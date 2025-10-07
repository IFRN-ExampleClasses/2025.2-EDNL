import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EstanteDeLivros implements Iterable<Livro> {
   private List<Livro> livros;

   public EstanteDeLivros() {
      this.livros = new ArrayList<>();
   }

   public List<Livro> getLivros() {
      return livros;
   }

   public void setLivros(List<Livro> livros) {
      this.livros = livros;
   }

   public void adicionar(Livro livro) {
      this.livros.add(livro);
   }

   @Override
   public Iterator<Livro> iterator() {
      return new EstanteIterator(this.livros);
   }
}
