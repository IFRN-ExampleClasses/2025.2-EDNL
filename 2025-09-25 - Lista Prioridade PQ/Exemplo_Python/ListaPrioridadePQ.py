# ------------------------------------------------------------------------
# listaPrioridadePQ.py
# Implementação da lista de prioridade usando heapq
# Todos os métodos e atributos em camelCase
# ------------------------------------------------------------------------
import heapq
from Node import Node
from ListaPrioridadeInterface import ListaPrioridadeInterface

class ListaPrioridadePQ(ListaPrioridadeInterfce):
    def __init__(self):
        self._heap = []  # lista interna usada pelo heapq
        self._elementos = {}  # dicionário para acesso rápido por codigoDisciplina

    # ---------------------------------------------------------------------
    # Inserir elemento
    # ---------------------------------------------------------------------
    def inserir(self, novoNode):
        if novoNode is None:
            return False
        if novoNode.codigoDisciplinaProp in self._elementos:
            return False
        heapq.heappush(self._heap, novoNode)
        self._elementos[novoNode.codigoDisciplinaProp] = novoNode
        return True

    # ---------------------------------------------------------------------
    # Remover elemento pelo código da disciplina
    # ---------------------------------------------------------------------
    def remover(self, codigoDisciplina):
        if codigoDisciplina not in self._elementos:
            return False
        nodeRemover = self._elementos.pop(codigoDisciplina)
        self._heap.remove(nodeRemover)
        heapq.heapify(self._heap)
        return True

    # ---------------------------------------------------------------------
    # Buscar elemento pelo código da disciplina
    # ---------------------------------------------------------------------
    def buscar(self, codigoDisciplina):
        return self._elementos.get(codigoDisciplina, None)

    # ---------------------------------------------------------------------
    # Atualizar disciplina existente
    # ---------------------------------------------------------------------
    def atualizar(self, nodeAtualizado):
        if nodeAtualizado is None:
            return False
        if self.remover(nodeAtualizado.codigoDisciplinaProp):
            return self.inserir(nodeAtualizado)
        return False

    # ---------------------------------------------------------------------
    # Imprimir lista completa
    # ---------------------------------------------------------------------
    def imprimirLista(self):
        temp = sorted(self._heap)  # cria lista ordenada temporária
        print("Lista de Prioridade (ordenada por semestre):")
        for node in temp:
            print(node.toStringNode())

    # ---------------------------------------------------------------------
    # Retornar tamanho da lista
    # ---------------------------------------------------------------------
    def tamanho(self):
        return len(self._heap)
