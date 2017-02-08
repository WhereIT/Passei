package whereit.com.passei.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import whereit.com.passei.R;

/**
 * Created by leani on 06/02/2017.
 */

public class SemestresViewHolder extends RecyclerView.ViewHolder {

    public TextView idTextView;
    public SemestresViewHolder(View itemView) {
        super(itemView);
        idTextView = (TextView) itemView.findViewById(R.id.rv_id);


    }
}
