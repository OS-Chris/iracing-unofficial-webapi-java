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
public class SeasonParser extends JsonParserBase {
    
    public static List<Season> parse(String json) {
        JSONParser parser = new JSONParser();
        List<Season> output = null;
        try {
            JSONArray rootArray = (JSONArray)parser.parse(json);
            output = new ArrayList<Season>();
            for (int i = 0; i < rootArray.size(); i++) {
                JSONObject r = (JSONObject)rootArray.get(i);
                Season season = new Season();
                season.setId(getInt(r, "seasonid"));
                season.setPrefImage(getString(r, "prefimg", true));
                season.setSeriesName(getString(r, "seriesname", true));
                season.setSeasonShortName(getString(r, "seasonshortname", true));
                season.setWhatsHotImage(getString(r, "whatshotimg", true));
                season.setCautionTypeRoad(getInt(r, "cautionTypeRoad"));
                season.setCautionTypeOval(getInt(r, "cautionTypeOval"));
                season.setRaceWeeks(getInt(r, "raceweek"));
                season.setActive((Boolean)r.get("active"));
                season.setMinimumSafetyRating(getString(r, "minsr"));
                season.setMinimumLicenseLevel(getInt(r, "minlicenselevel"));
                season.setMaximumLicenseLevel(getInt(r, "maxlicenselevel"));
                JSONArray array = (JSONArray)r.get("tracks");
                List<Season.Track> trackList = new ArrayList<Season.Track>();
                // to work around a website bug where tracks are listed 3 times each, 
                // we only add ones that have different raceweek values
                int lastRaceWeek = -1;
                for (int j = 0; j < array.size(); j++) {
                    //{"config":"","priority":0,"raceweek":0,"pkgid":90,"night":0,"name":"Mosport+International+Raceway","id":144,"lowername":"mosport+international+raceway"}
                    JSONObject o = (JSONObject)array.get(j);
                    int raceWeek = getInt(o, "raceweek");
                    if (raceWeek != lastRaceWeek) {
                        Season.Track track = new Season.Track();
                        track.setId(getInt(o, "id"));
                        track.setNightMode((getInt(o, "night")) == 1);
                        trackList.add(track);
                        lastRaceWeek = raceWeek;
                    }
                }
                season.setTracks(trackList);
                //"carclasses":[{"carsinclass":[{"name":"Cadillac+CTS-V+Racecar","id":41}],"shortname":"Cadillac+CTS-VR","name":"Cadillac+CTS-VR","id":45,"lowername":"cadillac+cts-vr"}]
                List<Integer> carClasses = new ArrayList<Integer>();
                array = (JSONArray)r.get("carclasses");
                for (int j = 0; j < array.size(); j++) {
                    JSONObject o = (JSONObject)array.get(j);
                    //JSONArray array2 = (JSONArray)o.get("carsinclass");
                    carClasses.add(getInt(o, "id"));
                }
                season.setCarClasses(carClasses);
                season.setApiUserClubAllowed((Boolean)r.get("isClubAllowed"));
                season.setSeriesLicenseGroupId(getInt(r, "serieslicgroupid"));
                season.setCurrentTrack(getInt(r, "currentTrack"));
                season.setSeriesId(getInt(r, "seriesid"));
                season.setLicenseGroupId(getInt(r, "licgroupid"));
                season.setLicenseIgnoredForPractice((Boolean)r.get("ignoreLicenseForPractice"));
                season.setWorldCupEvent((Boolean)r.get("isWorldCup"));
                season.setStartDate(new Date(getLong(r, "start")));
                season.setEndDate(new Date(getLong(r, "end")));
                array = (JSONArray)r.get("cars");
                List<Integer> carList = new ArrayList<Integer>();
                for (int j = 0; j < array.size(); j++) {
                    JSONObject o = (JSONObject)array.get(j);
                    carList.add(getInt(o, "id"));
                }
                season.setCars(carList);
                season.setMultiClass((Boolean)r.get("multiclass"));
                season.setRegionalCompetitionEvent((Boolean)r.get("isRegionCompetition"));
                season.setQuarter(getInt(r, "quarter"));
                season.setYear(getInt(r, "year"));
                season.setSeriesShortName(getString(r, "seriesshortname", true));
                season.setCategoryId(getInt(r, "catid")); // also stored under 'category'
                season.setOfficial((Boolean)r.get("isOfficial"));
                season.setApiUserLicenseEligible((Boolean)r.get("licenseEligible"));
                season.setComplete((Boolean)r.get("complete"));
                output.add(season);
            }
        } catch (ParseException ex) {
            Logger.getLogger(SeasonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}