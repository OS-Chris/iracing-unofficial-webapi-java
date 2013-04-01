package iracing.webapi;

import java.util.Date;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class PrivateMessageHeader {
    
    protected long id;
    protected boolean read;
    protected IracingCustomer from;
    protected IracingCustomer to;
    protected Date date;
    protected String subject;
    
    public PrivateMessageHeader() {}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public IracingCustomer getFrom() {
        return from;
    }

    public void setFrom(IracingCustomer from) {
        this.from = from;
    }

    public IracingCustomer getTo() {
        return to;
    }

    public void setTo(IracingCustomer to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  id:").append(id).append(",\n");
        if (from != null) sb.append("  from:{id:").append(from.getId()).append(",name:\"").append(from.getName()).append("\"},\n");
        if (to != null) sb.append("  to:{id:").append(to.getId()).append(",name:\"").append(to.getName()).append("\"},\n");
        sb.append("  subject:\"").append(subject).append("\",\n");
        sb.append("}");
        return sb.toString();
    }
    
}