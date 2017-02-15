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

import whereit.com.passei.adapter.MateriaAdapter;
import whereit.com.passei.model.Materia;
import whereit.com.passei.util.DateUtil;

public class DiarioActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView today;

    private RecyclerView mRecyclerView;
    private MateriaAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Materia> mDataSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario);

        int semestre = getIntent().getIntExtra("semestre_id",0);
        int userID = getIntent().getIntExtra("user_id",0);

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
        mAdapter = new MateriaAdapter(mDataSet);
        mRecyclerView.setAdapter(mAdapter);

    }


    private List<Materia> getMaterias(){
        List<Materia> materiasList = new ArrayList<>();
        String[] materias = {"Contabilidade","Marketing", "Linguagem de Programação 1", "Ética","Matematica Financeira"};
        int[] cores = {R.color.deep_orange,R.color.amber,R.color.grey,R.color.brown,R.color.red};
        for(int i = 0 ; i < materias.length - 1; i++){
            Materia materia = new Materia();
            materia.setMateria(materias[i]);
            materia.setCor(cores[i]);
            materiasList.add(materia);
        }
        return materiasList;
    }
}
