package org.example.lv2;

// 계산된 결과 값들을 기록하는 컬렉션을 만든다.
// 컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능을 만든다.

import java.util.ArrayList;
import java.util.List;

// 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
public class Calculator {
    // 속성(필드)
    // 나중에 변환하게 되면 편하게 하기 위해 List로 작성함 (사실 지금은 상관없음)
    private List<Integer> resultsList = new ArrayList<>();

    private int num1;
    private int num2;
    private char operator;
    private int result;

    // 생성자 - 기본 생성자 사용함

    // 기능
    // 사칙연산을 수행 후, 결과값 반환 메서드 구현
    // 여기에는 매개변수 안줘도 되네
    public int calculate() {
        try {
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

                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    result = num1 / num2;
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); // 에러 메시지 출력 기능
        }
        resultsList.add(result);
        return result;
    }

    // 컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능
    // ArrayList는 순서 유지하기 때문에 첫번째 값 삭제할 수 있음
    // 트러블슈팅- IndexOutOfBoundsException
    // 값 없는데 참조할 거라고 생각을 안함
    public void removeFirstResult () {
        if(resultsList.isEmpty()) {
            System.out.println("저장된 데이터가 없습니다.");
        } else {
            resultsList.remove(0);
        }
    }

    // 삭제되었는지 확인하는 메서드도 필요한가?
    // main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
    public List<Integer> getResultsList() {
        return new ArrayList<>(resultsList);
    }

    // Getter 메서드
    public int getResult() {
        System.out.println("계산 결과: " + result);
        return result;
    }

    // Setter 메서드
    public void setResult(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
    }

