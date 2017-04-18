package com.example.lovingworld.View.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovingworld.MainActivity;
import com.example.lovingworld.R;
import com.example.lovingworld.View.activity.TalkActivity;
import com.example.lovingworld.model.pojos.Friend;

import java.util.List;

/**
 * Created by 甄大昌 on 2017/2/6.
 */

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.ViewHolder>
{
    private List<Friend> friendList;

    public void  SessionAdapter()
    {

    }


    public void loadItems(List<Friend> friendList)
    {
        this.friendList = friendList;
    }

    @Override
    public void onBindViewHolder(SessionAdapter.ViewHolder viewHolder, int i)
    {
        //      viewHolder.icon.setImageBitmap(friendList.get(i).getIcon());
        viewHolder.name.setText(friendList.get(i).getFriendId());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Toast toast=Toast.makeText(MainActivity.mactivity, "你好,世界", Toast.LENGTH_SHORT);
//                toast.show();
                Intent intent = new Intent();
                intent.setClass(v.getContext(), TalkActivity.class);
                v.getContext().startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount()
    {
        if(friendList == null)
            return 0;
        return friendList.size();

    }
    @Override
    public SessionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_session, parent, false);
        return new SessionAdapter.ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView icon;
        public TextView name;
        public ViewHolder(View friendView)
        {
            super(friendView);
            icon = (ImageView) friendView.findViewById(R.id.session_friend_icon);
            name = (TextView) friendView.findViewById(R.id.session_friend_name);
        }
    }
}
