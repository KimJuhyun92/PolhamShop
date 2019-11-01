package com.example.polhamshop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.polhamshop.HttpConnection.SaveNotice;


import java.util.concurrent.ExecutionException;

public class InputNoticeDialog extends Dialog {

    private Button closeButton;
    private Button okButton;

    private EditText edt_title, edt_writer, edt_content;

    private String result;


    public InputNoticeDialog(final Context context) {
        super(context);

        Initialize();

        closeButton = (Button) findViewById(R.id.close_button);
        okButton = (Button) findViewById(R.id.ok_button);

        edt_title = (EditText) findViewById(R.id.edt_title);
        edt_writer = (EditText) findViewById(R.id.edt_writer);
        edt_content = (EditText) findViewById(R.id.edt_content);


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = String.valueOf(edt_title.getText());
                String writer = String.valueOf(edt_writer.getText());
                String content = String.valueOf(edt_content.getText());

                SaveNotice inputNoticeInfo = new SaveNotice(title, writer, content);

                try {
                    result = inputNoticeInfo.execute().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                //리플레쉬
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);

                Toast.makeText(getContext(), "공지사항이 입력되었습니다!", Toast.LENGTH_SHORT).show();

                dismiss();

            }
        });
    }

    private void Initialize() {
        //다이얼로그의 타이틀바를 없애주는 옵션입니다.
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //다이얼로그의 배경을 투명으로 만듭니다.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //다이얼로그에서 사용할 레이아웃입니다.\
        setContentView(R.layout.input_notice_dialog);
    }
}