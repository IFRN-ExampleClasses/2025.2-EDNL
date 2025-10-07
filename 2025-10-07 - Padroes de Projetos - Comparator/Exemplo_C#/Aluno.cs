public class Aluno
{
   private string nome;
   private float nota1;
   private float nota2;
   private float media;

   public Aluno(string nome, float nota1, float nota2)
   {
      this.nome = nome;
      this.nota1 = nota1;
      this.nota2 = nota2;
      CalcularMedia();
   }

   private void CalcularMedia()
   {
      this.media = (nota1 + nota2) / 2;
   }

   public string Nome
   {
      get { return nome; }
      set { nome = value; }
   }

   public float Nota1
   {
      get { return nota1; }
      set
      {
         nota1 = value;
         CalcularMedia();
      }
   }

   public float Nota2
   {
      get { return nota2; }
      set
      {
         nota2 = value;
         CalcularMedia();
      }
   }

   public float Media
   {
      get { return media; }
   }

   public override string ToString()
   {
      return $"Aluno(Nome={nome}, Nota1={nota1}, Nota2={nota2}, Média={media})";
   }
}
