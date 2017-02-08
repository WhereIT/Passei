package whereit.com.passei.model;

/**
 * Created by leani on 04/02/2017.
 */

public class Semestre {

    private int semestre;
    private int userId;

    public Semestre(int semestre, int user) {
        this.semestre = semestre;
        this.userId = user;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user) {
        this.userId = user;
    }
}
