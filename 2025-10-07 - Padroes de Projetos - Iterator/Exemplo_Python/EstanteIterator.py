class EstanteIterator:
   def __init__(self, livros):
      self.__livros = livros
      self.__posicao = 0

   def getLivros(self):
      return self.__livros

   def setLivros(self, livros):
      self.__livros = livros

   def getPosicao(self):
      return self.__posicao

   def setPosicao(self, posicao):
      self.__posicao = posicao

   def __iter__(self):
      return self

   def __next__(self):
      if self.__posicao < len(self.__livros) and self.__livros[self.__posicao] is not None:
         livro = self.__livros[self.__posicao]
         self.__posicao += 1
         return livro
      else:
         raise StopIteration
