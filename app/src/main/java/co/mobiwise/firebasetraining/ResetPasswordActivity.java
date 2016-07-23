package co.mobiwise.firebasetraining;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.email)
    protected EditText editTextEmail;

    @BindView(R.id.progressBar)
    protected ProgressBar progressBar;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();
    }

    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_reset_password)
    protected void resetPassword() {
        String email = editTextEmail.getText().toString().trim();

        showProgress();

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                dismissProgress();
                if (task.isSuccessful()) {
                    Toast.makeText(ResetPasswordActivity.this, getString(R.string.send_reset_password_email_success_message), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ResetPasswordActivity.this, getString(R.string.send_reset_password_email_error_message), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
