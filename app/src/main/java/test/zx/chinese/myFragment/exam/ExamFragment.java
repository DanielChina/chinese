package test.zx.chinese.myFragment.exam;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.R;
import test.zx.chinese.myFragment.GridViewFragment;
import test.zx.chinese.myFragment.exam.func.TestBasicActivity;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExamFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExamFragment extends GridViewFragment implements ExamView {
    private ExamPresenterImpl presenter;
    private Context context;
    private  String PHONETIC_TEST= Constant.SUB_FUNC_PHONETIC_TEST;
    private String HANDWRITING_TEST=Constant.SUB_FUNC_HANDWRITING_TEST;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=super.onCreateView(inflater, container, savedInstanceState);
        presenter=new ExamPresenterImpl(this,new ExamInteractorImpl());
        return view;
    }

    public List<Map<String,Object>> getSubFunction(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("img",R.drawable.exam_phonetic);
        map.put("name",PHONETIC_TEST);
        list.add(map);
        map=new HashMap<>();
        map.put("img",R.drawable.exam_handwriting);
        map.put("name",HANDWRITING_TEST);
        list.add(map);
        return list;
    }
    public void navigateToSubActivity(int position){
        switch(position){
            case Constant.TEST_PHONETIC_TEST:
                startActivity(new Intent(context, TestBasicActivity.class));
                break;
            case Constant.TEST_HANDWRITING_TEST:
                startActivity(new Intent(context,TestBasicActivity.class));
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

