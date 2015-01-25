package home;

import rank.Ranks;
import storage.DataSource;

import java.util.ArrayList;

/**
 * Created by sara on 23.11.2014.
 */
public class UserManager {

    DataSource dataSource;
    String firstName;
    String lastName;
    String email;
    String userName;
    String password;
    int enabled;
    String school;
    String city;
    String judet;
    String bac;
    String image;

    public void register(String firstName, String lastName, String email, String userName,
                         String password, int enabled, String school,
                         String city, String judet, String bac, String image) {
        dataSource.simpleQuery("insert into users values ('"+userName+"', '"+password+"', "
        +enabled+", '"+email+"', '"+firstName+"', '"+lastName+"', '"+school+"', '"+city+"', '"+judet+"', '"+bac+"', '"+image+"');");

        dataSource.simpleQuery("insert into user_roles (username, ROLE) values ('"+userName+"', 'ROLE_USER');");

        dataSource.simpleQuery("insert into user_learn_stage (username, romSubI, romSubIII, istSubI, istSubIII, geoSubI, geoSubII, geoSubIII, bioSubI, bioSubII, bioSubIII, anaSubI, anaSubII, anaSubIII)" +
                " values ('"+userName+"', '0|0', '0|0', '0|0', '0|0', '0|0', '0|0', '0|0', '0|0', '0|0', '0|0', '0|0', '0|0', '0|0');");
    }

    public ArrayList<String> getUserInfo(String username) {
        ArrayList userInfo = dataSource.getAll("select * from users where username='"+username+"';");

        return userInfo;
    }

    public ArrayList<String> getUserLearnStageInfo(String username) {
        ArrayList userLearnStageInfo = dataSource.getAll("select * from user_learn_stage where username='"+username+"';");

        return userLearnStageInfo;
    }

    public ArrayList<String[]> getAllUsersForRank() {

        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> romana = new ArrayList<Integer>();
        ArrayList<Integer> istorie = new ArrayList<Integer>();
        ArrayList<Integer> geografie = new ArrayList<Integer>();
        ArrayList<Integer> biologie = new ArrayList<Integer>();
        ArrayList<Integer> anatomie = new ArrayList<Integer>();

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
            int geografieStage = Ranks.getRankSubs(Ranks.getSecondElement(s[6]) + Ranks.getSecondElement(s[7]), Ranks.getFirstElement(s[6]) + Ranks.getFirstElement(s[7]));
            geografie.add(geografieStage);
        }
        for(String[] s : userinfo) {
            int biologieStage = Ranks.getRankSubs(Ranks.getSecondElement(s[8]) + Ranks.getSecondElement(s[9]), Ranks.getFirstElement(s[8]) + Ranks.getFirstElement(s[9]));
            biologie.add(biologieStage);
        }
        for(String[] s : userinfo) {
            int anatomieStage = Ranks.getRankSubs(Ranks.getSecondElement(s[10]) + Ranks.getSecondElement(s[11]), Ranks.getFirstElement(s[10]) + Ranks.getFirstElement(s[11]));
            anatomie.add(anatomieStage);
        }

        return userinfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getBac() {
        return bac;
    }

    public void setBac(String bac) {
        this.bac = bac;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }



}
