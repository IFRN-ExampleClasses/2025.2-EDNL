# ------------------------------------------------------------------------
# dictionary.py
# Implementação da tabela hash (dicionário) em Python com encadeamento (separate chaining)
# Utiliza classe Node para armazenar os dados das disciplinas.
#
# Observações:
#  - Funções públicas seguem camelCase.
#  - Atributos privados com getters/setters onde faz sentido.
#  - Método tamanho é mantido e atualizado incrementalmente.
#  - Métodos retornam booleano para sucesso/falha quando aplicável.
# ------------------------------------------------------------------------

from Node import Node
from DicionarioInterface import DicionarioInterface

class Dicionario(DicionarioInterface):
   """
   Implementação simples de tabela hash com encadeamento.
   """

   def __init__(self, capacidade: int = 11):
      # capacidade inicial (preferencialmente primo)
      self.__capacidade = capacidade
      # buckets: lista de referências para Node (início de listas encadeadas)
      self.__buckets = [None] * self.__capacidade
      # número de elementos
      self.__tamanho = 0
      # fator de carga para redimensionamento automático (opcional, mas mantemos simples)
      self.__fatorCargaLimite = 0.75

   # ---------------------------------------------------------------------
   # Funções utilitárias privadas
   # ---------------------------------------------------------------------
   def __hash(self, codigoDisciplina: str) -> int:
      """Função hash simples baseada em soma de códigos (poderia ser melhorada)."""
      # Uso de hash builtin mod capacity para simplicidade e robustez
      return abs(hash(codigoDisciplina)) % self.__capacidade

   def __resizeIfNeeded(self):
      """Redimensiona a tabela quando o fator de carga ultrapassa o limite."""
      if (self.__tamanho / self.__capacidade) > self.__fatorCargaLimite:
         # novo tamanho: próximo primo aproximado (dobro simples aqui)
         newCapacity = self.__capacidade * 2 + 1
         oldBuckets = self.__buckets
         self.__buckets = [None] * newCapacity
         oldCapacity = self.__capacidade
         self.__capacidade = newCapacity
         # re-hash dos nós
         for i in range(oldCapacity):
            current = oldBuckets[i]
            while current is not None:
               nextNode = current.getNext()
               # desconectar para evitar ciclos
               current.setNext(None)
               index = abs(hash(current.getCodigoDisciplina())) % self.__capacidade
               # inserir no novo bucket (inserção na cabeça)
               current.setNext(self.__buckets[index])
               self.__buckets[index] = current
               current = nextNode

   # ---------------------------------------------------------------------
   # Implementação dos métodos públicos (interface)
   # ---------------------------------------------------------------------
   def inserir(self, node: Node) -> bool:
      """
      Insere um Node na tabela hash.
      Retorna False se já existir um node com o mesmo codigoDisciplina.
      """
      if node is None:
         return False
      key = node.getCodigoDisciplina()
      index = self.__hash(key)
      # verificar duplicata
      current = self.__buckets[index]
      while current is not None:
         if current.getCodigoDisciplina() == key:
            return False
         current = current.getNext()
      # inserir no início do bucket (mais eficiente)
      node.setNext(self.__buckets[index])
      self.__buckets[index] = node
      self.__tamanho += 1
      # verificar redimensionamento
      self.__resizeIfNeeded()
      return True

   def removerPorCodigo(self, codigoDisciplina: str) -> bool:
      """
      Remove o node pela chave. Retorna True se removido, False se não encontrado.
      """
      index = self.__hash(codigoDisciplina)
      prev = None
      current = self.__buckets[index]
      while current is not None:
         if current.getCodigoDisciplina() == codigoDisciplina:
            # remover
            if prev is None:
               # remover o primeiro do bucket
               self.__buckets[index] = current.getNext()
            else:
               prev.setNext(current.getNext())
            current.setNext(None)
            self.__tamanho -= 1
            return True
         prev = current
         current = current.getNext()
      return False

   def buscarPorCodigo(self, codigoDisciplina: str):
      """
      Busca um Node pela chave e o retorna (ou None se não encontrado).
      """
      index = self.__hash(codigoDisciplina)
      current = self.__buckets[index]
      while current is not None:
         if current.getCodigoDisciplina() == codigoDisciplina:
            return current
         current = current.getNext()
      return None

   def atualizarPorCodigo(self, codigoDisciplina: str, novoNome: str = None, novaCarga: int = None, novoPeriodo: int = None) -> bool:
      """
      Atualiza os campos do Node identificado por codigoDisciplina.
      Retorna True se atualizado, False se não encontrado.
      """
      node = self.buscarPorCodigo(codigoDisciplina)
      if node is None:
         return False
      if novoNome is not None:
         node.setNomeDisciplina(novoNome)
      if novaCarga is not None:
         node.setCargaHoraria(novaCarga)
      if novoPeriodo is not None:
         node.setPeriodoCurso(novoPeriodo)
      return True

   def imprimirTabela(self):
      """
      Imprime o conteúdo completo da tabela hash com buckets.
      """
      print("-----------------------------------------------------------------")
      print(f"Tabela Hash (capacidade={self.__capacidade}, tamanho={self.__tamanho})")
      print("-----------------------------------------------------------------")
      for i in range(self.__capacidade):
         print(f"Bucket {i}: ", end="")
         current = self.__buckets[i]
         if current is None:
            print("vazio")
            continue
         elems = []
         while current is not None:
            elems.append(f"[{current.getCodigoDisciplina()} | {current.getNomeDisciplina()} | {current.getCargaHoraria()}h | P{current.getPeriodoCurso()}]")
            current = current.getNext()
         print(" -> ".join(elems))
      print("-----------------------------------------------------------------")

   def tamanho(self) -> int:
      """Retorna o tamanho atual (número de elementos)."""
      return self.__tamanho

   def containsKey(self, codigoDisciplina: str) -> bool:
      """Retorna True se a chave existe."""
      return self.buscarPorCodigo(codigoDisciplina) is not None

   def clear(self):
      """Limpa completamente a tabela."""
      self.__buckets = [None] * self.__capacidade
      self.__tamanho = 0
