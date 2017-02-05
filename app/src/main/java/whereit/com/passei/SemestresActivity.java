package whereit.com.passei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SemestresActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semestres);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public void CarregarSobre(View view){
        Intent intent = new Intent(SemestresActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}
