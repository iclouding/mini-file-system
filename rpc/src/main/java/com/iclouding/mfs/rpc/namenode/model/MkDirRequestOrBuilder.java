// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientNameNodeProtol.proto

package com.iclouding.mfs.rpc.namenode.model;

public interface MkDirRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.iclouding.mfs.rpc.namenode.MkDirRequest)
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
   * <code>optional bool createParent = 2;</code>
   */
  boolean getCreateParent();
}
