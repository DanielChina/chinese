/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package test.zx.chinese.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import test.zx.chinese.R;
import test.zx.chinese.main.MainActivity;


public class LoginActivity extends Activity implements LoginView, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;
    private boolean complexChosen;
    private RadioGroup mRadioGroup;
    private RadioButton mRbSimpleChosen,mRbComplexChosen;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mRadioGroup=(RadioGroup)findViewById(R.id.simple_complex_choose);
        mRbSimpleChosen=(RadioButton)findViewById(R.id.simple_chinese);
        mRbComplexChosen=(RadioButton)findViewById(R.id.complex_chinese);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
        presenter = new LoginPresenterImpl(this,new LoginInteractorImpl(this));
        mRadioGroup.setOnCheckedChangeListener(this);

    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

        @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override public void onClick(View v) {
        if(v.getId()==R.id.button){
            presenter.validateCredentials(username.getText().toString(),
                    password.getText().toString(),complexChosen);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.simple_chinese:
                complexChosen=false;
                break;
            case R.id.complex_chinese:
                complexChosen=true;
                break;
            default:
        }
    }
}
