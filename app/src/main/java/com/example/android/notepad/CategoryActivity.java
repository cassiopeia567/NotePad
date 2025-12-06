package com.example.android.notepad;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

    private void showAddCategoryDialog() {
        final EditText editText = new EditText(this);
        editText.setHint("请输入分类名称");

        new AlertDialog.Builder(this)
                .setTitle("新建分类")
                .setView(editText)
                .setPositiveButton("确定", (dialog, which) -> {
                    String categoryName = editText.getText().toString().trim();
                    if (categoryName.isEmpty()) {
                        Toast.makeText(CategoryActivity.this, "分类名称不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    addCategory(categoryName);
                })
                .setNegativeButton("取消", null)
                .show();

        // 自动弹出键盘
        editText.post(() -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        });
    }

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

    private void showDeleteConfirmDialog(long id, String name) {
        new AlertDialog.Builder(this)
                .setTitle("删除分类")
                .setMessage("确定要删除分类 \"" + name + "\" 吗？\n该分类下的笔记将被移动到默认分类。")
                .setPositiveButton("删除", (dialog, which) -> {
                    deleteCategory(id, name);
                })
                .setNegativeButton("取消", null)
                .show();
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

    private String getCategoryNameById(long id) {
        Cursor cursor = getContentResolver().query(
                Uri.withAppendedPath(NotePad.Categories.CONTENT_URI, String.valueOf(id)),
                PROJECTION,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(COLUMN_INDEX_NAME);
            cursor.close();
            return name;
        }
        return null;
    }

    private void reloadCategories() {
        // 重新查询数据并更新适配器
        Cursor newCursor = getContentResolver().query(
                NotePad.Categories.CONTENT_URI,
                PROJECTION,
                null,
                null,
                NotePad.Categories.DEFAULT_SORT_ORDER
        );

        mCursor = newCursor;
        mAdapter.changeCursor(mCursor);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 关闭游标
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
    }
}