import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaAcademico {
   public static void main(String[] args) {
      List<Aluno> alunos = new ArrayList<>();

      alunos.add(new Aluno("Carlos", 8.5f, 9.0f));
      alunos.add(new Aluno("Ana", 9.2f, 8.8f));
      alunos.add(new Aluno("Beatriz", 7.8f, 8.0f));

      System.out.println("=== Lista Original ===");
      for (Aluno a : alunos) {
         System.out.println(a);
      }

      Collections.sort(alunos, new OrdenarPorNome());
      System.out.println("\n=== Alunos ordenados por nome ===");
      for (Aluno a : alunos) {
         System.out.println(a);
      }

      Collections.sort(alunos, new OrdenarPorMedia());
      System.out.println("\n=== Alunos ordenados por média (decrescente) ===");
      for (Aluno a : alunos) {
         System.out.println(a);
      }
   }
}
