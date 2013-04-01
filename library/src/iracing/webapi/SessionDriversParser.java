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
class SessionDriversParser extends JsonParserBase {
    
    public static SessionDrivers parse(String json) {
        //{"subsessionid":5878565,"requestindex":0,"rows":[{"di":1,"dn":"David+Ruberti","p":17,"c1":255,"c2":156,"c3":141,"ll":15,"cc":18,"carid":21,"custid":46289},{"di":2,"dn":"Anthony+D+Ruberti","p":40,"c1":240,"c2":90,"c3":255,"ll":14,"cc":18,"carid":21,"custid":40014},{"di":3,"dn":"Wayne+Funston","p":25,"c1":124,"c2":148,"c3":143,"ll":16,"cc":18,"carid":21,"custid":34775},{"di":4,"dn":"Sam+Clark","p":28,"c1":54,"c2":240,"c3":213,"ll":11,"cc":18,"carid":21,"custid":80510},{"di":5,"dn":"Matt+Baker","p":9,"c1":240,"c2":112,"c3":116,"ll":14,"cc":18,"carid":21,"custid":20463},{"di":6,"dn":"Chase+O%27%27Brien","p":55,"c1":240,"c2":132,"c3":137,"ll":7,"cc":18,"carid":21,"custid":60168},{"di":7,"dn":"Phillip+Krutz","p":34,"c1":61,"c2":89,"c3":123,"ll":19,"cc":18,"carid":21,"custid":29716},{"di":8,"dn":"Timothy+Dennis","p":3,"c1":224,"c2":108,"c3":96,"ll":9,"cc":28,"carid":30,"custid":48873},{"di":9,"dn":"George+Mccourt","p":1,"c1":255,"c2":255,"c3":255,"ll":20,"cc":18,"carid":21,"custid":32060},{"di":10,"dn":"Andre+Castro","p":65,"c1":96,"c2":14,"c3":247,"ll":11,"cc":18,"carid":21,"custid":83741},{"di":11,"dn":"Eduardo+Beninca","p":12,"c1":80,"c2":253,"c3":148,"ll":14,"cc":18,"carid":21,"custid":42177},{"di":12,"dn":"James+Stone","p":43,"c1":255,"c2":127,"c3":240,"ll":10,"cc":28,"carid":30,"custid":76461},{"di":13,"dn":"Frank+Milowicki","p":41,"c1":92,"c2":108,"c3":123,"ll":19,"cc":18,"carid":21,"custid":24371},{"di":14,"dn":"Jason+Noel","p":63,"c1":240,"c2":124,"c3":255,"ll":6,"cc":28,"carid":30,"custid":32421}]}
        SessionDrivers output = null;
        JSONParser parser = new JSONParser();
        try {
            JSONObject root = (JSONObject)parser.parse(json);
            output = new SessionDrivers();
            output.setSubSessionId(getLong(root, "subsessionid"));
            JSONArray rows = (JSONArray)root.get("rows");
            List<SessionDriver> drivers = new ArrayList<SessionDriver>();
            for (int i = 0; i < rows.size(); i++) {
                JSONObject row = (JSONObject)rows.get(i);
                SessionDriver driver = new SessionDriver();
                driver.setCustomerId(getLong(row, "custid"));
                driver.setName(getString(row, "dn", true));
                driver.setCarId(getInt(row, "carid"));
                drivers.add(driver);
            }
            output.setDrivers(drivers);
        } catch (ParseException ex) {
            Logger.getLogger(SessionDriversParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}