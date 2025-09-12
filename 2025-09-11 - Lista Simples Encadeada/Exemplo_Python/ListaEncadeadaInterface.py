# ------------------------------------------------------------------------
# Interface conceitual da Lista Simplesmente Encadeada
# Em Python não é obrigatório, mas define a estrutura para referência
# ------------------------------------------------------------------------
from abc import ABC, abstractmethod

class ListaEncadeadaInterface(ABC):

    # Inserções
    @abstractmethod
    def InserirNoInicio(self, valor: int): ...
    @abstractmethod
    def InserirNoFim(self, valor: int): ...
    @abstractmethod
    def InserirNaPosicao(self, valor: int, posicao: int): ...

    # Remoções
    @abstractmethod
    def RemoverInicio(self): ...
    @abstractmethod
    def RemoverPorValor(self, valor: int): ...
    @abstractmethod
    def RemoverNaPosicao(self, posicao: int): ...

    # Buscas
    @abstractmethod
    def BuscarPorValor(self, valor: int) -> bool: ...
    @abstractmethod
    def ObterNaPosicao(self, posicao: int) -> int | None: ...

    # Atualizações
    @abstractmethod
    def AtualizarPorValor(self, valor_antigo: int, novo_valor: int): ...
    @abstractmethod
    def AtualizarNaPosicao(self, posicao: int, novo_valor: int): ...

    # Impressão
    @abstractmethod
    def ImprimirLista(self): ...
