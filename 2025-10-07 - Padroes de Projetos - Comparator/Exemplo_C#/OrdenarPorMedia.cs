using System.Collections.Generic;

public class OrdenarPorMedia : IComparer<Aluno>
{
   public int Compare(Aluno a1, Aluno a2)
   {
      return a2.Media.CompareTo(a1.Media); // ordem decrescente
   }
}
