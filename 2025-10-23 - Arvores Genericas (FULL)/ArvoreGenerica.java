/**
 * Arquivo...: ArvoreGenerica.java
 * Finalidade: Implementação da Árvore Genérica.
 * Esta classe contém a lógica para manipular a árvore.
 *
 * Ela pode receber uma árvore pré-construída em seu construtor
 * e também permite modificá-la usando seus métodos.
 */
public class ArvoreGenerica<T> implements ArvoreGenericaInterface<T> {

   // O único atributo da árvore é a referência ao seu nó raiz.
   private NoArvore<T> raiz;

   /**
    * Construtor da Árvore.
    * Recebe o nó raiz já construído.
    * @param noRaiz O nó raiz (do tipo NoArvore) da árvore.
    */
   public ArvoreGenerica(NoArvore<T> noRaiz) {
      if (noRaiz == null) {
         throw new IllegalArgumentException("O nó raiz não pode ser nulo.");
      }
      this.raiz = noRaiz;
   }

   /**
    * Método público para buscar um nó.
    */
   @Override
   public NoArvore<T> buscarNo(T dado) {
      // Começa a busca recursiva a partir da raiz
      return buscarNoRecursivo(this.raiz, dado);
   }

   /**
    * Método privado (auxiliar) que faz a busca recursiva.
    */
   private NoArvore<T> buscarNoRecursivo(NoArvore<T> noAtual, T dado) {
      if (noAtual == null) {
         return null;
      }
      if (noAtual.getDado().equals(dado)) {
         return noAtual;
      }
      for (NoArvore<T> filho : noAtual.getFilhos()) {
         NoArvore<T> noEncontrado = buscarNoRecursivo(filho, dado);
         if (noEncontrado != null) {
            return noEncontrado;
         }
      }
      return null;
   }
   
   // --- MÉTODOS DE MODIFICAÇÃO ---
   
   @Override
   public void inserirNo(T dadosPai, T dadosFilho) throws Exception {
      NoArvore<T> noPai = this.buscarNo(dadosPai);
      if (noPai == null) {
         throw new Exception("Nó pai '" + dadosPai + "' não encontrado para inserção.");
      }
      // Validação de dados (nulo/branco) ocorre no construtor de NoArvore
      NoArvore<T> novoFilho = new NoArvore<>(dadosFilho);
      noPai.adicionarFilho(novoFilho);
      System.out.println("Nó '" + dadosFilho + "' inserido com sucesso em '" + dadosPai + "'.");
   }
   
   @Override
   public boolean excluirNo(T dado) {
      NoArvore<T> noParaExcluir = this.buscarNo(dado);
      if (noParaExcluir == null) {
         System.out.println("Nó '" + dado + "' não encontrado para exclusão.");
         return false;
      }
      if (noParaExcluir == this.raiz) {
         System.out.println("Não é permitido excluir o nó raiz ('" + dado + "') desta forma.");
         return false;
      }
      NoArvore<T> pai = noParaExcluir.getPai();
      pai.removerFilho(noParaExcluir);
      System.out.println("Nó '" + dado + "' excluído com sucesso.");
      return true;
   }

   @Override
   public boolean editarNo(T dadoAntigo, T dadoNovo) {
      NoArvore<T> noParaEditar = this.buscarNo(dadoAntigo);
      if (noParaEditar == null) {
         System.out.println("Nó '" + dadoAntigo + "' não encontrado para edição.");
         return false;
      }
      try {
         // Validação de dados (nulo/branco) ocorre no setDado
         noParaEditar.setDado(dadoNovo);
         System.out.println("Nó '" + dadoAntigo + "' editado para '" + dadoNovo + "'.");
         return true;
      } catch (IllegalArgumentException e) {
         System.out.println("Erro ao editar nó '" + dadoAntigo + "': " + e.getMessage());
         return false;
      }
   }

   // --- MÉTODOS DE EXIBIÇÃO (PERCURSOS) ---
   
   @Override
   public void imprimirPreOrdem() {
      System.out.println("\nNavegando em Pré-Ordem (Raiz, Filhos):");
      imprimirPreOrdemRecursivo(this.raiz, 0);
   }
   
