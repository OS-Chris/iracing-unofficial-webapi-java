package iracing.webapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
class SessionResultSummaryParser extends JsonParserBase {
    
    public interface ItemHandler {
        public boolean onSessionResultSummaryParsed(SessionResultSummary summary);
    }
    
    public static class ListItemHandler implements ItemHandler {
        
        private List<SessionResultSummary> list;
        
        public ListItemHandler() {
            list = new ArrayList<SessionResultSummary>();
        }

        public List<SessionResultSummary> getList() {
            return list;
        }
        
        @Override
        public boolean onSessionResultSummaryParsed(SessionResultSummary summary) {
            list.add(summary);
            return true;
        }
        
    }
    
    private ItemHandler itemHandler;
    
    public SessionResultSummaryParser() {}

    public ItemHandler getItemHandler() {
        return itemHandler;
    }

    public void setItemHandler(ItemHandler itemHandler) {
        this.itemHandler = itemHandler;
    }
    
    public void parse(String json) {
        parse(json, itemHandler);
    }
    
    public static void main(String[] args) {
        String s = "{\"m\":{\"1\":\"champpointssort\",\"2\":\"raw_start_time\",\"3\":\"bestlaptime\",\"4\":\"start_time\",\"5\":\"groupname\",\"6\":\"helm_pattern\",\"7\":\"season_year\",\"8\":\"clubpoints\",\"9\":\"subsession_bestlaptime\",\"10\":\"evttype\",\"11\":\"winnerlicenselevel\",\"12\":\"strengthoffield\",\"13\":\"dropracepoints\",\"14\":\"finishedat\",\"15\":\"trackid\",\"16\":\"winnercustid\",\"17\":\"custid\",\"18\":\"winnerdisplayname\",\"19\":\"sessionid\",\"20\":\"clubpointssort\",\"21\":\"rn\",\"22\":\"seasonid\",\"23\":\"carclassid\",\"24\":\"helm_licenselevel\",\"25\":\"starting_position\",\"26\":\"officialsession\",\"27\":\"displayname\",\"28\":\"helm_color1\",\"29\":\"season_quarter\",\"30\":\"helm_color2\",\"31\":\"helm_color3\",\"32\":\"seriesid\",\"33\":\"bestquallaptime\",\"34\":\"licensegroup\",\"35\":\"incidents\",\"36\":\"champpoints\",\"37\":\"race_week_num\",\"38\":\"start_date\",\"39\":\"winnerhelmcolor1\",\"40\":\"winnerhelmcolor2\",\"41\":\"winnerhelmcolor3\",\"42\":\"carid\",\"43\":\"subsessionid\",\"44\":\"catid\",\"45\":\"winnerhelmpattern\",\"46\":\"rowcount\",\"47\":\"finishing_position\"},\"d\":{\"46\":83,\"r\":[{\"1\":-1,\"2\":1335438000000,\"3\":\"48.012\",\"4\":\"11%3A00am\",\"5\":\"Rookie\",\"6\":48,\"7\":2012,\"8\":0,\"9\":\"47.642\",\"10\":5,\"11\":20,\"12\":1430,\"13\":\"\",\"14\":1335439816000,\"15\":116,\"16\":29462,\"17\":29462,\"18\":\"Christian+Aylward\",\"19\":24324999,\"20\":0,\"21\":1,\"22\":627,\"23\":19,\"24\":20,\"25\":5,\"26\":0,\"27\":\"Christian+Aylward\",\"28\":111,\"29\":1,\"30\":255,\"31\":127,\"32\":116,\"33\":\"\",\"34\":1,\"35\":0,\"36\":\"\",\"37\":12,\"38\":\"2012.04.26\",\"39\":111,\"40\":255,\"41\":127,\"42\":22,\"43\":5498908,\"44\":1,\"45\":48,\"47\":1},{\"1\":-1,\"2\":1335433174000,\"3\":\"\",\"4\":\"09%3A39am\",\"5\":\"Rookie\",\"6\":48,\"7\":2012,\"8\":0,\"9\":\"47.455\",\"10\":2,\"11\":14,\"12\":1386,\"13\":\"\",\"14\":1335440592000,\"15\":116,\"16\":23747,\"17\":29462,\"18\":\"Owen+Kelly\",\"19\":24324964,\"20\":0,\"21\":2,\"22\":627,\"23\":19,\"24\":20,\"25\":10,\"26\":0,\"27\":\"Christian+Aylward\",\"28\":111,\"29\":1,\"30\":255,\"31\":127,\"32\":116,\"33\":\"\",\"34\":1,\"35\":0,\"36\":\"\",\"37\":12,\"38\":\"2012.04.26\",\"39\":112,\"40\":118,\"41\":240,\"42\":22,\"43\":5498795,\"44\":1,\"45\":49,\"47\":28},{\"1\":-1,\"2\":1335090559000,\"3\":\"53.574\",\"4\":\"10%3A29am\",\"5\":\"Class+D\",\"6\":48,\"7\":2012,\"8\":\"\",\"9\":\"53.217\",\"10\":2,\"11\":15,\"12\":3556,\"13\":\"\",\"14\":1335095023000,\"15\":142,\"16\":73424,\"17\":29462,\"18\":\"Robert+Hope\",\"19\":24279490,\"20\":-1,\"21\":3,\"22\":604,\"23\":1,\"24\":20,\"25\":2,\"26\":1,\"27\":\"Christian+Aylward\",\"28\":111,\"29\":1,\"30\":255,\"31\":127,\"32\":34,\"33\":\"\",\"34\":2,\"35\":7,\"36\":\"\",\"37\":11,\"38\":\"2012.04.22\",\"39\":240,\"40\":128,\"41\":128,\"42\":1,\"43\":5480916,\"44\":2,\"45\":22,\"47\":2}]}}";
        ListItemHandler lih = new ListItemHandler();
        parse(s, lih); //new ItemHandler() {
//            @Override
//            public boolean onSessionResultSummaryParsed(SessionResultSummary summary) {
//                System.err.println(summary.getSubSessionId());
//                return true;
//            }
//        });
        for (SessionResultSummary summary : lih.getList()) {
            System.err.println(summary.getSubSessionId());
        }
    }
    
