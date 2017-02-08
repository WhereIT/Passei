package whereit.com.passei.adapter;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import whereit.com.passei.interfaces.RecyclerViewOnClickListenerHack;
import whereit.com.passei.model.Semestre;
import whereit.com.passei.R;

/**
 * Created by leani on 06/02/2017.
 */

public class SemestreAdapter extends RecyclerView.Adapter<SemestreAdapter.SemestresViewHolder>{
    private List<Semestre> myDataset;
    private  RecyclerViewOnClickListenerHack recyclerViewOnClickListenerHack;


    public SemestreAdapter( List<Semestre> dataset) {
        this.myDataset = dataset;
    }


    @Override
    public SemestresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_semestres, parent, false);
        SemestresViewHolder vh = new SemestresViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(SemestresViewHolder holder, int position) {
        holder.idTextView.setText(String.valueOf(myDataset.get(position).getSemestre()) + "º");

    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        this.recyclerViewOnClickListenerHack = r;
    }

    @Override
    public int getItemCount() {

        return myDataset.size();

    }




    public class SemestresViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView idTextView;

        public SemestresViewHolder(View itemView) {
            super(itemView);
            idTextView = (TextView) itemView.findViewById(R.id.rv_id);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(recyclerViewOnClickListenerHack != null){
                recyclerViewOnClickListenerHack.onClickListener(v, getAdapterPosition());
            }
        }
    }

}
