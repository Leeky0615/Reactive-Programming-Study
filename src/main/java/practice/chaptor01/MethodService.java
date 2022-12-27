package practice.chaptor01;

import java.util.Arrays;
import java.util.List;

/**
 * List에 있는 숫자 중 6보다 큰 홀수의 합 구하기
 * 명령형, 선언형 프로그래밍 방식 비교
 */
public class MethodService {

    private final List<Integer> numbers;

    public MethodService() {
        this.numbers = Arrays.asList(1, 3, 8, 21, 11, 20);
    }

    public int imperative() {
        int sum = 0;
        for (int num : this.numbers) {
            if (num > 6 && num % 2 != 0) {
                sum += num;
            }
        }
        return sum;
    }

    public int declarative() {
        return this.numbers.stream()
                .filter(num -> num > 6 && num % 2 != 0)
                .mapToInt(value -> value)
                .sum();
    }
}
