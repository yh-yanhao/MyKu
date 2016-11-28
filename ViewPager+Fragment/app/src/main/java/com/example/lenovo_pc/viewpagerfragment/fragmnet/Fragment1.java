package com.example.lenovo_pc.viewpagerfragment.fragmnet;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo_pc.viewpagerfragment.Bean;
import com.example.lenovo_pc.viewpagerfragment.MyAdapter;
import com.example.lenovo_pc.viewpagerfragment.OkHttp;
import com.example.lenovo_pc.viewpagerfragment.R;
import com.example.lenovo_pc.viewpagerfragment.Tools;
import com.example.lenovo_pc.viewpagerfragment.view.PullBaseView;
import com.example.lenovo_pc.viewpagerfragment.view.PullRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by lenovo-pc on 2016/11/11.
 */
public class Fragment1 extends Fragment implements PullBaseView.OnHeaderRefreshListener,
        PullBaseView.OnFooterRefreshListener
{
    List<Bean.DataBean> list;
    PullRecyclerView recyclerView;
    private MyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.fragment1,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (PullRecyclerView) getView().findViewById(R.id.reww);

        recyclerView.setOnHeaderRefreshListener(this);//设置下拉监听
        recyclerView.setOnFooterRefreshListener(this);//设置上拉监听
        //设置布局管理
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setOrientation(LinearLayout.VERTICAL);
        //设置数据
        setData();
    }

    private void setData() {

        list=new ArrayList<Bean.DataBean>();
        OkHttp.getAsync("http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17", new OkHttp.DataCallBack() {



            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {

                Bean   bean= Tools.parseJsonWithGson(result,Bean.class) ;
                list=  bean.getData();
                adapter = new MyAdapter(getContext(), list);
                //设置Adapter
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(new MyAdapter.OnRecyclerViewItemClickListener(){
                    @Override
                    public void onItemClick(View view, Bean.DataBean data) {
                        Toast.makeText(getActivity(),data.getGoods_name(),Toast.LENGTH_SHORT).show();
                    }


                });
            }
        });


    }

    @Override
    public void onFooterRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mDatas.add("TEXT更多");
                adapter.notifyDataSetChanged();
                recyclerView.onFooterRefreshComplete();
            }
        }, 2000);
    }

    @Override
    public void onHeaderRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  mDatas.add(0, "TEXT新增");
                adapter.notifyDataSetChanged();
                recyclerView.onHeaderRefreshComplete();
            }
        }, 3000);
    }

//    @Override
//    public void onFooterRefresh(PullBaseView view) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // mDatas.add("TEXT更多");
//                adapter.notifyDataSetChanged();
//                recyclerView.onFooterRefreshComplete();
//            }
//        }, 2000);
//    }
//
//    @Override
//    public void onHeaderRefresh(PullBaseView view) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //  mDatas.add(0, "TEXT新增");
//                adapter.notifyDataSetChanged();
//                recyclerView.onHeaderRefreshComplete();
//            }
//        }, 3000);
//    }
}
