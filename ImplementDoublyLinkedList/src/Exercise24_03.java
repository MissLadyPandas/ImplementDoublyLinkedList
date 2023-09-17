import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;

public class Exercise24_03 {
  public static void main(String[] args) {
    new Exercise24_03();
  }
  
  public Exercise24_03() {
    TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
    System.out.print("Enter five numbers: ");
    Scanner input = new Scanner(System.in);
    double[] v = new double[5];
    for (int i = 0; i < 5; i++) 
      v[i] = input.nextDouble();

    list.add(v[1]);
    list.add(v[2]);
    list.add(v[3]);
    list.add(v[4]);
    list.add(0, v[0]);
    list.add(2, 10.55);
    list.remove(3);

    java.util.ListIterator<Double> iterator1 = list.listIterator();
    System.out.print("The list in forward order: ");
    while (iterator1.hasNext())
      System.out.print(iterator1.next() + " ");

    java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
    System.out.print("\nThe list in backward order: ");
    while (iterator2.hasPrevious())
      System.out.print(iterator2.previous() + " ");
  }
} 

interface MyList<E> extends java.util.Collection<E> {
  /** Add a new element at the specified index in this list */
  public void add(int index, E e);

  /** Return the element from this list at the specified index */
  public E get(int index);

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(Object e);

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E e);

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index);

  /** Replace the element at the specified position in this list
   *  with the specified element and returns the new set. */
  public E set(int index, E e);
  
  @Override /** Add a new element at the end of this list */
  public default boolean add(E e) {
    add(size(), e);
    return true;
  }

  @Override /** Return true if this list contains no elements */
  public default boolean isEmpty() {
    return size() == 0;
  }

  @Override /** Remove the first occurrence of the element e 
   *  from this list. Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public default boolean remove(Object e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    }
    else
      return false;
  }

  @Override
  public default boolean containsAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean addAll(Collection<? extends E> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean removeAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean retainAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default Object[] toArray() {
    // Left as an exercise
    return null;
  }

  @Override
  public default <T> T[] toArray(T[] array) {
    // Left as an exercise
    return null;
  }
}

class TwoWayLinkedList<E> implements MyList<E> {
  private Node<E> head, tail;
  private int size;

  /** Create a default list */
  public TwoWayLinkedList() {
  }

  /** Create a list from an array of objects */
  public TwoWayLinkedList(E[] objects) {
    for (E e : objects)
      add(e);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    } else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    } else {
      return tail.element;
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      } else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  /** Clear the list */
  public void clear() {
    head = tail = null;
  }

  /** Return true if this list contains the element o */
  public boolean contains(Object e) {
    System.out.println("Implementation left as an exercise");
    return true;
  }

  /** Return the element from this list at the specified index */
  public E get(int index) {
    System.out.println("Implementation left as an exercise");
    return null;
  }

  /**
   * Return the index of the head matching element in this list. Return -1 if
   * no match.
   */
  public int indexOf(Object e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }

  /**
   * Return the index of the last matching element in this list Return -1 if
   * no match.
   */
  public int lastIndexOf(Object e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }

  /**
   * Replace the element at the specified position in this list with the
   * specified element.
   */
  public E set(int index, E e) {
    System.out.println("Implementation left as an exercise");
    return null;
  }

  private class LinkedListIterator implements java.util.ListIterator<E> {
    private Node<E> current = head; // Current index

    public LinkedListIterator() {
    }
    
    public LinkedListIterator(int index) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
          + size);
      for (int nextIndex = 0; nextIndex < index; nextIndex++)
        current = current.next;
    }
    
    public void setLast() {
  	current = tail;
    }
    
    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as an exercise");
    }

    @Override
    public void add(E e) {
      System.out.println("Implementation left as an exercise");
    }

    @Override
    public boolean hasPrevious() {
      return current != null;
    }

    @Override
    public int nextIndex() {
      System.out.println("Implementation left as an exercise");
      return 0;
    }

    @Override
    public E previous() {
      E e = current.element;
      current = current.previous;
      return e;
    }

    @Override
    public int previousIndex() {
      System.out.println("Implementation left as an exercise");
      return 0;
    }

    @Override
    public void set(E e) {
      current.element = e; // TODO Auto-generated method stub
    }
  }
  
  //node class to store the elements of the doubly linked list
  private class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    // constructor to create a node with the given element
    public Node(E o) {
      element = o;
    }
  }
//returns the size of the list
  @Override
  public int size() {
    return size;
  }
//returns a list iterator starting from the beginning of the list
  public ListIterator<E> listIterator() {
    return new LinkedListIterator(); 
  }
