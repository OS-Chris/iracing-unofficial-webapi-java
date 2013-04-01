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
public class HardcoreOptionParser extends JsonParserBase {
    
    static List<HardcoreOption> parse(String json) {
        //var hardcoreOptions = extractJSON('[{"lookup_name":"Disable+all+driving+aids+%28but+clutch+assist+OK%29","lookup_value":"0","lookup_type":"HARDCORE_MODE"},{"lookup_name":"Enable+all+driving+aids","lookup_value":"1","lookup_type":"HARDCORE_MODE"},{"lookup_name":"Allow+all+driving+aids%2C+plus+relaxed+camera+views","lookup_value":"3","lookup_type":"HARDCORE_MODE"}]');
        JSONParser parser = new JSONParser();
        List<HardcoreOption> output = null;
        try {
            JSONArray rootArray = (JSONArray)parser.parse(json);
            output = new ArrayList<HardcoreOption>();
            for (int i = 0; i < rootArray.size(); i++) {
                JSONObject r = (JSONObject)rootArray.get(i);
                HardcoreOption d = new HardcoreOption();
                d.setId(getInt(r, "lookup_value"));
                d.setName(getString(r, "lookup_name", true));
                output.add(d);
            }
        } catch (ParseException ex) {
            Logger.getLogger(DivisionParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}