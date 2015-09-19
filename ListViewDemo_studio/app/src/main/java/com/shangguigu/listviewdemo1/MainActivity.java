package com.shangguigu.listviewdemo1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.shangguigu.listviewdemo1.adapter.DemoAdapter;
import com.shangguigu.listviewdemo1.bean.ItemData;

import java.util.ArrayList;

/**
 * by xzl  lalallalallalallallala
 */
public class MainActivity extends ActionBarActivity {

    //列表      的顶顶顶顶顶大
    private ListView list_item;
    private ArrayList<ItemData> list = new ArrayList<ItemData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_item = (ListView) findViewById(R.id.lv_demo);
        setDate();
        list_item.setAdapter(new DemoAdapter(MainActivity.this,list));
    }

    private void setDate() {
        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                list.add(new ItemData(1, i));
            } else if (i < 8) {
                list.add(new ItemData(2, i));
            } else {
                list.add(new ItemData(3, i));
            }
        }
    }
}
