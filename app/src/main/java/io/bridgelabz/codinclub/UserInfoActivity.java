package io.bridgelabz.codinclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserInfoActivity extends AppCompatActivity {

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_part_1);
        submitButton=findViewById(R.id.button_otp_verify);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboardIntent=new Intent(UserInfoActivity.this,DashboardActivity.class);
                startActivity(dashboardIntent);
            }
        });
    }
}