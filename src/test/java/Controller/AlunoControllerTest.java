package Controller;

import Model.Aluno;
import Model.Endereco;
import Model.Professor;
import Model.Responsavel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoControllerTest {

    private AlunoController alunoController;
    private Endereco enderecoPadrao;
    private Responsavel responsavelPadrao;
    private Professor professorPadrao;

    @BeforeEach
    void setUp() {
        alunoController = new AlunoController();
        enderecoPadrao = new Endereco("Rua Teste", "Bairro", "12345-000", "Cidade", "TS");
        responsavelPadrao = new Responsavel("Joana Responsável", "01/01/1980", enderecoPadrao, "11111-1111");
        professorPadrao = new Professor("Prof. Carlos", "02/02/1982", enderecoPadrao, "História", "22222-2222");
    }

    @Test
    @DisplayName("Deve cadastrar um novo aluno")
    void deveCadastrarNovoAluno() {
        alunoController.cadastrar("João da Silva", "10/01/2010", enderecoPadrao, "Cidade Natal");
        assertEquals(1, alunoController.listarTodos().size());
    }

    @Test
    @DisplayName("Deve buscar um aluno pelo nome e retornar o primeiro encontrado")
    void deveBuscarAlunoExistentePeloNome() {
        alunoController.cadastrar("Maria Oliveira", "15/05/2011", enderecoPadrao, "Outra Cidade");
        alunoController.cadastrar("Maria Oliveira", "20/06/2012", enderecoPadrao, "Mais uma Cidade");

        Aluno encontrada = alunoController.buscarPorNome("Maria Oliveira");
        assertNotNull(encontrada);
        assertEquals("15/05/2011", encontrada.getDataNascimento()); // Verifica se pegou a primeira
    }

    @Test
    @DisplayName("Deve associar um responsável a um aluno")
    void deveAssociarResponsavel() {
        Aluno aluno = alunoController.cadastrar("Pedro", "01/01/2015", enderecoPadrao, "Cidade");
        alunoController.associarResponsavel(aluno, responsavelPadrao);

        assertEquals("Joana Responsável", aluno.getResponsavel().getNome());
        assertTrue(responsavelPadrao.getDependentes().contains(aluno));
    }

    @Test
    @DisplayName("Deve associar um professor responsável a um aluno")
    void deveAssociarProfessorResponsavel() {
        Aluno aluno = alunoController.cadastrar("Lucas", "02/02/2016", enderecoPadrao, "Cidade");
        alunoController.associarProfessorResponsavel(aluno, professorPadrao);

        assertEquals("Prof. Carlos", aluno.getProfessorPai().getNome());
        assertTrue(professorPadrao.getDependentes().contains(aluno));
    }

    @Test
    @DisplayName("Deve atualizar o primeiro aluno encontrado com o nome")
    void deveAtualizarAluno() {
        alunoController.cadastrar("Carlos Souza", "20/03/2009", enderecoPadrao, "Cidade");
        Endereco novoEndereco = new Endereco("Rua Nova", "Centro", "54321-000", "Cidade Nova", "TS");

        boolean atualizado = alunoController.atualizar("Carlos Souza", "Carlos Souza Lima", "20/03/2009", novoEndereco, "Outra Cidade");

        assertTrue(atualizado);
        assertNotNull(alunoController.buscarPorNome("Carlos Souza Lima"));
        assertNull(alunoController.buscarPorNome("Carlos Souza"));
    }

    @Test
    @DisplayName("Deve excluir o primeiro aluno encontrado com o nome")
    void deveExcluirAluno() {
        alunoController.cadastrar("Ana Costa", "01/02/2012", enderecoPadrao, "Cidade");
        boolean excluido = alunoController.excluir("Ana Costa");

        assertTrue(excluido);
        assertEquals(0, alunoController.listarTodos().size());
    }
}