package com.patty.proyecto.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.patty.proyecto.R;
import com.patty.proyecto.model.Receta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eddy on 15-09-17.
 */

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.DeviceViewHolder> {

    private Context context;
    private List<Receta> dataset;
    private OnRecetaSelectedListener onRecetaSelectedListener;

    public interface OnRecetaSelectedListener {
        void onRecetaSelected(Receta res);
    }

    public RecetasAdapter(Context context, OnRecetaSelectedListener listener) {
        this.dataset = new ArrayList<>();
        this.context = context;
        this.onRecetaSelectedListener = listener;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        Receta u = dataset.get(position);
        holder.titleTextView.setText(u.getTitle());
        holder.publisherUrlTextView.setText(u.getPublisherUrl());
        holder.recipeIdTextView.setText(u.getRecipeId());

        String url = /*"http://static.food2fork.com/" + */u.getImageUrl();
        Glide.with(context).load(url).into(holder.fotoImageView);
        Log.i("DIRECCION IMAGEN", "URL: " + url);

        holder.setDeviceSelectedListener(u, onRecetaSelectedListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class DeviceViewHolder extends RecyclerView.ViewHolder {

        View cardView;

        TextView titleTextView;
        TextView publisherUrlTextView;
        TextView recipeIdTextView;
        ImageView fotoImageView;

        public DeviceViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);

            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            publisherUrlTextView = (TextView) itemView.findViewById(R.id.publisherUrlTextView);
            recipeIdTextView = (TextView) itemView.findViewById(R.id.recipeIdTextView);
            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
        }

        public void setDeviceSelectedListener(final Receta res, final OnRecetaSelectedListener onRecetaSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecetaSelectedListener.onRecetaSelected(res);
                }
            });
        }
    }

    public void add(Receta receta) {
        dataset.add(receta);
        notifyDataSetChanged();
    }

    public void setDataset(List<Receta> recetas) {
        if (recetas == null) {
            dataset = new ArrayList<>();
        } else {
            dataset = recetas;
        }
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }
}
