// ------------------------------------------------------------------------
// Classe ListaEncadeada que implementa a interface ListaEncadeadaInterface
// Mantém atributo tamanho atualizado nas inserções e remoções
// ------------------------------------------------------------------------
public class ListaEncadeada implements ListaEncadeadaInterface {
   private Node head;
   private int tamanho;

   public ListaEncadeada() {
      head = null;
      tamanho = 0;
   }

   @Override
   public boolean estaVazia() {
      return head == null;
   }

   @Override
   public boolean inserirNoInicio(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      Node novoNode = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      novoNode.setNoProximo(head);
      head = novoNode;
      tamanho++;
      return true;
   }

   @Override
   public boolean inserirNoFim(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      Node novoNode = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      if (estaVazia()) {
         head = novoNode;
      } else {
         Node atual = head;
         while (atual.getNoProximo() != null) {
            atual = atual.getNoProximo();
         }
         atual.setNoProximo(novoNode);
      }
      tamanho++;
      return true;
   }

   @Override
   public boolean inserirNaPosicao(int posicao, String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      if (posicao < 0 || posicao > tamanho) return false;

      if (posicao == 0) return inserirNoInicio(codigoDisciplina, nomeDisciplina, cargaHoraria);

      Node novoNode = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      Node atual = head;
      for (int i = 0; i < posicao - 1; i++) {
         atual = atual.getNoProximo();
      }
      novoNode.setNoProximo(atual.getNoProximo());
      atual.setNoProximo(novoNode);
      tamanho++;
      return true;
   }

   @Override
   public boolean removerPorCodigo(String codigoDisciplina) {
      if (estaVazia()) return false;

      if (head.getCodigoDisciplina().equals(codigoDisciplina)) {
         head = head.getNoProximo();
         tamanho--;
         return true;
      }

      Node atual = head;
      while (atual.getNoProximo() != null) {
         if (atual.getNoProximo().getCodigoDisciplina().equals(codigoDisciplina)) {
            atual.setNoProximo(atual.getNoProximo().getNoProximo());
            tamanho--;
            return true;
         }
         atual = atual.getNoProximo();
      }

      return false;
   }

   @Override
   public boolean buscarPorCodigo(String codigoDisciplina) {
      Node atual = head;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            return true;
         }
         atual = atual.getNoProximo();
      }
      return false;
   }

   @Override
   public boolean atualizarDisciplina(String codigoDisciplina, String novoNome, int novaCargaHoraria) {
      Node atual = head;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            atual.setNomeDisciplina(novoNome);
            atual.setCargaHoraria(novaCargaHoraria);
            return true;
         }
         atual = atual.getNoProximo();
      }
      return false;
   }

   @Override
   public void imprimirLista() {
      if (estaVazia()) {
         System.out.println("A lista está vazia.");
         return;
      }

      Node atual = head;
      System.out.println("Lista de Disciplinas:");
      while (atual != null) {
         System.out.println("Código: " + atual.getCodigoDisciplina() +
                            ", Nome: " + atual.getNomeDisciplina() +
                            ", Carga Horária: " + atual.getCargaHoraria());
         atual = atual.getNoProximo();
      }
   }

   @Override
   public int tamanho() {
      return tamanho;
   }
}
