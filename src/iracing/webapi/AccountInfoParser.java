package iracing.webapi;

import java.io.BufferedReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class AccountInfoParser {
    
    private enum DataType {
        CUSTOMER_ID,
        CUSTOMER_NAME,
        NEXT_BILLING_DATE,
        IRACING_DOLLARS,
        IRACING_CREDITS
    }
    
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static AccountInfo parse(String html) {
        BufferedReader br = new BufferedReader(new StringReader(html));
        String line, s;
        int startIndex, endIndex;
        AccountInfo output = null;
        IracingCustomer apiUser = null;
        DataType nextDataType = DataType.CUSTOMER_ID;
        try {
            while ((line = br.readLine()) != null) {
                if (nextDataType == DataType.CUSTOMER_ID) {
                    s = "<tr><td class=\"bold\">Customer ID:</td><td>";
                    startIndex = line.indexOf(s);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        endIndex = line.indexOf("</td>", startIndex);
                        apiUser = new IracingCustomer();
                        apiUser.setId(Long.parseLong(line.substring(startIndex, endIndex)));
                        nextDataType = DataType.CUSTOMER_NAME;
                    }
                } else if (nextDataType == DataType.CUSTOMER_NAME) {
                    s = "<tr><td class=\"bold\">Member Name:</td><td>";
                    startIndex = line.indexOf(s);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        endIndex = line.indexOf("</td>", startIndex);
                        apiUser.setName(line.substring(startIndex, endIndex));
                        output = new AccountInfo();
                        output.setCustomer(apiUser);
                        nextDataType = DataType.NEXT_BILLING_DATE;
                    }
                } else if (nextDataType == DataType.NEXT_BILLING_DATE) {
                    s = "<tr><td class=\"bold\">Next Billing Date:</td><td>";
                    startIndex = line.indexOf(s);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        endIndex = line.indexOf("</td>", startIndex);
                        String sNextBillingDate = line.substring(startIndex, endIndex);
                        output.setNextBillingDate(dateFormat.parse(sNextBillingDate));
                        nextDataType = DataType.IRACING_DOLLARS;
                    }
                } else if (nextDataType == DataType.IRACING_DOLLARS) {
                    s = "<tr><td class=\"bold\" width=\"1\">iRacing.com&trade;&nbsp;Dollars:</td><td align='left' width=\"1\">$";
                    startIndex = line.indexOf(s);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        endIndex = line.indexOf("</td>", startIndex);
                        output.setIracingDollars(Double.parseDouble(line.substring(startIndex, endIndex)));
                        nextDataType = DataType.IRACING_CREDITS;
                    }
                } else if (nextDataType == DataType.IRACING_CREDITS) {
                    s = "<tr><td class=\"bold\" width=\"1\">iRacing.com&trade;&nbsp;Credits:</td><td align='left' width=\"1\">$";
                    startIndex = line.indexOf(s);
                    if (startIndex > -1) {
                        startIndex += s.length();
                        endIndex = line.indexOf("</td>", startIndex);
                        output.setIracingCredits(Double.parseDouble(line.substring(startIndex, endIndex)));
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountInfoParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try { br.close(); } catch (Exception ex) {}
        }
        return output;
    }
    
}