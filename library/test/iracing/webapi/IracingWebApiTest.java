package iracing.webapi;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class IracingWebApiTest {
    
    private IracingWebApi instance;
    
    public IracingWebApiTest() {
        instance = new IracingWebApi();
        instance.setLoginRequiredHandler(new IracingWebApi.LoginRequiredHandler() {
            @Override
            public boolean onLoginCredentialsRequired(IracingLoginCredentials creds) {
                creds.setEmailAddress("");  // <- TODO: set your iRacing email address here
                creds.setPassword("");  // <- TODO: set your iRacing password here
                return true;
            }
        });
    }

    /**
     * Test of lookupCustomerName method, of class IracingWebApi.
     */
    @Test
    public void testLookupCustomerName() throws Exception {
        System.out.println("lookupCustomerName");
        long customerId = 29462L;
        String expResult = "Christian Aylward";
        String result = instance.lookupCustomerName(customerId);
        assertEquals(expResult, result);
    }

    /**
     * Test of lookupCustomerId method, of class IracingWebApi.
     */
    @Test
    public void testLookupCustomerId() throws Exception {
        System.out.println("lookupCustomerId");
        String customerName = "Christian Aylward";
        long expResult = 29462L;
        long result = instance.lookupCustomerId(customerName);
        assertEquals(expResult, result);
    }

}