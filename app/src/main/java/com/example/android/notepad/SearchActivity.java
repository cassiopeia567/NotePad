package com.example.android.notepad;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;

public class SearchActivity extends ListActivity {
    private SearchView searchView;
    private TextView tvCancel;

    private TextView text_count;
    private LinearLayout text_result;

    private static final String[] PROJECTION = new String[] {
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_TITLE, // 1
            NotePad.Notes.COLUMN_NAME_CREATE_DATE,
            NotePad.Notes.COLUMN_NAME_CATEGORY
    };

    private String[] dataColumns = { NotePad.Notes.COLUMN_NAME_TITLE,NotePad.Notes.COLUMN_NAME_CREATE_DATE } ;
    private int[] viewIDs = { android.R.id.text1,R.id.itemdate };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initViews();
        //设置文本监听
        setSearchAdaoter();
    }

    private void initViews() {
        searchView = findViewById(R.id.searchView);
        tvCancel = findViewById(R.id.tv_cancel);
        tvCancel.setOnClickListener(v -> finish());
        text_count = findViewById(R.id.text_count);
        text_result = findViewById(R.id.text_result);
        // 自动弹出键盘并获取焦点
        searchView.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchView, InputMethodManager.SHOW_IMPLICIT);
    }
    private void setSearchAdaoter(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                Cursor cursor = queryNotesByTitle(newText);
                searchNotes(cursor);
                SimpleCursorAdapter adapter
                        = new SimpleCursorAdapter(
                        getApplicationContext(),                             // The Context for the ListView
                        R.layout.noteslist_item,          // Points to the XML for a list item
                        cursor,                           // The cursor to get items from
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
                        getApplicationContext(),                             // The Context for the ListView
                        R.layout.noteslist_item,          // Points to the XML for a list item
                        cursor,                           // The cursor to get items from
                        dataColumns,
                        viewIDs
                );
                setListAdapter(adapter);
                return true;
            }
        });
    }
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
}
