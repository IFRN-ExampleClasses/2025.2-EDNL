using System;

public class Biblioteca {
   public static void Main(string[] args) {
      EstanteDeLivros minhaEstante = new EstanteDeLivros();

      minhaEstante.Adicionar(new Livro("O Senhor dos Anéis", "J. R. R. Tolkien", "Fantasia"));
      minhaEstante.Adicionar(new Livro("O Guia do Mochileiro das Galáxias", "Douglas Adams", "Ficção Científica"));
      minhaEstante.Adicionar(new Livro("1984", "George Orwell", "Distopia"));
      minhaEstante.Adicionar(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));

      foreach (Livro livro in minhaEstante) {
         Console.WriteLine(livro);
      }
   }
}
