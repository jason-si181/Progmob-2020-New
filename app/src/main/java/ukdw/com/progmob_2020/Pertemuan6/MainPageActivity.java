package ukdw.com.progmob_2020.Pertemuan6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ukdw.com.progmob_2020.R;

public class MainPageActivity extends AppCompatActivity {
    private Button btnLogout;
    TextView txtPengguna;
    String resultNama;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        SharedPreferences pref = MainPageActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        Button btnMatkul = (Button)findViewById(R.id.btnMatkul);
        Button btnDosen = (Button)findViewById(R.id.btnDsn);
        Button btnMhs = (Button)findViewById(R.id.btnMhs);
        Bundle extras = getIntent().getExtras();
        if (extras !=null)
            resultNama = extras.getString("result_nama");
        txtPengguna.setText(resultNama);

        Button btnLogout = (Button)findViewById(R.id.btnLogOut);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    //BUAT KELUAR - YES DAN NO
    private void showDialog(){
        AlertDialog.Builder pemberitahuan = new AlertDialog.Builder(this);
        pemberitahuan.setTitle("Keluar dari menu?");
        pemberitahuan
                .setMessage("Tekan Ya untuk Keluar")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(MainPageActivity.this, PrefActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = pemberitahuan.create();
        alertDialog.show();
    }
    private void initComponents(){
        txtPengguna = (TextView) findViewById(R.id.txtJdl);
    }
}