package ListaEncadeadaDupla;

public class Main {
  public static void main(String[] args) {
    ListaEncadeadaDupla lista = new ListaEncadeadaDupla();
    lista.adiciona(10);
    lista.adiciona(20);
    lista.adicionaNoComeco(30);
    lista.adiciona(40, 1);
    lista.adicionaNoComeco(5);
    lista.removeDoComeco();
    lista.removeDoFim();
    Object value = lista.pega(1);
    lista.remove(1);
    System.out.println(lista);
    System.out.println(value);
  }
}
