package iracing.webapi;

import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SessionSubResult {
    
    private int eventTypeId;
    private List<SessionDriverResult> driverResults;
    
    public SessionSubResult() {}

    public SessionSubResult(CsvSessionResult csvResult) {
        driverResults = csvResult.getDriverResults();
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }
    
    public List<SessionDriverResult> getDriverResults() {
        return driverResults;
    }

    public void setDriverResults(List<SessionDriverResult> driverResults) {
        this.driverResults = driverResults;
    }

}