/*
The api: int read4(char *buf) reads 4 characterss at a time from a file
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters in the 
file.
By using the read4 API, implement the function read(char *buf, int n) that reads n characters from the file

Note: The read function will only be called once for each test case
*/

/**
be ware of edge cases, where read4 returns 4 and that means the last 4 characters in the file.
**/

public Solution extends read4{
  public int read(char[] buff, int n){
    char[] buffer = new char[4];
    int readbytes = 0;
    boolean eof = false;
    while(!eof && readbytes < 4){
      int size = read4(buffer);
      if(size<4) eof = true;
      int bytes = Math.min(n- readbytes, size);
      System.arraycopy(buffer /*src*/,0 /*srcPos*/, buff /*dest*/, readbytes /*destPos*/, bytes /*length*/);
      readbytes += bytes;
    }
    return readbytes;
  }
}

//no flag version

    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i += 4) {
            char[] tmp = new char[4];
            int len = read4(tmp);
            System.arraycopy(tmp, 0, buf, i, Math.min(len, n - i));
            if (len < 4) return Math.min(i + len, n);
        }
        return n; /* i >= n */
    }
    
    
 //no arraycopy version
 
 
 public int read(char[] buf, int n) {
  boolean eof = false;      // end of file flag
  int total = 0;            // total bytes have read
  char[] tmp = new char[4]; // temp buffer
  
  while (!eof && total < n) {
    int count = read4(tmp);
    
    // check if it's the end of the file
    eof = count < 4;
    
    // get the actual count
    count = Math.min(count, n - total);
    
    // copy from temp buffer to buf
    for (int i = 0; i < count; i++) 
      buf[total++] = tmp[i];
  }
  
  return total;
}
