package iracing.webapi;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SessionResult {

    private Date startTime;
    private String trackName;
    private String seriesName;
    private String hostedSessionName;
    private List<SessionSubResult> subResults;
    
    public SessionResult() {}

    public boolean isHosted() {
        return (hostedSessionName != null && !"".equals(hostedSessionName));
    }
    
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String track) {
        this.trackName = track;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String series) {
        this.seriesName = series;
    }

    public String getHostedSessionName() {
        return hostedSessionName;
    }

    public void setHostedSessionName(String hostedSessionName) {
        this.hostedSessionName = hostedSessionName;
    }

    public List<SessionSubResult> getSubResults() {
        return subResults;
    }

    public void setSubResults(List<SessionSubResult> subResults) {
        this.subResults = subResults;
    }
    
}