//returns a list iterator starting from the specified index
  public ListIterator<E> listIterator(int index) {
    return new LinkedListIterator(index); 
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

// BEGIN REVEL SUBMISSION
  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
	  	// create a new node
	    Node<E> newNode = new Node<>(e); 
	    // link the new node with the head
	    newNode.next = head; 
	    if (head != null) {
	    	// link the head's previous to the new node
	        head.previous = newNode; // 
	    }
	    // now head is the new node
	    head = newNode; 
	    // // increase the list size
	    size++; 
	    
	    // if the only node in the list, it's also the tail
	    if (tail == null) {
	        tail = head;
	    }
	}


  /** Add an element to the end of the list */
  public void addLast(E e) {
	  	// create a new node
	    Node<E> newNode = new Node<>(e); 
	    if (tail == null) {
	    	// the only one in the list
	        head = tail = newNode; 
	    } else {
	    	// link the new node with the last node
	        tail.next = newNode; 
	        // // link the new node's previous to the last node
	        newNode.previous = tail; 
	        // now the tail is the new node
	        tail = tail.next; 
	    }
	    // increase size
	    size++; 
	}


  /**
   * Add a new element at the specified index in this list The index of the
   * head element is 0
   */
  public void add(int index, E e) {
	    // check if the provided index is valid
	    if (index < 0 || index > size) {
	        throw new IndexOutOfBoundsException("Index out of bounds.");
	    }

	    // if adding to the beginning of the list
	    if (index == 0) {
	        addFirst(e);
	    }
	    // if adding to the end of the list
	    else if (index == size) {
	        addLast(e);
	    }
	    // adding to somewhere in the middle of the list
	    else {
	        // review the list to find the node at the specified index
	        Node<E> current = head;
	        for (int i = 0; i < index; i++) {
	            current = current.next;
	        }

	        // get the previous node of the current node
	        Node<E> temp = current.previous;

	        // create a new node with the provided element
	        Node<E> newNode = new Node<>(e);

	        // adjust the next pointers of temp and newNode
	        temp.next = newNode;
	        newNode.next = current;

	        // adjust the previous pointers of newNode and current
	        newNode.previous = temp;
	        current.previous = newNode;

	        // increase the size of the list
	        size++;
	    }
	}



  /**
   * Remove the head node and return the object that is contained in the
   * removed node.
   */
  public E removeFirst() {
	    // check if the list is empty
	    if (size == 0) {
	        return null;
	    } else {
	        // store the first node temporarily
	        Node<E> temp = head;

	        // move the head pointer to the next node
	        head = head.next;

	        // check if the list is not empty after removal
	        if (head != null) {
	            // reset the previous pointer of the new head
	            head.previous = null;
	        } else {
	            // if list becomes empty after removal, reset the tail
	            tail = null; // List is empty now
	        }

	        // decrease the size of the list
	        size--;

	        // return the element of the removed node
	        return temp.element;
	    }
	}


  /**
   * Remove the last node and return the object that is contained in the
   * removed node.
   */
  public E removeLast() {
	    // check if the list is empty
	    if (size == 0) {
	        return null;
	    }
	    // if there's only one element in the list
	    else if (size == 1) {
	        // Store the only node temporarily
	        Node<E> temp = head;

	        // reset both the head and tail pointers
	        head = tail = null;

	        // reset the size of the list
	        size = 0;

	        // return the element of the removed node
	        return temp.element;
	    } else {
	        // store the last node temporarily
	        Node<E> temp = tail;

	        // move the tail pointer to the previous node
	        tail = tail.previous;

	        // remove the next pointer of the new tail
	        tail.next = null;

	        // decrease the size of the list
	        size--;

	        // return the element of the removed node
	        return temp.element;
	    }
	}


  /**
   * Remove the element at the specified position in this list. Return the
   * element that was removed from the list.
   */
  public E remove(int index) {
	    // check if the provided index is valid
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Index out of bounds.");
	    }
	    // if removing the first element
	    else if (index == 0) {
	        return removeFirst();
	    }
	    // if removing the last element
	    else if (index == size - 1) {
	        return removeLast();
	    }
	    // if removing an element from somewhere in the middle
	    else {
	        // search the list to find the node at the specified index
	        Node<E> current = head;
	        for (int i = 0; i < index; i++) {
	            current = current.next;
	        }

	        // get the nodes before and after the current node
	        Node<E> prevNode = current.previous;
	        Node<E> nextNode = current.next;

	        // adjust the next pointer of prevNode and previous pointer of nextNode
	        prevNode.next = nextNode;
	        nextNode.previous = prevNode;

	        // decrease the size of the list
	        size--;

	        // return the element of the removed node
	        return current.element;
	    }
	}
}
