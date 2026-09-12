package Model;

import java.util.List;
import java.util.ArrayList;

public class Turma {
    private String serie;
    private int anoLetivo;
    private Professor professorRegente;
    private List<Aluno> alunos;
    private List<Boletim> boletins;

    public Turma(String serie, int anoLetivo, Professor professorRegente) {
        this.serie = serie;
        this.anoLetivo = anoLetivo;
        this.professorRegente = professorRegente;
        this.alunos = new ArrayList<>();
        this.boletins = new ArrayList<>();
    }

    // Getters e Setters
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Professor getProfessorRegente() {
        return professorRegente;
    }

    public void setProfessorRegente(Professor professorRegente) {
        this.professorRegente = professorRegente;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Boletim> getBoletins() {
        return boletins;
    }

    public void setBoletins(List<Boletim> boletins) {
        this.boletins = boletins;
    }
}