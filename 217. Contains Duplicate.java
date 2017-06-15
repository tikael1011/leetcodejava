/*
check if there is duplicate integer in an unsorted array
*/
/*
1. rc O(n^2) ,brutal force, sc O(1)
2. sort the array, then find.since the "Arrays.sort(args)" uses merge sort, the rc is O(nlg(n)) and sc O(1).
3. use hashset, rc O(n) but sc O(n) as well.

 */ 
// or checkout how stream() makes your java 8 times slower:
  public boolean containsDuplicate(int[] nums) {

        return nums.length != Arrays.stream(nums)
                .distinct()
                .count();
    }
