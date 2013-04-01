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
class SeasonStandingsParser extends JsonParserBase {
    
    //  "1":"dropped","2":"clubname","3":"countrycode","4":"sublevel","5":"avgfinish",
    //  "6":"irating","7":"topfive","8":"maxlicenselevel","9":"displayname","10":"clubid",
    //  "11":"starts","12":"helmpattern","13":"displaycountry","14":"lapslead","15":"country",
    //  "16":"wins","17":"incidents","18":"points","19":"custrow","20":"rank",
    //  "21":"helmcolor1","22":"division","23":"helmcolor2","24":"custid","25":"helmcolor3",
    //  "26":"week","27":"rowcount","28":"laps","29":"avgstart","30":"poles",
    //  "31":"pos","32":"rn"

    public interface ItemHandler {
        public boolean onSeasonStandingParsed(SeasonStanding standing);
    }
    
    public static class ListItemHandler implements ItemHandler {
        
        private List<SeasonStanding> list;
        
        public ListItemHandler() {
            list = new ArrayList<SeasonStanding>();
        }

        public List<SeasonStanding> getList() {
            return list;
        }
        
        @Override
        public boolean onSeasonStandingParsed(SeasonStanding standing) {
            list.add(standing);
            return true;
        }
        
    }
    
    private ItemHandler itemHandler;
    
    public SeasonStandingsParser() {}

    public ItemHandler getItemHandler() {
        return itemHandler;
    }

    public void setItemHandler(ItemHandler itemHandler) {
        this.itemHandler = itemHandler;
    }
    
