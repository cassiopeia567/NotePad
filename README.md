# NotePad-Android应用的介绍文档

## 一.应用的使用

### 1.笔记主界面介绍

（1）点击软件之后进入主界面


![img.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img.png)


（2）图中红框标的为搜索按钮，点击进入搜索界面（**搜索界面详情见2**）


![img_1.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_1.png)


（3）图中红框为统计功能，能够统计笔记数量


![img_2.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_2.png


（4）图中红框为分类栏，最左边的小图标点击可进入笔记本界面（**笔记本详情见3**），右侧展示的是存在的笔记本，点击可展示该笔记本下的所有笔记，用于分类


![img_3.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_3.png)


（5）图中红框为笔记列表，用于展示笔记


![img_4.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_4.png)


![img_15.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_15.png)


（6）图中红框新增按钮或点击笔记可进入笔记编辑界面（**笔记编辑界面见4**）


![img_5.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_5.png)


（7）主界面长按笔记项可移动笔记至其他笔记本


![img_17.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_17.png)


![img_18.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_18.png)


![img_19.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_19.png)


![img_20.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_20.png)


### 2.搜索界面介绍

（1）进入搜索界面

![img_6.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_6.png)


（2）搜索界面红框为搜索栏，输入搜索条件可搜索符合的笔记，可展示搜索到了几条数据


![img_7.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_7.png)


![img_16.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_16.png)


（3）搜索界面红框为取消按钮，点击可退出搜索界面


![img_8.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_8.png)


### 3.笔记本界面介绍

（1）进入笔记本界面


![img_22.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_22.png)


（2）笔记本界面红框为新建，点击新建笔记本


![img_23.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_23.png)


![img_24.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_24.png)


（3）笔记本界面红框为展示已有笔记本


![img_25.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_25.png)


（4）笔记本界面长按笔记本可删除笔记本，该笔记本下的所有笔记将移至默认笔记本


![img_26.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_26.png)


![img_27.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_27.png)


### 4.笔记编辑界面介绍


（1）进入笔记编辑界面


![img_9.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_9.png)


（2）笔记编辑界面红框为返回，点击可返回笔记主界面


![img_10.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_10.png)


（3）笔记编辑界面红框为保存，点击可保存内容


![img_11.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_11.png)


（4）笔记编辑界面红框为笔记信息，左边为时间，右边为笔记本类别


![img_12.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_12.png)


（5）笔记编辑界面红框为笔记标题文本栏，点击可编辑笔记标题


![img_13.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_13.png)


（6）笔记编辑界面红框为笔记内容文本栏，点击可编辑笔记内容


![img_14.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_14.png)


## 二.应用的代码实现


### （一）.笔记条目增加时间戳显示


#### 1.功能要求


每个新建笔记都会保存新建时间并显示


#### 2.实现思路和技术实现


(1)初始应用的笔记列表`item`只有一个标题，需要再添加一个`TextView`用来显示时间，布局使用 `LinearLayout`


```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    >

    <TextView
        android:id="@android:id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textColor="@android:color/white"
        android:ellipsize="end"/>

    <TextView
        android:id="@+id/note_date"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        />
</LinearLayout>
```



(2)`PROJECTION`变量用来定义Java文件定义的`Activity`的数据，所以在`PROJECTION`中加入创建时间作为显示在笔记列表的时间

```
    /**
     * The columns needed by the cursor adapter
     */
    private static final String[] PROJECTION = new String[] {
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_TITLE, // 1
            NotePad.Notes.COLUMN_NAME_CREATE_DATE,
            NotePad.Notes.COLUMN_NAME_CATEGORY
    };
private static final String[] PROJECTION = new String[] {
        NotePad.Notes._ID, // 0
        NotePad.Notes.COLUMN_NAME_TITLE, // 1
        NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE
};
```



(3)笔记条目数据通过`SimpleCursorAdapter`装填，其中用到的`dataColumns`，`viewIDs`变量需要添加时间

```
    private String[] dataColumns = { NotePad.Notes.COLUMN_NAME_TITLE,NotePad.Notes.COLUMN_NAME_CREATE_DATE } ;
    private int[] viewIDs = { android.R.id.text1,R.id.itemdate };
```



(4)对显示的时间戳（`now`变量）进行转换，在NoteEdit.java中初始化视图方法采用SimpleDateFormat来格式化时间

```
 private void initViews() {
        // 绑定控件
        mTitleText = findViewById(R.id.et_title);
        mContentText = findViewById(R.id.et_content);
        categoryView = findViewById(R.id.tv_category);
        TextView timeView = findViewById(R.id.tv_time);
        ImageButton backButton = findViewById(R.id.button_back);
        ImageButton finishButton = findViewById(R.id.button_finish);

        // 设置当前时间
        timeView.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));

        // finish按钮：保存但不退出，编辑框失焦
        finishButton.setOnClickListener(v -> {
            saveNote(); // 保存内容
            loseFocus(); // 编辑框失去焦点
            hideKeyboard(); // 隐藏键盘
            Toast.makeText(this, "已保存", Toast.LENGTH_SHORT).show();
        });

        // 返回按钮：判断是否保存
        backButton.setOnClickListener(v -> handleBackPress());
    }
```



#### 3.实现效果界面截图

(1)创建笔记时显示创建时间

### （二）.笔记查询功能（按标题查询）

#### 1.功能要求

点击搜索按钮进入搜索界面，搜索界面中输入条件搜索笔记

#### 2.实现思路和技术实现

(1)在list_options_menu新增菜单搜索按钮

```
   <item android:id="@+id/menu_search"
        android:icon="@drawable/search_icon"
        android:title="@string/menu_search"
        android:alphabeticShortcut='a'
        android:showAsAction="ifRoom"
        tools:ignore="AppCompatResource" />
```

(2)在NotesList中的onOptionsItemSelected对menu_search进行监听，点击时跳转至搜索界面

```
  Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
            return true;
```

(3)新增searchactivity，设置搜索栏文本监听

```
private void setSearchAdaoter(){
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextChange(String newText) {
            Cursor cursor = queryNotesByTitle(newText);
            searchNotes(cursor);
            SimpleCursorAdapter adapter
                    = new SimpleCursorAdapter(
                    getApplicationContext(),                         
                    R.layout.noteslist_item,         
                    cursor,                         
                    dataColumns,
                    viewIDs
            );
            setListAdapter(adapter);
            return true;
        }
        @Override
        public boolean onQueryTextSubmit(String query) {
            Cursor cursor = queryNotesByTitle(query);
            searchNotes(cursor);
            SimpleCursorAdapter adapter
                    = new SimpleCursorAdapter(
                    getApplicationContext(),
                    R.layout.noteslist_item,         
                    cursor,                         
                    dataColumns,
                    viewIDs
            );
            setListAdapter(adapter);
            return true;
        }
    });
}
```

(4)在searchactivity新增查询按标题查询方法

```
private Cursor queryNotesByTitle(String keyword) {
    if (keyword == null || keyword.trim().isEmpty()) {
        return null;
    }
    String selection = null;
    String[] selectionArgs = null;

    if (keyword != null && !keyword.trim().isEmpty()) {

        selection = NotePad.Notes.SELECTION_TITLE_LIKE;
        selectionArgs = new String[]{"%" + keyword.trim() + "%"};
    }

    return getContentResolver().query(
            NotePad.Notes.CONTENT_URI,
            PROJECTION,
            selection,
            selectionArgs,
            NotePad.Notes.DEFAULT_SORT_ORDER
    );
}
```

(4)在searchactivity新增更新搜索到的笔记文本数量方法

```
private void searchNotes( Cursor cursor) {

    // 2. 处理搜索结果
    if (cursor == null) {
        // 关键词为空时：隐藏列表和计数
        text_result.setVisibility(View.GONE);
        return;
    }

    // 3. 获取数据数量并更新计数文本
    int count = cursor.getCount();
    if (count > 0) {
        // 有数据：显示列表和计数
        text_count.setText("已找到 " + count + " 条数据");
        text_result.setVisibility(View.VISIBLE);
    } else {
        // 无数据：隐藏列表，显示计数（0条）
        text_count.setText("已找到 0 条数据");
        text_result.setVisibility(View.VISIBLE);
    }
}
```

#### 3.实现效果界面截图


![img_21.png](%E5%BA%94%E7%94%A8%E6%88%AA%E5%9B%BE/img_21.png)


**见搜索界面介绍**

## 四.拓展附加功能

### （一）.UI美化

#### 1.功能要求

美化ui，提升用户体验

#### 2.实现思路和技术实现

(1）定义的颜色可复用

```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#3F51B5</color> <!-- 示例主色调 -->
    <color name="custom_dark_gray">#333333</color> <!-- 之前定义的深灰色 -->
</resources>
```

(2）定义的actionbar风格

```
<?xml version="1.0" encoding="utf-8"?>
<!-- 如果有 styles.xml 文件，添加或修改以下内容 -->
<resources>
    <!-- Base application theme -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- 修改 ActionBar 高度 -->
        <item name="actionBarSize">48dp</item> <!-- 默认是 56dp，可以调整为 48dp 或更小 -->
        <item name="actionBarStyle">@style/MyActionBar</item>
    </style>

    <!-- 自定义 ActionBar 样式 -->
    <style name="MyActionBar" parent="@style/Widget.AppCompat.ActionBar.Solid">
        <!-- 设置最小高度 -->
        <item name="height">48dp</item>
        <item name="minHeight">48dp</item>
    </style>

    <style name="NoteEditorTheme" parent="android:Theme.Holo.Light.DarkActionBar">
        <!-- ActionBar 背景色设为黑色 -->
        <item name="android:actionBarStyle">@style/NoteActionBar</item>
        <!-- 菜单图标颜色设为白色 -->
        <item name="android:textColorPrimary">@android:color/white</item>
    </style>

    <!-- 自定义 ActionBar 样式 -->
    <style name="NoteActionBar" parent="android:Widget.Holo.ActionBar">
        <item name="android:background">@android:color/black</item>  <!-- 黑色背景 -->
        <item name="android:titleTextStyle">
        </item>
    </style>
</resources>
```

(3）美化笔记主界面

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:fitsSystemWindows="true"
    android:orientation="vertical"
    android:layout_height="match_parent"
    android:background="#121212"
    tools:context=".NotesList">
    <LinearLayout
        android:id="@+id/linearLayout3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:paddingLeft="16dp"
        android:background="#1A1B20"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">
        <TextView
            android:id="@+id/text_counts"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="0篇笔记"
            android:textColor="#aaaaaa"
            android:textSize="14sp" />
    </LinearLayout>
    <LinearLayout
        android:id="@+id/linearLayout123"
        android:layout_width="match_parent"
        app:layout_constraintBottom_toTopOf="@+id/linearLayout4"
        app:layout_constraintTop_toBottomOf="@+id/linearLayout3"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintVertical_bias="0.045"
        app:layout_constraintHorizontal_bias="1.0"
        android:orientation="horizontal"
        android:background="#1e1e1e"
        android:gravity="center_vertical"
        app:layout_constraintStart_toStartOf="parent"
        android:layout_height="50dp">
        <ImageButton
            android:id="@+id/btn_add_category"
            android:layout_width="36dp"
            android:layout_height="36dp"
            android:src="@drawable/notebook"
            android:scaleType="centerInside"
            android:background="#1e1e1e"
            android:layout_marginLeft="16dp"/>
        <HorizontalScrollView
            android:layout_weight="1"
            android:layout_gravity="center_vertical"
            android:id="@+id/horizontalScrollView"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:paddingVertical="8dp"
            android:paddingLeft="16dp"
            android:paddingRight="16dp"
            android:scrollbars="none"
            >
            <LinearLayout
                android:id="@+id/categoryContainer"
                android:layout_width="wrap_content"
                android:layout_gravity="center_vertical"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:gravity="center_vertical">
            </LinearLayout>
        </HorizontalScrollView>
    </LinearLayout>
    <LinearLayout
        android:id="@+id/linearLayout4"
        android:layout_width="match_parent"
        android:layout_marginTop="20px"
        android:layout_height="0dp"
        android:layout_marginHorizontal="16dp"
        android:background="@drawable/noteslist_item_backgroud_border"
        android:orientation="vertical"
        android:padding="5px"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/linearLayout123">
        <ListView
            android:id="@android:id/list"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:dividerHeight="3dp" >
        </ListView>
    </LinearLayout>
    <Button
        android:id="@+id/btn_add_note"
        android:layout_width="46dp"
        android:layout_height="46dp"
        android:text="+"
        android:textColor="@android:color/white"
        android:gravity="center_horizontal"
        android:textSize="32sp"
        android:background="@drawable/circle_background"
        android:contentDescription="@string/menu_add"
        android:elevation="4dp"
        android:clickable="true"
        android:padding="0dp"
        android:layout_marginBottom="16dp"
        android:layout_marginRight="15dp"
        app:layout_constraintBottom_toBottomOf="@+id/linearLayout4"
        app:layout_constraintEnd_toEndOf="@+id/linearLayout4"
         />
</android.support.constraint.ConstraintLayout>
```

(4）美化笔记本界面**同（3）**

4）美化搜索界面

```
<!-- res/layout/activity_search.xml -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@android:color/black">
    <LinearLayout
        android:layout_marginTop="20px"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:padding="10dp">
        <SearchView
            android:id="@+id/searchView"
            android:layout_width="0dp"
            android:layout_height="48dp"
            android:layout_weight="1"
            android:queryHint="搜索笔记"
            android:iconifiedByDefault="false"
            android:textColor="@android:color/white"
            android:paddingHorizontal="16dp"
            android:background="@drawable/search_bg"
            tools:ignore="MissingConstraints">
        <requestFocus />
    </SearchView>
    <TextView
        android:id="@+id/tv_cancel"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:text="取消"
        android:textColor="@android:color/holo_orange_light"
        android:textSize="16sp"
        android:paddingHorizontal="16dp"
        android:gravity="center"
        android:layout_gravity="center_vertical"/>
    </LinearLayout>
    <LinearLayout
        android:id="@+id/text_result"
        android:layout_marginTop="15px"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:visibility="gone"
        android:padding="10dp">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:text="笔记"
            android:layout_weight="1"
            android:textColor="@android:color/white"
            android:textSize="20sp"
            android:paddingHorizontal="16dp"
            android:gravity="left"
            android:layout_gravity="center_vertical"/>
        <TextView
            android:id="@+id/text_count"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:text="已找到0项"
            android:layout_weight="1"
            android:textColor="@android:color/darker_gray"
            android:textSize="16sp"
            android:paddingHorizontal="16dp"
            android:gravity="right"
            android:layout_gravity="center_vertical"/>
    </LinearLayout>
    <ListView
        android:id="@android:id/list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:dividerHeight="3dp" />
</LinearLayout>
```

#### 3.实现效果界面截图

**见一应用的使用**

### （二）.笔记分类

#### 1.功能要求

点击主页面的笔记本按钮进入笔记本界面，可在笔记本界面新建笔记，以及删除笔记，查看笔记

(1)在NotePad新增笔记本表

```
   public static final class Categories implements BaseColumns {
        private Categories() {}

        public static final int NOTE_ID_PATH_POSITION = 1;
        // 表名
        public static final String TABLE_NAME = "categories";

        // 分类名称列（唯一）
        public static final String COLUMN_NAME_CATEGORY_NAME = "category_name";

        // 内容URI相关定义
        private static final String SCHEME = "content://";
        private static final String PATH_CATEGORIES = "/categories";
        private static final String PATH_CATEGORY_ID = "/categories/";

        public static final Uri CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + PATH_CATEGORIES);
        public static final Uri CONTENT_ID_URI_BASE = Uri.parse(SCHEME + AUTHORITY + PATH_CATEGORY_ID);
        public static final Uri CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME + AUTHORITY + PATH_CATEGORY_ID + "/#");

        // MIME类型
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.category";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.category";

        // 默认排序
        public static final String DEFAULT_SORT_ORDER = COLUMN_NAME_CATEGORY_NAME + " DESC";
    }
```



(2)在NotePad中Notes表中新增列

```
 public static final String COLUMN_NAME_CATEGORY = "category";  public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.note";
```

(3)在notepadprovider类中新增

```
public class NotePadProvider extends ContentProvider implements PipeDataWriter<Cursor> {
	....
  private static HashMap<String, String> sCategoriesProjectionMap;
        private static final int CATEGORIES = 4;
    private static final int CATEGORY_ID = 5;
	....
    static {sUriMatcher.addURI(NotePad.AUTHORITY, "categories", CATEGORIES);
        sUriMatcher.addURI(NotePad.AUTHORITY, "categories/#", CATEGORY_ID);
      	sCategoriesProjectionMap = new HashMap<>();
        sCategoriesProjectionMap.put(NotePad.Categories._ID, NotePad.Categories._ID);
        sCategoriesProjectionMap.put(NotePad.Categories.COLUMN_NAME_CATEGORY_NAME,
                NotePad.Categories.COLUMN_NAME_CATEGORY_NAME);
    }
   static class DatabaseHelper extends SQLiteOpenHelper {
		....
       @Override
       public void onCreate(SQLiteDatabase db) {

      	 db.execSQL("CREATE TABLE " + NotePad.Notes.TABLE_NAME + " ("
                   + NotePad.Notes._ID + " INTEGER PRIMARY KEY,"
                   + NotePad.Notes.COLUMN_NAME_TITLE + " TEXT,"
                   + NotePad.Notes.COLUMN_NAME_NOTE + " TEXT,"
                   + NotePad.Notes.COLUMN_NAME_CREATE_DATE + " INTEGER,"
                   + NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE + " INTEGER,"
                   + NotePad.Notes.COLUMN_NAME_CATEGORY + " TEXT DEFAULT '默认分类'"
                   + ");");
           db.execSQL("CREATE TABLE " + NotePad.Categories.TABLE_NAME + " ("
                   + NotePad.Categories._ID + " INTEGER PRIMARY KEY,"
                   + NotePad.Categories.COLUMN_NAME_CATEGORY_NAME + " TEXT UNIQUE NOT NULL" 
                   + ");");

           // 插入默认分类
           db.execSQL("INSERT INTO " + NotePad.Categories.TABLE_NAME + " ("
                   + NotePad.Categories.COLUMN_NAME_CATEGORY_NAME + ") VALUES ('默认分类');");
       }
  @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           if (oldVersion < 6) {
               // 创建分类表
               db.execSQL("CREATE TABLE " + NotePad.Categories.TABLE_NAME + " ("
                       + NotePad.Categories._ID + " INTEGER PRIMARY KEY,"
                       + NotePad.Categories.COLUMN_NAME_CATEGORY_NAME + " TEXT UNIQUE NOT NULL"
                       + ");");
               // 插入默认分类
               db.execSQL("INSERT INTO " + NotePad.Categories.TABLE_NAME + " ("
                       + NotePad.Categories.COLUMN_NAME_CATEGORY_NAME + ") VALUES ('默认分类');");
           }
       }
   @Override
   public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
           String sortOrder) {
       switch (sUriMatcher.match(uri)) {
         ....
          case CATEGORIES:
               qb.setTables(NotePad.Categories.TABLE_NAME);
               qb.setProjectionMap(sCategoriesProjectionMap);
               if (TextUtils.isEmpty(sortOrder)) {
                   orderBy = NotePad.Categories.DEFAULT_SORT_ORDER;  // "category_name ASC"
               } else {
                   // otherwise, uses the incoming sort order
                   orderBy = sortOrder;
               }
               break;
           case CATEGORY_ID:
               qb.setTables(NotePad.Categories.TABLE_NAME);
               qb.setProjectionMap(sCategoriesProjectionMap);
               qb.appendWhere(NotePad.Categories._ID + "=" +
                       uri.getPathSegments().get(NotePad.Categories.NOTE_ID_PATH_POSITION));
               if (TextUtils.isEmpty(sortOrder)) {
                   orderBy = NotePad.Categories.DEFAULT_SORT_ORDER;  // "category_name ASC"
               } else {
                   // otherwise, uses the incoming sort order
                   orderBy = sortOrder;
               }
               break;
           default:
               // If the URI doesn't match any of the known patterns, throw an exception.
               throw new IllegalArgumentException("Unknown URI " + uri);
       	}
	}
}
```



(4)创建categoryactivity类

```
public class CategoryActivity extends ListActivity {

    private static final String[] PROJECTION = {
            NotePad.Categories._ID,
            NotePad.Categories.COLUMN_NAME_CATEGORY_NAME
    };
    private static final int COLUMN_INDEX_NAME = 1;

    private Cursor mCursor;
    private SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_list_layout);
        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);

        // 初始化视图和事件
        initViews();
        // 加载分类数据
        loadCategories();
    }
