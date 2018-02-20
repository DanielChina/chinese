package test.zx.chinese.myFragment.learn.function;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import test.zx.chinese.R;
public class FuncBasicActivity extends AppCompatActivity implements FuncBasicView {
    private GridView mGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_func);
        mGridView=findViewById(R.id.basic_words_list);
    }
    public void onUpdate(){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SimpleAdapter simpleAdapter=(SimpleAdapter)mGridView.getAdapter();
                simpleAdapter.notifyDataSetChanged();
            }
        });
    }
    public void showGridView(SimpleAdapter simpleAdapter){
        mGridView.setAdapter(simpleAdapter);
    }
}

