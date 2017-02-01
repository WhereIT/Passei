package whereit.com.passei.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


/**
 * Created by leani on 23/01/2017.
 */


public class AlertUtil {

    public static boolean showAlert(Context context, String title, String msg, boolean negative){
        final boolean[] res = new boolean[1];
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
               res[0] = true;
            }
        });

        if(negative){
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    res[0] = false;
                }
            });
        }
        AlertDialog dialog = builder.create();
        dialog.show();
        return res[0];
    }


}
