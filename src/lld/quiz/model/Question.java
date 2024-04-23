package lld.quiz.model;

import java.util.List;

public class Question {
    String no;
    String description;
    List<String> options;
    String correctAnswer;

    public Question(String no, String description, List options, String correctAnswer) {
        this.no = no;
        this.description = description;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
