package co.mobiwise.firebasetraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.firebase_signup)
    protected void openSignupActivity() {
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }

    @OnClick(R.id.firebase_login)
    protected void openLoginActivity() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    @OnClick(R.id.firebase_reset_password)
    protected void openResetPasswordActivity() {
        startActivity(new Intent(MainActivity.this, ResetPasswordActivity.class));
    }
}