# ------------------------------------------------------------------------
# Node.py
# Classe que representa um nó da lista de prioridade
# ------------------------------------------------------------------------
class Node:
    """
    Cada nó possui código, nome, carga horária e semestre 
    (que define a prioridade).
    """
    def __init__(self, codigoDisciplina, nomeDisciplina, cargaHoraria, semestre):
        self._codigoDisciplina = codigoDisciplina
        self._nomeDisciplina = nomeDisciplina
        self._cargaHoraria = cargaHoraria
        self._semestre = semestre
        self._proximo = None

    # --- Getters ---
    def getCodigoDisciplina(self):
        return self._codigoDisciplina

    def getNomeDisciplina(self):
        return self._nomeDisciplina

    def getCargaHoraria(self):
        return self._cargaHoraria

    def getSemestre(self):
        return self._semestre

    def getProximo(self):
        return self._proximo

    # --- Setters ---
    def setCodigoDisciplina(self, codigoDisciplina):
        self._codigoDisciplina = codigoDisciplina

    def setNomeDisciplina(self, nomeDisciplina):
        self._nomeDisciplina = nomeDisciplina

    def setCargaHoraria(self, cargaHoraria):
        self._cargaHoraria = cargaHoraria

    def setSemestre(self, semestre):
        self._semestre = semestre

    def setProximo(self, proximo):
        self._proximo = proximo