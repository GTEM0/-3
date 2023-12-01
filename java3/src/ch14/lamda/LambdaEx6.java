package ch14.lamda;


import java.util.function.*;
import java.util.*;

class LambdaEx6 {
	public static void main(String[] args) {
		
		//기본형
		
		//입력없고, int 반환 ( int값을 반환한다(제공한다) ) 
		IntSupplier  s = ()-> (int)(Math.random()*100)+1;
		
		//int입력, 반환없음 (입력받은  int값  사용(소비)한다 ) 
		IntConsumer  c = i -> System.out.print(i+", ");
		
		//int입력받고 boolean 반환 (int값 판별)
		IntPredicate p = i -> i%2==0; 
		
		
		// int 값을 받아들이고 int 값을 반환 (함수를 의미함)
		//단항연산자
		IntUnaryOperator op = i -> i/10*10; // i의 일의 자리를 없앤다.

		int[] arr = new int[10];

		makeRandomList(s, arr);
		System.out.println(Arrays.toString(arr));
		printEvenNum(p, c, arr);
		int[] newArr = doSomething(op, arr);
		System.out.println(Arrays.toString(newArr));
	}

	
	//arr의 배열의 요소가 random값으로 채워진다
	static void makeRandomList(IntSupplier s, int[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = s.getAsInt();  // get()이 아니라 getAsInt()임에 주의
		}
	}

	
	//***배열의 요소가 짝수이면 출력함 
	static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
		System.out.print("[");
		for(int i : arr) {
			if(p.test(i))
				c.accept(i);
		}	
		System.out.println("]");
	}

	
	//***배열의 요소값의 일의자리를 없앤다 
	//12=>10
	//5=>0
	//43=>40	
	static int[] doSomething(IntUnaryOperator op, int[] arr) {
		int[] newArr = new int[arr.length];

		for(int i=0; i<newArr.length;i++) {
			newArr[i] = op.applyAsInt(arr[i]); // apply()가 아님에 주의
		}	

		return newArr;
	}
}
