package iracing.webapi;

import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class WorldRecords {
    
    private long totalResults;
    private long apiUserRow;
    private List<WorldRecord> records;
    
    public WorldRecords() {}

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public long getApiUserRow() {
        return apiUserRow;
    }

    public void setApiUserRow(long apiUserRow) {
        this.apiUserRow = apiUserRow;
    }

    public List<WorldRecord> getRecords() {
        return records;
    }

    public void setRecords(List<WorldRecord> records) {
        this.records = records;
    }
    
}