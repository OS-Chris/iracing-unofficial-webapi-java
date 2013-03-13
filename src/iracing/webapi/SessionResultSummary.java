package iracing.webapi;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SessionResultSummary {

    public static class SearchParameters {
        
        //custid=29462&format=json&lowerbound=1&seasonquarter=2&seasonyear=2012&showclassa=1&showclassb=1&showclassc=1&showclassd=1&showofficial=1&showops=1&showpro=1&showprowc=1&showquals=1&showraces=1&showrookie=1&showtts=1&showunofficial=1&upperbound=25
        private long customerId;
        private int lowerBound = 1;
        private int upperBound = 25;
        private int seriesId = -1;
        private int seasonQuarter = 1;
        private int seasonYear = 2012;
        private int carClassId;
        private int carId;
        private int trackId;
        private int raceWeek;
        private boolean includeProWC = false;
        private boolean includePro = false;
        private boolean includeClassA = false;
        private boolean includeClassB = false;
        private boolean includeClassC = false;
        private boolean includeClassD = false;
        private boolean includeRookie = false;
        private boolean includeOfficialSessions = false;
        private boolean includeUnofficialSessions = false;
        private boolean includePractiseSessions = false;
        private boolean includeQualifyingSessions = false;
        private boolean includeRaceSessions = false;
        private boolean includeTimeTrialSessions = false;
        private Date startDate;
        private Date endDate;
        
        public SearchParameters() {}
        public SearchParameters(boolean includeAllLicenses, boolean includeAllSessions) {
            if (includeAllLicenses) includeAllLicenses();
            if (includeAllSessions) includeAllSessions();
        }

        public final void includeAllLicenses() {
            includeProWC = true;
            includePro = true;
            includeClassA = true;
            includeClassB = true;
            includeClassC = true;
            includeClassD = true;
            includeRookie = true;
        }
        
        public final void includeAllSessions() {
            includeOfficialSessions = true;
            includeUnofficialSessions = true;
            includePractiseSessions = true;
            includeQualifyingSessions = true;
            includeRaceSessions = true;
            includeTimeTrialSessions = true;
        }
        
        public long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(long customerId) {
            this.customerId = customerId;
        }

        public int getLowerBound() {
            return lowerBound;
        }

        public void setLowerBound(int lowerBound) {
            this.lowerBound = lowerBound;
        }

        public int getUpperBound() {
            return upperBound;
        }

        public void setUpperBound(int upperBound) {
            this.upperBound = upperBound;
        }

        public int getSeriesId() {
            return seriesId;
        }

        public void setSeriesId(int seriesId) {
            this.seriesId = seriesId;
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

        public int getCarClassId() {
            return carClassId;
        }

        public void setCarClassId(int carClassId) {
            this.carClassId = carClassId;
        }

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

        public int getRaceWeek() {
            return raceWeek;
        }

        public void setRaceWeek(int raceWeek) {
            this.raceWeek = raceWeek;
        }

        public boolean getIncludeProWC() {
            return includeProWC;
        }

        public void setIncludeProWC(boolean includeProWC) {
            this.includeProWC = includeProWC;
        }

        public boolean getIncludePro() {
            return includePro;
        }

        public void setIncludePro(boolean includePro) {
            this.includePro = includePro;
        }

        public boolean getIncludeClassA() {
            return includeClassA;
        }

        public void setIncludeClassA(boolean includeClassA) {
            this.includeClassA = includeClassA;
        }

        public boolean getIncludeClassB() {
            return includeClassB;
        }

        public void setIncludeClassB(boolean includeClassB) {
            this.includeClassB = includeClassB;
        }

        public boolean getIncludeClassC() {
            return includeClassC;
        }

        public void setIncludeClassC(boolean includeClassC) {
            this.includeClassC = includeClassC;
        }

        public boolean getIncludeClassD() {
            return includeClassD;
        }

        public void setIncludeClassD(boolean includeClassD) {
            this.includeClassD = includeClassD;
        }

        public boolean getIncludeRookie() {
            return includeRookie;
        }

        public void setIncludeRookie(boolean includeRookie) {
            this.includeRookie = includeRookie;
        }

        public boolean getIncludeOfficialSessions() {
            return includeOfficialSessions;
        }

        public void setIncludeOfficialSessions(boolean includeOfficialSessions) {
            this.includeOfficialSessions = includeOfficialSessions;
        }

        public boolean getIncludeUnofficialSessions() {
            return includeUnofficialSessions;
        }

        public void setIncludeUnofficialSessions(boolean includeUnofficialSessions) {
            this.includeUnofficialSessions = includeUnofficialSessions;
        }

        public boolean getIncludePractiseSessions() {
            return includePractiseSessions;
        }

        public void setIncludePractiseSessions(boolean includePractiseSessions) {
            this.includePractiseSessions = includePractiseSessions;
        }

        public boolean getIncludeQualifyingSessions() {
            return includeQualifyingSessions;
        }

        public void setIncludeQualifyingSessions(boolean includeQualifyingSessions) {
            this.includeQualifyingSessions = includeQualifyingSessions;
        }

        public boolean getIncludeRaceSessions() {
            return includeRaceSessions;
        }

        public void setIncludeRaceSessions(boolean includeRaceSessions) {
            this.includeRaceSessions = includeRaceSessions;
        }

        public boolean getIncludeTimeTrialSessions() {
            return includeTimeTrialSessions;
        }

        public void setIncludeTimeTrialSessions(boolean includeTimeTrialSessions) {
            this.includeTimeTrialSessions = includeTimeTrialSessions;
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
        
        public Map<String, String> toParameters() {
            Map<String, String> output = new HashMap<String, String>();
            output.put("custid", String.valueOf(customerId));
            output.put("format", "json");
            output.put("order", "desc");
            output.put("sort", "start_time");
            output.put("seriesid", String.valueOf(seriesId));
            output.put("lowerbound", String.valueOf(lowerBound));
            output.put("upperbound", String.valueOf(upperBound));
            if (carClassId > 0) output.put("carclassid", String.valueOf(carClassId));
            if (carId > 0) output.put("carid", String.valueOf(carId));
            if (trackId > 0) output.put("trackid", String.valueOf(trackId));
            if (includeProWC) output.put("showprowc", "1");
            if (includePro) output.put("showpro", "1");
            if (includeClassA) output.put("showclassa", "1");
            if (includeClassB) output.put("showclassb", "1");
            if (includeClassC) output.put("showclassc", "1");
            if (includeClassD) output.put("showclassd", "1");
            if (includeRookie) output.put("showrookie", "1");
            if (includeOfficialSessions) output.put("showofficial", "1");
            if (includeUnofficialSessions) output.put("showunofficial", "1");
            if (includePractiseSessions) output.put("showops", "1");
            if (includeQualifyingSessions) output.put("showquals", "1");
            if (includeRaceSessions) output.put("showraces", "1");
            if (includeTimeTrialSessions) output.put("showtts", "1");
            if (startDate != null || endDate != null) {
                if (startDate != null) output.put("starttime_low", String.valueOf(startDate.getTime()));
                if (endDate != null) output.put("starttime_high", String.valueOf(endDate.getTime()));
            } else {
                output.put("seasonquarter", String.valueOf(seasonQuarter));
                output.put("seasonyear", String.valueOf(seasonYear));
                if (raceWeek > 0) output.put("raceweek", String.valueOf(raceWeek));
            }
            return output;
        }
        
    }
    
    //"1":"champpointssort"
    //"2":"raw_start_time"
    private Date startTime;
    //"3":"bestlaptime"
    private String bestLapTime;
    //"4":"start_time"
    //private String startTime;
    //"5":"groupname"
    private String groupName;
    //"6":"helm_pattern"
    //"7":"season_year"
    private int seasonYear;
    //"8":"clubpoints"
    private int clubPoints;
    //"9":"subsession_bestlaptime"
    private String sessionBestLapTime;
    //"10":"evttype"
    private int eventType; // TODO: make this an enum
    //"11":"winnerlicenselevel"
    private int winnerLicenseLevel; // TODO: make this an enum
    //"12":"strengthoffield"
    private int strengthOfField;
    //"13":"dropracepoints"
    private int dropRacePoints;
    //"14":"finishedat"
    private Date finishDate;
    //"15":"trackid"
    private int trackId;
    //"16":"winnercustid"
    private long winnerCustomerId;
    //"17":"custid"
    private long customerId;
    //"18":"winnerdisplayname"
    private String winnerDisplayName;
    //"19":"sessionid"
    private long sessionId;
    //"20":"clubpointssort"
    //"21":"rn"
    //"22":"seasonid"
    private int seasonId;
    //"23":"carclassid"
    private int carClassId;
    //"24":"helm_licenselevel"
    //"25":"starting_position"
    private int startingPosition;
    //"26":"officialsession"
    private boolean officialSession;
    //"27":"displayname"
    private String displayName;
    //"28":"helm_color1"
    //"29":"season_quarter"
    private int seasonQuarter;
    //"30":"helm_color2"
    //"31":"helm_color3"
    //"32":"seriesid"
    private int seriesId;
    //"33":"bestquallaptime"
    private String bestQualifyingLapTime;
    //"34":"licensegroup"
    private int licenseGroup;
    //"35":"incidents"
    private int incidents;
    //"36":"champpoints"
    private int championshipPoints;
    //"37":"race_week_num"
    private int raceWeek;
    //"38":"start_date"
    private String startDate;
    //"39":"winnerhelmcolor1"
    //"40":"winnerhelmcolor2"
    //"41":"winnerhelmcolor3"
    //"42":"carid"
    private int carId;
    //"43":"subsessionid"
    private long subSessionId;
    //"44":"catid"
    private int categoryId;
    //"45":"winnerhelmpattern"
    //"46":"rowcount"
    //"47":"finishing_position"
    private int finishingPosition;
    
    public SessionResultSummary() {}

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getBestLapTime() {
        return bestLapTime;
    }

    public void setBestLapTime(String bestLapTime) {
        this.bestLapTime = bestLapTime;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(int seasonYear) {
        this.seasonYear = seasonYear;
    }

    public int getClubPoints() {
        return clubPoints;
    }

    public void setClubPoints(int clubPoints) {
        this.clubPoints = clubPoints;
    }

    public String getSessionBestLapTime() {
        return sessionBestLapTime;
    }

    public void setSessionBestLapTime(String sessionBestLapTime) {
        this.sessionBestLapTime = sessionBestLapTime;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getWinnerLicenseLevel() {
        return winnerLicenseLevel;
    }

    public void setWinnerLicenseLevel(int winnerLicenseLevel) {
        this.winnerLicenseLevel = winnerLicenseLevel;
    }

    public int getStrengthOfField() {
        return strengthOfField;
    }

    public void setStrengthOfField(int strengthOfField) {
        this.strengthOfField = strengthOfField;
    }

    public int getDropRacePoints() {
        return dropRacePoints;
    }

    public void setDropRacePoints(int dropRacePoints) {
        this.dropRacePoints = dropRacePoints;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public long getWinnerCustomerId() {
        return winnerCustomerId;
    }

    public void setWinnerCustomerId(long winnerCustomerId) {
        this.winnerCustomerId = winnerCustomerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getWinnerDisplayName() {
        return winnerDisplayName;
    }

    public void setWinnerDisplayName(String winnerDisplayName) {
        this.winnerDisplayName = winnerDisplayName;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getCarClassId() {
        return carClassId;
    }

    public void setCarClassId(int carClassId) {
        this.carClassId = carClassId;
    }

    public int getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    public boolean isOfficialSession() {
        return officialSession;
    }

    public void setOfficialSession(boolean officialSession) {
        this.officialSession = officialSession;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getSeasonQuarter() {
        return seasonQuarter;
    }

    public void setSeasonQuarter(int seasonQuarter) {
        this.seasonQuarter = seasonQuarter;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public String getBestQualifyingLapTime() {
        return bestQualifyingLapTime;
    }

    public void setBestQualifyingLapTime(String bestQualifyingLapTime) {
        this.bestQualifyingLapTime = bestQualifyingLapTime;
    }

    public int getLicenseGroup() {
        return licenseGroup;
    }

    public void setLicenseGroup(int licenseGroup) {
        this.licenseGroup = licenseGroup;
    }

    public int getIncidents() {
        return incidents;
    }

    public void setIncidents(int incidents) {
        this.incidents = incidents;
    }

    public int getChampionshipPoints() {
        return championshipPoints;
    }

    public void setChampionshipPoints(int championshipPoints) {
        this.championshipPoints = championshipPoints;
    }

    public int getRaceWeek() {
        return raceWeek;
    }

    public void setRaceWeek(int raceWeek) {
        this.raceWeek = raceWeek;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public long getSubSessionId() {
        return subSessionId;
    }

    public void setSubSessionId(long subSessionId) {
        this.subSessionId = subSessionId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getFinishingPosition() {
        return finishingPosition;
    }

    public void setFinishingPosition(int finishingPosition) {
        this.finishingPosition = finishingPosition;
    }
    
}