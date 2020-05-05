// written by Nilesh Domah

public class HashTableGen<T>
{
	// the default size
	private static final int DEFAULT_SIZE = 101;
			
	// the table 
	private LinkedListGen<T> table[];
	
	// the number of buckets
	private int numBuckets;
	
	// the constructor
	@SuppressWarnings("unchecked")
	public HashTableGen()
	{
		// create the hash table
		table = new LinkedListGen[DEFAULT_SIZE];
		
		// set the number of buckets
		numBuckets = DEFAULT_SIZE;
	}
	
	// the method to add item to the hash table
	public void add(T item)
	{
		// if this entry already exists, ignore it
		if( search(item) )
			return;
		
		// get the hash value
		int hashValue = hash(item) % numBuckets;
		
		// if the linked list at this location is null
		if( table[hashValue] == null )
		{
			// create a new linked list here
			table[hashValue] = new LinkedListGen<T>();
		}
		
		// add this item
		table[hashValue].insert(item);
	}
	
	// method to hash the given key
	private int hash(T key)
	{
		// get the hash code
		int hashCode = key.hashCode();
		
		// make sure the hash code is not negative
		while( hashCode < 0 )
			hashCode += numBuckets;
		
		// return the hash code
		return hashCode;
	}
	
	// method to search for this key in the table
	public boolean search(T item)
	{
		// get the hash value
		int hashValue = hash(item) % numBuckets;
		
		// if the linked list at this location is null
		if( table[hashValue] == null )
		{
			// return false
			return false;
		}
		// else search for this item
		else
		{
			// return the value of the search
			return table[hashValue].search(item);
		}
	}
	
	// method to display the hash table
	public void display()
	{
		// print the table
		for( int i=0; i<numBuckets; i++)
		{
			// print this index
			System.out.print(i + ": ");
			
			// if this linked list is null
			if( table[i] == null )
			{
				// print blank
				System.out.println("[]");
			}
			// else print the entire list
			else
				System.out.println("[ " + table[i].toString() + " ]");
		}
	}
	
	// method to display the details
	public void dump()
	{
		// print the table
		for( int i=0; i<numBuckets; i++)
		{
			// print this index
			System.out.print(i + ": ");
			
			// // if this linked list is null
			if( table[i] == null )
			{
				// print size as 0
				System.out.println("Size = 0");
			}
			// else print the size of this list
			else
				System.out.println("Size = " + table[i].size());
		}
	}

}
