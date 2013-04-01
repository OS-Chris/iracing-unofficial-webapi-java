package iracing.webapi;

import java.util.Date;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class AccountInfo {
    
    private IracingCustomer customer;
    private Date memberSince;
    private Date nextBillingDate;
    private double iracingDollars;
    private double iracingCredits;
    
    public AccountInfo() {}

    public IracingCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(IracingCustomer customer) {
        this.customer = customer;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public Date getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(Date nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

    public double getIracingDollars() {
        return iracingDollars;
    }

    public void setIracingDollars(double iracingDollars) {
        this.iracingDollars = iracingDollars;
    }

    public double getIracingCredits() {
        return iracingCredits;
    }

    public void setIracingCredits(double iracingCredits) {
        this.iracingCredits = iracingCredits;
    }
    
}