// Note que a classe exige <T extends Comparable<T>>
public class ArvoreBinariaBusca<T extends Comparable<T>> implements ArvoreBinariaBuscaInterface<T> {

   private NoBinario<T> raiz;

   // Construtor: A BST começa vazia
   public ArvoreBinariaBusca() {
      this.raiz = null;
   }

   // ------------------------------------------------------------
   // Implementação do método de inserção de um nó
   @Override 
   public void inserirNo(T dado) {
      NoBinario<T> novoNo = new NoBinario<>(dado);

      // CASO 1: Árvore está vazia
      if (this.raiz == null) {
         this.raiz = novoNo;
         return;
      }

      // CASO 2: Árvore não vazia (Iterativo)
      NoBinario<T> atual = this.raiz;
      NoBinario<T> pai = null;

      while (atual != null) {
         pai = atual;
         int comparacao = dado.compareTo(atual.getDado());

         if (comparacao < 0) {
            atual = atual.getEsquerda(); // Vai para a esquerda
         } else if (comparacao > 0) {
            atual = atual.getDireita(); // Vai para a direita
         } else {
            System.out.println("Nó " + dado + " já existe (duplicado). Inserção cancelada.");
            return;
         }
      }

      // 'pai' é o nó folha onde devemos inserir
      if (dado.compareTo(pai.getDado()) < 0) {
         pai.setEsquerda(novoNo);
      } else {
         pai.setDireita(novoNo);
      }
   } 


   // ------------------------------------------------------------
   // Implementação do método que busca um nó
   @Override
   public NoBinario<T> buscarNo(T dado) {
      return buscarNoRecursivo(this.raiz, dado);
   }

   // Busca O(log n) - muito mais rápida
   private NoBinario<T> buscarNoRecursivo(NoBinario<T> noAtual, T dado) {
      if (noAtual == null) {
         return null; // Não encontrado
      }

      int comparacao = dado.compareTo(noAtual.getDado());

      if (comparacao == 0) {        // Encontrado
         return noAtual; 
      } else if (comparacao < 0) {  // Busca na esquerda
         return buscarNoRecursivo(noAtual.getEsquerda(), dado); 
      } else {                      // Busca na direita
         return buscarNoRecursivo(noAtual.getDireita(), dado); 
      }
   }


   // ------------------------------------------------------------
   // Implementação do método que exclui um nó
   @Override
   public void excluirNo(T dado) {
      // A raiz é atualizada, caso ela própria seja excluída
      this.raiz = excluirNoRecursivo(this.raiz, dado);
   }

   private NoBinario<T> excluirNoRecursivo(NoBinario<T> noAtual, T dado) {
      // 1. Nó não encontrado
      if (noAtual == null) {
         return null; 
      }

      // 2. Procurando o nó...
      int comparacao = dado.compareTo(noAtual.getDado());

      if (comparacao < 0) {         // Nó está na esquerda
         noAtual.setEsquerda( excluirNoRecursivo(noAtual.getEsquerda(), dado) );
      } else if (comparacao > 0) {  // Nó está na direita
         noAtual.setDireita( excluirNoRecursivo(noAtual.getDireita(), dado) );
      } else {
         // 3. Achou o nó (noAtual) para excluir
            
         // CENÁRIO 1: Nó folha
         if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) {
            return null; // O pai receberá 'null'
         }

         // CENÁRIO 2: Nó com UM filho (direito)
         if (noAtual.getEsquerda() == null) {
            return noAtual.getDireita(); // Retorna o filho da direita para o pai
         }

         // CENÁRIO 2: Nó com UM filho (esquerdo)
         if (noAtual.getDireita() == null) {
            return noAtual.getEsquerda(); // Retorna o filho da esquerda para o pai
         }

         // CENÁRIO 3: Nó com DOIS filhos
         // Encontrar o sucessor (o menor nó da sub-árvore direita)
         NoBinario<T> sucessor = encontrarMenorValor(noAtual.getDireita());
            
         // Copiar o valor do sucessor para este nó
         noAtual.setDado(sucessor.getDado());
            
         // Excluir o nó sucessor (que agora está duplicado) da sub-árvore direita
         noAtual.setDireita( excluirNoRecursivo(noAtual.getDireita(), sucessor.getDado()) );
      }

      return noAtual; // Retorna o nó (modificado ou não)
   }

   // Método auxiliar para encontrar o Sucessor (Cenário 3)
   private NoBinario<T> encontrarMenorValor(NoBinario<T> no) {
      NoBinario<T> atual = no;
      while (atual.getEsquerda() != null) {
         atual = atual.getEsquerda();
      }
      return atual;
   }


   // ------------------------------------------------------------
   // Implementação do método de impressão em pré-ordem
   @Override
   public void imprimirPreOrdem() {
      imprimirPreOrdemRecursivo(this.raiz, 0);
   }

   private void imprimirPreOrdemRecursivo(NoBinario<T> noAtual, int nivel) {
      if (noAtual == null) return;
      // 1. Raiz
      System.out.println(indentacao(nivel) + " " + noAtual.getDado()); 
      // 2. Esquerda
      imprimirPreOrdemRecursivo(noAtual.getEsquerda(), nivel + 1); 
      // 3. Direita
      imprimirPreOrdemRecursivo(noAtual.getDireita(), nivel + 1); 
   }


   // ------------------------------------------------------------
   // Implementação do método de impressão em pós-ordem  
   @Override
   public void imprimirPosOrdem() {
      imprimirPosOrdemRecursivo(this.raiz, 0);
   }

   private void imprimirPosOrdemRecursivo(NoBinario<T> noAtual, int nivel) {
      if (noAtual == null) return;
      // 1. Esquerda
      imprimirPosOrdemRecursivo(noAtual.getEsquerda(), nivel + 1);
      // 2. Direita 
      imprimirPosOrdemRecursivo(noAtual.getDireita(), nivel + 1); 
      // 3. Raiz
      System.out.println(indentacao(nivel) + " " + noAtual.getDado()); 
   }


   // ------------------------------------------------------------
   // Implementação do método de impressão em ordem
   @Override
   public void imprimirNaOrdem() {
      imprimirNaOrdemRecursivo(this.raiz, 0);
   }

   private void imprimirNaOrdemRecursivo(NoBinario<T> noAtual, int nivel) {
      if (noAtual == null) return;
      // 1. Esquerda
      imprimirNaOrdemRecursivo(noAtual.getEsquerda(), nivel + 1); 
      // 2. Raiz
      System.out.println(indentacao(nivel) + " " + noAtual.getDado()); 
      // 3. Direita
      imprimirNaOrdemRecursivo(noAtual.getDireita(), nivel + 1); 
   }

   private String indentacao(int nivel) {
      if (nivel == 0) return "";
      return " ".repeat(nivel * 3) + "|- ";
   }

   // ------------------------------------------------------------
   // Implementação do método que retorna a raiz da árvore
   @Override
   public NoBinario<T> getRaiz() { return this.raiz; }


   // ------------------------------------------------------------
   // Implementação do método que verifica se a árvore está vazia
   @Override
   public boolean isVazia() { return this.raiz == null; }
}