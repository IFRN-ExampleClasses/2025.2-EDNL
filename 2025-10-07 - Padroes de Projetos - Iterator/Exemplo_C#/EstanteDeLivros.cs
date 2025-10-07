using System;
using System.Collections;
using System.Collections.Generic;

public class EstanteDeLivros : IEnumerable<Livro> {
   private List<Livro> livros;

   public EstanteDeLivros() {
      this.livros = new List<Livro>();
   }

   public List<Livro> Livros {
      get { return livros; }
      set { livros = value; }
   }

   public void Adicionar(Livro livro) {
      this.livros.Add(livro);
   }

   public IEnumerator<Livro> GetEnumerator() {
      return new EstanteIterator(this.livros);
   }

   IEnumerator IEnumerable.GetEnumerator() {
      return GetEnumerator();
   }
}
