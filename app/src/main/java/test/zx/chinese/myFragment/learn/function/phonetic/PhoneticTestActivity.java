package test.zx.chinese.myFragment.learn.function.phonetic;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.R;
import test.zx.chinese.myFragment.learn.function.FuncBasicActivity;

public class PhoneticTestActivity extends FuncBasicActivity implements PhoneticTestView {
    private PhoneticTestPresenter presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new PhoneticTestPresenterImpl(this,new PhoneticTestInteractorImpl());
        presenter.onResume(Constant.PHONETICS_TEST);
    }
}
