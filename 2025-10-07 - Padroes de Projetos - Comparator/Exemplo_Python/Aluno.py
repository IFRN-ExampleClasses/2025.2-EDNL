class Aluno:
   def __init__(self, nome: str, nota1: float, nota2: float):
      self.__nome = nome
      self.__nota1 = nota1
      self.__nota2 = nota2
      self.__calcularMedia()

   def __calcularMedia(self):
      self.__media = (self.__nota1 + self.__nota2) / 2

   # Getters e setters
   def getNome(self) -> str:
      return self.__nome

   def setNome(self, nome: str):
      self.__nome = nome

   def getNota1(self) -> float:
      return self.__nota1

   def setNota1(self, nota1: float):
      self.__nota1 = nota1
      self.__calcularMedia()

   def getNota2(self) -> float:
      return self.__nota2

   def setNota2(self, nota2: float):
      self.__nota2 = nota2
      self.__calcularMedia()

   def getMedia(self) -> float:
      return self.__media

   def __str__(self) -> str:
      return f'Aluno(Nome={self.__nome}, Nota1={self.__nota1}, Nota2={self.__nota2}, Média={self.__media})'
