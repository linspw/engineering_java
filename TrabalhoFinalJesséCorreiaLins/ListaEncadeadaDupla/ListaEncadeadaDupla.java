package ListaEncadeadaDupla;

public class ListaEncadeadaDupla {
  private Celula primeira;
  private Celula ultima;
  private int total;

  public void adicionaNoComeco(Object elemento) {
    Celula novaCelula = new Celula(elemento);

    if (this.tamanho() == 0) {
      this.primeira = novaCelula;
      this.ultima = this.primeira;
    } else {
      novaCelula.setProxima(this.primeira);
      this.primeira.setAnterior(novaCelula);
      this.primeira = novaCelula;
    }
    this.total += 1;
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


  public void adiciona(Object elemento, int posicao) {
    if(posicao == 0)  {
      this.adicionaNoComeco(elemento);
    }
    else if (posicao == this.total) {
      this.adiciona(elemento);
    }
    else {
      Celula anterior = this.pegaCelula(posicao - 1);
      Celula proxima = anterior.getProxima();
      Celula nova = new Celula(elemento);
      nova.setAnterior(anterior);
      nova.setProxima(proxima);
      anterior.setProxima(nova);
      this.total = this.total + 1;
    }
  }


  public void removeDoComeco() {
    if(!this.posicaoOcupada(0)) throw new IllegalArgumentException("Posição não existe");

    this.primeira = this.primeira.getProxima();
    this.total -= 1;
    if (this.total == 0) this.ultima = null;
  }


  public void removeDoFim() {
    if(!this.posicaoOcupada(this.total - 1)) {
      throw new IllegalArgumentException("Posição não existe");
    }
  
    if(this.total == 1) {
      this.removeDoComeco();
    }
    else {
      Celula penultima = this.ultima.getAnterior();
      penultima.setProxima(null);
      System.out.println(penultima);
      this.ultima = penultima;
      this.total = this.total - 1;
    }
  }

  public void remove(int posicao) {
    if(!this.posicaoOcupada(posicao)) {
      throw new IllegalArgumentException("Posição não existe");
    }
    if(posicao == 0) {
      this.removeDoComeco();
    }
    else {
      Celula anterior = this.pegaCelula(posicao - 1);
      Celula atual = anterior.getProxima();
      Celula proxima = atual.getProxima();
      anterior.setProxima(proxima);
      proxima.setAnterior(anterior);
    }
    
    this.total = this.total - 1;
  }

  Celula pegaCelula(int posicao) {
    if(!this.posicaoOcupada(posicao)) throw new IllegalArgumentException("Posição não existe");
    Celula atual = this.primeira;

    for (int i = 0; i < posicao; i += 1) {
      atual = atual.getProxima();
    }
  
    return atual;
  }

  public Object pega(int posicao) {
    return (pegaCelula(posicao).getValor());
  }

  public int tamanho() {
    return this.total;
  }

  public boolean posicaoOcupada(int posicao) {
    return posicao >= 0 && posicao < this.total;
  }

  public String toString() {
    String str = "Lista Encadeada Dupla: [";

    for (Celula celula = this.primeira; celula != null; celula = celula.proxima) {
      str += celula.valor ;
      if(celula.proxima != null) {
        str += ", ";
      }
    }
    return str + "]\n";
  }
}
