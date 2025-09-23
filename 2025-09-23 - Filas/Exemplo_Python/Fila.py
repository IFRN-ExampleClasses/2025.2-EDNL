# ------------------------------------------------------------------------
# fila.py
# Implementação de uma fila encadeada (FIFO) em Python.
# Mantém tamanho otimizado.
# ------------------------------------------------------------------------
from Node import Node
from FilaInterface import FilaInterface

class Fila(FilaInterface):
   def __init__(self):
      self.__frente: Node | None = None
      self.__tras: Node | None = None
      self.__tamanho: int = 0

   # ------------------------------------------------------------------
   # enqueue: insere no final da fila
   # ------------------------------------------------------------------
   def enqueue(self, novo: Node) -> bool:
      if novo is None:
         return False
      if self.__tras is None:
         self.__frente = self.__tras = novo
      else:
         self.__tras.next = novo
         self.__tras = novo
      self.__tamanho += 1
      return True

   # ------------------------------------------------------------------
   # dequeue: remove e retorna o nó da frente
   # ------------------------------------------------------------------
   def dequeue(self) -> Node | None:
      if self.isEmpty():
         return None
      removido = self.__frente
      self.__frente = self.__frente.next
      if self.__frente is None:
         self.__tras = None
      removido.next = None
      self.__tamanho -= 1
      return removido

   # ------------------------------------------------------------------
   def front(self) -> Node | None:
      return self.__frente

   def isEmpty(self) -> bool:
      return self.__frente is None

   def tamanho(self) -> int:
      return self.__tamanho

   def imprimirLista(self):
      print("------ FILA (frente -> trás) ------")
      atual = self.__frente
      while atual:
         print(atual)
         atual = atual.next
      print("------ FIM DA FILA ------")

   # ------------------------------------------------------------------
   def buscarPorCodigo(self, codigo_disciplina: str) -> Node | None:
      atual = self.__frente
      while atual:
         if atual.codigoDisciplina == codigo_disciplina:
            return atual
         atual = atual.next
      return None

   def contains(self, codigo_disciplina: str) -> bool:
      return self.buscarPorCodigo(codigo_disciplina) is not None

   def atualizar(self, codigo_disciplina: str, novo_nome: str, nova_carga: int) -> bool:
      alvo = self.buscarPorCodigo(codigo_disciplina)
      if alvo:
         alvo.nomeDisciplina = novo_nome
         alvo.cargaHoraria = nova_carga
         return True
      return False

   # ------------------------------------------------------------------
   # removerPorCodigo: remove nó com o código indicado (não apenas frente)
   # ------------------------------------------------------------------
   def removerPorCodigo(self, codigo_disciplina: str) -> bool:
      if self.isEmpty():
         return False
      # Se é o primeiro
      if self.__frente.codigoDisciplina == codigo_disciplina:
         self.dequeue()
         return True
      anterior = self.__frente
      atual = self.__frente.next
      while atual:
         if atual.codigoDisciplina == codigo_disciplina:
            anterior.next = atual.next
            if atual == self.__tras:
               self.__tras = anterior
            atual.next = None
            self.__tamanho -= 1
            return True
         anterior = atual
         atual = atual.next
      return False

   def clear(self):
      while not self.isEmpty():
         self.dequeue()
