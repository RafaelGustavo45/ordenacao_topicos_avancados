import java.util.Arrays;
import java.util.ArrayList;

class TimSort {

	private static final int MIN_MERGE = 32;

	private int minRunLength(int n) {
		assert n >= 0;
		int r = 0;
		while (n >= MIN_MERGE) {
			r |= (n & 1);
			n >>= 1;
		}
		return n + r;
	}

	private void insertionSort(int[] arr, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= left && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	private void merge(int[] arr, int l, int m, int r) {
		int len1 = m - l + 1, len2 = r - m;
		int[] left = Arrays.copyOfRange(arr, l, m + 1);
		int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

		int i = 0, j = 0, k = l;

		while (i < len1 && j < len2) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		while (i < len1) {
			arr[k++] = left[i++];
		}

		while (j < len2) {
			arr[k++] = right[j++];
		}
	}

	public void timSort(int[] arr) {
		int n = arr.length;
		int minRun = minRunLength(n);

		for (int i = 0; i < n; i += minRun) {
			insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
		}

		for (int size = MIN_MERGE; size < n; size = 2 * size) {
			for (int left = 0; left < n; left += 2 * size) {
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (n - 1));

				if (mid < right) {
					merge(arr, left, mid, right);
				}
			}
		}
	}

	public void timSort(ArrayList<Integer> list) {
		int n = list.size();
		int minRun = minRunLength(n);

		for (int i = 0; i < n; i += minRun) {
			insertionSortList(list, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
		}

		for (int size = MIN_MERGE; size < n; size = 2 * size) {
			for (int left = 0; left < n; left += 2 * size) {
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (n - 1));

				if (mid < right) {
					mergeList(list, left, mid, right);
				}
			}
		}
	}

	private void insertionSortList(ArrayList<Integer> arr, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int key = arr.get(i);
			int j = i - 1;
			while (j >= left && arr.get(j) > key) {
				arr.set(j + 1, arr.get(j));
				j--;
			}
			arr.set(j + 1, key);
		}
	}

	private void mergeList(ArrayList<Integer> arr, int l, int m, int r) {
		int len1 = m - l + 1, len2 = r - m;
		ArrayList<Integer> left = new ArrayList<>(arr.subList(l, m + 1));
		ArrayList<Integer> right = new ArrayList<>(arr.subList(m + 1, r + 1));

		int i = 0, j = 0, k = l;

		while (i < len1 && j < len2) {
			if (left.get(i) <= right.get(j)) {
				arr.set(k++, left.get(i++));
			} else {
				arr.set(k++, right.get(j++));
			}
		}

		while (i < len1) {
			arr.set(k++, left.get(i++));
		}

		while (j < len2) {
			arr.set(k++, right.get(j++));
		}
	}
}