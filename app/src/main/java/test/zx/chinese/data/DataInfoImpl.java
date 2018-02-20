package test.zx.chinese.data;

import android.content.Context;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.data.sqlite.MySqlOpenHelper;

/**
 * Created by THink on 2018/2/4.
 */

public class DataInfoImpl implements DataInfo {

    private volatile boolean finishConfig=false;
    private List<String> listOfCommonWords,listOfLearned,listOfTask;
    private List<String> listOfHandwritingTest,listOfPhoneticTest;
    private List<String> listOfHandwritingTestTime,listOfLearnedTime;
    private List<String> listOfPhoneticTestTime,listOfTaskTime;
    private List<String> listOfPhoneticTestPhonetic,listOfTaskPhonetic,listOfLearnedPhonetic;
    private List<String> listOfHandwritingTestPhonetic,listOfCommonWordsPhonetic;
    private Context context;
    private static DataInfo dataInfo;
    private MySqlOpenHelper sqlOpenHelper;
    private List<Map<String,String>> learnedTotalList, commonWordsTotalList;
    private List<Map<String,String>> handwritingTestTotalList;
    private List<Map<String,String>> phoneticTestTotalList,taskTotalList;
    public DataInfoImpl(Context context) {
        this.context=context;
    }
    public Object get(int type) {
        switch(type) {
            case Constant.COMMON_WORDS:
                return getListOfCommonWords();
            case Constant.LEARNED_WORDS:
                return getListOfLearned();
            case Constant.PHONETICS_TEST:
                return getListOfPhoneticTest();
            case Constant.HANDWRITING_TEST:
                return getListOfHandwritingTest();
            case Constant.TASK:
                return getListOfTask();
            case Constant.LEARNED_WORDS_TIME:
                return getListOfLearnedTime();
            case Constant.PHONETICS_TEST_TIME:
                return getListOfPhoneticTestTime();
            case Constant.HANDWRITING_TEST_TIME:
                return getListOfHandwritingTestTime();
            case Constant.TASK_TIME:
                return getListOfTaskTime();
            case Constant.COMMON_WORDS_PHONETIC:
                return getListOfCommonWordsPhonetic();
            case Constant.LEARNED_PHONETIC:
                return getListOfLearnedPhonetic();
            case Constant.PHONETICS_TEST_PHONETIC:
                return getListOfPhoneticTestPhonetic();
            case Constant.HANDWRITING_TEST_PHONETIC:
                return getListOfHandwritingTestPhonetic();
            case Constant.TASK_PHONETIC:
                return getListOfTaskPhonetic();
        }
        return null;
    }
    public List<String> getListOfLearned() {
        return listOfLearned;
    }
    public List<String> getListOfHandwritingTest() {
        return listOfHandwritingTest;
    }

    public List<String> getListOfPhoneticTest() {
        return listOfPhoneticTest;
    }
    public List<String> getListOfTask() {
        return listOfTask;
    }

    public List<String> getListOfHandwritingTestTime() {
        return listOfHandwritingTestTime;
    }

    public List<String> getListOfLearnedTime() {
        return listOfLearnedTime;
    }

    public List<String> getListOfPhoneticTestTime() {
        return listOfPhoneticTestTime;
    }

    public List<String> getListOfTaskTime() {
        return listOfTaskTime;
    }

    @Override
    public void add(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }

