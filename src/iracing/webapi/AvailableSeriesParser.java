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
public class AvailableSeriesParser extends JsonParserBase {
    
    static List<AvailableSeries> parse(String json) {
        JSONParser parser = new JSONParser();
        List<AvailableSeries> output = null;
        try {
            JSONArray root = (JSONArray)parser.parse(json);
            output = new ArrayList<AvailableSeries>();
            for (int i = 0; i < root.size(); i++) {
                JSONObject o = (JSONObject)root.get(i);
                AvailableSeries as = new AvailableSeries();
                as.setSeriesName(getString(o, "seriesname", true));
                as.setApiUserEligible((Boolean)o.get("eligible"));
                as.setCategoryId(getInt(o, "category"));
                as.setSeasonId(getInt(o, "seasonid"));
                output.add(as);
            }
        } catch (ParseException ex) {
            Logger.getLogger(AvailableSeriesParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}