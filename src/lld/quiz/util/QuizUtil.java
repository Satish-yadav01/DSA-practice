package lld.quiz.util;

import java.util.List;

public class QuizUtil {

    public static boolean checkCorrectAnswer(List<String> options, String userAns, String correctAnswer) {

        StringBuilder sb = new StringBuilder();

        for (char i = 97; i < 97 + options.size(); i++) {
            sb.append(i);
        }

        int correctAnsIndex = sb.toString().indexOf(userAns);

        if (correctAnsIndex == -1) {
            return false;
        }

        String userOption = options.get(correctAnsIndex);

        return userOption.equals(correctAnswer);
    }
}
