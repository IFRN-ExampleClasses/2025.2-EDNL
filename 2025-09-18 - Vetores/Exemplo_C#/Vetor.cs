// ------------------------------------------------------------------------
// Vetor.cs
// Implementação da interface VetorInterface usando array dinâmico
// ------------------------------------------------------------------------
public class Vetor : VetorInterface
{
   private const int CAPACIDADE_INICIAL = 4;
   private Node[] elementos;
   private int qtd;

   public Vetor()
   {
      elementos = new Node[CAPACIDADE_INICIAL];
      qtd = 0;
   }

   public Vetor(int capacidadeInicial)
   {
      if (capacidadeInicial <= 0) capacidadeInicial = CAPACIDADE_INICIAL;
      elementos = new Node[capacidadeInicial];
      qtd = 0;
   }

   private void garantirCapacidade(int min)
   {
      if (min <= elementos.Length) return;
      int nova = elementos.Length * 2;
      if (nova < min) nova = min;
      Node[] novo = new Node[nova];
      for (int i = 0; i < qtd; i++) novo[i] = elementos[i];
      elementos = novo;
   }

   private bool existeCodigo(string codigo)
   {
      for (int i = 0; i < qtd; i++)
         if (elementos[i] != null && elementos[i].CodigoDisciplina == codigo)
            return true;
      return false;
   }

   public bool inserir(Node item)
   {
      if (item == null || item.CodigoDisciplina == null) return false;
      if (existeCodigo(item.CodigoDisciplina))
      {
         Console.WriteLine($"Falha: código duplicado ({item.CodigoDisciplina})");
         return false;
      }
      garantirCapacidade(qtd + 1);
      elementos[qtd++] = item;
      return true;
   }

   public bool inserirEm(Node item, int pos)
   {
      if (item == null || item.CodigoDisciplina == null) return false;
      if (pos < 0 || pos > qtd) return false;
      if (existeCodigo(item.CodigoDisciplina))
      {
         Console.WriteLine($"Falha: código duplicado ({item.CodigoDisciplina})");
         return false;
      }
      garantirCapacidade(qtd + 1);
      for (int i = qtd - 1; i >= pos; i--)
         elementos[i + 1] = elementos[i];
      elementos[pos] = item;
      qtd++;
      return true;
   }

   public bool removerPorCodigo(string codigo)
   {
      if (codigo == null) return false;
      int idx = -1;
      for (int i = 0; i < qtd; i++)
         if (elementos[i].CodigoDisciplina == codigo) { idx = i; break; }
      if (idx == -1) return false;
      for (int i = idx; i < qtd - 1; i++)
         elementos[i] = elementos[i + 1];
      elementos[qtd - 1] = null!;
      qtd--;
      return true;
   }

   public bool removerPorPosicao(int pos)
   {
      if (pos < 0 || pos >= qtd) return false;
      for (int i = pos; i < qtd - 1; i++)
         elementos[i] = elementos[i + 1];
      elementos[qtd - 1] = null!;
      qtd--;
      return true;
   }

   public Node? buscarPorCodigo(string codigo)
   {
      if (codigo == null) return null;
      for (int i = 0; i < qtd; i++)
         if (elementos[i].CodigoDisciplina == codigo) return elementos[i];
      return null;
   }

   public bool atualizarPorCodigo(string codigo, Node novo)
   {
      if (codigo == null || novo == null || novo.CodigoDisciplina == null)
         return false;
      for (int i = 0; i < qtd; i++)
      {
         if (elementos[i].CodigoDisciplina == codigo)
         {
            if (codigo != novo.CodigoDisciplina && existeCodigo(novo.CodigoDisciplina))
            {
               Console.WriteLine($"Falha: novo código duplicado ({novo.CodigoDisciplina})");
               return false;
            }
            elementos[i] = novo;
            return true;
         }
      }
      return false;
   }

   public void imprimirVetor()
   {
      Console.WriteLine($"Vetor (tamanho={qtd}, capacidade={elementos.Length}):");
      for (int i = 0; i < qtd; i++)
         Console.WriteLine($"   [{i}] -> {elementos[i]}");
   }

   public int tamanho() => qtd;

   public bool estaVazio() => qtd == 0;
}
