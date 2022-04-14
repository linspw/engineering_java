package ListaEncadeada;

public class Main {
  public static void main(String[] args) {
    ListaEncadeada lista = new ListaEncadeada();
    lista.adiciona(10);
    lista.adiciona(20);
    lista.adicionaNoComeco(30);
    lista.removeDoComeco();
    Object value = lista.pega(1);
    System.out.println(lista);
    System.out.println(value);
  }
}
