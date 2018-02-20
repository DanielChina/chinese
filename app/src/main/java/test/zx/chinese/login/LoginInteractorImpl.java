package test.zx.chinese.login;

import android.content.Context;
import android.text.TextUtils;

import test.zx.chinese.data.DataInfo;
import test.zx.chinese.data.DataInfoImpl;
public class LoginInteractorImpl implements LoginInteractor {
    private DataInfo data;
    private Context context;
    public LoginInteractorImpl(Context context) {
        this.context = context;
    }
    @Override
    public void login(final String username, final String password, boolean complexChosen,final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        if (TextUtils.isEmpty(username)) {
            listener.onUsernameError();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            return;
        }
        data=DataInfoImpl.newInstance(context);
        //配置初始化
        data.configTask(complexChosen);
     //   if(data.get(username)==true && data.get(password)==true)
            listener.onSuccess();
    }
}
