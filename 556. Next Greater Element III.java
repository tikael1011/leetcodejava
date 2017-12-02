/*
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the
same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists,
you need to return -1.

Example 1:
Input: 12
Output: 21
Example 2:
Input: 21
Output: -1
*/

/*
the idea can be described as following:
From right to left, find the number[i-1] > number[i], d = number[i-1]
find smallest number greater than d in the right part, swap these two
then sort the right part, care about output if integer overflow.
*/

//while the 'sort' part can be improved, since we know we will the right part is reversed sorted.
//we can define a swap/reverse function instead.

public int nextGreaterElement(int n) {
    char[] arr = String.valueOf(n).toCharArray();

    int i = arr.length - 2;
    while (i >= 0 && arr[i] >= arr[i + 1])
        i--;

    if (i < 0) return -1;

    int j = arr.length - 1;
    while (arr[j] <= arr[i])
        j--;

    swap(arr, i, j);
    reverse(arr, i + 1, arr.length - 1);

    try {
        return Integer.valueOf(String.valueOf(arr));
    } catch (NumberFormatException e) {
        return -1;
    }
}

private void swap(char[] arr, int i, int j) {
    arr[i] ^= arr[j];
    arr[j] ^= arr[i];
    arr[i] ^= arr[j];
}

private void reverse(char[] arr, int i, int j) {
    int l = i, h = j;
    while (l < h)
        swap(arr, l++, h--);
}
