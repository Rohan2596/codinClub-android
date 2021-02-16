package io.bridgelabz.codinclub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import io.bridgelabz.codinclub.R;
import io.bridgelabz.codinclub.api.ApiClient;
import io.bridgelabz.codinclub.api.Response;
import io.bridgelabz.codinclub.api.UserService;
import io.bridgelabz.codinclub.dtos.AddUser;
import retrofit2.Call;
import retrofit2.Callback;

public class OtpVerificationActivity extends AppCompatActivity {

    Button otpVerificationButton;
    TextInputLayout textInputOtp;
    UserService userService;
    Intent intent;
    String mobileNumber;
    SharedPreferences sharedPreferences;

    public static final String perference="codinClub";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent=getIntent();
        setContentView(R.layout.activity_otp_verification);
        otpVerificationButton=findViewById(R.id.button_otp_verify);
        textInputOtp=(TextInputLayout)findViewById(R.id.text_input_otp);

        sharedPreferences=getSharedPreferences(perference, Context.MODE_PRIVATE);

        otpVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobileNumber=intent.getStringExtra("mobileNumber");
                confirmInput(view);
                intent=new Intent(OtpVerificationActivity.this,UserInfoActivity.class);
                startActivity(intent);
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
        OtpVerification(mobileNumber,textInputOtp.getEditText().getText().toString());
        Toast.makeText(this,textInputOtp.getEditText().getText().toString(),Toast.LENGTH_LONG).show();
    }

    public void OtpVerification(String mobileNumber,String otp){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        userService= ApiClient.getClient().create(UserService.class);
        Call<Response> responseCall=userService.verityOtp(mobileNumber,otp);
        responseCall.enqueue(
                new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if(response.isSuccessful()){
                            editor.putString("token", response.body().getData().toString());
                            editor.commit();
                            Toast.makeText(OtpVerificationActivity.this,"Succesfull",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(OtpVerificationActivity.this,"Failure",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}