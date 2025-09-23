# ------------------------------------------------------------------------
# pilha.py
# Implementação da pilha encadeada (LIFO) em Python.
# Mantém o atributo 'tamanho' otimizado.
# ------------------------------------------------------------------------
from Node import Node
from PilhaInterface import PilhaInterface

class Pilha(PilhaInterface):
   def __init__(self):
      self.__topo: Node | None = None
      self.__tamanho: int = 0

   # ------------------------------------------------------------------
   # push: insere no topo
   # ------------------------------------------------------------------
   def push(self, novo: Node) -> bool:
      if novo is None:
         return False
      novo.next = self.__topo
      self.__topo = novo
      self.__tamanho += 1
      return True

   # ------------------------------------------------------------------
   # pop: remove e retorna o topo
   # ------------------------------------------------------------------
   def pop(self) -> Node | None:
      if self.isEmpty():
         return None
      removido = self.__topo
      self.__topo = self.__topo.next
      removido.next = None
      self.__tamanho -= 1
      return removido

   # ------------------------------------------------------------------
   def peek(self) -> Node | None:
      return self.__topo

   def isEmpty(self) -> bool:
      return self.__topo is None

   def tamanho(self) -> int:
      return self.__tamanho

   # ------------------------------------------------------------------
   def imprimirLista(self):
      print("------ PILHA (topo -> fundo) ------")
      atual = self.__topo
      while atual:
         print(atual)
         atual = atual.next
      print("------ FIM DA PILHA ------")

   # ------------------------------------------------------------------
   def buscarPorCodigo(self, codigo_disciplina: str) -> Node | None:
      atual = self.__topo
      while atual:
         if atual.codigoDisciplina == codigo_disciplina:
            return atual
         atual = atual.next
      return None

   def contains(self, codigo_disciplina: str) -> bool:
      return self.buscarPorCodigo(codigo_disciplina) is not None

   def atualizar(self, codigo_disciplina: str, novo_nome: str, nova_carga: int) -> bool:
      alvo = self.buscarPorCodigo(codigo_disciplina)
      if alvo is None:
         return False
      alvo.nomeDisciplina = novo_nome
      alvo.cargaHoraria = nova_carga
      return True

   def removerPorCodigo(self, codigo_disciplina: str) -> bool:
      if self.isEmpty():
         return False
      # Caso especial: topo
      if self.__topo.codigoDisciplina == codigo_disciplina:
         self.pop()
         return True
      anterior = self.__topo
      atual = self.__topo.next
      while atual:
         if atual.codigoDisciplina == codigo_disciplina:
            anterior.next = atual.next
            atual.next = None
            self.__tamanho -= 1
            return True
         anterior = atual
         atual = atual.next
      return False

   def clear(self):
      while not self.isEmpty():
         self.pop()
