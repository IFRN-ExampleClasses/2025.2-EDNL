using System.Collections.Generic;

public class OrdenarPorNome : IComparer<Aluno>
{
   public int Compare(Aluno a1, Aluno a2)
   {
      return string.Compare(a1.Nome, a2.Nome, System.StringComparison.OrdinalIgnoreCase);
   }
}
