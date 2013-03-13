package iracing.webapi;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class LicenseLevelParser extends JsonParserBase {
    
    public static void main(String[] args) {
        String s = "{\"22\":{\"groupId\":6,\"name\":\"Pro+%282.0%29\",\"id\":22,\"colorIndex\":240},\"23\":{\"groupId\":6,\"name\":\"Pro+%283.0%29\",\"id\":23,\"colorIndex\":240},\"24\":{\"groupId\":6,\"name\":\"Pro+%284.0%29\",\"id\":24,\"colorIndex\":240},\"25\":{\"groupId\":7,\"name\":\"Pro%2FWC+%281.0%29\",\"id\":25,\"colorIndex\":240},\"26\":{\"groupId\":7,\"name\":\"Pro%2FWC+%282.0%29\",\"id\":26,\"colorIndex\":240},\"27\":{\"groupId\":7,\"name\":\"Pro%2FWC+%283.0%29\",\"id\":27,\"colorIndex\":240},\"28\":{\"groupId\":7,\"name\":\"Pro%2FWC+%284.0%29\",\"id\":28,\"colorIndex\":240},\"10\":{\"groupId\":3,\"name\":\"Class+C+%282.0%29\",\"id\":10,\"colorIndex\":116},\"11\":{\"groupId\":3,\"name\":\"Class+C+%283.0%29\",\"id\":11,\"colorIndex\":116},\"12\":{\"groupId\":3,\"name\":\"Class+C+%284.0%29\",\"id\":12,\"colorIndex\":116},\"13\":{\"groupId\":4,\"name\":\"Class+B+%281.0%29\",\"id\":13,\"colorIndex\":86},\"14\":{\"groupId\":4,\"name\":\"Class+B+%282.0%29\",\"id\":14,\"colorIndex\":86},\"15\":{\"groupId\":4,\"name\":\"Class+B+%283.0%29\",\"id\":15,\"colorIndex\":86},\"16\":{\"groupId\":4,\"name\":\"Class+B+%284.0%29\",\"id\":16,\"colorIndex\":86},\"17\":{\"groupId\":5,\"name\":\"Class+A+%281.0%29\",\"id\":17,\"colorIndex\":107},\"18\":{\"groupId\":5,\"name\":\"Class+A+%282.0%29\",\"id\":18,\"colorIndex\":107},\"19\":{\"groupId\":5,\"name\":\"Class+A+%283.0%29\",\"id\":19,\"colorIndex\":107},\"1\":{\"groupId\":1,\"name\":\"Rookie+%281.0%29\",\"id\":1,\"colorIndex\":112},\"2\":{\"groupId\":1,\"name\":\"Rookie+%282.0%29\",\"id\":2,\"colorIndex\":112},\"3\":{\"groupId\":1,\"name\":\"Rookie+%283.0%29\",\"id\":3,\"colorIndex\":112},\"4\":{\"groupId\":1,\"name\":\"Rookie+%284.0%29\",\"id\":4,\"colorIndex\":112},\"5\":{\"groupId\":2,\"name\":\"Class+D+%281.0%29\",\"id\":5,\"colorIndex\":130},\"6\":{\"groupId\":2,\"name\":\"Class+D+%282.0%29\",\"id\":6,\"colorIndex\":130},\"7\":{\"groupId\":2,\"name\":\"Class+D+%283.0%29\",\"id\":7,\"colorIndex\":130},\"8\":{\"groupId\":2,\"name\":\"Class+D+%284.0%29\",\"id\":8,\"colorIndex\":130},\"9\":{\"groupId\":3,\"name\":\"Class+C+%281.0%29\",\"id\":9,\"colorIndex\":116},\"20\":{\"groupId\":5,\"name\":\"Class+A+%284.0%29\",\"id\":20,\"colorIndex\":107},\"21\":{\"groupId\":6,\"name\":\"Pro+%281.0%29\",\"id\":21,\"colorIndex\":240}}";
        List<LicenseLevel> levels = parse(s);
        for (LicenseLevel level : levels) {
            System.err.println(level.getName());
        }
    }
    
    static List<LicenseLevel> parse(String json) {
        //var licenseLevels = extractJSON('{"22":{"groupId":6,"name":"Pro+%282.0%29","id":22,"colorIndex":240},"23":{"groupId":6,"name":"Pro+%283.0%29","id":23,"colorIndex":240},"24":{"groupId":6,"name":"Pro+%284.0%29","id":24,"colorIndex":240},"25":{"groupId":7,"name":"Pro%2FWC+%281.0%29","id":25,"colorIndex":240},"26":{"groupId":7,"name":"Pro%2FWC+%282.0%29","id":26,"colorIndex":240},"27":{"groupId":7,"name":"Pro%2FWC+%283.0%29","id":27,"colorIndex":240},"28":{"groupId":7,"name":"Pro%2FWC+%284.0%29","id":28,"colorIndex":240},"10":{"groupId":3,"name":"Class+C+%282.0%29","id":10,"colorIndex":116},"11":{"groupId":3,"name":"Class+C+%283.0%29","id":11,"colorIndex":116},"12":{"groupId":3,"name":"Class+C+%284.0%29","id":12,"colorIndex":116},"13":{"groupId":4,"name":"Class+B+%281.0%29","id":13,"colorIndex":86},"14":{"groupId":4,"name":"Class+B+%282.0%29","id":14,"colorIndex":86},"15":{"groupId":4,"name":"Class+B+%283.0%29","id":15,"colorIndex":86},"16":{"groupId":4,"name":"Class+B+%284.0%29","id":16,"colorIndex":86},"17":{"groupId":5,"name":"Class+A+%281.0%29","id":17,"colorIndex":107},"18":{"groupId":5,"name":"Class+A+%282.0%29","id":18,"colorIndex":107},"19":{"groupId":5,"name":"Class+A+%283.0%29","id":19,"colorIndex":107},"1":{"groupId":1,"name":"Rookie+%281.0%29","id":1,"colorIndex":112},"2":{"groupId":1,"name":"Rookie+%282.0%29","id":2,"colorIndex":112},"3":{"groupId":1,"name":"Rookie+%283.0%29","id":3,"colorIndex":112},"4":{"groupId":1,"name":"Rookie+%284.0%29","id":4,"colorIndex":112},"5":{"groupId":2,"name":"Class+D+%281.0%29","id":5,"colorIndex":130},"6":{"groupId":2,"name":"Class+D+%282.0%29","id":6,"colorIndex":130},"7":{"groupId":2,"name":"Class+D+%283.0%29","id":7,"colorIndex":130},"8":{"groupId":2,"name":"Class+D+%284.0%29","id":8,"colorIndex":130},"9":{"groupId":3,"name":"Class+C+%281.0%29","id":9,"colorIndex":116},"20":{"groupId":5,"name":"Class+A+%284.0%29","id":20,"colorIndex":107},"21":{"groupId":6,"name":"Pro+%281.0%29","id":21,"colorIndex":240}}');
        JSONParser parser = new JSONParser();
        List<LicenseLevel> output = null;
        try {
            JSONObject root = (JSONObject)parser.parse(json);
            output = new ArrayList<LicenseLevel>();
            for (Object key : root.keySet()) {
                LicenseLevel ll = new LicenseLevel();
                JSONObject o = (JSONObject)root.get(key);
                ll.setLicenseGroupId(getInt(o, "groupId"));
                ll.setName(getString(o, "name", true));
                ll.setId(getInt(o, "id"));
                output.add(ll);
            }
        } catch (ParseException ex) {
            Logger.getLogger(LicenseLevelParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}