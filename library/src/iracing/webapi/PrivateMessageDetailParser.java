package iracing.webapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class PrivateMessageDetailParser {
    
    public static void main(String[] args) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader("H:\\iracing_web_api-private_message_htmlsrc3.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            parse(sb.toString());
        } catch (Exception ex) {
            Logger.getLogger(PrivateMessageDetailParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public static PrivateMessage parse(String html) {
        String s, line;
        BufferedReader b = new BufferedReader(new StringReader(html));
        PrivateMessage output = null;
        try {
            output = new PrivateMessage();
            int endIndex, startIndex;
            while ((line = b.readLine()) != null) {
                // Message ID
                s = "<a class=\"contentBarButton\" id=\"writeAReply\" href=\"/jforum/pm/reply/";
                startIndex = line.indexOf(s);
                if (startIndex > -1) {
                    startIndex += s.length();
                    endIndex = line.indexOf(".page", startIndex);
                    long messageId = Long.parseLong(line.substring(startIndex, endIndex));
                    // From
                    s = "<tr class=\"trDark\"><td width=\"90\">From:</td><td><a href=\"/jforum/user/profile/";
                    startIndex = line.indexOf(s, endIndex);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        s = ".page\">";
                        endIndex = line.indexOf(s, startIndex);
                        IracingCustomer from = new IracingCustomer();
                        from.setId(Long.parseLong(line.substring(startIndex, endIndex)));
                        startIndex = endIndex + s.length();
                        endIndex = line.indexOf("</a>", startIndex);
                        from.setName(line.substring(startIndex, endIndex));
                        output.setFrom(from);
                    }
                    // To
                    s = "<tr class=\"trTopBlank\"><td>To:</td><td><a href=\"/jforum/user/profile/";
                    startIndex = line.indexOf(s, endIndex);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        s = ".page\">";
                        endIndex = line.indexOf(s, startIndex);
                        IracingCustomer to = new IracingCustomer();
                        to.setId(Long.parseLong(line.substring(startIndex, endIndex)));
                        startIndex = endIndex + s.length();
                        endIndex = line.indexOf("</a>", startIndex);
                        to.setName(line.substring(startIndex, endIndex));
                        output.setTo(to);
                    }
                    // Date
                    s = "<tr><td>Date:</td><td>";
                    startIndex = line.indexOf(s, endIndex);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        s = "</td>";
                        endIndex = line.indexOf(s, startIndex);
                        output.setDate(dateFormat.parse(line.substring(startIndex, endIndex)));
                    }
                    // Subject
                    s = "<tr class=\"trDark\"><td>Subject:</td><td>";
                    startIndex = line.indexOf(s, endIndex);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        s = "</td>";
                        endIndex = line.indexOf(s, startIndex);
                        output.setSubject(line.substring(startIndex, endIndex));
                    }
                    // Message
                    s = "<div class=\"postBody\""; // style="margin: 0 0 0 60px;">
                    startIndex = line.indexOf(s, endIndex);
                    startIndex = line.indexOf('>', startIndex) + 1;
                    s = "</div></td>";
                    endIndex = line.indexOf(s, startIndex);
                    output.setMessage(line.substring(startIndex, endIndex));
                    output.setRead(true);
                    
                    //System.err.println(output.getMessage().replaceAll("<br />", "\n"));
                    
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
    
}