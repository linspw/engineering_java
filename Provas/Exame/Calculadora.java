
public class Calculadora {
  

  public double calcular(double valor) {
    double total = 100 * Math.exp(-valor);

    return total;
  }

  public Double getVariancia(ListaSkip lista, Double media) {
    Double variancia = 0.0;
    for (int i = 1; i < lista.size(); i++) {
      variancia += Math.pow((lista.getelement(i) - media), 2);
    }
    variancia = variancia/(lista.size() - 2);
    return variancia;
  }

  public Double getDesvpadrao(Double valor) {
    return Math.pow(valor, 1.0/2.0);
  }
}
