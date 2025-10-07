import java.util.Comparator;

public class OrdenarPorNome implements Comparator<Aluno> {
   @Override
   public int compare(Aluno a1, Aluno a2) {
      return a1.getNome().compareToIgnoreCase(a2.getNome());
   }
}
