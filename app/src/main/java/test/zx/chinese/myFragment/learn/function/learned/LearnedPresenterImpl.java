package test.zx.chinese.myFragment.learn.function.learned;

import test.zx.chinese.myFragment.learn.function.FuncBasicInteractorImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicPresenterImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicView;

/**
 * Created by THink on 2018/2/9.
 */

public class LearnedPresenterImpl extends FuncBasicPresenterImpl implements LearnedPresenter {
    public LearnedPresenterImpl(FuncBasicView funcBasicView, FuncBasicInteractorImpl funcBasicInteractor) {
        super(funcBasicView, funcBasicInteractor);
    }

    @Override
    public void onResume(int type) {
        super.onResume(type);
    }
}
