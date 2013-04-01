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
public class WorldRecordsParser extends JsonParserBase {
    
    public static void main(String[] args) {
        //carid=33&custid=29462&format=json&lowerbound=1&order=asc&seasonyear=2011&sort=practice&trackid=46&upperbound=5
        String s = "{\"m\":{\"1\":\"clubname\",\"2\":\"countrycode\",\"3\":\"sublevel\",\"4\":\"irating\",\"5\":\"timetrial_subsessionid\",\"6\":\"qualify\",\"7\":\"displayname\",\"8\":\"practice_start_time\",\"9\":\"season_quarter\",\"10\":\"clubid\",\"11\":\"race\",\"12\":\"helmpattern\",\"13\":\"licenseclass\",\"14\":\"season_year\",\"15\":\"ttrating\",\"16\":\"licensegroup\",\"17\":\"race_subsessionid\",\"18\":\"timetrial_start_time\",\"19\":\"qualify_subsessionid\",\"20\":\"licenselevel\",\"21\":\"trackid\",\"22\":\"custrow\",\"23\":\"timetrial\",\"24\":\"helmcolor1\",\"25\":\"helmcolor2\",\"26\":\"custid\",\"27\":\"helmcolor3\",\"28\":\"carid\",\"29\":\"catid\",\"30\":\"region\",\"31\":\"practice_subsessionid\",\"32\":\"rowcount\",\"33\":\"race_start_time\",\"34\":\"practice\",\"35\":\"qualify_start_time\",\"36\":\"rn\",\"37\":\"category\"},\"d\":{\"22\":80,\"32\":761,\"r\":[{\"1\":\"Australia%2FNZ\",\"2\":\"AU\",\"3\":475,\"4\":4733,\"5\":\"\",\"6\":\"\",\"7\":\"Christian+Aylward\",\"8\":1310173279000,\"9\":\"\",\"10\":34,\"11\":\"\",\"12\":48,\"13\":\"A+4.68\",\"14\":\"2011\",\"15\":2308,\"16\":5,\"17\":\"\",\"18\":0,\"19\":\"\",\"20\":20,\"21\":46,\"23\":\"\",\"24\":111,\"25\":255,\"26\":29462,\"27\":127,\"28\":33,\"29\":2,\"30\":\"Region+1\",\"31\":3772373,\"33\":0,\"34\":\"1%3A01.648\",\"35\":0,\"36\":\"\",\"37\":\"Road\"},{\"1\":\"DE-AT-CH\",\"2\":\"DE\",\"3\":481,\"4\":5448,\"5\":3785098,\"6\":\"1%3A00.534\",\"7\":\"Martin+Kr%C3%B6nke\",\"8\":1318764014000,\"9\":\"\",\"10\":42,\"11\":\"1%3A01.618\",\"12\":9,\"13\":\"A+3.57\",\"14\":\"2011\",\"15\":2488,\"16\":5,\"17\":3781478,\"18\":1310387880000,\"19\":3780856,\"20\":28,\"21\":46,\"23\":\"1%3A01.650\",\"24\":255,\"25\":240,\"26\":58404,\"27\":112,\"28\":33,\"29\":2,\"30\":\"Region+1\",\"31\":4301721,\"33\":1310325300000,\"34\":\"1%3A00.338\",\"35\":1310316300000,\"36\":1,\"37\":\"Road\"},{\"1\":\"Australia%2FNZ\",\"2\":\"AU\",\"3\":438,\"4\":6401,\"5\":\"\",\"6\":\"1%3A00.488\",\"7\":\"Luke+McLean\",\"8\":1302177958000,\"9\":\"\",\"10\":34,\"11\":\"1%3A02.897\",\"12\":60,\"13\":\"P+2.34\",\"14\":\"2011\",\"15\":2723,\"16\":7,\"17\":3349615,\"18\":0,\"19\":3349501,\"20\":28,\"21\":46,\"23\":\"\",\"24\":22,\"25\":116,\"26\":18209,\"27\":118,\"28\":33,\"29\":2,\"30\":\"Region+2\",\"31\":3338537,\"33\":1302386400000,\"34\":\"1%3A00.374\",\"35\":1302384600000,\"36\":2,\"37\":\"Road\"},{\"1\":\"Eastern+Canada\",\"2\":\"CA\",\"3\":499,\"4\":6760,\"5\":\"\",\"6\":\"1%3A00.683\",\"7\":\"Shawn+Purdy\",\"8\":1302177958000,\"9\":\"\",\"10\":15,\"11\":\"1%3A02.046\",\"12\":37,\"13\":\"P+3.14\",\"14\":\"2011\",\"15\":3238,\"16\":7,\"17\":3349615,\"18\":0,\"19\":3349501,\"20\":18,\"21\":46,\"23\":\"\",\"24\":254,\"25\":243,\"26\":16110,\"27\":139,\"28\":33,\"29\":2,\"30\":\"Region+1\",\"31\":3338537,\"33\":1302386400000,\"34\":\"1%3A00.411\",\"35\":1302384600000,\"36\":3,\"37\":\"Road\"},{\"1\":\"Iberia\",\"2\":\"PT\",\"3\":252,\"4\":4678,\"5\":\"\",\"6\":\"1%3A00.735\",\"7\":\"Joao+Vaz\",\"8\":1302377052000,\"9\":\"\",\"10\":38,\"11\":\"1%3A01.923\",\"12\":30,\"13\":\"P+2.28\",\"14\":\"2011\",\"15\":1304,\"16\":7,\"17\":3349615,\"18\":0,\"19\":3777133,\"20\":18,\"21\":46,\"23\":\"\",\"24\":128,\"25\":11,\"26\":30569,\"27\":218,\"28\":33,\"29\":2,\"30\":\"Region+4\",\"31\":3349039,\"33\":1302386400000,\"34\":\"1%3A00.569\",\"35\":1310251500000,\"36\":4,\"37\":\"Road\"},{\"1\":\"New+England\",\"2\":\"US\",\"3\":496,\"4\":7405,\"5\":\"\",\"6\":\"1%3A00.432\",\"7\":\"Jake+Stergios\",\"8\":1318424480000,\"9\":\"\",\"10\":12,\"11\":\"1%3A00.940\",\"12\":9,\"13\":\"A+4.85\",\"14\":\"2011\",\"15\":2640,\"16\":5,\"17\":4820478,\"18\":0,\"19\":4291560,\"20\":28,\"21\":46,\"23\":\"\",\"24\":116,\"25\":240,\"26\":27868,\"27\":240,\"28\":33,\"29\":2,\"30\":\"Region+4\",\"31\":4281160,\"33\":1326647700000,\"34\":\"1%3A00.576\",\"35\":1318599900000,\"36\":5,\"37\":\"Road\"}]}}";
        WorldRecords records = parse(s, false);
        for (WorldRecord record : records.getRecords()) {
            s = record.getRecordNumber() + " : " + record.getDriver().getName();
            s += " (" + record.getPractice() + ")";
            System.err.println(s);
        }
    }
    
