package quiz;

import quiz.manager.QuizManager;
import quiz.model.User;

public class Driver {
    public static void main(String[] args) {
        User user = new User("Abhishek");
        QuizManager manager = new QuizManager(user);
        manager.startQuiz();
        manager.printScore();
    }
}
