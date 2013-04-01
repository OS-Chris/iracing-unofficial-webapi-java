package iracing.webapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class HostedSessionResultSummaryParser extends JsonParserBase {
    
    public interface ItemHandler {
        public boolean onHostedSessionResultSummaryParsed(HostedSessionResultSummary summary);
    }
    
    public static class ListItemHandler implements ItemHandler {

        private List<HostedSessionResultSummary> list;
        
        public ListItemHandler() {
            list = new ArrayList<HostedSessionResultSummary>();
        }
        
        @Override
        public boolean onHostedSessionResultSummaryParsed(HostedSessionResultSummary summary) {
            list.add(summary);
            return true;
        }

        public List<HostedSessionResultSummary> getList() {
            return list;
        }
        
    }
    
    private ItemHandler itemHandler;
    
    public HostedSessionResultSummaryParser() {}

    public ItemHandler getItemHandler() {
        return itemHandler;
    }

    public void setItemHandler(ItemHandler itemHandler) {
        this.itemHandler = itemHandler;
    }
    
    public HostedSessionResultSummaries parse(String json) {
        ListItemHandler lih = new ListItemHandler();
        HostedSessionResultSummaries output = new HostedSessionResultSummaries();
        output.setTotalRecords(parse(json, lih));
        output.setResults(lih.getList());
        return output;
    }
    
    static long parse(String json, ItemHandler handler) {
        JSONParser parser = new JSONParser();
//        System.err.println(json);
        long output = 0;
        if (!"{}".equals(json)) {
            try {
                JSONObject root = (JSONObject)parser.parse(json);
                output = getLong(root, "rowcount");
                JSONArray rootArray = (JSONArray)root.get("rows");
                for (int i = 0; i < rootArray.size(); i++) {
                    JSONObject r = (JSONObject)rootArray.get(i);
                    HostedSessionResultSummary summary = new HostedSessionResultSummary();
                    summary.setWasPrivate((getInt(r, "private")) == 1);
                    summary.setDriverSearchedBestLapTime(getLong(r, "bestlaptime"));
                    summary.setDriverSearchedStartingPosition(getInt(r, "startingposition"));
                    summary.setDriverSearchedClassStartingPosition(getInt(r, "classstartingposition"));
                    summary.setDriverSearchedFinishingPosition(getInt(r, "finishingposition"));
                    summary.setDriverSearchedClassFinishingPosition(getInt(r, "classfinishingposition"));
                    summary.setDriverSearchedCarClassId(getInt(r, "carclassid"));
                    summary.setDriverSearchedIncidents(getInt(r, "incidents"));
                    summary.setPracticeLength(getInt(r, "practicelength"));
                    summary.setQualifyingLaps(getInt(r, "qualifylaps"));
                    summary.setQualifyingLength(getInt(r, "qualifylength"));
                    summary.setRaceLaps(getInt(r, "racelaps"));
                    summary.setRaceLength(getInt(r, "racelength"));
                    summary.setStartTime(new Date(getLong(r, "start_time")));
                    summary.setMinimumLicenseLevel(getInt(r, "minliclevel"));
                    summary.setMaximumLicenseLevel(getInt(r, "maxliclevel"));
                    summary.setMinimumIrating(getInt(r, "minir"));
                    summary.setMaximumIrating(getInt(r, "maxir"));
                    summary.setPrivateSessionId(getLong(r, "privatesessionid"));
                    IracingCustomer host = new IracingCustomer();
                    host.setId(getLong(r, "host_custid"));
                    host.setName(getString(r, "host_displayname", true));
                    summary.setHost(host);
                    summary.setHostLicenseLevel(getInt(r, "host_licenselevel"));
                    summary.setSessionName(getString(r, "sessionname", true));
                    summary.setTrackId(getInt(r, "trackid"));
                    summary.setTrackName(getString(r, "track_name", true));
                    IracingCustomer winner = new IracingCustomer();
                    winner.setId(getLong(r, "winner_custid"));
                    winner.setName(getString(r, "winner_displayname", true));
                    summary.setWinner(winner);
                    summary.setWinnerLicenseLevel(getInt(r, "winner_licenselevel"));
                    summary.setSessionId(getLong(r, "sessionid"));
                    summary.setSubSessionId(getLong(r, "subsessionid"));
                    summary.setSubSessionFinishedAt(new Date(getLong(r, "subsessionfinishedat")));
                    summary.setRaceFinishedAt(new Date(getLong(r, "racefinishedat")));
                    summary.setLoneQualifying((getInt(r, "lonequalify")) == 1);
                    summary.setHardcoreLevelId(getInt(r, "hardcorelevel"));
                    summary.setNightMode((getInt(r, "nightmode")) == 1);
                    summary.setRestarts(getInt(r, "restarts"));
                    summary.setFullCourseCautions((getInt(r, "fullcoursecautions")) == 1);
                    summary.setRollingStarts((getInt(r, "rollingstarts")) == 1);
                    summary.setMultiClass((getInt(r, "multiclass")) == 1);
                    summary.setFixedSetup((getInt(r, "fixed_setup")) == 1);
                    summary.setNumberOfFastTows(getInt(r, "numfasttows"));
                    String s = getString(r, "carids", true);
                    String[] sa = s.split(",");
                    List<Integer> carIds = new ArrayList<Integer>();
                    for (String carId : sa) {
                        carIds.add(Integer.parseInt(carId));
                    }
                    summary.setCars(carIds);
                    s = getString(r, "max_pct_fuel_fills", true);
                    if (!"".equals(s)) {
                        sa = s.split(",");
                        List<Integer> maxFuelFills = new ArrayList<Integer>();
                        for (String mff : sa) {
                            maxFuelFills.add(Integer.parseInt(mff));
                        }
                        summary.setMaximumPercentageFuelFills(maxFuelFills);
                    }
                    summary.setMaximumDrivers(getInt(r, "maxdrivers"));
                    summary.setCreated(new Date(getLong(r, "created")));
                    summary.setSessionFastestLap(getLong(r, "sessionfastlap"));
                    summary.setCategoryId(getInt(r, "catid"));
                    handler.onHostedSessionResultSummaryParsed(summary);
                }
            } catch (ParseException ex) {
                Logger.getLogger(HostedSessionResultSummaryParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }
    
}