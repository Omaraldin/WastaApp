package com.wasta.ui.views.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wasta.R;
import com.wasta.databinding.ViewCategoryItemBinding;
import com.wasta.di.module.NetworkModule;
import com.wasta.models.category.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private static final int PLACEHOLDERS_COUNT = 5;

    private final CategoryListView mView;

    private List<Category> mItems;

    private int mOrientation;


    public CategoryListAdapter(CategoryListView view) {
        this.mView = view;
        this.mItems = new ArrayList<>();

        for (int i = 0; i < PLACEHOLDERS_COUNT; ++i) {
            Category model = new Category();
            model.setId(i);
            model.setName("");
            model.setImage("");
            this.mItems.add(model);
        }
    }

    public CategoryListAdapter(CategoryListView view, @Nullable List<Category> items) {
        this(view);
        if (items != null) {
            this.mItems.addAll(items);
        }
    }

    public CategoryListAdapter(CategoryListView view, @Nullable List<Category> items, int orientation) {
        this(view, items);

        this.mOrientation = orientation;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(mView, ViewCategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

        if (mOrientation == CategoryListView.VERTICAL) {
            holder.mLayout.setOrientation(LinearLayout.HORIZONTAL);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mModel = mItems.get(position);
        holder.mCategoryName.setText(holder.mModel.getName());
        if (!holder.mModel.getImage().isEmpty()) {
            Picasso.get()
                    .load(NetworkModule.BASE_URL + holder.mModel.getImage())
                    .error(R.drawable.category_image_placeholder)
                    .placeholder(R.drawable.category_image_placeholder)
                    .into(holder.mCategoryImage);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateList(@NonNull List<Category> categories) {
        this.mItems = categories;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CategoryListView mView;

        public Category mModel;

        public LinearLayout mLayout;

        public ImageView mCategoryImage;

        public TextView mCategoryName;

        public ViewHolder(CategoryListView view, @NonNull ViewCategoryItemBinding binding) {
            super(binding.getRoot());

            this.mLayout = binding.layout;

            this.mCategoryImage = binding.categoryImage;

            this.mCategoryName = binding.categoryName;

            this.mView = view;

            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mView.onCategoryClick(mModel.getId());
        }

    }
}