   /**
    * Método auxiliar recursivo para Pré-Ordem (com indentação de 3 espaços).
    * Nível 0 (raiz) e Nível 1 (filhos da raiz) não têm indentação.
    * A indentação começa no Nível 2.
    */
   private void imprimirPreOrdemRecursivo(NoArvore<T> noAtual, int nivel) {
      if (noAtual == null) return;
      
      // Nível 0 e 1 têm 0 de indentação. A indentação (nível-1) * 3 começa no nível 2.
      String indentacao = (nivel <= 1) ? "" : "   ".repeat(nivel - 1);
      // O prefixo é vazio apenas para a raiz (nível 0).
      String prefixo = (nivel == 0) ? "" : "|- ";

      // 1. Visita a "raiz" (nó atual)
      System.out.println(indentacao + prefixo + noAtual.getDado());
      
      // 2. Visita os filhos (passo recursivo)
      for (NoArvore<T> filho : noAtual.getFilhos()) {
         imprimirPreOrdemRecursivo(filho, nivel + 1);
      }
   }

   @Override
   public void imprimirPosOrdem() {
      System.out.println("\nNavegando em Pós-Ordem (Filhos, Raiz):");
      imprimirPosOrdemRecursivo(this.raiz, 0);
   }

   /**
    * Método auxiliar recursivo para Pós-Ordem (com indentação de 3 espaços).
    * Nível 0 e Nível 1 não têm indentação.
    */
   private void imprimirPosOrdemRecursivo(NoArvore<T> noAtual, int nivel) {
      if (noAtual == null) return;
      
      // 1. Visita os filhos (passo recursivo)
      for (NoArvore<T> filho : noAtual.getFilhos()) {
         imprimirPosOrdemRecursivo(filho, nivel + 1);
      }
      
      String indentacao = (nivel <= 1) ? "" : "   ".repeat(nivel - 1);
      String prefixo = (nivel == 0) ? "" : "|- ";

      // 2. Visita a "raiz" (nó atual)
      System.out.println(indentacao + prefixo + noAtual.getDado());
   }

   @Override
   public void imprimirNaOrdem() {
      System.out.println("\nNavegando Em-Ordem (Adaptado: 1º Filho, Raiz, Outros Filhos):");
      imprimirNaOrdemRecursivo(this.raiz, 0);
   }

   /**
    * Método auxiliar recursivo para Em-Ordem (Adaptado, com indentação de 3 espaços).
    * Nível 0 e Nível 1 não têm indentação.
    */
   private void imprimirNaOrdemRecursivo(NoArvore<T> noAtual, int nivel) {
      if (noAtual == null) return;

      String indentacao = (nivel <= 1) ? "" : "   ".repeat(nivel - 1);
      String prefixo = (nivel == 0) ? "" : "|- ";
      
      // Caso base: Se é uma folha, apenas imprime
      if (noAtual.getFilhos().isEmpty()) {
         System.out.println(indentacao + prefixo + noAtual.getDado());
         return;
      }
      
      // 1. Visita recursivamente o *primeiro* filho
      imprimirNaOrdemRecursivo(noAtual.getFilhos().get(0), nivel + 1);
      
      // 2. Visita a "raiz" (nó atual)
      System.out.println(indentacao + prefixo + noAtual.getDado());
      
      // 3. Visita recursivamente os *outros* filhos
      for (int i = 1; i < noAtual.getFilhos().size(); i++) {
         imprimirNaOrdemRecursivo(noAtual.getFilhos().get(i), nivel + 1);
      }
   }

   // --- MÉTODOS DE MEDIÇÃO ---
   
   @Override
   public int getTamanho() {
      return getTamanhoRecursivo(this.raiz);
   }
   private int getTamanhoRecursivo(NoArvore<T> no) {
      if (no == null) return 0;
      int contador = 1;
      for (NoArvore<T> filho : no.getFilhos()) {
         contador += getTamanhoRecursivo(filho);
      }
      return contador;
   }
   @Override
   public int getAltura() {
      return getAlturaRecursivo(this.raiz);
   }
   private int getAlturaRecursivo(NoArvore<T> no) {
      if (no == null) return -1;
      if (no.getFilhos().isEmpty()) return 0;
      int alturaMaximaFilho = 0;
      for (NoArvore<T> filho : no.getFilhos()) {
         int alturaFilho = getAlturaRecursivo(filho);
         if (alturaFilho > alturaMaximaFilho) {
            alturaMaximaFilho = alturaFilho;
         }
      }
      return 1 + alturaMaximaFilho;
   }
   @Override
   public NoArvore<T> getRaiz() {
      return this.raiz;
   }
   @Override
   public boolean isVazia() {
      return this.raiz == null;
   }
}