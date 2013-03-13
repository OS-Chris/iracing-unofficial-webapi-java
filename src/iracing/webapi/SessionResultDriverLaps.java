package iracing.webapi;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SessionResultDriverLaps {
    
    private int lapsForSolo;
    private int lapsForQualifying;
    private int bestNLapsNumber;
    private int bestNLapsTime;
    private int bestLapNumber;
    private long bestQualifyingLapTime;
    private String seasonShortName;
    private String seasonName;
    private String seriesShortName;
    private String seriesName;
    private int maximumLicenseLevel;
    private String driverName;
    private long sessionId;
    private long subSessionId;
    private String carNumber;
    private int carId;
    private int eventTypeId;
    private String eventTypeName;
    private int bestQualifyingLapAt;
    private int bestQualifyingLapNumber;
    private int trackId;
    private String trackName;
    private String trackConfigName;
    private Date eventDate;
    private List<SessionResultDriverLap> laps;
    
    public SessionResultDriverLaps() {}

    public int getLapsForSolo() {
        return lapsForSolo;
    }

    public void setLapsForSolo(int lapsForSolo) {
        this.lapsForSolo = lapsForSolo;
    }

    public int getLapsForQualifying() {
        return lapsForQualifying;
    }

    public void setLapsForQualifying(int lapsForQualifying) {
        this.lapsForQualifying = lapsForQualifying;
    }

    public int getBestNLapsNumber() {
        return bestNLapsNumber;
    }

    public void setBestNLapsNumber(int bestNLapsNumber) {
        this.bestNLapsNumber = bestNLapsNumber;
    }

    public int getBestNLapsTime() {
        return bestNLapsTime;
    }

    public void setBestNLapsTime(int bestNLapsTime) {
        this.bestNLapsTime = bestNLapsTime;
    }

    public int getBestLapNumber() {
        return bestLapNumber;
    }

    public void setBestLapNumber(int bestLapNumber) {
        this.bestLapNumber = bestLapNumber;
    }

    public long getBestQualifyingLapTime() {
        return bestQualifyingLapTime;
    }

    public void setBestQualifyingLapTime(long bestQualifyingLapTime) {
        this.bestQualifyingLapTime = bestQualifyingLapTime;
    }

    public String getSeasonShortName() {
        return seasonShortName;
    }

    public void setSeasonShortName(String seasonShortName) {
        this.seasonShortName = seasonShortName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeriesShortName() {
        return seriesShortName;
    }

    public void setSeriesShortName(String seriesShortName) {
        this.seriesShortName = seriesShortName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getMaximumLicenseLevel() {
        return maximumLicenseLevel;
    }

    public void setMaximumLicenseLevel(int maximumLicenseLevel) {
        this.maximumLicenseLevel = maximumLicenseLevel;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public long getSubSessionId() {
        return subSessionId;
    }

    public void setSubSessionId(long subSessionId) {
        this.subSessionId = subSessionId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public int getBestQualifyingLapAt() {
        return bestQualifyingLapAt;
    }

    public void setBestQualifyingLapAt(int bestQualifyingLapAt) {
        this.bestQualifyingLapAt = bestQualifyingLapAt;
    }

    public int getBestQualifyingLapNumber() {
        return bestQualifyingLapNumber;
    }

    public void setBestQualifyingLapNumber(int bestQualifyingLapNumber) {
        this.bestQualifyingLapNumber = bestQualifyingLapNumber;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackConfigName() {
        return trackConfigName;
    }

    public void setTrackConfigName(String trackConfigName) {
        this.trackConfigName = trackConfigName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<SessionResultDriverLap> getLaps() {
        return laps;
    }

    public void setLaps(List<SessionResultDriverLap> laps) {
        this.laps = laps;
    }
    
}