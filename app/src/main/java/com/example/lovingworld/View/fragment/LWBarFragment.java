package com.example.lovingworld.View.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lovingworld.R;
import com.example.lovingworld.View.adapter.FriendAdapter;

/**
 * Created by 甄大昌 on 2017/2/3.
 */

public class LWBarFragment extends Fragment
{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.postbar_main,container,false);
        return rootView;
    }
}
