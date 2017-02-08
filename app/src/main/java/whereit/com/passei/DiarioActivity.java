package whereit.com.passei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class DiarioActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView today;
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








    }
}