    public static void main(String[] args) {
        // NOTE: the following sample output is outdated
        String s = "{\"m\":{\"1\":\"dropped\",\"2\":\"clubname\",\"3\":\"countrycode\",\"4\":\"sublevel\",\"5\":\"avgfinish\",\"6\":\"irating\",\"7\":\"topfive\",\"8\":\"maxlicenselevel\",\"9\":\"displayname\",\"10\":\"clubid\",\"11\":\"starts\",\"12\":\"helmpattern\",\"13\":\"displaycountry\",\"14\":\"lapslead\",\"15\":\"country\",\"16\":\"wins\",\"17\":\"incidents\",\"18\":\"points\",\"19\":\"custrow\",\"20\":\"rank\",\"21\":\"helmcolor1\",\"22\":\"division\",\"23\":\"helmcolor2\",\"24\":\"custid\",\"25\":\"helmcolor3\",\"26\":\"week\",\"27\":\"rowcount\",\"28\":\"laps\",\"29\":\"avgstart\",\"30\":\"poles\",\"31\":\"pos\",\"32\":\"rn\"},\"d\":{\"19\":\"-1\",\"27\":574,\"r\":[{\"1\":3,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+3.54\",\"5\":5,\"6\":5640,\"7\":17,\"8\":19,\"9\":\"Richard+Hamstead\",\"10\":34,\"11\":20,\"12\":65,\"13\":\"Australia\",\"14\":220,\"15\":\"Australia\",\"16\":7,\"17\":265,\"18\":1869,\"20\":1,\"21\":240,\"22\":0,\"23\":255,\"24\":28805,\"25\":76,\"26\":8,\"28\":483,\"29\":3,\"30\":2,\"31\":1,\"32\":1},{\"1\":3,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+2.65\",\"5\":5,\"6\":5762,\"7\":16,\"8\":14,\"9\":\"Mitchell+McLeod\",\"10\":34,\"11\":22,\"12\":42,\"13\":\"Australia\",\"14\":191,\"15\":\"Australia\",\"16\":9,\"17\":191,\"18\":1848,\"20\":2,\"21\":112,\"22\":0,\"23\":255,\"24\":19885,\"25\":106,\"26\":8,\"28\":481,\"29\":2,\"30\":11,\"31\":2,\"32\":2},{\"1\":3,\"2\":\"Benelux\",\"3\":\"NL\",\"4\":\"+3.55\",\"5\":5,\"6\":5761,\"7\":18,\"8\":19,\"9\":\"Rens+Broekman\",\"10\":40,\"11\":24,\"12\":64,\"13\":\"Netherlands\",\"14\":74,\"15\":\"Netherlands\",\"16\":3,\"17\":273,\"18\":1722,\"20\":3,\"21\":113,\"22\":0,\"23\":113,\"24\":27251,\"25\":255,\"26\":8,\"28\":583,\"29\":3,\"30\":6,\"31\":3,\"32\":3},{\"1\":4,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+3.45\",\"5\":7,\"6\":5164,\"7\":13,\"8\":15,\"9\":\"Justin+V+Ruggier\",\"10\":34,\"11\":22,\"12\":1,\"13\":\"Australia\",\"14\":33,\"15\":\"Australia\",\"16\":1,\"17\":206,\"18\":1651,\"20\":4,\"21\":255,\"22\":0,\"23\":252,\"24\":76404,\"25\":246,\"26\":8,\"28\":514,\"29\":6,\"30\":0,\"31\":4,\"32\":4},{\"1\":0,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+3.28\",\"5\":7,\"6\":4327,\"7\":10,\"8\":11,\"9\":\"Scott+T+McLaughlin\",\"10\":34,\"11\":17,\"12\":0,\"13\":\"Australia\",\"14\":67,\"15\":\"Australia\",\"16\":2,\"17\":261,\"18\":1599,\"20\":5,\"21\":249,\"22\":1,\"23\":132,\"24\":30869,\"25\":126,\"26\":8,\"28\":385,\"29\":5,\"30\":1,\"31\":5,\"32\":5},{\"1\":4,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+2.46\",\"5\":7,\"6\":5512,\"7\":14,\"8\":18,\"9\":\"Scott+U%27Ren\",\"10\":34,\"11\":24,\"12\":64,\"13\":\"Australia\",\"14\":4,\"15\":\"Australia\",\"16\":0,\"17\":199,\"18\":1544,\"20\":6,\"21\":241,\"22\":0,\"23\":100,\"24\":17193,\"25\":54,\"26\":8,\"28\":573,\"29\":9,\"30\":0,\"31\":6,\"32\":6},{\"1\":4,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+3.16\",\"5\":7,\"6\":5332,\"7\":11,\"8\":19,\"9\":\"Joshua+Muggleton\",\"10\":34,\"11\":24,\"12\":12,\"13\":\"Australia\",\"14\":93,\"15\":\"Australia\",\"16\":2,\"17\":254,\"18\":1541,\"20\":7,\"21\":240,\"22\":0,\"23\":112,\"24\":51878,\"25\":52,\"26\":8,\"28\":596,\"29\":6,\"30\":2,\"31\":7,\"32\":7},{\"1\":0,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+2.86\",\"5\":8,\"6\":3984,\"7\":3,\"8\":14,\"9\":\"Stuart+Wood\",\"10\":34,\"11\":16,\"12\":13,\"13\":\"Australia\",\"14\":1,\"15\":\"Australia\",\"16\":0,\"17\":176,\"18\":1314,\"20\":8,\"21\":112,\"22\":0,\"23\":124,\"24\":50369,\"25\":255,\"26\":8,\"28\":421,\"29\":8,\"30\":0,\"31\":8,\"32\":8},{\"1\":4,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+2.27\",\"5\":8,\"6\":3632,\"7\":10,\"8\":14,\"9\":\"John+Emerson\",\"10\":34,\"11\":21,\"12\":32,\"13\":\"Australia\",\"14\":26,\"15\":\"Australia\",\"16\":2,\"17\":178,\"18\":1280,\"20\":9,\"21\":240,\"22\":1,\"23\":80,\"24\":53125,\"25\":240,\"26\":8,\"28\":510,\"29\":7,\"30\":3,\"31\":9,\"32\":9},{\"1\":0,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+2.41\",\"5\":8,\"6\":3885,\"7\":4,\"8\":14,\"9\":\"Simon+Madden\",\"10\":34,\"11\":14,\"12\":5,\"13\":\"Australia\",\"14\":0,\"15\":\"Australia\",\"16\":0,\"17\":153,\"18\":1211,\"20\":10,\"21\":84,\"22\":0,\"23\":22,\"24\":51488,\"25\":255,\"26\":7,\"28\":318,\"29\":6,\"30\":0,\"31\":10,\"32\":10},{\"1\":2,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+3.60\",\"5\":12,\"6\":3666,\"7\":2,\"8\":11,\"9\":\"Brad+Ryan\",\"10\":34,\"11\":20,\"12\":28,\"13\":\"Australia\",\"14\":0,\"15\":\"Australia\",\"16\":0,\"17\":156,\"18\":1185,\"20\":11,\"21\":118,\"22\":1,\"23\":116,\"24\":67541,\"25\":240,\"26\":8,\"28\":410,\"29\":9,\"30\":0,\"31\":11,\"32\":11},{\"1\":2,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+1.31\",\"5\":9,\"6\":3174,\"7\":8,\"8\":13,\"9\":\"Shaun+Kelly\",\"10\":34,\"11\":20,\"12\":65,\"13\":\"Australia\",\"14\":67,\"15\":\"Australia\",\"16\":3,\"17\":201,\"18\":1149,\"20\":12,\"21\":113,\"22\":1,\"23\":255,\"24\":64287,\"25\":97,\"26\":8,\"28\":487,\"29\":8,\"30\":2,\"31\":12,\"32\":12},{\"1\":4,\"2\":\"Australia%2FNZ\",\"3\":\"NZ\",\"4\":\"+2.75\",\"5\":10,\"6\":2897,\"7\":9,\"8\":18,\"9\":\"Josh+Smith\",\"10\":34,\"11\":28,\"12\":35,\"13\":\"New+Zealand\",\"14\":136,\"15\":\"New+Zealand\",\"16\":6,\"17\":151,\"18\":1129,\"20\":13,\"21\":113,\"22\":1,\"23\":116,\"24\":60147,\"25\":118,\"26\":8,\"28\":636,\"29\":6,\"30\":11,\"31\":13,\"32\":13},{\"1\":4,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+3.43\",\"5\":7,\"6\":3366,\"7\":11,\"8\":15,\"9\":\"Christopher+Osborne\",\"10\":34,\"11\":21,\"12\":18,\"13\":\"Australia\",\"14\":74,\"15\":\"Australia\",\"16\":2,\"17\":125,\"18\":1108,\"20\":14,\"21\":243,\"22\":1,\"23\":116,\"24\":73560,\"25\":116,\"26\":8,\"28\":479,\"29\":7,\"30\":2,\"31\":14,\"32\":14},{\"1\":4,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+4.63\",\"5\":9,\"6\":4704,\"7\":9,\"8\":20,\"9\":\"Simon+Black\",\"10\":34,\"11\":22,\"12\":19,\"13\":\"Australia\",\"14\":25,\"15\":\"Australia\",\"16\":1,\"17\":121,\"18\":1104,\"20\":15,\"21\":240,\"22\":0,\"23\":240,\"24\":17455,\"25\":244,\"26\":8,\"28\":537,\"29\":10,\"30\":1,\"31\":15,\"32\":15},{\"1\":3,\"2\":\"Benelux\",\"3\":\"NL\",\"4\":\"+4.57\",\"5\":3,\"6\":4554,\"7\":20,\"8\":20,\"9\":\"Thomas+van+Bussel\",\"10\":40,\"11\":22,\"12\":64,\"13\":\"Netherlands\",\"14\":182,\"15\":\"Netherlands\",\"16\":9,\"17\":114,\"18\":1068.5,\"20\":16,\"21\":255,\"22\":1,\"23\":240,\"24\":69848,\"25\":124,\"26\":8,\"28\":529,\"29\":3,\"30\":6,\"31\":16,\"32\":16},{\"1\":3,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+3.27\",\"5\":7,\"6\":3190,\"7\":17,\"8\":15,\"9\":\"Thomas+Guerrini\",\"10\":34,\"11\":31,\"12\":68,\"13\":\"Australia\",\"14\":225,\"15\":\"Australia\",\"16\":9,\"17\":318,\"18\":1061.5,\"20\":17,\"21\":240,\"22\":1,\"23\":242,\"24\":67274,\"25\":255,\"26\":8,\"28\":742,\"29\":6,\"30\":5,\"31\":17,\"32\":17},{\"1\":1,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+3.29\",\"5\":7,\"6\":3657,\"7\":12,\"8\":19,\"9\":\"Ben+Rothberg\",\"10\":34,\"11\":20,\"12\":65,\"13\":\"Australia\",\"14\":74,\"15\":\"Australia\",\"16\":3,\"17\":144,\"18\":1044.5,\"20\":18,\"21\":113,\"22\":1,\"23\":255,\"24\":79260,\"25\":240,\"26\":8,\"28\":421,\"29\":7,\"30\":3,\"31\":18,\"32\":18},{\"1\":0,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+4.61\",\"5\":2,\"6\":7100,\"7\":10,\"8\":20,\"9\":\"Madison+Down\",\"10\":34,\"11\":11,\"12\":65,\"13\":\"Australia\",\"14\":98,\"15\":\"Australia\",\"16\":6,\"17\":96,\"18\":1029.5,\"20\":19,\"21\":255,\"22\":0,\"23\":240,\"24\":50308,\"25\":96,\"26\":5,\"28\":261,\"29\":3,\"30\":5,\"31\":19,\"32\":19},{\"1\":1,\"2\":\"England\",\"3\":\"GB\",\"4\":\"+1.94\",\"5\":7,\"6\":3554,\"7\":10,\"8\":13,\"9\":\"Mick+Claridge\",\"10\":36,\"11\":18,\"12\":23,\"13\":\"United+Kingdom\",\"14\":185,\"15\":\"United+Kingdom\",\"16\":8,\"17\":192,\"18\":1009,\"20\":20,\"21\":88,\"22\":1,\"23\":139,\"24\":18090,\"25\":44,\"26\":8,\"28\":430,\"29\":5,\"30\":7,\"31\":20,\"32\":20},{\"1\":4,\"2\":\"Benelux\",\"3\":\"BE\",\"4\":\"+3.31\",\"5\":4,\"6\":4018,\"7\":22,\"8\":19,\"9\":\"Kevin+Duwel\",\"10\":40,\"11\":26,\"12\":48,\"13\":\"Belgium\",\"14\":104,\"15\":\"Belgium\",\"16\":4,\"17\":119,\"18\":999.5,\"20\":21,\"21\":240,\"22\":1,\"23\":112,\"24\":64165,\"25\":84,\"26\":8,\"28\":658,\"29\":5,\"30\":2,\"31\":21,\"32\":21},{\"1\":4,\"2\":\"New+York\",\"3\":\"US\",\"4\":\"+4.25\",\"5\":7,\"6\":4083,\"7\":22,\"8\":16,\"9\":\"Chad+Chastain\",\"10\":14,\"11\":37,\"12\":63,\"13\":\"USA+-+NY\",\"14\":162,\"15\":\"United+States\",\"16\":3,\"17\":372,\"18\":992.666672,\"20\":22,\"21\":61,\"22\":1,\"23\":112,\"24\":32550,\"25\":255,\"26\":8,\"28\":851,\"29\":6,\"30\":9,\"31\":22,\"32\":22},{\"1\":4,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+2.44\",\"5\":7,\"6\":2723,\"7\":10,\"8\":14,\"9\":\"Jon+Latham\",\"10\":34,\"11\":17,\"12\":43,\"13\":\"Australia\",\"14\":30,\"15\":\"Australia\",\"16\":1,\"17\":160,\"18\":982.5,\"20\":23,\"21\":252,\"22\":2,\"23\":156,\"24\":73071,\"25\":77,\"26\":8,\"28\":410,\"29\":7,\"30\":2,\"31\":23,\"32\":23},{\"1\":0,\"2\":\"Australia%2FNZ\",\"3\":\"AU\",\"4\":\"+2.40\",\"5\":10,\"6\":3404,\"7\":4,\"8\":14,\"9\":\"George+Fullerton\",\"10\":34,\"11\":16,\"12\":0,\"13\":\"Australia\",\"14\":0,\"15\":\"Australia\",\"16\":0,\"17\":158,\"18\":965,\"20\":24,\"21\":255,\"22\":0,\"23\":255,\"24\":16160,\"25\":255,\"26\":8,\"28\":410,\"29\":12,\"30\":0,\"31\":24,\"32\":24},{\"1\":3,\"2\":\"England\",\"3\":\"GB\",\"4\":\"+4.63\",\"5\":5,\"6\":3223,\"7\":17,\"8\":16,\"9\":\"Trevor+Johnson\",\"10\":36,\"11\":22,\"12\":18,\"13\":\"United+Kingdom\",\"14\":25,\"15\":\"United+Kingdom\",\"16\":1,\"17\":120,\"18\":956.5,\"20\":25,\"21\":128,\"22\":2,\"23\":255,\"24\":66022,\"25\":240,\"26\":8,\"28\":510,\"29\":3,\"30\":3,\"31\":25,\"32\":25}]}}";
        long totalRecords = parse(s, new ItemHandler() {
            @Override
            public boolean onSeasonStandingParsed(SeasonStanding standing) {
                System.err.println(standing.getPosition() + " : " + standing.getDriverName() + " (" + standing.getTotalPoints() + ")");
                return true;
            }
        });
        System.err.println("Total records : " + totalRecords);
    }
    
