package whereit.com.passei.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import whereit.com.passei.R;
import whereit.com.passei.model.Materia;

/**
 * Created by leani on 15/02/2017.
 */

public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.MateriaViewHolder> {

    private List<Materia> mDataSet;

    public MateriaAdapter(List<Materia> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public MateriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_materias,parent,false);
        MateriaViewHolder vh = new MateriaViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MateriaViewHolder holder, int position) {
        holder.materiaTextView.setText(mDataSet.get(position).getMateria());
        holder.materiaLinearLayout.setBackgroundColor(mDataSet.get(position).getCor());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class MateriaViewHolder extends RecyclerView.ViewHolder {
        private TextView materiaTextView;
        private LinearLayout materiaLinearLayout;

        public MateriaViewHolder(View itemView) {
            super(itemView);
            materiaTextView = (TextView) itemView.findViewById(R.id.rv_txt_materias);
            materiaLinearLayout = (LinearLayout) itemView.findViewById(R.id.rv_ll_materias);
        }
    }
}
