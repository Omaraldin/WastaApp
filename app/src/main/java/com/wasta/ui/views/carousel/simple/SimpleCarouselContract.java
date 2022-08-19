package com.wasta.ui.views.carousel.simple;

import com.wasta.base.BaseContract;
import com.wasta.base.BaseCustomView;
import com.wasta.models.slider.Slider;

import java.util.List;

public interface SimpleCarouselContract {

    interface View extends BaseCustomView {
        void addSlider(Slider slider);

        void updateSliders(List<Slider> categories);

        void showLoadError(boolean visible);

        void onSliderClick(Slider slider);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void loadSliders();

    }
}
