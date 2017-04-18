//package com.example.lovingworld.View.adapter;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.example.lovingworld.R;
//import com.example.lovingworld.model.pojos.Post;
//import java.util.List;
//
///**
// * Created by 甄大昌 on 2017/1/6.
// */
//
//public class PostContentAdapter extends RecyclerView.Adapter<PostContentAdapter.ViewHolder>
//{
//    private List<Post> mPostList;
//    PostContentAdapter()
//    {
//        super();
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDataset.length;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
//        View view = View.inflate(viewGroup.getContext(), R.layout.post_content, null);
//        // 创建一个ViewHolder
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, int i) {
//        // 绑定数据到ViewHolder上
//        viewHolder.mTextView.setText(mDataset[i]);
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//        public ImageView mPostIcon;
//        public TextView mPostHead;
//        public TextView mPostContent;
//
//        public TextView mTextView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            mTextView = (TextView) itemView;
//        }
//    }
//}
