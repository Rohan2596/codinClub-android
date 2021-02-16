package io.bridgelabz.codinclub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import io.bridgelabz.codinclub.R;
import io.bridgelabz.codinclub.api.ApiClient;
import io.bridgelabz.codinclub.api.Response;
import io.bridgelabz.codinclub.api.UserService;
import io.bridgelabz.codinclub.dtos.AddUser;
import retrofit2.Call;
import retrofit2.Callback;

public class SignUpActivity extends AppCompatActivity {

    Button signUp;
    TextInputLayout textInputMobileNumber;
    UserService userService;

    SharedPreferences sharedPreferences;

    public static final String perference="codinClub";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        appConfiguration();
        signUp=(Button) findViewById(R.id.button_sign_up);
        textInputMobileNumber=(TextInputLayout)findViewById(R.id.textInputMobileNumber);
         sharedPreferences=getSharedPreferences(perference,Context.MODE_PRIVATE);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                confrimInput(view);
                Intent otpIntent=new Intent(SignUpActivity.this,OtpVerificationActivity.class);
                otpIntent.putExtra("mobileNumber",textInputMobileNumber.getEditText().getText().toString());
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

        String mobileNumber=textInputMobileNumber.getEditText().getText().toString();
        AddUser addUser =new AddUser("91"+mobileNumber,"Android App","","");
        signUp(addUser);
    }


    public void signUp(AddUser addUser){


        userService= ApiClient.getClient().create(UserService.class);
        Call<Response> responseCall=userService.addUser(addUser);
        responseCall.enqueue(
                new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(SignUpActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this,"Failure",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void appConfiguration(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        userService= ApiClient.getClient().create(UserService.class);
        Call<Response> responseCall=userService.appConfiguration();
        responseCall.enqueue(
                new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if(response.isSuccessful()){
                            editor.putString("passingYear",response.body().getData().toString());
                            editor.putString("Streams",response.body().getMessage());
                            editor.commit();
                            Toast.makeText(SignUpActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this,"Failure",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}