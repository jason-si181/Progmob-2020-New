package ukdw.com.progmob_2020.Crud;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.progmob_2020.Model.DefaultResult;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class MahasiswaUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);
        final EditText edNamaBaru = (EditText)findViewById(R.id.editNamaBr);
        final EditText edNimBaru = (EditText)findViewById(R.id.editNimBr);
        final EditText edAlamatBaru = (EditText)findViewById(R.id.editAlamatbr);
        final EditText edEmail = (EditText)findViewById(R.id.editEmailbr);
        Button btnUbah = (Button)findViewById(R.id.buttonUbah);
        pd = new ProgressDialog(MahasiswaUpdateActivity.this);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Tunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mhs(
                        edNamaBaru.getText().toString(),
                        edNimBaru.getText().toString(),
                        edAlamatBaru.getText().toString(),
                        edEmail.getText().toString(),
                        "kosongkan saja diisi sembarang karena dirandom sistem",
                        "72180181"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Data berhasil diubah", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}