package ukdw.com.progmob_2020.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ukdw.com.progmob_2020.R;

public class MainDsnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dsn);

        //Button
        Button btnGetDosen =(Button)findViewById(R.id.buttonGetDsn);
        Button btnAddDosen = (Button)findViewById(R.id.buttonAddDsn);
        Button btnHps = (Button)findViewById(R.id.buttonDelDsn);
        Button btnUpdate = (Button)findViewById(R.id.buttonUpdDsn);

        //Action
        btnGetDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenGetAllActivity.class);
                startActivity(intent);
            }
        });
        btnHps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenDeleteActivity.class);
                startActivity(intent);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenUpdateActivity.class);
                startActivity(intent);
            }
        });

        btnAddDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenAddActivity.class);
                startActivity(intent);
            }
        });
    }
}