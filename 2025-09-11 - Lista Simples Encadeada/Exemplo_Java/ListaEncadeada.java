// ------------------------------------------------------------------------
// Implementação da Lista Simplesmente Encadeada
// Implementa todos os métodos definidos em ListaEncadeadaInterface
// ------------------------------------------------------------------------
public class ListaEncadeada implements ListaEncadeadaInterface
{
   private No cabeca; // início da lista

   // ---------------------------------------------------------------------
   // Inserções
   @Override
   public void inserirNoInicio(int valor)
   {
      No novoNo = new No(valor);
      novoNo.proximo = cabeca;
      cabeca = novoNo;
   }

   @Override
   public void inserirNoFim(int valor)
   {
      No novoNo = new No(valor);
      if (cabeca == null)
      {
         cabeca = novoNo;
         return;
      }
      No atual = cabeca;
      while (atual.proximo != null)
      {
         atual = atual.proximo;
      }
      atual.proximo = novoNo;
   }

   @Override
   public void inserirNaPosicao(int valor, int posicao)
   {
      if (posicao < 0)
      {
         System.out.println("Posição inválida");
         return;
      }
      if (posicao == 0)
      {
         inserirNoInicio(valor);
         return;
      }

      No atual = cabeca;
      int indice = 0;
      while (atual != null && indice < posicao - 1)
      {
         atual = atual.proximo;
         indice++;
      }

      if (atual == null)
      {
         System.out.println("Posição fora do alcance");
         return;
      }

      No novoNo = new No(valor);
      novoNo.proximo = atual.proximo;
      atual.proximo = novoNo;
   }

   // ---------------------------------------------------------------------
   // Remoções
   @Override
   public void removerInicio()
   {
      if (cabeca != null)
         cabeca = cabeca.proximo;
   }

   @Override
   public void removerPorValor(int valor)
   {
      if (cabeca == null) return;
      if (cabeca.dado == valor)
      {
         cabeca = cabeca.proximo;
         return;
      }
      No atual = cabeca;
      while (atual.proximo != null && atual.proximo.dado != valor)
      {
         atual = atual.proximo;
      }
      if (atual.proximo != null)
      {
         atual.proximo = atual.proximo.proximo;
      }
   }

   @Override
   public void removerNaPosicao(int posicao)
   {
      if (cabeca == null || posicao < 0) return;
      if (posicao == 0)
      {
         cabeca = cabeca.proximo;
         return;
      }

      No atual = cabeca;
      int indice = 0;
      while (atual.proximo != null && indice < posicao - 1)
      {
         atual = atual.proximo;
         indice++;
      }

      if (atual.proximo != null)
      {
         atual.proximo = atual.proximo.proximo;
      }
   }

   // ---------------------------------------------------------------------
   // Buscas
   @Override
   public boolean buscarPorValor(int valor)
   {
      No atual = cabeca;
      while (atual != null)
      {
         if (atual.dado == valor) return true;
         atual = atual.proximo;
      }
      return false;
   }

   @Override
   public Integer obterNaPosicao(int posicao)
   {
      if (posicao < 0) return null;
      No atual = cabeca;
      int indice = 0;
      while (atual != null && indice < posicao)
      {
         atual = atual.proximo;
         indice++;
      }
      if (atual == null) return null;
      return atual.dado;
   }

   // ---------------------------------------------------------------------
   // Atualizações
   @Override
   public void atualizarPorValor(int valorAntigo, int novoValor)
   {
      No atual = cabeca;
      while (atual != null)
      {
         if (atual.dado == valorAntigo)
         {
            atual.dado = novoValor;
            return;
         }
         atual = atual.proximo;
      }
      System.out.println("Valor " + valorAntigo + " não encontrado.");
   }

   @Override
   public void atualizarNaPosicao(int posicao, int novoValor)
   {
      if (posicao < 0)
      {
         System.out.println("Posição inválida");
         return;
      }
      No atual = cabeca;
      int indice = 0;
      while (atual != null && indice < posicao)
      {
         atual = atual.proximo;
         indice++;
      }
      if (atual == null)
      {
         System.out.println("Posição fora do alcance");
         return;
      }
      atual.dado = novoValor;
   }

   // ---------------------------------------------------------------------
   // Impressão
   @Override
   public void imprimirLista()
   {
      No atual = cabeca;
      while (atual != null)
      {
         System.out.print(atual.dado + " -> ");
         atual = atual.proximo;
      }
      System.out.println("null");
   }
}
