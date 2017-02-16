package whereit.com.passei.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.Build;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import whereit.com.passei.R;
import whereit.com.passei.model.Materia;

/**
 * Created by leani on 15/02/2017.
 */

public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.MateriaViewHolder> {

    private List<Materia> mDataSet;
    Context context;
    public MateriaAdapter(List<Materia> mDataSet, Context c) {

        this.mDataSet = mDataSet;
        context = c;
    }

    @Override
    public MateriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_materias,parent,false);
        MateriaViewHolder vh = new MateriaViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final MateriaViewHolder holder, int position) {
        holder.materiaTextView.setText(mDataSet.get(position).getMateria());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            holder.materiaLinearLayout.setBackgroundColor(context.getColor(mDataSet.get(position).getCor()));
        }
        else
        {
            holder.materiaLinearLayout.setBackgroundColor(context.getResources().getColor(mDataSet.get(position).getCor()));
        }

        holder.imgMnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context,holder.imgMnu);
                popup.inflate(R.menu.menu_materias);
                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class MateriaViewHolder extends RecyclerView.ViewHolder {
        private TextView materiaTextView;
        private LinearLayout materiaLinearLayout;
        private ImageView imgMnu;

        public MateriaViewHolder(View itemView) {
            super(itemView);
            materiaTextView = (TextView) itemView.findViewById(R.id.rv_txt_materias);
            materiaLinearLayout = (LinearLayout) itemView.findViewById(R.id.rv_ll_materias);
            imgMnu = (ImageView) itemView.findViewById(R.id.img_more);
        }
    }
}
