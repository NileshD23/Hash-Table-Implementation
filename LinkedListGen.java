/**
 * Written by:
 * Nilesh Domah				domah001
 * Adeyinka Omotoyinbo		omoto011
 */

public class LinkedListGen<T>
{
	// the reference to the head node
	private NGen<T> head;
	
	// the reference to the tail node
	private NGen<T> tail;
	
	// the size of the list
	private int size;
	
	// the constructor
	public LinkedListGen()
	{
		// set the head and the tail to null 
		head = null;
		tail = null;
		
		// set the size to 0
		size = 0;
	}
	
	// the method to insert into the linked list
	public void insert(T val)
	{
		// if the head is null
		if( head == null )
		{
			// create a new head
			head = new NGen<T>(val,null);
			
			// since this is the only node, point the tail to this as well
			tail = head;
		}
		// else if the head is not null
		else
		{
			// create a new node
			NGen<T> newNode = new NGen<T>(val,null);
			
			// set the next of tail to this new node
			tail.setNext(newNode);
			
			// set the tail to this new node
			tail = newNode;
		}
		
		// increment the size by 1
		size++;
	}
	
	// method to get the size
	public int size()
	{
		// return the size of this list
		return size;
	}
	
	// the method to look for this token in this table
	public boolean search(T item)
	{
		// the reference to the head node
		NGen<T> curr = head;
		
		// as long as the current is not null
		while( curr != null )
		{
			// if this is the item we are looking for
			if( item.equals(curr.getData()))
			{
				// return true
				return true;
			}
			
			// move the current ahead
			curr = curr.getNext();
		}
		// finally return false
		return false;
	}
		
	
	// method toString()
	public String toString()
	{
		// create a String buffer
		StringBuffer buffer = new StringBuffer();
		
		// add all the elements to this buffer
		NGen<T> curr = head;
		
		// as long as the current is not null
		while( curr != null )
		{
			// add this to the string
			buffer.append( curr.getData().toString() + " " );
			
			// move the current ahead
			curr = curr.getNext();
		}
		
		// return the string
		return buffer.toString();
	}
}

