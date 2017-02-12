package nyc.c4q.hyun.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button submitBtn;
    private TextView userName, password;
    private int userLength, passLength;
    private final String toastUser = "user", toastPass = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

    }

    private void initViews() {
        submitBtn = (Button) findViewById(R.id.submitTV);
        submitBtn.setOnClickListener(LoginActivity.this);
        userName = (TextView) findViewById(R.id.usernameTV);
        password = (TextView) findViewById(R.id.passwordTV);
    }


    @Override
    public void onClick(View v) {

        passLength = password.getText().length();
        userLength = userName.getText().length();

        switch (v.getId()) {
            case R.id.submitTV:
                if (userLength > 1 && passLength > 1) {
                    Intent mainScreen = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(mainScreen);
                } else if (userLength <= 0) {
                    toaster(toastUser);
                    break;
                } else if (passLength <= 0) {
                    toaster(toastPass);
                    break;
                }
                break;
        }
    }

    public void toaster(String user) {
        if (user.equals("user")) {
            Toast.makeText(getApplicationContext(), "Enter a Username", Toast.LENGTH_SHORT).show();
        } else if(user.equals("pass")){
            Toast.makeText(getApplicationContext(), "Enter a password", Toast.LENGTH_SHORT).show();
        }
    }
}
