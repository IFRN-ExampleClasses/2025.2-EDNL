# ------------------------------------------------------------------------
# Node.py
# Classe Node (No) que representa um elemento na tabela hash (encadeamento)
# Campos privados: codigoDisciplina, nomeDisciplina, cargaHoraria, periodoCurso
# Também possui referência privada para o próximo nó (usado no encadeamento)
# ------------------------------------------------------------------------

class Node:
   """
   Representa um nó contendo informações da disciplina.
   Usado nas listas encadeadas que compõem cada bucket da tabela hash.
   """

   def __init__(self, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int, periodoCurso: int):
      # Atributos privados (name mangling)
      self.__codigoDisciplina = codigoDisciplina
      self.__nomeDisciplina = nomeDisciplina
      self.__cargaHoraria = cargaHoraria
      self.__periodoCurso = periodoCurso
      # Referência para encadeamento (próximo nó)
      self.__next = None

   # ---------------------------------------------------------------------
   # Getters e setters (camelCase)
   # ---------------------------------------------------------------------
   def getCodigoDisciplina(self) -> str:
      return self.__codigoDisciplina

   def setCodigoDisciplina(self, codigoDisciplina: str):
      self.__codigoDisciplina = codigoDisciplina

   def getNomeDisciplina(self) -> str:
      return self.__nomeDisciplina

   def setNomeDisciplina(self, nomeDisciplina: str):
      self.__nomeDisciplina = nomeDisciplina

   def getCargaHoraria(self) -> int:
      return self.__cargaHoraria

   def setCargaHoraria(self, cargaHoraria: int):
      self.__cargaHoraria = cargaHoraria

   def getPeriodoCurso(self) -> int:
      return self.__periodoCurso

   def setPeriodoCurso(self, periodoCurso: int):
      self.__periodoCurso = periodoCurso

   def getNext(self):
      return self.__next

   def setNext(self, nextNode):
      self.__next = nextNode

   # Representação para debug/impressão
   def __repr__(self):
      return f"Node({self.__codigoDisciplina}, {self.__nomeDisciplina}, {self.__cargaHoraria}h, Período {self.__periodoCurso})"
