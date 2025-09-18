# ------------------------------------------------------------------------
# vetor.py
# Implementação da interface VetorInterface usando lista dinâmica do Python
# Inclui:
#  - Verificação de códigos duplicados
#  - Incremento/decremento do atributo tamanho
# ------------------------------------------------------------------------
from VetorInterface import VetorInterface
from Node import Node

class Vetor(VetorInterface):
   def __init__(self):
      self.__elementos: list[Node] = []
      self.__tamanho: int = 0

   # -------------------- Métodos auxiliares --------------------
   def __existeCodigo(self, codigo: str) -> bool:
      for elem in self.__elementos:
         if elem.getCodigoDisciplina() == codigo:
            return True
      return False

   # -------------------- Operações principais --------------------
   def inserir(self, item: Node) -> bool:
      if not item or not item.getCodigoDisciplina():
         return False
      if self.__existeCodigo(item.getCodigoDisciplina()):
         print(f"Falha: código duplicado ({item.getCodigoDisciplina()})")
         return False
      self.__elementos.append(item)
      self.__tamanho += 1
      return True

   def inserirEm(self, item: Node, pos: int) -> bool:
      if not item or not item.getCodigoDisciplina():
         return False
      if pos < 0 or pos > self.__tamanho:
         return False
      if self.__existeCodigo(item.getCodigoDisciplina()):
         print(f"Falha: código duplicado ({item.getCodigoDisciplina()})")
         return False
      self.__elementos.insert(pos, item)
      self.__tamanho += 1
      return True

   def removerPorCodigo(self, codigo: str) -> bool:
      for i, elem in enumerate(self.__elementos):
         if elem.getCodigoDisciplina() == codigo:
            del self.__elementos[i]
            self.__tamanho -= 1
            return True
      return False

   def removerPorPosicao(self, pos: int) -> bool:
      if pos < 0 or pos >= self.__tamanho:
         return False
      del self.__elementos[pos]
      self.__tamanho -= 1
      return True

   def buscarPorCodigo(self, codigo: str) -> Node | None:
      for elem in self.__elementos:
         if elem.getCodigoDisciplina() == codigo:
            return elem
      return None

   def atualizarPorCodigo(self, codigo: str, novo: Node) -> bool:
      if not novo or not novo.getCodigoDisciplina():
         return False
      for i, elem in enumerate(self.__elementos):
         if elem.getCodigoDisciplina() == codigo:
            # evita duplicar caso mude o código
            if codigo != novo.getCodigoDisciplina() and self.__existeCodigo(novo.getCodigoDisciplina()):
               print(f"Falha: novo código duplicado ({novo.getCodigoDisciplina()})")
               return False
            self.__elementos[i] = novo
            return True
      return False

   def imprimirVetor(self) -> None:
      print(f"Vetor (tamanho={self.__tamanho}):")
      for i, elem in enumerate(self.__elementos):
         print(f"   [{i}] -> {elem}")

   def tamanho(self) -> int:
      return self.__tamanho

   def estaVazio(self) -> bool:
      return self.__tamanho == 0
