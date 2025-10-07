using System;

public class Livro {
   private string titulo;
   private string autor;
   private string genero;

   public Livro(string titulo, string autor, string genero) {
      this.titulo = titulo;
      this.autor = autor;
      this.genero = genero;
   }

   public string Titulo {
      get { return titulo; }
      set { titulo = value; }
   }

   public string Autor {
      get { return autor; }
      set { autor = value; }
   }

   public string Genero {
      get { return genero; }
      set { genero = value; }
   }

   public override string ToString() {
      return $"Livro: {titulo} | Autor: {autor} | Gênero: {genero}";
   }
}
