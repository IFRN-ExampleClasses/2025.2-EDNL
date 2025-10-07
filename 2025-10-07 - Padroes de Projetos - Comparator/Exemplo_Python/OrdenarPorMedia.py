class OrdenarPorMedia:
   def __call__(self, aluno):
      return -aluno.getMedia()  # negativo para ordenar decrescente
