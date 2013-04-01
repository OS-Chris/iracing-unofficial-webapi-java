package iracing.webapi;

import java.io.*;
import java.net.*;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.*;
import javax.security.auth.login.LoginException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class IracingWebApi {

    public interface LoginRequiredHandler {
        boolean onLoginCredentialsRequired(IracingLoginCredentials creds);
    }
    
    public static final int VERSION = 1;
    
    // TODO: add event handlers for friend requests and new PM notifications
    //       so they are not missed
    
    // TODO
    // - Provide the ability to get world records
    
    private static final String MAINTENANCE_URL = "http://members.iracing.com/updating/maintenanceupdate.htm";
    private static final String MESSAGE_INBOX_URL = "http://members.iracing.com/jforum/pm/inbox.page";
    private static final String MESSAGE_READ_URL = "http://members.iracing.com/jforum/pm/read/";
    private static final String LOGIN_URL = "https://members.iracing.com/membersite/Login";
    private static final String ACCOUNT_URL = "https://members.iracing.com/membersite/account/Home.do";
    private static final String FORUM_LOGIN_URL = "http://members.iracing.com/jforum/search/filters.page"; // the search page is used as it's a small page that still requires login
    private static final String FORUM_POST_PAGE_URL = "http://members.iracing.com/jforum/jforum.page";
    private static final String DRIVER_PROFILE_URL = "http://members.iracing.com/membersite/member/Profile.do";
    private static final String GET_RESULT_SUMMARIES_URL = "http://members.iracing.com/memberstats/member/GetResults";
    private static final String GET_HOSTED_RESULT_SUMMARIES_URL = "http://members.iracing.com/memberstats/member/GetPrivateSessionResults";
    private static final String GET_HOSTED_SESSIONS_URL = "http://members.iracing.com/membersite/member/GetHostedSessions?ts=0";
    private static final String GET_RACE_RESULT_CSV_URL = "http://members.iracing.com/membersite/member/GetEventResultsAsCSV";
    private static final String GET_SESSION_DRIVER_LAPS_URL = "http://members.iracing.com/membersite/member/GetLaps";
    private static final String GET_SESSION_DRIVERS_URL = "http://members.iracing.com/membersite/member/GetSessionDrivers";
    private static final String GET_OPEN_SESSION_DRIVERS_URL = "http://members.iracing.com/membersite/member/GetOpenSessionDrivers"; // open practice sessions
    private static final String GET_HOSTED_SESSION_DRIVERS_URL = "http://members.iracing.com/membersite/member/GetPrivateSessionRegistered"; // hosted sessions
    private static final String DRIVER_SEARCH_URL = "http://members.iracing.com/membersite/member/GetDriverStatus";
    private static final String GLOBAL_DATA_URL = "http://members.iracing.com/membersite/member/HostedSessions.do"; //"http://members.iracing.com/membersite/member/CareerStats.do"; //"http://members.iracing.com/membersite/member/SeriesStandings.do?season=672";
    private static final String GET_SEASON_STANDINGS_URL = "http://members.iracing.com/memberstats/member/GetSeasonStandings";
    private static final String GET_SEASON_QUALIFYING_RESULTS_URL = "http://members.iracing.com/memberstats/member/GetSeasonQualifyResults";
    private static final String GET_SEASON_TIME_TRIAL_STANDINGS_URL = "http://members.iracing.com/memberstats/member/GetSeasonTTStandings";
    private static final String GET_TIME_TRIAL_RESULTS_URL = "http://members.iracing.com/memberstats/member/GetSeasonTTResults";
    private static final String GET_SPECTATOR_SESSIONS_URL = "http://members.iracing.com/membersite/member/GetSpectatorSessions";
    private static final String GET_WORLD_RECORDS_URL = "http://members.iracing.com/memberstats/member/GetWorldRecords";
    private static final String GET_DRIVER_STATS_URL = "http://members.iracing.com/memberstats/member/GetDriverStats";
    
    private static final String CERT_STORE_PASSWORD = "changeit";
    
    private static final String JSESSIONID = "JSESSIONID";
    private static final String JFORUMSESSIONID = "JFORUMSESSIONID";
    private static final String SET_COOKIE = "Set-Cookie";
    private static final String COOKIE = "Cookie";
    private static final String BOUNDRY = "---------------------------41184676334";
    private static final String lineEnd = "\r\n";
    private static final String twoHyphens = "--";
    
    private static final int CUSTOMER_DEFINITION_TYPE_ID = 1;
    private static final int CUSTOMER_DEFINITION_TYPE_NAME = 2;
    
    private String cookie = "";
    private Map<String, String> cookieMap;
//    private GlobalDataDao globalDataDao;
//    private GlobalDataParser globalData;
    private GlobalData globalData;
    private long bytesReceived = 0;
    private LoginRequiredHandler loginRequiredHandler;
    
    public IracingWebApi() {
        cookieMap = new HashMap<String, String>();
    }
    
    public void setLoginRequiredHandler(LoginRequiredHandler handler) {
        loginRequiredHandler = handler;
    }

    public long getBytesReceived() {
        return bytesReceived;
    }
    
    public void resetBytesReceived() {
        bytesReceived = 0;
    }

    /**
     * Test the API.
     * @param args 
     */
    public static void main(String[] args) {
        IracingWebApi webApi = new IracingWebApi();
        webApi.setLoginRequiredHandler(new LoginRequiredHandler() {
            @Override
            public boolean onLoginCredentialsRequired(IracingLoginCredentials creds) {
                creds.setEmailAddress("");  // <- Set your iRacing email address here
                creds.setPassword("");  // <- Set your iRacing password here
                return true;
            }
        });
        try {
//            long customerId = webApi.lookupCustomerId("Christian Aylward");
//            System.err.println("customer id : " + customerId);
            
            //System.err.println("apiUser: { id:" + webApi.accountInfo.getCustomer().getId() + ", name:\"" + webApi.accountInfo.getCustomer().getName() + "\" }");
            
//            String name = webApi.lookupCustomerName(29462);
//            System.err.println("customer name : " + name);
            
//            String[] userData = webApi.getUserData();
//            if (userData != null) {
//                for (String s : userData) System.out.println(s);
//            }
            
            // Send a private message by name
//            SendPrivateMessageResult result = webApi.sendPrivateMessage("Christian Aylward", "testing again", "..");
            // Send a private message by customer ID
//            SendPrivateMessageResult result = webApi.sendPrivateMessage(29462, "testing again", "..");
//            System.err.println("Send message result : " + result);
//            SendPrivateMessageResult result = SendPrivateMessageResult.SUCCESS;
//            while (result == SendPrivateMessageResult.SUCCESS) {
//                result = webApi.sendPrivateMessage("Christian Aylward", "testing for full mailbox", "..");
//            }
            
//            List<PrivateMessageHeader> messages = webApi.getAllPrivateMessages();
//            if (messages != null) {
//                System.err.println("Parsed " + messages.size() + " messages");
//                System.err.println("------------------------------");
//                for (PrivateMessageHeader pm : messages) {
//                    System.err.println("pm {");
//                    System.err.println("  id: " + pm.getId());
//                    System.err.println("  subject: " + pm.getSubject());
//                    System.err.println("  from {");
//                    System.err.println("    id: " + pm.getFrom().getId());
//                    System.err.println("    name: " + pm.getFrom().getName());
//                    System.err.println("  }");
//                    System.err.println("  date: " + pm.getDate().toLocaleString());
//                    System.err.println("}");
//                }
//            }
            
//            List<Long> messageIds = new ArrayList();
//            messageIds.add(3326572L);
//            messageIds.add(3301088L);
//            webApi.deletePrivateMessages(messageIds);
//            webApi.deletePrivateMessage(3372968L);
            
//            SessionResultSummary.SearchParameters params = new SessionResultSummary.SearchParameters(true, false);
//            params.setIncludeOfficialSessions(true);
//            params.setIncludeUnofficialSessions(true);
//            params.setIncludeQualifyingSessions(true);
//            params.setCustomerId(27251);
//            params.setSeasonQuarter(2);
//            params.setUpperBound(10);
//            List<SessionResultSummary> list = webApi.getSessionResultSummaries(params);
//            for (SessionResultSummary summary : list) {
//                System.err.println(summary.getSubSessionId());
//            }
            
//            List<HostedSessionSummary> hostedSessions = webApi.getHostedSessions();
//            for (HostedSessionSummary summary : hostedSessions) {
//                System.err.println("------------------");
//                System.err.println(summary.getSessionName());
//                if (!"".equals(summary.getSessionDescription())) {
//                    System.err.println(summary.getSessionDescription());
//                }
//            }
            
//            HostedSessionResultSummary.SearchParameters params = new HostedSessionResultSummary.SearchParameters();
//            params.setParticipantCustomerId(29462);
//            params.setEnd(20);
//            HostedSessionResultSummaries summaries = webApi.getHostedSessionResultSummaries(params);
//            for (HostedSessionResultSummary summary : summaries.getResults()) {
//                System.err.println(summary.getSessionName());
//            }
            
//            long subSessionId = 5916582L;
//            long customerId = 34038;
//            SessionDriverLaps laps1 = webApi.getSessionDriverLaps(customerId, subSessionId, 0);
//            SessionDriverLaps laps2 = webApi.getSessionDriverLaps(customerId, subSessionId, -1);
//            SessionDriverLaps laps3 = webApi.getSessionDriverLaps(customerId, subSessionId, -2);
//            System.err.println("== Race laps ==");
//            for (SessionDriverLap lap : laps1.getLaps()) {
//                double time = (double)lap.getLapTime() / 10000;
//                System.err.println(lap.getLapNumber() + " : " + time);
//            }
//            System.err.println("== Qualifying laps ==");
//            for (SessionDriverLap lap : laps2.getLaps()) {
//                double time = (double)lap.getLapTime() / 10000;
//                System.err.println(lap.getLapNumber() + " : " + time);
//            }
//            System.err.println("== Practice laps ==");
//            for (SessionDriverLap lap : laps3.getLaps()) {
//                double time = (double)lap.getLapTime() / 10000;
//                System.err.println(lap.getLapNumber() + " : " + time);
//            }
            
//            SessionResult sessionResult = webApi.getSessionResult(5916582, true); //5923645); //5861385); //5878460);
//            if (sessionResult != null) {
//                System.err.println("=================");
//                System.err.println(sessionResult.getSeriesName());
//                System.err.println("-----------------");
//                for (SessionSubResult result : sessionResult.getSubResults()) {
//                    System.err.println(getEventTypeName(result.getEventTypeId()).toUpperCase());
//                    System.err.println("-----------------");
//                    for (SessionDriverResult driverResult : result.getDriverResults()) {
//                        System.err.println(driverResult.getCustomerName() + " : " + driverResult.getFastestLapTime() + " (" + driverResult.getDriverLaps().getLaps().size() + ")");
//                    }
//                    System.err.println("-----------------");
//                }
//            }
            
//            SessionDriverList drivers = webApi.getLiveSessionDrivers(5878460);
//            for (SessionDriver driver : drivers.getDrivers()) {
//                System.err.println(driver.getCustomerId() + " : " + driver.getName());
//            }
            
//            List<HostedSessionSummary> hostedSessions = webApi.getLiveHostedSessions();
//            for (HostedSessionSummary hostedSession : hostedSessions) {
//                String host = hostedSession.getHost().getName();
//                System.err.println("==========================");
//                System.err.println(hostedSession.getSessionName() + " (" + host + ")");
//                System.err.println("--------------------------");
//                SessionDriverList drivers = webApi.getLiveHostedSessionDrivers(hostedSession.getSubSessionId(), hostedSession.getPrivateSessionId());
//                for (SessionDriver driver : drivers.getDrivers()) {
//                    System.err.println(driver.getName());
//                }
//                System.err.println("==========================");
//            }
            
            SeasonStandings.SearchParameters params = new SeasonStandings.SearchParameters();
            params.setEnd(5);
            params.setSeasonId(672);
            long totalRecords = webApi.getSeasonStandings(params, new SeasonStandingsParser.ItemHandler() {
                @Override
                public boolean onSeasonStandingParsed(SeasonStanding standing) {
                    System.err.println(standing.getDriverName() + " (" + standing.getTotalPoints() + ")");
                    return true;
                }
            });
            System.err.println("TOTAL RECORDS : " + totalRecords);
            
//            SeasonQualifyingResults.SearchParameters params = new SeasonQualifyingResults.SearchParameters();
//            params.setEnd(5);
//            params.setCarClassId(25);
//            params.setSeasonId(672);
//            SeasonQualifyingResults results = webApi.getSeasonQualifyingResults(params);
//            for (SeasonQualifyingResult result : results.getResults()) {
//                System.err.println(result.getDriverName() + " (" + result.getBestQualifyingTimeFormatted() + ")");
//            }
//            System.err.println("TOTAL RECORDS : " + results.getTotalRecords());
            
//            SeasonTimeTrialStandings.SearchParameters params = new SeasonTimeTrialStandings.SearchParameters();
//            params.setEnd(5);
//            params.setCarClassId(25);
//            params.setSeasonId(672);
//            SeasonTimeTrialStandings standings = webApi.getSeasonTimeTrialStandings(params);
//            for (SeasonTimeTrialStanding standing : standings.getStandings()) {
//                System.err.println(standing.getDriverName() + " (" + standing.getTotalPoints() + ")");
//            }
//            System.err.println("TOTAL RECORDS : " + standings.getTotalRecords());
            
//            TimeTrialResultStandings.SearchParameters params = new TimeTrialResultStandings.SearchParameters();
//            params.setCarClassId(25);
//            params.setSeasonId(672);
//            params.setRaceWeek(8);
//            params.setEnd(5);
//            //params.setDivision(DIVISION_ALL);
//            TimeTrialResultStandings standings = webApi.getTimeTrialResultStandings(params);
//            for (TimeTrialResultStanding standing : standings.getStandings()) {
//                System.err.println(standing.getDriverName() + " (" + standing.getPoints() + ")");
//            }
//            System.err.println("TOTAL RECORDS : " + standings.getTotalRecords());
            
//            GlobalData data = webApi.getGlobalData();
//            for (Division d : data.getDivisions()) {
//                System.err.println(d.getShortName());
//            }
//            for (EventType e : data.getEventTypes()) {
//                System.err.println(e.getName());
//            }
//            for (Category c : data.getCategories()) {
//                System.err.println(c.getName());
//            }
//            for (License l : data.getLicenses()) {
//                System.err.println(l.getFullName());
//            }
//            for (Track t : data.getTracks()) {
//                String s = t.getName();
//                if (!"".equals(t.getConfigName())) s += " - " + t.getConfigName();
//                System.err.println(s);
//            }
//            for (Car c : data.getCars()) {
//                System.err.println(c.getName());
//            }
//            for (CarClass cc : data.getCarClasses()) {
//                System.err.println(cc.getName());
//            }
//            for (Season s : data.getSeasons()) {
//                System.err.println(s.getSeriesShortName() + " - " + s.getSeasonShortName());
//            }
//            for (YearAndQuarters yaq : data.getYearAndQuarters()) {
//                System.err.println(yaq.getYear() + " : " + yaq.getQuarters().size());
//            }
//            for (LicenseGroup lg : data.getLicenseGroups()) {
//                System.err.println(lg.getName());
//            }
//            for (LicenseLevel ll : data.getLicenseLevels()) {
//                System.err.println(ll.getName());
//            }
//            for (HardcoreOption ho : data.getHardcoreOptions()) {
//                System.err.println(ho.getName());
//            }
//            for (Club c : data.getClubs()) {
//                System.err.println(c.getShortName());
//            }
            
//            getV8QualifyingStats(webApi);
            
//            GlobalDataDao globalData = webApi.getGlobalData();
////            CarClass cc = globalData.getCarClass(25);
////            System.err.println(cc.getName());
//            
//            List<SpectatorSession> sessions = webApi.getSpectatorSessions();
//            for (SpectatorSession session : sessions) {
//                if (session.getBroadcastInfo().getNumberOfDrivers() > 0) {
//                    String s = String.valueOf(session.getSubSessionId());
//                    if (session.getHostedInfo() != null) {
//                        s += " : " + session.getHostedInfo().getSessionName();
//                    } else {
//                        Season season = globalData.getSeason(session.getSeasonId());
//                        EventType et = globalData.getEventType(session.getEventTypeId());
//                        s += " - " + season.getSeriesName() + " (" + et.getName() + ")";
//                    }
//                    s += " (" + session.getBroadcastInfo().getNumberOfDrivers() + ")";
//                    System.err.println(s);
//                }
//            }
            
//            WorldRecord.SearchParameters params = new WorldRecord.SearchParameters();
//            params.setCustomerId(29462);
//            params.setCarId(33);
//            params.setEnd(5);
//            params.setSeasonYear(2011);
//            params.setTrackId(46);
//            WorldRecords records = webApi.getWorldRecords(params, true);
//            for (WorldRecord record : records.getRecords()) {
//                String s = record.getRecordNumber() + " : " + record.getDriver().getName();
//                s += " (" + record.getPractice() + ")";
//                System.err.println(s);
//            }
            
//            DriverStat.SearchParameters params = new DriverStat.SearchParameters();
//            params.setCategoryId(2); // road
//            params.setActiveDriversOnly(true);
//            params.setUserFilter(UserFilter.FRIENDS);
//            params.setEnd(10);
//            DriverStats stats = webApi.getDriverStats(params, false);
//            for (DriverStat stat : stats.getStats()) {
//                System.err.println(stat.getRecordNumber() + " : " + stat.getIrating() + " " + stat.getDriver().getName());
//            }
            
            System.err.println("Bytes received : " + webApi.getBytesReceived());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void getV8QualifyingStats(IracingWebApi webApi) throws IOException, LoginException {
        // get a list of all drivers who have set a qualifying time
        SeasonQualifyingResults.SearchParameters params = new SeasonQualifyingResults.SearchParameters();
        params.setCarClassId(25);
        params.setSeasonId(672);
        params.setRaceWeek(8);
        params.setStart(1);
        params.setEnd(25);
        SeasonQualifyingResults results = webApi.getSeasonQualifyingResults(params);
        // for each driver who has set a time, check how many qualifying sessions they've entered
        for (SeasonQualifyingResult result : results.getResults()) {
            SessionResultSummary.SearchParameters params2 = new SessionResultSummary.SearchParameters(true, false);
            params2.setIncludeOfficialSessions(true);
            params2.setIncludeUnofficialSessions(true);
            params2.setIncludeQualifyingSessions(true);
            params2.setCustomerId(result.getDriverCustomerId());
            params2.setSeriesId(88);
            params2.setCarClassId(25);
            params2.setCarId(28);
            params2.setSeasonYear(2012);
            params2.setSeasonQuarter(2);
            params2.setRaceWeek(8);
            List<SessionResultSummary> summaries = webApi.getSessionResultSummaries(params2);
//            for (SessionResultSummary summary : summaries) {
//                System.err.println("  " + summary.getDisplayName());
//            }
            System.err.println(result.getPosition() + " : " + result.getDriverName() + " (" + summaries.size() + ")");
        }
    }
    
    private void createCookieFromMap() {
        StringBuilder sb = new StringBuilder();
        for (String key : cookieMap.keySet()) {
            if (sb.length() > 0) sb.append("; ");
            sb.append(key).append("=").append(cookieMap.get(key));
        }
        cookie = sb.toString();
//        System.err.println("Cookie is : " + cookie);
    }
    
    private void installCerts() throws Exception {
        String host = "members.iracing.com";
        int port = 443;
        
        char[] password = CERT_STORE_PASSWORD.toCharArray();

        File file = new File("jssecacerts");
        if (!file.isFile()) {
            char seperator = File.separatorChar;
            File dir = new File(System.getProperty("java.home") + seperator + "lib" + seperator + "security");
            file = new File(dir, "jssecacerts");
            if (!file.isFile()) {
                file = new File(dir, "cacerts");
            }
        }
        KeyStore ks;
        InputStream in = new FileInputStream(file);
        ks = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            ks.load(in, password);
        } catch(Exception e) {}
        in.close();

        SSLContext context = SSLContext.getInstance("TLS");
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);
        X509TrustManager defaultTrustManager = (X509TrustManager)tmf.getTrustManagers()[0];
        SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
        context.init(null, new TrustManager[] { tm }, null);
        SSLSocketFactory factory = context.getSocketFactory();

        SSLSocket socket = null;
        try {
            socket = (SSLSocket) factory.createSocket(host, port);
            socket.setSoTimeout(10000);
            socket.startHandshake();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
        }

        X509Certificate[] chain = tm.chain;
        if (chain == null) return;

        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        for (int i = 0; i < chain.length; i++) {
            X509Certificate cert = chain[i];
            sha1.update(cert.getEncoded());
            md5.update(cert.getEncoded());
        }

        for (int count = 0; count < chain.length; count++) {
            X509Certificate cert = chain[count];
            String alias = host + "-" + (count + 1);
            ks.setCertificateEntry(alias, cert);
            OutputStream out = new FileOutputStream("jssecacerts");
            try {
                ks.store(out, password);
            } finally {
                out.close();
            }
        }
    }

    private boolean isMaintenancePage(URLConnection conn) {
        String location = conn.getHeaderField("Location");
        if (location != null && location.startsWith(MAINTENANCE_URL)) {
            System.err.println("iRacing website is down for maintenance");
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @return a login response code
     * @throws IOException
     * @throws LoginException 
     * @see #LOGIN_RESPONSE_SUCCESS
     * @see #LOGIN_RESPONSE_CONNECTION_ERROR
     * @see #LOGIN_RESPONSE_DOWN_FOR_MAINTAINENCE
     * @see #LOGIN_RESPONSE_FAILED_CREDENTIALS
     */
    public LoginResponse login() throws IOException, LoginException {
        try {
            installCerts();
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new LoginException("error whilst attempting to install SSL certificates");
        }

        System.setProperty("javax.net.ssl.trustStore", "jssecacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", CERT_STORE_PASSWORD);

        if (loginRequiredHandler == null) return LoginResponse.ConfigError;
        IracingLoginCredentials creds = new IracingLoginCredentials();
        if (!loginRequiredHandler.onLoginCredentialsRequired(creds)) return LoginResponse.CredentialsError;
        String encodedUsername = URLEncoder.encode(creds.getEmailAddress(), "UTF-8");
        String encodedPW = URLEncoder.encode(creds.getPassword(), "UTF-8");

        String urltext = LOGIN_URL + "?username=" + encodedUsername + 
                "&password=" + encodedPW; // + "&utcoffset=-60&todaysdate=";

        URL url = new URL(urltext);

        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        conn.addRequestProperty("Content-Length", "0");

        conn.setInstanceFollowRedirects(false);
        HttpsURLConnection.setFollowRedirects(false);

        try {
            conn.connect();
        } catch (Exception e) {
            e.printStackTrace();
            throw new LoginException(e.getMessage());
        }

        if (isMaintenancePage(conn)) return LoginResponse.DownForMaintenance;
        
        String headerName;
        for (int i = 1; (headerName = conn.getHeaderFieldKey(i)) != null; i++) {
            if (headerName.equalsIgnoreCase(SET_COOKIE)) {
                addToCookieMap(conn.getHeaderField(i));
            } else {
                if (!headerName.equals("Location")) {
                    continue;
                }
                String location2 = conn.getHeaderField(i);

                if (location2.indexOf("failedlogin") != -1) {
                    throw new LoginException("You have been directed to the failed login page");
                }
            }
        }
        createCookieFromMap();

        conn.disconnect();
        
        return LoginResponse.Success;
    }

    private void addToCookieMap(String setCookieHeader) {
        StringTokenizer st = new StringTokenizer(setCookieHeader, ";");
        if (st.hasMoreTokens()) {
            String token = st.nextToken();
            String name = token.substring(0, token.indexOf('='));
            String value = token.substring(token.indexOf('=') + 1, token.length());
            cookieMap.put(name, value);
        }
    }
    
    private boolean forumLoginAndGetCookie() {
        try {
            // Make a connect to the server
            URL url = new URL(FORUM_LOGIN_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.addRequestProperty(COOKIE, cookie);

            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);
            HttpURLConnection.setFollowRedirects(false);

            conn.connect();

            if (isMaintenancePage(conn)) return false;

            String headerName; boolean containsCookie = false;
            for (int i = 1; (headerName = conn.getHeaderFieldKey(i)) != null; i++) {
                if (headerName.equalsIgnoreCase(SET_COOKIE)) {
                    containsCookie = true;
                    addToCookieMap(conn.getHeaderField(i));
                }
            }
            if (containsCookie) createCookieFromMap();
            
            conn.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    private String getResponseText(URLConnection conn) throws IOException {
        byte[] bytes;
        // NOTE: The response is read into memory first before unzipping
        //       because it resulted in a 200% performance increase
        //       as opposed to unzipping directly from the connection inputstream
        // Read the response in to memory (GZipped or not)
        InputStream is = conn.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(b)) != -1) {
                baos.write(b, 0, bytesRead);
            }
            bytes = baos.toByteArray();
        } finally {
            baos.close();
            is.close();
        }
//        System.err.println(conn.getURL().toString());
        this.bytesReceived += bytes.length;
        // Unzip the response if necessary
        if ("gzip".equals(conn.getContentEncoding())) {
//            System.err.println("compressed : " + bytesReceived.length + " bytes");
            GZIPInputStream is2 = null;
            try {
                is2 = new GZIPInputStream(new ByteArrayInputStream(bytes));
                baos = new ByteArrayOutputStream();
                byte[] b = new byte[1024];
                int bytesRead;
                while ((bytesRead = is2.read(b)) != -1) {
                    baos.write(b, 0, bytesRead);
                }
                bytes = baos.toByteArray();
            } finally {
                baos.close();
                is2.close();
            }
        }
//        System.err.println("uncompressed : " + bytesReceived.length + " bytes");
        return new String(bytes);
    }
    
    private void addMultipartFormData(StringBuilder data, String key, String value) {
        data.append(twoHyphens).append(BOUNDRY).append(lineEnd);
        data.append("Content-Disposition: form-data; name=\"").append(key).append('"').append(lineEnd).append(lineEnd);
        if (value != null) data.append(value);
        data.append(lineEnd);
    }
    
    private String mapToRequestParamaters(Map<String, String> parameters) throws UnsupportedEncodingException {
        StringBuilder content = new StringBuilder();
        for (String key : parameters.keySet()) {
            if (content.length() > 0) content.append("&");
            content.append(key).append("=");
            content.append(URLEncoder.encode(parameters.get(key), "UTF-8"));
        }
        return content.toString();
    }
    
    private String doPostRequestUrlEncoded(boolean needForumCookie, String url, Map<String, String> parameters) throws IOException, LoginException {
        return doPostRequestUrlEncoded(needForumCookie, url, mapToRequestParamaters(parameters));
    }
    
    private String doPostRequestUrlEncoded(boolean needForumCookie, String url, String parameters) throws IOException, LoginException {
        if (!cookieMap.containsKey(JSESSIONID)) {
            if (login() != LoginResponse.Success) return null;
        }
        if (needForumCookie && !cookieMap.containsKey(JFORUMSESSIONID)) {
            if (!forumLoginAndGetCookie()) return null;
        }
        String output = null;
        try {
            // URL of CGI-Bin script.
            URL oUrl = new URL(url);
            // URL connection channel.
            HttpURLConnection urlConn = (HttpURLConnection)oUrl.openConnection();
            // Let the run-time system (RTS) know that we want input.
            urlConn.setDoInput(true);
            // Let the RTS know that we want to do output.
            urlConn.setDoOutput(true);
            // No caching, we want the real thing.
            urlConn.setUseCaches(false);
            urlConn.addRequestProperty(COOKIE, cookie);
            
            // request to have the response gzipped (bringing a 3.5Mb response down to 175kb)
            urlConn.addRequestProperty("Accept-Encoding", "gzip");
            
            urlConn.setRequestMethod("POST");
            // Specify the content type.
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            DataOutputStream printout = new DataOutputStream(urlConn.getOutputStream());
            try {
                printout.writeBytes(parameters);
                printout.flush();
            } finally {
                printout.close();
            }
            
            output = getResponseText(urlConn);
//            System.out.println(output);
            
            urlConn.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
    
    private String doGetRequest(boolean needForumCookie, String url) throws IOException, LoginException {
        return doGetRequest(needForumCookie, url, null);
    }
    
    private String doGetRequest(boolean needForumCookie, String url, String userAgent) throws IOException, LoginException {
        if (!cookieMap.containsKey(JSESSIONID)) {
            if (login() != LoginResponse.Success) return null;
        }
        if (needForumCookie && !cookieMap.containsKey(JFORUMSESSIONID)) {
            if (!forumLoginAndGetCookie()) return null;
        }
        String output = null;
        try {
            // Make a connection
            URL oUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)oUrl.openConnection();

            conn.addRequestProperty(COOKIE, cookie);
            
            // request to have the response gzipped (bringing a 3.5Mb response down to 175kb)
            conn.addRequestProperty("Accept-Encoding", "gzip");
            if (userAgent != null) conn.addRequestProperty("User-Agent", userAgent);
            
//            conn.setDoInput(true);
//            conn.setUseCaches(false);
//            conn.setInstanceFollowRedirects(false);
//            HttpURLConnection.setFollowRedirects(false);

    //        logger.debug("opening connection to " + url.getFile());
            conn.connect();

            if (isMaintenancePage(conn)) return null;

            // Ensure we got the HTTP 200 response code
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new Exception(String.format("Received the response code %d from the URL %s : %s", responseCode, url, conn.getResponseMessage()));
            }

            // Read the response
            output = getResponseText(conn);
//            System.out.println(output);
            
            conn.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
    
//    public void setGlobalDataDao(GlobalDataDao dao) {
//        this.globalDataDao = dao;
//    }
    
//    private void updateGlobalData() throws IOException, LoginException {
//        String html = doGetRequest(false, "http://members.iracing.com/membersite/member/SeriesStandings.do?season=672");
//        globalData = new GlobalDataParser();
//        globalData.parse(html);
//    }
    
//    public GlobalDataParser getGlobalData() throws IOException, LoginException {
//        if (globalData == null) {
//            updateGlobalData();
//        }
//        return globalData;
//    }
    
//    public GlobalDataDao getGlobalData() throws IOException, LoginException {
//        if (globalDataDao == null) {
//            globalDataDao = new GlobalDataInMemoryDao();
//        }
//        if (globalDataDao.getLastUpdate() == null) {
//            String html = doGetRequest(false, GLOBAL_DATA_URL);
//            GlobalDataParser.parse(html, globalDataDao);
//        }
//        return globalDataDao;
//    }
    
    public GlobalData getGlobalData() throws IOException, LoginException {
        if (globalData == null) {
            String html = doGetRequest(false, GLOBAL_DATA_URL);
            globalData = GlobalDataParser.parse(html);
        }
        return globalData;
    }
    
    private String lookupCustomer_GetResponse(String customerNameOrId) throws IOException, LoginException  {
        return doGetRequest(false, DRIVER_SEARCH_URL + "?searchTerms=" + URLEncoder.encode(customerNameOrId, "UTF-8"));
    }
    
    public String lookupCustomerName(long customerId) throws IOException, LoginException {
        // Valid ID's start at 15052
        if (customerId < 15052) return null;
        // example output
        //{"friends":false,"search":1,"studied":false,"searchRacers":[{"userRole":0,"lastSeen":0,"broadcast":{},"privateSession":{},"spotterAccess":0,"lastLogin":1337689089000,"subSessionStatus":"","name":"Christian+Aylward","helmet":{"ll":14,"c3":95,"hp":19,"c1":253,"c2":71},"regOpen":false,"custid":29462}],"fsRacers":[]}
        String output = null, response = lookupCustomer_GetResponse(String.valueOf(customerId));
        if (response == null) return null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject)parser.parse(response);
            JSONArray jsonSearchResults = (JSONArray)jsonObj.get("searchRacers");
            for (int i = 0; i < jsonSearchResults.size(); i++) {
                JSONObject jsonSearchResult = (JSONObject)jsonSearchResults.get(i);
                long id = (Long)jsonSearchResult.get("custid");
                if (id == customerId) {
                    output = URLDecoder.decode((String)jsonSearchResult.get("name"), "UTF-8");
                    break;
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
    
    public long lookupCustomerId(String customerName) throws IOException, LoginException {
        // example output
        //{"friends":false,"search":1,"studied":false,"searchRacers":[{"userRole":0,"lastSeen":0,"broadcast":{},"privateSession":{},"spotterAccess":0,"lastLogin":1337689089000,"subSessionStatus":"","name":"Christian+Aylward","helmet":{"ll":14,"c3":95,"hp":19,"c1":253,"c2":71},"regOpen":false,"custid":29462}],"fsRacers":[]}
        String response = lookupCustomer_GetResponse(customerName);
        if (response == null) return 0;
        long output = 0;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject)parser.parse(response);
            JSONArray jsonSearchResults = (JSONArray)jsonObj.get("searchRacers");
            for (int i = 0; i < jsonSearchResults.size(); i++) {
                JSONObject jsonSearchResult = (JSONObject)jsonSearchResults.get(i);
                String name = URLDecoder.decode((String)jsonSearchResult.get("name"), "UTF-8");
                if (name.equals(customerName)) {
                    output = (Long)jsonSearchResult.get("custid");
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
    
    public SendPrivateMessageResult sendPrivateMessage(long customerId, String subject, String message) throws IOException, LoginException {
        return sendPrivateMessage(CUSTOMER_DEFINITION_TYPE_ID, String.valueOf(customerId), subject, message);
    }
    
    public SendPrivateMessageResult sendPrivateMessage(String customerName, String subject, String message) throws IOException, LoginException {
        return sendPrivateMessage(CUSTOMER_DEFINITION_TYPE_NAME, customerName, subject, message);
    }
    
    private SendPrivateMessageResult sendPrivateMessage(int customerDefinitionType, String customer, String subject, String message) throws IOException, LoginException {
        if (!cookieMap.containsKey(JSESSIONID)) {
            if (login() != LoginResponse.Success) return SendPrivateMessageResult.UNABLE_TO_LOGIN;
        }
        SendPrivateMessageResult output = SendPrivateMessageResult.UNKNOWN_ERROR;
        if (!cookieMap.containsKey(JFORUMSESSIONID)) {
            if (!forumLoginAndGetCookie()) return SendPrivateMessageResult.UNABLE_TO_LOGIN;
        }
        try {
            // Make a connection
            URL url = new URL(FORUM_POST_PAGE_URL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            //multipart/form-data
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            //conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDRY);

            conn.addRequestProperty(COOKIE, cookie);

            StringBuilder data = new StringBuilder();
            
            // set the multipart form data parameters
            addMultipartFormData(data, "action", "sendSave");
            addMultipartFormData(data, "module", "pm");
            addMultipartFormData(data, "preview", "0");
            addMultipartFormData(data, "start", null);
            if (customerDefinitionType == CUSTOMER_DEFINITION_TYPE_ID) {
                addMultipartFormData(data, "toUsername", null);
                addMultipartFormData(data, "toUserId", customer);
            } else if (customerDefinitionType == CUSTOMER_DEFINITION_TYPE_NAME) {
                addMultipartFormData(data, "toUsername", customer);
                addMultipartFormData(data, "toUserId", null);
            }
            addMultipartFormData(data, "disa1ble_html", "on");
            addMultipartFormData(data, "attach_sig", "on");
            addMultipartFormData(data, "subject", subject);
            addMultipartFormData(data, "message", message);
            addMultipartFormData(data, "addbbcode24", "#444444");
            addMultipartFormData(data, "addbbcode26", "12");
            addMultipartFormData(data, "helpbox", "Italic Text: [i]Text[/i]  (alt+i)");

            data.append(twoHyphens).append(BOUNDRY).append(twoHyphens);
            DataOutputStream dataOS = new DataOutputStream(conn.getOutputStream());
            try {
                dataOS.writeBytes(data.toString());
                dataOS.flush();
            } finally {
                dataOS.close();
            }

            conn.connect();
            
            if (isMaintenancePage(conn)) return SendPrivateMessageResult.UNABLE_TO_LOGIN;

            // Ensure we got the HTTP 200 response code
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new Exception(String.format("Received the response code %d from the URL %s : %s", responseCode, url, conn.getResponseMessage()));
            }
            
            String response = getResponseText(conn);
//            System.out.println(response);
            
            if (response.contains("Your message was successfully sent.")) {
                output = SendPrivateMessageResult.SUCCESS;
            } else if (response.contains("Could not determine the user id. Please check if you typed the username correctly and try again.")) {
                output = SendPrivateMessageResult.USER_NOT_FOUND;
            } else if (response.contains("Sorry, but this users inbox is currently full and cannot receive private messages at this time.")) {
                output = SendPrivateMessageResult.MAILBOX_FULL;
            }
            
            conn.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
    
    public void deletePrivateMessage(long messageId) throws IOException, LoginException {
        deletePrivateMessagesImpl("id=" + messageId);
    }
    
    public void deletePrivateMessages(List<Long> messageIds) throws IOException, LoginException {
        StringBuilder params = new StringBuilder();
        for (Long id : messageIds) {
            if (params.length() > 0) params.append("&");
            params.append("id=").append(id);
        }
        deletePrivateMessagesImpl(params.toString());
    }
    
    private void deletePrivateMessagesImpl(String ids) throws IOException, LoginException {
        StringBuilder params = new StringBuilder();
        params.append("module=").append(URLEncoder.encode("pm", "UTF-8"));
        params.append("&action=").append(URLEncoder.encode("delete", "UTF-8"));
        params.append("&").append(ids);
        params.append("&delete=").append(URLEncoder.encode(" Delete Selected ", "UTF-8"));
        String response = doPostRequestUrlEncoded(true, FORUM_POST_PAGE_URL, params.toString());
        // TODO: search for "Message deletion done." message in response
    }
    
    private IracingCustomer apiUser;
    
    private static final String USER_AGENT_FIREFOX_14 = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:14.0) Gecko/20100101 Firefox/14.0.1";
    
    private IracingCustomer getApiUser() throws IOException, LoginException {
        if (apiUser == null) {
            AccountInfo ai = getAccountInfo();
            apiUser = ai.getCustomer();
        }
        return apiUser;
    }
    
    public List<PrivateMessageHeader> getAllPrivateMessages() throws IOException, LoginException {
        // NOTE: passing USER_AGENT_FIREFOX causes the HTML to be compressed but also adds 20k extra download for some reason
        String html = doGetRequest(true, MESSAGE_INBOX_URL, null);
        return PrivateMessageListParser.parse(true, getApiUser(), html); // TODO: handle outbox messages
    }
    
    public PrivateMessage getPrivateMessage(long messageId) throws IOException, LoginException {
        String html = doGetRequest(true, MESSAGE_READ_URL + messageId + ".page");
        return PrivateMessageDetailParser.parse(html);
    }
    
//    private boolean getStatSessionCookie() {
//        boolean containsStatSessionId = false;
//        try {
//            URL url = new URL("http://members.iracing.com/membersite/member/CareerStats.do");
//            //URL url = new URL("http://members.iracing.com/membersite/member/results.jsp?custid=29462");
//            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//            conn.setDoInput(true);
//            conn.setUseCaches(false);
//            conn.setInstanceFollowRedirects(false);
//            HttpURLConnection.setFollowRedirects(false);
//
//            conn.addRequestProperty(COOKIE, cookie);
//
//            conn.connect();
//
//            if (isMaintenancePage(conn)) return false;
//
//            String headerName;
//            for (int i = 1; (headerName = conn.getHeaderFieldKey(i)) != null; i++) {
//                if (headerName.equalsIgnoreCase("Set-Cookie")) {
//                    StringTokenizer st = new StringTokenizer(conn.getHeaderField(i), ";");
//                    if (st.hasMoreTokens()) {
//                        String token = st.nextToken();
//                        String name = token.substring(0, token.indexOf('='));
//                        String value = token.substring(token.indexOf('=') + 1, token.length());
//                        cookieMap.put(name, value);
//                        if (name.equals("STATSSESSIONID")) containsStatSessionId = true;
//                    }
//                }
//            }
//            createCookieFromMap();
//            
//            conn.disconnect();
//        } catch (Exception ex) {
//            Logger.getLogger(IracingWebApi.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//        return containsStatSessionId;
//    }
    
    public List<SessionResultSummary> getSessionResultSummaries(SessionResultSummary.SearchParameters params) throws IOException, LoginException {
        SessionResultSummaryParser.ListItemHandler listHandler = new SessionResultSummaryParser.ListItemHandler();
        getSessionResultSummaries(params, listHandler);
        return listHandler.getList();
    }
    
    public void getSessionResultSummaries(SessionResultSummary.SearchParameters params, SessionResultSummaryParser.ItemHandler handler) throws IOException, LoginException {
//        System.err.println("getSessionResultSummaries() : " + mapToRequestParamaters(params.toParameters()));
        String json = doPostRequestUrlEncoded(false, GET_RESULT_SUMMARIES_URL, params.toParameters());
//        System.out.println(json);
        SessionResultSummaryParser.parse(json, handler);
    }
    
    public HostedSessionResultSummaries getHostedSessionResultSummaries(HostedSessionResultSummary.SearchParameters params) throws IOException, LoginException {
        HostedSessionResultSummaryParser.ListItemHandler listHandler = new HostedSessionResultSummaryParser.ListItemHandler();
        HostedSessionResultSummaries output = new HostedSessionResultSummaries();
        output.setTotalRecords(getHostedSessionResultSummaries(params, listHandler));
        output.setResults(listHandler.getList());
        return output;
    }
    
    public long getHostedSessionResultSummaries(HostedSessionResultSummary.SearchParameters params, HostedSessionResultSummaryParser.ItemHandler handler) throws IOException, LoginException {
        String json = doPostRequestUrlEncoded(false, GET_HOSTED_RESULT_SUMMARIES_URL, params.toParameters());
        return HostedSessionResultSummaryParser.parse(json, handler);
    }
    
    public List<HostedSessionSummary> getLiveHostedSessions() throws IOException, LoginException {
        String json = doGetRequest(false, GET_HOSTED_SESSIONS_URL);
        return HostedSessionSummaryParser.parse(json);
    }
    
    public static final int EVENT_TYPE_TEST = 1;
    public static final int EVENT_TYPE_PRACTICE = 2;
    public static final int EVENT_TYPE_QUALIFYING = 3;
    public static final int EVENT_TYPE_TIME_TRIAL = 4;
    public static final int EVENT_TYPE_RACE = 5;
    
    private static String getEventTypeName(int id) {
        switch (id) {
            case EVENT_TYPE_TEST: return "Test";
            case EVENT_TYPE_PRACTICE: return "Practice";
            case EVENT_TYPE_QUALIFYING: return "Qualify";
            case EVENT_TYPE_RACE: return "Race";
            default: return "Time Trial";
        }
    }
    
    public SessionResult getSessionResult(long subSessionId, boolean includeDriverLaps) throws IOException, LoginException {
        List<SessionSubResult> subResults = new ArrayList<SessionSubResult>();
        int simSessionNumber = 0;
        CsvSessionResult result1 = getSessionResult(subSessionId, simSessionNumber, includeDriverLaps, true);
        int[] iaEventTypes = null;
        // Use SessionResultSummary search to determine what sub sessions exist (i.e. practice, qualifying & race)
        if (result1.isHosted()) {
            HostedSessionResultSummary.SearchParameters params = new HostedSessionResultSummary.SearchParameters();
            params.setParticipantCustomerId(result1.getDriverResults().get(0).getCustomerId());
            params.setStartTime(new Date(result1.getStartTime().getTime() - 1000));
            params.setEndTime(new Date(result1.getStartTime().getTime() + (1000 * 60 * 60 * 4)));
            HostedSessionResultSummaries summaries = getHostedSessionResultSummaries(params);
//            System.err.println("getSessionResult() : found " + summaries.getResults().size() + " result summaries");
            boolean containsPractice = false, containsQualifying = false, containsRace = false;
            for (HostedSessionResultSummary summary : summaries.getResults()) {
                if (summary.getSubSessionId() == subSessionId) {
                    if (summary.getPracticeLength() > 0) containsPractice = true;
                    if (summary.getQualifyingLength() > 0) containsQualifying = true;
                    if (summary.getRaceLength() > 0) containsRace = true;
                    if (containsPractice && !containsQualifying && !containsRace) {
                        iaEventTypes = new int[] { EVENT_TYPE_PRACTICE };
                    } else if (!containsPractice && containsQualifying && containsRace) {
                        iaEventTypes = new int[] { EVENT_TYPE_RACE, EVENT_TYPE_QUALIFYING };
                    } else {
                        iaEventTypes = new int[] { EVENT_TYPE_RACE, EVENT_TYPE_QUALIFYING, EVENT_TYPE_PRACTICE };
                    }
                    break;
                }
            }
        } else {
            SessionResultSummary.SearchParameters params = new SessionResultSummary.SearchParameters(true, true);
            params.setCustomerId(result1.getDriverResults().get(0).getCustomerId());
            params.setStartDate(new Date(result1.getStartTime().getTime() - 1000));
            params.setEndDate(new Date(result1.getStartTime().getTime() + 1000));
            List<SessionResultSummary> summaries = getSessionResultSummaries(params);
//            System.err.println("getSessionResult() : found " + summaries.size() + " result summaries");
            for (SessionResultSummary summary : summaries) {
                if (summary.getSubSessionId() == subSessionId) {
                    if (summary.getEventType() == EVENT_TYPE_RACE) {
                        iaEventTypes = new int[] { EVENT_TYPE_RACE, EVENT_TYPE_PRACTICE };
                    } else {
                        // must be either PRACTICE, QUALIFY or TIME_TRIAL (all of which are only a single sub session)
                        iaEventTypes = new int[] { summary.getEventType() };
                    }
                    break;
                }
            }
        }
        SessionResult output = null;
        if (iaEventTypes != null) {
            output = new SessionResult();
            SessionSubResult subResult1 = new SessionSubResult(result1);
            subResult1.setEventTypeId(iaEventTypes[0]);
            subResults.add(subResult1);
            // NOTE: sim session numbers go in reverse chronological order
            if (result1.isHosted()) {
                if (iaEventTypes.length > 1) {
                    simSessionNumber = -1;
                    CsvSessionResult result2 = getSessionResult(subSessionId, simSessionNumber, includeDriverLaps, false);
                    SessionSubResult subResult2 = new SessionSubResult(result2);
                    subResult2.setEventTypeId(iaEventTypes[1]);
                    subResults.add(subResult2);
                }
                if (iaEventTypes.length > 2) {
                    simSessionNumber = -2;
                    CsvSessionResult result3 = getSessionResult(subSessionId, simSessionNumber, includeDriverLaps, false);
                    SessionSubResult subResult3 = new SessionSubResult(result3);
                    subResult3.setEventTypeId(iaEventTypes[2]);
                    subResults.add(subResult3);
                }
            } else {
                if (iaEventTypes.length > 1) {
                    simSessionNumber = -1;
                    CsvSessionResult result2 = getSessionResult(subSessionId, simSessionNumber, includeDriverLaps, false);
                    if (result2 != null) {
                        SessionSubResult subResult2 = new SessionSubResult(result2);
                        subResult2.setEventTypeId(iaEventTypes[1]);
                        subResults.add(subResult2);
                    }
                }
            }
            output.setStartTime(result1.getStartTime());
            output.setSeriesName(result1.getSeriesName());
            output.setTrackName(result1.getTrackName());
            output.setHostedSessionName(result1.getHostedSessionName());
            output.setSubResults(subResults);
        }
        return output;
    }
    
    private CsvSessionResult getSessionResult(long subSessionId, int simSessionNumber, boolean includeDriverLaps, boolean includeSummary) throws IOException, LoginException {
        String sUrl = GET_RACE_RESULT_CSV_URL + "?subsessionid=" + subSessionId + "&simsesnum=" + simSessionNumber + "&includeSummary=" + (includeSummary ? "1" : "0");
        String csv = doGetRequest(false, sUrl);
        CsvSessionResult output = CsvSessionResultParser.parse(csv);
        if (includeDriverLaps) {
            for (SessionDriverResult result : output.getDriverResults()) {
                result.setDriverLaps(getSessionDriverLaps(result.getCustomerId(), subSessionId, simSessionNumber));
            }
        }
        return output;
    }
    
    public SessionResultDriverLaps getSessionDriverLaps(long customerId, long subSessionId, int simSessionNumber) throws IOException, LoginException {
        String sUrl = GET_SESSION_DRIVER_LAPS_URL + "?&subsessionid=" + subSessionId + "&custid=" + customerId + "&simsesnum=" + simSessionNumber + "&a=null";
        String json = doGetRequest(false, sUrl);
        return SessionResultDriverLapsParser.parse(json);
    }
    
    public SessionDrivers getLiveSessionDrivers(long subSessionId) throws IOException, LoginException {
        //String sUrl = GET_OPEN_SESSION_DRIVERS_URL + "?subsessionid=" + subSessionId + "&requestindex=0";
        String sUrl = GET_SESSION_DRIVERS_URL + "?subsessionid=" + subSessionId  + "&requestindex=0";
        String json = doGetRequest(false, sUrl);
        return SessionDriversParser.parse(json);
    }
    
    public SessionDrivers getLiveHostedSessionDrivers(long subSessionId, long privateId) throws IOException, LoginException {
        String sUrl = GET_HOSTED_SESSION_DRIVERS_URL + "?ssid=" + subSessionId + "&pvtid=" + privateId + "&requestindex=0";
        String json = doGetRequest(false, sUrl);
        return SessionDriversParser.parse(json);
    }
    
    public SeasonStandings getSeasonStandings(SeasonStandings.SearchParameters parameters) throws IOException, LoginException {
        SeasonStandingsParser.ListItemHandler lih = new SeasonStandingsParser.ListItemHandler();
        SeasonStandings output = new SeasonStandings();
        output.setTotalRecords(getSeasonStandings(parameters, lih));
        output.setStandings(lih.getList());
        return output;
    }
    
    public long getSeasonStandings(SeasonStandings.SearchParameters parameters, SeasonStandingsParser.ItemHandler handler) throws IOException, LoginException {
        String json = doPostRequestUrlEncoded(false, GET_SEASON_STANDINGS_URL, parameters.toParameters());
        return SeasonStandingsParser.parse(json, handler);
    }
    
    public SeasonQualifyingResults getSeasonQualifyingResults(SeasonQualifyingResults.SearchParameters parameters) throws IOException, LoginException {
        SeasonQualifyingResultParser.ListItemHandler lih = new SeasonQualifyingResultParser.ListItemHandler();
        SeasonQualifyingResults output = new SeasonQualifyingResults();
        output.setTotalRecords(getSeasonQualifyingResults(parameters, lih));
        output.setResults(lih.getList());
        return output;
    }
    
    public long getSeasonQualifyingResults(SeasonQualifyingResults.SearchParameters parameters, SeasonQualifyingResultParser.ItemHandler handler) throws IOException, LoginException {
        String json = doPostRequestUrlEncoded(false, GET_SEASON_QUALIFYING_RESULTS_URL, parameters.toParameters());
        return SeasonQualifyingResultParser.parse(json, handler);
    }
    
    public SeasonTimeTrialStandings getSeasonTimeTrialStandings(SeasonTimeTrialStandings.SearchParameters parameters) throws IOException, LoginException {
        String json = doPostRequestUrlEncoded(false, GET_SEASON_TIME_TRIAL_STANDINGS_URL, parameters.toParameters());
        return SeasonTimeTrialStandingsParser.parse(json);
    }
    
    public TimeTrialResultStandings getTimeTrialResultStandings(TimeTrialResultStandings.SearchParameters parameters) throws IOException, LoginException {
        String json = doPostRequestUrlEncoded(false, GET_TIME_TRIAL_RESULTS_URL, parameters.toParameters());
        return TimeTrialResultStandingsParser.parse(json);
    }
    
    public List<SpectatorSession> getSpectatorSessions() throws IOException, LoginException {
        String json = doGetRequest(false, GET_SPECTATOR_SESSIONS_URL);
        return SpectatorSessionParser.parse(json);
    }
    
    public WorldRecords getWorldRecords(WorldRecord.SearchParameters params, boolean includeApiUserTopRow) throws IOException, LoginException {
        String json = doPostRequestUrlEncoded(false, GET_WORLD_RECORDS_URL, params.toParameters());
        return WorldRecordsParser.parse(json, includeApiUserTopRow);
    }
    
    public DriverStats getDriverStats(DriverStat.SearchParameters params, boolean includeApiUserTopRow) throws IOException, LoginException {
        String json = doPostRequestUrlEncoded(false, GET_DRIVER_STATS_URL, params.toParameters());
        return DriverStatsParser.parse(json, includeApiUserTopRow);
    }
    
    public AccountInfo getAccountInfo() throws IOException, LoginException {
        String html = doGetRequest(false, ACCOUNT_URL);
        return AccountInfoParser.parse(html);
    }
    
    // TODO: add a function to check if the site is down (i.e. maintenance)
    //       the thread that sends out iRacing PM's should check the output of
    //       this function before trying to send out multiple PM's.
    //       Otherwise, each attempt to send a PM will be futile
    //       Handle cases where the members site is down but forum access is still available
    
    public String[] getUserData() throws IOException, LoginException {
        //if ((cookie == null) || (cookie.matches("^\\s*$"))) {
        if (!cookieMap.containsKey(JSESSIONID)) {
//            logger.warn("Cookie is " + cookie + ", performing login to get new cookie");
            if (login() != LoginResponse.Success) {
                System.err.println("Login failed");
                return null;
            }
        }

        URL url = new URL(DRIVER_PROFILE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.addRequestProperty(COOKIE, cookie);

//        logger.debug("opening connection to " + url.getFile());
        conn.connect();

        if (isMaintenancePage(conn)) return null;
        
        String pageData = "";

        String custid = null;
        String friends = null;
        String studied = null;
        BufferedReader b = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        try {
            boolean found = false;
            while (!found && (pageData = b.readLine()) != null) {
    //            logger.debug("line received : " + pageData);
                if (pageData.contains("this.currentCustId = ")) {
    //                logger.debug("found CustId in this line, attempting extract");
                    int x = pageData.indexOf("this.currentCustId = ");
                    int y = pageData.indexOf(";");
                    custid = pageData.substring(x + 21, y);
    //                logger.debug("following extract, saving CustId as " + custid);

                    found = true;
                } else if (pageData.contains("var FriendsListing")) {
    //                logger.debug("found 'var FriendsListing' in this line, attempting extract");
                    int x = pageData.indexOf("{");
                    int y = pageData.indexOf("}");
                    friends = pageData.substring(x + 1, y);
                    friends = friends.replaceAll("\"", "");
                    friends = friends.replaceAll(":1", "");
                    friends = friends.replaceAll(":2", "");
    //                logger.debug("Friends List (green) is " + friends + " following extract");
                } else {
                    if (!pageData.contains("var WatchedListing")) {
                        continue;
                    }
    //                logger.debug("found 'var WatchedListing' in this line, attempting extract");
                    int x = pageData.indexOf("{");
                    int y = pageData.indexOf("}");
                    studied = pageData.substring(x + 1, y);
                    studied = studied.replaceAll("\"", "");
                    studied = studied.replaceAll(":1", "");
                    studied = studied.replaceAll(":2", "");
    //                logger.debug("Watched List (blue) is " + studied + " following extract");
                }

            }
        } finally {
            b.close();
        }
        conn.disconnect();

        return new String[] { custid, friends, studied };
    }

    private static class SavingTrustManager
            implements X509TrustManager {

        private final X509TrustManager tm;
        private X509Certificate[] chain;

        SavingTrustManager(X509TrustManager tm) {
            this.tm = tm;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            this.chain = chain;
            this.tm.checkServerTrusted(chain, authType);
        }
    }
}
