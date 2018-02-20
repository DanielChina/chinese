package test.zx.chinese.myFragment.learn.function.common;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

import test.zx.chinese.R;
import test.zx.chinese.myFragment.learn.function.FuncBasicInteractor;
import test.zx.chinese.myFragment.learn.function.FuncBasicInteractorImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicPresenterImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicView;

/**
 * Created by THink on 2018/2/7.
 */

public class ComWordsPresenterImpl extends FuncBasicPresenterImpl implements ComWordsPresenter {
    public ComWordsPresenterImpl(FuncBasicView funcBasicView, FuncBasicInteractorImpl funcBasicInteractor) {
        super(funcBasicView, funcBasicInteractor);
    }

    @Override
    public void onResume(int type) {
        super.onResume(type);
    }
}
