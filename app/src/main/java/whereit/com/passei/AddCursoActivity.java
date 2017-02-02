package whereit.com.passei;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import whereit.com.passei.data.UserModel;
import whereit.com.passei.model.User;
import whereit.com.passei.util.AlertUtil;
import whereit.com.passei.util.JSONUtil;

public class AddCursoActivity extends AppCompatActivity {
    Toolbar toolbar;
    MaterialSpinner spinner;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = getIntent().getIntExtra("user_id", 0);
        userModel = new UserModel(this);
        User user = userModel.select("*","id = " + id, null, null);
        String userCurso = user.getCurso();
        Log.i("Curso", userCurso);

        if(userCurso.isEmpty()){

            setContentView(R.layout.activity_add_curso);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Selecionar Curso");
            setSupportActionBar(toolbar);
            List<String> data = JSONUtil.loadJSON(this, "cursos.json", "cursos", "curso");
            spinner = (MaterialSpinner) findViewById(R.id.spinner);
            spinner.setItems(data);
        }
        else{
            Intent intent = new Intent(AddCursoActivity.this, SemestresActivity.class);
            intent.putExtra("user_id", user.getID());
            startActivity(intent);
        }

    }

    public void cadastrarCurso(View v){
        String curso = spinner.getItems().get(spinner.getSelectedIndex()).toString();
        int id = getIntent().getIntExtra("user_id", 0);
        Map<String, String> values = new HashMap<String, String>();
        values.put("curso", curso);

        userModel = new UserModel(AddCursoActivity.this);
        userModel.update("id = " + id, values);
        Intent intent = new Intent(AddCursoActivity.this, SemestresActivity.class);
        intent.putExtra("user_id", id);
        startActivity(intent);
    }

}
