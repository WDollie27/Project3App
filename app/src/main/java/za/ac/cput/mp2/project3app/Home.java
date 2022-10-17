package za.ac.cput.mp2.project3app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {

TextView btn7, btn11, btn15, btnBack, btn16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn7 = findViewById(R.id.btn7);
        btn11 = findViewById(R.id.btn11);
        btn15 = findViewById(R.id.btn15);
        btnBack = findViewById((R.id.btnBack));
        btn16 = findViewById((R.id.btn16));


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(Home.this, Booking.class);
                startActivity(R);
                finish();
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(Home.this, Booking.class);
                startActivity(R);
                finish();
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(Home.this, Booking.class);
                startActivity(R);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(Home.this, Login.class);
                startActivity(R);
                finish();
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(Home.this, Booking.class);
                startActivity(R);
                finish();
            }
        });
    }

    
}