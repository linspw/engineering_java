package Exercicio1;
import java.util.Scanner;

/* ****************************************************************************************
 * Faculdade de Engenharias Arquitetura e Urbanismo (FEAU) (Univap)
 * Curso: Engenharia da Computação - Data de Entrega: 14/04/2022
 * Autor: Jessé Correia Lins - 01711418
 *
 * Turma: 9UNA Disciplina: Algoritmos Estrutura de Dados - II
 * Avaliação parcial referente ao 1 - Bimestre
 * Observação: <colocar se houver>
 *
 * Main.java
 * ***************************************************************************************/

public class Main {
  public static void main(String[] args) {
    Programa prova = new Programa();
    int numeroCandidatos = 0;

    
    Scanner ler = new Scanner(System.in);
    System.out.printf("Quantos candidatos: ");
    numeroCandidatos = ler.nextInt();

    ListaEncadeada lista = new ListaEncadeada();

    for (int i = 0; i < numeroCandidatos; i++) {
      ler.nextLine();
      String nome_do_aluno = ler.nextLine();
      Double nota1 = ler.nextDouble();
      // ler.nextLine();
      Double nota2 = ler.nextDouble();
      // ler.nextLine();
      Double nota3 = ler.nextDouble();
      CandidatoEntrada candidato = new CandidatoEntrada(nome_do_aluno, nota1, nota2, nota3);
      lista.adiciona(candidato);
    }

    ListaEncadeada listaCalculada = prova.calcular(lista);

    prova.apresentaCandidatos(listaCalculada);

    prova.pegaVencedor(listaCalculada);
  }
}
