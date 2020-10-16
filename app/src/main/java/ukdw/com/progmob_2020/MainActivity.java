package ukdw.com.progmob_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ukdw.com.progmob_2020.Pertemuan2.CardViewActivity;
import ukdw.com.progmob_2020.Pertemuan2.ListActivity;
import ukdw.com.progmob_2020.Pertemuan2.RecyclerActivity;
import ukdw.com.progmob_2020.Pertemuan4.DebuggingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable
        final TextView txtView = (TextView)findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button)findViewById(R.id.button1);
        final EditText myEditText = (EditText)findViewById(R.id.editText1);
        Button btnHelp = (Button)findViewById((R.id.btnHelp));
        Button btnTracker = (Button)findViewById(R.id.btnTracker);

        //pertemuan2
        Button btnList = (Button)findViewById((R.id.buttonListView));
        Button btnRecycler = (Button)findViewById((R.id.buttonRecyclerView));
        Button btnCard = (Button)findViewById((R.id.buttonCardView));

        //pertemuan 4
        Button btnDebug = (Button)findViewById(R.id.btnDebugging);

        //action
        txtView.setText(R.string.text_hello_world);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Coba Klik",myEditText.getText().toString());
                txtView.setText(myEditText.getText().toString());
            }
        });
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                Bundle b = new Bundle();

                b.putString("help_string",myEditText.getText().toString());
                intent.putExtras(b);

                startActivity(intent);
            }
        });
        btnTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TrackerActivity.class);
                startActivity(intent);
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(intent);
            }
        });
        btnDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DebuggingActivity.class);
                startActivity(intent);
            }
        });
    }
}