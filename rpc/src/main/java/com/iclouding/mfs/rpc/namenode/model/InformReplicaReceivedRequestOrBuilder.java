// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: NameNodeRpcModel.proto

package com.iclouding.mfs.rpc.namenode.model;

public interface InformReplicaReceivedRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.iclouding.mfs.rpc.namenode.InformReplicaReceivedRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string file_path = 1;</code>
   */
  java.lang.String getFilePath();
  /**
   * <code>optional string file_path = 1;</code>
   */
  com.google.protobuf.ByteString
      getFilePathBytes();

  /**
   * <code>optional .com.iclouding.mfs.rpc.namenode.DataNodeInfoProto dataNodeInfo = 2;</code>
   */
  boolean hasDataNodeInfo();
  /**
   * <code>optional .com.iclouding.mfs.rpc.namenode.DataNodeInfoProto dataNodeInfo = 2;</code>
   */
  com.iclouding.mfs.rpc.namenode.model.DataNodeInfoProto getDataNodeInfo();
  /**
   * <code>optional .com.iclouding.mfs.rpc.namenode.DataNodeInfoProto dataNodeInfo = 2;</code>
   */
  com.iclouding.mfs.rpc.namenode.model.DataNodeInfoProtoOrBuilder getDataNodeInfoOrBuilder();
}
