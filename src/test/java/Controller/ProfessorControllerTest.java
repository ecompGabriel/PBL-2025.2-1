package Controller;

import Model.Aluno;
import Model.Endereco;
import Model.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorControllerTest {

    private ProfessorController professorController;
    private Endereco enderecoPadrao;

    @BeforeEach
    void setUp() {
        professorController = new ProfessorController();
        enderecoPadrao = new Endereco("Rua dos Professores", "Centro", "98765-000", "Cidade Saber", "TS");
    }

    @Test
    @DisplayName("Deve cadastrar um novo professor")
    void deveCadastrarProfessor() {
        professorController.cadastrar("Prof. Carlos", "15/05/1980", enderecoPadrao, "Matemática", "99999-1111");
        assertEquals(1, professorController.listarTodos().size());
    }

    @Test
    @DisplayName("Deve associar um aluno a um professor existente")
    void deveAssociarAluno() {
        Professor professor = professorController.cadastrar("Prof. Pai", "10/10/1980", enderecoPadrao, "Física", "12345-6789");
        Aluno aluno = new Aluno("Filho do Professor", "01/01/2015", enderecoPadrao, "Cidade");

        professorController.associarAluno(professor, aluno);

        assertNotNull(professor);
        assertNotNull(aluno);
        assertEquals(1, professor.getDependentes().size());
        assertTrue(professor.getDependentes().contains(aluno));
        assertEquals("Prof. Pai", aluno.getProfessorPai().getNome());
    }

    @Test
    @DisplayName("Deve buscar um professor pelo nome")
    void deveBuscarProfessorPeloNome() {
        professorController.cadastrar("Prof. Ana", "20/10/1985", enderecoPadrao, "Português", "99999-2222");
        Professor encontrado = professorController.buscarPorNome("Prof. Ana");
        assertNotNull(encontrado);
        assertEquals("Português", encontrado.getFormacao());
    }
}