/*
 * Copyright (c) 2010-2011, The MiCode Open Source Community (www.micode.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.micode.notes.gtask.data;

import android.database.Cursor;

import org.json.JSONObject;

public abstract class Node {
    public static final int SYNC_ACTION_NONE = 0;

    public static final int SYNC_ACTION_ADD_REMOTE = 1;

    public static final int SYNC_ACTION_ADD_LOCAL = 2;

    public static final int SYNC_ACTION_DEL_REMOTE = 3;

    public static final int SYNC_ACTION_DEL_LOCAL = 4;

    public static final int SYNC_ACTION_UPDATE_REMOTE = 5;

    public static final int SYNC_ACTION_UPDATE_LOCAL = 6;

    public static final int SYNC_ACTION_UPDATE_CONFLICT = 7;

    public static final int SYNC_ACTION_ERROR = 8;

    // 全局唯一标识符
    private String mGid;

    // 节点名称
    private String mName;

    // 最后修改时间
    private long mLastModified;

    // 是否已删除
    private boolean mDeleted;

    public Node() {
        mGid = null;
        mName = "";
        mLastModified = 0;
        mDeleted = false;
    }

    // 获取用于创建操作的 JSON 对象
    public abstract JSONObject getCreateAction(int actionId);

    // 获取用于更新操作的 JSON 对象
    public abstract JSONObject getUpdateAction(int actionId);

    // 从远程 JSON 数据中解析内容
    public abstract void setContentByRemoteJSON(JSONObject js);

    // 从本地 JSON 数据中解析内容
    public abstract void setContentByLocalJSON(JSONObject js);

    // 获取本地 JSON 数据从内容
    public abstract JSONObject getLocalJSONFromContent();

    // 获取同步操作类型
    public abstract int getSyncAction(Cursor c);

    // 设置全局唯一标识符
    public void setGid(String gid) {
        this.mGid = gid;
    }

    // 设置节点名称
    public void setName(String name) {
        this.mName = name;
    }

    // 设置最后修改时间
    public void setLastModified(long lastModified) {
        this.mLastModified = lastModified;
    }

    // 设置是否已删除
    public void setDeleted(boolean deleted) {
        this.mDeleted = deleted;
    }

    // 获取全局唯一标识符
    public String getGid() {
        return this.mGid;
    }

    // 获取节点名称
    public String getName() {
        return this.mName;
    }

    // 获取最后修改时间
    public long getLastModified() {
        return this.mLastModified;
    }

    // 获取是否已删除
    public boolean getDeleted() {
        return this.mDeleted;
    }

}
