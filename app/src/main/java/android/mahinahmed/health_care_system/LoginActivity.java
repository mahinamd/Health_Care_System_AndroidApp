package android.mahinahmed.health_care_system;

import android.content.Intent;
import android.content.SharedPreferences;
import android.mahinahmed.health_care_system.MainActivity;
import android.mahinahmed.health_care_system.R;
import android.mahinahmed.health_care_system.RegistrationActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private CheckBox rememberMeCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        rememberMeCheckBox = findViewById(R.id.rememberLoginCheckBox);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();


                if (isValidLogin(email, password)) {
                    if (rememberMeCheckBox.isChecked()) {
                        saveLoginCredentials(email, password);
                    }
                    launchMainActivity();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView registerTextView = findViewById(R.id.registerTextView);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        if (isSavedLoginCredentialsExist()) {
            launchMainActivity();
        }
    }

    private boolean isValidLogin(String email, String password) {
        // Instantiate the UserDatabaseHelper
        KeyDBValue databaseHelper = new KeyDBValue(this);

        // Check if the email and password are valid
        // by querying the database for a matching user
        return databaseHelper.checkUser(email, password);
    }

    private void saveLoginCredentials(String email, String password) {
        SharedPreferences preferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }

    private boolean isSavedLoginCredentialsExist() {
        SharedPreferences preferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        String email = preferences.getString("email", "");
        String password = preferences.getString("password", "");
        return !email.isEmpty() && !password.isEmpty();
    }

    private void launchMainActivity() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish(); // Remove this activity from the back stack so the user can't go back to it
    }
}
