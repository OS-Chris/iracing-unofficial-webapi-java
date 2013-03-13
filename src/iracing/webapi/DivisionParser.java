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
public class DivisionParser extends JsonParserBase {
    
    static List<Division> parse(String json) {
        JSONParser parser = new JSONParser();
        List<Division> output = null;
        try {
            //var DivisionListing = extractJSON('[{"shortdivname":"Division+1","id":0},{"shortdivname":"Division+2","id":1},{"shortdivname":"Division+3","id":2},{"shortdivname":"Division+4","id":3},{"shortdivname":"Division+5","id":4},{"shortdivname":"Division+6","id":5},{"shortdivname":"Division+7","id":6},{"shortdivname":"Division+8","id":7},{"shortdivname":"Division+9","id":8},{"shortdivname":"Division+10","id":9},{"shortdivname":"R","id":10}]');
            JSONArray rootArray = (JSONArray)parser.parse(json);
            output = new ArrayList<Division>();
            for (int i = 0; i < rootArray.size(); i++) {
                JSONObject r = (JSONObject)rootArray.get(i);
                Division d = new Division();
                d.setShortName(getString(r, "shortdivname", true));
                d.setId(getInt(r, "id"));
                output.add(d);
            }
        } catch (ParseException ex) {
            Logger.getLogger(DivisionParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}