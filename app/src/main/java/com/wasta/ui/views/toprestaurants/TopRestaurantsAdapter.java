package com.wasta.ui.views.toprestaurants;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wasta.R;
import com.wasta.databinding.ViewTopRestaurantItemBinding;
import com.wasta.di.module.NetworkModule;
import com.wasta.models.store.Store;

import java.util.ArrayList;
import java.util.List;

public class TopRestaurantsAdapter extends RecyclerView.Adapter<TopRestaurantsAdapter.ViewHolder> {
    private static final int PLACEHOLDERS_COUNT = 5;

    private TopRestaurantsView mView;

    private List<Store> mItems;

    public TopRestaurantsAdapter(TopRestaurantsView view) {
        this.mView = view;
        this.mItems = new ArrayList<>();
    }

    public TopRestaurantsAdapter(TopRestaurantsView view, @Nullable List<Store> items) {
        this(view);

        if (items != null) {
            this.mItems = items;
        } else {
            for (int i = 0; i < PLACEHOLDERS_COUNT; ++i) {
                Store store = new Store();
                store.setId(i);
                this.mItems.add(store);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mView, ViewTopRestaurantItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mItem = this.mItems.get(position);
        holder.mName.setText(holder.mItem.getName());
        holder.mRatingBar.setRating(0);
        if (!holder.mItem.getImage().isEmpty()) {
            Picasso.get()
                    .load(NetworkModule.BASE_URL + holder.mItem.getImage())
                    .error(R.drawable.category_image_placeholder)
                    .placeholder(R.drawable.category_image_placeholder)
                    .into(holder.mImage);
        }
    }

    public void updateList(@NonNull List<Store> stores) {
        this.mItems = stores;
        notifyDataSetChanged();
    }

    public void addAll(@NonNull List<Store> stores) {
        this.mItems.addAll(stores);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TopRestaurantsView mView;

        public Store mItem;

        public ImageView mImage;

        public TextView mName;

        public RatingBar mRatingBar;

        public ViewHolder(TopRestaurantsView view, @NonNull ViewTopRestaurantItemBinding binding) {
            super(binding.getRoot());

            mView = view;

            mImage = binding.image;

            mName = binding.name;

            mRatingBar = binding.rating;

            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mView.onStoreClick(mItem);
        }
    }
}
