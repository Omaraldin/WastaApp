package com.wasta.ui.views.topbar;

import com.wasta.base.BaseContract;
import com.wasta.base.BaseCustomView;

public interface TopBarContract {

    interface View extends BaseCustomView {
    }

    interface Presenter extends BaseContract.Presenter<View> {

    }

}
