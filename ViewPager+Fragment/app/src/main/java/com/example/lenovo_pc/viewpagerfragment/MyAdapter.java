package com.example.lenovo_pc.viewpagerfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by lenovo-pc on 2016/11/11.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener{
    Context context;
    List<Bean.DataBean> list;
    private final LayoutInflater inflater;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;


    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , Bean.DataBean data);
    }


    public MyAdapter(Context context, List<Bean.DataBean> list) {
        this.context=context;
        this.list=list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        BitmapUtils bitmap=new BitmapUtils(context);
        bitmap.display(holder.im,list.get(position).getGoods_img());
        holder.tv.setText(list.get(position).getGoods_name());


        holder.itemView.setTag(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(Bean.DataBean)v.getTag());
        }
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;
        ImageView im;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
            im= (ImageView) view.findViewById(R.id.im);
        }
    }
}
