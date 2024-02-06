package ListaSkip;

import java.lang.Math;

public class ListaSkip {
  private static class SkipNode {
    public SkipNode[] next;
    public int elem;
    
    public SkipNode (int pVal, int pLev) {
      elem = pVal;
      next = new SkipNode[pLev];
    }
  }

  private SkipNode head;
  private int maxLevel;
  private int actualLevel;
  private static int total = 0;

  public ListaSkip(int pVal, int pMaxLevel) {
    this.head = new SkipNode(pVal, pMaxLevel);
    this.maxLevel = pMaxLevel;
    this.actualLevel = 0;
    this.total++;
  }

  public boolean isEmpty() {
    for (int i = 0; i < this.head.next.length; i++) {
      if(this.head.next[i] == null) {
        return false;
      }
    }
    // if(this.total <= 0) return true;
    return true;
  }

  private int rand() {
    int i,j;
    double t = Math.random();
    for(i=1, j=2; i< this.maxLevel; i++, j+=j) {
      if(t * j >1.0) break;

      if(i > actualLevel) actualLevel = i;
    }
    return i;
  }

  private static void recInsert(SkipNode phead, SkipNode pNew, int pLev) {
    if (phead.next[pLev] == null || pNew.elem < phead.next[pLev].elem) {
      if (pLev < pNew.next.length) {
        pNew.next[pLev] = phead.next[pLev];
        phead.next[pLev] = pNew;
      }

      if (pLev == 0) return;

      recInsert(phead, pNew, pLev - 1);
    } else {
      recInsert(phead.next[pLev], pNew, pLev);
    }
  }

  public String toString() {
    if(isEmpty()) return "Lista vazia";
    
    SkipNode node, test;
    String str = "Lista Skip\n";
    
    for(int i = maxLevel - 1; i > 0; i--) {
      node = this.head;

      if (node.next[i] == null) {
        str += "\n";
      }
      else {
        str += "> "+node.next[i].elem;
        test = head.next[0];
        for(node = node.next[i]; node != null; node = node.next[i]) {

          for(;test != node && test.next[0] != null; test = test.next[0]) {
            str += "\t";
            if (node.next[i]== null) {
              str +="\t*";
            }
            else {
              str += " \t> "+node.next[i].elem;
              test = test.next[0];
            }
          }
          str += "\n";
        }
      }
    }
    str += head.elem;
    for (node=head.next[0];node!=null;node=node.next[0]) {
      str += "\t" + node.elem;
    }
    return str + "\t*\n";
  } 

  public void insert(int pElem){
    int rnd = rand();
    SkipNode ins = new SkipNode(pElem, rnd);
    recInsert(head, ins, this.actualLevel - 1);
    this.total++;
  }

  public int getelement(int posicao) {
    SkipNode node;
    node = this.head;

    if (posicao == 0) return head.elem;

    for (int i=0;i<=posicao-1;i++) {
      node=node.next[0];
    }
    return node.elem;
  }

  public boolean search (int pElem) {
    return recSearch(head, pElem, actualLevel - 1) != null;
  }

  private static SkipNode recSearch(SkipNode pNode, int pElem, int pLev) {
    if (pElem == pNode.elem) return pNode;

    while (pLev > 0 && pNode.next[pLev] == null) {
      pLev--;
    }

    if (pElem < pNode.next[pLev].elem) {
      if (pLev == 0) return null;

      return recSearch(pNode, pElem, pLev - 1);
    }

    return recSearch(pNode.next[pLev], pElem, pLev);
  }
  public void delete(int pElem){
    if (this.search(pElem)) {
      recDelete(head, pElem, actualLevel - 1);
      this.total = this.total--;
    }
    System.out.println(this.total);
  }

  private static void recDelete(SkipNode pHead, int pElem, int pLev) {
    while (pLev > 0 && pHead.next[pLev] == null) {
      pLev--;
    }
    if (pLev < 0 || pHead.next[0] == null) return;

    SkipNode node = pHead.next[pLev];

    if (node.elem >= pElem){
      if (node.elem == pElem){
        pHead.next[pLev] = node.next[pLev];
        if (pLev==0) return;
      }
      recDelete(pHead,pElem,pLev-1);
    }
    else {
      recDelete(pHead.next[pLev],pElem,pLev);
    }
  }
}
