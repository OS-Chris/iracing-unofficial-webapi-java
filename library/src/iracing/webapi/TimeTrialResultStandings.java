package iracing.webapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class TimeTrialResultStandings {
    
    public static class SearchParameters {
        
        //carclassid=25&clubid=-1&division=-1&end=25&order=desc&raceweek=8&seasonid=672&sort=points&start=1
        
        // TODO: use the following known data in a test case
        //carclassid=25&clubid=-1&division=0&end=25&order=desc&raceweek=1&seasonid=672&sort=points&start=1
        //{"m":{"1":"points","2":"sublevel","3":"custrow","4":"maxlicenselevel","5":"rank","6":"helmcolor1","7":"division","8":"displayname","9":"helmcolor2","10":"custid","11":"helmcolor3","12":"starts","13":"besttimeformatted","14":"besttime","15":"clubid","16":"helmpattern","17":"rowcount","18":"pos","19":"rn"},"d":{"3":"-1","17":8,"r":[{"1":100,"2":"+4.63","4":20,"5":1,"6":240,"7":0,"8":"Simon+Black","9":240,"10":17455,"11":244,"12":4,"13":"2%3A10.117","14":1301170,"15":34,"16":19,"18":1,"19":1},{"1":97.3947372,"2":"+2.62","4":18,"5":2,"6":113,"7":0,"8":"Josh+Smith","9":116,"10":60147,"11":118,"12":2,"13":"2%3A10.251","14":1302518,"15":34,"16":35,"18":2,"19":2},{"1":94.7894745,"2":"+3.61","4":19,"5":3,"6":60,"7":0,"8":"Stephen+Titow","9":116,"10":16671,"11":112,"12":2,"13":"2%3A10.650","14":1306505,"15":34,"16":60,"18":3,"19":3},{"1":92.1842117,"2":"+3.88","4":15,"5":4,"6":47,"7":0,"8":"Trevor+Forster","9":212,"10":17417,"11":212,"12":1,"13":"2%3A11.038","14":1310381,"15":34,"16":32,"18":4,"19":4},{"1":89.578949,"2":"+4.82","4":20,"5":5,"6":240,"7":0,"8":"Omar+S%C3%B2to","9":114,"10":88011,"11":100,"12":2,"13":"2%3A11.367","14":1313674,"15":38,"16":45,"18":5,"19":5},{"1":84.3684235,"2":"+3.24","4":19,"5":6,"6":255,"7":0,"8":"Wayne+Wortley","9":252,"10":30467,"11":246,"12":2,"13":"2%3A11.608","14":1316089,"15":1,"16":1,"18":6,"19":6},{"1":81.7631607,"2":"+4.16","4":20,"5":7,"6":116,"7":0,"8":"Jacob+Fredriksson","9":116,"10":26161,"11":124,"12":2,"13":"2%3A11.619","14":1316195,"15":43,"16":64,"18":7,"19":7},{"1":0,"2":"+2.67","4":18,"5":8,"6":254,"7":0,"8":"Simon+Hill","9":105,"10":20386,"11":144,"12":1,"13":"","14":"","15":36,"16":18,"18":8,"19":8}]}}
        private int carClassId;
        private int seasonId;
        private int clubId = -1;
        private int division = -1;
        private long start = 1;
        private long end = 25;
        private int raceWeek = 1;
        private SortOrder sortOrder = SortOrder.DESCENDING;
        private SortField sortField = SortField.POINTS;
        
        public SearchParameters() {}

        public int getCarClassId() {
            return carClassId;
        }

        public void setCarClassId(int carClassId) {
            this.carClassId = carClassId;
        }

        public int getSeasonId() {
            return seasonId;
        }

        public void setSeasonId(int seasonId) {
            this.seasonId = seasonId;
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
            output.put("seasonid", String.valueOf(getSeasonId()));
            output.put("start", String.valueOf(getStart()));
            output.put("end", String.valueOf(getEnd()));
            output.put("raceweek", String.valueOf(getRaceWeek()));
            if (getSortField() == SortField.DRIVER_NAME) {
                output.put("sort", "displayname");
            } else if (getSortField() == SortField.DIVISION) {
                output.put("sort", "division");
            } else if (getSortField() == SortField.CLUB_NAME) {
                output.put("sort", "clubname");
            } else if (getSortField() == SortField.TOTAL_STARTS) {
                output.put("sort", "starts");
            } else if (getSortField() == SortField.POINTS) {
                output.put("sort", "points");
            }
            if (getSortOrder() == SortOrder.ASCENDING) {
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
        TOTAL_STARTS,
        POINTS
    }
    
    private long apiUserRow;
    private long totalRecords;
    private List<TimeTrialResultStanding> standings;
    
    public TimeTrialResultStandings() {}

    public long getApiUserRow() {
        return apiUserRow;
    }

    public void setApiUserRow(long apiUserRow) {
        this.apiUserRow = apiUserRow;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<TimeTrialResultStanding> getStandings() {
        return standings;
    }

    public void setStandings(List<TimeTrialResultStanding> standings) {
        this.standings = standings;
    }
    
}