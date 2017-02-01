package whereit.com.passei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.jaredrummler.materialspinner.MaterialSpinner;

import whereit.com.passei.util.AlertUtil;

public class AddCursoActivity extends AppCompatActivity {
    Toolbar toolbar;
    MaterialSpinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_curso);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Selecionar Curso");
        setSupportActionBar(toolbar);
        int id = getIntent().getIntExtra("user_id", 0);

        String cursos[] = new String[]{"Fabricação Mecânica","Gestão Empresarial", "Informática para Negócios", "Logística", "Polímeros"};
        spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems(cursos);
    }
}
