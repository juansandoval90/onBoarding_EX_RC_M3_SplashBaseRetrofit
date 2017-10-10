package com.splashbaseretro.juansandoval.splashbaseretrofit.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.splashbaseretro.juansandoval.splashbaseretrofit.R;
import com.splashbaseretro.juansandoval.splashbaseretrofit.models.ImageListData;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<ImageListData> data;
    private Context context;

    public HomeAdapter(Context context, List<ImageListData> data, OnItemClickListener listener){
        this.data = data;
        this.listener = listener;
        this.context = context;
    }


    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.tvUrl.setText(String.valueOf(data.get(position).getId()));
        holder.tvLargeUrl.setText(data.get(position).getUrl());

        String images = data.get(position).getUrl();

        Glide.with(context)
                .load(images)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.background);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(ImageListData Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvLargeUrl, tvUrl;
        ImageView background;

        public ViewHolder(View itemView){
            super(itemView);
            tvLargeUrl = (TextView) itemView.findViewById(R.id.long_url);
            tvUrl = (TextView)itemView.findViewById(R.id.id_url);
            background = (ImageView)itemView.findViewById(R.id.image);

        }


        public void click(final ImageListData imageListData, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(imageListData);
                }
            });
        }
    }
}
