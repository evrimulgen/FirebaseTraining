package co.mobiwise.firebasetraining;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();
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

    @OnClick(R.id.firebase_log_out)
    protected void userLogout() {
        auth.signOut();
    }
}