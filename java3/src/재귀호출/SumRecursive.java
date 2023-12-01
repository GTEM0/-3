package 재귀호출;

public class SumRecursive {

    public static void main(String[] args) {
        int result = tenSum( 10);
        System.out.println("1부터 10까지의 합: " + result);
    }

    // 재귀 호출을 이용하여 1부터 n까지의 합을 계산하는 함수
    private static int tenSum(int n) {
        if (n==1) {
            // 기저 조건: start와 end가 같으면 해당 값이 합의 결과
            return 1;
        } else {
            // start부터 end까지의 합은 start부터 end-1까지의 합에 end를 더한 값과 같음
            return n + tenSum(n-1);
        }
    }
}
