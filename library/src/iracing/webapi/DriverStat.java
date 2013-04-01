package iracing.webapi;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class DriverStat {
    
    public static class SearchParameters {
        
        private UserFilter userFilter = UserFilter.ALL_USERS;
//        private boolean limitToApiUserFriends;
//        private boolean limitToApiUserStudied;
        private long customerId;
        private boolean activeDriversOnly;
        private int averageStartingPositionLow;
        private int averageStartingPositionHigh;
        private int averageFinishingPositionLow;
        private int averageFinishingPositionHigh;
        private double averageIncidentsLow = -1;
        private double averageIncidentsHigh = -1;
        private int averagePointsHigh = -1;
        private int averagePointsLow = -1;
        private int categoryId = 1;
        private int classLow = -1;
        private int classHigh = -1;
        private int iratingLow = -1;
        private int iratingHigh = -1;
        private int timeTrialRatingLow = -1;
        private int timeTrialRatingHigh = -1;
        private long start = 1;
        private long end = 25;
        private String countryCode;
        private SortField sortField = SortField.IRATING;
        private SortOrder sortOrder = SortOrder.DESCENDING;
        
        public SearchParameters() {}

        public UserFilter getUserFilter() {
            return userFilter;
        }

        public void setUserFilter(UserFilter userFilter) {
            this.userFilter = userFilter;
        }

        public long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(long customerId) {
            this.customerId = customerId;
        }

        public boolean isActiveDriversOnly() {
            return activeDriversOnly;
        }

        public void setActiveDriversOnly(boolean activeDriversOnly) {
            this.activeDriversOnly = activeDriversOnly;
        }

        public int getAverageStartingPositionLow() {
            return averageStartingPositionLow;
        }

        public void setAverageStartingPositionLow(int averageStartingPositionLow) {
            this.averageStartingPositionLow = averageStartingPositionLow;
        }

        public int getAverageStartingPositionHigh() {
            return averageStartingPositionHigh;
        }

        public void setAverageStartingPositionHigh(int averageStartingPositionHigh) {
            this.averageStartingPositionHigh = averageStartingPositionHigh;
        }

        public int getAverageFinishingPositionLow() {
            return averageFinishingPositionLow;
        }

        public void setAverageFinishingPositionLow(int averageFinishingPositionLow) {
            this.averageFinishingPositionLow = averageFinishingPositionLow;
        }

        public int getAverageFinishingPositionHigh() {
            return averageFinishingPositionHigh;
        }

        public void setAverageFinishingPositionHigh(int averageFinishingPositionHigh) {
            this.averageFinishingPositionHigh = averageFinishingPositionHigh;
        }

        public double getAverageIncidentsLow() {
            return averageIncidentsLow;
        }

        public void setAverageIncidentsLow(double averageIncidentsLow) {
            this.averageIncidentsLow = averageIncidentsLow;
        }

        public double getAverageIncidentsHigh() {
            return averageIncidentsHigh;
        }

        public void setAverageIncidentsHigh(double averageIncidentsHigh) {
            this.averageIncidentsHigh = averageIncidentsHigh;
        }

        public int getAveragePointsHigh() {
            return averagePointsHigh;
        }

        public void setAveragePointsHigh(int averagePointsHigh) {
            this.averagePointsHigh = averagePointsHigh;
        }

        public int getAveragePointsLow() {
            return averagePointsLow;
        }

        public void setAveragePointsLow(int averagePointsLow) {
            this.averagePointsLow = averagePointsLow;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getClassLow() {
            return classLow;
        }

        public void setClassLow(int classLow) {
            this.classLow = classLow;
        }

        public int getClassHigh() {
            return classHigh;
        }

        public void setClassHigh(int classHigh) {
            this.classHigh = classHigh;
        }

        public int getIratingLow() {
            return iratingLow;
        }

        public void setIratingLow(int iratingLow) {
            this.iratingLow = iratingLow;
        }

        public int getIratingHigh() {
            return iratingHigh;
        }

        public void setIratingHigh(int iratingHigh) {
            this.iratingHigh = iratingHigh;
        }

        public int getTimeTrialRatingLow() {
            return timeTrialRatingLow;
        }

        public void setTimeTrialRatingLow(int timeTrialRatingLow) {
            this.timeTrialRatingLow = timeTrialRatingLow;
        }

        public int getTimeTrialRatingHigh() {
            return timeTrialRatingHigh;
        }

        public void setTimeTrialRatingHigh(int timeTrialRatingHigh) {
            this.timeTrialRatingHigh = timeTrialRatingHigh;
        }

        public long getStart() {
            return start;
        }

        public void setStart(long start) {
            this.start = start;
        }

        public long getEnd() {
            return end;
        }

        public void setEnd(long end) {
            this.end = end;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
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
            output.put("search", "null");
            output.put("recent", "-1");
            if (userFilter == UserFilter.ALL_USERS) {
                output.put("friend", "-1");
                output.put("watched", "-1");
            } else if (userFilter == UserFilter.FRIENDS) {
                output.put("friend", "1");
                output.put("watched", "-1");
            } else if (userFilter == UserFilter.STUDIED) {
                output.put("friend", "-1");
                output.put("watched", "1");
            }
            output.put("lowerbound", String.valueOf(start));
            output.put("upperbound", String.valueOf(end));
            output.put("category", String.valueOf(categoryId));
            output.put("active", (activeDriversOnly ? "1" : "0"));
            output.put("classlow", String.valueOf(classLow));
            output.put("classhigh", String.valueOf(classHigh));
            if (countryCode != null) output.put("country", countryCode);
            if (customerId > 0) output.put("custid", String.valueOf(customerId));
            if (averageStartingPositionLow > 0) output.put("avgstartlow", String.valueOf(averageStartingPositionLow));
            if (averageStartingPositionHigh > 0) output.put("avgstarthigh", String.valueOf(averageStartingPositionHigh));
            if (averageFinishingPositionLow > 0) output.put("avgfinishlow", String.valueOf(averageFinishingPositionLow));
            if (averageFinishingPositionHigh > 0) output.put("avgfinishhigh", String.valueOf(averageFinishingPositionHigh));
            if (averagePointsLow > -1) output.put("avgpointslow", String.valueOf(averagePointsLow));
            if (averagePointsHigh > -1) output.put("avgpointshigh", String.valueOf(averagePointsHigh));
            if (averageIncidentsLow > -1) output.put("avgincidentslow", String.valueOf(averageIncidentsLow));
            if (averageIncidentsHigh > -1) output.put("avgincidentshigh", String.valueOf(averageIncidentsHigh));
            if (iratingLow > -1) output.put("iratinglow", String.valueOf(iratingLow));
            if (iratingHigh > -1) output.put("iratinghigh", String.valueOf(iratingHigh));
            if (timeTrialRatingLow > -1) output.put("ttratinglow", String.valueOf(timeTrialRatingLow));
            if (timeTrialRatingHigh > -1) output.put("ttratinghigh", String.valueOf(timeTrialRatingHigh));
            if (sortField == SortField.DRIVER_NAME) {
                output.put("sort", "displayname");
            } else if (sortField == SortField.COUNTRY) {
                output.put("sort", "countrycode");
            } else if (sortField == SortField.CLUB_NAME) {
                output.put("sort", "clubname");
            } else if (sortField == SortField.TOTAL_STARTS) {
                output.put("sort", "starts");
            } else if (sortField == SortField.TOTAL_WINS) {
                output.put("sort", "wins");
            } else if (sortField == SortField.AVERAGE_STARTING_POSITION) {
                output.put("sort", "avgstartingposition");
            } else if (sortField == SortField.AVERAGE_FINISHING_POSITION) {
                output.put("sort", "avgfinishingposition");
            } else if (sortField == SortField.AVERAGE_POINTS_PER_RACE) {
                output.put("sort", "avgpoints");
            } else if (sortField == SortField.TOP_25_PERCENT_FINISHES) {
                output.put("sort", "top25pcnt");
            } else if (sortField == SortField.TOTAL_LAPS) {
                output.put("sort", "laps");
            } else if (sortField == SortField.TOTAL_LAPS_LED) {
                output.put("sort", "lapslead");
            } else if (sortField == SortField.AVERAGE_INCIDENTS) {
                output.put("sort", "avgincidents");
            } else if (sortField == SortField.LICENSE_CLASS) {
                output.put("sort", "class");
            } else if (sortField == SortField.IRATING) {
                output.put("sort", "irating");
            } else if (sortField == SortField.TIME_TRIAL_RATING) {
                output.put("sort", "ttrating");
            } else if (sortField == SortField.TOTAL_CLUB_POINTS) {
                output.put("sort", "clubpoints");
            } else if (sortField == SortField.TOTAL_CHAMPIONSHIP_POINTS) {
                output.put("sort", "points");
            }
            output.put("order", (sortOrder == SortOrder.DESCENDING ? "desc" : "asc"));
            return output;
        }
    }
    
    public enum SortField {
        DRIVER_NAME,
        COUNTRY,
        CLUB_NAME,
        TOTAL_STARTS,
        TOTAL_WINS,
        AVERAGE_STARTING_POSITION,
        AVERAGE_FINISHING_POSITION,
        AVERAGE_POINTS_PER_RACE,
        TOP_25_PERCENT_FINISHES,
        TOTAL_LAPS,
        TOTAL_LAPS_LED,
        AVERAGE_INCIDENTS,
        LICENSE_CLASS,
        IRATING,
        TIME_TRIAL_RATING,
        TOTAL_CLUB_POINTS,
        TOTAL_CHAMPIONSHIP_POINTS
    }
    
    private int clubId;
    private String clubName;
    private String countryCode;
    private int licenseSubLevel;
    private long iratingRank;
    private int averageFinishingPosition;
    private int irating;
    private int licenseGroupId;
    private String licenseGroupName;
    private String licenseGroupLetter;
    private IracingCustomer driver;
    private long timeTrialRatingRank;
    private double averageIncidentsPerRace;
    private long totalTop25PercentFinishes;
    private long totalStarts;
    private long licenseClassRank;
    private long totalLapsLed;
    private long totalWins;
    private long totalClubPoints;
    private int timeTrialRating;
    private int licenseLevelId;
    private long totalChampionshipPoints;
    private int averageFieldSize;
    private long rank;
    private String regionName;
    private int averagePointsPerRace;
    private long totalLaps;
    private String licenseClass;
    private int averageStartingPosition;
    private long recordNumber;
    
    public DriverStat() {}
    
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getLicenseSubLevel() {
        return licenseSubLevel;
    }

    public void setLicenseSubLevel(int licenseSubLevel) {
        this.licenseSubLevel = licenseSubLevel;
    }

    public long getIratingRank() {
        return iratingRank;
    }

    public void setIratingRank(long iratingRank) {
        this.iratingRank = iratingRank;
    }

    public int getAverageFinishingPosition() {
        return averageFinishingPosition;
    }

    public void setAverageFinishingPosition(int averageFinishingPosition) {
        this.averageFinishingPosition = averageFinishingPosition;
    }

    public int getIrating() {
        return irating;
    }

    public void setIrating(int irating) {
        this.irating = irating;
    }

    public int getLicenseGroupId() {
        return licenseGroupId;
    }

    public void setLicenseGroupId(int licenseGroupId) {
        this.licenseGroupId = licenseGroupId;
    }

    public String getLicenseGroupName() {
        return licenseGroupName;
    }

    public void setLicenseGroupName(String licenseGroupName) {
        this.licenseGroupName = licenseGroupName;
    }

    public String getLicenseGroupLetter() {
        return licenseGroupLetter;
    }

    public void setLicenseGroupLetter(String licenseGroupLetter) {
        this.licenseGroupLetter = licenseGroupLetter;
    }

    public IracingCustomer getDriver() {
        return driver;
    }

    public void setDriver(IracingCustomer driver) {
        this.driver = driver;
    }

    public long getTimeTrialRatingRank() {
        return timeTrialRatingRank;
    }

    public void setTimeTrialRatingRank(long timeTrialRatingRank) {
        this.timeTrialRatingRank = timeTrialRatingRank;
    }

    public double getAverageIncidentsPerRace() {
        return averageIncidentsPerRace;
    }

    public void setAverageIncidentsPerRace(double averageIncidentsPerRace) {
        this.averageIncidentsPerRace = averageIncidentsPerRace;
    }

    public long getTotalTop25PercentFinishes() {
        return totalTop25PercentFinishes;
    }

    public void setTotalTop25PercentFinishes(long totalTop25PercentFinishes) {
        this.totalTop25PercentFinishes = totalTop25PercentFinishes;
    }

    public long getTotalStarts() {
        return totalStarts;
    }

    public void setTotalStarts(long totalStarts) {
        this.totalStarts = totalStarts;
    }

    public long getLicenseClassRank() {
        return licenseClassRank;
    }

    public void setLicenseClassRank(long licenseClassRank) {
        this.licenseClassRank = licenseClassRank;
    }

    public long getTotalLapsLed() {
        return totalLapsLed;
    }

    public void setTotalLapsLed(long totalLapsLed) {
        this.totalLapsLed = totalLapsLed;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    public long getTotalClubPoints() {
        return totalClubPoints;
    }

    public void setTotalClubPoints(long totalClubPoints) {
        this.totalClubPoints = totalClubPoints;
    }

    public int getTimeTrialRating() {
        return timeTrialRating;
    }

    public void setTimeTrialRating(int timeTrialRating) {
        this.timeTrialRating = timeTrialRating;
    }

    public int getLicenseLevelId() {
        return licenseLevelId;
    }

    public void setLicenseLevelId(int licenseLevelId) {
        this.licenseLevelId = licenseLevelId;
    }

    public long getTotalChampionshipPoints() {
        return totalChampionshipPoints;
    }

    public void setTotalChampionshipPoints(long totalChampionshipPoints) {
        this.totalChampionshipPoints = totalChampionshipPoints;
    }

    public int getAverageFieldSize() {
        return averageFieldSize;
    }

    public void setAverageFieldSize(int averageFieldSize) {
        this.averageFieldSize = averageFieldSize;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getAveragePointsPerRace() {
        return averagePointsPerRace;
    }

    public void setAveragePointsPerRace(int averagePointsPerRace) {
        this.averagePointsPerRace = averagePointsPerRace;
    }

    public long getTotalLaps() {
        return totalLaps;
    }

    public void setTotalLaps(long totalLaps) {
        this.totalLaps = totalLaps;
    }

    public String getLicenseClass() {
        return licenseClass;
    }

    public void setLicenseClass(String licenseClass) {
        this.licenseClass = licenseClass;
    }

    public int getAverageStartingPosition() {
        return averageStartingPosition;
    }

    public void setAverageStartingPosition(int averageStartingPosition) {
        this.averageStartingPosition = averageStartingPosition;
    }

    public long getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(long recordNumber) {
        this.recordNumber = recordNumber;
    }
    
}