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
public class CarClassParser extends JsonParserBase {
    
    public static List<CarClass> parse(String json) {
        JSONParser parser = new JSONParser();
        List<CarClass> output = null;
        try {
            //{"carsinclass":[{"name":"Modified+-+Tour","id":31}],"shortname":"Tour+Modified","name":"Tour+Modified","id":29,"lowername":"tour+modified"}
            JSONArray root = (JSONArray)parser.parse(json);
            output = new ArrayList<CarClass>();
            for (int i = 0; i < root.size(); i++) {
                JSONObject o = (JSONObject)root.get(i);
                CarClass cc = new CarClass();
                JSONArray cic = (JSONArray)o.get("carsinclass");
                List<Integer> carsInClass = new ArrayList<Integer>();
                for (int j = 0; j < cic.size(); j++) {
                    JSONObject o2 = (JSONObject)cic.get(j);
                    carsInClass.add(getInt(o2, "id"));
                }
                cc.setId(getInt(o, "id"));
                cc.setShortName(getString(o, "shortname", true));
                cc.setName(getString(o, "name", true));
                cc.setIdsOfCarsInClass(carsInClass);
                output.add(cc);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CarClassParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}