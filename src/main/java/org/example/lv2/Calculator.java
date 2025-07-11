package org.example.lv2;

// 계산된 결과 값들을 기록하는 컬렉션을 만든다.
// 컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능을 만든다.

import java.util.ArrayList;
import java.util.List;

// 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
public class Calculator {
    // 속성
    // 나중에 있을수도 있는 변환 때 편하게 하기위해 List로 작성함 (사실 상관없음)
    private List<Integer> resultsList = new ArrayList<>();

    private int num1;
    private int num2;
    private char operator;
    private int result;

    // 생성자

    // 기능
    // 사칙연산을 수행 후, 결과값 반환 메서드 구현
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
                        return -1;
                    }
                    result = num1 / num2;
                    break;

                default:
                    System.out.println("+, -, *, / 중에 다시 입력하세요!");
                    return -1;
            }
        } catch (ArithmeticException e) {
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            return -1;
        }
        resultsList.add(result);
        return result;
    }

    // 컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능
    // ArrayList는 순서 유지하기 때문에 첫번째 값 삭제할 수 있음
     // 트러블슈팅- IndexOutOfBoundsException
    public void removedFirst () {
        if(resultsList.isEmpty()) {
            System.out.println("저장된 데이터가 없습니다.");
        } else {
            resultsList.remove(0);
        }
    }

//    // 삭제되었는지 확인하는 메서드도 필요한가?
//    public void getResultsList() {
//        System.out.println("resultsList = " + resultsList);
//    }

    //  main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
    // Getter 메서드
    public int getResult() {
        return result;
    }

    // Setter 메서드
    public void setResult(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
    }

