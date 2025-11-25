public class ArvoreBinaria<T> implements ArvoreBinariaInterface<T> {

   private NoBinario<T> raiz;

   // Construtor que "adota" um nó raiz já criado
   public ArvoreBinaria(NoBinario<T> noRaiz) {
      if (noRaiz == null) {
         throw new IllegalArgumentException("O nó raiz não pode ser nulo.");
      }
      this.raiz = noRaiz;
   }

   // Implementação do método que busca um nó na árvore.
   @Override
   public NoBinario<T> buscarNo(T dado) {
      return buscarNoRecursivo(this.raiz, dado); //
   }

   // Método privado (recursivo)
   private NoBinario<T> buscarNoRecursivo(NoBinario<T> noAtual, T dado) {
      // Caso 1: Nó não encontrado (chegou ao fim de um galho)
      if (noAtual == null) {
         return null;
      }
      // Caso 2: Encontrado!
      if (noAtual.getDado().equals(dado)) {
         return noAtual;
      }
        
      // Caso 3: (Passo Recursivo) Procura na sub-árvore esquerda
      NoBinario<T> noEncontrado = buscarNoRecursivo(noAtual.getEsquerda(), dado);
        
      // Se não achou na esquerda, procura na direita
      if (noEncontrado == null) {
         noEncontrado = buscarNoRecursivo(noAtual.getDireita(), dado);
      }

      return noEncontrado;
   }

   // Implementação do método que insere um nó na árvore.
   @Override
   public void inserirNo(T dadosPai, T dadosFilho, char lado) throws Exception {
      NoBinario<T> noPai = this.buscarNo(dadosPai); //

      // Se o pai não for encontrado, lança um erro
      if (noPai == null) {
         throw new Exception("Nó pai '" + dadosPai + "' não foi encontrado.");
      }

      // Cria o novo filho (a validação ocorre no construtor)
      NoBinario<T> novoFilho = new NoBinario<>(dadosFilho);

      // Adiciona o filho no lado correto
      if (lado == 'E' || lado == 'e') {
         if (noPai.getEsquerda() != null) {
            throw new Exception("Lado esquerdo do nó '" + dadosPai + "' já está ocupado.");
         }
         noPai.setEsquerda(novoFilho);
      } else if (lado == 'D' || lado == 'd') {
         if (noPai.getDireita() != null) {
            throw new Exception("Lado direito do nó '" + dadosPai + "' já está ocupado.");
         }
         noPai.setDireita(novoFilho);
      } else {
         throw new Exception("Lado de inserção inválido. Use 'E' ou 'D'.");
      }
      System.out.println("Nó '" + dadosFilho + "' inserido com sucesso como filho de '" + dadosPai + "'.");
   }

   // Implementação do método que exclui um nó na árvore.
   @Override
   public boolean excluirNo(T dado) {
      NoBinario<T> noParaExcluir = buscarNo(dado);

      if (noParaExcluir == null) {
         System.out.println("Nó " + dado + " não encontrado para exclusão.");
         return false;
      }

      if (noParaExcluir == this.raiz) {
         System.out.println("Não é permitido excluir o nó raiz.");
         return false;
      }

      NoBinario<T> pai = noParaExcluir.getPai();

      // Desconecta o nó do pai
      if (pai.getEsquerda() == noParaExcluir) {
         pai.setEsquerda(null);
      } else if (pai.getDireita() == noParaExcluir) {
         pai.setDireita(null);
      }

      // OBS: Isso exclui o nó E TODOS OS SEUS FILHOS (sub-árvore)
      // O Garbage Collector do Java limpará os nós órfãos
      System.out.println("Nó " + dado + " e seus descendentes foram excluídos.");
      return true;
   }

   // --- Métodos de Caminhamento ---

   @Override
   public void imprimirPreOrdem() {
      imprimirPreOrdemRecursivo(this.raiz, 0);
   }
   
   private void imprimirPreOrdemRecursivo(NoBinario<T> noAtual, int nivel) {
      if (noAtual == null) return;
      System.out.println(indentacao(nivel) + " " + noAtual.getDado()); // 1. Raiz
      imprimirPreOrdemRecursivo(noAtual.getEsquerda(), nivel + 1); // 2. Esquerda
      imprimirPreOrdemRecursivo(noAtual.getDireita(), nivel + 1); // 3. Direita
   }

   @Override
   public void imprimirPosOrdem() {
      imprimirPosOrdemRecursivo(this.raiz, 0);
   }
   
   private void imprimirPosOrdemRecursivo(NoBinario<T> noAtual, int nivel) {
      if (noAtual == null) return;
      imprimirPosOrdemRecursivo(noAtual.getEsquerda(), nivel + 1); // 1. Esquerda
      imprimirPosOrdemRecursivo(noAtual.getDireita(), nivel + 1); // 2. Direita
      System.out.println(indentacao(nivel) + " " + noAtual.getDado()); // 3. Raiz
   }

   @Override
   public void imprimirNaOrdem() {
      imprimirNaOrdemRecursivo(this.raiz, 0);
   }
   
   private void imprimirNaOrdemRecursivo(NoBinario<T> noAtual, int nivel) {
      if (noAtual == null) return;
      imprimirNaOrdemRecursivo(noAtual.getEsquerda(), nivel + 1); // 1. Esquerda
      System.out.println(indentacao(nivel) + " " + noAtual.getDado()); // 2. Raiz
      imprimirNaOrdemRecursivo(noAtual.getDireita(), nivel + 1); // 3. Direita
   }

   // Helper para indentação (similar ao original)
   private String indentacao(int nivel) {
      if (nivel == 0) return "";
      return " ".repeat(nivel * 3) + "|- ";
   }

   // --- Métodos Utilitários ---

   @Override
   public NoBinario<T> getRaiz() { return this.raiz; }

   @Override
   public boolean isVazia() { return this.raiz == null; }
}