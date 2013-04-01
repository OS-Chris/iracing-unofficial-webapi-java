package iracing.webapi;

import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public interface StatisticsDataDao {
    
    List<SeasonStanding> getSeasonStandingsBySeason(long seasonId);
    SeasonStanding getSeasonStanding(long seasonId, int year, int quarter);
    void persist(SeasonStanding o);
    
    List<SeasonTimeTrialStanding> getSeasonTimeTrialStandingsBySeason(long seasonId);
    SeasonTimeTrialStanding getSeasonTimeTrialStanding(long seasonId, int year, int quarter);
    void persist(SeasonTimeTrialStanding o);
    
    List<SessionResultSummary> getSessionResultSummaries();
    SessionResultSummary getSessionResultSummary(long subSessionId);
    void persist(SessionResultSummary o);
    
    List<SessionResult> getSessionResults();
    SessionResult getSessionResult(long subSessionId);
    void persist(SessionResult o);
    
}