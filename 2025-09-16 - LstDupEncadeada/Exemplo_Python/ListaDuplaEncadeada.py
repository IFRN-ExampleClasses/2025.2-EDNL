# ------------------------------------------------------------------------
# Classe ListaDuplaEncadeada
# Implementa a interface ListaDuplaEncadeadaInterface
# ------------------------------------------------------------------------

from Node import Node
from ListaDuplaEncadeadaInterface import ListaDuplaEncadeadaInterface

class ListaDuplaEncadeada(ListaDuplaEncadeadaInterface):
   def __init__(self) -> None:
      self.head: Node | None = None
      self.tail: Node | None = None
      self.tamanho: int = 0

   def InserirNoInicio(self, codigo: str, nome: str, carga: int) -> bool:
      try:
         novo = Node(codigo, nome, carga)
         if self.EstaVazia():
            self.head = self.tail = novo
         else:
            novo.no_proximo = self.head
            self.head.no_anterior = novo
            self.head = novo
         self.tamanho += 1
         return True
      except:
         return False

   def InserirNoFim(self, codigo: str, nome: str, carga: int) -> bool:
      try:
         novo = Node(codigo, nome, carga)
         if self.EstaVazia():
            self.head = self.tail = novo
         else:
            self.tail.no_proximo = novo
            novo.no_anterior = self.tail
            self.tail = novo
         self.tamanho += 1
         return True
      except:
         return False

   def InserirNaPosicao(self, codigo: str, nome: str, carga: int, posicao: int) -> bool:
      if posicao < 0 or posicao > self.tamanho:
         return False
      if posicao == 0:
         return self.InserirNoInicio(codigo, nome, carga)
      if posicao == self.tamanho:
         return self.InserirNoFim(codigo, nome, carga)
      try:
         novo = Node(codigo, nome, carga)
         atual = self.head
         for _ in range(posicao - 1):
            atual = atual.no_proximo
         proximo = atual.no_proximo
         novo.no_proximo = proximo
         novo.no_anterior = atual
         atual.no_proximo = novo
         if proximo:
            proximo.no_anterior = novo
         self.tamanho += 1
         return True
      except:
         return False

   def RemoverPorCodigo(self, codigo: str) -> bool:
      if self.EstaVazia():
         return False
      atual = self.head
      while atual and atual.codigo_disciplina != codigo:
         atual = atual.no_proximo
      if not atual:
         return False
      if atual == self.head:
         self.head = atual.no_proximo
         if self.head:
            self.head.no_anterior = None
         else:
            self.tail = None
      elif atual == self.tail:
         self.tail = atual.no_anterior
         if self.tail:
            self.tail.no_proximo = None
         else:
            self.head = None
      else:
         atual.no_anterior.no_proximo = atual.no_proximo
         atual.no_proximo.no_anterior = atual.no_anterior
      self.tamanho -= 1
      return True

   def BuscarPorCodigo(self, codigo: str) -> Node | None:
      atual = self.head
      while atual:
         if atual.codigo_disciplina == codigo:
            return atual
         atual = atual.no_proximo
      return None

   def AtualizarDisciplina(self, codigo: str, novo_nome: str, nova_carga: int) -> bool:
      alvo = self.BuscarPorCodigo(codigo)
      if alvo:
         alvo.nome_disciplina = novo_nome
         alvo.carga_horaria = nova_carga
         return True
      return False

   def ImprimirLista(self) -> None:
      print("---- Conteúdo da Lista ----")
      atual = self.head
      idx = 0
      while atual:
         print(f"[{idx}] Código: {atual.codigo_disciplina} | Nome: {atual.nome_disciplina} | Carga Horária: {atual.carga_horaria}")
         atual = atual.no_proximo
         idx += 1
      print("---------------------------")

   def EstaVazia(self) -> bool:
      return self.tamanho == 0

   def Tamanho(self) -> int:
      return self.tamanho
