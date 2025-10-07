# ------------------------------------------------------------------------
# Interface (classe base) ListaDuplaEncadeadaInterface
# ------------------------------------------------------------------------

from abc import ABC, abstractmethod
from Node import Node

class ListaDuplaEncadeadaInterface(ABC):

   @abstractmethod
   def InserirNoInicio(self, codigo: str, nome: str, carga: int) -> bool:
      pass

   @abstractmethod
   def InserirNoFim(self, codigo: str, nome: str, carga: int) -> bool:
      pass

   @abstractmethod
   def InserirNaPosicao(self, codigo: str, nome: str, carga: int, posicao: int) -> bool:
      pass

   @abstractmethod
   def RemoverPorCodigo(self, codigo: str) -> bool:
      pass

   @abstractmethod
   def BuscarPorCodigo(self, codigo: str) -> Node | None:
      pass

   @abstractmethod
   def AtualizarDisciplina(self, codigo: str, novo_nome: str, nova_carga: int) -> bool:
      pass

   @abstractmethod
   def ImprimirLista(self) -> None:
      pass

   @abstractmethod
   def EstaVazia(self) -> bool:
      pass

   @abstractmethod
   def Tamanho(self) -> int:
      pass
