package Model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private Responsavel responsavel;
    private Professor professorPai;
    private List<Turma> turmas;
    private List<Boletim> boletins;
    private String naturalidade;

    public Aluno(String nome, String dataNascimento, Endereco endereco, String naturalidade) {
        super(nome, dataNascimento, endereco);
        this.turmas = new ArrayList<>();
        this.boletins = new ArrayList<>();
        this.naturalidade = naturalidade;
        this.responsavel = null;
        this.professorPai = null;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Professor getProfessorPai() {
        return professorPai;
    }

    public void setProfessorPai(Professor professorPai) {
        this.professorPai = professorPai;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Boletim> getBoletins() {
        return boletins;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
}