```



(5))在categoryactivity类中设置上下文删除代码

```
private void initViews() {
        // 返回按钮事件
        findViewById(R.id.iv_back).setOnClickListener(v -> finish());

        // 新建分类按钮事件
        TextView tvNew = findViewById(R.id.tv_new);
        tvNew.setOnClickListener(v -> showAddCategoryDialog());


        // 为列表项设置上下文菜单（用于删除）
        getListView().setOnCreateContextMenuListener((menu, v, menuInfo) -> {
            menu.add(0, 0, 0, "删除笔记本");
        });
    }

    @Override
    public boolean onContextItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == 0) {
            // 获取选中项的ID
            android.widget.AdapterView.AdapterContextMenuInfo info =
                    (android.widget.AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            long categoryId = info.id;

            // 获取分类名称用于确认对话框
            String categoryName = getCategoryNameById(categoryId);
            if (categoryName == null) return true;

            // 显示删除确认对话框
            showDeleteConfirmDialog(categoryId, categoryName);
            return true;
        }
        return super.onContextItemSelected(item);
    }
     private void deleteCategory(long id, String name) {
        // 1. 将该分类下的笔记移动到默认分类
        ContentValues values = new ContentValues();
        values.put(NotePad.Notes.COLUMN_NAME_CATEGORY, "默认分类");

        getContentResolver().update(
                NotePad.Notes.CONTENT_URI,
                values,
                NotePad.Notes.COLUMN_NAME_CATEGORY + " = ?",
                new String[]{name}
        );

        // 2. 删除分类
        getContentResolver().delete(
                Uri.withAppendedPath(NotePad.Categories.CONTENT_URI, String.valueOf(id)),
                null,
                null
        );

        // 3. 重新加载数据
        reloadCategories();
        Toast.makeText(this, "分类已删除", Toast.LENGTH_SHORT).show();
    }
