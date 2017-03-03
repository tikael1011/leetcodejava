/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

//most intuitive way
//93ms
//12.8%

public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }
}

//use build-in function
//12ms
//44.53%

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}

//another idea is ot reverse the whole string, then reverse the word, and eliminate extra space

public char[] reverse(char[] arr, int i, int j) {
    while (i < j) {
        char tmp = arr[i];
        arr[i++] = arr[j];
        arr[j--] = tmp;
    }
    return arr;
}

//5ms
//81.04%

public class Solution {
    public char[] reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
        return arr;
    }
    
    public String reverseWords(String s) {
        // reverse the whole string and convert to char array
        char[] str = reverse(s.toCharArray(), 0, s.length()-1);
        int start = 0, end = 0; // start and end positions of a current word
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') { // if the current char is letter 
                str[end++] = str[i]; // just move this letter to the next free pos
            } else if (i > 0 && str[i-1] != ' ') { // if the first space after word
                reverse(str, start, end-1); // reverse the word
                str[end++] = ' '; // and put the space after it
                start = end; // move start position further for the next word
            }
        }
        reverse(str, start, end-1); // reverse the tail word if it's there
        // here's an ugly return just because we need to return Java's String
        // also as there could be spaces at the end of original string 
        // we need to consider redundant space we have put there before
        return new String(str, 0, end > 0 && str[end-1] == ' ' ? end-1 : end);
    }
}

//similar idea, use two pointers
//7ms

public class Solution {
  
  public String reverseWords(String s) {
    if (s == null) return null;
    
    char[] a = s.toCharArray();
    int n = a.length;
    
    // step 1. reverse the whole string
    reverse(a, 0, n - 1);
    // step 2. reverse each word
    reverseWords(a, n);
    // step 3. clean up spaces
    return cleanSpaces(a, n);
  }
  
  void reverseWords(char[] a, int n) {
    int i = 0, j = 0;
      
    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
      reverse(a, i, j - 1);                      // reverse the word
    }
  }
  
  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] a, int n) {
    int i = 0, j = 0;
      
    while (j < n) {
      while (j < n && a[j] == ' ') j++;             // skip spaces
      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
      while (j < n && a[j] == ' ') j++;             // skip spaces
      if (j < n) a[i++] = ' ';                      // keep only one space
    }
  
    return new String(a).substring(0, i);
  }
  
  // reverse a[] from a[i] to a[j]
  private void reverse(char[] a, int i, int j) {
    while (i < j) {
      char t = a[i];
      a[i++] = a[j];
      a[j--] = t;
    }
  }
}
