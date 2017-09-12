/*
Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one
character into another character in this word, the modified word is in the dictionary you just
built.

Example 1: Input: buildDict(["hello", "leetcode"]), Output: Null Input: search("hello"), Output:
False Input: search("hhllo"), Output: True Input: search("hell"), Output: False Input:
search("leetcoded"), Output: False Note: You may assume that all the inputs are consist of
lowercase letters a-z. For contest purpose, the test data is rather small by now. You could
think about highly efficient algorithm after the contest. Please remember to RESET your class
variables declared in class MagicDictionary, as static/class variables are persisted across
multiple test cases. */

//Medium, Contest
//
//There are several thoughts, the last one is my thought and I will try to understand the
//others, which are from the discussion page on the leetcode. No code involved. and there are
//maybe edge cases that certain algorithm can not take care of. But I do not know exactly. And
//my thought can be wrong. I will do some analysis. There is only PROPER solution for certain
//situation/requirements, with some trade-offs, no universal good one. 
//

class MagicDictionary {

    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

/**
 * Your MagicDictionary object will be instantiated and called as such: * MagicDictionary obj =
 new MagicDictionary(); * obj.buildDict(dict); * boolean param_2 = obj.search(word); */


/** 1 **/ 
/*
The idea is that, use a hashset store EVERY one-modify distance word into dictionary instead of
the original input, and then check if search(str), the str is in the hashset. E.g.
buildDict(abc), than store every *bc(no abc), a*c(no abc), ab*(no abc) into the hashset...This
can be one of the worst algorithms, literally. AC means certain code passed all the test cases
only, nothing else, let alone good design or other characteristic. */

/** 2 **/ 
/*
Similiar to 1, but this uses two hashset, one stores the *bc, a*c, ab* format instead, the other
stores the original inputs, While searching, check if the str's format is in first hashset &&
str is NOT in the second hashset. This is match better, but the sc is not good. If I am right,
suppose the avg length of word is m, the sc is O(mn), while the search is O(1). But if the hash
function is not good and there are some hash collision, we need some extra work. */

/** 3 **／
／* Use hashset to store input, sc O(n), n is the number of input words. While searching, the
len(str) is n, rc O(26n) sc O(n), check if it is one-modify (in-space) from
hashset.contains(str). The trade-off between is somehow acceptable, provided that 'search' is
not frequently called. *／

/** 4 **/ 
/*
Modified version of a Trie */

/** My thought **/ 
/*
It is my thought before I check any other resource. Say the length of search(str) is n, I want
to only search whatever (format, or the original input) in my dict with length == n only. How do
I store/build the dict then?

HashMap<Integer,HashSet<String>>, where the key is the length of the word in the following
hashset. In other words, every word with same length will be stored to the same hashset. In
terms of searching, determining one-modify is easy for only one word and can be done by one pass
but the problem is that in worst case, we have to go through the whole hashset to return a
'false' (true can be return early since it is a stop-search sign.) So this thought is NOT good.
I will try to come up another mind and implement it before I come back and update this file. */
