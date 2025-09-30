# ------------------------------------------------------------------------
# ListaPrioridade.py
# Implementação da Lista de Prioridade baseada no semestre
# ------------------------------------------------------------------------
from Node import Node
from ListaPrioridadeInterface import ListaPrioridadeInterface

class ListaPrioridade(ListaPrioridadeInterface):
    def __init__(self):
        self._inicio = None
        self._tamanhoLista = 0

    def inserir(self, novoNode: Node) -> bool:
        """ Inserir nó mantendo a prioridade (menor semestre = maior prioridade) """
        if not novoNode:
            return False
        
        if self.buscar(novoNode.getCodigoDisciplina()):
            return False

        if self._inicio is None or novoNode.getSemestre() < self._inicio.getSemestre():
            novoNode.setProximo(self._inicio)
            self._inicio = novoNode
        else:
            atual = self._inicio
            while (atual.getProximo() is not None and 
                   atual.getProximo().getSemestre() <= novoNode.getSemestre()):
                atual = atual.getProximo()
            novoNode.setProximo(atual.getProximo())
            atual.setProximo(novoNode)
        
        self._tamanhoLista += 1
        return True

    def remover(self, codigoDisciplina: str) -> bool:
        """ Remover nó pelo código da disciplina """
        if self._inicio is None or codigoDisciplina is None:
            return False

        if self._inicio.getCodigoDisciplina() == codigoDisciplina:
            self._inicio = self._inicio.getProximo()
            self._tamanhoLista -= 1
            return True

        atual = self._inicio
        while (atual.getProximo() is not None and 
               atual.getProximo().getCodigoDisciplina() != codigoDisciplina):
            atual = atual.getProximo()

        if atual.getProximo() is not None:
            proximoNode = atual.getProximo().getProximo()
            atual.setProximo(proximoNode)
            self._tamanhoLista -= 1
            return True

        return False

    def buscar(self, codigoDisciplina: str) -> Node:
        """ Buscar nó pelo código da disciplina """
        atual = self._inicio
        while atual is not None:
            if atual.getCodigoDisciplina() == codigoDisciplina:
                return atual
            atual = atual.getProximo()
        return None

    def atualizar(self, nodeAtualizado: Node) -> bool:
        """ Atualizar disciplina existente """
        if not nodeAtualizado:
            return False

        if self.remover(nodeAtualizado.getCodigoDisciplina()):
            return self.inserir(nodeAtualizado)

        return False

    def imprimirLista(self) -> None:
        """ Imprimir lista completa """
        atual = self._inicio
        print("Lista de Prioridade:")
        while atual is not None:
            print(f"{atual.getCodigoDisciplina()} – {atual.getNomeDisciplina()} "
                  f"({atual.getCargaHoraria()}h) - Semestre {atual.getSemestre()}")
            atual = atual.getProximo()

    def tamanho(self) -> int:
        """ Retornar tamanho da lista """
        return self._tamanhoLista