package Controller;

import Model.Aluno;
import Model.Endereco;
import Model.Responsavel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponsavelControllerTest {

    private ResponsavelController responsavelController;
    private Endereco enderecoPadrao;

    @BeforeEach
    void setUp() {
        responsavelController = new ResponsavelController();
        enderecoPadrao = new Endereco("Av. Família", "Lar Doce Lar", "55555-000", "Cidade", "TS");
    }

    @Test
    @DisplayName("Deve cadastrar um novo responsável")
    void deveCadastrarResponsavel() {
        responsavelController.cadastrar("Sr. José", "01/01/1980", enderecoPadrao, "75988887777");
        assertEquals(1, responsavelController.listarTodos().size());
    }

    @Test
    @DisplayName("Deve associar um aluno a um responsável existente")
    void deveAssociarAluno() {
        Responsavel responsavel = responsavelController.cadastrar("Sra. Joana", "06/06/1986", enderecoPadrao, "11223-34455");
        Aluno aluno = new Aluno("Mariana", "05/05/2016", enderecoPadrao, "Cidade");

        responsavelController.associarAluno(responsavel, aluno);

        assertNotNull(responsavel);
        assertNotNull(aluno);
        assertEquals(1, responsavel.getDependentes().size());
        assertTrue(responsavel.getDependentes().contains(aluno));
        assertEquals("Sra. Joana", aluno.getResponsavel().getNome());
    }

    @Test
    @DisplayName("Deve buscar um responsável pelo nome")
    void deveBuscarResponsavelPeloNome() {
        responsavelController.cadastrar("Sra. Marta", "02/02/1982", enderecoPadrao, "75977776666");
        Responsavel encontrado = responsavelController.buscarPorNome("Sra. Marta");
        assertNotNull(encontrado);
        assertEquals("75977776666", encontrado.getTelefone());
    }
}