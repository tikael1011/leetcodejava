/*
In English, we have a concept called root, which can be followed by some other words to form another longer word 
- let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the 
sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
*/


//there are two main thoughts, use a hashset/hashmap to store or build a trie.
//the following two python solution are from: 
// https://discuss.leetcode.com/topic/96826/python-straightforward-with-explanation-prefix-hash-trie-solutions

/*
def replaceWords(self, roots, sentence):
    rootset = set(roots)

    def replace(word):
        for i in xrange(1, len(word)):
            if word[:i] in rootset:
                return word[:i]
        return word

    return " ".join(map(replace, sentence.split()))
*/
/*
def replaceWords(self, roots, sentence):
    _trie = lambda: collections.defaultdict(_trie)
    trie = _trie()
    END = True
    for root in roots:
        cur = trie
        for letter in root:
            cur = cur[letter]
        cur[END] = root

    def replace(word):
        cur = trie
        for letter in word:
            if letter not in cur: break
            cur = cur[letter]
            if END in cur:
                return cur[END]
        return word

    return " ".join(map(replace, sentence.split()))
*/

/*
for the checking prefix algorithm, it is easier to understand and more intuitive, but the rc and sc is (much) worse
than the trie solution.
*/

//there is another sorting thinking:
//https://discuss.leetcode.com/topic/96897/simple-java-sort-solution

//java trie class solution:

public class Solution {
    class TrieNode{
        boolean isWord;
        TrieNode[] next;
        public TrieNode(){
            next = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    
    public void add(String word){
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            int c = word.charAt(i)-'a';
            if(cur.next[c] == null){
                cur.next[c] = new TrieNode();
            }
            cur = cur.next[c];
        }
        cur.isWord = true;
    }
    
    public String findRoot(String word){
        TrieNode cur = root;
        int i = 0;
        for(;i<word.length();i++){
            int c = word.charAt(i)-'a';
            if(cur.next[c] == null){
                return word;
            }
            if(cur.next[c].isWord){
                return word.substring(0,i+1);
            }
            cur = cur.next[c];
        }
        return word;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        for(int i = 0;i<dict.size();i++){
            add(dict.get(i));
        }
        String[] str = sentence.split(" ");
        for(int i = 0;i<str.length;i++){
            str[i] = findRoot(str[i]);
        }
        return String.join(" ",str);
    }
}
