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
public class SeasonQualifyingResultParser extends JsonParserBase {
    
    public interface ItemHandler {
        public boolean onSeasonQualifyingResultParsed(SeasonQualifyingResult result);
    }
    
    public static class ListItemHandler implements ItemHandler {
        
        private List<SeasonQualifyingResult> list;
        
        public ListItemHandler() {
            list = new ArrayList<SeasonQualifyingResult>();
        }

        public List<SeasonQualifyingResult> getList() {
            return list;
        }
        
        @Override
        public boolean onSeasonQualifyingResultParsed(SeasonQualifyingResult result) {
            list.add(result);
            return true;
        }
        
    }
    
    private ItemHandler itemHandler;
    
    public SeasonQualifyingResultParser() {}

    public static void main(String[] args) {
        String s = "{\"m\":{\"1\":\"bestqualtime\",\"2\":\"sublevel\",\"3\":\"custrow\",\"4\":\"maxlicenselevel\",\"5\":\"rank\",\"6\":\"helmcolor1\",\"7\":\"displayname\",\"8\":\"helmcolor2\",\"9\":\"division\",\"10\":\"custid\",\"11\":\"helmcolor3\",\"12\":\"clubid\",\"13\":\"helmpattern\",\"14\":\"pos\",\"15\":\"rowcount\",\"16\":\"bestqualtimeformatted\",\"17\":\"rn\"},\"d\":{\"3\":\"-1\",\"15\":6,\"r\":[{\"1\":1465493,\"2\":\"+2.36\",\"4\":18,\"5\":1,\"6\":255,\"7\":\"Mitchell+Abrahall\",\"8\":118,\"9\":1,\"10\":25765,\"11\":108,\"12\":34,\"13\":62,\"14\":1,\"16\":\"2%3A26.549\",\"17\":1},{\"1\":1490441,\"2\":\"+3.43\",\"4\":15,\"5\":2,\"6\":255,\"7\":\"John+Briggs\",\"8\":255,\"9\":5,\"10\":73770,\"11\":255,\"12\":34,\"13\":12,\"14\":2,\"16\":\"2%3A29.044\",\"17\":2},{\"1\":1496234,\"2\":\"+4.51\",\"4\":16,\"5\":3,\"6\":255,\"7\":\"Stephen+Jenkins\",\"8\":96,\"9\":3,\"10\":68792,\"11\":112,\"12\":34,\"13\":22,\"14\":3,\"16\":\"2%3A29.623\",\"17\":3},{\"1\":1502289,\"2\":\"+3.45\",\"4\":14,\"5\":4,\"6\":240,\"7\":\"Dirk+Benecke\",\"8\":130,\"9\":1,\"10\":84055,\"11\":255,\"12\":42,\"13\":63,\"14\":4,\"16\":\"2%3A30.228\",\"17\":4},{\"1\":1513869,\"2\":\"+2.73\",\"4\":10,\"5\":5,\"6\":44,\"7\":\"Wayne+Stroh\",\"8\":240,\"9\":3,\"10\":88615,\"11\":185,\"12\":34,\"13\":56,\"14\":5,\"16\":\"2%3A31.386\",\"17\":5},{\"1\":1548511,\"2\":\"+2.61\",\"4\":17,\"5\":6,\"6\":80,\"7\":\"Kyle+Young\",\"8\":249,\"9\":2,\"10\":72798,\"11\":240,\"12\":14,\"13\":21,\"14\":6,\"16\":\"2%3A34.851\",\"17\":6}]}}";
        ListItemHandler lih = new ListItemHandler();
        long totalRecords = parse(s, lih);
        for (SeasonQualifyingResult result : lih.getList()) {
            System.err.println(result.getDriverName() + " (" + result.getBestQualifyingTimeFormatted() + ")");
        }
        System.err.println("TOTAL RECORDS : " + totalRecords);
    }
    
    public ItemHandler getItemHandler() {
        return itemHandler;
    }

    public void setItemHandler(ItemHandler itemHandler) {
        this.itemHandler = itemHandler;
    }
    
    public long parse(String json) {
        return parse(json, itemHandler);
    }
    
    public static long parse(String json, ItemHandler handler) {
        JSONParser parser = new JSONParser();
        long output = 0;
        try {
            JSONObject root = (JSONObject)parser.parse(json);
            //{"m":{"1":"bestqualtime","2":"sublevel","3":"custrow","4":"maxlicenselevel","5":"rank","6":"helmcolor1","7":"displayname","8":"helmcolor2","9":"division","10":"custid","11":"helmcolor3","12":"clubid","13":"helmpattern","14":"pos","15":"rowcount","16":"bestqualtimeformatted","17":"rn"},"d":{"3":"-1","15":6,"r":[{"1":1465493,"2":"+2.36","4":18,"5":1,"6":255,"7":"Mitchell+Abrahall","8":118,"9":1,"10":25765,"11":108,"12":34,"13":62,"14":1,"16":"2%3A26.549","17":1},{"1":1490441,"2":"+3.43","4":15,"5":2,"6":255,"7":"John+Briggs","8":255,"9":5,"10":73770,"11":255,"12":34,"13":12,"14":2,"16":"2%3A29.044","17":2},{"1":1496234,"2":"+4.51","4":16,"5":3,"6":255,"7":"Stephen+Jenkins","8":96,"9":3,"10":68792,"11":112,"12":34,"13":22,"14":3,"16":"2%3A29.623","17":3},{"1":1502289,"2":"+3.45","4":14,"5":4,"6":240,"7":"Dirk+Benecke","8":130,"9":1,"10":84055,"11":255,"12":42,"13":63,"14":4,"16":"2%3A30.228","17":4},{"1":1513869,"2":"+2.73","4":10,"5":5,"6":44,"7":"Wayne+Stroh","8":240,"9":3,"10":88615,"11":185,"12":34,"13":56,"14":5,"16":"2%3A31.386","17":5},{"1":1548511,"2":"+2.61","4":17,"5":6,"6":80,"7":"Kyle+Young","8":249,"9":2,"10":72798,"11":240,"12":14,"13":21,"14":6,"16":"2%3A34.851","17":6}]}}
            Object o = root.get("d");
            if (o instanceof JSONObject) {
                JSONObject d = (JSONObject)o;
                output = getLong(d, "15");
                JSONArray arrayRoot = (JSONArray)d.get("r");
                for (int i = 0; i < arrayRoot.size(); i++) {
                    JSONObject r = (JSONObject)arrayRoot.get(i);
                    SeasonQualifyingResult result = new SeasonQualifyingResult();
                    result.setBestQualifyingTime(getLong(r, "1"));
                    result.setLicenseSubLevel(getString(r, "2"));
                    result.setMaxLicenseLevel(getInt(r, "4"));
                    result.setRank(getInt(r, "5"));
                    result.setDriverName(getString(r, "7", true));
                    result.setDivision(getInt(r, "9"));
                    result.setDriverCustomerId(getLong(r, "10"));
                    result.setClubId(getInt(r, "12"));
                    result.setPosition(getLong(r, "14"));
                    result.setBestQualifyingTimeFormatted(getString(r, "16", true));
                    handler.onSeasonQualifyingResultParsed(result);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(SeasonQualifyingResultParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}