package com.lambdaschool.unittestlogin;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lambdaschool.unittestlogin.util.EmailValidator;

public class MainActivity extends AppCompatActivity {


    public static final String MOCKED_EMAIL = "student@lambdaschool.com";
    public static final String MOCKED_PASSWORD = "password";

    EditText inputEmail, inputPassword;
    public Snackbar snackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);

        snackBar = Snackbar.make(findViewById(R.id.login_parent), "Login successful", Snackbar.LENGTH_INDEFINITE);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    void doLogin() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(EmailValidator.isValidEmail(inputEmail.getText())) {
                    // check credentials against server
                    if(inputEmail.getText().equals(MOCKED_EMAIL) &&
                       inputEmail.getText().equals(MOCKED_PASSWORD)) {
                        snackBar.show();
                    }
                }
            }
        }, 2000);
    }
}
