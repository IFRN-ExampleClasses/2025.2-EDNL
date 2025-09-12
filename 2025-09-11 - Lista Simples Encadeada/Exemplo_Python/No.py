# ------------------------------------------------------------------------
# Classe Nó
# Representa cada elemento da lista com dado e referência para o próximo
# ------------------------------------------------------------------------
class No:
    def __init__(self, dado: int):
        self.dado = dado
        self.proximo = None