    static WorldRecords parse(String json, boolean includeApiUserRow) {
        JSONParser parser = new JSONParser();
        WorldRecords output = null;
        try {
            JSONObject root = (JSONObject)parser.parse(json);
            output = new WorldRecords();
            JSONObject root2 = (JSONObject)root.get("d");
            output.setApiUserRow(getLong(root2, "22"));
            output.setTotalResults(getLong(root2, "32"));
            JSONArray rootArray = (JSONArray)root2.get("r");
            List<WorldRecord> recordList = new ArrayList<WorldRecord>();
            for (int i = 0; i < rootArray.size(); i++) {
                JSONObject r = (JSONObject)rootArray.get(i);
                long recordNumber = getLong(r, "36");
                if (!includeApiUserRow && recordNumber == 0) continue;
                WorldRecord wr = new WorldRecord();
                wr.setClubName(getString(r, "1", true));
                wr.setCountryCode(getString(r, "2"));
                wr.setLicenseSubLevel(getInt(r, "3"));
                wr.setIrating(getInt(r, "4"));
                wr.setTimeTrialSubSessionId(getLong(r, "5"));
                wr.setQualify(getString(r, "6", true));
                IracingCustomer driver = new IracingCustomer();
                driver.setId(getLong(r, "26"));
                driver.setName(getString(r, "7", true));
                wr.setDriver(driver);
                long l = getLong(r, "8");
                if (l > 0) wr.setPracticeStartTime(new Date(l));
                wr.setSeasonQuarter(getInt(r, "9"));
                wr.setClubId(getInt(r, "10"));
                wr.setRace(getString(r, "11", true));
                wr.setLicenseSubLevelText(getString(r, "13", true));
                wr.setSeasonYear(getInt(r, "14"));
                wr.setTimeTrialRating(getInt(r, "15"));
                wr.setLicenseGroupId(getInt(r, "16"));
                wr.setRaceSubSessionId(getLong(r, "17"));
                l = getLong(r, "18");
                if (l > 0) wr.setTimeTrialStartTime(new Date(l));
                wr.setQualifyingSubSessionId(getLong(r, "19"));
                wr.setLicenseLevelId(getInt(r, "20"));
                wr.setTrackId(getInt(r, "21"));
                wr.setTimeTrial(getString(r, "23", true));
                wr.setCarId(getInt(r, "28"));
                wr.setCategoryId(getInt(r, "29"));
                wr.setRegionName(getString(r, "30", true));
                wr.setPracticeSubSessionId(getLong(r, "31"));
                l = getLong(r, "33");
                if (l > 0) wr.setRaceStartTime(new Date(l));
                wr.setPractice(getString(r, "34", true));
                l = getLong(r, "35");
                wr.setRecordNumber(recordNumber);
                if (l > 0) wr.setQualifyingStartTime(new Date(l));
                wr.setCategoryName(getString(r, "37"));
                recordList.add(wr);
            }
            output.setRecords(recordList);
        } catch (ParseException ex) {
            Logger.getLogger(WorldRecordsParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}