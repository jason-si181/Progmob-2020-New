package ukdw.com.progmob_2020.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class DosenDeleteActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_delete);

        EditText txDelD = (EditText)findViewById(R.id.editNikHps);
        Button btnHapus = (Button)findViewById(R.id.buttonHapus);

        pd = new ProgressDialog(DosenDeleteActivity.this);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Now Loading");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_dsn(
                        txDelD.getText().toString(),"72180247"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenDeleteActivity.this, "Data Terhapus", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenDeleteActivity.this, "Eror Data E", Toast.LENGTH_LONG).show();
                    }
                });
                Intent intentBalikDosen = new Intent(DosenDeleteActivity.this, MainDsnActivity.class);
                startActivity(intentBalikDosen);
            }
        });
    }
}