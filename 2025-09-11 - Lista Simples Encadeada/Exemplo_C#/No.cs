// ------------------------------------------------------------------------
// Classe Nó
// Representa cada elemento da lista com dado e ponteiro para o próximo
// ------------------------------------------------------------------------
public class No
{
   public int Dado;      // valor armazenado
   public No Proximo;    // referência para o próximo nó

   public No(int dado)
   {
      Dado = dado;
      Proximo = null;
   }
}
