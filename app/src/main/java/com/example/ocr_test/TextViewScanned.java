package com.example.ocr_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewScanned extends AppCompatActivity {
    TextView resultTxt;
    Button copyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_scanned);
        overridePendingTransition(R.anim.in,R.anim.out);
        initWidget();

        Intent intent = getIntent();
        final String result = intent.getStringExtra("result");
        resultTxt.setText(result);
        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copy_Text", result);
                assert clipboard != null;
                clipboard.setPrimaryClip(clip);
                Toast.makeText(TextViewScanned.this, "copied to clipboard!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initWidget() {
        copyBtn = (Button) findViewById(R.id.copyBtn);
        resultTxt = (TextView) findViewById(R.id.resultTxt);
        resultTxt.setText("");
        resultTxt.setMovementMethod(new ScrollingMovementMethod());
    }
}