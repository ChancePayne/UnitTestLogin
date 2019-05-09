package com.lambdaschool.unittestlogin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lambdaschool.unittestlogin.util.EmailValidator;

public class MainActivity extends AppCompatActivity {


    public static final String MOCKED_EMAIL    = "student@lambdaschool.com";
    public static final String MOCKED_PASSWORD = "password";

    EditText inputEmail, inputPassword;
    public Snackbar successSnackBar, failureSnackBar;
    public ProgressDialog progressDialog;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");
        successSnackBar = Snackbar.make(findViewById(R.id.login_parent), "Login successful", Snackbar.LENGTH_INDEFINITE);
        failureSnackBar = Snackbar.make(findViewById(R.id.login_parent), "Login failed", Snackbar.LENGTH_INDEFINITE);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    void doLogin() {
        progressDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.hide();
                if (checkLogin(inputEmail.getText().toString(), inputPassword.getText().toString())) {
                    successSnackBar.show();

                    // receive userdata back from server
                    Intent intent = new Intent(getApplicationContext(), AccountDetailsActivity.class);
                    intent.putExtra(User.TAG, new User("Cat", "tester", MOCKED_EMAIL, "first", "last"));
                    startActivity(intent);

                } else {
                    failureSnackBar.show();
                }
            }
        }, 0);
    }

    static boolean checkLogin(String inputEmail, String inputPassword) {
        return EmailValidator.isValidEmail(inputEmail) &&
               inputEmail.equals(MOCKED_EMAIL) &&
               inputPassword.equals(MOCKED_PASSWORD);
    }
}
