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
public class SessionResultDriverLapsParser extends JsonParserBase {
    
    public static void main(String[] args) {
        String s = "{\"details\":{\"nlapsforsolo\":5,\"suitPattern\":1,\"bestnlapsnum\":-1,\"seasonShortName\":\"2012+Season+2\",\"maxLicenseLevel\":20,\"displayname\":\"Christian+Aylward\",\"seasonName\":\"Classic+Lotus+Grand+Prix\",\"sessionId\":25952482,\"carNum\":\"1\",\"eventtype\":5,\"suitColor1\":127,\"bestQualLapAt\":-1,\"suitColor2\":240,\"carPattern\":22,\"suitColor3\":255,\"bestQualLapNum\":-1,\"eventTypeName\":\"Race\",\"carColor1\":96,\"seriesName\":\"Classic+Lotus+Grand+Prix\",\"helmetPattern\":48,\"carColor2\":64,\"carColor3\":255,\"trackID\":185,\"eventDate\":\"2012-06-27\",\"trackConfig\":\"Intl+w%2Fno+Chicanes\",\"carid\":25,\"bestLapNum\":15,\"bestNLapsTime\":-1,\"seriesShortName\":\"Classic+Lotus+Grand+Prix\",\"subSessionId\":5923645,\"nlapsforqual\":2,\"eventDateUTCMilliSecs\":1340800200000,\"bestQualLapTime\":-1,\"trackName\":\"Oulton+Park+Circuit\",\"helmetColor1\":111,\"helmetColor2\":255,\"helmetColor3\":127},\"laps\":[{\"flags\":0,\"lapnum\":0,\"time\":606354},{\"flags\":0,\"lapnum\":1,\"time\":1402652},{\"flags\":0,\"lapnum\":2,\"time\":2154094},{\"flags\":0,\"lapnum\":3,\"time\":2897925},{\"flags\":0,\"lapnum\":4,\"time\":3642714},{\"flags\":0,\"lapnum\":5,\"time\":4385400},{\"flags\":0,\"lapnum\":6,\"time\":5123522},{\"flags\":0,\"lapnum\":7,\"time\":5868536},{\"flags\":0,\"lapnum\":8,\"time\":6612138},{\"flags\":0,\"lapnum\":9,\"time\":7356494},{\"flags\":0,\"lapnum\":10,\"time\":8098469},{\"flags\":0,\"lapnum\":11,\"time\":8839985},{\"flags\":0,\"lapnum\":12,\"time\":9585341},{\"flags\":0,\"lapnum\":13,\"time\":10323721},{\"flags\":0,\"lapnum\":14,\"time\":11059822},{\"flags\":0,\"lapnum\":15,\"time\":11794065},{\"flags\":0,\"lapnum\":16,\"time\":12530923},{\"flags\":4,\"lapnum\":17,\"time\":13279649},{\"flags\":0,\"lapnum\":18,\"time\":14020023},{\"flags\":0,\"lapnum\":19,\"time\":14760884},{\"flags\":0,\"lapnum\":20,\"time\":15497357},{\"flags\":0,\"lapnum\":21,\"time\":16287442},{\"flags\":2,\"lapnum\":22,\"time\":17237734},{\"flags\":0,\"lapnum\":23,\"time\":17973384},{\"flags\":0,\"lapnum\":24,\"time\":18708335},{\"flags\":0,\"lapnum\":25,\"time\":19446124}]}";
        SessionResultDriverLaps laps = parse(s);
        for (SessionResultDriverLap lap : laps.getLaps()) {
            double time = (double)lap.getLapTime() / 10000;
            String flags = lap.getFlagsText();
            s = lap.getLapNumber() + " : " + time;
            if (!"".equals(flags)) s += " (" + flags + ")";
            System.err.println(s);
        }
    }
    
    static SessionResultDriverLaps parse(String json) {
        JSONParser parser = new JSONParser();
        SessionResultDriverLaps output = null;
        try {
            JSONObject root = (JSONObject)parser.parse(json);
            output = new SessionResultDriverLaps();
            JSONObject details = (JSONObject)root.get("details");
            output.setLapsForSolo(getInt(details, "nlapsforsolo"));
            output.setBestNLapsNumber(getInt(details, "bestnlapsnum"));
            output.setSeasonShortName(getString(details, "seasonShortName", true));
            output.setMaximumLicenseLevel(getInt(details, "maxLicenseLevel"));
            output.setDriverName(getString(details, "displayname", true));
            output.setSeasonName(getString(details, "seasonName", true));
            output.setSeriesName(getString(details, "seriesName", true));
            output.setSeriesShortName(getString(details, "seriesShortName", true));
            output.setSessionId(getLong(details, "sessionId"));
            output.setSubSessionId(getLong(details, "subSessionId"));
            output.setCarNumber(getString(details, "carNum"));
            output.setCarId(getInt(details, "carid"));
            output.setEventTypeId(getInt(details, "eventtype"));
            output.setEventTypeName(getString(details, "eventTypeName", true));
            output.setBestQualifyingLapAt(getInt(details, "bestQualLapAt"));
            output.setBestQualifyingLapNumber(getInt(details, "bestQualLapNum"));
            output.setBestLapNumber(getInt(details, "bestLapNum"));
            output.setBestNLapsTime(getInt(details, "bestNLapsTime"));
            output.setLapsForQualifying(getInt(details, "nlapsforqual"));
            output.setBestQualifyingLapTime(getLong(details, "bestQualLapTime"));
            output.setTrackId(getInt(details, "trackID"));
            output.setTrackName(getString(details, "trackName", true));
            output.setTrackConfigName(getString(details, "trackConfig", true));
            output.setEventDate(new Date(getLong(details, "eventDateUTCMilliSecs")));
            List<SessionResultDriverLap> lapList = new ArrayList<SessionResultDriverLap>();
            JSONArray a = (JSONArray)root.get("laps");
            long lastLapTime = 0;
            for (int i = 0; i < a.size(); i++) {
                JSONObject r = (JSONObject)a.get(i);
                SessionResultDriverLap d = new SessionResultDriverLap();
                d.setLapNumber(getInt(r, "lapnum"));
                long lapTime = getLong(r, "time");
                d.setLapTime(lapTime - lastLapTime);
                lastLapTime = lapTime;
                d.setFlags(getInt(r, "flags"));
                lapList.add(d);
            }
            output.setLaps(lapList);
        } catch (ParseException ex) {
            Logger.getLogger(SessionResultDriverLapsParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}