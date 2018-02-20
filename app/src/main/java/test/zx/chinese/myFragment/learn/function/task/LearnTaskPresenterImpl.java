package test.zx.chinese.myFragment.learn.function.task;

import test.zx.chinese.myFragment.learn.function.FuncBasicInteractorImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicPresenterImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicView;
import test.zx.chinese.myFragment.learn.function.learned.LearnedView;

/**
 * Created by THink on 2018/2/9.
 */

public class LearnTaskPresenterImpl extends FuncBasicPresenterImpl implements LearnTaskPresenter {
    private LearnTaskView view;
    private LearnTaskInteractorImpl interactor;
    public LearnTaskPresenterImpl(LearnTaskView view, LearnTaskInteractorImpl interactor) {
        super(view, interactor);
        this.view=view;
        this.interactor=interactor;
    }
}
