// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StandByNameNodeProtol.proto

package com.iclouding.mfs.rpc.namenode.model;

public interface FetchEditLogResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.iclouding.mfs.rpc.namenode.FetchEditLogResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 status = 1;</code>
   */
  int getStatus();

  /**
   * <code>optional int64 begin_txid = 2;</code>
   */
  long getBeginTxid();

  /**
   * <pre>
   * 存放editlogs的
   * </pre>
   *
   * <code>repeated string edit_logs = 3;</code>
   */
  java.util.List<java.lang.String>
      getEditLogsList();
  /**
   * <pre>
   * 存放editlogs的
   * </pre>
   *
   * <code>repeated string edit_logs = 3;</code>
   */
  int getEditLogsCount();
  /**
   * <pre>
   * 存放editlogs的
   * </pre>
   *
   * <code>repeated string edit_logs = 3;</code>
   */
  java.lang.String getEditLogs(int index);
  /**
   * <pre>
   * 存放editlogs的
   * </pre>
   *
   * <code>repeated string edit_logs = 3;</code>
   */
  com.google.protobuf.ByteString
      getEditLogsBytes(int index);

  /**
   * <pre>
   * 获取editlog的数量
   * </pre>
   *
   * <code>optional int32 fetch_size = 4;</code>
   */
  int getFetchSize();

  /**
   * <pre>
   * 是否还有后续editlog
   * </pre>
   *
   * <code>optional bool has_more = 5;</code>
   */
  boolean getHasMore();

  /**
   * <pre>
   * 异常时提示消息
   * </pre>
   *
   * <code>optional string message = 6;</code>
   */
  java.lang.String getMessage();
  /**
   * <pre>
   * 异常时提示消息
   * </pre>
   *
   * <code>optional string message = 6;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}
