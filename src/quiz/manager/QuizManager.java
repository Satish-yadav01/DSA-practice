package quiz.manager;


import quiz.model.Question;
import quiz.model.User;
import quiz.model.UserScore;
import quiz.util.QuizUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizManager {
    
    User user;
    int userScore;

    public QuizManager(User user) {
        this.user = user;
    }

    public void startQuiz(){
        Scanner sc = new Scanner(System.in);
        List<Question> userScores = UserScore.getUserScore();

        System.out.println("Hello " + user.getName() + ", welcome to the quiz");

        for (int i = 0; i <= userScores.size()-1; i++) {
            System.out.print(userScores.get(i).getNo() + ". "+ userScores.get(i).getDescription()+"\n");
            System.out.println("Options");
            List<String> options = new ArrayList<>(userScores.get(i).getOptions());
            Collections.shuffle(options);

            char optionsIndex = 97;
            for (int j = 0; j <= options.size() - 1; j++) {
                System.out.println(optionsIndex+") "+ options.get(j));
                optionsIndex++;
            }

            System.out.println("Choose correct option: ");
            String userAns = sc.next();

            if(QuizUtil.checkCorrectAnswer(options,userAns,userScores.get(i).getCorrectAnswer())){
                userScore++;
            }

            break;
        }

    }

    public void printScore() {
        System.out.println(user.getName() +" scored : " + userScore);
    }
}
