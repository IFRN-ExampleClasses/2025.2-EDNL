# ------------------------------------------------------------------------
# testeListaPrioridadePQ.py
# Programa principal para demonstrar todas as operações da lista de prioridade
# ------------------------------------------------------------------------
from Node import Node
from ListaPrioridadePQ import ListaPrioridadePQ

def main():
    lista = ListaPrioridadePQ()

    # -----------------------------------------------------------------
    # Inserção de elementos
    # -----------------------------------------------------------------
    lista.inserir(Node("TEC.0007", "Programação de Computadores", 120, 1))
    lista.inserir(Node("TEC.0020", "Estrutura de Dados Lineares", 80, 2))
    lista.inserir(Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80, 3))
    lista.inserir(Node("TEC.0142", "Programação para Redes", 120, 3))
    lista.inserir(Node("TEC.0022", "Bancos de Dados", 80, 1))

    # -----------------------------------------------------------------
    # Imprimir lista
    # -----------------------------------------------------------------
    lista.imprimirLista()
    print("Tamanho da lista:", lista.tamanho())
    print("--------------------------------------")

    # -----------------------------------------------------------------
    # Buscar elemento
    # -----------------------------------------------------------------
    busca = lista.buscar("TEC.0020")
    if busca:
        print("Disciplina encontrada:", busca.nomeDisciplinaProp)
    else:
        print("Disciplina não encontrada.")
    print("--------------------------------------")

    # -----------------------------------------------------------------
    # Atualizar disciplina
    # -----------------------------------------------------------------
    lista.atualizar(Node("TEC.0020", "Estrutura de Dados Lineares Avançada", 100, 2))
    lista.imprimirLista()
    print("Tamanho da lista após atualização:", lista.tamanho())
    print("--------------------------------------")

    # -----------------------------------------------------------------
    # Remover disciplina
    # -----------------------------------------------------------------
    lista.remover("TEC.0007")
    lista.imprimirLista()
    print("Tamanho da lista após remoção:", lista.tamanho())

if __name__ == "__main__":
    main()
