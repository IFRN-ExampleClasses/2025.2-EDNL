# ------------------------------------------------------------------------
# node.py
# Classe que representa o nó da Deque (lista duplamente ligada)
# ------------------------------------------------------------------------
class Node:
   # ---------------------------------------------------------------------
   # Construtor
   # ---------------------------------------------------------------------
   def __init__(self, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int):
      self.__codigoDisciplina = codigoDisciplina
      self.__nomeDisciplina = nomeDisciplina
      self.__cargaHoraria = cargaHoraria
      self.__anterior = None
      self.__proximo = None

   # ---------------------------------------------------------------------
   # Getters e Setters (usando property em Python)
   # ---------------------------------------------------------------------
   @property
   def codigoDisciplina(self):
      return self.__codigoDisciplina

   @codigoDisciplina.setter
   def codigoDisciplina(self, valor):
      self.__codigoDisciplina = valor

   @property
   def nomeDisciplina(self):
      return self.__nomeDisciplina

   @nomeDisciplina.setter
   def nomeDisciplina(self, valor):
      self.__nomeDisciplina = valor

   @property
   def cargaHoraria(self):
      return self.__cargaHoraria

   @cargaHoraria.setter
   def cargaHoraria(self, valor):
      self.__cargaHoraria = valor

   @property
   def anterior(self):
      return self.__anterior

   @anterior.setter
   def anterior(self, valor):
      self.__anterior = valor

   @property
   def proximo(self):
      return self.__proximo

   @proximo.setter
   def proximo(self, valor):
      self.__proximo = valor

   # ---------------------------------------------------------------------
   # Representação em string
   # ---------------------------------------------------------------------
   def __str__(self):
      return f"{self.__codigoDisciplina} – {self.__nomeDisciplina} ({self.__cargaHoraria}h)"
