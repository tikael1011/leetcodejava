/*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. 
The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
*/


//The intuitive solution is trivia, while an elegant one is not, just forget about java~

class Solution:
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        moves = list(moves)
        v = h = 0
        for i in range(len(moves)):
            if moves[i] == 'D':
                v += 1
            elif moves[i] == 'U':
                v -= 1
            elif moves[i] == 'R':
                h += 1
            elif moves[i] == 'L':
                h -= 1
        return (v == 0 and h == 0)
        
// The following one is one-liner, but not elegant, Nor the collections.Counter function

def judgeCircle(self, moves):
    return moves.count('L') == moves.count('R') and moves.count('U') == moves.count('D')
    
//While the following one is my favourite, fast and smart.

def judgeCircle(self, moves):
    direct = {'U': 1, 'D': -1, 'L': 1j, 'R': -1j}
    return 0 == sum(direct[m] for m in moves)
    
//some trick, slower though

def judgeCircle(self, moves):
    return not sum(1j**'RUL'.find(m) for m in moves)
