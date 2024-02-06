package ListaEncadeadaDupla;

public class Celula {
  public Celula proxima;
  public Celula anterior;
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

  public void setAnterior(Celula anterior) {
    this.anterior = anterior;
  }

  public Celula getAnterior() {
    return this.anterior;
  }

  public Object getValor() {
    return this.valor;
  }
}
