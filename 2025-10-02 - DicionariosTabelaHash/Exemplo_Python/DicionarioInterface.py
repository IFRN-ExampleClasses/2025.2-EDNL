# ------------------------------------------------------------------------
# DicionarioInterface.py
# Interface (classe abstrata) que declara os métodos públicos esperados
# para a implementação da tabela hash (dicionário).
# ------------------------------------------------------------------------

from abc import ABC, abstractmethod

class DicionarioInterface(ABC):
   """
   Interface abstrata para um dicionário (tabela hash).
   """

   @abstractmethod
   def inserir(self, node):
      """Insere um Node no dicionário. Retorna True se inserido, False caso a chave já exista."""
      pass

   @abstractmethod
   def removerPorCodigo(self, codigoDisciplina: str) -> bool:
      """Remove o registro pela chave (codigoDisciplina). Retorna True se removido, False se não encontrado."""
      pass

   @abstractmethod
   def buscarPorCodigo(self, codigoDisciplina: str):
      """Retorna o Node correspondente à chave ou None se não encontrado."""
      pass

   @abstractmethod
   def atualizarPorCodigo(self, codigoDisciplina: str, novoNome: str = None, novaCarga: int = None, novoPeriodo: int = None) -> bool:
      """Atualiza campos do Node identificado por codigoDisciplina. Retorna True se atualizado, False se não encontrado."""
      pass

   @abstractmethod
   def imprimirTabela(self):
      """Imprime o conteúdo completo da tabela hash."""
      pass

   @abstractmethod
   def tamanho(self) -> int:
      """Retorna o número de elementos na tabela (atualizado incrementalmente)."""
      pass

   @abstractmethod
   def containsKey(self, codigoDisciplina: str) -> bool:
      """Retorna True se a chave existe na tabela."""
      pass

   @abstractmethod
   def clear(self):
      """Limpa a tabela."""
      pass
