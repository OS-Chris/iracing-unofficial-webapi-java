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
public class TrackParser extends JsonParserBase {
    
    public static List<Track> parse(String json) {
        JSONParser parser = new JSONParser();
        List<Track> output = null;
        try {
            //[{"config":"Legends+Oval","priority":3,"pkgid":36,"skuname":"Atlanta+Motor+Speedway","retired":0,"price":14.95,"hasNightLighting":false,"name":"Atlanta+Motor+Speedway","lowername":"atlanta+motor+speedway","nominalLapTime":15.5574207,"lowerNameAndConfig":"atlanta+motor+speedway+legends+oval","catid":1,"priceDisplay":"14.95","id":52,"sku":10039},{"config":"Road+Course","priority":2,"pkgid":36,"skuname":"Atlanta+Motor+Speedway","retired":0,"price":14.95,"hasNightLighting":false,"name":"Atlanta+Motor+Speedway","lowername":"atlanta+motor+speedway","nominalLapTime":82.5555344,"lowerNameAndConfig":"atlanta+motor+speedway+road+course","catid":2,"priceDisplay":"14.95","id":51,"sku":10039}]
            JSONArray root = (JSONArray)parser.parse(json);
            output = new ArrayList<Track>();
            for (int i = 0; i < root.size(); i++) {
                JSONObject o = (JSONObject)root.get(i);
                Track track = new Track();
                track.setId(getInt(o, "id"));
                track.setPackageId(getInt(o, "pkgid"));
                track.setCategoryId(getInt(o, "catid"));
                track.setPriority(getInt(o, "priority"));
                track.setSku(getLong(o, "sku"));
                track.setSkuName(getString(o, "skuname", true));
                track.setRetired((getInt(o, "retired")) == 1);
                track.setName(getString(o, "name", true));
                track.setConfigName(getString(o, "config", true));
                track.setHasNightLighting((Boolean)o.get("hasNightLighting"));
                track.setPrice(getDouble(o, "price"));
                track.setPriceDisplay(getString(o, "priceDisplay"));
                track.setNominalLapTime(getDouble(o, "nominalLapTime"));
                output.add(track);
            }
        } catch (ParseException ex) {
            Logger.getLogger(LicenseParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}