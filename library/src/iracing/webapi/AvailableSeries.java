package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class AvailableSeries {
    
    private String seriesName;
    private boolean apiUserEligible;
    private int categoryId;
    private int seasonId;
    
    public AvailableSeries() {}

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public boolean isApiUserEligible() {
        return apiUserEligible;
    }

    public void setApiUserEligible(boolean apiUserEligible) {
        this.apiUserEligible = apiUserEligible;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }
    
}