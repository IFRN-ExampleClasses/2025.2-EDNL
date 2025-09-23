# ------------------------------------------------------------------------
# node.py
# Nó da fila, contendo dados da disciplina.
# ------------------------------------------------------------------------
class Node:
   def __init__(self, codigo_disciplina: str = "",
                nome_disciplina: str = "",
                carga_horaria: int = 0):
      self.__codigo_disciplina = codigo_disciplina
      self.__nome_disciplina = nome_disciplina
      self.__carga_horaria = carga_horaria
      self.__next = None

   @property
   def codigoDisciplina(self) -> str:
      return self.__codigo_disciplina
   @codigoDisciplina.setter
   def codigoDisciplina(self, v: str):
      self.__codigo_disciplina = v

   @property
   def nomeDisciplina(self) -> str:
      return self.__nome_disciplina
   @nomeDisciplina.setter
   def nomeDisciplina(self, v: str):
      self.__nome_disciplina = v

   @property
   def cargaHoraria(self) -> int:
      return self.__carga_horaria
   @cargaHoraria.setter
   def cargaHoraria(self, v: int):
      self.__carga_horaria = v

   @property
   def next(self):
      return self.__next
   @next.setter
   def next(self, v):
      self.__next = v

   def __str__(self):
      return f"[codigo:{self.__codigo_disciplina} | nome:{self.__nome_disciplina} | carga:{self.__carga_horaria}]"
