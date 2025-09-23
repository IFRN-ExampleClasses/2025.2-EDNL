// ------------------------------------------------------------------------
// Pilha.java
// Implementação da pilha encadeada (LIFO) que implementa PilhaInterface.
// Mantém atributo 'tamanho' otimizado: incrementa ao inserir, decrementa ao remover.
// Todos os métodos que retornam sucesso/falha retornam boolean, quando aplicável.
// ------------------------------------------------------------------------
public class Pilha implements PilhaInterface {
   // ---------------------------------------------------------------------
   // Atributos privados da pilha
   // ---------------------------------------------------------------------
   private Node topo; // referência para o topo da pilha
   private int tamanho; // tamanho otimizado

   // ---------------------------------------------------------------------
   // Construtor
   // ---------------------------------------------------------------------
   public Pilha() {
      this.topo = null;
      this.tamanho = 0;
   }

   // ---------------------------------------------------------------------
   // push: insere no topo da pilha
   // Retorna true se inseriu com sucesso
   // ---------------------------------------------------------------------
   @Override
   public boolean push(Node novo) {
      if (novo == null) {
         return false;
      }
      // insere no topo
      novo.setNext(topo);
      topo = novo;
      tamanho++; // manter tamanho otimizado
      return true;
   }

   // ---------------------------------------------------------------------
   // pop: remove e retorna o nó do topo
   // Retorna null se a pilha estiver vazia
   // ---------------------------------------------------------------------
   @Override
   public Node pop() {
      if (isEmpty()) {
         return null;
      }
      Node removido = topo;
      topo = topo.getNext();
      // desconectar o nó removido para segurança
      removido.setNext(null);
      tamanho--; // manter tamanho otimizado
      return removido;
   }

   // ---------------------------------------------------------------------
   // peek: retorna o topo sem remover
   // ---------------------------------------------------------------------
   @Override
   public Node peek() {
      return topo;
   }

   // ---------------------------------------------------------------------
   // isEmpty: verifica se a pilha está vazia
   // ---------------------------------------------------------------------
   @Override
   public boolean isEmpty() {
      return topo == null;
   }

   // ---------------------------------------------------------------------
   // tamanho: retorna o atributo tamanho (otimizado)
   // ---------------------------------------------------------------------
   @Override
   public int tamanho() {
      return tamanho;
   }

   // ---------------------------------------------------------------------
   // imprimirLista: imprime a pilha do topo para o fundo
   // ---------------------------------------------------------------------
   @Override
   public void imprimirLista() {
      System.out.println("------ PILHA (topo -> fundo) ------");
      Node atual = topo;
      while (atual != null) {
         System.out.println(atual.toString());
         atual = atual.getNext();
      }
      System.out.println("------ FIM DA PILHA ------");
   }

   // ---------------------------------------------------------------------
   // buscarPorCodigo: retorna o nó com o código informado (ou null se não achar)
   // ---------------------------------------------------------------------
   @Override
   public Node buscarPorCodigo(String codigoDisciplina) {
      Node atual = topo;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            return atual;
         }
         atual = atual.getNext();
      }
      return null;
   }

   // ---------------------------------------------------------------------
   // contains: verifica se existe um código na pilha
   // ---------------------------------------------------------------------
   @Override
   public boolean contains(String codigoDisciplina) {
      return buscarPorCodigo(codigoDisciplina) != null;
   }

   // ---------------------------------------------------------------------
   // atualizar: atualiza nome e carga da disciplina identificada pelo código
   // Retorna true se atualizou, false caso não encontrado
   // ---------------------------------------------------------------------
   @Override
   public boolean atualizar(String codigoDisciplina, String novoNome, int novaCarga) {
      Node alvo = buscarPorCodigo(codigoDisciplina);
      if (alvo == null) {
         return false;
      }
      alvo.setNomeDisciplina(novoNome);
      alvo.setCargaHoraria(novaCarga);
      return true;
   }

   // ---------------------------------------------------------------------
   // removerPorCodigo: remove a primeira ocorrência com o código informado
   // Retorna true se removeu, false se não encontrou
   // OBS: operação pouco usual em pilha, mas implementada conforme especificação
   // ---------------------------------------------------------------------
   @Override
   public boolean removerPorCodigo(String codigoDisciplina) {
      if (isEmpty()) {
         return false;
      }
      // caso especial: topo
      if (topo.getCodigoDisciplina().equals(codigoDisciplina)) {
         Node removido = pop(); // já decrementa tamanho
         return removido != null;
      }
      // busca o anterior ao nó a ser removido
      Node anterior = topo;
      Node atual = topo.getNext();
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            // remove atual ligando anterior ao próximo de atual
            anterior.setNext(atual.getNext());
            atual.setNext(null);
            tamanho--; // manter tamanho otimizado
            return true;
         }
         anterior = atual;
         atual = atual.getNext();
      }
      return false; // não encontrado
   }

   // ---------------------------------------------------------------------
   // clear: remove todos os elementos da pilha
   // ---------------------------------------------------------------------
   @Override
   public void clear() {
      while (!isEmpty()) {
         pop();
      }
      // topo já null e tamanho 0 devido ao pop()
   }
}
