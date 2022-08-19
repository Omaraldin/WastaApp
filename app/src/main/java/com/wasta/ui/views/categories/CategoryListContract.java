package com.wasta.ui.views.categories;

import com.wasta.base.BaseContract;
import com.wasta.base.BaseCustomView;
import com.wasta.models.category.Category;

import java.util.List;

public interface CategoryListContract {

    interface View extends BaseCustomView {
        void updateCategoryList(List<Category> categories);

        void showLoadError(boolean visible);

        void onCategoryClick(int id);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void loadCategories();
    }


}
