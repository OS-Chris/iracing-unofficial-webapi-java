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
 */
public class EventTypeParser extends JsonParserBase {
    
    public static void main(String[] args) {
        String s = "[{id:1,full:\"Test\",short:\"T\"},{id:2,full:\"Practice\",short:\"P\"},{id:3,full:\"Qualify\",short:\"Q\"},{id:5,full:\"Race\",short:\"R\"},{id:4,full:\"Time Trial\",short:\"TT\"}]";
        List<EventType> eventTypes = parse(s);
        for (EventType eventType : eventTypes) {
            System.err.println(eventType.getId() + " : " + eventType.getName());
        }
    }
    
    public static List<EventType> parse(String json) {
        JSONParser parser = new JSONParser();
        //[{id:1,full:"Test",short:"T"},{id:2,full:"Practice",short:"P"},{id:3,full:"Qualify",short:"Q"},{id:5,full:"Race",short:"R"},{id:4,full:"Time Trial",short:"TT"}]
        String s = json.replace("{id:", "{\"id\":");
        s = s.replace(",full:", ",\"full\":");
        s = s.replace(",short:", ",\"short\":");
        List<EventType> output = null;
        try {
            JSONArray arrayRoot = (JSONArray)parser.parse(s);
            output = new ArrayList<EventType>();
            for (int i = 0; i < arrayRoot.size(); i++) {
                JSONObject o = (JSONObject)arrayRoot.get(i);
                EventType et = new EventType();
                et.setId(getInt(o, "id"));
                et.setAbbreviation(getString(o, "short"));
                et.setName(getString(o, "full"));
                output.add(et);
            }
        } catch (ParseException ex) {
            Logger.getLogger(EventTypeParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}