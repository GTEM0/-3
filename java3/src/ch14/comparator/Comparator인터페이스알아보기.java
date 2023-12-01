package ch14.comparator;

public class Comparator인터페이스알아보기 {

	public static void main(String[] args) {

			 /*interface Comparator<T>{
				int	compare(T o1, T o2) 
				static <T,U extends Comparable<? super U>> Comparator<T>	comparing(Function<? super T,? extends U> keyExtractor)
				static <T,U> Comparator<T>	comparing(Function<? super T,? extends U> keyExtractor, Comparator<? super U> keyComparator)
				static <T> Comparator<T>	comparingDouble(ToDoubleFunction<? super T> keyExtractor)
				static <T> Comparator<T>	comparingInt(ToIntFunction<? super T> keyExtractor)
				static <T> Comparator<T>	comparingLong(ToLongFunction<? super T> keyExtractor)
				static <T extends Comparable<? super T>> Comparator<T>	naturalOrder() 
				static <T> Comparator<T>	nullsFirst(Comparator<? super T> comparator)
				static <T> Comparator<T>	nullsLast(Comparator<? super T> comparator)
				default Comparator<T>	reversed()
				static <T extends Comparable<? super T>>
				Comparator<T>	reverseOrder()
				default Comparator<T>	thenComparing(Comparator<? super T> other)
				default <U extends Comparable<? super U>>
				Comparator<T>	thenComparing(Function<? super T,? extends U> keyExtractor)
				default <U> Comparator<T>	thenComparing(Function<? super T,? extends U> keyExtractor, Comparator<? super U> keyComparator)
				default Comparator<T>	thenComparingDouble(ToDoubleFunction<? super T> keyExtractor)
				default Comparator<T>	thenComparingInt(ToIntFunction<? super T> keyExtractor)
				default Comparator<T>	thenComparingLong(ToLongFunction<? super T> keyExtractor)
				
		 * }
		 * 
		 * static매서드 :  클래스매서드라고 함  객체생성과 상관없이 사용할 수 있다.		 * 
		 * 
		 * default : => 인터페이스를 구현하는 모든 객체가 똑같은 기능을 구현해야 한다면, 미리구현한 상태로 제공하는것이 효율적이다
		 *           => 객체가 있어야 실행되는 매서드이다
		 * 		     => 다른 추상매서드를 호출할 수 있다.
		 * 
		 * 
		 * 
		 */

	}

}
