package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SessionDriverResult {
    
    private int finishPosition;
    private int carId;
    private String car;
    private int carClassId;
    private String carClass;
    private long customerId;
    private String customerName;
    private int startingPosition;
    private String carNumber;
    private int reasonOutId;
    private String reasonOut;
    private String interval;
    private int lapsLed;
    private String averageLapTime;
    private String fastestLapTime;
    private int fastestLapNumber;
    private int lapsCompleted;
    private int incidents;
    private int points;
    private int clubPoints;
    private int division;
    private int clubId;
    private String clubName;
    private int oldIrating;
    private int newIrating;
    private int oldLicenseLevel;
    private int oldLicenseSubLevel;
    private int newLicenseLevel;
    private int newLicenseSubLevel;
    private String seriesName;
    private String hostedSessionName;
    private SessionResultDriverLaps driverLaps;

    public SessionDriverResult() {}

    public int getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(int finishPosition) {
        this.finishPosition = finishPosition;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getCarClassId() {
        return carClassId;
    }

    public void setCarClassId(int carClassId) {
        this.carClassId = carClassId;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getReasonOutId() {
        return reasonOutId;
    }

    public void setReasonOutId(int reasonOutId) {
        this.reasonOutId = reasonOutId;
    }

    public String getReasonOut() {
        return reasonOut;
    }

    public void setReasonOut(String reasonOut) {
        this.reasonOut = reasonOut;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public int getLapsLed() {
        return lapsLed;
    }

    public void setLapsLed(int lapsLed) {
        this.lapsLed = lapsLed;
    }

    public String getAverageLapTime() {
        return averageLapTime;
    }

    public void setAverageLapTime(String averageLapTime) {
        this.averageLapTime = averageLapTime;
    }

    public String getFastestLapTime() {
        return fastestLapTime;
    }

    public void setFastestLapTime(String fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }

    public int getFastestLapNumber() {
        return fastestLapNumber;
    }

    public void setFastestLapNumber(int fastestLapNumber) {
        this.fastestLapNumber = fastestLapNumber;
    }

    public int getLapsCompleted() {
        return lapsCompleted;
    }

    public void setLapsCompleted(int lapsCompleted) {
        this.lapsCompleted = lapsCompleted;
    }

    public int getIncidents() {
        return incidents;
    }

    public void setIncidents(int incidents) {
        this.incidents = incidents;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getClubPoints() {
        return clubPoints;
    }

    public void setClubPoints(int clubPoints) {
        this.clubPoints = clubPoints;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getOldIrating() {
        return oldIrating;
    }

    public void setOldIrating(int oldIrating) {
        this.oldIrating = oldIrating;
    }

    public int getNewIrating() {
        return newIrating;
    }

    public void setNewIrating(int newIrating) {
        this.newIrating = newIrating;
    }

    public int getOldLicenseLevel() {
        return oldLicenseLevel;
    }

    public void setOldLicenseLevel(int oldLicenseLevel) {
        this.oldLicenseLevel = oldLicenseLevel;
    }

    public int getOldLicenseSubLevel() {
        return oldLicenseSubLevel;
    }

    public void setOldLicenseSubLevel(int oldLicenseSubLevel) {
        this.oldLicenseSubLevel = oldLicenseSubLevel;
    }

    public int getNewLicenseLevel() {
        return newLicenseLevel;
    }

    public void setNewLicenseLevel(int newLicenseLevel) {
        this.newLicenseLevel = newLicenseLevel;
    }

    public int getNewLicenseSubLevel() {
        return newLicenseSubLevel;
    }

    public void setNewLicenseSubLevel(int newLicenseSubLevel) {
        this.newLicenseSubLevel = newLicenseSubLevel;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getHostedSessionName() {
        return hostedSessionName;
    }
    public void setHostedSessionName(String hostedSessionName) {
        this.hostedSessionName = hostedSessionName;
    }

    public SessionResultDriverLaps getDriverLaps() {
        return driverLaps;
    }

    public void setDriverLaps(SessionResultDriverLaps driverLaps) {
        this.driverLaps = driverLaps;
    }

}