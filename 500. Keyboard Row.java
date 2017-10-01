/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard
*/

//for java ,forget about the strean, with regex can be a one-liner solution though.

//the basic idea is to have 3 reference which represents three keyboard rows(string,hashset...)
//then check if the word is a subset of these or every letter are in the same reference.


def findWords(self, words):
    line1, line2, line3 = set('qwertyuiop'), set('asdfghjkl'), set('zxcvbnm')
    ret = []
    for word in words:
      w = set(word.lower())
      if w.issubset(line1) or w.issubset(line2) or w.issubset(line3):
        ret.append(word)
    return ret
    
    
public static String[] findWords(String[] words){
		String s1="qwertyuiop",s2="asdfghjkl",s3="zxcvbnm";
		List<String> list=new ArrayList<String>();
		int count1=0,count2=0,count3=0;
		for(int i=0;i!=words.length;i++){
			for(int j=0;j!=words[i].length();j++){
				if(s1.indexOf(words[i].toLowerCase().charAt(j))!=-1 ){
					count1++;
				}
				if(s2.indexOf(words[i].toLowerCase().charAt(j))!=-1){
					count2++;
				}
				if(s3.indexOf(words[i].toLowerCase().charAt(j))!=-1){
					count3++;
				}
			}
			if(count1==words[i].length() || count2==words[i].length() || count3==words[i].length()){
				list.add(words[i]);
			}
			count1=0;
			count2=0;
			count3=0;
		}
	}
		return list.toArray(new String[0]);
	}
