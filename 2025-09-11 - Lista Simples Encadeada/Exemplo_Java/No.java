// ------------------------------------------------------------------------
// Classe Nó
// Representa cada elemento da lista com dado e ponteiro para o próximo
// ------------------------------------------------------------------------
public class No
{
   int dado;   // valor armazenado
   No proximo; // referência para o próximo nó

   public No(int dado)
   {
      this.dado = dado;
      this.proximo = null;
   }
}
