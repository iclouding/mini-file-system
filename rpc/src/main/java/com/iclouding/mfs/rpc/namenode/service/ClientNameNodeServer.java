// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientNameNodeServer.proto

package com.iclouding.mfs.rpc.namenode.service;

public final class ClientNameNodeServer {
  private ClientNameNodeServer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032ClientNameNodeServer.proto\022\036com.icloud" +
      "ing.mfs.rpc.namenode\032\032ClientNameNodeProt" +
      "ol.proto2}\n\025ClientNameNodeService\022d\n\005mkd" +
      "ir\022,.com.iclouding.mfs.rpc.namenode.MkDi" +
      "rRequest\032-.com.iclouding.mfs.rpc.namenod" +
      "e.MkDirResponseB@\n&com.iclouding.mfs.rpc" +
      ".namenode.serviceB\024ClientNameNodeServerP" +
      "\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.iclouding.mfs.rpc.namenode.model.ClientNameNodeProtol.getDescriptor(),
        }, assigner);
    com.iclouding.mfs.rpc.namenode.model.ClientNameNodeProtol.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
