package whereit.com.passei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import whereit.com.passei.adapter.SemestreAdapter;
import whereit.com.passei.dao.SemestreModel;
import whereit.com.passei.interfaces.RecyclerViewOnClickListenerHack;
import whereit.com.passei.model.Semestre;

public class SemestresActivity extends AppCompatActivity implements RecyclerViewOnClickListenerHack{
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SemestreAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Semestre> semestresDataSet;

    int userId;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.getInstance().finish();
        setContentView(R.layout.activity_semestres);

        int userId = getIntent().getIntExtra("user_id",0);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Semestres");
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.semestres_recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        SemestreModel semestreModel = new SemestreModel(this);

        semestresDataSet = semestreModel.select("*", null, null, "6");
        adapter = new SemestreAdapter(semestresDataSet);
        adapter.setRecyclerViewOnClickListenerHack(this);
        recyclerView.setAdapter(adapter);




    }


    @Override
    public void onClickListener(View v, int position) {
        Intent intent = new Intent(SemestresActivity.this, DiarioActivity.class);
        intent.putExtra("semestre_id", position + 1);
        intent.putExtra("user_id", userId);
        startActivity(intent);
    }
}
