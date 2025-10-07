import java.util.Comparator;

public class OrdenarPorMedia implements Comparator<Aluno> {
   @Override
   public int compare(Aluno a1, Aluno a2) {
      return Float.compare(a2.getMedia(), a1.getMedia()); // decrescente
   }
}
