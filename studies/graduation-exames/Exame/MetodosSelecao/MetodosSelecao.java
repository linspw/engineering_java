package MetodosSelecao;

public class MetodosSelecao {
  public static int maxSelecao(int pSeq[], int pInicio, int pFim) {
    int max = pInicio;
    for (int indice=pInicio+1; indice <= pFim; indice++) {
      if (pSeq[indice] > pSeq[max]) {
        max = indice;
      }
    }
    return max;
  }
  public static int minSelecao(int pSeq[], int pInicio, int pFim) {
    int min = pInicio;
    for (int indice = pInicio + 1; indice <= pFim; indice++){
      if (pSeq[indice] < pSeq[min]) {
        min = indice;
      }
    }
    return min;
  }
  
  public static int primeiroSelecao(int pSeq[], int pInicio, int pFim, int pVal){
    for (int indice = pInicio; indice <= pFim; indice++) {
      if (pSeq[indice] <= pVal) return indice;
    }
    return -1;
  }
  public static int melhorSelecao(int pSeq[], int pInicio, int pFim, int pVal){
    int melhor = primeiroSelecao(pSeq, pInicio, pFim, pVal);
    if (melhor == -1) return -1;

    for (int indice = melhor + 1; indice <= pFim; indice++) {
      if (pSeq[indice] > pSeq[melhor] && pSeq[indice] <= pVal) {
        melhor = indice;
      }
    }
    return melhor;
  }

  public static int piorSelecao(int pSeq[], int pInicio, int pFim, int pVal){
    int pior = primeiroSelecao(pSeq,pInicio,pFim,pVal);
    if (pior == -1) {
      return -1;
    }
    for (int indice=pior+1; indice <= pFim; indice++) {
      if (pSeq[indice] < pSeq[pior]) {
        pior = indice;
      }
    }

    return pior;
  }
  
  public static void kSelecao(int pSeq[],int pInicio,int pFim, int pK) {
    int i = pInicio;
    int j = pFim;
    int pivot = pSeq[--pK];

    if (pInicio < pFim) {
      do {
        while(pSeq[i] < pivot) i++;
        while(pSeq[j] > pivot) j--;
        if (i < j) {
          troca(pSeq, i,j);
          i++;
          j--;     
        }
      } while (i < j);
    }
  }

  public static void troca(int[] pSeq, int pI, int pJ){
    int temp = pSeq[pI];
    pSeq[pI] = pSeq[pJ];
    pSeq[pJ] = temp;
  }
}