    public long parse(String json) {
        return parse(json, itemHandler);
    }
    
    public static long parse(String json, ItemHandler handler) {
        JSONParser parser = new JSONParser();
//        System.err.println(json);
        long output = 0;
        try {
            JSONObject root = (JSONObject)parser.parse(json);
            JSONObject arrayRoot = (JSONObject)root.get("d");
            output = getLong(arrayRoot, "27");
            JSONArray results = (JSONArray)arrayRoot.get("r");
            for (int i = 0; i < results.size(); i++) {
                JSONObject result = (JSONObject)results.get(i);
                SeasonStanding standing = new SeasonStanding();
                standing.setDroppedWeeks(getInt(result, "1"));
                standing.setClubName(getString(result, "2", true));
                standing.setCountryCode(getString(result, "3", true));
                standing.setLicenseSubLevel(getString(result, "4"));
                standing.setAverageFinish(getInt(result, "5"));
                standing.setIrating(getInt(result, "6"));
                standing.setTotalTopFives(getInt(result, "7"));
                standing.setMaxLicenseLevel(getInt(result, "8"));
                standing.setDriverName(getString(result, "9", true));
                standing.setClubId(getInt(result, "10"));
                standing.setTotalStarts(getInt(result, "11"));
                standing.setDisplayCountry(getString(result, "14", true));
                standing.setTotalLapsLed(getInt(result, "13"));
                standing.setCountry(getString(result, "15", true));
                standing.setTotalWins(getInt(result, "16"));
                standing.setTotalIncidents(getInt(result, "17"));
                Object o = result.get("18");
                double d;
                if (o instanceof Long) {
                    Long l = (Long)o;
                    d = l.doubleValue();
                } else {
                    d = (Double)o;
                }
                standing.setTotalPoints(d);
                standing.setRank(getInt(result, "20"));
                standing.setDivision(getInt(result, "22"));
                standing.setDriverCustomerId(getLong(result, "24"));
                standing.setWeeksCounted(getInt(result, "26"));
                standing.setTotalLaps(getLong(result, "28"));
                standing.setAverageStart(getInt(result, "29"));
                standing.setTotalPoles(getInt(result, "30"));
                standing.setPosition(getLong(result, "31"));
                if (!handler.onSeasonStandingParsed(standing)) break;
            }
        } catch (ParseException ex) {
            Logger.getLogger(SeasonStandingsParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
}