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

package net.micode.notes.data;

import android.net.Uri;
public class Notes {
    //内容提供者的权限
    public static final String AUTHORITY = "micode_notes";
    public static final String TAG = "Notes";

    //笔记类型常量
    public static final int TYPE_NOTE     = 0;
    public static final int TYPE_FOLDER   = 1;
    public static final int TYPE_SYSTEM   = 2;

    /**
     * Following IDs are system folders' identifiers
     * {@link Notes#ID_ROOT_FOLDER } is default folder
     * {@link Notes#ID_TEMPARAY_FOLDER } is for notes belonging no folder
     * {@link Notes#ID_CALL_RECORD_FOLDER} is to store call records
     */
    public static final int ID_ROOT_FOLDER = 0;
    public static final int ID_TEMPARAY_FOLDER = -1;
    public static final int ID_CALL_RECORD_FOLDER = -2;
    public static final int ID_TRASH_FOLER = -3;

    //用于传递提醒日期的意图额外数据
    public static final String INTENT_EXTRA_ALERT_DATE = "net.micode.notes.alert_date";

    //用于传递背景ID的意图额外数据
    public static final String INTENT_EXTRA_BACKGROUND_ID = "net.micode.notes.background_color_id";

    //用于传递小部件ID的意图额外数据
    public static final String INTENT_EXTRA_WIDGET_ID = "net.micode.notes.widget_id";

    // 用于传递小部件类型的意图额外数据
    public static final String INTENT_EXTRA_WIDGET_TYPE = "net.micode.notes.widget_type";

    // 用于传递文件夹ID的意图额外数据
    public static final String INTENT_EXTRA_FOLDER_ID = "net.micode.notes.folder_id";

    // 用于传递通话日期的意图额外数据
    public static final String INTENT_EXTRA_CALL_DATE = "net.micode.notes.call_date";

    //小部件类型常量
    public static final int TYPE_WIDGET_INVALIDE      = -1;
    public static final int TYPE_WIDGET_2X            = 0;
    public static final int TYPE_WIDGET_4X            = 1;

    public static class DataConstants {
        public static final String NOTE = TextNote.CONTENT_ITEM_TYPE;
        public static final String CALL_NOTE = CallNote.CONTENT_ITEM_TYPE;
    }

    /**
     * Uri to query all notes and folders
     */
    //查询所有笔记和文件夹的URI
    public static final Uri CONTENT_NOTE_URI = Uri.parse("content://" + AUTHORITY + "/note");

    /**
     * Uri to query data
     */
    // 查询数据的URI
    public static final Uri CONTENT_DATA_URI = Uri.parse("content://" + AUTHORITY + "/data");

    public interface NoteColumns {
        /**
         * The unique ID for a row
         * <P> Type: INTEGER (long) </P>
         */
        // 行的唯一ID
        public static final String ID = "_id";

        /**
         * The parent's id for note or folder
         * <P> Type: INTEGER (long) </P>
         */
        // 笔记或文件夹的父ID
        public static final String PARENT_ID = "parent_id";

        /**
         * Created data for note or folder
         * <P> Type: INTEGER (long) </P>
         */
        // 创建日期
        public static final String CREATED_DATE = "created_date";

        /**
         * Latest modified date
         * <P> Type: INTEGER (long) </P>
         */
        // 最后修改日期
        public static final String MODIFIED_DATE = "modified_date";


        /**
         * Alert date
         * <P> Type: INTEGER (long) </P>
         */
        // 提醒日期
        public static final String ALERTED_DATE = "alert_date";

        /**
         * Folder's name or text content of note
         * <P> Type: TEXT </P>
         */
        // 文件夹的名称或笔记的文本内容
        public static final String SNIPPET = "snippet";

        /**
         * Note's widget id
         * <P> Type: INTEGER (long) </P>
         */
        // 笔记的小部件ID
        public static final String WIDGET_ID = "widget_id";

        /**
         * Note's widget type
         * <P> Type: INTEGER (long) </P>
         */
        // 笔记的小部件类型
        public static final String WIDGET_TYPE = "widget_type";

        /**
         * Note's background color's id
         * <P> Type: INTEGER (long) </P>
         */
        // 笔记的背景颜色ID
        public static final String BG_COLOR_ID = "bg_color_id";

        /**
         * For text note, it doesn't has attachment, for multi-media
         * note, it has at least one attachment
         * <P> Type: INTEGER </P>
         */
        // 文本笔记没有附件，多媒体笔记至少有一个附件
        public static final String HAS_ATTACHMENT = "has_attachment";

