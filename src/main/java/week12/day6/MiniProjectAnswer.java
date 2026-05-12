package week12.day6;

import java.util.*;

public class MiniProjectAnswer {
    public static void main(String[] args) {
        // 조립 (DI)
        ScoreRepository repo = new MemoryScoreRepository();
        ScoreService service = new ScoreService(repo);

        service.addScore("홍길동", 90);
        service.addScore("이순신", 100);

        service.printAll();
        System.out.println("학급 평균: " + service.getAverage());
    }
}

class Score {
    String name;
    int point;

    Score(String n, int p) {
        name = n;
        point = p;
    }
}

interface ScoreRepository {
    void add(Score s);

    List<Score> findAll();
}

class MemoryScoreRepository implements ScoreRepository {
    private List<Score> db = new ArrayList<>();

    public void add(Score s) {
        db.add(s);
    }

    public List<Score> findAll() {
        return db;
    }
}

class ScoreService {
    private ScoreRepository repo;

    public ScoreService(ScoreRepository repo) {
        this.repo = repo;
    }

    public void addScore(String name, int point) {
        repo.add(new Score(name, point));
    }

    public void printAll() {
        for (Score s : repo.findAll()) System.out.println(s.name + ": " + s.point);
    }

    public double getAverage() {
        List<Score> list = repo.findAll();
        if (list.isEmpty()) return 0;
        return list.stream().mapToInt(s -> s.point).average().orElse(0);
    }
}
