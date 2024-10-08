// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientNameNodeProtol.proto

package com.iclouding.mfs.rpc.namenode.model;

/**
 * Protobuf type {@code com.iclouding.mfs.rpc.namenode.CreateFileRequest}
 */
public  final class CreateFileRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.iclouding.mfs.rpc.namenode.CreateFileRequest)
    CreateFileRequestOrBuilder {
  // Use CreateFileRequest.newBuilder() to construct.
  private CreateFileRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateFileRequest() {
    path_ = "";
    createParent_ = false;
    replication_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private CreateFileRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            path_ = s;
            break;
          }
          case 16: {

            createParent_ = input.readBool();
            break;
          }
          case 24: {

            replication_ = input.readUInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.iclouding.mfs.rpc.namenode.model.ClientNameNodeProtol.internal_static_com_iclouding_mfs_rpc_namenode_CreateFileRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.iclouding.mfs.rpc.namenode.model.ClientNameNodeProtol.internal_static_com_iclouding_mfs_rpc_namenode_CreateFileRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.iclouding.mfs.rpc.namenode.model.CreateFileRequest.class, com.iclouding.mfs.rpc.namenode.model.CreateFileRequest.Builder.class);
  }

  public static final int PATH_FIELD_NUMBER = 1;
  private volatile java.lang.Object path_;
  /**
   * <code>optional string path = 1;</code>
   */
  public java.lang.String getPath() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      path_ = s;
      return s;
    }
  }
  /**
   * <code>optional string path = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPathBytes() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      path_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CREATE_PARENT_FIELD_NUMBER = 2;
  private boolean createParent_;
  /**
   * <code>optional bool create_parent = 2;</code>
   */
  public boolean getCreateParent() {
    return createParent_;
  }

  public static final int REPLICATION_FIELD_NUMBER = 3;
  private int replication_;
  /**
   * <code>optional uint32 replication = 3;</code>
   */
  public int getReplication() {
    return replication_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getPathBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, path_);
    }
    if (createParent_ != false) {
      output.writeBool(2, createParent_);
    }
    if (replication_ != 0) {
      output.writeUInt32(3, replication_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPathBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, path_);
    }
    if (createParent_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, createParent_);
    }
    if (replication_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, replication_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.iclouding.mfs.rpc.namenode.model.CreateFileRequest)) {
      return super.equals(obj);
    }
    com.iclouding.mfs.rpc.namenode.model.CreateFileRequest other = (com.iclouding.mfs.rpc.namenode.model.CreateFileRequest) obj;

    boolean result = true;
    result = result && getPath()
        .equals(other.getPath());
    result = result && (getCreateParent()
        == other.getCreateParent());
    result = result && (getReplication()
        == other.getReplication());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + PATH_FIELD_NUMBER;
    hash = (53 * hash) + getPath().hashCode();
    hash = (37 * hash) + CREATE_PARENT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getCreateParent());
    hash = (37 * hash) + REPLICATION_FIELD_NUMBER;
    hash = (53 * hash) + getReplication();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.iclouding.mfs.rpc.namenode.model.CreateFileRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.iclouding.mfs.rpc.namenode.CreateFileRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.iclouding.mfs.rpc.namenode.CreateFileRequest)
      com.iclouding.mfs.rpc.namenode.model.CreateFileRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.iclouding.mfs.rpc.namenode.model.ClientNameNodeProtol.internal_static_com_iclouding_mfs_rpc_namenode_CreateFileRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.iclouding.mfs.rpc.namenode.model.ClientNameNodeProtol.internal_static_com_iclouding_mfs_rpc_namenode_CreateFileRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.iclouding.mfs.rpc.namenode.model.CreateFileRequest.class, com.iclouding.mfs.rpc.namenode.model.CreateFileRequest.Builder.class);
    }

    // Construct using com.iclouding.mfs.rpc.namenode.model.CreateFileRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      path_ = "";

      createParent_ = false;

      replication_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.iclouding.mfs.rpc.namenode.model.ClientNameNodeProtol.internal_static_com_iclouding_mfs_rpc_namenode_CreateFileRequest_descriptor;
    }

    public com.iclouding.mfs.rpc.namenode.model.CreateFileRequest getDefaultInstanceForType() {
      return com.iclouding.mfs.rpc.namenode.model.CreateFileRequest.getDefaultInstance();
    }

    public com.iclouding.mfs.rpc.namenode.model.CreateFileRequest build() {
      com.iclouding.mfs.rpc.namenode.model.CreateFileRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.iclouding.mfs.rpc.namenode.model.CreateFileRequest buildPartial() {
      com.iclouding.mfs.rpc.namenode.model.CreateFileRequest result = new com.iclouding.mfs.rpc.namenode.model.CreateFileRequest(this);
      result.path_ = path_;
      result.createParent_ = createParent_;
      result.replication_ = replication_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.iclouding.mfs.rpc.namenode.model.CreateFileRequest) {
        return mergeFrom((com.iclouding.mfs.rpc.namenode.model.CreateFileRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.iclouding.mfs.rpc.namenode.model.CreateFileRequest other) {
      if (other == com.iclouding.mfs.rpc.namenode.model.CreateFileRequest.getDefaultInstance()) return this;
      if (!other.getPath().isEmpty()) {
        path_ = other.path_;
        onChanged();
      }
      if (other.getCreateParent() != false) {
        setCreateParent(other.getCreateParent());
      }
      if (other.getReplication() != 0) {
        setReplication(other.getReplication());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.iclouding.mfs.rpc.namenode.model.CreateFileRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.iclouding.mfs.rpc.namenode.model.CreateFileRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object path_ = "";
    /**
     * <code>optional string path = 1;</code>
     */
    public java.lang.String getPath() {
      java.lang.Object ref = path_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        path_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string path = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPathBytes() {
      java.lang.Object ref = path_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        path_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string path = 1;</code>
     */
    public Builder setPath(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      path_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string path = 1;</code>
     */
    public Builder clearPath() {
      
      path_ = getDefaultInstance().getPath();
      onChanged();
      return this;
    }
    /**
     * <code>optional string path = 1;</code>
     */
    public Builder setPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      path_ = value;
      onChanged();
      return this;
    }

    private boolean createParent_ ;
    /**
     * <code>optional bool create_parent = 2;</code>
     */
    public boolean getCreateParent() {
      return createParent_;
    }
    /**
     * <code>optional bool create_parent = 2;</code>
     */
    public Builder setCreateParent(boolean value) {
      
      createParent_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool create_parent = 2;</code>
     */
    public Builder clearCreateParent() {
      
      createParent_ = false;
      onChanged();
      return this;
    }

    private int replication_ ;
    /**
     * <code>optional uint32 replication = 3;</code>
     */
    public int getReplication() {
      return replication_;
    }
    /**
     * <code>optional uint32 replication = 3;</code>
     */
    public Builder setReplication(int value) {
      
      replication_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint32 replication = 3;</code>
     */
    public Builder clearReplication() {
      
      replication_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.iclouding.mfs.rpc.namenode.CreateFileRequest)
  }

  // @@protoc_insertion_point(class_scope:com.iclouding.mfs.rpc.namenode.CreateFileRequest)
  private static final com.iclouding.mfs.rpc.namenode.model.CreateFileRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.iclouding.mfs.rpc.namenode.model.CreateFileRequest();
  }

  public static com.iclouding.mfs.rpc.namenode.model.CreateFileRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateFileRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateFileRequest>() {
    public CreateFileRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CreateFileRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateFileRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateFileRequest> getParserForType() {
    return PARSER;
  }

  public com.iclouding.mfs.rpc.namenode.model.CreateFileRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

