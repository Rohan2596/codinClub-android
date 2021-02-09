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

public class UserInfoActivity extends AppCompatActivity {

    Button submitButton;
    TextInputLayout textInputName,textInputEmailAddress,textYearOfPassingOut,textInputStream,textMothOfExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_part_1);

        submitButton=findViewById(R.id.button_confirm_user);
        //Input Field form User Info
        textInputName=findViewById(R.id.text_input_name);
        textInputEmailAddress=findViewById(R.id.text_input_emailAddress);
        textYearOfPassingOut=findViewById(R.id.text_input_yop);
        textInputStream=findViewById(R.id.text_input_stream);
        textMothOfExperience=findViewById(R.id.text_input_monthOfExperience);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInput(view);
                Intent dashboardIntent=new Intent(UserInfoActivity.this,DashboardActivity.class);
                startActivity(dashboardIntent);
            }
        });
    }


    private boolean validateName(){
        String name=textInputName.getEditText().getText().toString().trim();
        if(name.isEmpty()){
            textInputName.setError("Name Can't be Empty");
            return false;
        }
        if(name.length()>35){
            textInputName.setError("Name length should be 30");
            return false;
        }
        textInputName.setError(null);
        return true;

    }

    private boolean validateEmailAddress(){
        String emailAddress=textInputName.getEditText().getText().toString().trim();
        if(emailAddress.isEmpty()){
            textInputName.setError("Name Can't be Empty");
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
            textInputName.setError("Name length should be 30");
            return false;
        }
        textInputName.setError(null);
        return true;

    }

    private boolean validateStream(){
        String stream=textInputStream.getEditText().getText().toString().trim();
        if(stream.isEmpty()){
            textInputStream.setError("Stream Can't be Empty");
            return false;
        }
        textInputStream.setError(null);
        return true;
    }

    private boolean validateYearOfPassing(){
        String yop=textYearOfPassingOut.getEditText().getText().toString().trim();
        if(yop.isEmpty()){
            textYearOfPassingOut.setError("Year of Passing Can't be Empty");
            return false;
        }
        textYearOfPassingOut.setError(null);
        return true;
    }


    public void confirmInput(View view){
        if(!validateName()|| !validateEmailAddress() || !validateStream() || !validateYearOfPassing()){
            return;
        }
        Toast.makeText(this,
                textInputStream.getEditText().getText().toString()
                +"Name:- " +textInputName.getEditText().getText().toString()
                +"Email Address:- "+textInputEmailAddress.getEditText().getText().toString()
                +"Year of Passing:- "+textYearOfPassingOut.getEditText().getText().toString()
                +"Stream :- "+textInputStream.getEditText().getText().toString()
                ,Toast.LENGTH_LONG).show();
    }



}