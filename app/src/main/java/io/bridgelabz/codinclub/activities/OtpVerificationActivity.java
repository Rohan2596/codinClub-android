package io.bridgelabz.codinclub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import io.bridgelabz.codinclub.R;

public class OtpVerificationActivity extends AppCompatActivity {

    Button otpVerificationButton;
    TextInputLayout textInputOtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        otpVerificationButton=findViewById(R.id.button_otp_verify);
        textInputOtp=(TextInputLayout)findViewById(R.id.text_input_otp);


        otpVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInput(view);
                Intent userInfoIntent=new Intent(OtpVerificationActivity.this,UserInfoActivity.class);
                startActivity(userInfoIntent);
            }
        });
    }


    private boolean validateOtp(){
        String otpNumber=textInputOtp.getEditText().getText().toString().trim();
        if(otpNumber.isEmpty()){
            textInputOtp.setError("OTP Number Can't be Empty");
            return false;
        }
        if(otpNumber.length()>4 || otpNumber.length()<4){
            textInputOtp.setError("OTP Number length should be 4");
            return false;
        }
        textInputOtp.setError(null);
        return true;

    }

    public void confirmInput(View view){
        if(!validateOtp()){
            return;
        }
        Toast.makeText(this,textInputOtp.getEditText().getText().toString(),Toast.LENGTH_LONG).show();
    }
}