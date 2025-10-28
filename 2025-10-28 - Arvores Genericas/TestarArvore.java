import java.util.InputMismatchException;
import java.util.Scanner;

public class TestarArvore {

   public static void main(String[] args) {
      
      ArvoreGenerica<String> arvoreLinux = null;
      int opcao = -1;
      
      try (Scanner scanner = new Scanner(System.in)) {
         while (opcao != 0) {
            OpcoesArvore.exibirMenu();
            try {
               opcao = scanner.nextInt();
               scanner.nextLine();
               if (arvoreLinux == null && (opcao != 1 && opcao != 0)) {
                  System.out.println("\nERRO: Nenhuma árvore foi criada. Por favor, use a opção 1 primeiro.");
                  continue; }
               switch (opcao) {
                  case 1:
                     if (arvoreLinux != null) {
                        System.out.print("Atenção: A árvore atual será perdida. Deseja continuar? (S/N): ");
                        String confirmacao = scanner.nextLine().trim().toUpperCase();
                        if (!confirmacao.equals("S")) {
                           System.out.println("Criação cancelada.");
                           break;
                        }
                     }
                     String nomeRaiz = "/";
                     String[][] tuplas = {
                        {"/", "home"}, {"/", "etc"}, {"/", "bin"}, {"/", "usr"},
                        {"home", "user1"}, {"home", "user2"}, {"home", "user3"},
                        {"usr", "bin"}, {"usr", "local"}, {"usr", "sbin"}, {"usr", "tmp"}
                     };
                     arvoreLinux = OpcoesArvore.executarCriarArvore(nomeRaiz, tuplas);
                     break;
                  case 2:
                     OpcoesArvore.executarInserirNo(arvoreLinux, "home", "user4");
                     break;
                  case 3:
                    OpcoesArvore.executarExcluirNo(arvoreLinux, "user2");
                     break;
                  case 4:
                     OpcoesArvore.executarEditarNo(arvoreLinux, "user4", "newUser4");
                     break;
                  case 5:
                     OpcoesArvore.executarBuscarNo(arvoreLinux, "user4");
                     break;
                  case 6:
                     arvoreLinux.imprimirPreOrdem();
                     break;
                  case 7:
                     arvoreLinux.imprimirPosOrdem();
                     break;
                  case 8:
                     arvoreLinux.imprimirNaOrdem();
                     break;
                  case 9:
                     OpcoesArvore.executarExibirInformacoes(arvoreLinux);
                     break;
                  case 0:
                     System.out.println("Saindo...");
                     break;
                  default:
                     System.out.println("\nERRO: Opção inválida. Tente novamente.");
               }
               
            } catch (InputMismatchException e) {
               System.out.println("\nERRO: Por favor, digite apenas um número (de 0 a 9).");
               scanner.nextLine();
               opcao = -1;
            }
         }        
      }
      System.out.println("\n--- Programa Finalizado ---");
   }
}