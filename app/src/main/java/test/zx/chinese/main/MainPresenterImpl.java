package test.zx.chinese.main;

/**
 * Created by THink on 2018/2/4.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.Callbacklistener {
    private MainActivityView mainView;
    private MainInteractorImpl interactor;
    MainPresenterImpl(MainActivityView mainView,MainInteractorImpl interactor){
        this.mainView=mainView;
        this.interactor=interactor;
    }

    @Override
    public void onPause() {
        interactor.onPause();
    }

    @Override
    public void clickSelect(String type) {
        mainView.showFragment(type);
    }
}
