package Model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    private String formacao;
    private String telefone;
    private List<Turma> turmas;
    private List<Aluno> dependentes;

    public Professor(String nome, String dataNascimento, Endereco endereco, String formacao, String telefone) {
        super(nome, dataNascimento, endereco);
        this.formacao = formacao;
        this.telefone = telefone;
        this.turmas = new ArrayList<>();
        this.dependentes = new ArrayList<>();
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Aluno> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Aluno> dependentes) {
        this.dependentes = dependentes;
    }
}