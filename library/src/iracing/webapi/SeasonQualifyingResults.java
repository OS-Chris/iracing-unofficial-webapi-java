package iracing.webapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SeasonQualifyingResults {
    
    public static class SearchParameters {
        
        private int carClassId;
        private int clubId = -1;
        private int division = -1;
        private long start = 1;
        private long end = 25;
        private int raceWeek = 1;
        private int seasonId;
        private SortOrder sortOrder = SortOrder.ASCENDING;
        private SortField sortField = SortField.QUALIFYING_TIME;
        
        public SearchParameters() {}

        public int getCarClassId() {
            return carClassId;
        }

        public void setCarClassId(int carClassId) {
            this.carClassId = carClassId;
        }

        public int getClubId() {
            return clubId;
        }

        public void setClubId(int clubId) {
            this.clubId = clubId;
        }

        public int getDivision() {
            return division;
        }

        public void setDivision(int division) {
            this.division = division;
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

        public int getRaceWeek() {
            return raceWeek;
        }

        public void setRaceWeek(int raceWeek) {
            this.raceWeek = raceWeek;
        }

        public int getSeasonId() {
            return seasonId;
        }

        public void setSeasonId(int seasonId) {
            this.seasonId = seasonId;
        }

        public SortOrder getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(SortOrder sortOrder) {
            this.sortOrder = sortOrder;
        }

        public SortField getSortField() {
            return sortField;
        }

        public void setSortField(SortField sortField) {
            this.sortField = sortField;
        }
        
        public Map<String, String> toParameters() {
            Map<String, String> output = new HashMap<String, String>();
            output.put("carclassid", String.valueOf(getCarClassId()));
            output.put("clubid", String.valueOf(getClubId()));
            output.put("division", String.valueOf(getDivision()));
            output.put("start", String.valueOf(getStart()));
            output.put("end", String.valueOf(getEnd()));
            output.put("raceweek", String.valueOf(getRaceWeek()));
            output.put("seasonid", String.valueOf(getSeasonId()));
            if (sortField == SortField.DRIVER_NAME) {
                output.put("sort", "displayname");
            } else if (sortField == SortField.DIVISION) {
                output.put("sort", "division");
            } else if (sortField == SortField.CLUB_NAME) {
                output.put("sort", "clubname");
            } else if (sortField == SortField.QUALIFYING_TIME) {
                output.put("sort", "bestqualtime");
            }
            if (sortOrder == SortOrder.ASCENDING) {
                output.put("order", "asc");
            } else {
                output.put("order", "desc");
            }
            return output;
        }
    }
    
    public enum SortField {
        DRIVER_NAME,
        DIVISION,
        CLUB_NAME,
        QUALIFYING_TIME
    }
    
    private long totalRecords;
    private List<SeasonQualifyingResult> results;
    
    public SeasonQualifyingResults() {}

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<SeasonQualifyingResult> getResults() {
        return results;
    }

    public void setResults(List<SeasonQualifyingResult> results) {
        this.results = results;
    }
    
}