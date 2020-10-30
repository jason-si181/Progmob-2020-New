package ukdw.com.progmob_2020.Crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.progmob_2020.Adapter.DosenCRUDRecyclerAdapter;
import ukdw.com.progmob_2020.Model.Dosen;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class DosenGetAllActivity extends AppCompatActivity {
    RecyclerView rvDosen;
    DosenCRUDRecyclerAdapter dosenAdapter;
    ProgressDialog pd;
    List<Dosen> dosenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_get_all);

        rvDosen = (RecyclerView)findViewById(R.id.rvGetDsnAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Sabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Dosen>> call = service.getDosen("72180181");

        call.enqueue(new Callback<List<Dosen>>() {
            @Override
            public void onResponse(Call<List<Dosen>> call, Response<List<Dosen>> response) {
                pd.dismiss();
                dosenList = response.body();
                dosenAdapter = new DosenCRUDRecyclerAdapter(dosenList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( DosenGetAllActivity.this);
                rvDosen.setLayoutManager(layoutManager);
                rvDosen.setHasFixedSize(true);
                rvDosen.setAdapter(dosenAdapter);

            }

            @Override
            public void onFailure(Call<List<Dosen>> call, Throwable t) {
                Toast.makeText(DosenGetAllActivity.this, "Error",Toast.LENGTH_LONG);
            }
        });
    }
}