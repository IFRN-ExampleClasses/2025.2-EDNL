# ------------------------------------------------------------------------
# node.py
# Classe que representa o elemento do vetor
# Campos: codigoDisciplina (str), nomeDisciplina (str), cargaHoraria (int)
# ------------------------------------------------------------------------
class Node:
   def __init__(self, codigo_disciplina: str = "", nome_disciplina: str = "", carga_horaria: int = 0):
      self.__codigoDisciplina = codigo_disciplina
      self.__nomeDisciplina = nome_disciplina
      self.__cargaHoraria = carga_horaria

   # -------------------- Getters e Setters --------------------
   def getCodigoDisciplina(self) -> str:
      return self.__codigoDisciplina

   def setCodigoDisciplina(self, codigo: str) -> None:
      self.__codigoDisciplina = codigo

   def getNomeDisciplina(self) -> str:
      return self.__nomeDisciplina

   def setNomeDisciplina(self, nome: str) -> None:
      self.__nomeDisciplina = nome

   def getCargaHoraria(self) -> int:
      return self.__cargaHoraria

   def setCargaHoraria(self, carga: int) -> None:
      self.__cargaHoraria = carga

   def __str__(self) -> str:
      return f"Node{{codigo='{self.__codigoDisciplina}', nome='{self.__nomeDisciplina}', carga={self.__cargaHoraria}}}"
