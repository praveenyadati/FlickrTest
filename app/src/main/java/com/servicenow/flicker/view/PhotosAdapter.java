package com.servicenow.flicker.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.servicenow.flicker.R;
import com.servicenow.flicker.network.model.ImagesModel;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {

    private List<ImagesModel.Photo> photoList;
    private Context context;
    private ClickListener clickListener;

    PhotosAdapter(Context mContext, ClickListener clickListener) {
        context = mContext;
        this.clickListener = clickListener;
    }

    void setProjectList(final List<ImagesModel.Photo> photoList) {
        this.photoList = photoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        ImagesModel.Photo photo = photoList.get(position);
        String url = "http://farm" + photo.getFarm() + ".static.flickr.com/" + photo.getServer() + "/" + photo.getId() + "_" + photo.getSecret() + ".jpg";
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return photoList == null ? 0 : photoList.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView imageView;

        PhotoViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.sn_image_photo);
            view.setOnClickListener(v -> {
                if (clickListener != null) {
                    ImagesModel.Photo photo = photoList.get(getAdapterPosition());
                    String url = "http://farm" + photo.getFarm() + ".static.flickr.com/" + photo.getServer() + "/" + photo.getId() + "_" + photo.getSecret() + ".jpg";
                    clickListener.onClick(url);
                }
            });
        }
    }

    public interface ClickListener {
        void onClick(String url);
    }
}
