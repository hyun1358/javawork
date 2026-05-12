package week11.day4;

public class Answer2 {
    public static void main(String[] args) {
        State s = State.START;
        s = s.next();
        System.out.println(s);
    }
}

enum State {
    START {
        public State next() {
            return IN_PROGRESS;
        }
    },
    IN_PROGRESS {
        public State next() {
            return END;
        }
    },
    END {
        public State next() {
            return END;
        }
    };

    public abstract State next();
}
