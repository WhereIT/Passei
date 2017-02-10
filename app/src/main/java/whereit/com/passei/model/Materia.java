package whereit.com.passei.model;

/**
 * Created by leani on 10/02/2017.
 */

public class Materia {

    private int id;
    private int semestre;
    private String materia;
    private String professor;
    private String bibliografia;
    private String situacao;
    private boolean dp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public boolean isDp() {
        return dp;
    }

    public void setDp(boolean dp) {
        this.dp = dp;
    }




}
