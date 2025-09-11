// ------------------------------------------------------------------------
// Implementação Completa de Lista Simplesmente Encadeada em Java
// Inclui inserções, remoções, buscas, atualizações e impressão
// ------------------------------------------------------------------------

// ------------------------------------------------------------------------
// Classe Nó
class Node
{
   int data;
   Node next;

   Node(int data)
   {
      this.data = data;
      this.next = null;
   }
}


// ------------------------------------------------------------------------
// Classe Lista Simplesmente Encadeada Completa
class LinkedList
{
   private Node head;

   // ---------------------------------------------------------------------
   // Inserções
   public void insertAtHead(int value)
   {
      Node newNode = new Node(value);
      newNode.next = head;
      head = newNode;
   }

   public void insertAtTail(int value)
   {
      Node newNode = new Node(value);
      if (head == null)
      {
         head = newNode;
         return;
      }
      Node current = head;
      while (current.next != null)
      {
         current = current.next;
      }
      current.next = newNode;
   }

   public void insertAtPosition(int value, int position)
   {
      if (position < 0)
      {
         System.out.println("Posição inválida");
         return;
      }
      if (position == 0)
      {
         insertAtHead(value);
         return;
      }

      Node current = head;
      int index = 0;
      while (current != null && index < position - 1)
      {
         current = current.next;
         index++;
      }

      if (current == null)
      {
         System.out.println("Posição fora do alcance");
         return;
      }

      Node newNode = new Node(value);
      newNode.next = current.next;
      current.next = newNode;
   }

   // ---------------------------------------------------------------------
   // Remoções
   public void removeHead()
   {
      if (head != null)
         head = head.next;
   }

   public void removeByValue(int value)
   {
      if (head == null) return;
      if (head.data == value)
      {
         head = head.next;
         return;
      }
      Node current = head;
      while (current.next != null && current.next.data != value)
      {
         current = current.next;
      }
      if (current.next != null)
      {
         current.next = current.next.next;
      }
   }

   public void removeAtPosition(int position)
   {
      if (head == null || position < 0) return;
      if (position == 0)
      {
         head = head.next;
         return;
      }

      Node current = head;
      int index = 0;
      while (current.next != null && index < position - 1)
      {
         current = current.next;
         index++;
      }

      if (current.next != null)
      {
         current.next = current.next.next;
      }
   }

   // ---------------------------------------------------------------------
   // Buscas
   public boolean searchByValue(int value)
   {
      Node current = head;
      while (current != null)
      {
         if (current.data == value) return true;
         current = current.next;
      }
      return false;
   }

   public Integer getAtPosition(int position)
   {
      if (position < 0) return null;
      Node current = head;
      int index = 0;
      while (current != null && index < position)
      {
         current = current.next;
         index++;
      }
      if (current == null) return null;
      return current.data;
   }

   // ---------------------------------------------------------------------
   // Atualizações
   public void updateByValue(int oldValue, int newValue)
   {
      Node current = head;
      while (current != null)
      {
         if (current.data == oldValue)
         {
            current.data = newValue;
            return;
         }
         current = current.next;
      }
      System.out.println("Valor " + oldValue + " não encontrado.");
   }

   public void updateAtPosition(int position, int newValue)
   {
      if (position < 0)
      {
         System.out.println("Posição inválida");
         return;
      }
      Node current = head;
      int index = 0;
      while (current != null && index < position)
      {
         current = current.next;
         index++;
      }
      if (current == null)
      {
         System.out.println("Posição fora do alcance");
         return;
      }
      current.data = newValue;
   }

   // ---------------------------------------------------------------------
   // Impressão
   public void printList()
   {
      Node current = head;
      while (current != null)
      {
         System.out.print(current.data + " -> ");
         current = current.next;
      }
      System.out.println("null");
   }
}


// ------------------------------------------------------------------------
// Testando a lista
public class linked_list
{
   public static void main(String[] args)
   {
      LinkedList list = new LinkedList();

      // Inserções
      list.insertAtHead(10);
      list.insertAtTail(5);
      list.insertAtPosition(20, 1); // insere na posição 1
      list.printList(); // 10 -> 20 -> 5 -> null

      // Atualizações
      list.updateByValue(20, 25);
      list.printList(); // 10 -> 25 -> 5 -> null

      list.updateAtPosition(2, 15);
      list.printList(); // 10 -> 25 -> 15 -> null

      // Remoções
      list.removeHead();
      list.printList(); // 25 -> 15 -> null

      list.removeByValue(25);
      list.printList(); // 15 -> null

      list.removeAtPosition(0);
      list.printList(); // null
   }
}
