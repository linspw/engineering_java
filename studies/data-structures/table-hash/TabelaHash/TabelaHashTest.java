package TabelaHash;
import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TabelaHashTest {


  @BeforeClass
  public static void testSetup() {
  }

  @AfterClass
  public static void testCleanup() {
    // Do your cleanup here like close URL connection , releasing resources etc
  }

  @Test
  public void insereCorretamente() {
    int tester = TabelaHash.hash(31, 2);
    // Resto da divisão

    assertEquals(1, tester);
  }

  @Test
  public void insereTabelaCorretamente() {
    int tabela[] = {1, 2, 3, 4, 5};
    TabelaHash.inserirTabela(tabela, 6);
    // tester.insert(8);
    // tester.insert(14);
    // tester.insert(12);
    // tester.insert(10);
    // tester.insert(1);
    assertEquals(0, tabela);
    assertEquals(0, TabelaHash.mostra(tabela));
    // assertEquals(1, tester.getelement(1));
    // assertEquals(8, tester.getelement(2));
    // assertEquals(10, tester.getelement(3));
    // assertEquals(12, tester.getelement(4));
    // assertEquals(14, tester.getelement(5));
  }

  @Test
  public void removeEOrdenaCorretamente() {
    // tester = new ListaSkip(0, 10);
    // tester.insert(8);
    // tester.insert(14);
    // tester.insert(12);
    // tester.insert(10);
    // tester.insert(1);

    // assertEquals(true, tester.search(1));
    // tester.delete(1);
    // assertEquals(false, tester.search(1));

    // assertEquals(true, tester.search(8));
    // tester.delete(8);
    // assertEquals(false, tester.search(8));

    // assertEquals(true, tester.search(10));
    // tester.delete(10);
    // assertEquals(false, tester.search(10));

    // assertEquals(true, tester.search(12));
    // tester.delete(12);
    // assertEquals(false, tester.search(12));

    // assertEquals(true, tester.search(14));
    // tester.delete(14);
    // assertEquals(false, tester.search(14));
  }
} 