package whereit.com.passei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import whereit.com.passei.adapter.AulasAdapter;
import whereit.com.passei.adapter.MateriaAdapter;
import whereit.com.passei.model.Aulas;
import whereit.com.passei.model.Materia;
import whereit.com.passei.util.DateUtil;

public class DiarioActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView today;

    private RecyclerView mRecyclerView, aRecyclerView;
    private MateriaAdapter mAdapter;
    private AulasAdapter aAdapter;
    private RecyclerView.LayoutManager mLayoutManager,aLayoutManager;
    private List<Materia> mDataSet;
    private List<Aulas> aDataSet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario);

        int semestre = getIntent().getIntExtra("semestre_id", 0);
        int userID = getIntent().getIntExtra("user_id", 0);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(semestre + "º Semestre");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        today = (TextView) findViewById(R.id.txtToday);
        DateUtil date = new DateUtil();
        today.setText(date.getToday());


        mRecyclerView = (RecyclerView) findViewById(R.id.materias_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDataSet = getMaterias();
        mAdapter = new MateriaAdapter(mDataSet, this);
        mRecyclerView.setAdapter(mAdapter);

        aRecyclerView = (RecyclerView) findViewById(R.id.aulas_recyclerview);
        aRecyclerView.setHasFixedSize(true);
        aLayoutManager = new LinearLayoutManager(this);
        aRecyclerView.setLayoutManager(aLayoutManager);
        aDataSet = getAulas();
        aAdapter = new AulasAdapter(aDataSet,this);
        aRecyclerView.setAdapter(aAdapter);


    }




    private List<Materia> getMaterias() {
        List<Materia> materiasList = new ArrayList<>();
        String[] materias = {"Contabilidade", "Marketing", "Linguagem de Programação 1", "Ética", "Matematica Financeira"};
        int[] cores = {R.color.deep_orange, R.color.amber, R.color.lime, R.color.brown, R.color.red};
        for (int i = 0; i < materias.length; i++) {
            Materia materia = new Materia();
            materia.setMateria(materias[i]);
            materia.setCor(cores[i]);
            materiasList.add(materia);
        }
        return materiasList;
    }

    private List<Aulas> getAulas(){
        List<Aulas> aulasList = new ArrayList<>();
        String[] materias = {"Contabilidade", "Marketing"};
        String[] professor = {"Adilson", "Andreia"};
        int[] cores = {R.color.deep_orange, R.color.amber};
        String[] horaI = {"19h00", "21h00"};
        String[] horaF = {"20h40", "22h30"};
        String[] horaR = {"1h00", "3h00"};
        for (int i = 0; i < materias.length; i++) {
            Materia materia = new Materia();
            materia.setMateria(materias[i]);
            materia.setCor(cores[i]);
            materia.setProfessor(professor[i]);
            Aulas aula = new Aulas();
            aula.setHoraI(horaI[i]);
            aula.setHoraF(horaF[i]);
            aula.setHorasRestantes(horaR[i]);
            aula.setMateria(materia);
            aulasList.add(aula);
        }

        return aulasList;
    }
}
