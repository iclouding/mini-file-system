package com.iclouding.mfs.namenode.protocolPB;

import com.iclouding.mfs.common.ResponseStatus;
import com.iclouding.mfs.namenode.datanode.DataNodeInfo;
import com.iclouding.mfs.namenode.FSNamesystem;

import com.iclouding.mfs.rpc.namenode.model.AllocationDataNodesRequest;
import com.iclouding.mfs.rpc.namenode.model.AllocationDataNodesResponse;
import com.iclouding.mfs.rpc.namenode.model.CreateFileRequest;
import com.iclouding.mfs.rpc.namenode.model.CreateFileResponse;
import com.iclouding.mfs.rpc.namenode.model.DataNodeInfoProto;
import com.iclouding.mfs.rpc.namenode.model.MkDirRequest;
import com.iclouding.mfs.rpc.namenode.model.MkDirResponse;
import com.iclouding.mfs.rpc.namenode.model.RenameDirRequest;
import com.iclouding.mfs.rpc.namenode.model.RenameDirResponse;
import com.iclouding.mfs.rpc.namenode.service.ClientNameNodeServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * ClientNameNodeService
 * 客户端和服务端通信协议
 * @author: iclouding
 * @date: 2021/7/31 16:01
 * @email: clouding.vip@qq.com
 */
public class ClientNameNodeService implements ClientNameNodeServiceGrpc.ClientNameNodeService {
    public static final Logger logger = LoggerFactory.getLogger(ClientNameNodeService.class);

    private FSNamesystem namesystem;

    private AtomicLong reNameCount = new AtomicLong(0);

    public ClientNameNodeService(FSNamesystem namesystem) {
        this.namesystem = namesystem;
    }

    @Override
    public void mkdir(MkDirRequest request, StreamObserver<MkDirResponse> responseObserver) {
        logger.info("收到创建文件请求，文件路径: {}", request.getPath());
        try {
            MkDirResponse mkDirResponse;
            boolean result = namesystem.mkdirs(request.getPath(), request.getCreateParent());
            if (result){
                mkDirResponse = MkDirResponse
                        .newBuilder()
                        .setPath(request.getPath())
                        .setStatus(ResponseStatus.SUCCESS.getStatus())
                        .build();

            }else {
                mkDirResponse = MkDirResponse
                        .newBuilder()
                        .setPath(request.getPath())
                        .setStatus(ResponseStatus.FAILURE.getStatus())
                        .setMessage("未知原因")
                        .build();
            }
            responseObserver.onNext(mkDirResponse);
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.info("创建目录异常: \n{}", ExceptionUtils.getStackTrace(e));
            responseObserver.onError(e);
        }
    }

    @Override
    public void createFile(CreateFileRequest request, StreamObserver<CreateFileResponse> responseObserver) {
        logger.info("收到创建文件请求，文件路径: {}", request.getPath());
        String path = request.getPath();
        boolean createParent = request.getCreateParent();
        int replication = request.getReplication();
        try {
            namesystem.createFile(path, createParent, replication);
            CreateFileResponse createFileResponse = CreateFileResponse.newBuilder()
                    .setPath(path)
                    .setStatus(ResponseStatus.SUCCESS.getStatus())
                    .build();
            responseObserver.onNext(createFileResponse);
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("创建文件异常，异常日志: {}", ExceptionUtils.getStackTrace(e));
            responseObserver.onError(e);
        }
    }

    @Override
    public void renamedirs(RenameDirRequest request, StreamObserver<RenameDirResponse> responseObserver) {
        logger.info("收到重命名文件夹请求，修改前文件路径: {}，修改后文件路径: {}", request.getSrcDir(), request.getDestDir());
        boolean result = false;
        try {
            namesystem.renamedir(request.getSrcDir(), request.getDestDir());
//            if (result){
//                mkDirResponse = MkDirResponse
//                        .newBuilder()
//                        .setPath(request.getPath())
//                        .setStatus(ResponseStatus.SUCCESS.getStatus())
//                        .build();
//
//            }else {
//                mkDirResponse = MkDirResponse
//                        .newBuilder()
//                        .setPath(request.getPath())
//                        .setStatus(ResponseStatus.FAILURE.getStatus())
//                        .setMessage("未知原因")
//                        .build();
//            }
        } catch (Exception e) {
            logger.info("创建目录异常: \n{}", ExceptionUtils.getStackTrace(e));
//            mkDirResponse = MkDirResponse
//                    .newBuilder()
//                    .setPath(request.getPath())
//                    .setStatus(ResponseStatus.FAILURE.getStatus())
//                    .setMessage(ExceptionUtils.getStackTrace(e))
//                    .build();
            responseObserver.onError(new Exception("aaaa"));
        }

//        responseObserver.onNext(mkDirResponse);

        responseObserver.onCompleted();
        logger.info("处理重命名文件夹({})请求完毕, 处理完毕的数量: {}", request.getDestDir(), reNameCount.incrementAndGet());
    }

    @Override
    public void allocationDataNodes(AllocationDataNodesRequest request,
                                    StreamObserver<AllocationDataNodesResponse> responseObserver) {
        String path = request.getPath();
        long fileSize = request.getFileSize();
        logger.info("收到获取文件存储节点请求, 路径: {}, 文件大小: {}", path, fileSize);
        List<DataNodeInfo> dataNodeInfos = namesystem.allocationDataNodes(path, fileSize);
        List<DataNodeInfoProto> dataNodeInfoProtos = dataNodeInfos.stream().map(dataNodeInfo -> {
            DataNodeInfoProto dataNodeInfoProto = DataNodeInfoProto
                    .newBuilder()
                    .setHostname(dataNodeInfo.getHostname())
                    .setIp(dataNodeInfo.getIp())
                    .setDataPort(dataNodeInfo.getDataPort())
                    .build();
            return dataNodeInfoProto;
        }).collect(Collectors.toList());
        AllocationDataNodesResponse allocationDataNodesResponse = AllocationDataNodesResponse
                .newBuilder()
                .addAllDataNodeInfos(dataNodeInfoProtos)
                .build();
        responseObserver.onNext(allocationDataNodesResponse);
        responseObserver.onCompleted();

    }
}
