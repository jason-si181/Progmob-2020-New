package ukdw.com.progmob_2020.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ukdw.com.progmob_2020.Model.Dosen;
import ukdw.com.progmob_2020.R;

public class DosenCRUDRecyclerAdapter extends RecyclerView.Adapter<DosenCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Dosen> dosenList;

    public DosenCRUDRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();
    }

    public DosenCRUDRecyclerAdapter(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_dosen, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dosen m = dosenList.get(position);

        holder.tvNama.setText(m.getNama());
        holder.tvNik.setText(m.getNik());
        holder.tvAlamat.setText(m.getAlamat());
        holder.tvEmail.setText(m.getEmail());
        holder.dosen = m;
    }

    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNik, tvNoTelp, tvAlamat, tvEmail;
        private RecyclerView rxGetDosen;
        Dosen dosen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNik = itemView.findViewById(R.id.tvNik);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            rxGetDosen = itemView.findViewById(R.id.rvGetDosenAll);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goInput = new Intent(itemView.getContext(), MahasiswaUpdateActivity.class);
                    goInput.putExtra("nik", dosen.getNik());
                    goInput.putExtra("nama", dosen.getNama());
                    goInput.putExtra("alamat", dosen.getAlamat());
                    goInput.putExtra("email", dosen.getEmail());
                    itemView.getContext().startActivity(goInput);
                }
            });
        }
    }
}
