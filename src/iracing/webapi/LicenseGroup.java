package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class LicenseGroup {

    private int id;
    private String name;
    private int minimumNumberOfRaces;
    private int minimumNumberOfTimeTrials;
    
    public LicenseGroup() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumNumberOfRaces() {
        return minimumNumberOfRaces;
    }

    public void setMinimumNumberOfRaces(int minimumNumberOfRaces) {
        this.minimumNumberOfRaces = minimumNumberOfRaces;
    }

    public int getMinimumNumberOfTimeTrials() {
        return minimumNumberOfTimeTrials;
    }

    public void setMinimumNumberOfTimeTrials(int minimumNumberOfTimeTrials) {
        this.minimumNumberOfTimeTrials = minimumNumberOfTimeTrials;
    }
    
}