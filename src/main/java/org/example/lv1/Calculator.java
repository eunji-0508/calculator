package org.example.lv1;
// 계산기는 2개의 숫자를 받을 수 있고 사칙연산 될 문자를 받을 수 있다.
// 계산기는 exit을 입력할 때까지 계속해서 값을 받고 연산 결과를 반환한다.

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // exit 전까지 무한 반복 while문 사용
        while (true) {
            // 양의 정수(0 포함)를 입력받기
            // 양의 정수는 각각 하나씩 전달 받기
            // 양의 정수는 적합한 타입으로 선언한 변수에 저장하기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");   // 여기서는 에러 안나는 이유: nextInt()는 숫자만 읽어서 엔터 알아서 버려짐.
            int num2 = scanner.nextInt();

            if ((num1 < 0) || (num2 < 0)) {
                System.out.println("양의 정수만 입력하세요!");
                continue;   // 다시 while문으로 돌아가서 반복
            }

            scanner.nextLine();     // 트러블슈팅: 라인 정리
            System.out.println();   // 깔끔하게 보기 위해 띄어쓰기 추가

            char operator;    // 트러블슈팅: 초기화

            // 사칙연산 기호(+, -, *, /)를 입력받기
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");

                // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장하기 (charAt(0))
                // charAt(0) - 첫 문자만 꺼내겠다
                // String operator =  scanner.next();
                operator = scanner.nextLine().charAt(0);    // 트러블슈팅

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println("+, -, *, / 중에 다시 입력하세요!");
                }
            }

            // 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
            // switch문 사용
            int result = 0;     // 결과값 변수
            boolean correct = true; // 트러블슈팅: 오류일 때 결과 출력 안되게 추가한 변수

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                // 연산 오류 발생할 경우 오류 처리
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        correct = false;
                    } else {
                        result = num1 / num2;
                    }
            }

            if (correct) {
                System.out.println();   // 깔끔하게 보기 위해 띄어쓰기 추가
                System.out.println("결과: " + result);
            }

            System.out.println();   // 깔끔하게 보기 위해 띄어쓰기 추가

            // 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = scanner.nextLine();
            if (answer.equals("exit")) {
                break;
            }
        }
        scanner.close();    // 스캐너 닫기
    }
}
