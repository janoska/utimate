package game;

/**
 * Created by jboy on 10/4/2014.
 */
public class GameUtils {

    private final static String CORRECT_ANSWER_PATTERN = "***";

    private int counter = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private int totalQuestions = 0;
    private int remainedQuestions= 0;

    public static boolean checkAnswer(String answer, boolean answers) {
        boolean checkedAnswer;
        if(answer.endsWith(CORRECT_ANSWER_PATTERN)) {
            if (answers) {
                checkedAnswer = true;
            } else {
                checkedAnswer = false;
            }
            return checkedAnswer;
        }
        else {
            if(answers) {
                checkedAnswer = false;
            }
            else {
                checkedAnswer = true;
            }
            return checkedAnswer;
        }
    }

    public static String answerFilter(String answer) {
        if(answer.endsWith(CORRECT_ANSWER_PATTERN)) {
            answer = answer.substring(0, answer.length()-3);
        }
        return answer;
    }

    public static String getLearnStageResult(String curriculum, int subject, String learnStage) {
        if(curriculum == "romana") {
            if(subject == 1) {
                return "romSubI='"+learnStage+"'";
            }
            else {
                return "romSubIII='"+learnStage+"'";
            }
        }
        else if(curriculum == "istorie") {
            if(subject == 1) {
                return "istSubI='"+learnStage+"'";
            }
            else {
                return "istSubIII='"+learnStage+"'";
            }
        }
        else if(curriculum == "geografie") {
            if(subject == 1) {
                return "geoSubI='"+learnStage+"'";
            }
            else if(subject == 2) {
                return "geoSubII='"+learnStage+"'";
            }
            else {
                return "geoSubIII='"+learnStage+"'";
            }
        }
        else if(curriculum == "biologie") {
            if(subject == 1) {
                return "bioSubI='"+learnStage+"'";
            }
            else if(subject == 2) {
                return "bioSubII='"+learnStage+"'";
            }
            else {
                return "bioSubIII='"+learnStage+"'";
            }
        }
        else {
            if(subject == 1) {
                return "anaSubI='"+learnStage+"'";
            }
            else if(subject == 2) {
                return "anaSubII='"+learnStage+"'";
            }
            else {
                return "anaSubIII='"+learnStage+"'";
            }
        }
    }

    public static String getCurriculum(String curriculum) {
//        switch(curriculum) {
//            case "romana": return "Rom&#226n&#259";
//            case "istorie": return "Istorie";
//            case "geografie": return "Geografie";
//            case "biologie": return "Biologie";
//            default: return "";
//        }
        return "Istorie";
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getRemainedQuestions() {
        return remainedQuestions;
    }

    public void setRemainedQuestions(int remainedQuestions) {
        this.remainedQuestions = remainedQuestions;
    }
}
