package io.bridgelabz.codinclub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.bridgelabz.codinclub.R;

public class OtpVerificationActivity extends AppCompatActivity {

    Button otpVerificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        otpVerificationButton=findViewById(R.id.button_otp_verify);
        otpVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userInfoIntent=new Intent(OtpVerificationActivity.this,UserInfoActivity.class);
                startActivity(userInfoIntent);
            }
        });
    }
}