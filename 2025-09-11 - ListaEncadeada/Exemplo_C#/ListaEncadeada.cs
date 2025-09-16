// ------------------------------------------------------------------------
// Classe ListaEncadeada que implementa a interface ListaEncadeadaInterface
// Mantém atributo tamanho atualizado nas inserções e remoções
// ------------------------------------------------------------------------
public class ListaEncadeada : ListaEncadeadaInterface
{
   private Node head;
   private int tamanho;

   public ListaEncadeada()
   {
      head = null;
      tamanho = 0;
   }

   public bool estaVazia()
   {
      return head == null;
   }

   public bool inserirNoInicio(string codigoDisciplina, string nomeDisciplina, int cargaHoraria)
   {
      Node novoNode = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      novoNode.NoProximo = head;
      head = novoNode;
      tamanho++;
      return true;
   }

   public bool inserirNoFim(string codigoDisciplina, string nomeDisciplina, int cargaHoraria)
   {
      Node novoNode = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      if (estaVazia())
      {
         head = novoNode;
      }
      else
      {
         Node atual = head;
         while (atual.NoProximo != null)
         {
            atual = atual.NoProximo;
         }
         atual.NoProximo = novoNode;
      }
      tamanho++;
      return true;
   }

   public bool inserirNaPosicao(int posicao, string codigoDisciplina, string nomeDisciplina, int cargaHoraria)
   {
      if (posicao < 0 || posicao > tamanho) return false;

      if (posicao == 0) return inserirNoInicio(codigoDisciplina, nomeDisciplina, cargaHoraria);

      Node novoNode = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      Node atual = head;
      for (int i = 0; i < posicao - 1; i++)
      {
         atual = atual.NoProximo;
      }
      novoNode.NoProximo = atual.NoProximo;
      atual.NoProximo = novoNode;
      tamanho++;
      return true;
   }

   public bool removerPorCodigo(string codigoDisciplina)
   {
      if (estaVazia()) return false;

      if (head.CodigoDisciplina == codigoDisciplina)
      {
         head = head.NoProximo;
         tamanho--;
         return true;
      }

      Node atual = head;
      while (atual.NoProximo != null)
      {
         if (atual.NoProximo.CodigoDisciplina == codigoDisciplina)
         {
            atual.NoProximo = atual.NoProximo.NoProximo;
            tamanho--;
            return true;
         }
         atual = atual.NoProximo;
      }

      return false;
   }

   public bool buscarPorCodigo(string codigoDisciplina)
   {
      Node atual = head;
      while (atual != null)
      {
         if (atual.CodigoDisciplina == codigoDisciplina)
         {
            return true;
         }
         atual = atual.NoProximo;
      }
      return false;
   }

   public bool atualizarDisciplina(string codigoDisciplina, string novoNome, int novaCargaHoraria)
   {
      Node atual = head;
      while (atual != null)
      {
         if (atual.CodigoDisciplina == codigoDisciplina)
         {
            atual.NomeDisciplina = novoNome;
            atual.CargaHoraria = novaCargaHoraria;
            return true;
         }
         atual = atual.NoProximo;
      }
      return false;
   }

   public void imprimirLista()
   {
      if (estaVazia())
      {
         Console.WriteLine("A lista está vazia.");
         return;
      }

      Node atual = head;
      Console.WriteLine("Lista de Disciplinas:");
      while (atual != null)
      {
         Console.WriteLine($"Código: {atual.CodigoDisciplina}, Nome: {atual.NomeDisciplina}, Carga Horária: {atual.CargaHoraria}");
         atual = atual.NoProximo;
      }
   }

   public int tamanho()
   {
      return tamanho;
   }
}
