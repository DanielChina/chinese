package test.zx.chinese.myFragment.learn.function.common;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.R;
import test.zx.chinese.myFragment.learn.function.FuncBasicActivity;
import test.zx.chinese.myFragment.learn.function.learned.LearnedInteractorImpl;
import test.zx.chinese.myFragment.learn.function.learned.LearnedPresenterImpl;

public class ComWordsActivity extends FuncBasicActivity implements ComWordsView{
    private ComWordsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new ComWordsPresenterImpl(this,new ComWordsInteractorImpl());
        presenter.onResume(Constant.COMMON_WORDS);
    }
}
