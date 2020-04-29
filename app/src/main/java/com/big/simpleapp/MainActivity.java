package com.big.simpleapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpannableString ss = new SpannableString("Don't have an account? Register");

        ClickableSpan clickableSpan1 =  new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan1, 23, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.register);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }
}
