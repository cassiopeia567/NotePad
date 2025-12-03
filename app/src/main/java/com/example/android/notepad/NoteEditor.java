package com.example.android.notepad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteEditor extends Activity {
    private static final String[] PROJECTION = {
            NotePad.Notes._ID,
            NotePad.Notes.COLUMN_NAME_TITLE,
            NotePad.Notes.COLUMN_NAME_NOTE,
            NotePad.Notes.COLUMN_NAME_CATEGORY
    };

    private int mState;
    private Uri mUri;
    private Cursor mCursor;
    private EditText mTitleText;
    private EditText mContentText;
    private String mOriginalTitle; // 原始标题备份
    private String mOriginalContent; // 原始内容备份

    private String mOriginalCategory;

    private TextView categoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_edit_layout);

        // 初始化意图和状态
        Intent intent = getIntent();
        String action = intent.getAction();

        if (Intent.ACTION_EDIT.equals(action)) {
            mState = 0; // 编辑状态
            mUri = intent.getData();
        } else if (Intent.ACTION_INSERT.equals(action)) {
            mState = 1; // 插入状态
            mUri = getContentResolver().insert(intent.getData(), null);
            if (mUri == null) {
                finish();
                return;
            }
            setResult(RESULT_OK, new Intent().setAction(mUri.toString()));
        } else {
            finish();
            return;
        }

        // 初始化视图
        initViews();

        // 查询数据
        mCursor = managedQuery(mUri, PROJECTION, null, null, null);
    }

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

    @Override
    protected void onResume() {
        super.onResume();
        if (mCursor != null && mCursor.moveToFirst()) {
            // 加载原始数据
            int titleIndex = mCursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_TITLE);
            int contentIndex = mCursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_NOTE);
            int categoryIndex = mCursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_CATEGORY);
            mOriginalTitle = mCursor.getString(titleIndex);
            mOriginalContent = mCursor.getString(contentIndex);
            mOriginalCategory = mCursor.getString(categoryIndex);
            if (!mOriginalTitle.equals("<Untitled>"))
                mTitleText.setText(mOriginalTitle);
            mContentText.setText(mOriginalContent);
            categoryView.setText(mOriginalCategory);
        }
    }

    // 保存笔记（仅保存有变化的内容）
    private void saveNote() {
        String currentTitle = mTitleText.getText().toString().trim();
        String currentContent = mContentText.getText().toString().trim();

        // 内容无变化则不保存
        if (currentTitle.equals(mOriginalTitle) && currentContent.equals(mOriginalContent)) {
            return;
        }

        ContentValues values = new ContentValues();
        values.put(NotePad.Notes.COLUMN_NAME_TITLE, currentTitle);
        values.put(NotePad.Notes.COLUMN_NAME_NOTE, currentContent);
        values.put(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE, System.currentTimeMillis());

        getContentResolver().update(mUri, values, null, null);

        // 更新原始数据备份
        mOriginalTitle = currentTitle;
        mOriginalContent = currentContent;
    }

    // 处理返回逻辑：标题和内容都为空则不保存
    private void handleBackPress() {
        String currentTitle = mTitleText.getText().toString().trim();
        String currentContent = mContentText.getText().toString().trim();

        // 标题和内容都为空：删除空笔记并退出
        if (currentTitle.isEmpty() && currentContent.isEmpty()) {
            if (mState == 1) { // 仅对新创建的笔记生效
                getContentResolver().delete(mUri, null, null);
            }
            finish();
            return;
        }

        // 有内容：保存并退出
        saveNote();
        finish();
    }

    // 编辑框失去焦点
    private void loseFocus() {
        mTitleText.clearFocus();
        mContentText.clearFocus();
    }

    // 隐藏软键盘
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mContentText.getWindowToken(), 0);
    }

    // 物理返回键处理
    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        handleBackPress();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCursor != null) {
            mCursor.close();
        }
    }
}