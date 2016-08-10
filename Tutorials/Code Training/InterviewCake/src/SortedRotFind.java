
public class SortedRotFind {

	// We assume we can use a function find(int[] a, int l, int h, int x)
	// find returns the index of the element x, -1 if x is not in the array
	
	// sfind handles arrays which are shifted after being sorted
	// sfind returns the index of the element x, -1 if x is not in the array 
	
	// Complexity: O(ln(n)) operations (testing), O(ln(n)) stack memory
	public static int sfind(int[] arr, int l, int h, int x) {
		
		// Exception: incoherent low and high index
		if (l>h) {
			throw new IllegalArgumentException("array bounds are not in the right order");
		}
		
		int m = (l+h)/2; // euclidian division returns integer
		
		if (arr[l]<=arr[m]) { // left array is sorted

			if (arr[l] <= x && x <= arr[m]) { 
				// x in left sorted array, so we call find
				// case of [7,8,9,12,17,2,4,5] when looking for 9
				return find(arr,l,m,x);
			}
			else 
				// x in right array not sorted
				return sfind(arr,m,h,x);
		}
		
		else { // right array is sorted
			if (arr[m] <= x && x <= arr[h]) { 
				// x in right sorted array, so we call find
				// case of [12,17,2,4,5,7,8,9] when looking for 9
				return find(arr,m,h,x);
			}
			else
				// x in left array not sorted
				return sfind(arr,l,m,x);
		}
	}
}
