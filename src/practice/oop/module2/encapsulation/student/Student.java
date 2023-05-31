package practice.oop.module2.encapsulation.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

  private final String name;
  private final List<Integer> scores;

  public Student(String name) {
    this(name, new ArrayList<>());
  }

  public Student(String name, List<Integer> scores) {
    this.name = name;
    this.scores = new ArrayList<>();
    if (!scores.isEmpty() && isValid(scores)) {
      this.scores.addAll(scores);
    }
  }

  public String getName() {
    return name;
  }

  public List<Integer> getScores() {
    return scores;
  }

  public void setScores(int score) {
    if (score >= 2 && score <= 5) {
      scores.add(score);
    } else {
      throw new IllegalArgumentException("Ratings can be from 2 to 5");
    }
  }

  public void setScores(List<Integer> scores) {
    if (!scores.isEmpty() && isValid(scores)) {
      this.scores.addAll(scores);
    }
  }

  @Override
  public String toString() {
    if (scores.isEmpty()) {
      return name + ": отсутствуют";
    } else {
      return name + ": " + scores;
    }
  }

  private boolean isValid(List<Integer> scores) {
    if (Collections.max(scores) <= 5 && Collections.min(scores) >= 2) {
      return true;
    } else {
      throw new IllegalArgumentException("Ratings can be from 2 to 5");
    }
  }
}
