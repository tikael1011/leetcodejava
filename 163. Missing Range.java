/*
Given a sorted integer array and a range of elements [start,end] inclusive, return its missing range
For example, start = 0 ,end =99
array [0,1,3,50,75] return ["2","4->49","51->74","76->99"]
*/

public List<String> missingrange(int[] input, int start, int end){
  List<String> res = new ArrayList<>():
  int prev = start -1;
  for(int i = 0; i<=input.length; i++){
    int curr = (i==input.length)?end+1: input[i];
    if(curr- prev >=2){
      res.add(getrange(prev+1, curr-1));
    }
    prev = curr;
  }
  return res;
}

private String getrange(int from, int to){
  return (from==to)?String.valueOf(from): from + "->" + to;
}
