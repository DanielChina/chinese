package test.zx.chinese.myFragment.learn.function.task;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.myFragment.learn.function.FuncBasicActivity;

public class LearnTaskActivity extends FuncBasicActivity implements LearnTaskView {
    private LearnTaskPresenter presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new LearnTaskPresenterImpl(this,new LearnTaskInteractorImpl());
        presenter.onResume(Constant.TASK);
    }
}
