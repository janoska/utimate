package game;

import storage.DataSource;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jboy on 9/23/2014.
 */
public class GameManager implements Serializable {

    private static final long serialVersionUID = 7526471155622776147L;

    DataSource dataSource;
    String table;
    int subject;
    ArrayList<String> question;
    ArrayList<String> answer1;
    ArrayList<String> answer2;
    ArrayList<String> answer3;
    ArrayList<String> answer4;

    public GameManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public GameManager() {

    }

    public void getAllDataFromCurriculum() {

        ArrayList<String[]> getAllData = dataSource.getArr("select * from "+table+" where subiect="+subject);

        question = new ArrayList<String>();
        answer1 = new ArrayList<String>();
        answer2 = new ArrayList<String>();
        answer3 = new ArrayList<String>();
        answer4 = new ArrayList<String>();
        for(String[] s : getAllData) {
            question.add(s[2]); }
        for(String[] s : getAllData) {
            answer1.add(s[3]); }
        for(String[] s : getAllData) {
            answer2.add(s[4]); }
        for(String[] s : getAllData) {
            answer3.add(s[5]); }
        for(String[] s : getAllData) {
            answer4.add(s[6]); }

    }

    public String getSubjectCount(String material, int subject) {
        int subjectCount = dataSource.getColumnCount("select count(*) from " + material + " where subiect=" + subject + ";");
        String subjectCounts = String.valueOf(subjectCount);
        return subjectCounts;
    }

    public void insertCurriculum(String table, int subject, String question, String answer1, String answer2, String answer3, String answer4) {
        dataSource.simpleQuery("insert into "+table+" (subiect, intrebare, raspuns1, raspuns2, raspuns3, raspuns4) values ("+subject+", '"+question+"', '"+answer1+"', '"+answer2+"', '"+answer3+"', '"+answer4+"');");
    }

    public void updateLearnStage(String subjectInfo, String username) {
        dataSource.simpleQuery("update user_learn_stage set "+subjectInfo+" where username='"+username+"';");
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public ArrayList<String> getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswer1() {
        return answer1;
    }

    public ArrayList<String> getAnswer2() {
        return answer2;
    }

    public ArrayList<String> getAnswer3() {
        return answer3;
    }

    public ArrayList<String> getAnswer4() {
        return answer4;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

}

