/* 
CSE 17 
Stephen Friedman
saf217
Program #5 DEADLINE: December 6, 2013 
*/
/**
 * This class is all the code necessary for a LinkedList. The class includes many methods that make it possible to 
 * manage the LinkedList.
 */
public class MyLinkedList<E> extends MyAbstractList<E> {
  private Node<E> head, tail;

  /** Create a default list */
  public MyLinkedList() {
  }

  /** Create a list from an array of objects */
  public MyLinkedList(E[] objects) {
    super(objects);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
    size++; // Increase list size

    if (tail == null) // the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new for element e

    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = tail.next; // tail now points to the last node
    }

    size++; // Increase size
  }


  /** Add a new element at the specified index in this list
   * The index of the head element is 0 */
  public void add(int index, E e) {
    if (index == 0) {
      addFirst(e);
    }
    else if (index >= size) {
      addLast(e);
    }
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node<E> temp = current.next;
      current.next = new Node<E>(e);
      (current.next).next = temp;
      size++;
    }
  }
  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }
    else {
      Node<E> temp = head;
      head = head.next;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp.element;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      return null;
    }
    else if (size == 1) {
      Node<E> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else {
      Node<E> current = head;

      for (int i = 0; i < size - 2; i++) {
        current = current.next;
      }

      Node<E> temp = tail;
      tail = current;
      tail.next = null;
      size--;
      return temp.element;
    }
  }

  /** Remove the element at the specified position in this list.
   *  Return the element that was removed from the list. */
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    else if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = head;

      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }

      Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  /** Override toString() to return elements in the list */
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      }
      else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  /** Clear the list */
  public void clear() {
    head = tail = null;
    size = 0;       // this is missing from the 8th edition of the book!
  }

  /** Return true if this list contains the element e */
  public boolean contains(E e) {
	  Node<E>next;
	  if(head.element.equals(e))
		  return true;
	  else
		  next=head.next;
	  for(int i=0; i< this.size;i++)
	  {
		  if(next.element.equals(e))
			  return true;
		  else
			  next=next.next;
	  }
	  return false;
  }

  /** Return the element from this list at the specified index */
  public E get(int index) {

	  if(this.size<index)
		  return null;
	  else if(index==0)
		  return this.getFirst();
	  else
	  {
		  Node<E>next=this.head.next;
		  for(int i=1;i<this.size;i++)
		  {
			if(i==index)
			{
				return next.element;
			}
			else
				next=next.next;
		  }
	  }
		  return null;
	  
  }

  /** Return the index of the head matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(E e) {
   
	  if(head.element.equals(e))
		  return 0;
	  else
	  {
		  Node<E>next=head.next;
		  for(int i=1;i<this.size;i++)
		  {
			  if(next.element.equals(e))
				  return i;
			  else
				  next=next.next;
		  }
	  }
	  
	  return -1;
  }

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E e) {
 
	  int last=0;
	  
	  if(head.element.equals(e))
		  last= 0;
	  else
	  {
		  Node<E>next=head.next;
		  for(int i=1;i<this.size;i++)
		  {
			  if(next.element.equals(e))
				  last= i;
			  else
				  next=next.next;
		  }
		  return last;
	  }
	  
	  return -1;
	  
  }

  /** Replace the element at the specified position in this list
   *  with the specified element. Returns what was replaced. */
  public E set(int index, E e) {
   
	  if(index==0)
	  {
		  Node<E>next=head.next;
		  this.head=new Node<E>(e);
		  head.next=next;
	  }
	  
	  else
	  {
		  for(int i=1;i<this.size;i++)
		  {
			  if(index==i)
			  {
				  Node<E>curr=(Node<E>) this.get(i);
				  E duplicate=curr.element;
				  Node<E>next=curr.next;
				  curr=new Node<E>(e);
				  curr.next=next;
				  return duplicate;
			  }
		  }
	  }
	  return null;
  }
  /**
   * This method removes a sublist from the MyLinkedList starting at the
   * start index and ending at the end index, inclusive in removing both
   * indexes.
   * @param start where to start removing
   * @param end where to stop removing
   * @return the list that has been removed
   */
  public MyLinkedList<E> extractSublist(int start, int end)
  {
	  
	  if(start>end || start>this.size || start<0 || end<0 || end>this.size)
	  {
		  return null;
	  }
	  MyLinkedList<E> removed = new MyLinkedList<E>();
	  int setback=0;
	  for(int i=start;i<=end;i++)
	  {
		  removed.add(this.remove(i-setback));
		  setback++;
	  }
	  return removed;

  }
  
  /**
   * This method adds on a MyLinkedList to the front of this MyLinkedList
   * @param prefix the MyLinkedList to tack on
   */
  public void prepend(MyLinkedList<E> prefix)
  {

	  for(int i = prefix.size - 1; i >= 0; i--) {
          addFirst(prefix.get(i));
     }
  }

  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
    }
  }
}