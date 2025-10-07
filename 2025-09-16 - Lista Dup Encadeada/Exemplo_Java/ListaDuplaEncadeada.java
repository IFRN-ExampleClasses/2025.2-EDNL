// ------------------------------------------------------------------------
// Classe ListaDuplaEncadeada
// Implementa a interface ListaDuplaEncadeadaInterface, fornecendo a
// lógica completa para manipulação da lista duplamente encadeada.
// ------------------------------------------------------------------------

public class ListaDuplaEncadeada implements ListaDuplaEncadeadaInterface {

   private Node head;   // Primeiro nó da lista
   private Node tail;   // Último nó da lista
   private int tamanho;

   public ListaDuplaEncadeada() {
      this.head = null;
      this.tail = null;
      this.tamanho = 0;
   }

   @Override
   public boolean inserirNoInicio(String codigo, String nome, int cargaHoraria) {
      try {
         Node novo = new Node(codigo, nome, cargaHoraria);
         if (estaVazia()) {
            head = tail = novo;
         } else {
            novo.setNoProximo(head);
            head.setNoAnterior(novo);
            head = novo;
         }
         tamanho++;
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   @Override
   public boolean inserirNoFim(String codigo, String nome, int cargaHoraria) {
      try {
         Node novo = new Node(codigo, nome, cargaHoraria);
         if (estaVazia()) {
            head = tail = novo;
         } else {
            tail.setNoProximo(novo);
            novo.setNoAnterior(tail);
            tail = novo;
         }
         tamanho++;
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   @Override
   public boolean inserirNaPosicao(String codigo, String nome, int cargaHoraria, int posicao) {
      if (posicao < 0 || posicao > tamanho) {
         return false;
      }
      if (posicao == 0) {
         return inserirNoInicio(codigo, nome, cargaHoraria);
      }
      if (posicao == tamanho) {
         return inserirNoFim(codigo, nome, cargaHoraria);
      }

      try {
         Node novo = new Node(codigo, nome, cargaHoraria);
         Node atual = head;
         for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getNoProximo();
         }
         Node proximo = atual.getNoProximo();
         novo.setNoProximo(proximo);
         novo.setNoAnterior(atual);
         atual.setNoProximo(novo);
         if (proximo != null) {
            proximo.setNoAnterior(novo);
         }
         tamanho++;
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   @Override
   public boolean removerPorCodigo(String codigo) {
      if (estaVazia()) return false;

      Node atual = head;
      while (atual != null && !atual.getCodigoDisciplina().equals(codigo)) {
         atual = atual.getNoProximo();
      }

      if (atual == null) return false;

      if (atual == head) {
         head = atual.getNoProximo();
         if (head != null) head.setNoAnterior(null);
         else tail = null;
      } else if (atual == tail) {
         tail = atual.getNoAnterior();
         if (tail != null) tail.setNoProximo(null);
         else head = null;
      } else {
         atual.getNoAnterior().setNoProximo(atual.getNoProximo());
         atual.getNoProximo().setNoAnterior(atual.getNoAnterior());
      }
      tamanho--;
      return true;
   }

   @Override
   public Node buscarPorCodigo(String codigo) {
      Node atual = head;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigo)) {
            return atual;
         }
         atual = atual.getNoProximo();
      }
      return null;
   }

   @Override
   public boolean atualizarDisciplina(String codigo, String novoNome, int novaCarga) {
      Node alvo = buscarPorCodigo(codigo);
      if (alvo != null) {
         alvo.setNomeDisciplina(novoNome);
         alvo.setCargaHoraria(novaCarga);
         return true;
      }
      return false;
   }

   @Override
   public void imprimirLista() {
      Node atual = head;
      System.out.println("---- Conteúdo da Lista ----");
      int idx = 0;
      while (atual != null) {
         System.out.printf("[%d] Código: %s | Nome: %s | Carga Horária: %d\n",
               idx,
               atual.getCodigoDisciplina(),
               atual.getNomeDisciplina(),
               atual.getCargaHoraria());
         atual = atual.getNoProximo();
         idx++;
      }
      System.out.println("---------------------------");
   }

   @Override
   public boolean estaVazia() {
      return tamanho == 0;
   }

   @Override
   public int tamanho() {
      return tamanho;
   }
}
