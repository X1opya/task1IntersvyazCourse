package com.x1opya.task1intersvyazcourse.Api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.x1opya.task1intersvyazcourse.Api.Models.Owner;
import com.x1opya.task1intersvyazcourse.R;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{
    private LayoutInflater mInflater;
    private List<Owner> owners;


    public UserAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        owners = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    public void updateOwners(List<Owner> owners){
        clear();
        this.owners.addAll(owners);
        notifyDataSetChanged();
    }

    private void clear(){
        owners.clear();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(owners.get(position));
    }

    @Override
    public int getItemCount() {
        return owners.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvType;
        private ImageView ivAvatar;
        private ProgressBar p;

        public MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            ivAvatar = view.findViewById(R.id.imageView);
            p = view.findViewById(R.id.pb_img_loading);
        }

        public void onBind(Owner v){
            tvName.setText(v.getLogin());
            Picasso.get()
                    .load(v.getAvatarUrl())
                    .into(ivAvatar, new Callback() {
                        @Override
                        public void onSuccess() {
                            p.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });

        }
    }
}
