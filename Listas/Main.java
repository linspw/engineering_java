import java.util.Scanner;

import SegundoBimestre.ListaSkip.ListaSkip;
import TabelaHash.TabelaHash;

/* ****************************************************************************************
 * Faculdade de Engenharias Arquitetura e Urbanismo (FEAU) (Univap)
 * Curso: Engenharia da Computação - Data de Entrega: 09/06/2022
 * Autor: Jessé Correia Lins - 01711418
 *
 * Turma: 9UNA Disciplina: Algoritmos Estrutura de Dados - II
 * Avaliação parcial referente ao 2 - Bimestre
 * Observação: <colocar se houver>
 *
 * Main.java
 * ***************************************************************************************/

public class Main {
  public static void main(String[] args) {
    System.out.println("Número de apreensões: ");

    Scanner ler = new Scanner(System.in);
    int numeroCandidatos = ler.nextInt();
    int[] tabela = {};
    ListaSkip lista = new ListaSkip(0, 5);

    for (int i = 0; i < numeroCandidatos; i++) {
      int value = ler.nextInt();
      lista.insert(value);
    }

    for (int i = 0; i <= 50 && !lista.isEmpty(); i++) {
      int count = 0;

      while(lista.search(i)) {
        lista.delete(i);
        count++;
      };

      if(count > 0 ) TabelaHash.inserirTabela(tabela, count);
    }
    System.out.println(TabelaHash.mostra(tabela));
    // System.out.println(lista.toString());
  }
}
