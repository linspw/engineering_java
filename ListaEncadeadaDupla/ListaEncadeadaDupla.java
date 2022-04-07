public class ListaEncadeadaDupla {
  private Celula primeira;
  private Celula ultima;
  private int total;

  public void adicionaNoComeco(Object elemento) {
    Celula novaCelula = new Celula(elemento);
    this.primeira = novaCelula;

    if (this.tamanho() == 0) {
      novaCelula.setAnterior(this.primeira);
      this.ultima = this.primeira;
    }
    this.total += 1;
  }

  public int tamanho() {
    return this.total;
  }

  public void adiciona(Object elemento) {
    if (this.total == 0) {
      this.adicionaNoComeco(elemento);
    }
    else {
      Celula nova = new Celula(elemento);
      this.ultima.setProxima(nova);
      nova.setAnterior(this.ultima);
      this.ultima = nova;
      total = total + 1;
    }
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

  public void adiciona(int posicao, Object elemento) {
    if(posicao == 0)  {
      this.adicionaNoComeco(elemento);
    }
    else if (posicao == this.total) {
      this.adiciona(elemento);
    }
    else {
      Celula anterior = this.pegaCelula(posicao - 1);
      Celula nova = new Celula(elemento);
      nova.setAnterior(anterior.getProxima());
      anterior.setProxima(nova);
      this.total = this.total + 1;
    }
  }
}
