
public class ListaEncadeada {
  private Celula primeira;
  private Celula ultima;
  private int total;

  public boolean vazio() {
    return this.primeira == null;
  }

  public int tamanho() {
    return this.total;
  }

  public void adicionaNoComeco(Object elemento) {
    Celula novaCelula = new Celula(elemento);
    novaCelula.setProxima(this.primeira);

    this.primeira = novaCelula;

    if(this.tamanho() == 0) {
      this.ultima = this.primeira;
    }
    this.total += 1;
  }

  public void adiciona(Object elemento) {
    if(this.tamanho() == 0) {
      this.adicionaNoComeco(elemento);
    } else {
      Celula novaCelula = new Celula(elemento);
      this.ultima.setProxima(novaCelula);
      this.ultima = novaCelula;
      this.total += 1;
    }
  }

  public void removeDoComeco() {
    if(!this.posicaoOcupada(0)) throw new IllegalArgumentException("Posição não existe");

    this.primeira = this.primeira.getProxima();
    this.total -= 1;
    if (this.total == 0) this.ultima = null;
  }

  public boolean posicaoOcupada(int posicao) {
    return posicao >= 0 && posicao < this.total;
  }

  Celula pegaCelula(int posicao) {
    if(!this.posicaoOcupada(posicao) ) throw new IllegalArgumentException("Posição não existe");
    Celula atual = this.primeira;

    for (int i = 0; i < posicao; i += 1) {
      atual = atual.getProxima();
    }
  
    return atual;
  }

  public Object pega(int posicao) {
    return (pegaCelula(posicao).getValor());
  }

  public String toString() {
    String str = "Lista Encadeada: [";

    for (Celula celula = this.primeira; celula != null; celula = celula.proxima) {
      str += celula.valor ;
      if(celula.proxima != null) {
        str += ", ";
      }
    }
    return str + "]\n";
  }

}
