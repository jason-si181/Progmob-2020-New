package ukdw.com.progmob_2020.Pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ukdw.com.progmob_2020.Adapter.MahasiswaRecyclerAdapter;
import ukdw.com.progmob_2020.Model.Mahasiswa;
import ukdw.com.progmob_2020.R;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView rv = (RecyclerView)findViewById(R.id.cvLatihan);
        MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;

        //data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Jason","72180181","081333696633");
        Mahasiswa m2 = new Mahasiswa("Bambang","72180182","081333698888");
        Mahasiswa m3 = new Mahasiswa("Johan","72180183","081333691111");
        Mahasiswa m4 = new Mahasiswa("Endrico","72180184","081333692222");
        Mahasiswa m5 = new Mahasiswa("Nathan","72180185","081333694444");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);

        mahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(RecyclerActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);
    }
}