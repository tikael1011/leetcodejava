/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,
Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/


//exceed time limit
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> res = new ArrayList<String>();
	        for (int i = 0, j =10; j< s.length();i++,j++){
	            for (int k = i + 1, l = j + 1; l<= s.length();k++,l++){
	                if(s.substring(i,j).equals(s.substring(k,l))){
	                    res.add(s.substring(i,j));
	                }
	            }
	        }
	        List<String> list = new ArrayList<>(new HashSet<>(res)); //in order to return python like :set(list)
	        return list;
    }
}

//similar idea
//48ms

public class Solution{
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }
}



//using hashmap
//65ms

//https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-manipulation/9

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 10) return list;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        for (int i = 0; i + 10 <= s.length(); i++ ) {
            int hash = stringToHash(s.substring(i, i + 10));
            if (map.containsKey(hash)) {
                if (!map.get(hash)) {                     // avoid duplicated
                    list.add(s.substring(i, i + 10));
                    map.put(hash, true);
                }
            } else {
                map.put(hash, false); //record unique number for the substring,'first' iteration/occurence always goes here.
            }
        }
        return list;
    }
    private int stringToHash(String s) {
        int numberBuilder = 0;
        for (int i = 0; i < s.length(); i++) {
            numberBuilder *= 4;
                 if (s.charAt(i) == 'A') numberBuilder += 0;
            else if (s.charAt(i) == 'C') numberBuilder += 1;
            else if (s.charAt(i) == 'G') numberBuilder += 2;
            else if (s.charAt(i) == 'T') numberBuilder += 3;
        }
        return numberBuilder;
    }
}

//44ms
//why the following is damn fast?

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value <<= 2;
            value |= map[s.charAt(i) - 'A'];
            value &= 0xfffff;
            if (i < 9) {
                continue;
            }
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }
}
