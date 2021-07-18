package com.iclouding.mini.namenode;

/**
 * NameNode
 * NameNode
 * @author: iclouding
 * @date: 2021/7/15 23:44
 * @email: clouding.vip@qq.com
 */
public class NameNode {

    /**
     * 提供namesystem，管理核心元数据
     */
    private FSNamesystem namesystem;
    /**
     * 管理集群中所有的datanode
     */
    private DataNodeManager dataNodeManager;
    /**
     * 对外提供rpc调用
     */
    private NameNodeRpcServiceImpl rpcServer;

    /**
     * namenode 是否还在运行
     */
    private volatile boolean shouldRun;

    public NameNode() {
        this.shouldRun = true;
    }

    private void run() {
        try {
            while (shouldRun) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NameNode nameNode = new NameNode();
        nameNode.initialize();
        nameNode.run();
    }

    /**
     * 初始化NameNode
     */
    private void initialize() {
        namesystem = new FSNamesystem();
        dataNodeManager = new DataNodeManager();
        this.rpcServer = new NameNodeRpcServiceImpl(namesystem, dataNodeManager);
        rpcServer.start();
    }
}
