/*
Given a M*N matrix, return all elements of the matrix in spiral order.

eg:
[
[1,2,3],
[4,5,6],
[7,8,9]
]
return [1,2,3,6,9,8,7,4,5]
*/

//take advange of list, since the the "add()" will not add duplicate element
//and keep track of position, when numbers of steps in a direction becomes zero, end

public List<Integer> SpiralOrder(int[][] matrix){
  List<Integer> elements = new ArrayList<>();
  if(matrix.length == 0) return elements;
  int m = matrix.length;
  int n = matrix[0].length;
  int row = 0;
  int col = -1;
  while(1){
    for(int i = 0;i < n;i++){
      elements.add(matrix[row][++col]);
    }
    if(--m == 0) break;
    for(int i = 0;i < m; i++){
      elements.add(matrix[++row][col]);
    }
    if(--n == 0) break;
    for(int i = 0;i < n;i++){
      elements.add(matrix[row][--col]);
    }
    if(--m == 0) break;
    for(int i = 0;i < m; i++){
      elements.add(matrix[--row][col]);
    }
    if(--n == 0) break;
  }
  return elements;
}
