# ------------------------------------------------------------------------
# dequeInterface.py
# Interface que declara os métodos públicos esperados para a Deque
# ------------------------------------------------------------------------
from abc import ABC, abstractmethod

class DequeInterface(ABC):
   @abstractmethod
   def inserirNoInicio(self, codigoDisciplina, nomeDisciplina, cargaHoraria): pass

   @abstractmethod
   def inserirNoFim(self, codigoDisciplina, nomeDisciplina, cargaHoraria): pass

   @abstractmethod
   def removerDoInicio(self): pass

   @abstractmethod
   def removerDoFim(self): pass

   @abstractmethod
   def removerPorCodigo(self, codigoDisciplina): pass

   @abstractmethod
   def buscarPorCodigo(self, codigoDisciplina): pass

   @abstractmethod
   def atualizarPorCodigo(self, codigoDisciplina, novoNome, novaCarga): pass

   @abstractmethod
   def imprimirDeque(self): pass

   @abstractmethod
   def tamanho(self): pass

   @abstractmethod
   def estaVazio(self): pass
