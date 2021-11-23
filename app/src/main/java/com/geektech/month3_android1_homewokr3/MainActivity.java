package com.geektech.month3_android1_homewokr3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
private ImageView imageView;
private EditText email, theme, massage;
private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iv_email);
        email = findViewById(R.id.et_email);
        theme = findViewById(R.id.et_theme);
        massage = findViewById(R.id.et_massage);
        send = findViewById(R.id.btn_send);
        String Uri = "https://vectorified.com/images/small-email-icon-12.png";
        Glide.with(MainActivity.this).load(Uri).into(imageView);
        initListeners();
    }

    private void initListeners() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT,theme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,massage.getText().toString());
                intent.setType("massage/rfc822");
                startActivity(Intent.createChooser(intent,"Choose an Email client:"));
            }
        });
    }

}