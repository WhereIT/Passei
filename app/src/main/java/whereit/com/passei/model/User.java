package whereit.com.passei.model;

/**
 * Created by Desenvolvimento on 01/02/17.
 */

public class User {

    private int ID;
    private String user;
    private String curso;

    public User(int id, String user, String curso) {
        this.ID = id;
        this.user = user;
        this.curso = curso;
    }

    public User(String user, String curso) {
        this.user = user;
        this.curso = curso;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


}
