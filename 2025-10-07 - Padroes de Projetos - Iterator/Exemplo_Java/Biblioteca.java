public class Biblioteca {
   public static void main(String[] args) {
      EstanteDeLivros minhaEstante = new EstanteDeLivros();

      minhaEstante.adicionar(new Livro("O Senhor dos Anéis", "J. R. R. Tolkien", "Fantasia"));
      minhaEstante.adicionar(new Livro("O Guia do Mochileiro das Galáxias", "Douglas Adams", "Ficção Científica"));
      minhaEstante.adicionar(new Livro("1984", "George Orwell", "Distopia"));
      minhaEstante.adicionar(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));

      for (Livro livro : minhaEstante) {
         System.out.println(livro);
      }
   }
}
