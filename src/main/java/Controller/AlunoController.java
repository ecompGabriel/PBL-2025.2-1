package Controller;

import Model.Aluno;
import Model.Endereco;
import Model.Professor;
import Model.Responsavel;
import java.util.ArrayList;
import java.util.List;

public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>();

    public Aluno cadastrar(String nome, String dataNascimento, Endereco endereco, String naturalidade) {
        Aluno aluno = new Aluno(nome, dataNascimento, endereco, naturalidade);
        this.alunos.add(aluno);
        return aluno;
    }

    public List<Aluno> listarTodos() {
        return new ArrayList<>(this.alunos);
    }

    public Aluno buscarPorNome(String nome) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public void associarResponsavel(Aluno aluno, Responsavel responsavel) {
        if (aluno != null && responsavel != null) {
            aluno.setResponsavel(responsavel);
            if (!responsavel.getDependentes().contains(aluno)) {
                responsavel.getDependentes().add(aluno);
            }
        }
    }

    public void associarProfessorResponsavel(Aluno aluno, Professor professor) {
        if (aluno != null && professor != null) {
            aluno.setProfessorPai(professor);
            if (!professor.getDependentes().contains(aluno)) {
                professor.getDependentes().add(aluno);
            }
        }
    }

    public boolean atualizar(String nomeParaBuscar, String novoNome, String novaDataNascimento, Endereco novoEndereco, String novaNaturalidade) {
        Aluno alunoParaAtualizar = buscarPorNome(nomeParaBuscar);
        if (alunoParaAtualizar != null) {
            alunoParaAtualizar.setNome(novoNome);
            alunoParaAtualizar.setDataNascimento(novaDataNascimento);
            alunoParaAtualizar.setEndereco(novoEndereco);
            alunoParaAtualizar.setNaturalidade(novaNaturalidade);
            return true;
        }
        return false;
    }

    public boolean excluir(String nome) {
        Aluno alunoParaExcluir = buscarPorNome(nome);
        if (alunoParaExcluir != null) {
            this.alunos.remove(alunoParaExcluir);
            return true;
        }
        return false;
    }
}