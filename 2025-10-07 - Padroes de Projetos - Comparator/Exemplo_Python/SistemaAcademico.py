from Aluno import Aluno
from OrdenarPorNome import OrdenarPorNome
from OrdenarPorMedia import OrdenarPorMedia

def main():
   alunos = [
      Aluno('Carlos', 8.5, 9.0),
      Aluno('Ana', 9.2, 8.8),
      Aluno('Beatriz', 7.8, 8.0)
   ]

   print('=== Lista Original ===')
   for a in alunos:
      print(a)

   # Ordenação usando a classe OrdenarPorNome
   alunos.sort(key=OrdenarPorNome())
   print('\n=== Alunos ordenados por nome (classe) ===')
   for a in alunos:
      print(a)

   # Ordenação usando a classe OrdenarPorMedia
   alunos.sort(key=OrdenarPorMedia())
   print('\n=== Alunos ordenados por média (decrescente, classe) ===')
   for a in alunos:
      print(a)

   # ------------------------------------------------------------
   # Ordenação usando lambda (função inline)

   # Por nome (alfabética)
   alunos.sort(key=lambda aluno: aluno.getNome().lower())
   print('\n=== Alunos ordenados por nome (lambda) ===')
   for a in alunos:
      print(a)

   # Por média (decrescente)
   alunos.sort(key=lambda aluno: -aluno.getMedia())
   print('\n=== Alunos ordenados por média (decrescente, lambda) ===')
   for a in alunos:
      print(a)

if __name__ == '__main__':
   main()
