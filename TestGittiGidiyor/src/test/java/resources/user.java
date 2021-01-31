package resources;

import org.apache.log4j.Logger;
import test.testGittiGidiyor;

public class user {
    private static Logger log = Logger.getLogger(testGittiGidiyor.class);

    private String email=null;
    private String password=null;


    public String getEmail() {
        if(email==null){
            log.error("test/java/pages/resources/user sınıfına GEÇERLİ BİR EMAİL ADRESİ GİRİN");
        }
        return email;
    }

    public String getPassword() {
        if(password==null){
            log.error("test/java/pages/resources/user sınıfına GEÇERLİ BİR PASSWORD GİRİN");

        }
        return password;
    }
}
