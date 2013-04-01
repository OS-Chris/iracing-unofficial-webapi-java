package iracing.webapi;

import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class YearAndQuarters {
    
    public static class Quarter {
        
        private int id;
        private int numberOfWeeks;
        private List<Integer> seasons;
        
        public Quarter() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumberOfWeeks() {
            return numberOfWeeks;
        }

        public void setNumberOfWeeks(int numberOfWeeks) {
            this.numberOfWeeks = numberOfWeeks;
        }

        public List<Integer> getSeasons() {
            return seasons;
        }

        public void setSeasons(List<Integer> seasons) {
            this.seasons = seasons;
        }
        
    }
    
    private int year;
    private List<Quarter> quarters;
    
    public YearAndQuarters() {}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public List<Quarter> getQuarters() {
        return quarters;
    }

    public void setQuarters(List<Quarter> quarters) {
        this.quarters = quarters;
    }

}