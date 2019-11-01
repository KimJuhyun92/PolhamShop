package com.example.polhamshop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.polhamshop.HttpConnection.GetNoticeInfo;
import com.example.polhamshop.Model.InfoNotice;
import com.github.clans.fab.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

public class NoticeFragment extends Fragment {

    private Button input_notice;

    public NoticeFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    InputNoticeDialog inputNoticeDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_notice, null);

        FloatingActionButton fab = view.findViewById(R.id.fab_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNoticeDialog= new InputNoticeDialog(getActivity());
                inputNoticeDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                inputNoticeDialog.show();
            }
        });
        final NoticeAdapter adapter = new NoticeAdapter(getActivity());
        final ListView listview = (ListView) view.findViewById(R.id.noticelist);
        listview.setAdapter(adapter);
        View header = inflater.inflate(R.layout.listview_header, null, false);
        listview.addHeaderView(header);

        //DB에서 공지사항 목록 불러오기
        GetNoticeInfo getNoticeInfo = new GetNoticeInfo();
        try {
            String result = getNoticeInfo.execute().get();
            Log.d("connect",result);
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            InfoNotice[] infoNotices = gson.fromJson(result, InfoNotice[].class);

            for (InfoNotice infoNotice : infoNotices) {
                try {
                    String title = infoNotice.getNotice_title();
                    title = URLDecoder.decode(title, "UTF-8");
                    infoNotice.setNotice_title(title);
                    String content = infoNotice.getNotice_content();
                    content = URLDecoder.decode(content, "UTF-8");
                    infoNotice.setNotice_content(content);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                adapter.add(infoNotice);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
        return view;
    }

}
