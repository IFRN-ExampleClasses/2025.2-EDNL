// ------------------------------------------------------------------------
// Programa de Teste da Lista Simplesmente Encadeada
// Demonstra as operações de inserção, atualização, remoção e impressão
// ------------------------------------------------------------------------
public class TesteListaEncadeada
{
   public static void main(String[] args)
   {
      ListaEncadeadaInterface lista = new ListaEncadeada();

      // Inserções
      lista.inserirNoInicio(10);
      lista.inserirNoFim(5);
      lista.inserirNaPosicao(20, 1); // insere na posição 1
      lista.imprimirLista(); // 10 -> 20 -> 5 -> null

      // Atualizações
      lista.atualizarPorValor(20, 25);
      lista.imprimirLista(); // 10 -> 25 -> 5 -> null

      lista.atualizarNaPosicao(2, 15);
      lista.imprimirLista(); // 10 -> 25 -> 15 -> null

      // Remoções
      lista.removerInicio();
      lista.imprimirLista(); // 25 -> 15 -> null

      lista.removerPorValor(25);
      lista.imprimirLista(); // 15 -> null

      lista.removerNaPosicao(0);
      lista.imprimirLista(); // null
   }
}
