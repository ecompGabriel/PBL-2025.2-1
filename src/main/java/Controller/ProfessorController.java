package Controller;

import Model.Professor;
import Model.Aluno;
import Model.Endereco;
import java.util.ArrayList;
import java.util.List;

public class ProfessorController {

    private List<Professor> professores = new ArrayList<>();

    public Professor cadastrar(String nome, String dataNascimento, Endereco endereco, String formacao, String telefone) {
        Professor professor = new Professor(nome, dataNascimento, endereco, formacao, telefone);
        this.professores.add(professor);
        return professor;
    }

    public void associarAluno(Professor professor, Aluno aluno) {
        if (professor != null && aluno != null) {
            aluno.setProfessorPai(professor);
            if (!professor.getDependentes().contains(aluno)) {
                professor.getDependentes().add(aluno);
            }
        }
    }

    public List<Professor> listarTodos() {
        return new ArrayList<>(this.professores);
    }

    public Professor buscarPorNome(String nome) {
        for (Professor professor : this.professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    public boolean atualizar(String nomeParaBuscar, String novoNome, String novaDataNascimento, Endereco novoEndereco, String novaFormacao, String novoTelefone) {
        Professor professorParaAtualizar = buscarPorNome(nomeParaBuscar);
        if (professorParaAtualizar != null) {
            professorParaAtualizar.setNome(novoNome);
            professorParaAtualizar.setDataNascimento(novaDataNascimento);
            professorParaAtualizar.setEndereco(novoEndereco);
            professorParaAtualizar.setFormacao(novaFormacao);
            professorParaAtualizar.setTelefone(novoTelefone);
            return true;
        }
        return false;
    }

    public boolean excluir(String nome) {
        Professor professorParaExcluir = buscarPorNome(nome);
        if (professorParaExcluir != null) {
            this.professores.remove(professorParaExcluir);
            return true;
        }
        return false;
    }
}