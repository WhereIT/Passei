package whereit.com.passei.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Desenvolvimento on 02/02/17.
 */

public class JSONUtil {

    public static ArrayList<String> loadJSON(Context c, String fileName, String tag, String child){
        String json = null;
        ArrayList<String> data;
        try {
            InputStream inputStream = c.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }

        try{
            JSONObject obj = new JSONObject(json);
            JSONArray jArray = obj.getJSONArray(tag);
            data = new ArrayList<String>();

            for (int i = 0; i< jArray.length(); i++){
                JSONObject jInside = jArray.getJSONObject(i);
                data.add(jInside.getString(child));
            }
        }
        catch (JSONException e){
            e.printStackTrace();
            return null;
        }


        return data;

    }

}