    public static void parse(String json, ItemHandler handler) {
        if (handler != null) {
            JSONParser parser = new JSONParser();
            try {
                JSONObject root = (JSONObject)parser.parse(json);
                //"1":"champpointssort","2":"raw_start_time","3":"bestlaptime","4":"start_time"
                //"5":"groupname","6":"helm_pattern","7":"season_year","8":"clubpoints","9":"subsession_bestlaptime"
                //"10":"evttype","11":"winnerlicenselevel","12":"strengthoffield","13":"dropracepoints","14":"finishedat"
                //"15":"trackid","16":"winnercustid","17":"custid","18":"winnerdisplayname","19":"sessionid"
                //"20":"clubpointssort","21":"rn","22":"seasonid","23":"carclassid","24":"helm_licenselevel"
                //"25":"starting_position","26":"officialsession","27":"displayname","28":"helm_color1","29":"season_quarter"
                //"30":"helm_color2","31":"helm_color3","32":"seriesid","33":"bestquallaptime","34":"licensegroup"
                //"35":"incidents","36":"champpoints","37":"race_week_num","38":"start_date","39":"winnerhelmcolor1"
                //"40":"winnerhelmcolor2","41":"winnerhelmcolor3","42":"carid","43":"subsessionid","44":"catid"
                //"45":"winnerhelmpattern","46":"rowcount","47":"finishing_position"
                
                // Only continue if 'd' is an JSONObject, not if it's an JSONArray (as is returned when invalid parameters are passed)
                // {"m":{},"d":[]}
                Object o = root.get("d");
                if (o instanceof JSONObject) {
                    JSONObject d = (JSONObject)o;
                    long totalRecords = getLong(d, "46");
                    JSONArray r = (JSONArray)d.get("r");
                    for (int i = 0; i < r.size(); i++) {
                        JSONObject rItem = (JSONObject)r.get(i);
                        SessionResultSummary summary = new SessionResultSummary();
                        //{"1":-1,"2":1339938000000,"3":"47.636","4":"01%3A00pm","5":"Rookie","6":48,"7":2012,"8":0,"9":"47.597",
                        //"10":5,"11":18,"12":1390,"13":"","14":1339940125000,"15":116,"16":72331,"17":29462,"18":"Robby+Singleton","19":25672697,
                        //"20":0,"21":1,"22":686,"23":19,"24":19,"25":6,"26":0,"27":"Christian+Aylward","28":111,"29":2,
                        //"30":255,"31":127,"32":116,"33":"","34":1,"35":4,"36":"","37":6,"38":"2012.06.17","39":22,
                        //"40":67,"41":39,"42":22,"43":5854525,"44":1,"45":56,"47":3}
                        summary.setStartTime(new Date(getLong(rItem, "2")));
                        summary.setBestLapTime(getString(rItem, "3"));
                        summary.setGroupName(getString(rItem, "5"));
                        summary.setSeasonYear(getInt(rItem, "7"));
                        String s = getString(rItem, "8");
                        if (!"".equals(s)) summary.setClubPoints(Integer.parseInt(s));
                        summary.setSessionBestLapTime(getString(rItem, "9"));
                        summary.setEventType(getInt(rItem, "10"));
                        summary.setWinnerLicenseLevel(getInt(rItem, "11"));
                        summary.setStrengthOfField(getInt(rItem, "12"));
                        s = getString(rItem, "13");
                        if (!"".equals(s)) summary.setDropRacePoints(Integer.parseInt(s));
                        summary.setFinishDate(new Date(getLong(rItem, "14")));
                        summary.setTrackId(getInt(rItem, "15"));
                        summary.setWinnerCustomerId(getLong(rItem, "16"));
                        summary.setCustomerId(getLong(rItem, "17"));
                        summary.setWinnerDisplayName(getString(rItem, "18", true));
                        summary.setSessionId(getLong(rItem, "19"));
                        summary.setSeasonId(getInt(rItem, "22"));
                        summary.setCarClassId(getInt(rItem, "23"));
                        summary.setStartingPosition(getInt(rItem, "25"));
                        summary.setOfficialSession((getInt(rItem, "26")) == 1);
                        summary.setDisplayName(getString(rItem, "27", true));
                        summary.setSeasonQuarter(getInt(rItem, "29"));
                        summary.setSeriesId(getInt(rItem, "32"));
                        summary.setBestQualifyingLapTime(getString(rItem, "33"));
                        summary.setLicenseGroup(getInt(rItem, "34"));
                        summary.setIncidents(getInt(rItem, "35"));
                        Object a = rItem.get("36");
                        if (a instanceof Long) {
                            summary.setChampionshipPoints(((Long)a).intValue());
                        }
//                        s = (String)rItem.get("36");
//                        if (!"".equals(s)) summary.setChampionshipPoints(Integer.parseInt(s));
                        summary.setRaceWeek(getInt(rItem, "37"));
                        summary.setStartDate(getString(rItem, "38"));
                        summary.setCarId(getInt(rItem, "42"));
                        summary.setSubSessionId(getLong(rItem, "43"));
                        summary.setCategoryId(getInt(rItem, "44"));
                        summary.setFinishingPosition(getInt(rItem, "47"));
                        if (!handler.onSessionResultSummaryParsed(summary)) break;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(SessionResultSummaryParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}