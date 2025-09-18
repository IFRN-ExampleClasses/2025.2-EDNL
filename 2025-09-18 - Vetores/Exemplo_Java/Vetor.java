// ------------------------------------------------------------------------
// Vetor.java
// Implementação da interface VetorInterface usando array dinâmico
// - Impede a inserção de códigos de disciplina duplicados
// - Mantém atributo tamanho atualizado (incrementa/decrementa)
// - Realiza redimensionamento automático (dobrar capacidade quando necessário)
// - Métodos booleanos para operações que retornam sucesso/falha
// ------------------------------------------------------------------------
public class Vetor implements VetorInterface {
   private static final int CAPACIDADE_INICIAL = 4;

   private Node[] elementos;
   private int tamanho;

   // ---------------------------------------------------------------------
   // Construtores
   // ---------------------------------------------------------------------
   public Vetor() {
      this.elementos = new Node[CAPACIDADE_INICIAL];
      this.tamanho = 0;
   }

   public Vetor(int capacidadeInicial) {
      if (capacidadeInicial <= 0) {
         capacidadeInicial = CAPACIDADE_INICIAL;
      }
      this.elementos = new Node[capacidadeInicial];
      this.tamanho = 0;
   }

   // ---------------------------------------------------------------------
   // Método auxiliar: garante capacidade mínima, dobra quando necessário
   // ---------------------------------------------------------------------
   private void garantirCapacidade(int capacidadeMinima) {
      if (capacidadeMinima <= elementos.length) {
         return;
      }
      int novaCapacidade = elementos.length * 2;
      if (novaCapacidade < capacidadeMinima) {
         novaCapacidade = capacidadeMinima;
      }
      Node[] novo = new Node[novaCapacidade];
      for (int i = 0; i < tamanho; i++) {
         novo[i] = elementos[i];
      }
      elementos = novo;
   }

   // ---------------------------------------------------------------------
   // Verifica se já existe um Node com o mesmo código
   // ---------------------------------------------------------------------
   private boolean existeCodigo(String codigo) {
      for (int i = 0; i < tamanho; i++) {
         if (elementos[i] != null && elementos[i].getCodigoDisciplina().equals(codigo)) {
            return true;
         }
      }
      return false;
   }

   // ---------------------------------------------------------------------
   // Inserir no final (bloqueia duplicados)
   // ---------------------------------------------------------------------
   @Override
   public boolean inserir(Node item) {
      if (item == null || item.getCodigoDisciplina() == null) {
         return false;
      }
      if (existeCodigo(item.getCodigoDisciplina())) {
         System.out.println("Falha: código duplicado (" + item.getCodigoDisciplina() + ")");
         return false;
      }
      garantirCapacidade(tamanho + 1);
      elementos[tamanho] = item;
      tamanho++;
      return true;
   }

   // ---------------------------------------------------------------------
   // Inserir em posição específica (bloqueia duplicados)
   // ---------------------------------------------------------------------
   @Override
   public boolean inserirEm(Node item, int pos) {
      if (item == null || item.getCodigoDisciplina() == null) {
         return false;
      }
      if (pos < 0 || pos > tamanho) {
         return false;
      }
      if (existeCodigo(item.getCodigoDisciplina())) {
         System.out.println("Falha: código duplicado (" + item.getCodigoDisciplina() + ")");
         return false;
      }
      garantirCapacidade(tamanho + 1);
      for (int i = tamanho - 1; i >= pos; i--) {
         elementos[i + 1] = elementos[i];
      }
      elementos[pos] = item;
      tamanho++;
      return true;
   }

   // ---------------------------------------------------------------------
   // Remover por código
   // ---------------------------------------------------------------------
   @Override
   public boolean removerPorCodigo(String codigo) {
      if (codigo == null) {
         return false;
      }
      int idx = -1;
      for (int i = 0; i < tamanho; i++) {
         if (codigo.equals(elementos[i].getCodigoDisciplina())) {
            idx = i;
            break;
         }
      }
      if (idx == -1) {
         return false;
      }
      for (int i = idx; i < tamanho - 1; i++) {
         elementos[i] = elementos[i + 1];
      }
      elementos[tamanho - 1] = null;
      tamanho--;
      return true;
   }

   // ---------------------------------------------------------------------
   // Remover por posição
   // ---------------------------------------------------------------------
   @Override
   public boolean removerPorPosicao(int pos) {
      if (pos < 0 || pos >= tamanho) {
         return false;
      }
      for (int i = pos; i < tamanho - 1; i++) {
         elementos[i] = elementos[i + 1];
      }
      elementos[tamanho - 1] = null;
      tamanho--;
      return true;
   }

   // ---------------------------------------------------------------------
   // Buscar por código
   // ---------------------------------------------------------------------
   @Override
   public Node buscarPorCodigo(String codigo) {
      if (codigo == null) {
         return null;
      }
      for (int i = 0; i < tamanho; i++) {
         if (codigo.equals(elementos[i].getCodigoDisciplina())) {
            return elementos[i];
         }
      }
      return null;
   }

   // ---------------------------------------------------------------------
   // Atualizar por código
   // ---------------------------------------------------------------------
   @Override
   public boolean atualizarPorCodigo(String codigo, Node novo) {
      if (codigo == null || novo == null || novo.getCodigoDisciplina() == null) {
         return false;
      }
      for (int i = 0; i < tamanho; i++) {
         if (codigo.equals(elementos[i].getCodigoDisciplina())) {
            // se o novo tiver código diferente, verifica duplicação
            if (!codigo.equals(novo.getCodigoDisciplina()) &&
                existeCodigo(novo.getCodigoDisciplina())) {
               System.out.println("Falha: novo código duplicado (" + novo.getCodigoDisciplina() + ")");
               return false;
            }
            elementos[i] = novo;
            return true;
         }
      }
      return false;
   }

   // ---------------------------------------------------------------------
   // Imprimir vetor
   // ---------------------------------------------------------------------
   @Override
   public void imprimirVetor() {
      System.out.println("Vetor (tamanho=" + tamanho + ", capacidade=" + elementos.length + "):");
      for (int i = 0; i < tamanho; i++) {
         System.out.println("  [" + i + "] -> " + elementos[i]);
      }
   }

   // ---------------------------------------------------------------------
   @Override
   public int tamanho() {
      return this.tamanho;
   }

   @Override
   public boolean estaVazio() {
      return this.tamanho == 0;
   }
}
