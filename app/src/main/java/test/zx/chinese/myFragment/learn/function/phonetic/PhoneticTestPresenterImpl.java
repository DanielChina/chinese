package test.zx.chinese.myFragment.learn.function.phonetic;

import test.zx.chinese.myFragment.learn.function.FuncBasicInteractor;
import test.zx.chinese.myFragment.learn.function.FuncBasicInteractorImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicPresenterImpl;
import test.zx.chinese.myFragment.learn.function.FuncBasicView;

/**
 * Created by THink on 2018/2/9.
 */

public class PhoneticTestPresenterImpl extends FuncBasicPresenterImpl implements PhoneticTestPresenter {
    public PhoneticTestPresenterImpl(PhoneticTestView view, PhoneticTestInteractorImpl interactor) {
        super(view, interactor);
    }
}