```

(6)在categoryactivity类中设置更新列表方法

```
private void loadCategories() {
        // 查询所有分类
        mCursor = getContentResolver().query(
                NotePad.Categories.CONTENT_URI,
                PROJECTION,
                null,
                null,
                NotePad.Categories.DEFAULT_SORT_ORDER
        );

        // 创建适配器
        mAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                mCursor,
                new String[]{NotePad.Categories.COLUMN_NAME_CATEGORY_NAME},
                new int[]{android.R.id.text1},
                0
        );

        setListAdapter(mAdapter);
    }

```

(7)在categoryactivity类中设置新增分类方法

```
private void addCategory(String name) {
    ContentValues values = new ContentValues();
    values.put(NotePad.Categories.COLUMN_NAME_CATEGORY_NAME, name);

    try {
        // 插入新分类
        getContentResolver().insert(NotePad.Categories.CONTENT_URI, values);
        // 重新加载数据
        reloadCategories();
        Toast.makeText(this, "分类创建成功", Toast.LENGTH_SHORT).show();
    } catch (Exception e) {
        // 处理重复分类等异常
        Toast.makeText(this, "分类已存在或创建失败", Toast.LENGTH_SHORT).show();
        throw  e;
    }
}
```

(8)在noteslist类中设置点击跳转笔记本界面方法

```
addCategory.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // 创建跳转到分类活动的意图
        Intent intent = new Intent(NotesList.this, CategoryActivity.class);
        // 启动活动并等待返回结果（使用请求码标识）
        startActivity(intent);
    }
});
```

(9)在noteslist类中设置加载分类方法

```
private void loadCategoriesFromDB() {
    categoryData.clear();
    categoryData.add("全部"); // 默认添加"全部"分类

    Cursor cursor = getContentResolver().query(
            NotePad.Categories.CONTENT_URI,
            new String[]{NotePad.Categories.COLUMN_NAME_CATEGORY_NAME},
            null,
            null,
            NotePad.Categories.DEFAULT_SORT_ORDER
    );

    if (cursor != null) {
        while (cursor.moveToNext()) {
            String category = cursor.getString(0);
            if (!TextUtils.isEmpty(category)) {
                categoryData.add(category);
            }
        }
        cursor.close();
    }
    addCategoryViews();
}
private void addCategoryViews() {
    categoryContainer.removeAllViews(); // 清空已有视图

    for (int i = 0; i < categoryData.size(); i++) {
        final int position = i;
        String category = categoryData.get(i);

        // 加载分类项布局
        TextView tv = (TextView) LayoutInflater.from(this)
                .inflate(R.layout.category_item, categoryContainer, false);
        tv.setText(category);

        // 设置点击事件
        tv.setOnClickListener(v -> {
            // 更新选中状态
            setSelectedPosition(position);
            // 切换分类刷新数据
            currentCategory = categoryData.get(position);
            reloadNotesByCategory();
        });

        // 添加到容器
        categoryContainer.addView(tv);
    }

    // 默认选中第一个分类
    setSelectedPosition(0);
}
```

(10)在noteslist类中设置点击分类更新分类下笔记

```
private void setSelectedPosition(int position) {
    // 取消之前选中项的状态
    View prevView = categoryContainer.getChildAt(selectedPosition);
    if (prevView != null) {
        prevView.setSelected(false);
    }

    // 设置新选中项的状态
    View currView = categoryContainer.getChildAt(position);
    if (currView != null) {
        currView.setSelected(true);
    }

    selectedPosition = position;
}

/**
 * 根据选中的分类重新加载笔记列表
 */
private void reloadNotesByCategory() {
    String selection = null;
    String[] selectionArgs = null;

    // 如果不是"全部"分类，添加筛选条件
    if (!"全部".equals(currentCategory)) {
        selection = NotePad.Notes.COLUMN_NAME_CATEGORY + " = ?";
        selectionArgs = new String[]{currentCategory};
    }

    // 查询符合条件的笔记
    Cursor cursor = managedQuery(
            NotePad.Notes.CONTENT_URI,
            PROJECTION,
            selection,
            selectionArgs,
            NotePad.Notes.DEFAULT_SORT_ORDER
    );

    // 更新列表适配器
    SimpleCursorAdapter adapter = new SimpleCursorAdapter(
            this,
            R.layout.noteslist_item,
            cursor,
            dataColumns,
            viewIDs
    );
    setListAdapter(adapter);
}
```

#### 3.实现效果界面截图

**见一笔记本界面介绍**



