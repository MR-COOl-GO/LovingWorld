package com.example.lovingworld.View.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovingworld.model.pojos.Message;

import java.util.List;

/**
 * Created by 甄大昌 on 2017/1/10.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>
{
    private List<Message> messageList;
    public MessageAdapter(){};

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }


    @Override
    public int getItemCount()
    {
        if(messageList == null)
        {
            return 0;
        }
        return messageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }


}
