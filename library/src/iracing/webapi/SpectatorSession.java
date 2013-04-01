package iracing.webapi;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SpectatorSession {

    public static class BroadcastInfo {
        
        private boolean canBroadcast;
        private long subSessionId;
        private boolean broadcaster;
        private int maximumUsers;
        private int availableSpectatorSlots;
        private int numberOfDrivers;
        private int numberOfDriverSlots;
        private int numberOfSpectators;
        private int numberOfBroadcasters;
        private int numberOfSpectatorSlots;
        private int availableReservedBroadcasterSlots;
        private boolean canWatch;
        
        public BroadcastInfo() {}

        public boolean getCanBroadcast() {
            return canBroadcast;
        }

        public void setCanBroadcast(boolean canBroadcast) {
            this.canBroadcast = canBroadcast;
        }

        public long getSubSessionId() {
            return subSessionId;
        }

        public void setSubSessionId(long subSessionId) {
            this.subSessionId = subSessionId;
        }

        public boolean isBroadcaster() {
            return broadcaster;
        }

        public void setBroadcaster(boolean broadcaster) {
            this.broadcaster = broadcaster;
        }

        public int getMaximumUsers() {
            return maximumUsers;
        }

        public void setMaximumUsers(int maximumUsers) {
            this.maximumUsers = maximumUsers;
        }

        public int getAvailableSpectatorSlots() {
            return availableSpectatorSlots;
        }

        public void setAvailableSpectatorSlots(int availableSpectatorSlots) {
            this.availableSpectatorSlots = availableSpectatorSlots;
        }

        public int getNumberOfDrivers() {
            return numberOfDrivers;
        }

        public void setNumberOfDrivers(int numberOfDrivers) {
            this.numberOfDrivers = numberOfDrivers;
        }

        public int getNumberOfDriverSlots() {
            return numberOfDriverSlots;
        }

        public void setNumberOfDriverSlots(int numberOfDriverSlots) {
            this.numberOfDriverSlots = numberOfDriverSlots;
        }

        public int getNumberOfSpectators() {
            return numberOfSpectators;
        }

        public void setNumberOfSpectators(int numberOfSpectators) {
            this.numberOfSpectators = numberOfSpectators;
        }

        public int getNumberOfBroadcasters() {
            return numberOfBroadcasters;
        }

        public void setNumberOfBroadcasters(int numberOfBroadcasters) {
            this.numberOfBroadcasters = numberOfBroadcasters;
        }

        public int getNumberOfSpectatorSlots() {
            return numberOfSpectatorSlots;
        }

        public void setNumberOfSpectatorSlots(int numberOfSpectatorSlots) {
            this.numberOfSpectatorSlots = numberOfSpectatorSlots;
        }

        public int getAvailableReservedBroadcasterSlots() {
            return availableReservedBroadcasterSlots;
        }

        public void setAvailableReservedBroadcasterSlots(int availableReservedBroadcasterSlots) {
            this.availableReservedBroadcasterSlots = availableReservedBroadcasterSlots;
        }

        public boolean getCanWatch() {
            return canWatch;
        }

        public void setCanWatch(boolean canWatch) {
            this.canWatch = canWatch;
        }
        
    }
    
    public static class DriverInfo {
        
        private long customerId;
        private String name;
        
        public DriverInfo() {}

        public long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(long customerId) {
            this.customerId = customerId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }
    
    public static class HostedInfo {
        
        private int heatFilterAmount;
        private int heatGridType;
        private int heatGridsId;
        private int heatAddedDrivers;
        private int heatSessionType;
        private int heatFilterType;
        private boolean heatFinal;
        private int practiceLength;
        private List<DriverInfo> administrators;
        private long orderId;
        private int minimumIrating;
        private int maximumIrating;
        private int minimumLicenseLevel;
        private int maximumLicenseLevel;
        private long rootPrivateSessionId;
        private String description;
        private int fastTows;
        private int qualifyingLength;
        private int qualifyingLaps;
        private int raceLength;
        private boolean restrictResults;
        private boolean restrictViewing;
        private int hardcoreLevelId;
        private long id;
        private String hostName;
        private List<Integer> allowedClubs;
        private List<Long> allowedLeagues;
        private List<Long> allowedTeams;
        private int raceLaps;
        private int numberOfServers;
        private int numberOfServersStarted;
        private int numberOfServersFinished;
        private long customerId;
        private Date expires;
        private boolean multiClass;
        private String sessionName;
        private List<Integer> cars;
        private String reason;
        private int trackId;
        private Date launchAt;
        private int maximumDrivers;
        private long sessionId;
        private long parentPrivateSessionId;
        private boolean nightMode;
        private Date created;
        private boolean cautions;
        private boolean fixedSetup;
        private int restartType;
        private int timeLimit;
        private boolean passwordProtected;
        private int farmId;
        private int status;
        private boolean loneQualifying;
        private boolean rollingStart;
        private List<Integer> maximumPercentageFuelFills;
        
        public HostedInfo() {}

        public int getHeatFilterAmount() {
            return heatFilterAmount;
        }

        public void setHeatFilterAmount(int heatFilterAmount) {
            this.heatFilterAmount = heatFilterAmount;
        }

        public int getHeatGridType() {
            return heatGridType;
        }

        public void setHeatGridType(int heatGridType) {
            this.heatGridType = heatGridType;
        }

        public int getHeatGridsId() {
            return heatGridsId;
        }

        public void setHeatGridsId(int heatGridsId) {
            this.heatGridsId = heatGridsId;
        }

        public int getHeatAddedDrivers() {
            return heatAddedDrivers;
        }

        public void setHeatAddedDrivers(int heatAddedDrivers) {
            this.heatAddedDrivers = heatAddedDrivers;
        }

        public int getHeatSessionType() {
            return heatSessionType;
        }

        public void setHeatSessionType(int heatSessionType) {
            this.heatSessionType = heatSessionType;
        }

        public int getHeatFilterType() {
            return heatFilterType;
        }

        public void setHeatFilterType(int heatFilterType) {
            this.heatFilterType = heatFilterType;
        }

        public boolean isHeatFinal() {
            return heatFinal;
        }

        public void setHeatFinal(boolean heatFinal) {
            this.heatFinal = heatFinal;
        }

        public int getPracticeLength() {
            return practiceLength;
        }

        public void setPracticeLength(int practiceLength) {
            this.practiceLength = practiceLength;
        }

        public List<DriverInfo> getAdministrators() {
            return administrators;
        }

        public void setAdministrators(List<DriverInfo> administrators) {
            this.administrators = administrators;
        }

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
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

        public long getRootPrivateSessionId() {
            return rootPrivateSessionId;
        }

        public void setRootPrivateSessionId(long rootPrivateSessionId) {
            this.rootPrivateSessionId = rootPrivateSessionId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getFastTows() {
            return fastTows;
        }

        public void setFastTows(int fastTows) {
            this.fastTows = fastTows;
        }

        public int getQualifyingLength() {
            return qualifyingLength;
        }

        public void setQualifyingLength(int qualifyingLength) {
            this.qualifyingLength = qualifyingLength;
        }

        public int getQualifyingLaps() {
            return qualifyingLaps;
        }

        public void setQualifyingLaps(int qualifyingLaps) {
            this.qualifyingLaps = qualifyingLaps;
        }

        public int getRaceLength() {
            return raceLength;
        }

        public void setRaceLength(int raceLength) {
            this.raceLength = raceLength;
        }

        public boolean getRestrictResults() {
            return restrictResults;
        }

        public void setRestrictResults(boolean restrictResults) {
            this.restrictResults = restrictResults;
        }

        public boolean getRestrictViewing() {
            return restrictViewing;
        }

        public void setRestrictViewing(boolean restrictViewing) {
            this.restrictViewing = restrictViewing;
        }

        public int getHardcoreLevelId() {
            return hardcoreLevelId;
        }

        public void setHardcoreLevelId(int hardcoreLevelId) {
            this.hardcoreLevelId = hardcoreLevelId;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getHostName() {
            return hostName;
        }

        public void setHostName(String hostName) {
            this.hostName = hostName;
        }

        public List<Integer> getAllowedClubs() {
            return allowedClubs;
        }

        public void setAllowedClubs(List<Integer> allowedClubs) {
            this.allowedClubs = allowedClubs;
        }

        public List<Long> getAllowedLeagues() {
            return allowedLeagues;
        }

        public void setAllowedLeagues(List<Long> allowedLeagues) {
            this.allowedLeagues = allowedLeagues;
        }

        public List<Long> getAllowedTeams() {
            return allowedTeams;
        }

        public void setAllowedTeams(List<Long> allowedTeams) {
            this.allowedTeams = allowedTeams;
        }

        public int getRaceLaps() {
            return raceLaps;
        }

        public void setRaceLaps(int raceLaps) {
            this.raceLaps = raceLaps;
        }

        public int getNumberOfServers() {
            return numberOfServers;
        }

        public void setNumberOfServers(int numberOfServers) {
            this.numberOfServers = numberOfServers;
        }

        public int getNumberOfServersStarted() {
            return numberOfServersStarted;
        }

        public void setNumberOfServersStarted(int numberOfServersStarted) {
            this.numberOfServersStarted = numberOfServersStarted;
        }

        public int getNumberOfServersFinished() {
            return numberOfServersFinished;
        }

        public void setNumberOfServersFinished(int numberOfServersFinished) {
            this.numberOfServersFinished = numberOfServersFinished;
        }

        public long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(long customerId) {
            this.customerId = customerId;
        }

        public Date getExpires() {
            return expires;
        }

        public void setExpires(Date expires) {
            this.expires = expires;
        }

        public boolean isMultiClass() {
            return multiClass;
        }

        public void setMultiClass(boolean multiClass) {
            this.multiClass = multiClass;
        }

        public String getSessionName() {
            return sessionName;
        }

        public void setSessionName(String sessionName) {
            this.sessionName = sessionName;
        }

        public List<Integer> getCars() {
            return cars;
        }

        public void setCars(List<Integer> cars) {
            this.cars = cars;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public int getTrackId() {
            return trackId;
        }

        public void setTrackId(int trackId) {
            this.trackId = trackId;
        }

        public Date getLaunchAt() {
            return launchAt;
        }

        public void setLaunchAt(Date launchAt) {
            this.launchAt = launchAt;
        }

        public int getMaximumDrivers() {
            return maximumDrivers;
        }

        public void setMaximumDrivers(int maximumDrivers) {
            this.maximumDrivers = maximumDrivers;
        }

        public long getSessionId() {
            return sessionId;
        }

        public void setSessionId(long sessionId) {
            this.sessionId = sessionId;
        }

        public long getParentPrivateSessionId() {
            return parentPrivateSessionId;
        }

        public void setParentPrivateSessionId(long parentPrivateSessionId) {
            this.parentPrivateSessionId = parentPrivateSessionId;
        }

        public boolean isNightMode() {
            return nightMode;
        }

        public void setNightMode(boolean nightMode) {
            this.nightMode = nightMode;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        public boolean getCautions() {
            return cautions;
        }

        public void setCautions(boolean cautions) {
            this.cautions = cautions;
        }

        public boolean isFixedSetup() {
            return fixedSetup;
        }

        public void setFixedSetup(boolean fixedSetup) {
            this.fixedSetup = fixedSetup;
        }

        public int getRestartType() {
            return restartType;
        }

        public void setRestartType(int restartType) {
            this.restartType = restartType;
        }

        public int getTimeLimit() {
            return timeLimit;
        }

        public void setTimeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        public boolean isPasswordProtected() {
            return passwordProtected;
        }

        public void setPasswordProtected(boolean passwordProtected) {
            this.passwordProtected = passwordProtected;
        }

        public int getFarmId() {
            return farmId;
        }

        public void setFarmId(int farmId) {
            this.farmId = farmId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isLoneQualifying() {
            return loneQualifying;
        }

        public void setLoneQualifying(boolean loneQualifying) {
            this.loneQualifying = loneQualifying;
        }

        public boolean isRollingStart() {
            return rollingStart;
        }

        public void setRollingStart(boolean rollingStart) {
            this.rollingStart = rollingStart;
        }

        public List<Integer> getMaximumPercentageFuelFills() {
            return maximumPercentageFuelFills;
        }

        public void setMaximumPercentageFuelFills(List<Integer> maximumPercentageFuelFills) {
            this.maximumPercentageFuelFills = maximumPercentageFuelFills;
        }
        
    }
    
    private String subSessionStatus;
    private String sessionStatus;
    private BroadcastInfo broadcastInfo;
    private HostedInfo hostedInfo;
    private long subSessionId;
    private long sessionId;
    private int seriesId;
    private int seasonId;
    private int trackId;
    private Date startTime;
    private int eventTypeId;
    private long privateSessionId;
    
    public SpectatorSession() {}
    
    public String getSubSessionStatus() {
        return subSessionStatus;
    }

    public void setSubSessionStatus(String subSessionStatus) {
        this.subSessionStatus = subSessionStatus;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public BroadcastInfo getBroadcastInfo() {
        return broadcastInfo;
    }

    public void setBroadcastInfo(BroadcastInfo broadcastInfo) {
        this.broadcastInfo = broadcastInfo;
    }

    public HostedInfo getHostedInfo() {
        return hostedInfo;
    }

    public void setHostedInfo(HostedInfo hostedInfo) {
        this.hostedInfo = hostedInfo;
    }

    public long getSubSessionId() {
        return subSessionId;
    }

    public void setSubSessionId(long subSessionId) {
        this.subSessionId = subSessionId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public long getPrivateSessionId() {
        return privateSessionId;
    }

    public void setPrivateSessionId(long privateSessionId) {
        this.privateSessionId = privateSessionId;
    }
    
}