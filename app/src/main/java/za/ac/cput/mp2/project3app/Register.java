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

public class Register extends AppCompatActivity {

    Database db;
    TextView btn1;
    Button regbtn;
    EditText name;
    EditText num;
    EditText pass;
    EditText confpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Database(this);
        btn1 = findViewById(R.id.btn1);
        regbtn = findViewById(R.id.Reg);
        name = findViewById(R.id.name);
        num = findViewById(R.id.num);
        pass = findViewById(R.id.Pass);
        confpassword = findViewById(R.id.ConfirmPass);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String confirmpassword = confpassword.getText().toString().trim();
                String number = num.getText().toString().trim();

                if(user.isEmpty()||password.isEmpty()||confirmpassword.isEmpty()||number.isEmpty()){
                    Toast.makeText(Register.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else if (password.equals(confirmpassword)) {
                    long val = db.addUser(user, password, number);
                    if (val > 0) {

                        Toast.makeText(Register.this, "You have successfully registered", Toast.LENGTH_SHORT).show();

                        Intent R = new Intent(Register.this, Login.class);
                        startActivity(R);
                        //finish();
                    }

                } else {

                    Toast.makeText(Register.this, "Password does not match", Toast.LENGTH_SHORT).show();

                }

            }

        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent R = new Intent(Register.this, Login.class);
                startActivity(R);

                finish();
            }
        });
    }
}