package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class TimeTrialResultStanding {
    
    private double points;
    private String licenseSubLevel;
    private int maxLicenseLevel;
    private int rank;
    private int division;
    private String driverName;
    private long driverCustomerId;
    private int totalStarts;
    private String bestTimeFormatted; //i.e. '2:29.756'
    private long bestTime; // divide by 10000 to get seconds
    private int clubId;
    private long position;
    
    public TimeTrialResultStanding() {}

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getLicenseSubLevel() {
        return licenseSubLevel;
    }

    public void setLicenseSubLevel(String licenseSubLevel) {
        this.licenseSubLevel = licenseSubLevel;
    }

    public int getMaxLicenseLevel() {
        return maxLicenseLevel;
    }

    public void setMaxLicenseLevel(int maxLicenseLevel) {
        this.maxLicenseLevel = maxLicenseLevel;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public long getDriverCustomerId() {
        return driverCustomerId;
    }

    public void setDriverCustomerId(long driverCustomerId) {
        this.driverCustomerId = driverCustomerId;
    }

    public int getTotalStarts() {
        return totalStarts;
    }

    public void setTotalStarts(int totalStarts) {
        this.totalStarts = totalStarts;
    }

    public String getBestTimeFormatted() {
        return bestTimeFormatted;
    }

    public void setBestTimeFormatted(String bestTimeFormatted) {
        this.bestTimeFormatted = bestTimeFormatted;
    }

    public long getBestTime() {
        return bestTime;
    }

    public void setBestTime(long bestTime) {
        this.bestTime = bestTime;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }
    
}