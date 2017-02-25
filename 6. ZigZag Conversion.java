/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

//75ms
//35.86%

public class Solution {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}

//74ms

public class Solution {
    public String convert(String s, int nRows) {
        
        if(nRows <=1)
            return s;
       
       StringBuilder[] r = new StringBuilder[nRows];
       for( int i=0; i<nRows; i++ )
           r[i] = new StringBuilder();
       
        int base = nRows+nRows-2;
        char[] toks = s.toCharArray();
        for(int i = 0; i < toks.length; i++)
        {
            int t = i % base;
            if(t < nRows)
            {
                r[t].append(toks[i]); // on the 'vertical/column'
            }
            else
            {
                r[base-t].append(toks[i]); // on the 'slope'
            }
        }
        
        for( int i = 1; i<nRows; i++ )
            r[0].append( r[i] );
        return r[0].toString();
    }
}


//58ms
//60.37%

public String convert(String s, int numRows) {
    if(numRows == 1) return s;
    int gap = (numRows-1)<<1;
    StringBuilder result = new StringBuilder();
    for(int i=0; i<numRows; i++) {
        int current = i;
        int offset = gap - (i<<1);
        while(current<s.length()) {
            if( offset != 0 ) { 
                // avoid inserting duplicate elements
                // in the first and the last row
                result.append(s.charAt(current));

                current += offset;
            }
            offset = gap-offset;
        }
    }
    
    return result.toString();
}

//67ms
//43.14%

public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() <= numRows || numRows == 1) return s;
        List<List<Character>> resList = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++) {
            resList.add(new ArrayList<Character>());
        }
        for (int i = 0; i < s.length(); i++) {
            int indexInGroup = i % (2 * numRows - 2);
            int indexInList = indexInGroup < numRows ? indexInGroup : 2 * numRows - 2 - indexInGroup;
            resList.get(indexInList).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : resList) {
            for (Character c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
