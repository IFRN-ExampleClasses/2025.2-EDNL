# ------------------------------------------------------------------------
# Classe Node
# Representa um nó da lista duplamente encadeada, armazenando dados
# da disciplina e referências para o próximo e o anterior.
# ------------------------------------------------------------------------
from __future__ import annotations  # Permite usar 'Node' como tipo dentro da própria classe

class Node:
   def __init__(self, codigo_disciplina: str, nome_disciplina: str, carga_horaria: int) -> None:
      self.__codigo_disciplina: str = codigo_disciplina
      self.__nome_disciplina: str = nome_disciplina
      self.__carga_horaria: int = carga_horaria
      self.__no_proximo: Node | None = None
      self.__no_anterior: Node | None = None

   # Getters e Setters
   @property
   def codigo_disciplina(self) -> str:
      return self.__codigo_disciplina

   @codigo_disciplina.setter
   def codigo_disciplina(self, valor: str) -> None:
      self.__codigo_disciplina = valor

   @property
   def nome_disciplina(self) -> str:
      return self.__nome_disciplina

   @nome_disciplina.setter
   def nome_disciplina(self, valor: str) -> None:
      self.__nome_disciplina = valor

   @property
   def carga_horaria(self) -> int:
      return self.__carga_horaria

   @carga_horaria.setter
   def carga_horaria(self, valor: int) -> None:
      self.__carga_horaria = valor

   @property
   def no_proximo(self) -> Node | None:
      return self.__no_proximo

   @no_proximo.setter
   def no_proximo(self, valor: Node | None) -> None:
      self.__no_proximo = valor

   @property
   def no_anterior(self) -> Node | None:
      return self.__no_anterior

   @no_anterior.setter
   def no_anterior(self, valor: Node | None) -> None:
      self.__no_anterior = valor
