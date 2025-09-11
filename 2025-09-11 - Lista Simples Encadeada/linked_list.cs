// ------------------------------------------------------------------------
// Implementação Completa de Lista Simplesmente Encadeada em C#
// Inclui inserções, remoções, buscas, atualizações e impressão
// ------------------------------------------------------------------------
using System;

namespace LinkedListExample
{
   // ---------------------------------------------------------------------
   // Classe Nó
   class Node
   {
      public int data;
      public Node next;

      public Node(int data)
      {
         this.data = data;
         this.next = null;
      }
   }

   // ---------------------------------------------------------------------
   // Lista Simplesmente Encadeada Completa
   class LinkedList
   {
      private Node head;

      // ------------------------------------------------------------------
      // Inserções
      public void InsertAtHead(int value)
      {
         Node newNode = new Node(value);
         newNode.next = head;
         head = newNode;
      }

      public void InsertAtTail(int value)
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

      public void InsertAtPosition(int value, int position)
      {
         if (position < 0)
         {
            Console.WriteLine("Posição inválida");
            return;
         }
         if (position == 0)
         {
            InsertAtHead(value);
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
            Console.WriteLine("Posição fora do alcance");
            return;
         }

         Node newNode = new Node(value);
         newNode.next = current.next;
         current.next = newNode;
      }

      // ------------------------------------------------------------------
      // Remoções
      public void RemoveHead()
      {
         if (head != null)
            head = head.next;
      }

      public void RemoveByValue(int value)
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

      public void RemoveAtPosition(int position)
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

      // ------------------------------------------------------------------
      // Buscas
      public bool SearchByValue(int value)
      {
         Node current = head;
         while (current != null)
         {
            if (current.data == value) return true;
            current = current.next;
         }
         return false;
      }

      public int? GetAtPosition(int position)
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

      // ------------------------------------------------------------------
      // Atualizações
      public void UpdateByValue(int oldValue, int newValue)
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
         Console.WriteLine($"Valor {oldValue} não encontrado.");
      }

      public void UpdateAtPosition(int position, int newValue)
      {
         if (position < 0)
         {
            Console.WriteLine("Posição inválida");
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
            Console.WriteLine("Posição fora do alcance");
            return;
         }

         current.data = newValue;
      }

      // ------------------------------------------------------------------
      // Impressão
      public void PrintList()
      {
         Node current = head;
         while (current != null)
         {
            Console.Write(current.data + " -> ");
            current = current.next;
         }
         Console.WriteLine("null");
      }
   }

   // ---------------------------------------------------------------------
   class Program
   {
      static void Main(string[] args)
      {
         LinkedList list = new LinkedList();

         // Inserções
         list.InsertAtHead(10);
         list.InsertAtTail(5);
         list.InsertAtPosition(20, 1); // insere na posição 1
         list.PrintList(); // 10 -> 20 -> 5 -> null

         // Atualizações
         list.UpdateByValue(20, 25);
         list.PrintList(); // 10 -> 25 -> 5 -> null

         list.UpdateAtPosition(2, 15);
         list.PrintList(); // 10 -> 25 -> 15 -> null

         // Remoções
         list.RemoveHead();
         list.PrintList(); // 25 -> 15 -> null

         list.RemoveByValue(25);
         list.PrintList(); // 15 -> null

         list.RemoveAtPosition(0);
         list.PrintList(); // null
      }
   }
}
