package jwangsadinata.github.io.stayintouch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPassword.getText().toString().equals(getString(R.string.password_login))) {
                    Intent intentMainMenu = new Intent();
                    intentMainMenu.setClass(LoginActivity.this, MainActivity.class);
                    intentMainMenu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentMainMenu);
                    finish();
                } else if (etPassword.getText().toString().equals("")) {
                    etPassword.setError(getString(R.string.emptypassword_login));
                } else {
                    etPassword.setError(getString(R.string.wrongpassword_login));
                }
            }
        });
    }
}
