package test.zx.chinese.main;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import test.zx.chinese.R;
import test.zx.chinese.myFragment.GridViewFragment;
import test.zx.chinese.myFragment.UserFragment;
import test.zx.chinese.myFragment.exam.ExamFragment;
import test.zx.chinese.myFragment.learn.LearnFragment;

public class MainActivity extends AppCompatActivity implements MainActivityView,UserFragment.OnFragmentInteractionListener,
                                                               GridViewFragment.OnFragmentInteractionListener {
    private MainPresenterImpl presenter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            String str;
            switch (item.getItemId()) {
                case R.id.navigation_learn:
                    str="learn";
                    break;
                case R.id.navigation_test:
                    str="exam";
                    break;
                case R.id.navigation_user:
                    str="user";
                    break;
                default:
                    return false;
            }
            presenter.clickSelect(str);
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fmTransaction=fm.beginTransaction();
        //默认是learnFragment
        fmTransaction.add(R.id.fragment,new LearnFragment());
        fmTransaction.commit();
        presenter=new MainPresenterImpl(this,new MainInteractorImpl());
    }

    @Override
    public void showFragment(String type) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fmTransaction=fm.beginTransaction();
        int id=R.id.fragment;
        Fragment fg;
        if(type.equals("learn")){
            fg=new LearnFragment();
        } else if(type.equals("exam")){
            fg=new ExamFragment();
        } else if(type.equals("user")){
            fg=new UserFragment();
        } else
            return;
        fmTransaction.replace(id,fg);
        fmTransaction.commit();
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.setting,menu);
//        return true;
//    }
    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }
}
