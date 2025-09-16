# ------------------------------------------------------------------------
# Programa principal de teste da ListaDuplaEncadeada
# ------------------------------------------------------------------------
from ListaDuplaEncadeada import ListaDuplaEncadeada

def main() -> None:
   lista = ListaDuplaEncadeada()

   print("== Inserções ==")
   lista.InserirNoInicio("INF101", "Algoritmos", 60)
   lista.InserirNoFim("INF102", "Estruturas de Dados", 80)
   lista.InserirNoFim("INF103", "Banco de Dados", 70)
   lista.ImprimirLista()

   print("\n== Inserir em posições específicas ==")
   lista.InserirNaPosicao("INF150", "Lógica", 40, 1)
   lista.InserirNaPosicao("INF100", "Introdução", 30, 0)
   lista.InserirNaPosicao("INF200", "Redes", 50, lista.Tamanho())
   lista.ImprimirLista()

   print("\n== Atualização e remoção ==")
   print("Atualizar INF103:", lista.AtualizarDisciplina("INF103", "Banco Avançado", 90))
   print("Remover INF100:", lista.RemoverPorCodigo("INF100"))
   lista.ImprimirLista()

if __name__ == "__main__":
   main()
