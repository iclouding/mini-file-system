package com.iclouding.mini.datanode;

import com.iclouding.mimi.namenode.rpc.model.HeartbeatRequest;
import com.iclouding.mimi.namenode.rpc.model.HeartbeatResponse;
import com.iclouding.mimi.namenode.rpc.model.RegisterRequest;
import com.iclouding.mimi.namenode.rpc.model.RegisterResponse;
import com.iclouding.mimi.namenode.rpc.service.NameNodeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.CountDownLatch;

/**
 * NameNodeServiceActor
 *
 * @author: iclouding
 * @date: 2021/7/15 23:48
 * @email: clouding.vip@qq.com
 */
public class NameNodeServiceActor {

    private NameNodeServiceGrpc.NameNodeServiceBlockingStub namenode;

    public NameNodeServiceActor() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 50070).build();
        namenode = NameNodeServiceGrpc.newBlockingStub(channel);
    }

    /**
     * 向负责通信的NameNode注册
     * @param latch
     */
    public void register(CountDownLatch latch) {
        RegisterThread registerThread = new RegisterThread(latch);
        HeartbeatThread heartbeatThread = new HeartbeatThread();
        registerThread.start();
        heartbeatThread.start();

    }

    /**
     * 注册线程
     */
    class RegisterThread extends Thread{
        CountDownLatch latch;

        public RegisterThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("发送请求注册");
            /**
             * 拿到 ip hostname 去namenode注册
             */
            String ip = "";
            String hostname = "127.0.0.1";
            RegisterRequest registerRequest = RegisterRequest
                    .newBuilder()
                    .setHostname(hostname)
                    .setIp(ip)
                    .build();
            RegisterResponse registerResponse = namenode.register(registerRequest);
            int status = registerResponse.getStatus();
            System.out.println("注册的结果: " + status);

            latch.countDown();
        }
    }


    /**
     * 心跳线程
     */
    class HeartbeatThread extends Thread{

        public HeartbeatThread(){

        }

        @Override
        public void run() {
            System.out.println("开始心跳");
            /**
             * 拿到 ip hostname 去namenode注册
             */
            String ip = "127.0.0.1";
            String hostname = "";
            HeartbeatRequest heartbeatRequest = HeartbeatRequest
                    .newBuilder()
                    .setHostname(hostname)
                    .setIp(ip)
                    .build();
            HeartbeatResponse heartbeatResponse = namenode.heartbeat(heartbeatRequest);
            int status = heartbeatResponse.getStatus();
            System.out.println("收到的心跳结果: " + status);

            try {
                Thread.sleep(3 * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
