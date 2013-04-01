package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class IracingLoginCredentials {
    
    private String emailAddress, password;
    
    public IracingLoginCredentials() {}
    public IracingLoginCredentials(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}