    @Override
    public void set(Object obj) {

    }
    public static DataInfo getInstance(){
        return dataInfo;
    }
    public static DataInfo newInstance(Context context) {
        dataInfo= new DataInfoImpl(context);
        return dataInfo;
    }
    public void configTask(boolean complexChosen){
        final boolean complex=complexChosen;
     //   if(true) return;
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(!finishConfig){
                    sqlOpenHelper=new MySqlOpenHelper(context);
                    WriteCommonWordsToDb();
                    User user=getUserFromDb("elsa");
                    if(user==null)
                        user=getTestData();
                    closeDb();
                    setTotalWordsList(complex,user);
                    setTotalTimeList(user);
                    setTotalPhoneticList(complex,user);
                    setTotalList();
                }
                finishConfig=true;
            }
        }).start();
    }
    public List<String> getListOfCommonWords(){
        return listOfCommonWords;
    }
    public List<String> setWordsList(String words){
        List<String> list=new ArrayList<>();
        String str;
        int count=words.length();
        for(int i=0;i<count;i++){
            str=words.substring(i,i+1);
            list.add(str);
        }
        return list;
    }
    public List<String> setTimeList(String words){
        List<String> list=new ArrayList<>();
        String str;
        int count=words.length()/5;
        for(int i=0;i<count;i++){
            str=words.substring(i*5,(i+1)*5);
            list.add(str);
        }
        return list;
    }
    public List<String> setPhoneticList(String words){
        List<String> list=new ArrayList<>();
        String str;
        int count=words.length();
        for(int i=0;i<count;i++){
            str=words.substring(i,i+1);
            try {
                str=PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_MARK);
            } catch (PinyinException e) {
                str="null";
                e.printStackTrace();
            }
            list.add(str);
        }
        return list;

    }
    public User getUserFromDb(String userName){
        User user=sqlOpenHelper.getUserProfile(userName);
        return user;
    }
    public User getTestData(){
        User user=new User();
        user.setUserName("elsa");
        user.setImgName("aaa");
        user.setLoginSign(true);
        user.setPassword("1a");
        user.setRegisterTime("as");
        user.setComplexChosen(true);
        user.setLearned("中国好");
        user.setLearnedTime("01/0502/0503/05");
        user.setTask("今天的任务");
        user.setTaskTime("01/0402/0403/0404/0405/04");
        user.setPhoneticTest("读音测试");
        user.setPhoneticTestTime("01/0202/0203/0204/02");
        user.setHandwritingTest("书写测试");
        user.setHandwritingTestTime("01/0302/0303/0304/03");
        return user;
    }
    public void WriteCommonWordsToDb(){
        sqlOpenHelper.deleteAll();
        User user=getTestData();
        sqlOpenHelper.put(user);
    }
    public boolean isFinishConfig() {
        return finishConfig;
    }

    @Override
    public void closeDb() {
        if(sqlOpenHelper!=null)
            sqlOpenHelper.close();
    }
    public void setTotalWordsList(boolean complexChosen,User user){
        if(complexChosen)
            listOfCommonWords=setWordsList(Constant.COMMON_COMPLEX);
        else
            listOfCommonWords=setWordsList(Constant.COMMON_SIMPLE);
        listOfLearned=setWordsList(user.getLearned());
        listOfHandwritingTest=setWordsList(user.getHandwritingTest());
        listOfPhoneticTest=setWordsList(user.getPhoneticTest());
        listOfTask=setWordsList(user.getTask());
    }
    public void setTotalTimeList(User user){
        listOfLearnedTime=setTimeList(user.getLearnedTime());
        listOfHandwritingTestTime=setTimeList(user.getHandwritingTestTime());
        listOfPhoneticTestTime=setTimeList(user.getPhoneticTestTime());
        listOfTaskTime=setTimeList(user.getTaskTime());
    }
    public void setTotalPhoneticList(boolean complexChosen,User user){
        List<String> list=new ArrayList<>();
        String str;
        if(complexChosen)
            str=Constant.COMMON_COMPLEX;
        else str=Constant.COMMON_SIMPLE;
        listOfCommonWordsPhonetic=setPhoneticList(str);
        listOfLearnedPhonetic=setPhoneticList(user.getLearned());
        listOfHandwritingTestPhonetic=setPhoneticList(user.getHandwritingTest());
        listOfTaskPhonetic=setPhoneticList(user.getTask());
        listOfPhoneticTestPhonetic=setPhoneticList(user.getPhoneticTest());
    }
    public void setTotalList(){
        learnedTotalList=getAdapterData(Constant.LEARNED_WORDS);
        commonWordsTotalList=getAdapterData(Constant.COMMON_WORDS);
        handwritingTestTotalList=getAdapterData(Constant.HANDWRITING_TEST);
        phoneticTestTotalList=getAdapterData(Constant.PHONETICS_TEST);
        taskTotalList=getAdapterData(Constant.TASK);
    }

    public List<Map<String, String>> getLearnedTotalList() {
        return learnedTotalList;
    }

    public List<Map<String, String>> getCommonWordsTotalList() {
        return commonWordsTotalList;
    }

    public List<Map<String, String>> getHandwritingTestTotalList() {
        return handwritingTestTotalList;
    }

    public List<Map<String, String>> getPhoneticTestTotalList() {
        return phoneticTestTotalList;
    }

    public List<Map<String, String>> getTaskTotalList() {
        return taskTotalList;
    }

    public List<Map<String,String>> getAdapterData(int type) {
        List<Map<String,String>> list=new ArrayList<>();
        List<String> subListTime=new ArrayList<>();
        List<String> subListPhonetic=new ArrayList<>();
        List<String> subList=(ArrayList<String>)get(type);
        switch(type){
            case Constant.COMMON_WORDS:
                subListPhonetic=(ArrayList<String>)get(Constant.COMMON_WORDS_PHONETIC);
                break;
            case Constant.LEARNED_WORDS:
                subListTime=(ArrayList<String>)get(Constant.LEARNED_WORDS_TIME);
                subListPhonetic=(ArrayList<String>)get(Constant.LEARNED_PHONETIC);
                break;
            case Constant.PHONETICS_TEST:
                subListTime=(ArrayList<String>)get(Constant.PHONETICS_TEST_TIME);
                subListPhonetic=(ArrayList<String>)get(Constant.PHONETICS_TEST_PHONETIC);
                break;
            case Constant.HANDWRITING_TEST:
                subListTime=(ArrayList<String>)get(Constant.HANDWRITING_TEST_TIME);
                subListPhonetic=(ArrayList<String>)get(Constant.HANDWRITING_TEST_PHONETIC);
                break;
            case Constant.TASK:
                subListTime=(ArrayList<String>)get(Constant.TASK_TIME);
                subListPhonetic=(ArrayList<String>)get(Constant.TASK_PHONETIC);
                break;
        }
        int count=subList.size();
        for(int i=0;i<count;i++) {
            Map<String,String> map = new HashMap<>();
            map.put("phonetics",subListPhonetic.get(i));
            map.put("words",subList.get(i));
            if(type==Constant.COMMON_WORDS)
                map.put("time","");
            else map.put("time",subListTime.get(i));
            list.add(map);
        }
        return list;
    }

    public List<String> getListOfPhoneticTestPhonetic() {
        return listOfPhoneticTestPhonetic;
    }

    public List<String> getListOfTaskPhonetic() {
        return listOfTaskPhonetic;
    }

    public List<String> getListOfLearnedPhonetic() {
        return listOfLearnedPhonetic;
    }

    public List<String> getListOfHandwritingTestPhonetic() {
        return listOfHandwritingTestPhonetic;
    }

    public List<String> getListOfCommonWordsPhonetic() {
        return listOfCommonWordsPhonetic;
    }
}
