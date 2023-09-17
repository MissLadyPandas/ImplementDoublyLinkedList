public void add(E e) {
    Node<E> newNode = new Node<>(e);
    if (tail == null) {
        head = tail = newNode;
    } else {
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }
    size++;
}

// clear the list
public void clear() {
    head = tail = null;
    size = 0;
}

// check if the list is empty
public boolean isEmpty() {
    return size == 0;
}

// return the size of the list
public int size() {
    return size;
}


/** Add an element to the beginning of the list */
public void addFirst(E e) {
 Node<E> newNode = new Node<>(e);
 if (head == null) {
     head = tail = newNode;
 } else {
     head.previous = newNode;
     newNode.next = head;
     head = newNode;
 }
 size++;
}

/** Add an element to the end of the list */
public void addLast(E e) {
 Node<E> newNode = new Node<>(e);
 if (tail == null) {
     head = tail = newNode;
 } else {
     tail.next = newNode;
     newNode.previous = tail;
     tail = newNode;
 }
 size++;
}

/** Add a new element at the specified index in this list */
public void add(int index, E e) {
 if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException();
 } else if (index == 0) {
     addFirst(e);
 } else if (index == size) {
     addLast(e);
 } else {
     Node<E> current = head;
     for (int i = 0; i < index - 1; i++) {
         current = current.next;
     }
     Node<E> temp = current.next;
     current.next = new Node<>(e);
     (current.next).next = temp;
     (current.next).previous = current;
     temp.previous = current.next;
     size++;
 }
}

/** Remove the head node and return the object contained in the removed node */
public E removeFirst() {
 if (size == 0) {
     return null;
 } else {
     Node<E> temp = head;
     head = head.next;
     size--;
     if (head == null) {
         tail = null;
     } else {
         head.previous = null;
     }
     return temp.element;
 }
}

/** Remove the last node and return the object contained in the removed node */
public E removeLast() {
 if (size == 0) {
     return null;
 } else if (size == 1) {
     Node<E> temp = head;
     head = tail = null;
     size = 0;
     return temp.element;
 } else {
     Node<E> temp = tail;
     tail = tail.previous;
     tail.next = null;
     size--;
     return temp.element;
 }
}

/** Remove the element at the specified position in this list */
public E remove(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index out of bounds.");
    } else if (index == 0) {
        return removeFirst();
    } else if (index == size - 1) {
        return removeLast();
    } else {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<E> prevNode = current.previous;
        Node<E> nextNode = current.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.previous = prevNode;
        }
        size--;
        return current.element;
    	}
	}
}

