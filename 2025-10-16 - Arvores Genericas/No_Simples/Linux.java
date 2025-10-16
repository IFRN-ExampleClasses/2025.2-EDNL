// Arquivo: Linux.java
public class Linux {
   public static void main(String[] args) {
      // Criando os nós individuais
      No<String> raiz = new No<>("Árvore de Diretórios do Linux");
      No<String> diretorioHome = new No<>("home");
      No<String> diretorioEtc  = new No<>("etc");
      No<String> diretorioBin  = new No<>("bin");
      No<String> diretorioUsr  = new No<>("usr");

      // Construindo a hierarquia completa
      raiz.adicionarFilho(diretorioHome);
      raiz.adicionarFilho(diretorioEtc);
      raiz.adicionarFilho(diretorioBin);
      raiz.adicionarFilho(diretorioUsr);

      diretorioHome.adicionarFilho(new No<>("user1"));
      diretorioHome.adicionarFilho(new No<>("user2"));
      diretorioHome.adicionarFilho(new No<>("user3"));

      diretorioUsr.adicionarFilho(new No<>("bin"));
      diretorioUsr.adicionarFilho(new No<>("local"));
      diretorioUsr.adicionarFilho(new No<>("sbin"));
      diretorioUsr.adicionarFilho(new No<>("temp"));

      // Executando os caminhamentos
      ArvoreGenerica<String> arvoreLinux = new ArvoreGenerica<>(raiz);
      System.out.println("Exemplo: Árvore de Diretórios do Linux");
      arvoreLinux.imprimirPreOrdem();
      arvoreLinux.imprimirPosOrdem();
   }
}