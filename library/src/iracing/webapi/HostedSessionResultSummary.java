package iracing.webapi;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class HostedSessionResultSummary {
    
    public static class SearchParameters {
        
        private int start = 1;
        private int end = 25;
        private long hostCustomerId;
        private long participantCustomerId;
        private String sessionName;
        private Date startTime;
        private Date endTime;
        private SortField sortField = SortField.START_TIME;
        private SortOrder sortOrder = SortOrder.DESCENDING;
        
        public SearchParameters() {}

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public long getHostCustomerId() {
            return hostCustomerId;
        }

        public void setHostCustomerId(long hostCustomerId) {
            this.hostCustomerId = hostCustomerId;
        }

        public long getParticipantCustomerId() {
            return participantCustomerId;
        }

        public void setParticipantCustomerId(long customerId) {
            this.participantCustomerId = customerId;
        }

        public String getSessionName() {
            return sessionName;
        }

        public void setSessionName(String sessionName) {
            this.sessionName = sessionName;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public SortField getSortField() {
            return sortField;
        }

        public void setSortField(SortField sortField) {
            this.sortField = sortField;
        }

        public SortOrder getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(SortOrder sortOrder) {
            this.sortOrder = sortOrder;
        }
        
        public Map<String, String> toParameters() {
            Map<String, String> output = new HashMap<String, String>();
            output.put("lowerbound", String.valueOf(start));
            output.put("upperbound", String.valueOf(end));
            if (hostCustomerId > 0) output.put("host_custid", String.valueOf(hostCustomerId));
            else if (participantCustomerId > 0) output.put("participant_custid", String.valueOf(participantCustomerId));
            else if (sessionName != null) output.put("sessionname", sessionName);
            if (startTime != null) {
                output.put("start_time_lowerbound", String.valueOf(startTime.getTime()));
            }
            if (endTime != null) {
                output.put("start_time_upperbound", String.valueOf(endTime.getTime()));
            }
            if (sortField == SortField.START_TIME) {
                output.put("sort", "start_time");
            } else if (sortField == SortField.SESSION_NAME) {
                output.put("sort", "sessionname");
            } else if (sortField == SortField.HOST_NAME) {
                output.put("sort", "host_displayname");
            } else if (sortField == SortField.TRACK_NAME) {
                output.put("sort", "track_name");
            } else if (sortField == SortField.CAR_NAME) {
                output.put("sort", "car_name");
            } else if (sortField == SortField.PRACTICE_LENGTH) {
                output.put("sort", "practicelength");
            } else if (sortField == SortField.QUALIFYING_LENGTH) {
                output.put("sort", "qualifylength");
            } else if (sortField == SortField.RACE_LAPS) {
                output.put("sort", "racelaps");
            } else if (sortField == SortField.WINNER_NAME) {
                output.put("sort", "winner_displayname");
            }
            output.put("order", (sortOrder == SortOrder.DESCENDING ? "desc" : "asc"));
            return output;
        }
        
    }
    
    public enum SortField {
        START_TIME,
        SESSION_NAME,
        HOST_NAME,
        TRACK_NAME,
        CAR_NAME,
        PRACTICE_LENGTH,
        QUALIFYING_LENGTH,
        RACE_LAPS,
        WINNER_NAME
    }
    
    private boolean wasPrivate;
    private long sessionFastestLap;
    private int practiceLength; // minutes
    private int qualifyingLaps;
    private int qualifyingLength; // minutes
    private int raceLaps;
    private int raceLength; // minutes
    private Date created;
    private Date startTime;
    private int minimumIrating;
    private int maximumIrating;
    private int minimumLicenseLevel;
    private int maximumLicenseLevel;
    private boolean loneQualifying;
    private boolean fixedSetup;
    private int numberOfFastTows; // -1 = unlimited
    private int driverSearchedStartingPosition;
    private int driverSearchedClassStartingPosition;
    private int driverSearchedFinishingPosition;
    private int driverSearchedClassFinishingPosition;
    private long driverSearchedBestLapTime;
    private int driverSearchedCarClassId;
    private int driverSearchedIncidents;
    private int hostLicenseLevel;
    private IracingCustomer host;
    private long privateSessionId;
    private long sessionId;
    private String sessionName;
    private long subSessionId;
    private int trackId;
    private String trackName;
    private IracingCustomer winner;
    private int winnerLicenseLevel;
    private Date raceFinishedAt;
    private Date subSessionFinishedAt;
    private int hardcoreLevelId;
    private boolean nightMode;
    private int restarts;
    private boolean fullCourseCautions;
    private boolean rollingStarts;
    private boolean multiClass;
    private List<Integer> cars;
    private List<Integer> maximumPercentageFuelFills;
    private int maximumDrivers;
    private int categoryId;
    
    public HostedSessionResultSummary() {}

    public boolean isPrivate() {
        return wasPrivate;
    }

    public void setWasPrivate(boolean wasPrivate) {
        this.wasPrivate = wasPrivate;
    }

    public long getSessionFastestLap() {
        return sessionFastestLap;
    }

    public void setSessionFastestLap(long sessionFastestLap) {
        this.sessionFastestLap = sessionFastestLap;
    }

    public int getPracticeLength() {
        return practiceLength;
    }

    public void setPracticeLength(int practiceLength) {
        this.practiceLength = practiceLength;
    }

    public int getQualifyingLaps() {
        return qualifyingLaps;
    }

    public void setQualifyingLaps(int qualifyingLaps) {
        this.qualifyingLaps = qualifyingLaps;
    }

    public int getQualifyingLength() {
        return qualifyingLength;
    }

    public void setQualifyingLength(int qualifyingLength) {
        this.qualifyingLength = qualifyingLength;
    }

    public int getRaceLaps() {
        return raceLaps;
    }

    public void setRaceLaps(int raceLaps) {
        this.raceLaps = raceLaps;
    }

    public int getRaceLength() {
        return raceLength;
    }

    public void setRaceLength(int raceLength) {
        this.raceLength = raceLength;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getMinimumIrating() {
        return minimumIrating;
    }

    public void setMinimumIrating(int minimumIrating) {
        this.minimumIrating = minimumIrating;
    }

    public int getMaximumIrating() {
        return maximumIrating;
    }

    public void setMaximumIrating(int maximumIrating) {
        this.maximumIrating = maximumIrating;
    }

    public int getMinimumLicenseLevel() {
        return minimumLicenseLevel;
    }

    public void setMinimumLicenseLevel(int minimumLicenseLevel) {
        this.minimumLicenseLevel = minimumLicenseLevel;
    }

    public int getMaximumLicenseLevel() {
        return maximumLicenseLevel;
    }

    public void setMaximumLicenseLevel(int maximumLicenseLevel) {
        this.maximumLicenseLevel = maximumLicenseLevel;
    }

    public boolean isLoneQualifying() {
        return loneQualifying;
    }

    public void setLoneQualifying(boolean loneQualifying) {
        this.loneQualifying = loneQualifying;
    }

    public boolean isFixedSetup() {
        return fixedSetup;
    }

    public void setFixedSetup(boolean fixedSetup) {
        this.fixedSetup = fixedSetup;
    }

    public int getNumberOfFastTows() {
        return numberOfFastTows;
    }

    public void setNumberOfFastTows(int numberOfFastTows) {
        this.numberOfFastTows = numberOfFastTows;
    }

    public int getDriverSearchedStartingPosition() {
        return driverSearchedStartingPosition;
    }

    public void setDriverSearchedStartingPosition(int driverSearchedStartingPosition) {
        this.driverSearchedStartingPosition = driverSearchedStartingPosition;
    }

    public int getDriverSearchedClassStartingPosition() {
        return driverSearchedClassStartingPosition;
    }

    public void setDriverSearchedClassStartingPosition(int driverSearchedClassStartingPosition) {
        this.driverSearchedClassStartingPosition = driverSearchedClassStartingPosition;
    }

    public int getDriverSearchedFinishingPosition() {
        return driverSearchedFinishingPosition;
    }

    public void setDriverSearchedFinishingPosition(int driverSearchedFinishingPosition) {
        this.driverSearchedFinishingPosition = driverSearchedFinishingPosition;
    }

    public int getDriverSearchedClassFinishingPosition() {
        return driverSearchedClassFinishingPosition;
    }

    public void setDriverSearchedClassFinishingPosition(int driverSearchedClassFinishingPosition) {
        this.driverSearchedClassFinishingPosition = driverSearchedClassFinishingPosition;
    }

    public long getDriverSearchedBestLapTime() {
        return driverSearchedBestLapTime;
    }

    public void setDriverSearchedBestLapTime(long driverSearchedBestLapTime) {
        this.driverSearchedBestLapTime = driverSearchedBestLapTime;
    }

    public int getDriverSearchedCarClassId() {
        return driverSearchedCarClassId;
    }

    public void setDriverSearchedCarClassId(int driverSearchedCarClassId) {
        this.driverSearchedCarClassId = driverSearchedCarClassId;
    }

    public int getDriverSearchedIncidents() {
        return driverSearchedIncidents;
    }

    public void setDriverSearchedIncidents(int driverSearchedIncidents) {
        this.driverSearchedIncidents = driverSearchedIncidents;
    }

    public int getHostLicenseLevel() {
        return hostLicenseLevel;
    }

    public void setHostLicenseLevel(int hostLicenseLevel) {
        this.hostLicenseLevel = hostLicenseLevel;
    }

    public IracingCustomer getHost() {
        return host;
    }

    public void setHost(IracingCustomer host) {
        this.host = host;
    }

    public long getPrivateSessionId() {
        return privateSessionId;
    }

    public void setPrivateSessionId(long privateSessionId) {
        this.privateSessionId = privateSessionId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public long getSubSessionId() {
        return subSessionId;
    }

    public void setSubSessionId(long subSessionId) {
        this.subSessionId = subSessionId;
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

    public IracingCustomer getWinner() {
        return winner;
    }

    public void setWinner(IracingCustomer winner) {
        this.winner = winner;
    }

    public int getWinnerLicenseLevel() {
        return winnerLicenseLevel;
    }

    public void setWinnerLicenseLevel(int winnerLicenseLevel) {
        this.winnerLicenseLevel = winnerLicenseLevel;
    }

    public Date getRaceFinishedAt() {
        return raceFinishedAt;
    }

    public void setRaceFinishedAt(Date raceFinishedAt) {
        this.raceFinishedAt = raceFinishedAt;
    }

    public Date getSubSessionFinishedAt() {
        return subSessionFinishedAt;
    }

    public void setSubSessionFinishedAt(Date subSessionFinishedAt) {
        this.subSessionFinishedAt = subSessionFinishedAt;
    }

    public int getHardcoreLevelId() {
        return hardcoreLevelId;
    }

    public void setHardcoreLevelId(int hardcoreLevelId) {
        this.hardcoreLevelId = hardcoreLevelId;
    }

    public boolean isNightMode() {
        return nightMode;
    }

    public void setNightMode(boolean nightMode) {
        this.nightMode = nightMode;
    }

    public int getRestarts() {
        return restarts;
    }

    public void setRestarts(int restarts) {
        this.restarts = restarts;
    }

    public boolean isFullCourseCautions() {
        return fullCourseCautions;
    }

    public void setFullCourseCautions(boolean fullCourseCautions) {
        this.fullCourseCautions = fullCourseCautions;
    }

    public boolean isRollingStarts() {
        return rollingStarts;
    }

    public void setRollingStarts(boolean rollingStarts) {
        this.rollingStarts = rollingStarts;
    }

    public boolean isMultiClass() {
        return multiClass;
    }

    public void setMultiClass(boolean multiClass) {
        this.multiClass = multiClass;
    }

    public List<Integer> getCars() {
        return cars;
    }

    public void setCars(List<Integer> cars) {
        this.cars = cars;
    }

    public List<Integer> getMaximumPercentageFuelFills() {
        return maximumPercentageFuelFills;
    }

    public void setMaximumPercentageFuelFills(List<Integer> maximumPercentageFuelFills) {
        this.maximumPercentageFuelFills = maximumPercentageFuelFills;
    }

    public int getMaximumDrivers() {
        return maximumDrivers;
    }

    public void setMaximumDrivers(int maximumDrivers) {
        this.maximumDrivers = maximumDrivers;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
}