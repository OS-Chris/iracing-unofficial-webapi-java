package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class LicenseLevel {
    
    private int id;
    private int licenseGroupId;
    private String name;
    
    public LicenseLevel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLicenseGroupId() {
        return licenseGroupId;
    }

    public void setLicenseGroupId(int licenseGroupId) {
        this.licenseGroupId = licenseGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}