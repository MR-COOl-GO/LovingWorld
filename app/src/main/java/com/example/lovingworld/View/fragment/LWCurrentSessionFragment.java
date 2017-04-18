package com.example.lovingworld.View.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lovingworld.R;
import com.example.lovingworld.View.adapter.FriendAdapter;
import com.example.lovingworld.View.adapter.SessionAdapter;
import com.example.lovingworld.model.db.DatabaseHelper;
import com.example.lovingworld.model.pojos.Friend;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 甄大昌 on 2017/2/3.
 */

public class LWCurrentSessionFragment extends Fragment
{
    SessionAdapter sessionAdapter;
    RecyclerView friendView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_session,container,false);
 //       testOrmlite();
        friendView = (RecyclerView)rootView.findViewById(R.id.recyclerview_fragment_session);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayout.VERTICAL, false);
        friendView.setLayoutManager(layoutManager);

        sessionAdapter = new SessionAdapter();
        sessionAdapter.loadItems(getData());
        friendView.setAdapter(sessionAdapter);
        return rootView;
    }

    public void initFragment()
    {

    }
    private void testOrmlite()
    {
        DatabaseHelper databaseHelper = DatabaseHelper.getHelper(getActivity());
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
        DatabaseHelper helper=DatabaseHelper.getHelper(getActivity());
        List<Friend> list=null;
        try {
            list = helper.getFriendDao().queryForAll();
            Log.i("list size",""+list.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
