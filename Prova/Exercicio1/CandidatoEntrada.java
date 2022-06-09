package Exercicio1;

class CandidatoEntrada {
  private String nome;
  private double nota1;
  private double nota2;
  private double nota3;

  CandidatoEntrada(String nome, double nota1, double nota2, double nota3) {
    this.nome = nome;
    this.nota1 = nota1;
    this.nota2 = nota2;
    this.nota3 = nota3;
  }

  public String getNome() {
    return this.nome;
  }

  public double getNota1() {
    return this.nota1;
  }

  public double getNota2() {
    return this.nota2;
  }

  public double getNota3() {
    return this.nota3;
  }
}