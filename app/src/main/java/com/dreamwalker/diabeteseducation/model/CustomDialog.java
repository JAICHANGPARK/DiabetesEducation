package com.dreamwalker.diabeteseducation.model;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dreamwalker.diabeteseducation.R;

public class CustomDialog extends Dialog {

    private MyDialogListener dialogListener;
    private Context context;
    private TextView text_title;
    private TextView text_content;
    private String name;
    private String title;
    private String content;

    public CustomDialog(Context context, String title, String content) {
        super(context);
        this.context = context;
        this.title = title;
        this.content = content;
    }

    public void setDialogListener(MyDialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);

        text_title = (TextView) findViewById(R.id.text_title);
        text_content = (TextView) findViewById(R.id.text_content);

        text_title.setText(title);
        text_content.setText(content);

        // 종료 버튼
        Button ok_btn = (Button) findViewById(R.id.ok_btn);
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }
}
