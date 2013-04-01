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
public class SpectatorSessionParser extends JsonParserBase {
    
    static List<SpectatorSession> parse(String json) {
        JSONParser parser = new JSONParser();
        List<SpectatorSession> output = null;
        try {
            JSONArray rootArray = (JSONArray)parser.parse(json);
            output = new ArrayList<SpectatorSession>();
            for (int i = 0; i < rootArray.size(); i++) {
                JSONObject r = (JSONObject)rootArray.get(i);
                SpectatorSession o = new SpectatorSession();
                o.setSubSessionStatus(getString(r, "subses_status"));
                o.setSessionStatus(getString(r, "ses_status"));
                
                JSONObject b = (JSONObject)r.get("broadcast");
                SpectatorSession.BroadcastInfo bi = new SpectatorSession.BroadcastInfo();
                bi.setCanBroadcast((Boolean)b.get("canBroadcast"));
                bi.setSubSessionId(getLong(b, "subSessionId"));
                bi.setBroadcaster((Boolean)b.get("isBroadcaster"));
                bi.setMaximumUsers(getInt(b, "maxUsers"));
                bi.setAvailableSpectatorSlots(getInt(b, "availSpectatorSlots"));
                bi.setNumberOfDrivers(getInt(b, "numDrivers"));
                bi.setNumberOfDriverSlots(getInt(b, "numDriverSlots"));
                bi.setNumberOfSpectators(getInt(b, "numSpectators"));
                bi.setNumberOfBroadcasters(getInt(b, "numBroadcasters"));
                bi.setNumberOfSpectatorSlots(getInt(b, "numSpectatorSlots"));
                bi.setAvailableReservedBroadcasterSlots(getInt(b, "availReservedBCasterSlots"));
                bi.setCanWatch((Boolean)b.get("canWatch"));
                o.setBroadcastInfo(bi);
                
                o.setSubSessionId(getLong(r, "subsessionid"));
                o.setSessionId(getLong(r, "sessionid"));
                o.setSeriesId(getInt(r, "seriesid"));
                o.setTrackId(getInt(r, "trackid"));
                
                JSONObject h = (JSONObject)r.get("hosted");
                if (h != null) {
                    SpectatorSession.HostedInfo hi = new SpectatorSession.HostedInfo();
                    hi.setHeatFilterAmount(getInt(h, "heatFilterAmount"));
                    hi.setPracticeLength(getInt(h, "practiceLength"));
                    JSONArray a = (JSONArray)h.get("admins");
                    List<SpectatorSession.DriverInfo> driverList = new ArrayList<SpectatorSession.DriverInfo>();
                    for (int j = 0; j < a.size(); j++) {
                        JSONObject ar = (JSONObject)a.get(j);
                        if (ar != null) {
                            SpectatorSession.DriverInfo di = new SpectatorSession.DriverInfo();
                            di.setCustomerId(getLong(ar, "custId"));
                            di.setName(getString(ar, "displayName", true));
                            driverList.add(di);
                        }
                    }
                    hi.setAdministrators(driverList);
                    hi.setOrderId(getLong(h, "orderId"));
                    hi.setMaximumIrating(getInt(h, "maxIR"));
                    hi.setMinimumLicenseLevel(getInt(h, "minLicLevel"));
                    hi.setRootPrivateSessionId(getLong(h, "rootPrivateSessionId"));
                    hi.setDescription(getString(h, "desc", true));
                    hi.setFastTows(getInt(h, "fastTows"));
                    hi.setQualifyingLength(getInt(h, "qualLength"));
                    hi.setRaceLength(getInt(h, "raceLength"));
                    hi.setRestrictResults((getInt(h, "restrictResults")) == 1);
                    hi.setHardcoreLevelId(getInt(h, "hardcoreLevel"));
                    hi.setId(getLong(h, "id"));
                    hi.setMaximumLicenseLevel(getInt(h, "maxLicLevel"));
                    hi.setQualifyingLaps(getInt(h, "qualLaps"));
                    hi.setHostName(getString(h, "host", true));
                    // TODO: handle allowed clubs/leagues/teams
                    hi.setRaceLaps(getInt(h, "raceLaps"));
                    hi.setNumberOfServers(getInt(h, "numServers"));
                    hi.setCustomerId(getLong(h, "custid"));
                    // TODO: handle league info
                    hi.setHeatGridType(getInt(h, "heatGridType"));
                    hi.setExpires(new Date(getLong(h, "expires")));
                    hi.setHeatAddedDrivers(getInt(h, "heatAddedDrivers"));
                    hi.setNumberOfServersFinished(getInt(h, "numServersFinished"));
                    hi.setMultiClass((getInt(h, "multiClass")) == 1);
                    hi.setRestrictViewing((getInt(h, "restrictViewing")) == 1);
                    hi.setSessionName(getString(h, "sessionName", true));
                    List<Integer> carList = new ArrayList<Integer>();
                    JSONArray ca = (JSONArray)h.get("carIds");
                    for (int j = 0; j < ca.size(); j++) {
                        carList.add(((Long)ca.get(j)).intValue());
                    }
                    hi.setCars(carList);
                    hi.setReason(getString(h, "reason", true));
                    hi.setTrackId(getInt(h, "trackId"));
                    hi.setLaunchAt(new Date(getLong(h, "launchAt")));
                    hi.setMaximumDrivers(getInt(h, "maxDrivers"));
                    hi.setSessionId(getLong(h, "sessionId"));
                    hi.setHeatGridsId(getInt(h, "heatGridsId"));
                    hi.setParentPrivateSessionId(getLong(h, "parentPrivateSessionId"));
                    hi.setNightMode((getInt(h, "nightMode")) == 1);
                    hi.setHeatSessionType(getInt(h, "heatSessionType"));
                    hi.setHeatFilterType(getInt(h, "heatFilterType"));
                    hi.setHeatFinal((getInt(h, "heatFinal")) == 1);
                    hi.setCreated(new Date(getLong(h, "created")));
                    hi.setCautions((getInt(h, "cautions")) == 1);
                    hi.setFixedSetup((getInt(h, "fixedSetup")) == 1);
                    hi.setRestartType(getInt(h, "restartType"));
                    hi.setTimeLimit(getInt(h, "timeLimit"));
                    hi.setPasswordProtected((Boolean)h.get("pwdProtected"));
                    hi.setFarmId(getInt(h, "farmId"));
                    hi.setStatus(getInt(h, "status"));
                    hi.setLoneQualifying((getInt(h, "loneQualify")) == 1);
                    hi.setRollingStart((getInt(h, "rollingStarts")) == 1);
                    hi.setNumberOfServersStarted(getInt(h, "numServersStarted"));
                    JSONArray ff = (JSONArray)h.get("maxPercentFuelFills");
                    List<Integer> fuelList = new ArrayList<Integer>();
                    for (int j = 0; j < ff.size(); j++) {
                        fuelList.add(((Long)ff.get(j)).intValue());
                    }
                    // TODO: finish handling % fuel fills
                    hi.setMinimumIrating(getInt(h, "minIR"));
                    o.setHostedInfo(hi);
                }
                o.setStartTime(new Date(getLong(r, "start_time")));
                o.setEventTypeId(getInt(r, "evttype"));
                o.setPrivateSessionId(getLong(r, "privatesessionid"));
                o.setSeasonId(getInt(r, "seasonid"));
                output.add(o);
            }
        } catch (ParseException ex) {
            Logger.getLogger(SpectatorSessionParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
}