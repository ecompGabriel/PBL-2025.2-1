package Model;

import java.util.ArrayList;
import java.util.List;

public class Responsavel extends Pessoa {
    private String telefone;
    private List<Aluno> dependentes;

    public Responsavel(String nome, String dataNascimento, Endereco endereco, String telefone) {
        super(nome, dataNascimento, endereco);
        this.telefone = telefone;
        this.dependentes = new ArrayList<>();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Aluno> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Aluno> dependentes) {
        this.dependentes = dependentes;
    }
}