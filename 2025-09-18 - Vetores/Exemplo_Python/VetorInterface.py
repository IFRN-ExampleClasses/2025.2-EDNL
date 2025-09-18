# ------------------------------------------------------------------------
# vetor_interface.py
# Interface que declara os métodos públicos da estrutura Vetor
# ------------------------------------------------------------------------
from abc import ABC, abstractmethod
from Node import Node

class VetorInterface(ABC):

   @abstractmethod
   def inserir(self, item: Node) -> bool: pass

   @abstractmethod
   def inserirEm(self, item: Node, pos: int) -> bool: pass

   @abstractmethod
   def removerPorCodigo(self, codigo: str) -> bool: pass

   @abstractmethod
   def removerPorPosicao(self, pos: int) -> bool: pass

   @abstractmethod
   def buscarPorCodigo(self, codigo: str) -> Node | None: pass

   @abstractmethod
   def atualizarPorCodigo(self, codigo: str, novo: Node) -> bool: pass

   @abstractmethod
   def imprimirVetor(self) -> None: pass

   @abstractmethod
   def tamanho(self) -> int: pass

   @abstractmethod
   def estaVazio(self) -> bool: pass
