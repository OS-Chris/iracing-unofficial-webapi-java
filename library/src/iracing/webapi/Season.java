package iracing.webapi;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class Season {
    
    public static class Track {
        
        //{"config":"","priority":0,"raceweek":0,"pkgid":90,"night":0,"name":"Mosport+International+Raceway","id":144,"lowername":"mosport+international+raceway"}
        private int id;
        private boolean nightMode;
        private int raceWeek;
        
        public Track() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isNightMode() {
            return nightMode;
        }

        public void setNightMode(boolean nightMode) {
            this.nightMode = nightMode;
        }

        public int getRaceWeek() {
            return raceWeek;
        }

        public void setRaceWeek(int raceWeek) {
            this.raceWeek = raceWeek;
        }

    }
    
    private int id;
    private String prefImage;
    private String seriesName;
    private String seriesShortName;
    private String seasonShortName;
    private String whatsHotImage;
    private int cautionTypeRoad;
    private int raceWeeks;
    private boolean active;
    private int minimumLicenseLevel;
    private int maximumLicenseLevel;
    private List<Season.Track> tracks;
    private boolean apiUserClubAllowed;
    private boolean apiUserLicenseEligible;
    private int seriesLicenseGroupId;
    private List<Integer> carClasses;
    private int currentTrack;
    private int seriesId;
    private int licenseGroupId;
    private boolean licenseIgnoredForPractice;
    private boolean worldCupEvent;
    private Date startDate;
    private Date endDate;
    private List<Integer> cars;
    private boolean multiClass;
    private boolean regionalCompetitionEvent;
    private int year;
    private int quarter;
    private int categoryId;
    private String minimumSafetyRating;
    private boolean official;
    private boolean complete;
    private int cautionTypeOval;
    
    public Season() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefImage() {
        return prefImage;
    }

    public void setPrefImage(String prefImage) {
        this.prefImage = prefImage;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesShortName() {
        return seriesShortName;
    }

    public void setSeriesShortName(String seriesShortName) {
        this.seriesShortName = seriesShortName;
    }

    public String getSeasonShortName() {
        return seasonShortName;
    }

    public void setSeasonShortName(String shortName) {
        this.seasonShortName = shortName;
    }

    public String getWhatsHotImage() {
        return whatsHotImage;
    }

    public void setWhatsHotImage(String whatsHotImage) {
        this.whatsHotImage = whatsHotImage;
    }

    public int getCautionTypeRoad() {
        return cautionTypeRoad;
    }

    public void setCautionTypeRoad(int cautionTypeRoad) {
        this.cautionTypeRoad = cautionTypeRoad;
    }

    public int getRaceWeeks() {
        return raceWeeks;
    }

    public void setRaceWeeks(int raceWeeks) {
        this.raceWeeks = raceWeeks;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMaximumLicenseLevel() {
        return maximumLicenseLevel;
    }

    public void setMaximumLicenseLevel(int maxLicenseLevel) {
        this.maximumLicenseLevel = maxLicenseLevel;
    }

    public List<Season.Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Season.Track> tracks) {
        this.tracks = tracks;
    }

    public int getMinimumLicenseLevel() {
        return minimumLicenseLevel;
    }

    public void setMinimumLicenseLevel(int minimumLicenseLevel) {
        this.minimumLicenseLevel = minimumLicenseLevel;
    }

    public boolean isApiUserClubAllowed() {
        return apiUserClubAllowed;
    }

    public void setApiUserClubAllowed(boolean isApiUserClubAllowed) {
        this.apiUserClubAllowed = isApiUserClubAllowed;
    }

    public boolean isApiUserLicenseEligible() {
        return apiUserLicenseEligible;
    }

    public void setApiUserLicenseEligible(boolean isApiUserLicenseEligible) {
        this.apiUserLicenseEligible = isApiUserLicenseEligible;
    }

    public int getSeriesLicenseGroupId() {
        return seriesLicenseGroupId;
    }

    public void setSeriesLicenseGroupId(int seriesLicenseGroupId) {
        this.seriesLicenseGroupId = seriesLicenseGroupId;
    }

    public List<Integer> getCarClasses() {
        return carClasses;
    }

    public void setCarClasses(List<Integer> carClasses) {
        this.carClasses = carClasses;
    }

    public int getCurrentTrack() {
        return currentTrack;
    }

    public void setCurrentTrack(int currentTrack) {
        this.currentTrack = currentTrack;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getLicenseGroupId() {
        return licenseGroupId;
    }

    public void setLicenseGroupId(int licenseGroupId) {
        this.licenseGroupId = licenseGroupId;
    }

    public boolean isLicenseIgnoredForPractice() {
        return licenseIgnoredForPractice;
    }

    public void setLicenseIgnoredForPractice(boolean licenseIgnoredForPractice) {
        this.licenseIgnoredForPractice = licenseIgnoredForPractice;
    }

    public boolean isWorldCupEvent() {
        return worldCupEvent;
    }

    public void setWorldCupEvent(boolean worldCupEvent) {
        this.worldCupEvent = worldCupEvent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Integer> getCars() {
        return cars;
    }

    public void setCars(List<Integer> cars) {
        this.cars = cars;
    }

    public boolean isMultiClass() {
        return multiClass;
    }

    public void setMultiClass(boolean multiClass) {
        this.multiClass = multiClass;
    }

    public boolean isRegionalCompetitionEvent() {
        return regionalCompetitionEvent;
    }

    public void setRegionalCompetitionEvent(boolean regionalCompetitionEvent) {
        this.regionalCompetitionEvent = regionalCompetitionEvent;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getMinimumSafetyRating() {
        return minimumSafetyRating;
    }

    public void setMinimumSafetyRating(String minimumSafetyRating) {
        this.minimumSafetyRating = minimumSafetyRating;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getCautionTypeOval() {
        return cautionTypeOval;
    }

    public void setCautionTypeOval(int cautionTypeOval) {
        this.cautionTypeOval = cautionTypeOval;
    }
    
}