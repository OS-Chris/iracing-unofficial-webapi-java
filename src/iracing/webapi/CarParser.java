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
public class CarParser extends JsonParserBase {
    
    public static List<Car> parse(String json) {
        JSONParser parser = new JSONParser();
        List<Car> output = null;
        try {
            JSONArray root = (JSONArray)parser.parse(json);
            output = new ArrayList<Car>();
            for (int i = 0; i < root.size(); i++) {
                JSONObject o = (JSONObject)root.get(i);
                Car car = new Car();
                car.setDefaultImage(getString(o, "defaultimg", true));
                car.setPackageId(getInt(o, "pkgid"));
                car.setId(getInt(o, "id"));
                car.setForumId(getLong(o, "forumID"));
                car.setSku(getLong(o, "sku"));
                car.setSkuName(getString(o, "skuname", true));
                car.setName(getString(o, "name", true));
                car.setAbbreviatedName(getString(o, "abbrevname", true));
                car.setFolderName(getString(o, "dirpath"));
                car.setPrice(getDouble(o, "price"));
                car.setPriceDisplay(getString(o, "priceDisplay"));
                output.add(car);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CarParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}