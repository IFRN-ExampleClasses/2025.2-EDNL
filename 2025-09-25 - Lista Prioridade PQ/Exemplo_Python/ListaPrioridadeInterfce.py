# ------------------------------------------------------------------------
# ListaPrioridadeInterfce.py
# Interface que define os métodos da lista de prioridade
# ------------------------------------------------------------------------
from abc import ABC, abstractmethod

class ListaPrioridadeInterfce(ABC):
    @abstractmethod
    def inserir(self, novoNode):
        pass

    @abstractmethod
    def remover(self, codigoDisciplina):
        pass

    @abstractmethod
    def buscar(self, codigoDisciplina):
        pass

    @abstractmethod
    def atualizar(self, nodeAtualizado):
        pass

    @abstractmethod
    def imprimirLista(self):
        pass

    @abstractmethod
    def tamanho(self):
        pass
