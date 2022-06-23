package SegundoBimestre.TabelaHash;

public class TabelaHash {
  public static int hash(int pVal, int ptabdim) {
    return pVal % ptabdim;
  }

  public static void inserirTabela(int[] pSeq, int pVal) {
    int ph = hash(pVal, pSeq.length);
    if (pSeq[ph] == 0) {
      pSeq[ph] = pVal;
    } else {
      int pos = (ph+1) % pSeq.length;
      while (pSeq[pos] != 0 && pos != ph) {
        pos = ++pos % pSeq.length;
      }
      if (pos != ph) {
        pSeq[pos] = pVal;
      }
    }
  }
  public static int procuraTabela(int[] pSeq, int pVal){
    int ph = hash(pVal, pSeq.length);
    if (pSeq[ph] == pVal) {
      return ph;
    }
    else {
      if (pSeq[ph] == 0) return -1;
      else {
        int pos = (ph+1) % pSeq.length;
        while (pSeq[pos] != pVal && pSeq[pos] != 0 && pos != ph) {
          pos = ++pos % pSeq.length;
        }
        if (pSeq[pos] == pVal) {
          return pos;
        } else {
          return -1;
        }
      }
    }
  }

  public static String mostra(int[] pSeq) {
    if (pSeq.length == 0) return "[]";

    String str = "[";

    for (int i=0;i<=pSeq.length-1;i++) {
      if (i < (pSeq.length-1)) {
        str+= pSeq[i]+",";
      } else {
        str += pSeq[i];
      }
    }

    return str+"]";
  }
}
