import java.util.ArrayList;
import java.util.Collections;
import ListaEncadeadaDupla.ListaEncadeadaDupla;

public class UniqueRandomNumbers {
    
  public static ListaEncadeadaDupla get(int maxRange) {
      ArrayList<Integer> listprepared = new ArrayList<Integer>();
      ArrayList<Integer> list = new ArrayList<Integer>();
      ListaEncadeadaDupla lista = new ListaEncadeadaDupla();

      for (int i=1; i <= 24; i++) list.add(i);

      Collections.shuffle(list);
      System.out.println(list);
      int max = (maxRange * maxRange) / 2;
      for (int i=0; i < max; i++) {
        listprepared.add(list.get(i));
        listprepared.add(list.get(i));
      }
      System.out.println(listprepared);

      Collections.shuffle(listprepared);
      System.out.println(listprepared);

      for (int i=0; i < listprepared.size(); i++) {
        lista.adiciona(listprepared.get(i));
      }
      // System.out.println(listprepared);
      // System.out.println(lista);
      return lista;
  }
}