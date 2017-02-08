package whereit.com.passei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.List;

import whereit.com.passei.dao.SemestreModel;
import whereit.com.passei.dao.UserModel;
import whereit.com.passei.model.Semestre;
import whereit.com.passei.model.User;
import whereit.com.passei.util.JSONUtil;

public class AddCursoActivity extends AppCompatActivity {
    Toolbar toolbar;
    MaterialSpinner spinner;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userModel = new UserModel(this);
        User user = userModel.select("*",null, null, null);
        int userId;
        try {
            userId = user.getID();
        }
        catch (Exception e){
            userId = 0;
        }
        Log.i("Curso", ""+ userId);

        if(userId == 0){

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
        String name = getIntent().getStringExtra("user_name");
        User user = new User(name, curso);
        UserModel userModel = new UserModel(AddCursoActivity.this);
        long id = userModel.insert(user);
        SemestreModel semestreModel = new SemestreModel(this);
        for(int i = 1; i<=6; i++){
            Semestre semestre = new Semestre(i,(int)id);
            semestreModel.insert(semestre);

        }
        Intent intent = new Intent(AddCursoActivity.this, SemestresActivity.class);
        intent.putExtra("user_id", id);
        startActivity(intent);
        finish();
    }

}
