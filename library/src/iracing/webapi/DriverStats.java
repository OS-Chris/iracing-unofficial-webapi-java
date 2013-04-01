package iracing.webapi;

import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class DriverStats {
    
    private long apiUserRow;
    private long totalRecords;
    private List<DriverStat> stats;
    
    public DriverStats() {}

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

    public List<DriverStat> getStats() {
        return stats;
    }

    public void setStats(List<DriverStat> stats) {
        this.stats = stats;
    }
    
}