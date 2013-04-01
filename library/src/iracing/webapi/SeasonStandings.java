package iracing.webapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SeasonStandings {
    
    public static class SearchParameters {
        
        private int carClassId = -1;
        private int clubId = -1;
        private int division = -1;
        private long start = 1;
        private long end = 25;
        private int raceWeek = -1;
        private int seasonId;
        private SortField sortField = SortField.POINTS;
        private SortOrder sortOrder = SortOrder.DESCENDING;
        
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
            Map<String, String> params = new HashMap<String, String>();
            params.put("carclassid", String.valueOf(carClassId));
            params.put("clubid", String.valueOf(clubId));
            params.put("division", String.valueOf(division));
            params.put("start", String.valueOf(start));
            params.put("end", String.valueOf(end));
            params.put("raceweek", String.valueOf(raceWeek));
            params.put("seasonid", String.valueOf(seasonId));
            if (sortField == SortField.POINTS) {
                params.put("sort", "points");
            } else if (sortField == SortField.DRIVER_NAME) {
                params.put("sort", "displayname");
            } else if (sortField == SortField.DIVISION) {
                params.put("sort", "division");
            } else if (sortField == SortField.CLUB_NAME) {
                params.put("sort", "clubname");
            } else if (sortField == SortField.WEEKS_COUNTED) {
                params.put("sort", "week");
            } else if (sortField == SortField.TOTAL_STARTS) {
                params.put("sort", "starts");
            } else if (sortField == SortField.TOTAL_WINS) {
                params.put("sort", "wins");
            } else if (sortField == SortField.TOTAL_TOP5) {
                params.put("sort", "topfive");
            } else if (sortField == SortField.TOTAL_POLES) {
                params.put("sort", "poles");
            } else if (sortField == SortField.AVERAGE_STARTING_POSITION) {
                params.put("sort", "avgstartingposition");
            } else if (sortField == SortField.AVERAGE_FINISHING_POSITION) {
                params.put("sort", "avgfinishingposition");
            } else if (sortField == SortField.TOTAL_LAPS) {
                params.put("sort", "laps");
            } else if (sortField == SortField.TOTAL_LAPS_LED) {
                params.put("sort", "lapslead");
            } else if (sortField == SortField.TOTAL_INCIDENTS) {
                params.put("sort", "incidents");
            }
            if (sortOrder == SortOrder.ASCENDING) {
                params.put("order", "asc");
            } else {
                params.put("order", "desc");
            }
            return params;
        }
    }
    
    public enum SortField {
        POINTS,
        DRIVER_NAME,
        DIVISION,
        CLUB_NAME,
        WEEKS_COUNTED,
        TOTAL_STARTS,
        TOTAL_WINS,
        TOTAL_TOP5,
        TOTAL_POLES,
        AVERAGE_STARTING_POSITION,
        AVERAGE_FINISHING_POSITION,
        TOTAL_LAPS,
        TOTAL_LAPS_LED,
        TOTAL_INCIDENTS
    }
    
    private long totalRecords;
    private List<SeasonStanding> standings;
    
    public SeasonStandings() {}

    public List<SeasonStanding> getStandings() {
        return standings;
    }

    public void setStandings(List<SeasonStanding> standings) {
        this.standings = standings;
    }

    public long getTotalRecords() {
        return totalRecords;
    }
    
    void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }
    
}