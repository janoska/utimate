package profile;

import storage.DataSource;

/**
 * Created by sara on 22.11.2014.
 */
public class ProfileManager {

    DataSource dataSource;
    String image;
    String school;
    String city;
    String judet;
    String bac;
    String username;

    public void setProfileInfo(String image, String school, String city, String judet, String bac, String username) {
        dataSource.simpleQuery("update users set image='"+image+"', school='"+school+"', city='"+city+"', judet='"+judet+"', bac='"+bac+"' where username='"+username+"';");
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
