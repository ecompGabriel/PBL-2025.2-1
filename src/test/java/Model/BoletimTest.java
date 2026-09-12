package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoletimTest {

    private Aluno aluno;
    private Turma turma;

    @BeforeEach
    void setUp() {
        Endereco endereco = new Endereco("Rua", "Bairro", "CEP", "Cidade", "Estado");
        aluno = new Aluno("Aluno Teste", "01/01/2010", endereco, "Brasileira");
        Professor professor = new Professor("Prof Teste", "01/01/1980", endereco, "Licenciatura", "123");
        turma = new Turma("5ª Série", 2025, professor);
    }

    @Test
    void testCalculoMediaAprovado() {
        Boletim boletim = new Boletim(aluno, turma, 2025, 7.0, 8.0, 9.0);
        assertEquals(8.0, boletim.getMedia(), 0.01);
        assertEquals("Aprovado", boletim.getSituacao());
    }

    @Test
    void testCalculoMediaReprovado() {
        Boletim boletim = new Boletim(aluno, turma, 2025, 4.0, 5.0, 5.5);
        assertEquals(4.83, boletim.getMedia(), 0.01);
        assertEquals("Reprovado", boletim.getSituacao());
    }

    @Test
    void testCalculoMediaAprovadoNoLimite() {
        Boletim boletim = new Boletim(aluno, turma, 2025, 6.0, 6.0, 6.0);
        assertEquals(6.0, boletim.getMedia(), 0.01);
        assertEquals("Aprovado", boletim.getSituacao());
    }

    @Test
    void testSetNotaAtualizaMediaESituacao() {
        Boletim boletim = new Boletim(aluno, turma, 2025, 10.0, 10.0, 10.0);
        assertEquals("Aprovado", boletim.getSituacao());

        boletim.setNota1(2.0);
        boletim.setNota2(3.0);
        boletim.setNota3(1.0);

        assertEquals(2.0, boletim.getMedia(), 0.01);
        assertEquals("Reprovado", boletim.getSituacao());
    }
}