package iracing.webapi;

import java.util.ArrayList;
import java.util.Date;
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
public class PrivateMessageJson extends JsonParserBase {
    
    private static String KEY_ID = "id";
    private static String KEY_DATETIME = "datetime";
    private static String KEY_FROM = "from";
    private static String KEY_TO = "to";
    private static String KEY_NAME = "name";
    private static String KEY_SUBJECT = "subject";
    private static String KEY_MESSAGE = "message";
    
    public static List<PrivateMessage> read(String json) {
        JSONParser parser = new JSONParser();
        Object o = null;
        try {
            o = parser.parse(json);
        } catch (ParseException ex) {
            Logger.getLogger(PrivateMessageJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<PrivateMessage> output = new ArrayList<PrivateMessage>();
        if (o instanceof JSONArray) {
            JSONArray array = (JSONArray)o;
            for (int i = 0; i < array.size(); i++) {
                Object o2 = array.get(i);
                if (o2 instanceof JSONObject) {
                    JSONObject pm1 = (JSONObject)o2;
                    PrivateMessage pm = new PrivateMessage();
                    pm.setId(getLong(pm1, KEY_ID));
                    // datetime is stored as unix time (seconds since epoch) so we need to convert it to milliseconds for java
                    long l = getLong(pm1, KEY_DATETIME) * 1000;
                    pm.setDate(new Date(l));
                    JSONObject o3 = (JSONObject)pm1.get(KEY_FROM);
                    pm.setFrom(new IracingCustomer(getLong(o3, KEY_ID), getString(o3, KEY_NAME)));
                    o3 = (JSONObject)pm1.get(KEY_TO);
                    pm.setTo(new IracingCustomer(getLong(o3, KEY_ID), getString(o3, KEY_NAME)));
                    pm.setSubject(getString(pm1, KEY_SUBJECT));
                    pm.setMessage(getString(pm1, KEY_MESSAGE));
                    output.add(pm);
                }
            }
        }
        return output;
    }
    
    public static String write(List<PrivateMessage> pms) {
        // NOTE: not using org.json.simple toString() because there is no control over what order attributes are written
//        JSONArray array = new JSONArray();
//        for (PrivateMessage pm : pms) {
//            JSONObject o = new JSONObject();
//            o.put(KEY_ID, pm.getId());
//            o.put(KEY_DATETIME, pm.getDate().getTime());
//            o.put(KEY_FROM, toJsonObject(pm.getFrom()));
//            o.put(KEY_TO, toJsonObject(pm.getTo()));
//            o.put(KEY_SUBJECT, pm.getSubject());
//            o.put(KEY_MESSAGE, pm.getMessage());
//            array.add(o);
//        }
//        return array.toJSONString();
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < pms.size(); i++) {
            PrivateMessage pm = pms.get(i);
            if (i > 0) sb.append(',');
            sb.append('{');
            sb.append("\"").append(KEY_ID).append("\":").append(pm.getId()).append(',');
            // store the datetime as unix time (seconds since epoch) so we need to convert it from milliseconds
            long l = pm.getDate().getTime() / 1000;
            sb.append("\"").append(KEY_DATETIME).append("\":").append(l).append(',');
            sb.append("\"").append(KEY_FROM).append("\":");
            toJsonObject(sb, pm.getFrom());
            sb.append(',');
            sb.append("\"").append(KEY_TO).append("\":");
            toJsonObject(sb, pm.getTo());
            sb.append(',');
            sb.append("\"").append(KEY_SUBJECT).append("\":\"").append(pm.getSubject()).append('"');
            if (pm.getMessage() == null) {
                sb.append('}');
            } else {
                sb.append(",\"").append(KEY_MESSAGE).append("\":\"").append(pm.getMessage()).append("\"}");
            }
        }
        return sb.append(']').toString();
    }
    
//    private static final JSONObject toJsonObject(IracingCustomer customer) {
//        JSONObject o = new JSONObject();
//        o.put(KEY_ID, customer.getId());
//        o.put(KEY_NAME, customer.getName());
//        return o;
//    }
    
    private static void toJsonObject(StringBuilder sb, IracingCustomer customer) {
        sb.append("{\"").append(KEY_ID).append("\":").append(customer.getId());
        sb.append(",\"").append(KEY_NAME).append("\":\"").append(customer.getName()).append("\"}");
    }
    
}