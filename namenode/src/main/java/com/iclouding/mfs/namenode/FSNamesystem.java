package com.iclouding.mfs.namenode;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.iclouding.mfs.common.conf.Configuration;
import com.iclouding.mfs.common.util.FileUtil;
import com.iclouding.mfs.namenode.datanode.DataNodeInfo;
import com.iclouding.mfs.namenode.datanode.DataNodeManager;
import com.iclouding.mfs.namenode.dir.FSDirectory;
import com.iclouding.mfs.namenode.dir.DirectoryINode;
import com.iclouding.mfs.namenode.dir.FileINode;
import com.iclouding.mfs.namenode.log.FSEditLog;
import com.iclouding.mfs.namenode.log.FSImage;
import com.iclouding.mfs.namenode.log.FetchEditLogsInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FSNamesystem
 *
 * @author: iclouding
 * @date: 2021/7/16 0:03
 * @email: clouding.vip@qq.com
 */
public class FSNamesystem {

    private static final Logger logger = LoggerFactory.getLogger(FSNamesystem.class);

    private FSDirectory fsDirectory;

    private DataNodeManager dataNodeManager;

    public FSNamesystem(DataNodeManager dataNodeManager, Configuration conf) {
        this.dataNodeManager = dataNodeManager;
        fsDirectory = new FSDirectory();
    }

    /**
     * 从磁盘加载 fsimage和editlog
     * @param conf
     */
    public void loadFromDisk(Configuration conf) {
        String fsImageDir = "./namenode/fsimage/";
        File dir = new File(fsImageDir);
        String[] fsimages = dir.list((dir1, name) -> name.startsWith("fsimage"));
        if (fsimages == null || fsimages.length == 0){
            // 没有fsimage
            return;
        }
        String maxFsImageFile = Arrays.stream(fsimages).max(String::compareTo).get();
        List<String> fileData = FileUtil.getFileData(maxFsImageFile);
        if (CollectionUtils.isEmpty(fileData)){
            logger.error("{}文件数据为空", maxFsImageFile);
            return;
        }

        FSImage fsImage = JSON.parseObject(StringUtils.join(fileData), FSImage.class);
        String fsimageStr = fsImage.getFsimageStr();
        // 恢复fsimage到内存中
        fsDirectory.recoverFromFSImage(fsimageStr);

        long lastTxidInFSImage = fsImage.getLastTxid();
        String[] editlogs = dir.list((dir1, name) -> name.startsWith("editlog"));

        long lastTxidInEditLogs = lastTxidInFSImage;
        Map<Long, String> startTxid2FileNameMap = new HashMap<>();
        for (String editlog : editlogs) {
            //
            Splitter splitter = Splitter.on("-").omitEmptyStrings().trimResults();
            List<String> split = splitter.splitToList(editlog);
            Long startTxid = Long.valueOf(split.get(1));
            Long endTxid = Long.valueOf(split.get(2));
            if (endTxid < lastTxidInFSImage){
                continue;
            }
            lastTxidInEditLogs = Math.max(lastTxidInEditLogs, endTxid);
            startTxid2FileNameMap.put(startTxid, editlog);
        }
        getEditLog().recoverFromEditLogs(lastTxidInEditLogs, startTxid2FileNameMap);

    }

    private FSEditLog getEditLog() {
        return fsDirectory.getEditLog();
    }

    public boolean mkdirs(String path, boolean createParent) throws Exception {
        DirectoryINode directoryINode = fsDirectory.mkdirs(path, createParent);
        return true;
    }

    public boolean renamedir(String srcdir, String desdir) throws Exception {
        DirectoryINode directoryINode = fsDirectory.renamedir(srcdir, desdir);

//        MkDirEditLogOp mkDirEditLogOp = new MkDirEditLogOp(path, create_parent,directoryINode.getCreateTime(), directoryINode.getUpdateTime());
//        editLog.logEdit(mkDirEditLogOp);

        return true;
    }

    public FetchEditLogsInfo fetchEditLogs(long beginTxid, int fetchSize) {
        FetchEditLogsInfo fetchEditLogsInfo = getEditLog().fetchEditLogs(beginTxid, fetchSize);
        return fetchEditLogsInfo;
    }

    public boolean createFile(String path, boolean createParent, int replication){
        FileINode file = fsDirectory.create(path, createParent, replication);
        return true;
    }

    public List<DataNodeInfo> allocationDataNodes(String filePath, long fileSize) {
        List<DataNodeInfo> dataNodeInfos = dataNodeManager.allocateDataNodes(fileSize, 2);
        return dataNodeInfos;
    }
}
