package lld.quiz.model;

import java.util.List;

public class UserScore {
    public static List<Question> getUserScore(){
        List<Question> questions = List.of(
                new Question("a", "What is 2+2", List.of("4", "8", "5", "6", "9", "0", "4"), "4"),
                new Question("b", "What is 2*2", List.of("4", "8", "5", "6"), "4"),
                new Question("c", "What is 2-2", List.of("4", "0", "5", "6"), "0"),
                new Question("d", "What is 2/2", List.of("4", "0", "1", "6"), "1")
        );

        return questions;
    }
}
