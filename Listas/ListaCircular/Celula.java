package ListaCircular;

class Celula {
  Object valor;
  Celula proximo;

  Celula(Object valor){
    this.valor = valor;
    this.proximo = null;
  }

  public Object getValor() {
    return this.valor;
  }
}