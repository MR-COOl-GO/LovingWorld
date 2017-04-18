package com.example.lovingworld.View.adapter;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovingworld.MainActivity;
import com.example.lovingworld.R;
import com.example.lovingworld.View.activity.TalkActivity;
import com.example.lovingworld.model.pojos.Friend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by 甄大昌 on 2017/1/9.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>
{
    private List<Friend> friendList;

    public void  FriendAdapter()
    {

    }


    public void loadItems(List<Friend> friendList)
    {
        this.friendList = friendList;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int i)
    {
  //      viewHolder.icon.setImageBitmap(friendList.get(i).getIcon());
        viewHolder.name.setText(friendList.get(i).getFriendId());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(MainActivity.mactivity, "你好,世界", Toast.LENGTH_SHORT);
                toast.show();
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
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_friend, parent, false);
        return new ViewHolder(itemView);
    }

public static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
{
    public ImageView icon;
    public TextView name;
    public ViewHolder(View friendView)
    {
        super(friendView);
        icon = (ImageView) friendView.findViewById(R.id.friend_icon);
        name = (TextView) friendView.findViewById(R.id.friend_name);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(view.getContext(), TalkActivity.class);
        view.getContext().startActivity(intent);
    }

}
}