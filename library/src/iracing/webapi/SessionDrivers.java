package iracing.webapi;

import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SessionDrivers {
    
    private long subSessionId;
    private List<SessionDriver> drivers;
    
    public SessionDrivers() {}

    public long getSubSessionId() {
        return subSessionId;
    }

    public void setSubSessionId(long subSessionId) {
        this.subSessionId = subSessionId;
    }

    public List<SessionDriver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<SessionDriver> drivers) {
        this.drivers = drivers;
    }
    
}