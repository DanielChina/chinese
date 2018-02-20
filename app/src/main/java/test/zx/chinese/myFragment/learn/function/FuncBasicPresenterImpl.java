package test.zx.chinese.myFragment.learn.function;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

import test.zx.chinese.R;
import test.zx.chinese.myFragment.learn.function.FuncBasicInteractorImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicView;

/**
 * Created by THink on 2018/2/9.
 */

public class FuncBasicPresenterImpl implements FuncBasicPresenter{
    private FuncBasicView mFuncBasicView;
    private FuncBasicInteractorImpl mFuncBasicInteractor;
    public FuncBasicPresenterImpl(FuncBasicView funcBasicView,FuncBasicInteractorImpl funcBasicInteractor) {
        this.mFuncBasicView=funcBasicView;
        this.mFuncBasicInteractor=funcBasicInteractor;
    }
    @Override
    public void onResume(int type) {
        List<Map<String,String>> list=mFuncBasicInteractor.getAdapterData(type);
        SimpleAdapter simpleAdapter=new SimpleAdapter((Context)mFuncBasicView,list,
                R.layout.single_word_detail,
                new String[]{"phonetics","words","time"},
                new int[]{R.id.single_phonetics,R.id.single_word,R.id.single_word_time});
        mFuncBasicView.showGridView(simpleAdapter);
    }
}
