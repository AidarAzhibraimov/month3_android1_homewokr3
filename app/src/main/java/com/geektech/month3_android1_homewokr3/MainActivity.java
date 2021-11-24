package com.geektech.month3_android1_homewokr3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
        massage = findViewById(R.id.et_message);
        send = findViewById(R.id.btn_send);
        String Uri = "https://vectorified.com/images/small-email-icon-12.png";
        Glide.with(MainActivity.this).load(Uri).into(imageView);
        initListeners();
    }

    private void initListeners() {
        send.setOnClickListener(v -> {
            Log.d("ololo",email.getText().toString());

            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{
                    email.getText().toString()
            });
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, theme.getText().toString());
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, massage.getText().toString());

            emailIntent.setType("message/rfc822");

            try {
                startActivity(Intent.createChooser(emailIntent,
                        "Send email using..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this,
                        "No email clients installed.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}