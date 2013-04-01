package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class YearAndQuarter {
    
    private int year, quarter;
    
    public YearAndQuarter() {}
    public YearAndQuarter(int year, int quarter) {
        this.year = year;
        this.quarter = quarter;
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
    
}