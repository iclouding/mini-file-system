package com.iclouding.mfs.client;

import com.iclouding.mfs.client.socket.Sender;
import com.iclouding.mfs.common.ResponseStatus;
import com.iclouding.mfs.common.conf.Configuration;
import com.iclouding.mfs.common.util.FileUtil;
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
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * DFSClient
 * hdfs Client
 *
 * @author: iclouding
 * @date: 2021/7/31 16:19
 * @email: clouding.vip@qq.com
 */
public class DFSClient {

    private Configuration conf;

    private ClientNameNodeServiceGrpc.ClientNameNodeServiceBlockingStub namenode;

    // 默认的副本数，配置文件里没有的话，就取默认值2
    public static int DEFAULT_REPLICATION = 2;

    public DFSClient() {

    }

    public DFSClient(Configuration conf) {
        this.conf = conf;
        /**
         * TODO 配置文件获取
         */
        DEFAULT_REPLICATION = 2;
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 50010)
                .executor(Executors.newFixedThreadPool(20))
                .usePlaintext()
                .build();
        namenode = ClientNameNodeServiceGrpc.newBlockingStub(channel);
    }

    public boolean mkdirs(String path, boolean createParent) {
        MkDirRequest mkDirRequest = MkDirRequest
                .newBuilder()
                .setPath(path)
                .setCreateParent(createParent)
                .build();
        MkDirResponse mkDirResponse = namenode.mkdir(mkDirRequest);
        int status = mkDirResponse.getStatus();
        return status == ResponseStatus.SUCCESS.getStatus();
    }

    public boolean renamedirs(String srcFile, String destDir) {
        RenameDirRequest renameDirRequest = RenameDirRequest.newBuilder().setSrcDir(srcFile).setDestDir(destDir).build();
        RenameDirResponse renameDirResponse = namenode.renamedirs(renameDirRequest);
        return renameDirResponse.getStatus() == 0;
    }

    public boolean createFile(String path, boolean createParent) {
        return createFile(path, DEFAULT_REPLICATION, createParent);
    }

    private boolean createFile(String path, int replication, boolean createParent) {
        CreateFileRequest createRequest = CreateFileRequest
                .newBuilder()
                .setPath(path)
                .setCreateParent(createParent)
                .setReplication(replication)
                .build();
        CreateFileResponse createResponse = namenode.createFile(createRequest);
        return createResponse.getStatus() == ResponseStatus.SUCCESS.getStatus();
    }

    public void close() {
        ManagedChannel channel = (ManagedChannel) namenode.getChannel();
        try {
            if (!channel.isShutdown()) {
                channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<DataNodeInfoProto> allocationDataNodes(String filePath, long fileSize) {
        AllocationDataNodesRequest allocationDataNodesRequest = AllocationDataNodesRequest
                .newBuilder()
                .setPath(filePath)
                .setFileSize(fileSize)
                .build();
        AllocationDataNodesResponse dataNodesResponse = namenode.allocationDataNodes(
                allocationDataNodesRequest);
        return dataNodesResponse.getDataNodeInfosList();
    }

    /**
     * 通过NIO发送文件
     * @param oriPath
     * @param destPath
     * @param dataNodeInfoProtos
     */
    public void uploadFile(String oriPath, String destPath, List<DataNodeInfoProto> dataNodeInfoProtos)
            throws IOException {
        for (DataNodeInfoProto dataNodeInfoProto : dataNodeInfoProtos) {
            String ip = dataNodeInfoProto.getIp();
            int dataPort = dataNodeInfoProto.getDataPort();
            Sender sender = new Sender(ip, dataPort);
            byte[] fileBytes = FileUtil.getFileBytes(oriPath);
            sender.send(fileBytes, destPath);
        }
    }
}
