import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestarArvoreAVL {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("=== Teste de Carga para Árvore AVL ===");

      try {
         // ----------------------------------------------------------------------
         // Configuração dos dados de entrada
         System.out.print("Quantidade de nós (números) a inserir: ");
         int intQuantidade = scanner.nextInt();

         System.out.print("Valor Mínimo: ");
         int intValorMinimo = scanner.nextInt();

         System.out.print("Valor Máximo: ");
         int intValorMaximo = scanner.nextInt();


         // ----------------------------------------------------------------------
         // 1. Gera os números usando a classe auxiliar
         GeradorDeNumeros gerador = new GeradorDeNumeros(intQuantidade, intValorMinimo, intValorMaximo);
         List<Integer> chavesParaInserir = gerador.getResultado();


         // ----------------------------------------------------------------------
         // 2. Exibe os números gerados (que seriam inseridos na árvore)
         System.out.println("\nNúmeros gerados (sem repetição):");
         System.out.println(chavesParaInserir);


         // ----------------------------------------------------------------------
         // 3. Montando a árvore AVL

         // Usaremos <Integer> que já implementa Comparable
         ArvoreAVL<Integer> arvoreTeste = null;
         arvoreTeste = new ArvoreAVL<>();
         for (Integer valor : chavesParaInserir) {
            arvoreTeste.inserirNo(valor);
         }

         //arvoreTeste.exibirArvoreTerminal();
         //arvoreTeste.exibirArvoreGrafica();

      } catch (IllegalArgumentException e) {
         System.err.println("Erro na configuração: " + e.getMessage());
      } catch (Exception e) {
         System.err.println("Erro inesperado. Verifique os dados.");
      } finally {
         scanner.close();
      }
   }
}