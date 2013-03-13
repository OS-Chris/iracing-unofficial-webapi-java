package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SeasonQualifyingResult {
    
    //"1":"bestqualtime","2":"sublevel","3":"custrow","4":"maxlicenselevel","5":"rank","6":"helmcolor1","7":"displayname","8":"helmcolor2","9":"division","10":"custid","11":"helmcolor3","12":"clubid","13":"helmpattern","14":"pos","15":"rowcount","16":"bestqualtimeformatted","17":"rn"
    //{"1":1465493,"2":"+2.36","4":18,"5":1,"6":255,"7":"Mitchell+Abrahall","8":118,"9":1,"10":25765,"11":108,"12":34,"13":62,"14":1,"16":"2%3A26.549","17":1
    private long bestQualifyingTime;
    private String licenseSubLevel;
    private int maxLicenseLevel;
    private int rank;
    private String driverName;
    private int division;
    private long driverCustomerId;
    private int clubId;
    private long position;
    private String bestQualifyingTimeFormatted;
    
    public SeasonQualifyingResult() {}

    public long getBestQualifyingTime() {
        return bestQualifyingTime;
    }

    public void setBestQualifyingTime(long bestQualifyingTime) {
        this.bestQualifyingTime = bestQualifyingTime;
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public long getDriverCustomerId() {
        return driverCustomerId;
    }

    public void setDriverCustomerId(long driverCustomerId) {
        this.driverCustomerId = driverCustomerId;
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

    public String getBestQualifyingTimeFormatted() {
        return bestQualifyingTimeFormatted;
    }

    public void setBestQualifyingTimeFormatted(String bestQualifyingTimeFormatted) {
        this.bestQualifyingTimeFormatted = bestQualifyingTimeFormatted;
    }
    
}