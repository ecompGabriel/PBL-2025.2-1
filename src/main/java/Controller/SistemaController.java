package Controller;

public class SistemaController {

    private int anoLetivoAtual;
    private AlunoController alunoController;
    private ProfessorController professorController;
    private ResponsavelController responsavelController;
    private TurmaController turmaController;

    public SistemaController() {
        this.alunoController = new AlunoController();
        this.professorController = new ProfessorController();
        this.responsavelController = new ResponsavelController();
        this.turmaController = new TurmaController();
        this.anoLetivoAtual = 2025;
    }

    public int getAnoLetivoAtual() {
        return this.anoLetivoAtual;
    }

    public void avancarAnoLetivo() {
        this.anoLetivoAtual++;
        System.out.println("Sistema atualizado para o ano letivo de: " + this.anoLetivoAtual);
    }

    public AlunoController getAlunoController() {
        return alunoController;
    }

    public ProfessorController getProfessorController() {
        return professorController;
    }

    public ResponsavelController getResponsavelController() {
        return responsavelController;
    }

    public TurmaController getTurmaController() {
        return turmaController;
    }
}