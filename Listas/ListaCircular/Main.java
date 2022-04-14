package ListaCircular;

public class Main {
  public static void main(String[] args) {
    ListaCircular lista = new ListaCircular();
    lista.adiciona(10);
    lista.adiciona(20);
    lista.adiciona(30);
    lista.adiciona(40);
    lista.adiciona(50);

    System.out.println(lista);
    System.out.println(lista.getValor());
    // lista.proximo();
    // System.out.println(lista.getValor());

    // lista.adicionaNoComeco(30);
    // lista.adiciona(40, 1);
    // lista.adicionaNoComeco(5);
    // lista.removeDoComeco();
    // lista.removeDoFim();
    // Object value = lista.pega(1);
    // lista.remove(1);
    // System.out.println(lista);
    // System.out.println(value);
  }
}
