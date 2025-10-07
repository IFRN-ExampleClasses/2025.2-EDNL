public class Aluno {
   private String nome;
   private float nota1;
   private float nota2;
   private float media;

   public Aluno(String nome, float nota1, float nota2) {
      this.nome = nome;
      this.nota1 = nota1;
      this.nota2 = nota2;
      calcularMedia();
   }

   private void calcularMedia() {
      this.media = (nota1 + nota2) / 2;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public float getNota1() {
      return nota1;
   }

   public void setNota1(float nota1) {
      this.nota1 = nota1;
      calcularMedia();
   }

   public float getNota2() {
      return nota2;
   }

   public void setNota2(float nota2) {
      this.nota2 = nota2;
      calcularMedia();
   }

   public float getMedia() {
      return media;
   }

   @Override
   public String toString() {
      return "Aluno(Nome=" + nome + 
             ", Nota1=" + nota1 + 
             ", Nota2=" + nota2 + 
             ", Média=" + media + ")";
   }
}
