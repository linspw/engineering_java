package ListaEncadeada;

public class Celula {
  public Celula proxima;
  public Object valor;

  public Celula(Object valor) {
    this.valor = valor;
    this.proxima = null;
  }

  public void setProxima(Celula proxima) {
    this.proxima = proxima;
  }

  public Celula getProxima() {
    return this.proxima;
  }

  public Object getValor() {
    return this.valor;
  }
}
