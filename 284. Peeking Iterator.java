/*
Given an Iterator class interface with methods: next() and hasNext(),
design and implement a PeekingIterator that support the peek() operation 
-- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

Hint:

Think of "looking ahead". You want to cache the next element.
Is one variable sufficient? Why or why not?
Test your design with call order of peek() before next() vs next() before peek().
For a clean implementation, check out Google's guava library source code.
*/


// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
/* https://github.com/google/guava/blob/
703ef758b8621cfbab16814f01ddcc5324bdea33/guava-gwt/src-super/com
/google/common/collect/super/com/google/common/collect/Iterators.java#L1125
*/

//91ms
//95.95%


class PeekingIterator implements Iterator<Integer> {
    
    private Integer next;
    
    private Iterator<Integer> iter;

	public PeekingIterator(Iterator<Integer> iterator) {
	    
	    this.iter = iterator;
        if (iter.hasNext()) next = iter.next();
	    // initialize any member here.
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        //if(!hasNext()) return null;
        return next;
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    
	    Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    
	    return next != null;
	}
}
