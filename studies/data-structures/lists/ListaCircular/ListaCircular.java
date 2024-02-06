package ListaCircular;

public class ListaCircular {
  Celula cursor;
  int total;
  
  public void Listacircular() {
    this.cursor = null;
  }

  public void adiciona(Object valor) {
    Celula novaCelula = new Celula(valor);
    if (this.cursor == null) {
      novaCelula.proximo = novaCelula;
      this.cursor = novaCelula;
    } else {
      novaCelula.proximo = this.cursor.proximo;
      this.cursor.proximo = novaCelula;
      this.cursor = novaCelula;
    }
    this.total = this.total + 1;
  }

  public void remove() {
    if (this.cursor != null) {
      if (this.cursor == this.cursor.proximo) {
        this.cursor = null;
      }
      else {
        this.cursor.proximo = this.cursor.proximo.proximo;
        total = total - 1;
      }
    }
  }

  public void proximo() {
    this.cursor = this.cursor.proximo;
  }

  public void avanca(int posicao) {
    for(int i = 0; i < posicao; i++) {
      this.proximo();
    }
  }

  Object getValor() {
    return this.cursor.getValor();
  }

  public int tamanho() {
    return this.total;
  }

  public boolean checkUltimoValor() {
    return (this.cursor == this.cursor.proximo);
  }

  public String toString(){
    if (this.cursor == null) return "[]";

    
    String texto = "Lista Circular: [" + this.getValor();
    Celula velhocursor = this.cursor;

    for (this.proximo(); velhocursor != this.cursor; this.proximo()) {
      texto += "," + this.getValor();
    }
    return texto + "]";
  }
}
