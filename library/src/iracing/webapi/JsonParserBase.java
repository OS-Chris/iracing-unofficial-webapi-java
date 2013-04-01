package iracing.webapi;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
class JsonParserBase {
    
    
    protected static String getString(JSONObject object, String key) {
        return getString(object, key, false);
    }
    
    protected static String getString(JSONObject object, String key, boolean urlDecode) {
        String s = String.valueOf(object.get(key));
        if (urlDecode) {
            try {
                s = URLDecoder.decode(s, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SessionResultSummaryParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return s;
    }
    
    protected static double getDouble(JSONObject object, String key) {
        Object o = object.get(key);
        if (o instanceof String) {
            String s = (String)object.get(key);
            if (!"".equals(s)) return Double.parseDouble(s);
            else return 0d;
        } else if (o instanceof Double) {
            return (Double)o;
        } else if (o instanceof Long) {
            return Double.parseDouble(String.valueOf((Long)o));
        }
        return 0d;
    }
    
    protected static int getInt(JSONObject object, String key) {
        Object o = object.get(key);
        if (o instanceof String) {
            if (((String)o).equals("")) return 0;
            else return Integer.parseInt((String)o);
        } else {
            long l = (Long)object.get(key);
            return (int)l;
        }
    }
    
    protected static long getLong(JSONObject object, String key) {
        Object o = object.get(key);
        if (o instanceof String) {
            if (((String)o).equals("")) return 0;
            else return Integer.parseInt((String)o);
        } else {
            return (Long)object.get(key);
        }
    }
    
}