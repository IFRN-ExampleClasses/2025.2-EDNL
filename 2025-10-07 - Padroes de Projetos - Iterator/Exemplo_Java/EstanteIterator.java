import java.util.Iterator;
import java.util.List;

public class EstanteIterator implements Iterator<Livro> {
   private List<Livro> livros;
   private int posicao = 0;

   public EstanteIterator(List<Livro> livros) {
      this.livros = livros;
   }

   public List<Livro> getLivros() {
      return livros;
   }

   public void setLivros(List<Livro> livros) {
      this.livros = livros;
   }

   public int getPosicao() {
      return posicao;
   }

   public void setPosicao(int posicao) {
      this.posicao = posicao;
   }

   @Override
   public boolean hasNext() {
      return posicao < livros.size() && livros.get(posicao) != null;
   }

   @Override
   public Livro next() {
      return livros.get(posicao++);
   }
}
