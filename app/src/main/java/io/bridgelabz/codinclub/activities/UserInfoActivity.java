package io.bridgelabz.codinclub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.bridgelabz.codinclub.R;

public class UserInfoActivity extends AppCompatActivity {

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_part_1);
        submitButton=findViewById(R.id.button_confirm_user);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboardIntent=new Intent(UserInfoActivity.this,DashboardActivity.class);
                startActivity(dashboardIntent);
            }
        });
    }
}