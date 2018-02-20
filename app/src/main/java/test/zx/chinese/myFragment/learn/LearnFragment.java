package test.zx.chinese.myFragment.learn;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.R;
import test.zx.chinese.myFragment.GridViewFragment;
import test.zx.chinese.myFragment.learn.function.common.ComWordsActivity;
import test.zx.chinese.myFragment.learn.function.handwriting.HandWritingActivity;
import test.zx.chinese.myFragment.learn.function.learned.LearnedActivity;
import test.zx.chinese.myFragment.learn.function.phonetic.PhoneticTestActivity;
import test.zx.chinese.myFragment.learn.function.task.LearnTaskActivity;

public class LearnFragment extends GridViewFragment implements LearnView{
    private LearnPresenterImpl presenter;
    private Context context;
    private  String COMMON_WORDS= Constant.SUB_FUNC_LEARN_COMMON;
    private  String LEARNED_WORDS=Constant.SUB_FUNC_LEARN_LEARNED;
    private  String HANDWRITING_TEST=Constant.SUB_FUNC_HANDWRITING_TEST_REC;
    private String LEARN_TASK=Constant.SUB_FUNC_LEARN_TASK;
    private String PHONETIC_TEST=Constant.SUB_FUNC_PHONETIC_TEST_REC;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=super.onCreateView(inflater, container, savedInstanceState);
        presenter=new LearnPresenterImpl(this,new LearnInteractorImpl());
        return view;
    }

    public List<Map<String,Object>> getSubFunction(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("img",R.drawable.learn_common);
        map.put("name",COMMON_WORDS);
        list.add(map);
        map=new HashMap<>();
        map.put("img",R.drawable.learn_learned);
        map.put("name",LEARNED_WORDS);
        list.add(map);
        map=new HashMap<>();
        map.put("img",R.drawable.learn_phonetic);
        map.put("name",PHONETIC_TEST);
        list.add(map);
        map=new HashMap<>();
        map.put("img",R.drawable.learn_handwriting);
        map.put("name",HANDWRITING_TEST);
        list.add(map);
        map=new HashMap<>();
        map.put("img",R.drawable.learn_task);
        map.put("name",LEARN_TASK);
        list.add(map);
        return list;
    }
    public void navigateToSubActivity(int position){
        switch(position){
            case Constant.COMMON_WORDS:
                startActivity(new Intent(context, ComWordsActivity.class));
                break;
            case Constant.LEARNED_WORDS:
                startActivity(new Intent(context, LearnedActivity.class));
                break;
            case Constant.PHONETICS_TEST:
                startActivity(new Intent(context, PhoneticTestActivity.class));
                break;
            case Constant.HANDWRITING_TEST:
                startActivity(new Intent(context, HandWritingActivity.class));
                break;
            case Constant.TASK:
                startActivity(new Intent(context,LearnTaskActivity.class));
            default:
                break;
        }
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.visitSubActivity(position);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }
}
