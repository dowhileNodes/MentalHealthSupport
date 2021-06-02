package com.example.mvcexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvcexample.Controller.LoginController;
import com.example.mvcexample.Controller.iLoginController;
import com.example.mvcexample.View.iLoginView;

public class MainActivity extends AppCompatActivity implements iLoginView {

    EditText email,password;
    Button loginb;
    iLoginController loginPresenter;
    Button showHidebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        loginb = (Button) findViewById(R.id.loginb);
        showHidebtn = (Button) findViewById(R.id.showHidebtn);
        showHidebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ()
            }
        });{

        }
        loginPresenter = new LoginController(this);

        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });
    }

    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                  