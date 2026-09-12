package Controller;

import Model.Responsavel;
import Model.Aluno;
import Model.Endereco;
import java.util.ArrayList;
import java.util.List;

public class ResponsavelController {

    private List<Responsavel> responsaveis = new ArrayList<>();

    public Responsavel cadastrar(String nome, String dataNascimento, Endereco endereco, String telefone) {
        Responsavel responsavel = new Responsavel(nome, dataNascimento, endereco, telefone);
        this.responsaveis.add(responsavel);
        return responsavel;
    }

    public void associarAluno(Responsavel responsavel, Aluno aluno) {
        if (responsavel != null && aluno != null) {
            aluno.setResponsavel(responsavel);
            if (!responsavel.getDependentes().contains(aluno)) {
                responsavel.getDependentes().add(aluno);
            }
        }
    }

    public List<Responsavel> listarTodos() {
        return new ArrayList<>(this.responsaveis);
    }

    public Responsavel buscarPorNome(String nome) {
        for (Responsavel responsavel : this.responsaveis) {
            if (responsavel.getNome().equalsIgnoreCase(nome)) {
                return responsavel;
            }
        }
        return null;
    }

    public boolean atualizar(String nomeParaBuscar, String novoNome, String novaDataNascimento, Endereco novoEndereco, String novoTelefone) {
        Responsavel responsavelParaAtualizar = buscarPorNome(nomeParaBuscar);
        if (responsavelParaAtualizar != null) {
            responsavelParaAtualizar.setNome(novoNome);
            responsavelParaAtualizar.setDataNascimento(novaDataNascimento);
            responsavelParaAtualizar.setEndereco(novoEndereco);
            responsavelParaAtualizar.setTelefone(novoTelefone);
            return true;
        }
        return false;
    }

    public boolean excluir(String nome) {
        Responsavel responsavelParaExcluir = buscarPorNome(nome);
        if (responsavelParaExcluir != null) {
            this.responsaveis.remove(responsavelParaExcluir);
            return true;
        }
        return false;
    }
}