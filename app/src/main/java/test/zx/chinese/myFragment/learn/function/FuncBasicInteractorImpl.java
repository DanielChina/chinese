package test.zx.chinese.myFragment.learn.function;

import java.util.List;
import java.util.Map;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.data.DataInfo;
import test.zx.chinese.data.DataInfoImpl;

/**
 * Created by THink on 2018/2/9.
 */

public class FuncBasicInteractorImpl implements FuncBasicInteractor {
    @Override
    public List<Map<String,String>> getAdapterData(int type) {
        DataInfo dataInfo= DataInfoImpl.getInstance();
        if(dataInfo.isFinishConfig()){
            switch(type) {
                case Constant.COMMON_WORDS:
                    return dataInfo.getCommonWordsTotalList();
                case Constant.LEARNED_WORDS:
                    return dataInfo.getLearnedTotalList();
                case Constant.PHONETICS_TEST:
                    return dataInfo.getPhoneticTestTotalList();
                case Constant.HANDWRITING_TEST:
                    return dataInfo.getHandwritingTestTotalList();
                case Constant.TASK:
                    return dataInfo.getTaskTotalList();
            }
        }
        return null;
    }
}
