package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class PrivateMessage extends PrivateMessageHeader {
    
    private String message;
    
    public PrivateMessage() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  id:").append(id).append(",\n");
        if (from != null) sb.append("  from:{id:").append(from.getId()).append(",name:\"").append(from.getName()).append("\"},\n");
        if (to != null) sb.append("  to:{id:").append(to.getId()).append(",name:\"").append(to.getName()).append("\"},\n");
        sb.append("  subject:\"").append(subject).append("\",\n");
        if (message != null) sb.append("  message:\"").append(message).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
    
}