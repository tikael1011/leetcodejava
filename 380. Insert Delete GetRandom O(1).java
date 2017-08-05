/*
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have
the same probability of being returned.
*/

/*
* I am not going to put answer here, just thoughts and questions.
* Is duplicates allowed ? For example, after insert(1), insert(1), insert(2), 
* getRandom() should have 2/3 chance return 1 and 1/3 chance return 2 or equal chance of 1 and 2?
* The main purpose, IMO, is asking you to solve the problem remove() takes O(n) in list.
* And for hashmap, how to randomly get a value(key)
*/

/*
The first thougt was to use a DoubleLinkedList, when I realized that for getRandom I will have O(n)
So (one of) the solution is to use a combination of Hashmap and list(another hashmap) and for the remove
part, always remove the lastIndex of element, which thereby achieves O(1).
*/

/*
Also notice that, the word average: you never know if there is a collison in hashcode or not, do you?
*/
