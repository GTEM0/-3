package 재귀호출;

public class MaxRecursive {

    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 6, 2, 10, 5};
        int max = findMax(arr, 0, arr.length - 1);
        System.out.println("배열의 최대값: " + max);
    }

    // 재귀 호출을 이용하여 배열의 최대값을 찾는 함수
    private static int findMax(int[] arr, int start, int end) {
        if (start == end) {
            // 배열의 크기가 1인 경우
            return arr[start];
        } else {
            // 배열을 두 부분으로 나누어 각 부분에서 최대값을 찾음
            int mid = (start + end) / 2;
            int max1 = findMax(arr, start, mid);
            int max2 = findMax(arr, mid + 1, end);
            
            // 두 부분에서 찾은 최대값 중 큰 값을 반환
            return  max1> max2?max1:max2;
        }
    }
}
