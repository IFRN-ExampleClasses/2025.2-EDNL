# ------------------------------------------------------------------------
# ListaPrioridadeInterface.py
# Interface que define os métodos públicos da lista de prioridade
# ------------------------------------------------------------------------
from abc import ABC, abstractmethod
from Node import Node

class ListaPrioridadeInterface(ABC):
    @abstractmethod
    def inserir(self, novoNode: Node) -> bool:
        """ Inserir mantendo a prioridade """
        pass

    @abstractmethod
    def remover(self, codigoDisciplina: str) -> bool:
        """ Remover por código da disciplina """
        pass

    @abstractmethod
    def buscar(self, codigoDisciplina: str) -> Node:
        """ Buscar por código """
        pass

    @abstractmethod
    def atualizar(self, nodeAtualizado: Node) -> bool:
        """ Atualizar disciplina existente """
        pass

    @abstractmethod
    def imprimirLista(self) -> None:
        """ Imprimir todos os elementos """
        pass

    @abstractmethod
    def tamanho(self) -> int:
        """ Retorna o tamanho da lista """
        pass