package practice.chaptor01;

public class Programing {
    public static void main(String[] args) {
        MethodService methodService = new MethodService();
        System.out.println("# 명령형 프로그래밍 방식: " + methodService.imperative());
        System.out.println("# 선언형 프로그래밍 방식: " + methodService.declarative());
    }
}
