# ------------------------------------------------------------------------
# deque.py
# Implementação da Deque (fila dupla) usando lista duplamente ligada
# ------------------------------------------------------------------------
from Node import Node
from DequeInterface import DequeInterface

class Deque(DequeInterface):
   def __init__(self):
      self.__inicio = None
      self.__fim = None
      self.__tamanho = 0

   # ---------------------------------------------------------------------
   # Método utilitário: verifica se código já existe
   # ---------------------------------------------------------------------
   def __existeCodigo(self, codigoDisciplina):
      atual = self.__inicio
      while atual is not None:
         if atual.codigoDisciplina == codigoDisciplina:
            return True
         atual = atual.proximo
      return False

   # ---------------------------------------------------------------------
   # Inserção no início
   # ---------------------------------------------------------------------
   def inserirNoInicio(self, codigoDisciplina, nomeDisciplina, cargaHoraria):
      if self.__existeCodigo(codigoDisciplina):
         raise ValueError(f"Código duplicado: {codigoDisciplina}")
      novo = Node(codigoDisciplina, nomeDisciplina, cargaHoraria)
      if self.estaVazio():
         self.__inicio = self.__fim = novo
      else:
         novo.proximo = self.__inicio
         self.__inicio.anterior = novo
         self.__inicio = novo
      self.__tamanho += 1

   # ---------------------------------------------------------------------
   # Inserção no fim
   # ---------------------------------------------------------------------
   def inserirNoFim(self, codigoDisciplina, nomeDisciplina, cargaHoraria):
      if self.__existeCodigo(codigoDisciplina):
         raise ValueError(f"Código duplicado: {codigoDisciplina}")
      novo = Node(codigoDisciplina, nomeDisciplina, cargaHoraria)
      if self.estaVazio():
         self.__inicio = self.__fim = novo
      else:
         self.__fim.proximo = novo
         novo.anterior = self.__fim
         self.__fim = novo
      self.__tamanho += 1

   # ---------------------------------------------------------------------
   # Remover do início
   # ---------------------------------------------------------------------
   def removerDoInicio(self):
      if self.estaVazio():
         raise IndexError("Deque vazia, não é possível remover do início.")
      if self.__inicio == self.__fim:
         self.__inicio = self.__fim = None
      else:
         self.__inicio = self.__inicio.proximo
         self.__inicio.anterior = None
      self.__tamanho -= 1

   # ---------------------------------------------------------------------
   # Remover do fim
   # ---------------------------------------------------------------------
   def removerDoFim(self):
      if self.estaVazio():
         raise IndexError("Deque vazia, não é possível remover do fim.")
      if self.__inicio == self.__fim:
         self.__inicio = self.__fim = None
      else:
         self.__fim = self.__fim.anterior
         self.__fim.proximo = None
      self.__tamanho -= 1

   # ---------------------------------------------------------------------
   # Remover por código
   # ---------------------------------------------------------------------
   def removerPorCodigo(self, codigoDisciplina):
      if self.estaVazio():
         raise IndexError("Deque vazia, não é possível remover.")
      atual = self.__inicio
      while atual is not None:
         if atual.codigoDisciplina == codigoDisciplina:
            if atual == self.__inicio:
               self.removerDoInicio()
               return
            if atual == self.__fim:
               self.removerDoFim()
               return
            anterior = atual.anterior
            proximo = atual.proximo
            anterior.proximo = proximo
            proximo.anterior = anterior
            self.__tamanho -= 1
            return
         atual = atual.proximo
      raise KeyError(f"Código não encontrado: {codigoDisciplina}")

   # ---------------------------------------------------------------------
   # Buscar por código
   # ---------------------------------------------------------------------
   def buscarPorCodigo(self, codigoDisciplina):
      atual = self.__inicio
      while atual is not None:
         if atual.codigoDisciplina == codigoDisciplina:
            return atual
         atual = atual.proximo
      raise KeyError(f"Código não encontrado: {codigoDisciplina}")

   # ---------------------------------------------------------------------
   # Atualizar por código
   # ---------------------------------------------------------------------
   def atualizarPorCodigo(self, codigoDisciplina, novoNome, novaCarga):
      encontrado = self.buscarPorCodigo(codigoDisciplina)
      encontrado.nomeDisciplina = novoNome
      encontrado.cargaHoraria = novaCarga

   # ---------------------------------------------------------------------
   # Imprimir
   # ---------------------------------------------------------------------
   def imprimirDeque(self):
      print("Deque (início -> fim):")
      if self.estaVazio():
         print("   [vazia]")
         return
      atual = self.__inicio
      while atual is not None:
         print("   " + str(atual))
         atual = atual.proximo

   # ---------------------------------------------------------------------
   # Tamanho e estado
   # ---------------------------------------------------------------------
   def tamanho(self):
      return self.__tamanho

   def estaVazio(self):
      return self.__tamanho == 0
