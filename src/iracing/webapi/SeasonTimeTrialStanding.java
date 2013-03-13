package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SeasonTimeTrialStanding {
    
    //{"m":{"1":"dropped","2":"clubname","3":"points","4":"sublevel","5":"custrow","6":"maxlicenselevel","7":"rank","8":"helmcolor1","9":"division","10":"displayname","11":"helmcolor2","12":"custid","13":"helmcolor3","14":"starts","15":"clubid","16":"helmpattern","17":"week","18":"rowcount","19":"wins","20":"pos","21":"rn"},"d":{"5":"-1","18":14,"r":[{"1":0,"2":"Australia%2FNZ","3":665.1786957,"4":"+4.63","6":20,"7":1,"8":240,"9":0,"10":"Simon+Black","11":240,"12":17455,"13":244,"14":16,"15":34,"16":19,"17":7,"19":16,"20":1,"21":1},{"1":0,"2":"Iberia","3":645.4015045,"4":"+4.81","6":20,"7":2,"8":240,"9":0,"10":"Omar+S%C3%B2to","11":114,"12":88011,"13":100,"14":11,"15":38,"16":45,"17":7,"19":11,"20":2,"21":2},{"1":0,"2":"Australia%2FNZ","3":358.8825836,"4":"+3.88","6":15,"7":3,"8":47,"9":0,"10":"Trevor+Forster","11":212,"12":17417,"13":212,"14":4,"15":34,"16":32,"17":4,"19":4,"20":3,"21":3},{"1":0,"2":"International+Club","3":263.0749436,"4":"+3.24","6":19,"7":4,"8":255,"9":0,"10":"Wayne+Wortley","11":252,"12":30467,"13":246,"14":8,"15":1,"16":1,"17":3,"19":8,"20":4,"21":4},{"1":0,"2":"Australia%2FNZ","3":200,"4":"+3.16","6":19,"7":5,"8":240,"9":0,"10":"Joshua+Muggleton","11":112,"12":51878,"13":52,"14":5,"15":34,"16":12,"17":2,"19":5,"20":5,"21":5},{"1":0,"2":"Australia%2FNZ","3":197.3947372,"4":"+2.75","6":18,"7":6,"8":113,"9":0,"10":"Josh+Smith","11":116,"12":60147,"13":118,"14":4,"15":34,"16":35,"17":2,"19":4,"20":6,"21":6},{"1":0,"2":"Australia%2FNZ","3":194.8804321,"4":"+3.35","6":19,"7":7,"8":240,"9":0,"10":"Wayne+Tolley","11":127,"12":49363,"13":255,"14":3,"15":34,"16":68,"17":2,"19":3,"20":7,"21":7},{"1":0,"2":"Australia%2FNZ","3":100,"4":"+3.61","6":19,"7":8,"8":240,"9":0,"10":"Peter+Read","11":123,"12":18070,"13":252,"14":1,"15":34,"16":62,"17":1,"19":1,"20":8,"21":8},{"1":0,"2":"Australia%2FNZ","3":94.7894745,"4":"+3.61","6":19,"7":9,"8":60,"9":0,"10":"Stephen+Titow","11":116,"12":16671,"13":112,"14":2,"15":34,"16":60,"17":1,"19":2,"20":9,"21":9},{"1":0,"2":"Iberia","3":93.25,"4":"+2.48","6":18,"7":10,"8":132,"9":0,"10":"Samuel+de+la+Fuente","11":77,"12":80801,"13":112,"14":1,"15":38,"16":59,"17":1,"19":1,"20":10,"21":10},{"1":0,"2":"Australia%2FNZ","3":87.625,"4":"+4.46","6":20,"7":11,"8":255,"9":0,"10":"Troy+Cox","11":240,"12":49209,"13":96,"14":1,"15":34,"16":68,"17":1,"19":1,"20":11,"21":11},{"1":0,"2":"Scandinavia","3":81.7631607,"4":"+4.16","6":20,"7":12,"8":116,"9":0,"10":"Jacob+Fredriksson","11":116,"12":26161,"13":124,"14":2,"15":43,"16":64,"17":1,"19":2,"20":12,"21":12},{"1":0,"2":"Australia%2FNZ","3":0,"4":"+4.32","6":20,"7":14,"8":255,"9":0,"10":"Charles+Ng","11":255,"12":30010,"13":255,"14":1,"15":34,"16":68,"17":1,"19":1,"20":13,"21":13},{"1":0,"2":"England","3":0,"4":"+2.67","6":18,"7":13,"8":254,"9":0,"10":"Simon+Hill","11":105,"12":20386,"13":144,"14":1,"15":36,"16":18,"17":1,"19":1,"20":14,"21":14}]}}
    private int droppedWeeks;
    private String clubName;
    private double totalPoints;
    private String licenseSubLevel;
    private int maxLicenseLevel;
    private int rank;
    private int division;
    private String driverName;
    private long driverCustomerId;
    private int totalStarts;
    private int clubId;
    private int weeksCounted;
    private int totalWins;
    private int position;
    
    public SeasonTimeTrialStanding() {}

    public int getDroppedWeeks() {
        return droppedWeeks;
    }

    public void setDroppedWeeks(int droppedWeeks) {
        this.droppedWeeks = droppedWeeks;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
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

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public int getWeeksCounted() {
        return weeksCounted;
    }

    public void setWeeksCounted(int weeksCounted) {
        this.weeksCounted = weeksCounted;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
}