package com.example.polhamshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.polhamshop.HttpConnection.LoginCheck;
import com.example.polhamshop.HttpConnection.TestConn;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    private String input_id = " ";
    private String input_password = " ";
    private EditText id_edit, password_edit;
    private Button login_button;
    private Button signUp_button;
    private String state;

    private Button login_btn, signup_btn;
    private EditText id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_edit = (EditText)findViewById(R.id.id_edit);
        password_edit = (EditText)findViewById(R.id.pw_edit);
        login_button = (Button)findViewById(R.id.login_btn);
        signUp_button = (Button)findViewById(R.id.signup_btn);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                input_id = id_edit.getText().toString();
//                input_password = password_edit.getText().toString();

                TestConn testConn = new TestConn();
                try {
                    String result = testConn.execute().get();
                    Log.d("@@result",result);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);

//                if(!TextUtils.isEmpty(input_id) && !TextUtils.isEmpty(input_password)) {
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    Log.d("check", input_id+", " + input_password + "!!!");
//
//                    //로그인 통신
//                    LoginCheck checkLogin = new LoginCheck(input_id, input_password);
//                    try {
//                        state = checkLogin.execute().get();
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
//
//                    if(state.equals("0")){
//                        Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                    else if(state.equals("1")) {
//                        startActivity(intent);
//                        finish();
//                    }
//                }
//                else{
//                    Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호를 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

}
