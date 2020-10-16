package ukdw.com.progmob_2020.Pertemuan4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import ukdw.com.progmob_2020.Adapter.DebuggingRecyclerAdapter;
import ukdw.com.progmob_2020.Model.MahasiswaDebugging;
import ukdw.com.progmob_2020.R;

public class DebuggingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugging);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvDebug);
        DebuggingRecyclerAdapter mahasiswaRecyclerAdapter;

        //data dummy
        List<MahasiswaDebugging> mahasiswaList = new ArrayList<MahasiswaDebugging>();

        //generate data mahasiswa
        MahasiswaDebugging m1 = new MahasiswaDebugging("Argo","72110101","084646464646");
        MahasiswaDebugging m2 = new MahasiswaDebugging("Halim","72110101","084646464646");
        MahasiswaDebugging m3 = new MahasiswaDebugging("Jong Jek Siang","72110101","084646464646");
        MahasiswaDebugging m4 = new MahasiswaDebugging("Katon","72110101","084646464646");
        MahasiswaDebugging m5 = new MahasiswaDebugging("Yetli","72110101","084646464646");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);
        
        mahasiswaRecyclerAdapter = new DebuggingRecyclerAdapter(DebuggingActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(DebuggingActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);
    }
}
