package test.zx.chinese.myFragment.learn;

import test.zx.chinese.Constant.Constant;

/**
 * Created by THink on 2018/2/7.
 */

public class LearnPresenterImpl implements LearnPresenter {
    private LearnView learnView;
    private LearnInteractor learnInteractor;
    public LearnPresenterImpl(LearnView learnView,LearnInteractorImpl learnInteractor) {
        this.learnView=learnView;
        this.learnInteractor= learnInteractor;
    }

    @Override
    public void visitSubActivity(int position) {
        learnView.navigateToSubActivity(position);
    }
}
