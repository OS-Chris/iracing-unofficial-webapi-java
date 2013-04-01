package iracing.webapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class GlobalDataParser {
    
    static GlobalData parse(String html) {
        GlobalData output = new GlobalData();
        BufferedReader br = new BufferedReader(new StringReader(html));
        try {
            String s1, s2, s3, line;
            String EVENT_TYPE_PREFIX = "var EventTypeListing=";
            String CATEGORY_PREFIX = "CategoryListing[";
            String DIVISION_PREFIX = "var DivisionListing = extractJSON('";
            String LICENSE_PREFIX = "var LicenseListing = extractJSON('";
            String TRACK_PREFIX = "var TrackListing = extractJSON('";
            String CAR_PREFIX = "var CarListing = extractJSON('";
            String CAR_CLASS_PREFIX = "var CarClassListing = extractJSON('";
            String YEAR_AND_QUARTER_PREFIX = "var YearAndQuarterListing = extractJSON('";
            String SEASON_PREFIX = "var SeasonListing = extractJSON('";
            String LICENSE_GROUP_PREFIX = "var LicenseGroupListing = extractJSON('";
            String AVAIL_SERIES_PREFIX = "var AvailSeries = extractJSON('";
            String LICENSE_LEVEL_PREFIX = "var licenseLevels = extractJSON('";
            String CURRENT_SEASON_PREFIX = "var currentSeason={year:";
            String HARDCORE_OPTIONS_PREFIX = "var hardcoreOptions = extractJSON('";
            String CLUB_PREFIX = "var ClubListing = extractJSON('";
            int i, j, start;
            while ((line = br.readLine()) != null) {
                //// EVENT TYPES ////
                if ((start = line.indexOf(EVENT_TYPE_PREFIX)) != -1) {
                    start += EVENT_TYPE_PREFIX.length();
                    int end = -1;
                    s1 = "];";
                    while (end == -1) {
                        end = line.indexOf(s1);
                        if (end == -1) {
                            line += br.readLine();
                        }
                    }
                    String json = line.substring(start, end + 1);
                    start = end + s1.length();
                    output.setEventTypes(EventTypeParser.parse(json));
                }
                //// CATEGORIES ////
                if ((start = line.indexOf(CATEGORY_PREFIX, start)) != -1) {
                    s1 = "]=\"";
                    s3 = "\";";
                    start += CATEGORY_PREFIX.length();
                    i = line.indexOf(s1, start + 1);
                    List<Category> categories = new ArrayList<Category>();
                    if (i > start && i < start + 4) {
                        Category category = new Category();
                        s2 = line.substring(start, i);
                        category.setId(Integer.parseInt(s2));
                        j = line.indexOf(s3, i + s1.length());
                        s2 = line.substring(i + s1.length(), j);
                        category.setName(s2);
                        start = j + s3.length();
                        categories.add(category);
                    }
                    output.setCategories(categories);
                }
                //// DIVISIONS ////
                if ((start = line.indexOf(DIVISION_PREFIX, start)) != -1) {
                    start += DIVISION_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setDivisions(DivisionParser.parse(json));
                }
                //// LICENSES ////
                if ((start = line.indexOf(LICENSE_PREFIX, start)) != -1) {
                    start += LICENSE_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setLicenses(LicenseParser.parse(json));
                }
                //// TRACKS ////
                if ((start = line.indexOf(TRACK_PREFIX, start)) != -1) {
                    start += TRACK_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setTracks(TrackParser.parse(json));
                }
                //// CARS ////
                if ((start = line.indexOf(CAR_PREFIX, start)) != -1) {
                    start += CAR_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setCars(CarParser.parse(json));
                }
                //// CAR CLASSES ////
                if ((start = line.indexOf(CAR_CLASS_PREFIX, start)) != -1) {
                    start += CAR_CLASS_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setCarClasses(CarClassParser.parse(json));
                }
                //// YEAR & QUARTERS ////
                if ((start = line.indexOf(YEAR_AND_QUARTER_PREFIX, start)) != -1) {
                    start += YEAR_AND_QUARTER_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setYearAndQuarters(YearAndQuartersParser.parse(json));
                }
                //// SEASONS ////
                if ((start = line.indexOf(SEASON_PREFIX, start)) != -1) {
                    start += SEASON_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setSeasons(SeasonParser.parse(json));
                }
                //// LICENSE GROUPS ////
                if ((start = line.indexOf(LICENSE_GROUP_PREFIX, start)) != -1) {
                    start += LICENSE_GROUP_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setLicenseGroups(LicenseGroupParser.parse(json));
                }
                //// AVAILABLE SERIES ////
                if ((start = line.indexOf(AVAIL_SERIES_PREFIX, start)) != -1) {
                    start += AVAIL_SERIES_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setAvailableSeries(AvailableSeriesParser.parse(json));
                }
                //// LICENSE LEVELS ////
                if ((start = line.indexOf(LICENSE_LEVEL_PREFIX, start)) != -1) {
                    start += LICENSE_LEVEL_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setLicenseLevels(LicenseLevelParser.parse(json));
                }
                //// CURRENT SEASON ////
                if ((start = line.indexOf(CURRENT_SEASON_PREFIX, start)) != -1) {
                    start += CURRENT_SEASON_PREFIX.length();
                    //var currentSeason={year:2012,quarter:2};
                    YearAndQuarter currentYearAndQuarter = new YearAndQuarter();
                    int end = line.indexOf(",", start);
                    String year = line.substring(start, end);
                    currentYearAndQuarter.setYear(Integer.parseInt(year));
                    s1 = ",quarter:";
                    start = line.indexOf(s1, start) + s1.length();
                    end = line.indexOf("};", start);
                    String quarter = line.substring(start, end);
                    currentYearAndQuarter.setQuarter(Integer.parseInt(quarter));
                    output.setCurrentYearAndQuarter(currentYearAndQuarter);
                }
                //// HARDCORE OPTIONS ////
                if ((start = line.indexOf(HARDCORE_OPTIONS_PREFIX, start)) != -1) {
                    start += HARDCORE_OPTIONS_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setHardcoreOptions(HardcoreOptionParser.parse(json));
                }
                //// CLUBS ////
                if ((start = line.indexOf(CLUB_PREFIX, start)) != -1) {
                    start += CLUB_PREFIX.length();
                    s1 = "');";
                    int end = line.indexOf(s1, start);
                    String json = line.substring(start, end);
                    start = end + s1.length();
                    output.setClubs(ClubParser.parse(json));
                }
            }
            br.close();
        } catch (IOException ex) {}
        return output;
    }
    
}