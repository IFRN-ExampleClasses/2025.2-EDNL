class Livro:
   def __init__(self, titulo, autor, genero):
      self.__titulo = titulo
      self.__autor = autor
      self.__genero = genero

   # Getters e Setters
   def getTitulo(self):
      return self.__titulo

   def setTitulo(self, titulo):
      self.__titulo = titulo

   def getAutor(self):
      return self.__autor

   def setAutor(self, autor):
      self.__autor = autor

   def getGenero(self):
      return self.__genero

   def setGenero(self, genero):
      self.__genero = genero

   def __str__(self):
      return f"Livro: {self.__titulo} | Autor: {self.__autor} | Gênero: {self.__genero}"
