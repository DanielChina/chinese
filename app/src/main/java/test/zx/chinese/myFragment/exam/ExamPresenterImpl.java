package test.zx.chinese.myFragment.exam;

import test.zx.chinese.myFragment.learn.LearnInteractor;
import test.zx.chinese.myFragment.learn.LearnInteractorImpl;
import test.zx.chinese.myFragment.learn.LearnView;

/**
 * Created by THink on 2018/2/4.
 */

public class ExamPresenterImpl implements ExamPresenter {
    private ExamView view;
    private ExamInteractorImpl interactor;
    public ExamPresenterImpl(ExamView view,ExamInteractorImpl interactor) {
        this.view = view;
        this.interactor = interactor;
    }
    public void visitSubActivity(int position) {
        view.navigateToSubActivity(position);
    }
}