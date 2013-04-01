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
public class LicenseGroupParser extends JsonParserBase {
    
    public static List<LicenseGroup> parse(String json) {
        JSONParser parser = new JSONParser();
        List<LicenseGroup> output = null;
        try {
            JSONArray rootArray = (JSONArray)parser.parse(json);
            output = new ArrayList<LicenseGroup>();
            for (int i = 0; i < rootArray.size(); i++) {
                JSONObject r = (JSONObject)rootArray.get(i);
                LicenseGroup lg = new LicenseGroup();
                lg.setId(getInt(r, "group"));
                lg.setName(getString(r, "name", true));
                // NOTE: the following aren't specified if not applicable
                Object o = r.get("minNumTT");
                if (o != null) lg.setMinimumNumberOfTimeTrials(((Long)o).intValue());
                o = r.get("minNumRaces");
                if (o != null) lg.setMinimumNumberOfRaces(((Long)o).intValue());
                output.add(lg);
            }
        } catch (ParseException ex) {
            Logger.getLogger(LicenseGroupParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}