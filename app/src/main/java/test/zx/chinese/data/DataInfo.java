package test.zx.chinese.data;

import java.util.List;
import java.util.Map;

/**
 * Created by THink on 2018/2/4.
 */

public  interface DataInfo {

   List<Map<String, String>> getLearnedTotalList();
   List<Map<String, String>> getCommonWordsTotalList();
   List<Map<String, String>> getHandwritingTestTotalList();
   List<Map<String, String>> getPhoneticTestTotalList();
   List<Map<String, String>> getTaskTotalList();
   void add(Object obj);
   void delete(Object obj);
   void set(Object obj);
   void configTask(boolean complexChosen);
   boolean isFinishConfig();
   void closeDb();
   Object get(int type);
}