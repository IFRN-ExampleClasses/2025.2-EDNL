# ------------------------------------------------------------------------
# node.py
# Representa um nó da pilha contendo dados da disciplina.
# ------------------------------------------------------------------------
class Node:
   # ---------------------------------------------------------------------
   # Construtor
   # ---------------------------------------------------------------------
   def __init__(self, codigo_disciplina: str = "",
                nome_disciplina: str = "",
                carga_horaria: int = 0):
      # atributos privados
      self.__codigo_disciplina = codigo_disciplina
      self.__nome_disciplina = nome_disciplina
      self.__carga_horaria = carga_horaria
      self.__next = None  # referência para o próximo nó

   # ---------------------------------------------------------------------
   # Getters e setters (propriedades em Python)
   # ---------------------------------------------------------------------
   @property
   def codigoDisciplina(self) -> str:
      return self.__codigo_disciplina

   @codigoDisciplina.setter
   def codigoDisciplina(self, value: str):
      self.__codigo_disciplina = value

   @property
   def nomeDisciplina(self) -> str:
      return self.__nome_disciplina

   @nomeDisciplina.setter
   def nomeDisciplina(self, value: str):
      self.__nome_disciplina = value

   @property
   def cargaHoraria(self) -> int:
      return self.__carga_horaria

   @cargaHoraria.setter
   def cargaHoraria(self, value: int):
      self.__carga_horaria = value

   @property
   def next(self):
      return self.__next

   @next.setter
   def next(self, value):
      self.__next = value

   # ---------------------------------------------------------------------
   # Representação textual do nó
   # ---------------------------------------------------------------------
   def __str__(self) -> str:
      return f"[codigo:{self.__codigo_disciplina} | nome:{self.__nome_disciplina} | carga:{self.__carga_horaria}]"
