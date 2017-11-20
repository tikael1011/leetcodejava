
'''
Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
'''

'''
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
'''


# the basic idea is similar to Dijkstra's algorithm, and in order to make sure a 'shortest', we use BFS instead of DFS
# and we have one improvement, use a two-end BFS instead of a traditional BFS.
# from 
# https://discuss.leetcode.com/topic/43246/simple-to-understand-python-solution-using-list-preprocessing-and-bfs-beats-95 
# https://discuss.leetcode.com/topic/19721/share-my-two-python-solutions-a-very-concise-one-12-lines-160ms-and-an-optimized-solution-100ms/2
