# ------------------------------------------------------------------------
# Classe ListaEncadeada implementando a interface ListaEncadeadaInterface
# Mantém atributo tamanho atualizado nas inserções e remoções
# ------------------------------------------------------------------------
from Node import Node
from ListaEncadeadaInterface import ListaEncadeadaInterface

class ListaEncadeada(ListaEncadeadaInterface):
   def __init__(self):
      self.head = None
      self.__tamanho = 0

   def estaVazia(self) -> bool:
      return self.head is None

   def inserirNoInicio(self, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int) -> bool:
      novoNode = Node(codigoDisciplina, nomeDisciplina, cargaHoraria)
      novoNode.noProximo = self.head
      self.head = novoNode
      self.__tamanho += 1
      return True

   def inserirNoFim(self, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int) -> bool:
      novoNode = Node(codigoDisciplina, nomeDisciplina, cargaHoraria)
      if self.estaVazia():
         self.head = novoNode
      else:
         atual = self.head
         while atual.noProximo:
            atual = atual.noProximo
         atual.noProximo = novoNode
      self.__tamanho += 1
      return True

   def inserirNaPosicao(self, posicao: int, codigoDisciplina: str, nomeDisciplina: str, cargaHoraria: int) -> bool:
      if posicao < 0 or posicao > self.__tamanho:
         return False
      if posicao == 0:
         return self.inserirNoInicio(codigoDisciplina, nomeDisciplina, cargaHoraria)

      novoNode = Node(codigoDisciplina, nomeDisciplina, cargaHoraria)
      atual = self.head
      for _ in range(posicao - 1):
         atual = atual.noProximo
      novoNode.noProximo = atual.noProximo
      atual.noProximo = novoNode
      self.__tamanho += 1
      return True

   def removerPorCodigo(self, codigoDisciplina: str) -> bool:
      if self.estaVazia():
         return False

      if self.head.codigoDisciplina == codigoDisciplina:
         self.head = self.head.noProximo
         self.__tamanho -= 1
         return True

      atual = self.head
      while atual.noProximo:
         if atual.noProximo.codigoDisciplina == codigoDisciplina:
            atual.noProximo = atual.noProximo.noProximo
            self.__tamanho -= 1
            return True
         atual = atual.noProximo

      return False

   def buscarPorCodigo(self, codigoDisciplina: str) -> bool:
      atual = self.head
      while atual:
         if atual.codigoDisciplina == codigoDisciplina:
            return True
         atual = atual.noProximo
      return False

   def atualizarDisciplina(self, codigoDisciplina: str, novoNome: str, novaCargaHoraria: int) -> bool:
      atual = self.head
      while atual:
         if atual.codigoDisciplina == codigoDisciplina:
            atual.nomeDisciplina = novoNome
            atual.cargaHoraria = novaCargaHoraria
            return True
         atual = atual.noProximo
      return False

   def imprimirLista(self) -> None:
      if self.estaVazia():
         print("A lista está vazia.")
         return

      atual = self.head
      print("Lista de Disciplinas:")
      while atual:
         print(f"Código: {atual.codigoDisciplina}, Nome: {atual.nomeDisciplina}, Carga Horária: {atual.cargaHoraria}")
         atual = atual.noProximo

   def tamanho(self) -> int:
      return self.__tamanho
