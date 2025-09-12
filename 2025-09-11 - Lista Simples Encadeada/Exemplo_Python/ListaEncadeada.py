# ------------------------------------------------------------------------
# Implementação da Lista Simplesmente Encadeada
# ------------------------------------------------------------------------
from No import No
from ListaEncadeadaInterface import ListaEncadeadaInterface

class ListaEncadeada(ListaEncadeadaInterface):
    def __init__(self):
        self.cabeca: No | None = None

    # ---------------------------------------------------------------------
    # Inserções
    def InserirNoInicio(self, valor: int):
        novo_no = No(valor)
        novo_no.proximo = self.cabeca
        self.cabeca = novo_no

    def InserirNoFim(self, valor: int):
        novo_no = No(valor)
        if not self.cabeca:
            self.cabeca = novo_no
            return
        atual = self.cabeca
        while atual.proximo:
            atual = atual.proximo
        atual.proximo = novo_no

    def InserirNaPosicao(self, valor: int, posicao: int):
        if posicao < 0:
            print("Posição inválida")
            return
        if posicao == 0:
            self.InserirNoInicio(valor)
            return
        atual = self.cabeca
        indice = 0
        while atual and indice < posicao - 1:
            atual = atual.proximo
            indice += 1
        if not atual:
            print("Posição fora do alcance")
            return
        novo_no = No(valor)
        novo_no.proximo = atual.proximo
        atual.proximo = novo_no

    # ---------------------------------------------------------------------
    # Remoções
    def RemoverInicio(self):
        if self.cabeca:
            self.cabeca = self.cabeca.proximo

    def RemoverPorValor(self, valor: int):
        if not self.cabeca:
            return
        if self.cabeca.dado == valor:
            self.cabeca = self.cabeca.proximo
            return
        atual = self.cabeca
        while atual.proximo and atual.proximo.dado != valor:
            atual = atual.proximo
        if atual.proximo:
            atual.proximo = atual.proximo.proximo

    def RemoverNaPosicao(self, posicao: int):
        if not self.cabeca or posicao < 0:
            return
        if posicao == 0:
            self.cabeca = self.cabeca.proximo
            return
        atual = self.cabeca
        indice = 0
        while atual.proximo and indice < posicao - 1:
            atual = atual.proximo
            indice += 1
        if atual.proximo:
            atual.proximo = atual.proximo.proximo

    # ---------------------------------------------------------------------
    # Buscas
    def BuscarPorValor(self, valor: int) -> bool:
        atual = self.cabeca
        while atual:
            if atual.dado == valor:
                return True
            atual = atual.proximo
        return False

    def ObterNaPosicao(self, posicao: int) -> int | None:
        if posicao < 0:
            return None
        atual = self.cabeca
        indice = 0
        while atual and indice < posicao:
            atual = atual.proximo
            indice += 1
        return atual.dado if atual else None

    # ---------------------------------------------------------------------
    # Atualizações
    def AtualizarPorValor(self, valor_antigo: int, novo_valor: int):
        atual = self.cabeca
        while atual:
            if atual.dado == valor_antigo:
                atual.dado = novo_valor
                return
            atual = atual.proximo
        print(f"Valor {valor_antigo} não encontrado.")

    def AtualizarNaPosicao(self, posicao: int, novo_valor: int):
        if posicao < 0:
            print("Posição inválida")
            return
        atual = self.cabeca
        indice = 0
        while atual and indice < posicao:
            atual = atual.proximo
            indice += 1
        if not atual:
            print("Posição fora do alcance")
            return
        atual.dado = novo_valor

    # ---------------------------------------------------------------------
    # Impressão
    def ImprimirLista(self):
        atual = self.cabeca
        while atual:
            print(f"{atual.dado} -> ", end="")
            atual = atual.proximo
        print("None")
