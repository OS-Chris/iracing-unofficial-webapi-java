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
public class YearAndQuartersParser extends JsonParserBase {
    
    public static List<YearAndQuarters> parse(String json) {
        JSONParser parser = new JSONParser();
        List<YearAndQuarters> output = null;
        try {
            JSONArray root = (JSONArray)parser.parse(json);
            output = new ArrayList<YearAndQuarters>();
            for (int i = 0; i < root.size(); i++) {
                YearAndQuarters yearAndQuarter = new YearAndQuarters();
                JSONObject r = (JSONObject)root.get(i);
                yearAndQuarter.setYear(getInt(r, "year"));
                JSONArray quarters = (JSONArray)r.get("quarters");
                List<YearAndQuarters.Quarter> quarterList = new ArrayList<YearAndQuarters.Quarter>();
                for (int j = 0; j < quarters.size(); j++) {
                    JSONObject o = (JSONObject)quarters.get(j);
                    YearAndQuarters.Quarter quarter = new YearAndQuarters.Quarter();
                    quarter.setId(getInt(o, "quarterid"));
                    quarter.setNumberOfWeeks(getInt(o, "numweeks"));
                    JSONArray seasons = (JSONArray)o.get("seasons");
                    List<Integer> seasonList = new ArrayList<Integer>();
                    for (int k = 0; k < seasons.size(); k++) {
                        seasonList.add(((Long)seasons.get(k)).intValue());
                    }
                    quarter.setSeasons(seasonList);
                    quarterList.add(quarter);
                }
                yearAndQuarter.setQuarters(quarterList);
                output.add(yearAndQuarter);
            }
        } catch (ParseException ex) {
            Logger.getLogger(YearAndQuartersParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}