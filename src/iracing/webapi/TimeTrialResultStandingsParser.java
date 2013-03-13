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
public class TimeTrialResultStandingsParser extends JsonParserBase {
    
    public static void main(String[] args) {
        String s = "{\"m\":{\"1\":\"points\",\"2\":\"sublevel\",\"3\":\"custrow\",\"4\":\"maxlicenselevel\",\"5\":\"rank\",\"6\":\"helmcolor1\",\"7\":\"division\",\"8\":\"displayname\",\"9\":\"helmcolor2\",\"10\":\"custid\",\"11\":\"helmcolor3\",\"12\":\"starts\",\"13\":\"besttimeformatted\",\"14\":\"besttime\",\"15\":\"clubid\",\"16\":\"helmpattern\",\"17\":\"rowcount\",\"18\":\"pos\",\"19\":\"rn\"},\"d\":{\"3\":\"-1\",\"17\":8,\"r\":[{\"1\":100,\"2\":\"+4.63\",\"4\":20,\"5\":1,\"6\":240,\"7\":0,\"8\":\"Simon+Black\",\"9\":240,\"10\":17455,\"11\":244,\"12\":4,\"13\":\"2%3A10.117\",\"14\":1301170,\"15\":34,\"16\":19,\"18\":1,\"19\":1},{\"1\":97.3947372,\"2\":\"+2.62\",\"4\":18,\"5\":2,\"6\":113,\"7\":0,\"8\":\"Josh+Smith\",\"9\":116,\"10\":60147,\"11\":118,\"12\":2,\"13\":\"2%3A10.251\",\"14\":1302518,\"15\":34,\"16\":35,\"18\":2,\"19\":2},{\"1\":94.7894745,\"2\":\"+3.61\",\"4\":19,\"5\":3,\"6\":60,\"7\":0,\"8\":\"Stephen+Titow\",\"9\":116,\"10\":16671,\"11\":112,\"12\":2,\"13\":\"2%3A10.650\",\"14\":1306505,\"15\":34,\"16\":60,\"18\":3,\"19\":3},{\"1\":92.1842117,\"2\":\"+3.88\",\"4\":15,\"5\":4,\"6\":47,\"7\":0,\"8\":\"Trevor+Forster\",\"9\":212,\"10\":17417,\"11\":212,\"12\":1,\"13\":\"2%3A11.038\",\"14\":1310381,\"15\":34,\"16\":32,\"18\":4,\"19\":4},{\"1\":89.578949,\"2\":\"+4.82\",\"4\":20,\"5\":5,\"6\":240,\"7\":0,\"8\":\"Omar+S%C3%B2to\",\"9\":114,\"10\":88011,\"11\":100,\"12\":2,\"13\":\"2%3A11.367\",\"14\":1313674,\"15\":38,\"16\":45,\"18\":5,\"19\":5},{\"1\":84.3684235,\"2\":\"+3.24\",\"4\":19,\"5\":6,\"6\":255,\"7\":0,\"8\":\"Wayne+Wortley\",\"9\":252,\"10\":30467,\"11\":246,\"12\":2,\"13\":\"2%3A11.608\",\"14\":1316089,\"15\":1,\"16\":1,\"18\":6,\"19\":6},{\"1\":81.7631607,\"2\":\"+4.16\",\"4\":20,\"5\":7,\"6\":116,\"7\":0,\"8\":\"Jacob+Fredriksson\",\"9\":116,\"10\":26161,\"11\":124,\"12\":2,\"13\":\"2%3A11.619\",\"14\":1316195,\"15\":43,\"16\":64,\"18\":7,\"19\":7},{\"1\":0,\"2\":\"+2.67\",\"4\":18,\"5\":8,\"6\":254,\"7\":0,\"8\":\"Simon+Hill\",\"9\":105,\"10\":20386,\"11\":144,\"12\":1,\"13\":\"\",\"14\":\"\",\"15\":36,\"16\":18,\"18\":8,\"19\":8}]}}";
        TimeTrialResultStandings standings = parse(s);
        for (TimeTrialResultStanding standing : standings.getStandings()) {
            System.err.println(standing.getDriverName() + " (" + standing.getPoints() + ")");
        }
        System.err.println("TOTAL RECORDS : " + standings.getTotalRecords());
    }
    
    public static TimeTrialResultStandings parse(String json) {
        TimeTrialResultStandings output = null;
        JSONParser parser = new JSONParser();
        try {
            JSONObject root = (JSONObject)parser.parse(json);
            Object o = root.get("d");
            if (o instanceof JSONObject) {
                JSONObject d = (JSONObject)o;
                output = new TimeTrialResultStandings();
                String s = (String)d.get("3");
                output.setApiUserRow(Integer.parseInt(s));
                output.setTotalRecords(getInt(d, "17"));
                JSONArray arrayRoot = (JSONArray)d.get("r");
                List<TimeTrialResultStanding> standings = new ArrayList<TimeTrialResultStanding>();
                for (int i = 0; i < arrayRoot.size(); i++) {
                    JSONObject r = (JSONObject)arrayRoot.get(i);
                    TimeTrialResultStanding standing = new TimeTrialResultStanding();
                    o = r.get("1");
                    if (o instanceof Double) {
                        standing.setPoints((Double)o);
                    } else if (o instanceof Long) {
                        standing.setPoints(Double.parseDouble(String.valueOf(o)));
                    }
                    standing.setLicenseSubLevel(getString(r, "2"));
                    standing.setMaxLicenseLevel(getInt(r, "4"));
                    standing.setRank(getInt(r, "5"));
                    standing.setDivision(getInt(r, "7"));
                    standing.setDriverName(getString(r, "8", true));
                    standing.setDriverCustomerId(getLong(r, "10"));
                    standing.setTotalStarts(getInt(r, "12"));
                    standing.setBestTimeFormatted(getString(r, "13", true));
                    o = r.get("14");
                    if (o instanceof Long) {
                        standing.setBestTime((Long)o);
                    } else {  // drivers setting no time will have an empty string ("14":"")
                        standing.setBestTime(-1L);
                    }
                    standing.setClubId(getInt(r, "15"));
                    standing.setPosition(getLong(r, "18"));
                    standings.add(standing);
                }
                output.setStandings(standings);
            }
        } catch (ParseException ex) {
            Logger.getLogger(TimeTrialResultStandingsParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}