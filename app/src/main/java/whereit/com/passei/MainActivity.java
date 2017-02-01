package whereit.com.passei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import whereit.com.passei.data.UserModel;
import whereit.com.passei.model.User;
import whereit.com.passei.util.AlertUtil;

public class MainActivity extends AppCompatActivity {

    EditText userET;
    UserModel userModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userModel = new UserModel(this);
        User user = userModel.select("*", null,"id DESC",null);
        if(user != null){

            Intent intent = new Intent(MainActivity.this, AddCursoActivity.class);
            intent.putExtra("user_id", user.getID());
            intent.putExtra("user_name", user.getUser());
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
            User user = new User(_user, "");
            long id = userModel.insert(user);
            Intent intent = new Intent(MainActivity.this, AddCursoActivity.class);
            intent.putExtra("user_id", (int) id);
            startActivity(intent);
        }
    }
}
