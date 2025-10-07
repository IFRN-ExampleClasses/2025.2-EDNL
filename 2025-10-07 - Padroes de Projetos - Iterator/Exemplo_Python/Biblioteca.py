from Livro import Livro
from EstanteDeLivros import EstanteDeLivros

class Biblioteca:
   @staticmethod
   def main():
      minhaEstante = EstanteDeLivros()

      minhaEstante.adicionar(Livro("O Senhor dos Anéis", "J. R. R. Tolkien", "Fantasia"))
      minhaEstante.adicionar(Livro("O Guia do Mochileiro das Galáxias", "Douglas Adams", "Ficção Científica"))
      minhaEstante.adicionar(Livro("1984", "George Orwell", "Distopia"))
      minhaEstante.adicionar(Livro("Dom Casmurro", "Machado de Assis", "Romance"))

      for livro in minhaEstante:
         print(livro)

if __name__ == "__main__":
   Biblioteca.main()
