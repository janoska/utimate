package rank;

/**
 * Created by sara on 29.11.2014.
 */
public class Ranks {

    private static final String SEPARATOR = "\\|";

    public static String[] separateString(String s) {
        return s.split(SEPARATOR);
    }

    public static int getRankSubs(int correctAnswers, int totalAnswers) {
        if(totalAnswers == 0){
            return 0;
        }
        int rankSub = (correctAnswers * 100) / totalAnswers;

        return rankSub;
    }

    public static int getRankRomIst(int rankSubI, int rankSubII) {
        int rankRomIst = (rankSubI / 2) + (rankSubII / 2);

        return rankRomIst;
    }

    public static int getRankGeoBio(int rankSubI, int rankSubII, int rankSubIII) {
        int rankGeoBio = (rankSubI / 3) + (rankSubII / 3) + (rankSubIII / 3);
        if(rankGeoBio == 99) {
            return rankGeoBio + 1;
        }

        return rankGeoBio;
    }

    public static int getFirstElement(String rankInfo) {
        String[] separatedString = separateString(rankInfo);
        int firstElement = Integer.parseInt(separatedString[0]);
        return firstElement;
    }

    public static int getSecondElement(String rankInfo) {
        String[] separatedString = separateString(rankInfo);
        int secondElement = Integer.parseInt(separatedString[1]);
        return secondElement;
    }

    public static int getThirdElement(String rankInfo) {
        String[] separatedString = separateString(rankInfo);
        int thirdElement = Integer.parseInt(separatedString[2]);
        return thirdElement;
    }

    public static int getSum(String rankInfo) {
        String[] s = rankInfo.split("\\|");
        int sum = 0;

        for (int i=0; i<s.length; i++) {
            int num = Integer.parseInt(s[i]);
            sum = sum + num;
        }

        return sum;
    }

    public static String getLearnStage(int counter, int correctAnswers) {
        String answersCount = String.valueOf(counter);
        String corrAnswersCount = String.valueOf(correctAnswers);

        return answersCount + SEPARATOR + corrAnswersCount;
    }



}
