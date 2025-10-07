public class Livro {
   private String titulo;
   private String autor;
   private String genero;

   public Livro(String titulo, String autor, String genero) {
      this.titulo = titulo;
      this.autor = autor;
      this.genero = genero;
   }

   // Getters e Setters
   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getAutor() {
      return autor;
   }

   public void setAutor(String autor) {
      this.autor = autor;
   }

   public String getGenero() {
      return genero;
   }

   public void setGenero(String genero) {
      this.genero = genero;
   }

   @Override
   public String toString() {
      return "Livro: " + titulo + 
             " | Autor: " + autor + 
             " | Gênero: " + genero;
   }
}
