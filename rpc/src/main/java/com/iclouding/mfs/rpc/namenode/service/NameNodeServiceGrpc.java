package com.iclouding.mfs.rpc.namenode.service;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class NameNodeServiceGrpc {

  private NameNodeServiceGrpc() {}

  public static final String SERVICE_NAME = "com.iclouding.mfs.rpc.namenode.NameNodeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.iclouding.mfs.rpc.namenode.model.RegisterRequest,
      com.iclouding.mfs.rpc.namenode.model.RegisterResponse> METHOD_REGISTER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.iclouding.mfs.rpc.namenode.NameNodeService", "register"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.iclouding.mfs.rpc.namenode.model.RegisterRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.iclouding.mfs.rpc.namenode.model.RegisterResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest,
      com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse> METHOD_HEARTBEAT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.iclouding.mfs.rpc.namenode.NameNodeService", "heartbeat"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest,
      com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse> METHOD_INFORM_REPLICA_RECEIVED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.iclouding.mfs.rpc.namenode.NameNodeService", "informReplicaReceived"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse.getDefaultInstance()));

  public static NameNodeServiceStub newStub(io.grpc.Channel channel) {
    return new NameNodeServiceStub(channel);
  }

  public static NameNodeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NameNodeServiceBlockingStub(channel);
  }

  public static NameNodeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NameNodeServiceFutureStub(channel);
  }

  public static interface NameNodeService {

    public void register(com.iclouding.mfs.rpc.namenode.model.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.RegisterResponse> responseObserver);

    public void heartbeat(com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse> responseObserver);

    public void informReplicaReceived(com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest request,
        io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse> responseObserver);
  }

  public static interface NameNodeServiceBlockingClient {

    public com.iclouding.mfs.rpc.namenode.model.RegisterResponse register(com.iclouding.mfs.rpc.namenode.model.RegisterRequest request);

    public com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse heartbeat(com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest request);

    public com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse informReplicaReceived(com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest request);
  }

  public static interface NameNodeServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.iclouding.mfs.rpc.namenode.model.RegisterResponse> register(
        com.iclouding.mfs.rpc.namenode.model.RegisterRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse> heartbeat(
        com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse> informReplicaReceived(
        com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest request);
  }

  public static class NameNodeServiceStub extends io.grpc.stub.AbstractStub<NameNodeServiceStub>
      implements NameNodeService {
    private NameNodeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NameNodeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NameNodeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NameNodeServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void register(com.iclouding.mfs.rpc.namenode.model.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REGISTER, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void heartbeat(com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_HEARTBEAT, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void informReplicaReceived(com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest request,
        io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INFORM_REPLICA_RECEIVED, getCallOptions()), request, responseObserver);
    }
  }

  public static class NameNodeServiceBlockingStub extends io.grpc.stub.AbstractStub<NameNodeServiceBlockingStub>
      implements NameNodeServiceBlockingClient {
    private NameNodeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NameNodeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NameNodeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NameNodeServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.iclouding.mfs.rpc.namenode.model.RegisterResponse register(com.iclouding.mfs.rpc.namenode.model.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGISTER, getCallOptions(), request);
    }

    @java.lang.Override
    public com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse heartbeat(com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_HEARTBEAT, getCallOptions(), request);
    }

    @java.lang.Override
    public com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse informReplicaReceived(com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INFORM_REPLICA_RECEIVED, getCallOptions(), request);
    }
  }

  public static class NameNodeServiceFutureStub extends io.grpc.stub.AbstractStub<NameNodeServiceFutureStub>
      implements NameNodeServiceFutureClient {
    private NameNodeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NameNodeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NameNodeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NameNodeServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.iclouding.mfs.rpc.namenode.model.RegisterResponse> register(
        com.iclouding.mfs.rpc.namenode.model.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REGISTER, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse> heartbeat(
        com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_HEARTBEAT, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse> informReplicaReceived(
        com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INFORM_REPLICA_RECEIVED, getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_HEARTBEAT = 1;
  private static final int METHODID_INFORM_REPLICA_RECEIVED = 2;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NameNodeService serviceImpl;
    private final int methodId;

    public MethodHandlers(NameNodeService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((com.iclouding.mfs.rpc.namenode.model.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.RegisterResponse>) responseObserver);
          break;
        case METHODID_HEARTBEAT:
          serviceImpl.heartbeat((com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest) request,
              (io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse>) responseObserver);
          break;
        case METHODID_INFORM_REPLICA_RECEIVED:
          serviceImpl.informReplicaReceived((com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest) request,
              (io.grpc.stub.StreamObserver<com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final NameNodeService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
        .addMethod(
          METHOD_REGISTER,
          asyncUnaryCall(
            new MethodHandlers<
              com.iclouding.mfs.rpc.namenode.model.RegisterRequest,
              com.iclouding.mfs.rpc.namenode.model.RegisterResponse>(
                serviceImpl, METHODID_REGISTER)))
        .addMethod(
          METHOD_HEARTBEAT,
          asyncUnaryCall(
            new MethodHandlers<
              com.iclouding.mfs.rpc.namenode.model.HeartbeatRequest,
              com.iclouding.mfs.rpc.namenode.model.HeartbeatResponse>(
                serviceImpl, METHODID_HEARTBEAT)))
        .addMethod(
          METHOD_INFORM_REPLICA_RECEIVED,
          asyncUnaryCall(
            new MethodHandlers<
              com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedRequest,
              com.iclouding.mfs.rpc.namenode.model.InformReplicaReceivedResponse>(
                serviceImpl, METHODID_INFORM_REPLICA_RECEIVED)))
        .build();
  }
}
