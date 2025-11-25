/**
 * Arquivo...: MenuArvore.java
 * Finalidade: Gerencia toda a lógica de execução das
 * operações da árvore. Atua como a "camada de serviço"
 * para a classe de teste principal.
 *
 * Ela recebe os dados prontos de quem a chamou.
 */
import java.util.Scanner;

public class MenuArvore {

   /**
    * Rotina para a OPÇÃO 1: CRIAR ÁRVORE.
    * Recebe o nome da raiz e um array de tuplas (Pai, Filho).
    *
    * @param nomeRaiz O nome do nó raiz (ex: "/").
    * @param tuplas Um array de String[2] onde [0] é o pai e [1] é o filho.
    * @return A nova árvore construída.
    */
   public static ArvoreGenerica<String> executarCriarArvore(String nomeRaiz, String[][] tuplas) {
      System.out.println("\n--- Criando Árvore Padrão ---");
      try {
         // 1. Instancia a árvore com o nome da raiz
         NoArvore<String> noRaiz = new NoArvore<>(nomeRaiz);
         ArvoreGenerica<String> arvore = new ArvoreGenerica<>(noRaiz);

         // 2. Itera sobre o array de tuplas para inserir os nós
         for (String[] tupla : tuplas) {
            String pai = tupla[0];
            String filho = tupla[1];
            // O método inserirNo já imprime o status de cada inserção
            arvore.inserirNo(pai, filho);
         }
         
         System.out.println("Árvore inicial construída com sucesso.");
         arvore.imprimirPreOrdem();
         return arvore;

      } catch (Exception e) {
         System.out.println("ERRO na construção inicial: " + e.getMessage());
         return null; // Retorna nulo se a criação da raiz falhar
      }
   }

   /**
    * Rotina para INSERIR um nó.
    * Recebe o nome do pai e do filho como argumentos.
    */
   public static void executarInserirNo(ArvoreGenerica<String> arvore, String pai, String filho) {
      System.out.println("\n--- Inserindo Nó ---");
      try {
         arvore.inserirNo(pai, filho);
         System.out.println("Inserção concluída.");
         
      } catch (IllegalArgumentException e) { // Dado nulo/branco
         System.out.println("ERRO na inserção: " + e.getMessage());
      } catch (Exception e) { // Pai não encontrado
         System.out.println("ERRO na inserção: " + e.getMessage());
      }
   }

   /**
    * Rotina para EXCLUIR um nó.
    * Recebe o nome do nó a ser excluído como argumento.
    */
   public static void executarExcluirNo(ArvoreGenerica<String> arvore, String dado) {
      System.out.println("\n--- Excluindo Nó ---");
      // O método da árvore já imprime o status
      arvore.excluirNo(dado);
   }

   /**
    * Rotina para EDITAR um nó.
    * Recebe o nome antigo e o novo nome como argumentos.
    */
   public static void executarEditarNo(ArvoreGenerica<String> arvore, String dadoAntigo, String dadoNovo) {
      System.out.println("\n--- Editando Nó ---");
      // O método da árvore já imprime o status e trata exceções
      arvore.editarNo(dadoAntigo, dadoNovo);
   }

   /**
    * Rotina para BUSCAR um nó e exibir seus detalhes.
    * Recebe o nome do nó a ser buscado como argumento.
    */
   public static void executarBuscarNo(ArvoreGenerica<String> arvore, String dado) {
      System.out.println("\n--- Buscando Nó ---");
      
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

   /**
    * Rotina para exibir informações gerais da árvore.
    */
   public static void executarExibirInformacoes(ArvoreGenerica<String> arvore) {
      System.out.println("\n--- Informações da Árvore ---");
      System.out.println("Tamanho da árvore (total de nós): " + arvore.getTamanho());
      System.out.println("Altura da árvore: " + arvore.getAltura());
      System.out.println("Nó Raiz: " + arvore.getRaiz().getDado());
   }
}