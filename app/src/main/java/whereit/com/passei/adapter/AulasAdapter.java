package whereit.com.passei.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import whereit.com.passei.model.Aulas;
import whereit.com.passei.R;

/**
 * Created by leani on 18/02/2017.
 */

public class AulasAdapter extends RecyclerView.Adapter<AulasAdapter.AulasViewHolder>{

    private List<Aulas> mDataset;
    Context context;

    public AulasAdapter(List<Aulas> mDataset,Context context) {
        this.context = context;
        this.mDataset = mDataset;
    }

    @Override
    public AulasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_aulas,parent,false);
        AulasViewHolder vh = new AulasViewHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(AulasViewHolder holder, int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            holder.layoutH.setBackgroundColor(context.getColor(mDataset.get(position).getMateria().getCor()));
        }
        else
        {
            holder.layoutH.setBackgroundColor(context.getResources().getColor(mDataset.get(position).getMateria().getCor()));
        }
        holder.horaRestante.setText(mDataset.get(position).getHorasRestantes());
        holder.materia.setText(mDataset.get(position).getMateria().getMateria());
        holder.professor.setText( mDataset.get(position).getMateria().getProfessor());
        holder.aulaHora.setText(mDataset.get(position).getHoraI() + " - " + mDataset.get(position).getHoraF());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class AulasViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layoutH;
        TextView horaRestante, materia,professor,aulaHora;
        public AulasViewHolder(View itemView) {
            super(itemView);
            layoutH = (RelativeLayout) itemView.findViewById(R.id.layout_hour);
            horaRestante = (TextView) itemView.findViewById(R.id.txt_hora);
            materia = (TextView) itemView.findViewById(R.id.txt_aula_materia);
            professor = (TextView) itemView.findViewById(R.id.txt_aula_professor);
            aulaHora = (TextView) itemView.findViewById(R.id.txt_aula_hora);

        }
    }
}
