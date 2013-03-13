package iracing.webapi;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public abstract class AjaxReaderBase {
//
//    // shared cookie container for all requests
//    protected String userAgent = null;
////    protected CookieContainer m_Cookies = null;
//    protected List<String> cookieCollection;
//
//    public AjaxReaderBase(boolean cookiePersist) {
////        if (cookiePersist) {
////            m_Cookies = new CookieContainer();
////        }
//        this.cookieCollection = new ArrayList<>();
//    }
//
//    protected boolean connectedToInternet() {
//        return false;
////        try {
////            System.Net.IPHostEntry ipHE = System.Net.Dns.GetHostEntry("www.google.com");
////            return true;
////        } catch (Exception ex)  {
////            return false; // host not reachable.
////        }
//    }
//
//    protected URLConnection doGetRequest(String url, String postData) {
////        byte[] ba = null;
////        if (postData != null) {
////            try {
////                ba = postData.getBytes("UTF8");
////            } catch (Exception ex) {}
////        }
//        return doRequest(url, "GET", postData);
//    }
//
////    protected HttpURLConnection doGetRequest(String url, byte[] postData) {
////        return doRequest(url, "GET", postData);
////    }
//
//    protected URLConnection doPostRequest(String url, String postData) {
////        byte[] ba = null;
////        if (postData != null) {
////            try {
////                ba = postData.getBytes("UTF8");
////            } catch (Exception ex) {}
////        }
//        return doRequest(url, "POST", postData);
//    }
//
////    protected HttpURLConnection doPostRequest(String url, byte[] postData) {
////        return doRequest(url, "POST", postData);
////    }
//
//    protected URLConnection doRequest(String url, String method, String postData) {
//        URLConnection output = null;
//        try {
//            System.out.println(new Date().toString() + ": Starting web request (" + url + ")");
//            // Setup the http request.
////            HttpWebRequest wrWebRequest = WebRequest.Create(url) as HttpWebRequest;
////            wrWebRequest.Method = method;
////            wrWebRequest.UserAgent = m_UserAgent;
////            wrWebRequest.ContentType = "application/x-www-form-urlencoded";
////            wrWebRequest.CookieContainer = m_Cookies;
//            URL oURL = new URL(url);
//            URLConnection connection = oURL.openConnection();
//            connection.setRequestProperty("User-Agent", userAgent);
//            connection.setDoInput(true);
//            if (cookieCollection.size() > 0) {
//                StringBuilder cookies = new StringBuilder();
//                for (String cookie : cookieCollection) {
//                    if (cookies.length() > 0) cookies.append("; ");
//                    cookies.append(cookie);
//                }
//                connection.setRequestProperty("Cookie", cookies.toString());
//            }
////            if (oURL.getProtocol().equalsIgnoreCase("https")) {
////                HttpURLConnection connection = new HttpsURLConnection(oURL);
////            } else {
////            }
//
//            if (postData != null) {
////                wrWebRequest.ContentLength = postData.length;
////                // Get the request stream.
////                Stream dataStream = wrWebRequest.GetRequestStream();
////                // Write the data to the request stream.
////                dataStream.Write(postData, 0, postData.length);
////                // Close the Stream object.
////                dataStream.Close();
//                connection.setDoOutput(true);
//                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
//                wr.write(postData);
//                wr.flush();
//            } else {
//                connection.connect();
//            }
//
//            // Get the response.
////            output = (HttpURLConnection) wrWebRequest.GetResponse();
//            output = connection;
//        } catch (Exception ex) {
//            System.out.println("WebRequest failed: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//        return output;
//    }
//    
//    // TODO: move this method to somewhere more appropriate
////    public static TextReader GetResponseTextReader(HttpURLConnection response) {
////        TextReader output = null;
////        try {
////            if (response.getResponseCode() == HttpURLConnection.HTTP_OK) {
////                // Read the response
//////					Debug.WriteLine(DateTime.Now + ": Starting read of response to string");
//////					StreamReader srResponseReader = new StreamReader(response.GetResponseStream());
//////					string s = srResponseReader.ReadToEnd();
//////					srResponseReader.Close();
//////					Debug.WriteLine(DateTime.Now + ": Finished read of response to string");
////
////                output = new StreamReader(response.GetResponseStream());
////            } else {
////                System.out.println("Response status is not OK");
////                System.out.println("code: " + response.getResponseCode()
////                        + ", description: " + response.getResponseMessage());
////            }
////        } catch (Exception ex) {
////            System.out.println("Failed to read the WebResponse stream: " + ex.getMessage());
////            ex.printStackTrace();
////        }
////        return output;
////    }
//    
}