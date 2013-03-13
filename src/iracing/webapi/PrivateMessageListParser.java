package iracing.webapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class PrivateMessageListParser {
    
    public static void main(String[] args) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader("H:\\iracing_web_api-private_message_list.txt")); //_compressed.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            List<PrivateMessageHeader> messages = parse(true, new IracingCustomer(29462, "Christian Aylward"), sb.toString());
            for (PrivateMessageHeader message : messages) {
                System.err.println(message.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(PrivateMessageListParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static String findMultiLineStringBetween(String input, String startTag, String endTag) {
        StringBuilder interestingHtml = new StringBuilder();
        String line;
        int startIndex, endIndex;
        boolean interestingHtmlNeedsMoreData = false;
        BufferedReader b = new BufferedReader(new StringReader(input));
        try {
            while ((line = b.readLine()) != null) {
                // look for the tag specifying the start of the
                // HTML containing all the messages
                startIndex = line.indexOf(startTag); //, lineStartIndex);
                if (startIndex > -1) {
                    // check if the end tag is on the same line
                    endIndex = line.indexOf(endTag, startIndex);
                    if (endIndex > -1) {
                        interestingHtml.append(line.substring(startIndex, endIndex));
                        break;
                    } else {
                        interestingHtmlNeedsMoreData = true;
                        interestingHtml.append(line.substring(startIndex));
                    }
                // If we've started gathering the interesting HTML
                // and it wasn't complete, add the remaining HTML
                } else if (interestingHtmlNeedsMoreData) {
                    endIndex = line.indexOf(endTag);
                    if (endIndex > -1) {
                        interestingHtml.append(line.substring(0, endIndex));
                        break;
                    } else {
                        interestingHtml.append(line);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PrivateMessageListParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try { b.close(); } catch (Exception ex) {}
        }
        return interestingHtml.toString();
    }
    
    public static List<PrivateMessageHeader> parse(boolean inbox, IracingCustomer apiUser, String html) {
        List<PrivateMessageHeader> output = new ArrayList<PrivateMessageHeader>();
        String line;
        int startIndex, endIndex;
        
        try {
            
            // Determine whether the HTML is compressed (in which case we'll need to process it differently)
            String firstChars = html.substring(0, 120);
            int firstLineIndex = firstChars.indexOf("\n");
            int htmlTagIndex = firstChars.indexOf("<html>");
            boolean htmlIsCompressed = (htmlTagIndex > -1 && firstLineIndex == -1);
            
            if (htmlIsCompressed) {
                // The following works on HTML that has been compressed
                // and spans multiple lines.
                line = findMultiLineStringBetween(html, 
                        "<tr><td class=\"tdIcon\"><img src=\"/jforum/templates/iracing/images/", 
                        "<tr class=\"trDark\">");

                if (!StringUtils.isEmpty(line)) {
                    int lineStartIndex = 0;
                    while (true) {
                        // Read
                        String s = "<tr><td class=\"tdIcon\"><img src=\"/jforum/templates/iracing/images/";
                        startIndex = line.indexOf(s, lineStartIndex);
                        if (startIndex > -1) {
                            startIndex += s.length();
                            endIndex = line.indexOf("\"/>", startIndex);
                            String s1 = line.substring(startIndex, endIndex);
                            PrivateMessageHeader message = new PrivateMessageHeader();
                            message.setRead(s1.equals("iconRead.png"));
                            // Message ID
                            s = "<td class=\"tdTopic\"><a href=\"/jforum/pm/read/";
                            startIndex = line.indexOf(s, endIndex);
                            if (startIndex > -1) {
                                startIndex += s.length();
                                s = ".page\">";
                                endIndex = line.indexOf(s, startIndex);
                                message.setId(Long.parseLong(line.substring(startIndex, endIndex)));
                                // Subject
                                startIndex = endIndex + s.length();
                                endIndex = line.indexOf("</a>", startIndex);
                                message.setSubject(line.substring(startIndex, endIndex));
                            }
                            // From/To
                            s = "<td class=\"tdAuthor\"><a class=\"name\" href=\"/jforum/user/profile/";
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
                                message.setFrom(from);
                                message.setTo(apiUser);
                            }
                            // Date
                            s = "getDateAndTime(";
                            startIndex = line.indexOf(s, endIndex);
                            if (startIndex > -1) {
                                startIndex += s.length();
                                endIndex = line.indexOf("))", startIndex);
                                message.setDate(new Date(Long.parseLong(line.substring(startIndex, endIndex))));
                            }
                            output.add(message);
                            lineStartIndex = endIndex;
                        } else {
                            break;
                        }
                    }
                } else {
                    System.err.println("PrivateMessageListParser: Error locating interesting HTML");
                }
            } else {
                PrivateMessageHeader currentMessage = null;
                boolean inMessagesSection = false;
                BufferedReader br = new BufferedReader(new StringReader(html));
                while ((line = br.readLine()) != null) {
                    // the following was used when HTML was not compressed
                    String s2, s1 = "<td class=\"tdIcon\">";
                    if (line.contains(s1)) {
                        inMessagesSection = true;
                        currentMessage = new PrivateMessage();
                        currentMessage.setRead(line.contains("iconRead.png"));
                    } else if (line.contains("<td class=\"tdTopic\">")) {
                        String text = "/jforum/pm/read/";
                        startIndex = line.indexOf(text) + text.length();
                        endIndex = line.indexOf(".page");
                        String messageId = line.substring(startIndex, endIndex);
                        currentMessage.setId(Long.parseLong(messageId));
                        text = ".page\">";
                        startIndex = line.indexOf(text) + text.length();
                        endIndex = line.indexOf("</a>");
                        currentMessage.setSubject(line.substring(startIndex, endIndex));
                    } else if (line.contains("<td class=\"tdAuthor\">")) {
                        String text = "/jforum/user/profile/";
                        startIndex = line.indexOf(text) + text.length();
                        endIndex = line.indexOf(".page");
                        String driverId = line.substring(startIndex, endIndex);
                        text = ".page\">";
                        startIndex = line.indexOf(text) + text.length();
                        endIndex = line.indexOf("</a>");
                        String driverName = line.substring(startIndex, endIndex);
                        currentMessage.setFrom(new IracingCustomer(Long.parseLong(driverId), driverName));
                    } else if (line.contains("<td class=\"tdLast\">")) {
                        String text = "getDateAndTime(";
                        startIndex = line.indexOf(text) + text.length();
                        endIndex = line.indexOf("))", startIndex);
                        long lDate = Long.parseLong(line.substring(startIndex, endIndex));
                        Date date = new Date(lDate);
                        currentMessage.setDate(date);
                        currentMessage.setTo(apiUser);
                        output.add(currentMessage);
                    } else if (line.contains("<div id=\"bottomCorners\">")) {
                        break;
                    }
                }
            }
                    
//                // The following was used when HTML content was compressed
//                    boolean continueScanningLine = true;
//                    int startIndexMainLoop = 0, endIndexMainLoop;
//                    while (continueScanningLine) {
//                        //// Read ////
//                        String s2, s1 = "<td class=\"tdIcon\">";
//                        if ((startIndexMainLoop = pageData.indexOf(s1, startIndexMainLoop)) >= 0) {
//                            inMessagesSection = true;
//    //                        System.out.println("startIndex = " + startIndexMainLoop);
//                            endIndexMainLoop = pageData.indexOf("</td>", startIndexMainLoop + s1.length());
//                            if (endIndexMainLoop == -1) {
////                                continueScanningLine = false;
//                                break;
//                            }
//                            s2 = pageData.substring(startIndexMainLoop + s1.length(), endIndexMainLoop);
//    //                        System.out.println("s2 = " + s2);
//                            currentMessage = new PrivateMessage();
//                            currentMessage.setRead(s2.contains("iconRead.png"));
//                        } else {
////                            continueScanningLine = false;
//                            break;
//                        }
//                        //// ID & Subject ////
//                        s1 = "<td class=\"tdTopic\">";
//                        if ((startIndexMainLoop = pageData.indexOf(s1, startIndexMainLoop)) >= 0) {
//                            endIndexMainLoop = pageData.indexOf("</td>", startIndexMainLoop + s1.length());
//                            if (endIndexMainLoop == -1) {
////                                continueScanningLine = false;
//                                break;
//                            }
//                            s2 = pageData.substring(startIndexMainLoop + s1.length(), endIndexMainLoop);
//    //                        System.out.println("s2 = " + s2);
//                            String text = "/jforum/pm/read/";
//                            int start2 = s2.indexOf(text) + text.length();
//                            int end2 = s2.indexOf(".page", start2);
//                            String messageId = s2.substring(start2, end2);
//                            currentMessage.setId(Long.parseLong(messageId));
//                            text = ".page\">";
//                            start2 = s2.indexOf(text) + text.length();
//                            end2 = s2.indexOf("</a>");
//                            String subject = s2.substring(start2, end2);
//                            currentMessage.setSubject(subject);
//                        } else {
////                            continueScanningLine = false;
//                            break;
//                        }
//                        //// From ////
//                        s1 = "<td class=\"tdAuthor\">";
//                        if ((startIndexMainLoop = pageData.indexOf(s1, startIndexMainLoop)) >= 0) {
//                            endIndexMainLoop = pageData.indexOf("</td>", startIndexMainLoop + s1.length());
//                            if (endIndexMainLoop == -1) {
////                                continueScanningLine = false;
//                                break;
//                            }
//                            s2 = pageData.substring(startIndexMainLoop + s1.length(), endIndexMainLoop);
//    //                        System.out.println("s2 = " + s2);
//                            String text = "/jforum/user/profile/";
//                            int startIndex = s2.indexOf(text) + text.length();
//                            int endIndex = s2.indexOf(".page");
//                            String driverId = s2.substring(startIndex, endIndex);
//                            text = ".page\">";
//                            startIndex = s2.indexOf(text) + text.length();
//                            endIndex = s2.indexOf("</a>");
//                            String driverName = s2.substring(startIndex, endIndex);
//                            currentMessage.setFrom(new IracingCustomer(Long.parseLong(driverId), driverName));
//                            currentMessage.setTo(apiUser);
//                        } else {
////                            continueScanningLine = false;
//                            break;
//                        }
//                        //// Date ////
//                        s1 = "<td class=\"tdLast\">";
//                        if ((startIndexMainLoop = pageData.indexOf(s1, startIndexMainLoop)) >= 0) {
//                            endIndexMainLoop = pageData.indexOf("</td>", startIndexMainLoop + s1.length());
//                            if (endIndexMainLoop == -1) {
////                                continueScanningLine = false;
//                                break;
//                            }
//                            s2 = pageData.substring(startIndexMainLoop + s1.length(), endIndexMainLoop);
//    //                        System.out.println("s2 = " + s2);
//                            String text = "getDateAndTime(";
//                            int startIndex = s2.indexOf(text) + text.length();
//                            int endIndex = s2.indexOf("))", startIndex);
//                            long lDate = Long.parseLong(s2.substring(startIndex, endIndex));
//                            Date date = new Date(lDate);
//                            currentMessage.setDate(date);
//                            messages.add(currentMessage);
//                        } else {
////                            continueScanningLine = false;
//                            break;
//                        }
//                        
//                        // the following was written when the HTML was not compressed
//    //                    } else if (pageData.contains("<td class=\"tdTopic\">")) {
//    //                        String text = "/jforum/pm/read/";
//    //                        int startIndex = pageData.indexOf(text) + text.length();
//    //                        int endIndex = pageData.indexOf(".page");
//    //                        String messageId = pageData.substring(startIndex, endIndex);
//    //                        currentMessage.setId(Long.parseLong(messageId));
//    //                        text = ".page\">";
//    //                        startIndex = pageData.indexOf(text) + text.length();
//    //                        endIndex = pageData.indexOf("</a>");
//    //                        currentMessage.setSubject(pageData.substring(startIndex, endIndex));
//    //                    } else if (pageData.contains("<td class=\"tdAuthor\">")) {
//    //                        String text = "/jforum/user/profile/";
//    //                        int startIndex = pageData.indexOf(text) + text.length();
//    //                        int endIndex = pageData.indexOf(".page");
//    //                        String driverId = pageData.substring(startIndex, endIndex);
//    //                        text = ".page\">";
//    //                        startIndex = pageData.indexOf(text) + text.length();
//    //                        endIndex = pageData.indexOf("</a>");
//    //                        String driverName = pageData.substring(startIndex, endIndex);
//    //                        currentMessage.setFrom(new IracingCustomer(Long.parseLong(driverId), driverName));
//    //                    } else if (pageData.contains("<td class=\"tdLast\">")) {
//    //                        String text = "getDateAndTime(";
//    //                        int startIndex = pageData.indexOf(text) + text.length();
//    //                        int endIndex = pageData.indexOf("))", startIndex);
//    //                        long lDate = Long.parseLong(pageData.substring(startIndex, endIndex));
//    //                        Date date = new Date(lDate);
//    //                        currentMessage.setDate(date);
//    //                        messages.add(currentMessage);
//    //                    } else if (pageData.contains("<div id=\"bottomCorners\">")) {
//    //                        break;
//    //                    }
//                    }
                
//            }
//            b.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
    
}