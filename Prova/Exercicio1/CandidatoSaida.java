package Exercicio1;

public class CandidatoSaida {
  private String nome;
  private double media;
  private double mediana;
  private double variancia;
  private double desvpadrao;

  CandidatoSaida(String nome, double media, double mediana, double variancia, double desvpadrao) {
    this.nome = nome;
    this.media = media;
    this.mediana = mediana;
    this.variancia = variancia;
    this.desvpadrao = desvpadrao;
  }

  public String getNome() {
    return this.nome;
  }

  public double getMedia() {
    return this.media;
  }

  public double getMediana() {
    return this.mediana;
  }

  public double getVariancia() {
    return this.variancia;
  }

  public double getDesvpadrao() {
    return this.desvpadrao;
  }
}
