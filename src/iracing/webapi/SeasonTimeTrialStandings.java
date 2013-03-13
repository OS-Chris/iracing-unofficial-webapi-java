package iracing.webapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SeasonTimeTrialStandings {
    
    public static class SearchParameters {
        
        private int carClassId;
        private int clubId = -1;
        private int division = -1;
        private int start = 1;
        private int end = 25;
        private int seasonId;
        private int raceWeek = 1;
        private SortOrder sortOrder = SortOrder.DESCENDING;
        private SortField sortField = SortField.TOTAL_POINTS;
        
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

        public int getSeasonId() {
            return seasonId;
        }

        public void setSeasonId(int seasonId) {
            this.seasonId = seasonId;
        }

        public int getRaceWeek() {
            return raceWeek;
        }

        public void setRaceWeek(int raceWeek) {
            this.raceWeek = raceWeek;
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
            output.put("carclassid", String.valueOf(carClassId));
            output.put("clubid", String.valueOf(clubId));
            output.put("division", String.valueOf(division));
            output.put("seasonid", String.valueOf(seasonId));
            output.put("start", String.valueOf(start));
            output.put("end", String.valueOf(end));
            output.put("raceweek", String.valueOf(raceWeek));
            if (sortField == SortField.DRIVER_NAME) {
                output.put("sort", "displayname");
            } else if (sortField == SortField.DIVISION) {
                output.put("sort", "division");
            } else if (sortField == SortField.CLUB_NAME) {
                output.put("sort", "clubname");
            } else if (sortField == SortField.WEEKS_COUNTED) {
                output.put("sort", "week");
            } else if (sortField == SortField.TOTAL_STARTS) {
                output.put("sort", "starts");
            } else if (sortField == SortField.TOTAL_WINS) {
                output.put("sort", "wins");
            } else if (sortField == SortField.TOTAL_POINTS) {
                output.put("sort", "points");
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
        WEEKS_COUNTED,
        TOTAL_STARTS,
        TOTAL_WINS,
        TOTAL_POINTS
    }
    
    private long totalRecords;
    private long apiUserRow;
    private List<SeasonTimeTrialStanding> standings;
    
    public SeasonTimeTrialStandings() {}

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    /**
     * 
     * @return -1 if the API user did not compete in the series matching the search parameters, otherwise, the row containing the API user
     */
    public long getApiUserRow() {
        return apiUserRow;
    }

    public void setApiUserRow(long apiUserRow) {
        this.apiUserRow = apiUserRow;
    }

    public List<SeasonTimeTrialStanding> getStandings() {
        return standings;
    }

    public void setStandings(List<SeasonTimeTrialStanding> standings) {
        this.standings = standings;
    }
    
}