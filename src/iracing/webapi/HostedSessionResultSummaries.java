package iracing.webapi;

import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class HostedSessionResultSummaries {
    
    private long totalRecords;
    private List<HostedSessionResultSummary> results;
    
    public HostedSessionResultSummaries() {}

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<HostedSessionResultSummary> getResults() {
        return results;
    }

    public void setResults(List<HostedSessionResultSummary> results) {
        this.results = results;
    }
    
}