        /**
         * Folder's count of notes
         * <P> Type: INTEGER (long) </P>
         */
        // 文件夹中的笔记数量
        public static final String NOTES_COUNT = "notes_count";

        /**
         * The file type: folder or note
         * <P> Type: INTEGER </P>
         */
        // 文件类型：文件夹或笔记
        public static final String TYPE = "type";

        /**
         * The last sync id
         * <P> Type: INTEGER (long) </P>
         */
        // 最后同步ID
        public static final String SYNC_ID = "sync_id";

        /**
         * Sign to indicate local modified or not
         * <P> Type: INTEGER </P>
         */
        // 用于指示是否本地修改的标志
        public static final String LOCAL_MODIFIED = "local_modified";

        /**
         * Original parent id before moving into temporary folder
         * <P> Type : INTEGER </P>
         */
        // 移动到临时文件夹之前的原始父ID
        public static final String ORIGIN_PARENT_ID = "origin_parent_id";

        /**
         * The gtask id
         * <P> Type : TEXT </P>
         */
        // Gtask ID
        public static final String GTASK_ID = "gtask_id";

        /**
         * The version code
         * <P> Type : INTEGER (long) </P>
         */
        // 版本代码
        public static final String VERSION = "version";
    }

    public interface DataColumns {
        /**
         * The unique ID for a row
         * <P> Type: INTEGER (long) </P>
         */
        //行的唯一ID
        public static final String ID = "_id";

        /**
         * The MIME type of the item represented by this row.
         * <P> Type: Text </P>
         */
        // 该行所代表的项的MIME类型
        public static final String MIME_TYPE = "mime_type";

        /**
         * The reference id to note that this data belongs to
         * <P> Type: INTEGER (long) </P>
         */
        // 与此数据相关的笔记的引用ID
        public static final String NOTE_ID = "note_id";

        /**
         * Created data for note or folder
         * <P> Type: INTEGER (long) </P>
         */
        // 创建日期
        public static final String CREATED_DATE = "created_date";

        /**
         * Latest modified date
         * <P> Type: INTEGER (long) </P>
         */
        // 最后修改日期
        public static final String MODIFIED_DATE = "modified_date";

        /**
         * Data's content
         * <P> Type: TEXT </P>
         */
        // 数据的内容
        public static final String CONTENT = "content";


        /**
         * Generic data column, the meaning is {@link #MIMETYPE} specific, used for
         * integer data type
         * <P> Type: INTEGER </P>
         */
        // 通用数据列，其含义是特定于MIME类型，用于整数数据类型
        public static final String DATA1 = "data1";

        /**
         * Generic data column, the meaning is {@link #MIMETYPE} specific, used for
         * integer data type
         * <P> Type: INTEGER </P>
         */
        // 通用数据列，其含义是特定于MIME类型，用于整数数据类型
        public static final String DATA2 = "data2";

        /**
         * Generic data column, the meaning is {@link #MIMETYPE} specific, used for
         * TEXT data type
         * <P> Type: TEXT </P>
         */
        // 通用数据列，其含义是特定于MIME类型，用于文本数据类型
        public static final String DATA3 = "data3";

        /**
         * Generic data column, the meaning is {@link #MIMETYPE} specific, used for
         * TEXT data type
         * <P> Type: TEXT </P>
         */
        // 通用数据列，其含义是特定于MIME类型，用于文本数据类型
        public static final String DATA4 = "data4";

        /**
         * Generic data column, the meaning is {@link #MIMETYPE} specific, used for
         * TEXT data type
         * <P> Type: TEXT </P>
         */
        // 通用数据列，其含义是特定于MIME类型，用于文本数据类型
        public static final String DATA5 = "data5";
    }

    public static final class TextNote implements DataColumns {
        /**
         * Mode to indicate the text in check list mode or not
         * <P> Type: Integer 1:check list mode 0: normal mode </P>
         */
        // 表示文本是否处于检查列表模式的模式
        public static final String MODE = DATA1;

        public static final int MODE_CHECK_LIST = 1;

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/text_note";

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/text_note";

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/text_note");
    }

    public static final class CallNote implements DataColumns {
        /**
         * Call date for this record
         * <P> Type: INTEGER (long) </P>
         */
        public static final String CALL_DATE = DATA1;

        /**
         * Phone number for this record
         * <P> Type: TEXT </P>
         */
        // 此记录的通话日期
        public static final String PHONE_NUMBER = DATA3;

        // 此记录的电话号码
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/call_note";

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/call_note";

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/call_note");
    }
}
