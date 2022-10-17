package za.ac.cput.mp2.project3app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public static final String EXTRA_TEXT = "za.ac.cput.mp2.project3app.EXTRA_TEXT";
    Database db;
    TextView btn;
    Button btnLogin;
    EditText name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Database(this);
        btn = findViewById(R.id.btn);
        btnLogin = findViewById(R.id.btnLogin);
        name = findViewById(R.id.Name);
        password = findViewById(R.id.Password);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(Login.this, Register.class);
                startActivity(R);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = name.getText().toString().trim();
                String pass = password.getText().toString().trim();

                Boolean chk = db.checkUser(user, pass);

                if(user.isEmpty()||pass.isEmpty()){
                    Toast.makeText(Login.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                }

                else if (chk == true)
                {
                    Toast.makeText(Login.this, "You have logged in successfully", Toast.LENGTH_SHORT).show();
                    Intent R = new Intent(Login.this, Home.class);

                    //send username to home page
                    R.putExtra(EXTRA_TEXT, user);

                    startActivity(R);
                }
                else{
                    Toast.makeText(Login.this, "Please enter correct login details", Toast.LENGTH_SHORT).show();
                }


                //finish();
            }
        });
    }

}