package test.zx.chinese.myFragment.learn.function.handwriting;

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

public class HandWritingActivity extends FuncBasicActivity implements HandWritingView {
    private HandWritingPresenter presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new HandWritingPresenterImpl(this,new HandWritingInteractorImpl());
        presenter.onResume(Constant.HANDWRITING_TEST);
    }

}
