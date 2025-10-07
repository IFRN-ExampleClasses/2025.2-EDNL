using System;
using System.Collections;
using System.Collections.Generic;

public class EstanteIterator : IEnumerator<Livro> {
   private List<Livro> livros;
   private int posicao = -1;

   public EstanteIterator(List<Livro> livros) {
      this.livros = livros;
   }

   public List<Livro> Livros {
      get { return livros; }
      set { livros = value; }
   }

   public int Posicao {
      get { return posicao; }
      set { posicao = value; }
   }

   public Livro Current {
      get { return livros[posicao]; }
   }

   object IEnumerator.Current {
      get { return Current; }
   }

   public bool MoveNext() {
      posicao++;
      return posicao < livros.Count && livros[posicao] != null;
   }

   public void Reset() {
      posicao = -1;
   }

   public void Dispose() {
      // Não há recursos não gerenciados, então nada a fazer aqui
   }
}
