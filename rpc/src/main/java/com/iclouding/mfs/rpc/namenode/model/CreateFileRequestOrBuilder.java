// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientNameNodeProtol.proto

package com.iclouding.mfs.rpc.namenode.model;

public interface CreateFileRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.iclouding.mfs.rpc.namenode.CreateFileRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string path = 1;</code>
   */
  java.lang.String getPath();
  /**
   * <code>optional string path = 1;</code>
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>optional bool create_parent = 2;</code>
   */
  boolean getCreateParent();

  /**
   * <code>optional uint32 replication = 3;</code>
   */
  int getReplication();
}
