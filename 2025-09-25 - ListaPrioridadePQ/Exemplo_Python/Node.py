# ------------------------------------------------------------------------
# node.py
# Classe que representa um nó da lista de prioridade
# Todos os métodos e atributos em camelCase
# ------------------------------------------------------------------------
class Node:
    def __init__(self, codigoDisciplina, nomeDisciplina, cargaHoraria, semestre):
        self._codigoDisciplina = codigoDisciplina
        self._nomeDisciplina = nomeDisciplina
        self._cargaHoraria = cargaHoraria
        self._semestre = semestre

    # ---------------------------------------------------------------------
    # Getters e setters em camelCase
    # ---------------------------------------------------------------------
    @property
    def codigoDisciplinaProp(self):
        return self._codigoDisciplina

    @codigoDisciplinaProp.setter
    def codigoDisciplinaProp(self, value):
        self._codigoDisciplina = value

    @property
    def nomeDisciplinaProp(self):
        return self._nomeDisciplina

    @nomeDisciplinaProp.setter
    def nomeDisciplinaProp(self, value):
        self._nomeDisciplina = value

    @property
    def cargaHorariaProp(self):
        return self._cargaHoraria

    @cargaHorariaProp.setter
    def cargaHorariaProp(self, value):
        self._cargaHoraria = value

    @property
    def semestreProp(self):
        return self._semestre

    @semestreProp.setter
    def semestreProp(self, value):
        self._semestre = value

    # ---------------------------------------------------------------------
    # Método toStringNode em camelCase
    # ---------------------------------------------------------------------
    def toStringNode(self):
        return f"{self._codigoDisciplina} – {self._nomeDisciplina} ({self._cargaHoraria}h) - Semestre {self._semestre}"

    # Para PriorityQueue, precisamos que os nós sejam comparáveis pelo semestre
    def __lt__(self, other):
        return self._semestre < other._semestre
