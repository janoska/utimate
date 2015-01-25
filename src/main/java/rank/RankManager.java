package rank;

import storage.DataSource;

import java.util.ArrayList;

/**
 * Created by sara on 06.12.2014.
 */
public class RankManager {

    DataSource dataSource;
    ArrayList<String> name;
    ArrayList<Integer> romana;
    ArrayList<Integer> istorie;
    ArrayList<Integer> geografie;
    ArrayList<Integer> biologie;
    ArrayList<Integer> anatomie;

    public RankManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public RankManager() {}

    public void getAllUsersForRank() {

        name = new ArrayList<String>();
        romana = new ArrayList<Integer>();
        istorie = new ArrayList<Integer>();
        geografie = new ArrayList<Integer>();
        biologie = new ArrayList<Integer>();
        anatomie = new ArrayList<Integer>();

        ArrayList<String[]> userinfo = dataSource.getArr("SELECT users.first_name, users.last_name, user_learn_stage.romSubI, user_learn_stage.romSubIII,\n" +
                "user_learn_stage.istSubI, user_learn_stage.istSubIII, user_learn_stage.geoSubI, \n" +
                "user_learn_stage.geoSubII, user_learn_stage.geoSubIII, user_learn_stage.bioSubI,\n" +
                "user_learn_stage.bioSubII, user_learn_stage.bioSubIII, user_learn_stage.anaSubI,\n" +
                "user_learn_stage.anaSubII, user_learn_stage.anaSubIII from users inner join \n" +
                "user_learn_stage on users.username = user_learn_stage.username;");

        for(String[] s : userinfo) {
            String fullName = s[0]+" "+s[1];
            name.add(fullName);
        }
        for(String[] s : userinfo) {
            int romanaStage = Ranks.getRankSubs(Ranks.getSecondElement(s[2]) + Ranks.getSecondElement(s[3]), Ranks.getFirstElement(s[2]) + Ranks.getFirstElement(s[3]));
            romana.add(romanaStage);
        }
        for(String[] s : userinfo) {
            int istorieStage = Ranks.getRankSubs(Ranks.getSecondElement(s[4]) + Ranks.getSecondElement(s[5]), Ranks.getFirstElement(s[4]) + Ranks.getFirstElement(s[5]));
            istorie.add(istorieStage);
        }
        for(String[] s : userinfo) {
            int geografieStage = Ranks.getRankSubs(Ranks.getSecondElement(s[6]) + Ranks.getSecondElement(s[7]) + Ranks.getSecondElement(s[8]), Ranks.getFirstElement(s[6]) + Ranks.getFirstElement(s[7]) + Ranks.getFirstElement(s[8]));
            geografie.add(geografieStage);
        }
        for(String[] s : userinfo) {
            int biologieStage = Ranks.getRankSubs(Ranks.getSecondElement(s[9]) + Ranks.getSecondElement(s[10]) + Ranks.getSecondElement(s[11]), Ranks.getFirstElement(s[9]) + Ranks.getFirstElement(s[10]) + Ranks.getFirstElement(s[11]));
            biologie.add(biologieStage);
        }
        for(String[] s : userinfo) {
            int anatomieStage = Ranks.getRankSubs(Ranks.getSecondElement(s[12]) + Ranks.getSecondElement(s[13]) + Ranks.getSecondElement(s[14]), Ranks.getFirstElement(s[12]) + Ranks.getFirstElement(s[13]) + Ranks.getFirstElement(s[14]));
            anatomie.add(anatomieStage);
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<Integer> getRomana() {
        return romana;
    }

    public void setRomana(ArrayList<Integer> romana) {
        this.romana = romana;
    }

    public ArrayList<Integer> getIstorie() {
        return istorie;
    }

    public void setIstorie(ArrayList<Integer> istorie) {
        this.istorie = istorie;
    }

    public ArrayList<Integer> getGeografie() {
        return geografie;
    }

    public void setGeografie(ArrayList<Integer> geografie) {
        this.geografie = geografie;
    }

    public ArrayList<Integer> getBiologie() {
        return biologie;
    }

    public void setBiologie(ArrayList<Integer> biologie) {
        this.biologie = biologie;
    }

    public ArrayList<Integer> getAnatomie() {
        return anatomie;
    }

    public void setAnatomie(ArrayList<Integer> anatomie) {
        this.anatomie = anatomie;
    }
}
