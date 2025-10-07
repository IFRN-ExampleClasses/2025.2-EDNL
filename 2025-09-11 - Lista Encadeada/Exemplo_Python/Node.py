# ------------------------------------------------------------------------
# Classe Node (Nó) para a Lista Encadeada
# Campos: codigoDisciplina, nomeDisciplina, cargaHoraria
# Referência: noProximo (próximo nó da lista)
# Atributos privados e métodos getters e setters
# ------------------------------------------------------------------------
class Node:
   def __init__(self, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int):
      self.__codigoDisciplina = codigoDisciplina
      self.__nomeDisciplina = nomeDisciplina
      self.__cargaHoraria = cargaHoraria
      self.__noProximo = None

   # Getters e setters
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
   def noProximo(self):
      return self.__noProximo

   @noProximo.setter
   def noProximo(self, valor):
      self.__noProximo = valor
