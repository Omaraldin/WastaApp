package com.wasta.ui.views.carousel.simple;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wasta.R;
import com.wasta.databinding.ViewSimpleCarouselItemBinding;
import com.wasta.di.module.NetworkModule;
import com.wasta.models.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class SimpleCarouselAdapter extends RecyclerView.Adapter<SimpleCarouselAdapter.ViewHolder> {
    private static final int PLACEHOLDERS_COUNT = 5;

    private final SimpleCarouselView mView;

    private List<Slider> mItems;

    public SimpleCarouselAdapter(SimpleCarouselView view) {
        this.mView = view;
        this.mItems = new ArrayList<>();

        for (int i = 0; i < PLACEHOLDERS_COUNT; ++i) {
            Slider model = new Slider();
            model.setId(i);
            model.setSortingNumber(0);
            model.setStoreId(0);
            model.setStoreName("");
            model.setImage("");
            this.addOne(model);
        }
    }

    public SimpleCarouselAdapter(SimpleCarouselView view, @Nullable List<Slider> items) {
        this.mView = view;
        this.mItems = new ArrayList<>();
        if (items != null) {
            this.mItems.addAll(items);
        } else {
            for (int i = 0; i < PLACEHOLDERS_COUNT; ++i) {
                Slider model = new Slider();
                model.setId(i);
                model.setSortingNumber(0);
                model.setStoreId(0);
                model.setStoreName("");
                model.setImage("");
                this.addOne(model);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mView, ViewSimpleCarouselItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mItem = mItems.get(position);

        if (!holder.mItem.getImage().isEmpty()) {
            Picasso.get()
                    .load(NetworkModule.BASE_URL + holder.mItem.getImage())
                    .error(R.drawable.carousel_placeholder)
                    .placeholder(R.drawable.carousel_placeholder)
                    .into(holder.mImage);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addOne(Slider item) {
        this.mItems.add(item);
        notifyDataSetChanged();
    }

    public void updateList(@NonNull List<Slider> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }

    public void registerOnChange(OnChangeListener listener) {
        this.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listener.onChange();
            }
        });
    }

    public interface OnChangeListener {
        void onChange();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private SimpleCarouselView mView;

        public Slider mItem;

        public ImageView mImage;

        public ViewHolder(SimpleCarouselView view, @NonNull ViewSimpleCarouselItemBinding binding) {
            super(binding.getRoot());
            mView = view;

            mImage = binding.image;

            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mView.onSliderClick(mItem);
        }
    }
}
