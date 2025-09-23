# ------------------------------------------------------------------------
# pilha_interface.py
# Interface conceitual da pilha (apenas para referência de métodos).
# Em Python não é obrigatório, mas serve como guia de documentação.
# ------------------------------------------------------------------------
from abc import ABC, abstractmethod

class PilhaInterface(ABC):
   @abstractmethod
   def push(self, novo): pass

   @abstractmethod
   def pop(self): pass

   @abstractmethod
   def peek(self): pass

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
