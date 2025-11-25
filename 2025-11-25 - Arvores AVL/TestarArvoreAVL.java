import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestarArvoreAVL {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("=== Teste de Carga para Árvore AVL ===");

      try {
         // Configuração dos dados de entrada
         System.out.print("Quantidade de nós (números) a inserir: ");
         int qtd = scanner.nextInt();

         System.out.print("Valor Mínimo: ");
         int min = scanner.nextInt();

         System.out.print("Valor Máximo: ");
         int max = scanner.nextInt();

         // 1. Gera os números usando a classe auxiliar
         GeradorDeNumeros gerador = new GeradorDeNumeros(qtd, min, max);
         List<Integer> chavesParaInserir = gerador.getResultado();

         // 2. Exibe os números gerados (que seriam inseridos na árvore)
         System.out.println("\nNúmeros gerados (sem repetição):");
         System.out.println(chavesParaInserir);

         // TODO: Aqui você chamaria sua classe ArvoreAVL
         // Exemplo:
         // ArvoreAVL arvore = new ArvoreAVL();
         // for (Integer valor : chavesParaInserir) {
         //    arvore.inserir(valor);
         // }

      } catch (IllegalArgumentException e) {
         System.err.println("Erro na configuração: " + e.getMessage());
      } catch (Exception e) {
         System.err.println("Erro inesperado. Verifique os dados.");
      } finally {
         scanner.close();
      }
   }
}