# ------------------------------------------------------------------------
# Interface (classe abstrata) da Lista Encadeada
# Simula interface usando abc (classe abstrata)
# ------------------------------------------------------------------------
from abc import ABC, abstractmethod

class ListaEncadeadaInterface(ABC):
   @abstractmethod
   def inserirNoInicio(self, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int) -> bool:
      pass

   @abstractmethod
   def inserirNoFim(self, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int) -> bool:
      pass

   @abstractmethod
   def inserirNaPosicao(self, posicao: int, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int) -> bool:
      pass

   @abstractmethod
   def removerPorCodigo(self, codigoDisciplina: str) -> bool:
      pass

   @abstractmethod
   def buscarPorCodigo(self, codigoDisciplina: str) -> bool:
      pass

   @abstractmethod
   def atualizarDisciplina(self, codigoDisciplina: str, novoNome: str, novaCargaHoraria: int) -> bool:
      pass

   @abstractmethod
   def imprimirLista(self) -> None:
      pass

   @abstractmethod
   def tamanho(self) -> int:
      pass

   @abstractmethod
   def estaVazia(self) -> bool:
      pass
