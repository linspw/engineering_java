/* ****************************************************************************************
 * Faculdade de Engenharias Arquitetura e Urbanismo (FEAU) - (Univap)
 * Curso: Engenharia da Computação - Data de Entrega: DD/MM/2020
 * Autor: Jessé Correia Lins
 *
 * Turma: 8UNA Disciplina: Algoritmos Estrutura de Dados - II
 * Avaliação parcial referente ao 2 - Bimestre
 * Observação: <colocar se houver>
 *
 * Main.java
 * ***************************************************************************************/
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Calculadora calculadora = new Calculadora();
    ListaSkip lista = new ListaSkip(0, 10);
    Double media = 0.0;

    Scanner ler = new Scanner(System.in);

    System.out.println("Quantos tempos:");
    int n = ler.nextInt();

    for (int i = 0; i < n; i++) {

      Double linha = ler.nextDouble();
      Double resultado = calculadora.calcular(linha/60);
      lista.insert(resultado.intValue());
      media = media + resultado;
    }

    for (int i = 1; i < lista.size(); i++) {
      String porcentagem = lista.getelement(i) +",00%";
      System.out.println(porcentagem);
    }
    media = media / n;

    System.out.printf("\n");
    System.out.printf("Média = %.2f\n", media);
    Double variancia = calculadora.getVariancia(lista, media);
    Double desvpadrao = calculadora.getDesvpadrao(variancia);
    System.out.printf("Desvio Padrão = %.2f\n", desvpadrao);
    System.out.printf("Variancia = %.2f\n", variancia);

    // System.out.printf("\n%f", lista.melhorSelecao(100));

  }
}
