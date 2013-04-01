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
public class LicenseParser extends JsonParserBase {
    
    public static List<License> parse(String json) {
        JSONParser parser = new JSONParser();
        List<License> output = null;
        try {
            JSONArray root = (JSONArray)parser.parse(json);
            output = new ArrayList<License>();
            for (int i = 0; i < root.size(); i++) {
                JSONObject o = (JSONObject)root.get(i);
                License license = new License();
                license.setId(getInt(o, "id"));
                license.setShortName(getString(o, "shortname"));
                license.setFullName(getString(o, "name", true));
                output.add(license);
            }
        } catch (ParseException ex) {
            Logger.getLogger(LicenseParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}