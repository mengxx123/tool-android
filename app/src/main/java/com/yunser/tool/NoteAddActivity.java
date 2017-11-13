package com.yunser.tool;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class NoteAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_close);
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_give_up:
                dialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu){
        getMenuInflater().inflate(R.menu.note_add, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//
//            return true;
//        }
//
//        if (id == R.id.action_give_up) {
//            dialog();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    public void dialog() {
        new AlertDialog.Builder(NoteAddActivity.this).setTitle("提示")
                .setMessage("是否放弃此次编辑？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                        finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("alertdialog", " 请保存数据！");
                    }
                })
                .show();
    }
}
