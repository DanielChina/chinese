package test.zx.chinese.myFragment.learn.function.learned;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.R;
import test.zx.chinese.myFragment.learn.LearnPresenter;
import test.zx.chinese.myFragment.learn.function.FuncBasicActivity;
import test.zx.chinese.myFragment.learn.function.FuncBasicInteractorImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicPresenterImpl;

public class LearnedActivity extends FuncBasicActivity implements LearnedView {
    private LearnedPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new LearnedPresenterImpl(this,new LearnedInteractorImpl());
        presenter.onResume(Constant.LEARNED_WORDS);
    }
}
