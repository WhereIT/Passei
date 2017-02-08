package whereit.com.passei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import whereit.com.passei.dao.UserModel;
import whereit.com.passei.model.User;
import whereit.com.passei.util.AlertUtil;

public class MainActivity extends AppCompatActivity {

    EditText userET;
    UserModel userModel;

    static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = this;

        userModel = new UserModel(this);
        User user = userModel.select("*", null,"id DESC",null);

        if(user != null){
            Intent intent = new Intent(MainActivity.this, SemestresActivity.class);
            intent.putExtra("user_id", user.getID());
            startActivity(intent);
        }
        else {
            setContentView(R.layout.activity_main);
            userET = (EditText) findViewById(R.id.editUser);
        }

    }

    /**
     *
     * Metódo que realiza o login, chamado ao clicar o botão
     * @param v View button
     */
    public void login(View v){
        String _user = userET.getText().toString();

        if(_user.equals("")){
            AlertUtil.showAlert(MainActivity.this,"Erro!","Preencha o campo usuário para continuar", false);
        }
        else{

            Intent intent = new Intent(MainActivity.this, AddCursoActivity.class);
            intent.putExtra("user_name", _user);
            startActivity(intent);
        }
    }

    public static MainActivity getInstance(){
        return mainActivity;
    }
}
