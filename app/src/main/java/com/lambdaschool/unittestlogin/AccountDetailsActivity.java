package com.lambdaschool.unittestlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccountDetailsActivity extends AppCompatActivity {

    TextView userNameView, animalView, displayNameView, emailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        User user = (User) getIntent().getSerializableExtra(User.TAG);

        userNameView = findViewById(R.id.text_username);
        userNameView.setText(user.getUsername());

        animalView = findViewById(R.id.text_favorite_animal);
        animalView.setText(user.getFavoriteAnimal());

        displayNameView = findViewById(R.id.text_display_name);
        displayNameView.setText(user.getDisplayName());

        emailView = findViewById(R.id.text_email);
        emailView.setText(user.getEmail());
    }
}
