package ListaCircular;
import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class ListaCircularTest {
  @BeforeClass
  public static void testSetup() {
  }

  @AfterClass
  public static void testCleanup() {
    // Do your cleanup here like close URL connection , releasing resources etc
  }

  @Test
  public void insereCorretamente() {
    ListaCircular tester = new ListaCircular();
    tester.adiciona(10);
    tester.adiciona(20);
    tester.adiciona(30);
    tester.adiciona(40);
    tester.adiciona(50);
  
    String message = "Lista Circular: [50,10,20,30,40]";
    assertEquals(message, tester.toString());
  }

  @Test
  public void removeCorretamente() {
    ListaCircular tester = new ListaCircular();
    tester.adiciona(10);
    tester.adiciona(20);
    tester.adiciona(30);
    tester.adiciona(40);
    tester.adiciona(50);

    tester.remove();
    // O Próximo é deletado
    String message = "Lista Circular: [50,20,30,40]";
    assertEquals(message, tester.toString());
  }

  @Test
  public void getValorCorretamente() {
    ListaCircular tester = new ListaCircular();
    tester.adiciona(10);
    tester.adiciona(20);
    tester.adiciona(30);
    tester.adiciona(40);
    tester.adiciona(50);
  
    assertEquals(50, tester.getValor());
    tester.proximo();
    assertEquals(10, tester.getValor());
  }

  @Test
  public void vaiProProximoCorretamente() {
    ListaCircular tester = new ListaCircular();
    tester.adiciona(10);
    tester.adiciona(20);
    tester.adiciona(30);
    tester.adiciona(40);
    tester.adiciona(50);
  
    tester.proximo();
    assertEquals(10, tester.getValor());

    tester.proximo();
    assertEquals(20, tester.getValor());

    tester.proximo();
    assertEquals(30, tester.getValor());

    tester.proximo();
    assertEquals(40, tester.getValor());
  }

  @Test
  public void avancaCorretamente() {
    ListaCircular tester = new ListaCircular();
    tester.adiciona(10);
    tester.adiciona(20);
    tester.adiciona(30);
    tester.adiciona(40);
    tester.adiciona(50);
  
    tester.avanca(2);
    assertEquals(20, tester.getValor());

    tester.avanca(3);
    assertEquals(50, tester.getValor());

    tester.avanca(1);
    assertEquals(10, tester.getValor());

    tester.avanca(2);
    assertEquals(30, tester.getValor());

    tester.avanca(6);
    assertEquals(40, tester.getValor());
  }
}
