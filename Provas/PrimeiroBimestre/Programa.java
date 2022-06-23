package PrimeiroBimestre;

public class Programa {

  public ListaEncadeada calcular(ListaEncadeada lista) {

    ListaEncadeada listaFinal = new ListaEncadeada();

    for(int i = 0; i < lista.tamanho(); i++) {
      CandidatoEntrada candidato = CandidatoEntrada.class.cast(lista.pega(i));

      Double media = this.calcularMedia(candidato.getNota1(), candidato.getNota2(), candidato.getNota3());
      Double mediana = this.calcularMediana(candidato.getNota1(), candidato.getNota2(), candidato.getNota3());
      Double variancia = this.getVariancia(candidato.getNota1(), candidato.getNota2(), candidato.getNota3(), media);
      Double desvpadrao = Math.sqrt(variancia);
      CandidatoSaida candidatoCalculado = new CandidatoSaida(
        candidato.getNome(), media, mediana, variancia, desvpadrao);
      listaFinal.adiciona(candidatoCalculado);
    }

    return listaFinal;
  }

  public ListaEncadeada apresentaCandidatos(ListaEncadeada lista) {

    for(int i = 0; i < lista.tamanho(); i++) {
      CandidatoSaida candidato = CandidatoSaida.class.cast(lista.pega(i));
      System.out.printf("%s Média = %.1f Mediana = %.0f Desvio padrão = %.2f Variância = %.0f",candidato.getNome(), candidato.getMedia(), candidato.getMediana(), candidato.getDesvpadrao(), candidato.getVariancia());
    }
    return lista;
  }

  public Double calcularMedia(Double nota1, Double nota2, Double nota3) {
    Double media = (nota1 + nota2 + nota3) / 3;
    return media;
  }

  public Double calcularMediana(Double nota1, Double nota2, Double nota3) {
    Double mediana = 0.0;

    if (nota1 >= nota2 && nota1 >= nota3) {
      if(nota2 >= nota3) {
        mediana = nota2;
      } else {
        mediana = nota3;
      }
    }
    if (nota2 >= nota3 && nota2 >= nota1) {
      if(nota1 >= nota3) {
        mediana = nota1;
      } else {
        mediana = nota3;
      }
    }
    if (nota3 >= nota1 && nota3 >= nota2) {
      if(nota1 >= nota2) {
        mediana = nota1;
      } else {
        mediana = nota2;
      }
    }
    // Double mediana = (nota1 + nota2)
    return mediana;
  }

  public Double getVariancia(Double nota1, Double nota2, Double nota3, Double media) {
    Double variancia = Math.pow((nota1 - media), 2) + Math.pow((nota2 - media), 2) + Math.pow((nota3 - media), 2);
    variancia = variancia/(2);
    return variancia;
  }

  public String pegaVencedor(ListaEncadeada lista) {
    String vencedor;
    Double menorVariancia;
    CandidatoSaida primeiroCandidato = CandidatoSaida.class.cast(lista.pega(0));
    menorVariancia = primeiroCandidato.getVariancia();
    vencedor = primeiroCandidato.getNome();

    for(int i = 0; i < lista.tamanho(); i++) {
      CandidatoSaida candidato = CandidatoSaida.class.cast(lista.pega(i));
      if(candidato.getVariancia() <= menorVariancia) {
        menorVariancia = candidato.getVariancia();
        vencedor = candidato.getNome();
      }
    }

    System.out.printf("\n%s é candidata(o) contratada, por apresentar maior regularidade.", vencedor);
    
    return vencedor;
  }
}
