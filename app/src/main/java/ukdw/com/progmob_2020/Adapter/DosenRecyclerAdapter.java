package ukdw.com.progmob_2020.Adapter;

import android.content.Context;
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

public class DosenRecyclerAdapter extends RecyclerView.Adapter<DosenRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Dosen> dosenList;

    public DosenRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();
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
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dosen m = dosenList.get(position);
        holder.txtNama.setText(m.getNama());
        holder.txtNoTelp.setText(m.getNotelp());
        holder.txtNik.setText(m.getNik());
    }

    @Override
    public int getItemCount() {
        return dosenList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNik, txtNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.tvNama);
            txtNik  = itemView.findViewById(R.id.tvNik);
            txtNoTelp = itemView.findViewById(R.id.tvNoTelp);
        }
    }
}
