# ------------------------------------------------------------------------
# fila_interface.py
# Interface conceitual para a Fila (Queue).
# ------------------------------------------------------------------------
from abc import ABC, abstractmethod

class FilaInterface(ABC):
   @abstractmethod
   def enqueue(self, novo): pass

   @abstractmethod
   def dequeue(self): pass

   @abstractmethod
   def front(self): pass

   @abstractmethod
   def isEmpty(self) -> bool: pass

   @abstractmethod
   def tamanho(self) -> int: pass

   @abstractmethod
   def imprimirLista(self): pass

   @abstractmethod
   def buscarPorCodigo(self, codigo_disciplina: str): pass

   @abstractmethod
   def contains(self, codigo_disciplina: str) -> bool: pass

   @abstractmethod
   def atualizar(self, codigo_disciplina: str, novo_nome: str, nova_carga: int) -> bool: pass

   @abstractmethod
   def removerPorCodigo(self, codigo_disciplina: str) -> bool: pass

   @abstractmethod
   def clear(self): pass
