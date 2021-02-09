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

public class SignUpActivity extends AppCompatActivity {

    Button signUp;
    TextInputLayout textInputMobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUp=(Button) findViewById(R.id.button_sign_up);
        textInputMobileNumber=(TextInputLayout)findViewById(R.id.textInputMobileNumber);


        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                confrimInput(view);
                Intent otpIntent=new Intent(SignUpActivity.this,OtpVerificationActivity.class);
                startActivity(otpIntent);
            }
        });

    }

    private boolean validateMobileNumber(){
        String mobileNumber=textInputMobileNumber.getEditText().getText().toString().trim();
        if(mobileNumber.isEmpty()){
            textInputMobileNumber.setError("Mobile Number Can't be Empty");
            return false;
        }
        if(mobileNumber.length()>10 || mobileNumber.length()<10){
            textInputMobileNumber.setError("Mobile Number length should be 10");
            return false;
        }
        if(!Patterns.PHONE.matcher(mobileNumber).matches()){
            textInputMobileNumber.setError("Mobile Number  Pattern doesn't match.");
            return false;
        }
        textInputMobileNumber.setError(null);
        return true;

    }

    public void confrimInput(View view){
        if(!validateMobileNumber()){
            return;
        }
        Toast.makeText(this,textInputMobileNumber.getEditText().getText().toString(),Toast.LENGTH_LONG).show();
    }
}