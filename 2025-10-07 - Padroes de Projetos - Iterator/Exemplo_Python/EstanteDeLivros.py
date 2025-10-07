from EstanteIterator import EstanteIterator

class EstanteDeLivros:
   def __init__(self):
      self.__livros = []

   def getLivros(self):
      return self.__livros

   def setLivros(self, livros):
      self.__livros = livros

   def adicionar(self, livro):
      self.__livros.append(livro)

   def __iter__(self):
      return EstanteIterator(self.__livros)
