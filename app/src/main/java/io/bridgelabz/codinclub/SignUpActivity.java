package io.bridgelabz.codinclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUp=findViewById(R.id.button_sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent otpIntent=new Intent(SignUpActivity.this,OtpVerificationActivity.class);
                startActivity(otpIntent);
            }
        });

    }
}