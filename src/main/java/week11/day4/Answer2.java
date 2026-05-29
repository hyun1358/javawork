package week11.day4;

// 열거형(Enum)을 활용하여 상태 패턴(State Pattern) 혹은 상태 전이 머신을 구현한 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) {
        // 초기 상태를 START로 설정합니다.
        State s = State.START;
        // next() 메서드를 호출하여 다음 상태로 전이합니다.
        s = s.next();
        // 전이된 상태(IN_PROGRESS)를 출력합니다.
        System.out.println(s);
    }

    // 상태를 나타내는 열거형
    enum State {
        START {
            // START 상태에서 다음 상태는 IN_PROGRESS입니다.
            @Override
            public State next() {
                return IN_PROGRESS;
            }
        },
        IN_PROGRESS {
            // IN_PROGRESS 상태에서 다음 상태는 END입니다.
            @Override
            public State next() {
                return END;
            }
        },
        END {
            // END 상태에서는 더 이상 진행할 수 없으므로 자기 자신을 반환합니다.
            @Override
            public State next() {
                return END;
            }
        };
        
        // 각 열거 상수가 반드시 구현해야 하는 추상 메서드 선언
        public abstract State next();
    }
}
