package Model;

public class Boletim {
    private Aluno aluno;
    private Turma turma;
    private int anoLetivo;
    private double nota1;
    private double nota2;
    private double nota3;
    private double media;
    private String situacao;

    public Boletim(Aluno aluno, Turma turma, int anoLetivo, double nota1, double nota2, double nota3) {
        this.aluno = aluno;
        this.turma = turma;
        this.anoLetivo = anoLetivo;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        calcularMediaESituacao();
    }

    private void calcularMediaESituacao() {
        this.media = (nota1 + nota2 + nota3) / 3.0;
        if (media >= 6.0) {
            situacao = "Aprovado";
        } else {
            situacao = "Reprovado";
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
        calcularMediaESituacao();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
        calcularMediaESituacao();
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
        calcularMediaESituacao();
    }

    public double getMedia() {
        return media;
    }

    public String getSituacao() {
        return situacao;
    }
}