package com.iclouding.mfs.namenode.rpc;

import com.iclouding.mfs.namenode.datanode.DataNodeInfo;
import com.iclouding.mfs.namenode.datanode.DataNodeManager;
import com.iclouding.mfs.namenode.FSNamesystem;
import com.iclouding.mfs.rpc.namenode.model.DataNodeInfoProto;
import com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest;
import com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse;
import com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest;
import com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse;
import com.iclouding.mfs.rpc.namenode.model.RegisterRequest;
import com.iclouding.mfs.rpc.namenode.model.RegisterResponse;
import com.iclouding.mfs.rpc.namenode.service.NameNodeServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NameNodeRpcServiceImpl
 * NameNodeRpcServiceImpl
 * @author: iclouding
 * @date: 2021/7/15 23:44
 * @email: clouding.vip@qq.com
 */
public class NameNodeRpcServiceImpl implements NameNodeServiceGrpc.NameNodeService {

    public static final Logger logger = LoggerFactory.getLogger(NameNodeRpcServiceImpl.class);

    private static final int STATUS_SUCCESS = 1;

    private static final int STATUS_FAILURE = 2;

    private FSNamesystem namesystem;

    private DataNodeManager dataNodeManager;

    public NameNodeRpcServiceImpl(FSNamesystem namesystem, DataNodeManager dataNodeManager) {
        this.namesystem = namesystem;
        this.dataNodeManager = dataNodeManager;
    }

    @Override
    public void register(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {
        DataNodeInfoProto dataNodeInfoProto = request.getDataNodeInfo();
        dataNodeManager.register(DataNodeInfo.getByDataNodeInfoProto(dataNodeInfoProto));

        // 封装返回值
        RegisterResponse response = RegisterResponse
                .newBuilder()
                .setStatus(STATUS_SUCCESS)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void heartbeat(HeartbeatRequest request, StreamObserver<HeartbeatResponse> responseObserver) {
        dataNodeManager.heartbeat(request.getIp(), request.getHostname());
        HeartbeatResponse heartbeatResponse = HeartbeatResponse
                .newBuilder()
                .setStatus(STATUS_SUCCESS)
                .build();
        responseObserver.onNext(heartbeatResponse);
        responseObserver.onCompleted();

    }

    @Override
    public void informReplicaReceived(InformReplicaReceivedRequest request,
                                      StreamObserver<InformReplicaReceivedResponse> responseObserver) {
        DataNodeInfoProto dataNodeInfoProto = request.getDataNodeInfo();
        String filePath = request.getFilePath();
        DataNodeInfo dataNodeInfo = DataNodeInfo.getByDataNodeInfoProto(dataNodeInfoProto);
        namesystem.informReplicaReceived(filePath, dataNodeInfo);

    }
}
