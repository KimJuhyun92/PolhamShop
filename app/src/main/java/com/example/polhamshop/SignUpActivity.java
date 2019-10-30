package com.example.polhamshop;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.polhamshop.HttpConnection.SaveSignUp;

public class SignUpActivity extends AppCompatActivity {

    private EditText id, pw, name, tel;

    private Button okButton, closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        id = findViewById(R.id.id_edit);
        pw = findViewById(R.id.pw_edit);
//        name = findViewById(R.id.name_edit);
//        tel = findViewById(R.id.tel_edit);
//
//        okButton = (Button)findViewById(R.id.ok_btn);
//        closeButton = (Button)findViewById(R.id.close_btn);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edit_id = id.getText().toString();
                String edit_pw = pw.getText().toString();
                String edit_name = name.getText().toString();
                String edit_tel = tel.getText().toString();


                SaveSignUp saveSignUp = new SaveSignUp(edit_id, edit_pw, edit_name, edit_tel);
                saveSignUp.execute();

                Toast.makeText(SignUpActivity.this, "회원가입이 완료되었습니다.!", Toast.LENGTH_SHORT).show();

                finish();


            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
