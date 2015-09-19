package com.shangguigu.listviewdemo1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shangguigu.listviewdemo1.R;
import com.shangguigu.listviewdemo1.bean.ItemData;

import java.util.ArrayList;

/**
 * 分类型显示Item的适配器
 * Created by liyanlei on 2015/3/16.
 */
public class DemoAdapter extends BaseAdapter implements View.OnClickListener {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ItemData> mList;

    public DemoAdapter(Context context, ArrayList<ItemData> list) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mList = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null && mList.size() > 0) {
            return mList.get(position).type;
        }
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getCount() {
        if (mList != null && mList.size() > 0) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public ItemData getItem(int position) {
        if (mList != null && mList.size() > 0) {
            return mList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);

        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            if (1 == type) {
                convertView = mInflater.inflate(R.layout.item_textview, null);
                holder.textView = (TextView) convertView.findViewById(R.id.tv);
            } else if (2 == type) {
                convertView = mInflater.inflate(R.layout.item_imageview,null);
                holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            } else {
                convertView = mInflater.inflate(R.layout.item_buttom, null);
                holder.buttom = (Button) convertView.findViewById(R.id.btn);
            }
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        if(1== type){
            holder.textView.setOnClickListener(this);
            holder.textView.setTag(position);
        }else if(2 == type){
            holder.imageView.setOnClickListener(this);
            holder.imageView.setTag(position);
        }else if(3 == type){
            holder.buttom.setOnClickListener(this);
            holder.buttom.setTag(position);
        }

        return convertView;
    }

    @Override
    public void onClick(View v) {
       int postion = (int) v.getTag();
        Toast.makeText(mContext, "postion :" + postion, Toast.LENGTH_SHORT).show();
    }

     static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public Button buttom;
    }
}
