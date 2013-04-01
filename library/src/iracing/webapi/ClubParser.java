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
public class ClubParser extends JsonParserBase {
    
    static List<Club> parse(String json) {
        //var ClubListing = extractJSON('[{"id":18,"shortclubname":"Atlantic"},{"id":34,"shortclubname":"Australia%2FNZ"},{"id":40,"shortclubname":"Benelux"},{"id":45,"shortclubname":"Brazil"},{"id":6,"shortclubname":"California"},{"id":25,"shortclubname":"Carolina"},{"id":37,"shortclubname":"Celtic"},{"id":10,"shortclubname":"Central+US"},{"id":46,"shortclubname":"Central-Eastern+Europe"},{"id":13,"shortclubname":"Connecticut"},{"id":42,"shortclubname":"DE-AT-CH"},{"id":15,"shortclubname":"Eastern+Canada"},{"id":36,"shortclubname":"England"},{"id":44,"shortclubname":"Finland"},{"id":22,"shortclubname":"Florida"},{"id":39,"shortclubname":"France"},{"id":21,"shortclubname":"Georgia"},{"id":31,"shortclubname":"Plains"},{"id":24,"shortclubname":"Hispanoam%C3%A9rica"},{"id":38,"shortclubname":"Iberia"},{"id":26,"shortclubname":"Illinois"},{"id":27,"shortclubname":"Indiana"},{"id":1,"shortclubname":"International"},{"id":41,"shortclubname":"Italy"},{"id":11,"shortclubname":"Massachusetts"},{"id":28,"shortclubname":"Michigan"},{"id":5,"shortclubname":"Mid-Atlantic+US"},{"id":23,"shortclubname":"Mid-South"},{"id":29,"shortclubname":"Midwest"},{"id":8,"shortclubname":"Midwest+US"},{"id":12,"shortclubname":"New+England"},{"id":19,"shortclubname":"New+Jersey"},{"id":14,"shortclubname":"New+York"},{"id":3,"shortclubname":"Northeast+US"},{"id":33,"shortclubname":"Northwest"},{"id":20,"shortclubname":"Ohio"},{"id":16,"shortclubname":"Pennsylvania"},{"id":43,"shortclubname":"Scandinavia"},{"id":7,"shortclubname":"South+US"},{"id":2,"shortclubname":"Southeast+US"},{"id":30,"shortclubname":"Texas"},{"id":17,"shortclubname":"Virginias"},{"id":32,"shortclubname":"West"},{"id":9,"shortclubname":"West+Europe"},{"id":4,"shortclubname":"West+US"},{"id":35,"shortclubname":"Western+Canada"}]');
        JSONParser parser = new JSONParser();
        List<Club> output = null;
        try {
            JSONArray rootArray = (JSONArray)parser.parse(json);
            output = new ArrayList<Club>();
            for (int i = 0; i < rootArray.size(); i++) {
                JSONObject r = (JSONObject)rootArray.get(i);
                Club d = new Club();
                d.setId(getInt(r, "id"));
                d.setShortName(getString(r, "shortclubname", true));
                output.add(d);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ClubParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}