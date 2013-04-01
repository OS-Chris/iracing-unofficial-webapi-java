package iracing.webapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
class CsvSessionResultParser {
    
    public static CsvSessionResult parse(String csv) {
//        System.err.println(csv);
        Scanner reader = new Scanner(csv);
        boolean containsSummary = false, nextLineIsSummary = false, isHosted = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm a z");
        CsvSessionResult output = new CsvSessionResult();
        List<SessionDriverResult> driverResults = new ArrayList<SessionDriverResult>();
        while (reader.hasNextLine()) {
            String s = reader.nextLine();
            if (s.startsWith("\"Start Time\"")) {
                containsSummary = true;
                nextLineIsSummary = true;
            } else if (s.length() == 0 || s.startsWith("\"Fin Pos\"")) {
                // nothing to do here
                if (s.contains("\"Session Name\"")) isHosted = true;
            } else {
                String[] sa = s.split(",");
                if (containsSummary && nextLineIsSummary) {
                    String startTime = removeQuotes(sa[0]);
                    try {
                        //2012.06.27 10:18 PM GMT
                        output.setStartTime(sdf.parse(startTime));
                    } catch (ParseException ex) {
                        Logger.getLogger(CsvSessionResultParser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    output.setTrackName(removeQuotes(sa[1]));
                    output.setSeriesName(removeQuotes(sa[2]));
                    if (!"".equals(sa[3])) {
                        output.setHostedSessionName(removeQuotes(sa[3]));
                    }
                    nextLineIsSummary = false;
                } else {
                    // OFFICIAL SESSION
                    //"Fin Pos","Car ID","Car","Car Class ID","Car Class","Custid","Driver","Start Pos","Car #","Out ID","Out","Interval","Laps Led","Average Lap Time","Fastest Lap Time","Fast Lap#","Laps Comp","Inc","Pts","Club Pts","Div","Club ID","Club","Old iRating","New iRating","Old License Level","Old License Sub-Level","New License Level","New License Sub-Level","Series Name"
                    
                    // HOSTED
                    //"Fin Pos","Car ID","Car","Car Class ID","Car Class","Custid","Driver","Start Pos","Car #","Out ID","Out","Interval","Laps Led","Average Lap Time","Fastest Lap Time","Fast Lap#","Laps Comp","Inc","Club ID","Club","Session Name"
                    
                    SessionDriverResult result = new SessionDriverResult();
                    result.setFinishPosition(Integer.parseInt(removeQuotes(sa[0])));
                    result.setCarId(Integer.parseInt(removeQuotes(sa[1])));
                    result.setCar(removeQuotes(sa[2]));
                    result.setCarClassId(Integer.parseInt(removeQuotes(sa[3])));
                    result.setCarClass(removeQuotes(sa[4]));
                    result.setCustomerId(Long.parseLong(removeQuotes(sa[5])));
                    result.setCustomerName(removeQuotes(sa[6]));
                    result.setStartingPosition(Integer.parseInt(removeQuotes(sa[7])));
                    result.setCarNumber(removeQuotes(sa[8]));
                    result.setReasonOutId(Integer.parseInt(removeQuotes(sa[9])));
                    result.setReasonOut(removeQuotes(sa[10]));
                    result.setInterval(removeQuotes(sa[11]));
                    result.setLapsLed(Integer.parseInt(removeQuotes(sa[12])));
                    result.setAverageLapTime(removeQuotes(sa[13]));
                    result.setFastestLapTime(removeQuotes(sa[14]));
                    String s1 = removeQuotes(sa[15]);
                    if ("".equals(s1)) result.setFastestLapNumber(-1);
                    else result.setFastestLapNumber(Integer.parseInt(s1));
                    result.setLapsCompleted(Integer.parseInt(removeQuotes(sa[16])));
                    result.setIncidents(Integer.parseInt(removeQuotes(sa[17])));
                    if (isHosted) {
                        result.setClubId(Integer.parseInt(removeQuotes(sa[18])));
                        result.setClubName(removeQuotes(sa[19]));
                        result.setHostedSessionName(removeQuotes(sa[20]));
                    } else {
                        s1 = removeQuotes(sa[18]);
                        if (!"".equals(s1)) result.setPoints(Integer.parseInt(s1));
                        s1 = removeQuotes(sa[19]);
                        if (!"".equals(s1)) result.setClubPoints(Integer.parseInt(s1));
                        result.setDivision(Integer.parseInt(removeQuotes(sa[20])));
                        result.setClubId(Integer.parseInt(removeQuotes(sa[21])));
                        result.setClubName(removeQuotes(sa[22]));
                        result.setOldIrating(Integer.parseInt(removeQuotes(sa[23])));
                        result.setNewIrating(Integer.parseInt(removeQuotes(sa[24])));
                        result.setOldLicenseLevel(Integer.parseInt(removeQuotes(sa[25])));
                        result.setOldLicenseSubLevel(Integer.parseInt(removeQuotes(sa[26])));
                        result.setNewLicenseLevel(Integer.parseInt(removeQuotes(sa[27])));
                        result.setNewLicenseSubLevel(Integer.parseInt(removeQuotes(sa[28])));
                        result.setSeriesName(removeQuotes(sa[29]));
                    }
                    driverResults.add(result);
                }
            }
        }
        output.setDriverResults(driverResults);
        return output;
    }
    
    private static String removeQuotes(String input) {
        return input.substring(1, input.length() - 1);
    }
    
}