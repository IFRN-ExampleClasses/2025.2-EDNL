public class ArvoreGenerica<T> implements ArvoreGenericaInterface<T> {

   // O único atributo da árvore é a referência ao seu nó raiz.
   private NoArvore<T> raiz;

   // Construtor da Árvore.
   public ArvoreGenerica(NoArvore<T> noRaiz) {
      if (noRaiz == null) {
         throw new IllegalArgumentException("O nó raiz não pode ser nulo."); }
      this.raiz = noRaiz;
   }

   // Método público para buscar um nó.
   @Override
   public NoArvore<T> buscarNo(T dado) {
      return buscarNoRecursivo(this.raiz, dado);
   }

   // Método auxiliar privado que faz a busca recursiva.
   private NoArvore<T> buscarNoRecursivo(NoArvore<T> noAtual, T dado) {
      if (noAtual == null) { return null; }
      if (noAtual.getDado().equals(dado)) { return noAtual; }
      for (NoArvore<T> filho : noAtual.getFilhos()) {
         NoArvore<T> noEncontrado = buscarNoRecursivo(filho, dado);
         if (noEncontrado != null) { return noEncontrado; }
      }
      return null;
   }
   
   // Método para inserir um novo nó como filho de um nó existente.
   @Override
   public void inserirNo(T dadosPai, T dadosFilho) throws Exception {
      NoArvore<T> noPai = this.buscarNo(dadosPai);
      if (noPai == null) {
         throw new Exception("Nó pai '" + dadosPai + "' não encontrado para inserção."); }
      // Validação de dados (nulo/branco) ocorre no construtor de NoArvore
      NoArvore<T> novoFilho = new NoArvore<>(dadosFilho);
      noPai.adicionarFilho(novoFilho);
      System.out.println("Nó '" + dadosFilho + "' inserido com sucesso em '" + dadosPai + "'.");
   }

   // Método para excluir um nó existente.
   @Override
   public boolean excluirNo(T dado) {
      NoArvore<T> noParaExcluir = this.buscarNo(dado);
      if (noParaExcluir == null) {
         System.out.println("Nó '" + dado + "' não encontrado para exclusão.");
         return false; }
      if (noParaExcluir == this.raiz) {
         System.out.println("Não é permitido excluir o nó raiz ('" + dado + "') desta forma.");
         return false; }
      NoArvore<T> pai = noParaExcluir.getPai();
      pai.removerFilho(noParaExcluir);
      System.out.println("Nó '" + dado + "' excluído com sucesso.");
      return true;
   }

   // Método para editar o dado de um nó existente.
   @Override
   public boolean editarNo(T dadoAntigo, T dadoNovo) {
      NoArvore<T> noParaEditar = this.buscarNo(dadoAntigo);
      if (noParaEditar == null) {
         System.out.println("Nó '" + dadoAntigo + "' não encontrado para edição.");
         return false; }
      try {
         noParaEditar.setDado(dadoNovo);
         System.out.println("Nó '" + dadoAntigo + "' editado para '" + dadoNovo + "'.");
         return true;
      } catch (IllegalArgumentException e) {
         System.out.println("Erro ao editar nó '" + dadoAntigo + "': " + e.getMessage());
         return false;
      }
   }

   // Método para imprimir a árvore em Pré-Ordem.
   @Override
   public void imprimirPreOrdem() {
      System.out.println("\nNavegando em Pré-Ordem (Raiz, Filhos):");
      imprimirPreOrdemRecursivo(this.raiz, 0);
   }
   
   // Método auxiliar privado recursivo para Pré-Ordem (com indentação de 3 espaços).
   private void imprimirPreOrdemRecursivo(NoArvore<T> noAtual, int nivel) {
      if (noAtual == null) return;
      String indentacao = (nivel <= 1) ? "" : "   ".repeat(nivel - 1);
      String prefixo = (nivel == 0) ? "" : "|- ";
      System.out.println(indentacao + prefixo + noAtual.getDado());
      for (NoArvore<T> filho : noAtual.getFilhos()) {
         imprimirPreOrdemRecursivo(filho, nivel + 1); }
   }

   // Método para imprimir a árvore em Pós-Ordem.
   @Override
   public void imprimirPosOrdem() {
      System.out.println("\nNavegando em Pós-Ordem (Filhos, Raiz):");
      imprimirPosOrdemRecursivo(this.raiz, 0);
   }

   // Método auxiliar privado recursivo para Pós-Ordem (com indentação de 3 espaços).
   private void imprimirPosOrdemRecursivo(NoArvore<T> noAtual, int nivel) {
      if (noAtual == null) return;
      for (NoArvore<T> filho : noAtual.getFilhos()) {
         imprimirPosOrdemRecursivo(filho, nivel + 1); }     
      String indentacao = (nivel <= 1) ? "" : "   ".repeat(nivel - 1);
      String prefixo = (nivel == 0) ? "" : "|- ";
      System.out.println(indentacao + prefixo + noAtual.getDado());
   }

   // Método para imprimir a árvore em Em-Ordem (Adaptado: 1º Filho, Raiz, Outros Filhos).
   @Override
   public void imprimirNaOrdem() {
      System.out.println("\nNavegando Em-Ordem (Adaptado: 1º Filho, Raiz, Outros Filhos):");
      imprimirNaOrdemRecursivo(this.raiz, 0);
   }

   // Método auxiliar privado recursivo para Em-Ordem (Adaptado, com indentação de 3 espaços).
   private void imprimirNaOrdemRecursivo(NoArvore<T> noAtual, int nivel) {
      if (noAtual == null) return;
      String indentacao = (nivel <= 1) ? "" : "   ".repeat(nivel - 1);
      String prefixo = (nivel == 0) ? "" : "|- ";
      if (noAtual.getFilhos().isEmpty()) {
         System.out.println(indentacao + prefixo + noAtual.getDado());
         return; }
      imprimirNaOrdemRecursivo(noAtual.getFilhos().get(0), nivel + 1);
      System.out.println(indentacao + prefixo + noAtual.getDado());
      for (int i = 1; i < noAtual.getFilhos().size(); i++) {
         imprimirNaOrdemRecursivo(noAtual.getFilhos().get(i), nivel + 1); }
   }

    // Método para obter o tamanho da árvore (número de nós).
   @Override
   public int getTamanho() { return getTamanhoRecursivo(this.raiz); }

   // Método auxiliar privado recursivo para calcular o tamanho.
   private int getTamanhoRecursivo(NoArvore<T> no) {
      if (no == null) return 0;
      int contador = 1;
      for (NoArvore<T> filho : no.getFilhos()) {
         contador += getTamanhoRecursivo(filho);}
      return contador;
   }

   // Método para obter a altura da árvore.
   @Override
   public int getAltura() { return getAlturaRecursivo(this.raiz); }

   // Método auxiliar privado recursivo para calcular a altura.
   private int getAlturaRecursivo(NoArvore<T> no) {
      if (no == null) return -1;
      if (no.getFilhos().isEmpty()) return 0;
      int alturaMaximaFilho = 0;
      for (NoArvore<T> filho : no.getFilhos()) {
         int alturaFilho = getAlturaRecursivo(filho);
         if (alturaFilho > alturaMaximaFilho) {
            alturaMaximaFilho = alturaFilho; }
      }
      return 1 + alturaMaximaFilho;
   }

   // Método para obter a referência ao nó raiz.
   @Override
   public NoArvore<T> getRaiz() { return this.raiz; }

   // Método para verificar se a árvore está vazia.
   @Override
   public boolean isVazia() { return this.raiz == null; }

}