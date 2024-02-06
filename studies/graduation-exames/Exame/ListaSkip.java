class ListaSkip {
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
        public ListaSkip(int pVal, int pMaxLevel){
             head = new SkipNode(pVal, pMaxLevel);
             maxLevel = pMaxLevel;
             actualLevel = 0;
             total++;    
        }
        
        public boolean isEmpty() {  
             for(int i=0;i<head.next.length;i++)
                 if(head.next[i] != null) 
                     return false;
                 return true;
        }
        
        public int size() {
            return total;
        }
        
        private static void recInsert(SkipNode phead, SkipNode pNew, int pLev) {
                 if(phead.next[pLev] == null || pNew.elem < phead.next[pLev].elem)
                 {
                     if(pLev < pNew.next.length){
                          pNew.next[pLev] = phead.next[pLev];
                          phead.next[pLev] = pNew;
                     }
                     if(pLev == 0) return;
                       recInsert(phead, pNew, pLev-1);
                 } else
                     recInsert(phead.next[pLev], pNew, pLev); 
          }  
        
        public String toString() {
               if(isEmpty()) 
                   return "Lista vazia";
                   
               System.out.println("Passei aqui !");     
               SkipNode node, test; 
               String str = "Lista Skip\n";
               for(int i=maxLevel-1;i > 0; i--)
               {
                    node = head;
                    if(node.next[i] == null) 
                       str += "\n";
                    else {
                      str += "> "+node.next[i].elem;
                      test = head.next[0];
                      for(node = node.next[i]; node != null; node = node.next[i]) {
                          for(;test!= node; test= test.next[0])
                              str += "\t";
                              if(node.next[i]== null) 
                                  str +="\t*";
                              else
                                 str += " \t> "+node.next[i].elem;
                                 test = test.next[0];
                      }                
                      str += "\n"; 
                    }
              }
                  
              str += head.elem;
			  for(node=head.next[0];node!=null;node=node.next[0])
                       str += "\t"+node.elem;
                  
                return str+"\t*\n";
            }   
            
          public int getelement(int posicao) {
              SkipNode node;  
              node = head;
              if(posicao == 0)
                 return head.elem;
              for(int i=0;i<=posicao-1;i++){
                     node=node.next[0];
              }
              return node.elem;          
          }  
            
          // Procura de dados em uma lista SKIP  
          public boolean search (int pElem) {
              return recSearch(head, pElem, actualLevel-1) != null;
          }                      
          
          private static SkipNode recSearch(SkipNode pNode, int pElem, int pLev) {
                  if(pElem == pNode.elem) 
                       return pNode;
                  while(pLev > 0 && pNode.next[pLev] == null) 
                       pLev--;          
                  if(pElem < pNode.next[pLev].elem)
                  {
                     if(pLev == 0) return null;
                      return recSearch(pNode, pElem, pLev-1);
                  }
                  return recSearch(pNode.next[pLev],pElem,pLev); 
            }
     
          // Inser��o de dados
          public void insert(int pElem){
                 int x = rand();
                 SkipNode ins = new SkipNode(pElem,x);
                 recInsert(head,ins,actualLevel-1);
                  total++; 
          }               
          
          private int rand() {
              int i,j; 
              double t = Math.random();
              for(i=1,j=2; i< maxLevel; i++, j+=j)   
                  if(t*j>1.0) break;
              if(i > actualLevel) actualLevel = i;
              return i;
          } 
          
          /*private int rand() {
               double r = Math.random();
               int rnd = (int)(r*((maxLevel+1)-1)+1);
               rnd = rnd > actualLevel?actualLevel:rnd;
               return rnd;   
          } */
          
          
         
         // Apagar elemento na lista SKIP
         public void delete(int pElem){                     
              if (this.search(pElem)) {       
                 recDelete(head,pElem,actualLevel-1);
                 total--;
               }  
         }
         
         private static void recDelete(SkipNode pHead, int pElem, int pLev){
                while(pLev > 0 && pHead.next[pLev] == null) 
                     pLev--;
                if(pLev < 0 || pHead.next[0] == null) 
                    return;
                SkipNode node = pHead.next[pLev];
                if(node.elem >= pElem){
                     if(node.elem == pElem){
                         pHead.next[pLev] = node.next[pLev];
                         if(pLev==0) return;
                     }
                     recDelete(pHead,pElem,pLev-1);
                }
                else 
                  recDelete(pHead.next[pLev],pElem,pLev);
         }
          
          
         public int primeiroSelecao(int pInicio, int pVal){
            for (int indice = pInicio; indice <= this.size(); indice++) {
              if (this.getelement(indice) <= pVal) return indice;
            }
            return -1;
          }
          public int melhorSelecao(int pVal){
            int melhor = this.primeiroSelecao(1, pVal);
            if (melhor == -1) return -1;
        
            for (int indice = melhor + 1; indice <= this.size(); indice++) {
              if (this.getelement(indice) > this.getelement(melhor) && this.getelement(indice) <= pVal) {
                melhor = indice;
              }
            }
            return melhor;
          }
          
}
        
        