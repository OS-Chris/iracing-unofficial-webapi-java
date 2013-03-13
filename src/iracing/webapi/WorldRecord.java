package iracing.webapi;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class WorldRecord {
    
    public static class SearchParameters {
        
        private int carId;
        private int trackId;
        private int clubId;
        private String region;
        private String countryCode;
        private long customerId;
        private long start = 1;
        private long end = 25;
        private int seasonQuarter;
        private int seasonYear;
        private SortField sortField = SortField.PRACTICE_TIME;
        private SortOrder sortOrder = SortOrder.ASCENDING;
        
        public SearchParameters() {}
        
        public int getCarId() {
            return carId;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public int getTrackId() {
            return trackId;
        }

        public void setTrackId(int trackId) {
            this.trackId = trackId;
        }

        public int getClubId() {
            return clubId;
        }

        public void setClubId(int clubId) {
            this.clubId = clubId;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(long customerId) {
            this.customerId = customerId;
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

        public int getSeasonQuarter() {
            return seasonQuarter;
        }

        public void setSeasonQuarter(int seasonQuarter) {
            this.seasonQuarter = seasonQuarter;
        }

        public int getSeasonYear() {
            return seasonYear;
        }

        public void setSeasonYear(int seasonYear) {
            this.seasonYear = seasonYear;
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
            output.put("format", "json");
            if (customerId > 0) output.put("custid", String.valueOf(customerId));
            if (start > 0) output.put("lowerbound", String.valueOf(start));
            if (end > 0) output.put("upperbound", String.valueOf(end));
            output.put("carid", String.valueOf(carId));
            output.put("trackid", String.valueOf(trackId));
            if (clubId > 0) output.put("clubid", String.valueOf(clubId));
            if (countryCode != null) output.put("countrycode", countryCode);
            if (region != null) output.put("region", region);
            if (seasonQuarter > 0) output.put("seasonquarter", String.valueOf(seasonQuarter));
            if (seasonYear > 0) output.put("seasonyear", String.valueOf(seasonYear));
            if (sortField == SortField.PRACTICE_TIME) {
                output.put("sort", "practice");
            } else if (sortField == SortField.QUALIFY_TIME) {
                output.put("sort", "qualify");
            } else if (sortField == SortField.RACE_TIME) {
                output.put("sort", "race");
            } else if (sortField == SortField.TIME_TRIAL_TIME) {
                output.put("sort", "timetrial");
            } else if (sortField == SortField.DRIVER_NAME) {
                output.put("sort", "displayname");
            } else if (sortField == SortField.COUNTRY_CODE) {
                output.put("sort", "countrycode");
            } else if (sortField == SortField.REGION) {
                output.put("sort", "region");
            } else if (sortField == SortField.CLUB_NAME) {
                output.put("sort", "clubname");
            } else if (sortField == SortField.LICENSE_CLASS) {
                output.put("sort", "class");
            } else if (sortField == SortField.IRATING) {
                output.put("sort", "irating");
            } else if (sortField == SortField.TIME_TRIAL_RATING) {
                output.put("sort", "ttrating");
            }
            output.put("order", (sortOrder == SortOrder.ASCENDING ? "asc" : "desc"));
            return output;
        }

    }
    
    public enum SortField {
        DRIVER_NAME,
        COUNTRY_CODE,
        REGION,
        CLUB_NAME,
        PRACTICE_TIME,
        QUALIFY_TIME,
        RACE_TIME,
        TIME_TRIAL_TIME,
        LICENSE_CLASS,
        IRATING,
        TIME_TRIAL_RATING
    }
    
    private long recordNumber;
    private int clubId;
    private String clubName;
    private String countryCode;
    private int licenseSubLevel;
    private String licenseSubLevelText;
    private int irating;
    private long practiceSubSessionId;
    private Date practiceStartTime;
    private long qualifyingSubSessionId;
    private Date qualifyingStartTime;
    private long timeTrialSubSessionId;
    private Date timeTrialStartTime;
    private long raceSubSessionId;
    private Date raceStartTime;
    private String practice; // "" or "m:ss.sss"
    private String qualify; // "" or "m:ss.sss"
    private String race; // "" or "m:ss.sss"
    private String timeTrial; // "" or "m:ss.sss"
    private IracingCustomer driver;
    private int seasonQuarter;
    private int seasonYear;
    private int timeTrialRating;
    private int licenseGroupId;
    private int licenseLevelId;
    private int trackId;
    private int carId;
    private int categoryId;
    private String categoryName;
    private String regionName;
    
    public WorldRecord() {}

    public long getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(long recordNumber) {
        this.recordNumber = recordNumber;
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

    public String getLicenseSubLevelText() {
        return licenseSubLevelText;
    }

    public void setLicenseSubLevelText(String licenseSubLevelText) {
        this.licenseSubLevelText = licenseSubLevelText;
    }

    public int getIrating() {
        return irating;
    }

    public void setIrating(int irating) {
        this.irating = irating;
    }

    public long getPracticeSubSessionId() {
        return practiceSubSessionId;
    }

    public void setPracticeSubSessionId(long practiceSubSessionId) {
        this.practiceSubSessionId = practiceSubSessionId;
    }

    public Date getPracticeStartTime() {
        return practiceStartTime;
    }

    public void setPracticeStartTime(Date practiceStartTime) {
        this.practiceStartTime = practiceStartTime;
    }

    public long getQualifyingSubSessionId() {
        return qualifyingSubSessionId;
    }

    public void setQualifyingSubSessionId(long qualifyingSubSessionId) {
        this.qualifyingSubSessionId = qualifyingSubSessionId;
    }

    public Date getQualifyingStartTime() {
        return qualifyingStartTime;
    }

    public void setQualifyingStartTime(Date qualifyingStartTime) {
        this.qualifyingStartTime = qualifyingStartTime;
    }

    public long getTimeTrialSubSessionId() {
        return timeTrialSubSessionId;
    }

    public void setTimeTrialSubSessionId(long timeTrialSubSessionId) {
        this.timeTrialSubSessionId = timeTrialSubSessionId;
    }

    public Date getTimeTrialStartTime() {
        return timeTrialStartTime;
    }

    public void setTimeTrialStartTime(Date timeTrialStartTime) {
        this.timeTrialStartTime = timeTrialStartTime;
    }

    public long getRaceSubSessionId() {
        return raceSubSessionId;
    }

    public void setRaceSubSessionId(long raceSubSessionId) {
        this.raceSubSessionId = raceSubSessionId;
    }

    public Date getRaceStartTime() {
        return raceStartTime;
    }

    public void setRaceStartTime(Date raceStartTime) {
        this.raceStartTime = raceStartTime;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getQualify() {
        return qualify;
    }

    public void setQualify(String qualify) {
        this.qualify = qualify;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getTimeTrial() {
        return timeTrial;
    }

    public void setTimeTrial(String timeTrial) {
        this.timeTrial = timeTrial;
    }

    public IracingCustomer getDriver() {
        return driver;
    }

    public void setDriver(IracingCustomer driver) {
        this.driver = driver;
    }

    public int getSeasonQuarter() {
        return seasonQuarter;
    }

    public void setSeasonQuarter(int seasonQuarter) {
        this.seasonQuarter = seasonQuarter;
    }

    public int getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(int seasonYear) {
        this.seasonYear = seasonYear;
    }

    public int getTimeTrialRating() {
        return timeTrialRating;
    }

    public void setTimeTrialRating(int timeTrialRating) {
        this.timeTrialRating = timeTrialRating;
    }

    public int getLicenseGroupId() {
        return licenseGroupId;
    }

    public void setLicenseGroupId(int licenseGroupId) {
        this.licenseGroupId = licenseGroupId;
    }

    public int getLicenseLevelId() {
        return licenseLevelId;
    }

    public void setLicenseLevelId(int licenseLevelId) {
        this.licenseLevelId = licenseLevelId;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
}