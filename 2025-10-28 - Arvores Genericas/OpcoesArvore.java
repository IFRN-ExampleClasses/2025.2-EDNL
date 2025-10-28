public class OpcoesArvore {

   // Método para exibir o menu principal.
   public static void exibirMenu() {
      System.out.println("--- Menu da Árvore Genérica ---");   
      System.out.println("1. Criar Árvore Padrão");
      System.out.println("2. Inserir Nó");
      System.out.println("3. Excluir Nó");
      System.out.println("4. Editar Nó");
      System.out.println("5. Buscar Nó");
      System.out.println("6. Imprimir Árvore em Pré-Ordem");
      System.out.println("7. Imprimir Árvore em Pós-Ordem");
      System.out.println("8. Imprimir Árvore em Em-Ordem");
      System.out.println("9. Exibir Informações da Árvore");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
   }  

   // Método para criar uma árvore padrão.
   public static ArvoreGenerica<String> executarCriarArvore(String nomeRaiz, String[][] tuplas) {
      System.out.println("\n--- Criando Árvore Padrão ---");
      try {
         NoArvore<String> noRaiz = new NoArvore<>(nomeRaiz);
         ArvoreGenerica<String> arvore = new ArvoreGenerica<>(noRaiz);
         for (String[] tupla : tuplas) {
            String pai = tupla[0];
            String filho = tupla[1];
            arvore.inserirNo(pai, filho);
         }         
         System.out.println("Árvore inicial construída com sucesso.");
         arvore.imprimirPreOrdem();
         return arvore;

      } catch (Exception e) {
         System.out.println("ERRO na construção inicial: " + e.getMessage());
         return null;
      }
   }

   // Método para inserir um nó.
   public static void executarInserirNo(ArvoreGenerica<String> arvore, String pai, String filho) {
      try {
         arvore.inserirNo(pai, filho);
         System.out.println("Inserção concluída.");
         
      } catch (IllegalArgumentException e) { // Dado nulo/branco
         System.out.println("ERRO na inserção: " + e.getMessage());
      } catch (Exception e) { // Pai não encontrado
         System.out.println("ERRO na inserção: " + e.getMessage());
      }
   }

   // Método para excluir um nó.
   public static void executarExcluirNo(ArvoreGenerica<String> arvore, String dado) {
      arvore.excluirNo(dado);
   }

   // Método para editar um nó.
   public static void executarEditarNo(ArvoreGenerica<String> arvore, String dadoAntigo, String dadoNovo) {
      arvore.editarNo(dadoAntigo, dadoNovo);
   }

   // Método para buscar um nó.
   public static void executarBuscarNo(ArvoreGenerica<String> arvore, String dado) {
      NoArvore<String> noEncontrado = arvore.buscarNo(dado);      
      if (noEncontrado != null) {
         System.out.println("Nó '" + dado + "' encontrado!");
         String pai = (noEncontrado.getPai() == null) 
                        ? "NENHUM (é a raiz)" 
                        : noEncontrado.getPai().getDado();
         System.out.println("   - Pai: " + pai);
         System.out.println("   - Quantidade de filhos: " + noEncontrado.getFilhos().size());
      } else {
         System.out.println("Nó '" + dado + "' não encontrado na árvore.");
      }
   }

   // Método para exibir informações da árvore.
   public static void executarExibirInformacoes(ArvoreGenerica<String> arvore) {
      System.out.println("\n--- Informações da Árvore ---");
      System.out.println("Tamanho da árvore (total de nós): " + arvore.getTamanho());
      System.out.println("Altura da árvore: " + arvore.getAltura());
      System.out.println("Nó Raiz: " + arvore.getRaiz().getDado());
   }
}