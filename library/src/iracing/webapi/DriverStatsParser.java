package iracing.webapi;

import java.util.ArrayList;
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
public class DriverStatsParser extends JsonParserBase {
    
    static DriverStats parse(String json, boolean includeApiUserTopRow) {
        JSONParser parser = new JSONParser();
        DriverStats output = null;
        try {
            JSONObject root = (JSONObject)parser.parse(json);
            JSONObject root2 = (JSONObject)root.get("d");
            output = new DriverStats();
            output.setApiUserRow(getLong(root2, "24"));
            output.setTotalRecords(getLong(root2, "33"));
            JSONArray arrayRoot = (JSONArray)root2.get("r");
            List<DriverStat> statList = new ArrayList<DriverStat>();
            for (int i = 0; i < arrayRoot.size(); i++) {
                JSONObject r = (JSONObject)arrayRoot.get(i);
                long recordNumber = getLong(r, "37");
                if (!includeApiUserTopRow && recordNumber == 0) continue;
                DriverStat ds = new DriverStat();
                ds.setClubName(getString(r, "1", true));
                ds.setCountryCode(getString(r, "2", true));
                ds.setLicenseSubLevel(getInt(r, "3"));
                ds.setIratingRank(getLong(r, "4"));
                ds.setAverageFinishingPosition(getInt(r, "5"));
                ds.setIrating(getInt(r, "6"));
                ds.setLicenseGroupName(getString(r, "7", true));
                IracingCustomer driver = new IracingCustomer();
                driver.setName(getString(r, "8", true));
                driver.setId(getLong(r, "29"));
                ds.setDriver(driver);
                ds.setTimeTrialRatingRank(getLong(r, "9"));
                ds.setAverageIncidentsPerRace(getDouble(r, "10"));
                ds.setTotalTop25PercentFinishes(getLong(r, "11"));
                ds.setClubId(getInt(r, "12"));
                ds.setTotalStarts(getLong(r, "13"));
                ds.setLicenseClassRank(getLong(r, "15"));
                ds.setTotalLapsLed(getLong(r, "16"));
                ds.setTotalWins(getLong(r, "17"));
                ds.setTotalClubPoints(getLong(r, "18"));
                ds.setTimeTrialRating(getInt(r, "19"));
                ds.setLicenseGroupId(getInt(r, "20"));
                ds.setLicenseLevelId(getInt(r, "21"));
                ds.setTotalChampionshipPoints(getLong(r, "22"));
                ds.setLicenseGroupLetter(getString(r, "23", true));
                ds.setAverageFieldSize(getInt(r, "25"));
                ds.setRank(getLong(r, "26"));
                ds.setRegionName(getString(r, "31", true));
                ds.setAveragePointsPerRace(getInt(r, "32"));
                ds.setTotalLaps(getLong(r, "34"));
                ds.setLicenseClass(getString(r, "35", true));
                ds.setAverageStartingPosition(getInt(r, "36"));
                ds.setRecordNumber(recordNumber);
                statList.add(ds);
            }
            output.setStats(statList);
        } catch (ParseException ex) {
            Logger.getLogger(DriverStatsParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}