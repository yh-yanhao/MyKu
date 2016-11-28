package com.example.lenovo_pc.viewpagerfragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.lenovo_pc.viewpagerfragment.fragmnet.Fragment1;
import com.example.lenovo_pc.viewpagerfragment.fragmnet.Fragment2;
import com.example.lenovo_pc.viewpagerfragment.fragmnet.Fragment3;
import com.example.lenovo_pc.viewpagerfragment.fragmnet.Fragment4;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    private List<Fragment> list;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//找Id
        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);

        pager = (ViewPager) findViewById(R.id.pager);
        list = new ArrayList<Fragment>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());
        FragmentManager fragmentManager=getSupportFragmentManager();
        pager.setAdapter(new MyFragAdapter(fragmentManager,list));
        pager.setOffscreenPageLimit(4);
        // RadioGroup选中状态改变监听
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        pager.setCurrentItem(0, false);
                        rb1.setBackgroundColor(Color.RED);
                        rb2.setBackgroundColor(Color.BLACK);
                        rb3.setBackgroundColor(Color.BLACK);
                        rb4.setBackgroundColor(Color.BLACK);
                        break;
                    case R.id.rb2:
                        pager.setCurrentItem(1, false);
                        rb1.setBackgroundColor(Color.BLACK);
                        rb2.setBackgroundColor(Color.RED);
                        rb3.setBackgroundColor(Color.BLACK);
                        rb4.setBackgroundColor(Color.BLACK);
                        break;
                    case R.id.rb3:
                        pager.setCurrentItem(2, false);
                        rb1.setBackgroundColor(Color.BLACK);
                        rb2.setBackgroundColor(Color.BLACK);
                        rb3.setBackgroundColor(Color.RED);
                        rb4.setBackgroundColor(Color.BLACK);
                        break;
                    case R.id.rb4:
                        pager.setCurrentItem(3, false);

                        rb1.setBackgroundColor(Color.BLACK);
                        rb2.setBackgroundColor(Color.BLACK);
                        rb3.setBackgroundColor(Color.BLACK);
                        rb4.setBackgroundColor(Color.RED);
                        break;
                }
            }
        });
        // viewpager显示第一个界面
        pager.setCurrentItem(0);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {

                switch (arg0) {
                    case 0:
                        rg.check(R.id.rb1);
                        break;
                    case 1:
                        rg.check(R.id.rb2);
                        break;
                    case 2:
                        rg.check(R.id.rb3);
                        break;
                    case 3:
                        rg.check(R.id.rb4);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }



}
