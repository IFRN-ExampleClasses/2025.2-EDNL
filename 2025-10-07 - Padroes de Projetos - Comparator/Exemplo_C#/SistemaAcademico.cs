using System;
using System.Collections.Generic;

public class SistemaAcademico
{
   public static void Main(string[] args)
   {
      List<Aluno> alunos = new List<Aluno>();

      alunos.Add(new Aluno("Carlos", 8.5f, 9.0f));
      alunos.Add(new Aluno("Ana", 9.2f, 8.8f));
      alunos.Add(new Aluno("Beatriz", 7.8f, 8.0f));

      Console.WriteLine("=== Lista Original ===");
      foreach (Aluno a in alunos)
      {
         Console.WriteLine(a);
      }

      alunos.Sort(new OrdenarPorNome());
      Console.WriteLine("\n=== Alunos ordenados por nome ===");
      foreach (Aluno a in alunos)
      {
         Console.WriteLine(a);
      }

      alunos.Sort(new OrdenarPorMedia());
      Console.WriteLine("\n=== Alunos ordenados por média (decrescente) ===");
      foreach (Aluno a in alunos)
      {
         Console.WriteLine(a);
      }
   }
}
