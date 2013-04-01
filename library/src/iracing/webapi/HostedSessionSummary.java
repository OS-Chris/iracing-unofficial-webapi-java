package iracing.webapi;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class HostedSessionSummary {
    
    public IracingCustomer host;
    private boolean apiUserIsHost;
    private int hardcoreLevel;
    private boolean nightMode;
    private boolean fullCourseCautions;
    private boolean rollingStarts;
    private boolean multiclass;
    private boolean fixedSetup;
    private boolean hasGrid;
    private boolean inGrid;
    private int qualifyingLaps;
    private int qualifyingType; // TODO: change to an enum
    private int practiceDuration; // minutes
    private int pitsInUse;
    private int carsLeft;
    private long subSessionId;
    private String rootPrivateSessionId;
    private long privateSessionId;
    private int timeLimit; // minutes
    private int licenseLevel;
    private int minimumLicenseLevel;
    private int maximumLecenseLevel;
    private List<Integer> maximumFuelFillPercentages;
    private boolean hasEntry;
    private String rootPrivateSessionName;
    private String sessionName;
    private Date launchAt;
    private Date registrationExpires;
    private String sessionDescription;
    private int restarts;
    private int numberOfServers;
    private int numberOfServersStarted;
    private int numberOfServersFinished;
    private int qualifyingDuration;
    private List<Long> adminCustomerIds;
    private String farmDisplayName;
    private String farmImagePath;
    private List<Integer> carIds;
    private int maximumDrivers;
    private int trackId;
    private String trackName;
    private String trackConfigName;
    private List<Long> allowedEntities;
    private String heatAddedDrivers;
    private String heatGridType;
    private String heatGridsId;
    private String heatFilterType;
    private String heatFilterAmount;
    private String heatSessionType;
    private int heatRaceServerIndex;
    private boolean passwordProtected;
    private int qualifyingLength; // minutes ???
    private int numberOfFastTows;
    private List<Long> qualifyingSetupIds;
    private List<String> qualifyingSetupFilenames;
    private List<Long> raceSetupIds;
    private List<String> raceSetupFilenames;
    //"registered":""
//    private String registered;
    private int raceLaps;
    private int raceDuration; // minutes ???
    private int raceLength; // ???
    private long leagueId;
    private long leagueSeasonId;
    private int minimumIrating;
    private int maximumIrating;
    //"password":""
//    private String password;
    private boolean restrictResults;
    private boolean restrictViewing;
    
    public HostedSessionSummary() {}

    public IracingCustomer getHost() {
        return host;
    }

    public void setHost(IracingCustomer host) {
        this.host = host;
    }

    public boolean isApiUserIsHost() {
        return apiUserIsHost;
    }

    public void setApiUserIsHost(boolean apiUserIsHost) {
        this.apiUserIsHost = apiUserIsHost;
    }

    public int getHardcoreLevel() {
        return hardcoreLevel;
    }

    public void setHardcoreLevel(int hardcoreLevel) {
        this.hardcoreLevel = hardcoreLevel;
    }

    public boolean isNightMode() {
        return nightMode;
    }

    public void setNightMode(boolean nightMode) {
        this.nightMode = nightMode;
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

    public boolean isMulticlass() {
        return multiclass;
    }

    public void setMulticlass(boolean multiclass) {
        this.multiclass = multiclass;
    }

    public boolean isFixedSetup() {
        return fixedSetup;
    }

    public void setFixedSetup(boolean fixedSetup) {
        this.fixedSetup = fixedSetup;
    }

    public boolean isHasGrid() {
        return hasGrid;
    }

    public void setHasGrid(boolean hasGrid) {
        this.hasGrid = hasGrid;
    }

    public boolean isInGrid() {
        return inGrid;
    }

    public void setInGrid(boolean inGrid) {
        this.inGrid = inGrid;
    }

    public int getQualifyingLaps() {
        return qualifyingLaps;
    }

    public void setQualifyingLaps(int qualifyingLaps) {
        this.qualifyingLaps = qualifyingLaps;
    }

    public int getQualifyingType() {
        return qualifyingType;
    }

    public void setQualifyingType(int qualifyingType) {
        this.qualifyingType = qualifyingType;
    }

    public int getPracticeDuration() {
        return practiceDuration;
    }

    public void setPracticeDuration(int practiceDuration) {
        this.practiceDuration = practiceDuration;
    }

    public int getPitsInUse() {
        return pitsInUse;
    }

    public void setPitsInUse(int pitsInUse) {
        this.pitsInUse = pitsInUse;
    }

    public int getCarsLeft() {
        return carsLeft;
    }

    public void setCarsLeft(int carsLeft) {
        this.carsLeft = carsLeft;
    }

    public long getSubSessionId() {
        return subSessionId;
    }

    public void setSubSessionId(long subSessionId) {
        this.subSessionId = subSessionId;
    }

    public String getRootPrivateSessionId() {
        return rootPrivateSessionId;
    }

    public void setRootPrivateSessionId(String rootPrivateSessionId) {
        this.rootPrivateSessionId = rootPrivateSessionId;
    }

    public long getPrivateSessionId() {
        return privateSessionId;
    }

    public void setPrivateSessionId(long privateSessionId) {
        this.privateSessionId = privateSessionId;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getLicenseLevel() {
        return licenseLevel;
    }

    public void setLicenseLevel(int licenseLevel) {
        this.licenseLevel = licenseLevel;
    }

    public int getMinimumLicenseLevel() {
        return minimumLicenseLevel;
    }

    public void setMinimumLicenseLevel(int minimumLicenseLevel) {
        this.minimumLicenseLevel = minimumLicenseLevel;
    }

    public int getMaximumLecenseLevel() {
        return maximumLecenseLevel;
    }

    public void setMaximumLecenseLevel(int maximumLecenseLevel) {
        this.maximumLecenseLevel = maximumLecenseLevel;
    }

    public List<Integer> getMaximumFuelFillPercentages() {
        return maximumFuelFillPercentages;
    }

    public void setMaximumFuelFillPercentages(List<Integer> maximumFuelFillPercentages) {
        this.maximumFuelFillPercentages = maximumFuelFillPercentages;
    }

    public boolean isHasEntry() {
        return hasEntry;
    }

    public void setHasEntry(boolean hasEntry) {
        this.hasEntry = hasEntry;
    }

    public String getRootPrivateSessionName() {
        return rootPrivateSessionName;
    }

    public void setRootPrivateSessionName(String rootPrivateSessionName) {
        this.rootPrivateSessionName = rootPrivateSessionName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Date getLaunchAt() {
        return launchAt;
    }

    public void setLaunchAt(Date launchAt) {
        this.launchAt = launchAt;
    }

    public Date getRegistrationExpires() {
        return registrationExpires;
    }

    public void setRegistrationExpires(Date registrationExpires) {
        this.registrationExpires = registrationExpires;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public int getRestarts() {
        return restarts;
    }

    public void setRestarts(int restarts) {
        this.restarts = restarts;
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

    public int getQualifyingDuration() {
        return qualifyingDuration;
    }

    public void setQualifyingDuration(int qualifyingDuration) {
        this.qualifyingDuration = qualifyingDuration;
    }

    public List<Long> getAdminCustomerIds() {
        return adminCustomerIds;
    }

    public void setAdminCustomerIds(List<Long> adminCustomerIds) {
        this.adminCustomerIds = adminCustomerIds;
    }

    public String getFarmDisplayName() {
        return farmDisplayName;
    }

    public void setFarmDisplayName(String farmDisplayName) {
        this.farmDisplayName = farmDisplayName;
    }

    public String getFarmImagePath() {
        return farmImagePath;
    }

    public void setFarmImagePath(String farmImagePath) {
        this.farmImagePath = farmImagePath;
    }

    public List<Integer> getCarIds() {
        return carIds;
    }

    public void setCarIds(List<Integer> carIds) {
        this.carIds = carIds;
    }

    public int getMaximumDrivers() {
        return maximumDrivers;
    }

    public void setMaximumDrivers(int maximumDrivers) {
        this.maximumDrivers = maximumDrivers;
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

    public List<Long> getAllowedEntities() {
        return allowedEntities;
    }

    public void setAllowedEntities(List<Long> allowedEntities) {
        this.allowedEntities = allowedEntities;
    }

    public String getHeatAddedDrivers() {
        return heatAddedDrivers;
    }

    public void setHeatAddedDrivers(String heatAddedDrivers) {
        this.heatAddedDrivers = heatAddedDrivers;
    }

    public String getHeatGridType() {
        return heatGridType;
    }

    public void setHeatGridType(String heatGridType) {
        this.heatGridType = heatGridType;
    }

    public String getHeatGridsId() {
        return heatGridsId;
    }

    public void setHeatGridsId(String heatGridsId) {
        this.heatGridsId = heatGridsId;
    }

    public String getHeatFilterType() {
        return heatFilterType;
    }

    public void setHeatFilterType(String heatFilterType) {
        this.heatFilterType = heatFilterType;
    }

    public String getHeatFilterAmount() {
        return heatFilterAmount;
    }

    public void setHeatFilterAmount(String heatFilterAmount) {
        this.heatFilterAmount = heatFilterAmount;
    }

    public String getHeatSessionType() {
        return heatSessionType;
    }

    public void setHeatSessionType(String heatSessionType) {
        this.heatSessionType = heatSessionType;
    }

    public int getHeatRaceServerIndex() {
        return heatRaceServerIndex;
    }

    public void setHeatRaceServerIndex(int heatRaceServerIndex) {
        this.heatRaceServerIndex = heatRaceServerIndex;
    }

    public boolean isPasswordProtected() {
        return passwordProtected;
    }

    public void setPasswordProtected(boolean passwordProtected) {
        this.passwordProtected = passwordProtected;
    }

    public int getQualifyingLength() {
        return qualifyingLength;
    }

    public void setQualifyingLength(int qualifyingLength) {
        this.qualifyingLength = qualifyingLength;
    }

    public int getNumberOfFastTows() {
        return numberOfFastTows;
    }

    public void setNumberOfFastTows(int numberOfFastTows) {
        this.numberOfFastTows = numberOfFastTows;
    }

    public List<Long> getQualifyingSetupIds() {
        return qualifyingSetupIds;
    }

    public void setQualifyingSetupIds(List<Long> qualifyingSetupIds) {
        this.qualifyingSetupIds = qualifyingSetupIds;
    }

    public List<String> getQualifyingSetupFilenames() {
        return qualifyingSetupFilenames;
    }

    public void setQualifyingSetupFilenames(List<String> qualifyingSetupFilenames) {
        this.qualifyingSetupFilenames = qualifyingSetupFilenames;
    }

    public List<Long> getRaceSetupIds() {
        return raceSetupIds;
    }

    public void setRaceSetupIds(List<Long> raceSetupIds) {
        this.raceSetupIds = raceSetupIds;
    }

    public List<String> getRaceSetupFilenames() {
        return raceSetupFilenames;
    }

    public void setRaceSetupFilenames(List<String> raceSetupFilenames) {
        this.raceSetupFilenames = raceSetupFilenames;
    }

//    public String getRegistered() {
//        return registered;
//    }
//
//    public void setRegistered(String registered) {
//        this.registered = registered;
//    }

    public int getRaceLaps() {
        return raceLaps;
    }

    public void setRaceLaps(int raceLaps) {
        this.raceLaps = raceLaps;
    }

    public int getRaceDuration() {
        return raceDuration;
    }

    public void setRaceDuration(int raceDuration) {
        this.raceDuration = raceDuration;
    }

    public int getRaceLength() {
        return raceLength;
    }

    public void setRaceLength(int raceLength) {
        this.raceLength = raceLength;
    }

    public long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(long leagueId) {
        this.leagueId = leagueId;
    }

    public long getLeagueSeasonId() {
        return leagueSeasonId;
    }

    public void setLeagueSeasonId(long leagueSeasonId) {
        this.leagueSeasonId = leagueSeasonId;
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

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public boolean isRestrictResults() {
        return restrictResults;
    }

    public void setRestrictResults(boolean restrictResults) {
        this.restrictResults = restrictResults;
    }

    public boolean isRestrictViewing() {
        return restrictViewing;
    }

    public void setRestrictViewing(boolean restrictViewing) {
        this.restrictViewing = restrictViewing;
    }
    
}