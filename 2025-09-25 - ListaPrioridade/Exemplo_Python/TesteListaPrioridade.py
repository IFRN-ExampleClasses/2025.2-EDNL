# ------------------------------------------------------------------------
# TesteListaPrioridade.py
# Programa principal para demonstrar todas as operações da lista
# ------------------------------------------------------------------------
from Node import Node
from ListaPrioridade import ListaPrioridade

if __name__ == "__main__":
    lista = ListaPrioridade()

    # Inserção de elementos conforme exemplo
    lista.inserir(Node("TEC.0007", "Programação de Computadores", 120, 1))
    lista.inserir(Node("TEC.0020", "Estrutura de Dados Lineares", 80, 2))
    lista.inserir(Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80, 3))
    lista.inserir(Node("TEC.0142", "Programação para Redes", 120, 3))
    lista.inserir(Node("TEC.0022", "Bancos de Dados", 80, 1))

    # Imprimir lista após inserções
    lista.imprimirLista()
    print(f"Tamanho da lista: {lista.tamanho()}")
    print("--------------------------------------")

    # Buscar elemento
    busca = lista.buscar("TEC.0020")
    if busca:
        print(f"Disciplina encontrada: {busca.getNomeDisciplina()}")
    else:
        print("Disciplina não encontrada.")
    print("--------------------------------------")

    # Atualizar disciplina
    lista.atualizar(Node("TEC.0020", "Estrutura de Dados Lineares Avançada", 100, 2))
    lista.imprimirLista()
    print(f"Tamanho da lista após atualização: {lista.tamanho()}")
    print("--------------------------------------")

    # Remover disciplina
    lista.remover("TEC.0007")
    lista.imprimirLista()
    print(f"Tamanho da lista após remoção: {lista.tamanho()}")