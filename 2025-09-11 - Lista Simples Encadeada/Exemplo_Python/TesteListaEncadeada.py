# ------------------------------------------------------------------------
# Programa de Teste da Lista Simplesmente Encadeada
# ------------------------------------------------------------------------
from ListaEncadeada import ListaEncadeada

def main():
    lista = ListaEncadeada()

    # Inserções
    lista.InserirNoInicio(10)
    lista.InserirNoFim(5)
    lista.InserirNaPosicao(20, 1)   # insere na posição 1
    lista.ImprimirLista()           # 10 -> 20 -> 5 -> None

    # Atualizações
    lista.AtualizarPorValor(20, 25)
    lista.ImprimirLista()           # 10 -> 25 -> 5 -> None

    lista.AtualizarNaPosicao(2, 15)
    lista.ImprimirLista()           # 10 -> 25 -> 15 -> None

    # Remoções
    lista.RemoverInicio()
    lista.ImprimirLista()           # 25 -> 15 -> None

    lista.RemoverPorValor(25)
    lista.ImprimirLista()           # 15 -> None

    lista.RemoverNaPosicao(0)
    lista.ImprimirLista()           # None

if __name__ == "__main__":
    main()
