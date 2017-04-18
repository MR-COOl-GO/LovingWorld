package com.example.lovingworld;

import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.content.Context;
import android.content.SyncContext;
import android.widget.Toast;

import com.example.lovingworld.View.adapter.FriendAdapter;
import com.example.lovingworld.View.fragment.LWBarFragment;
import com.example.lovingworld.View.fragment.LWCurrentSessionFragment;
import com.example.lovingworld.View.fragment.LWFriendFragment;
import com.example.lovingworld.View.fragment.LWUserFragment;
import com.example.lovingworld.model.db.DatabaseHelper;
import com.example.lovingworld.model.pojos.Friend;
import com.j256.ormlite.dao.Dao;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity {
    public static MainActivity mactivity;
    private RecyclerView friendView;

    private ViewPager mViewPager;
    private List<Fragment> mContentFragments = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mactivity = this;
        setContentView(R.layout.activity_main);
//        File lwPath = this.getFilesDir();//this.getCacheDir();
//        String yygypathstr = lwPath.toString();
//        File file = new File(lwPath, "Lovingworld");
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        File sd= Environment.getExternalStorageDirectory();
        String path=sd.getPath()+"/LovingWorld";
        File file=new File(path);
        if(!file.exists())
            file.mkdir();
        initFragment();
        initViewPager();
//        testOrmlite();
//        friendView = (RecyclerView)findViewById(R.id.recyclerview_friend);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
//                                                 LinearLayout.VERTICAL, false);
//        friendView.setLayoutManager(layoutManager);
//
//        FriendAdapter friendAdapter = new FriendAdapter();
//        friendAdapter.loadItems(getData());
//        friendView.setAdapter(friendAdapter);
    }

    private void initFragment()
    {
        LWCurrentSessionFragment tmpFragment = new LWCurrentSessionFragment();
        mContentFragments.add(tmpFragment);
        LWFriendFragment tmpFriendFragment = new LWFriendFragment();
        mContentFragments.add(tmpFriendFragment);
        LWBarFragment tmpBarFragment = new LWBarFragment();
        mContentFragments.add(tmpBarFragment);
        LWUserFragment tmpUserFragment = new LWUserFragment();
        mContentFragments.add(tmpUserFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {

            @Override
            public int getCount()
            {
                return mContentFragments.size();
            }
            @Override
            public Fragment getItem(int arg0)
            {
                return mContentFragments.get(arg0);
            }
        };

        //initTabIndicator();

    }
    private void testOrmlite()
    {
        DatabaseHelper databaseHelper = DatabaseHelper.getHelper(getApplicationContext());
        try {
            Dao<Friend, String> friendDao = databaseHelper.getFriendDao();
            Friend friend = new Friend("李强",1,"kkkk");
            friendDao.create(friend);
            Friend friend1 = new Friend("张三",1,"kkkk");
            friendDao.create(friend1);
            Friend friend2 = new Friend("李四",1,"kkkk");
            friendDao.create(friend2);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private List<Friend> getData()
    {
        DatabaseHelper helper=DatabaseHelper.getHelper(this);
        List<Friend> list=null;
        try {
            list = helper.getFriendDao().queryForAll();
            Log.i("list size",""+list.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void initViewPager()
    {
        mViewPager = (ViewPager) findViewById(R.id.main_activity_viewpager);
        mViewPager.setAdapter(mAdapter);
    }

}
