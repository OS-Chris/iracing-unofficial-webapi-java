package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class IracingCustomer {
    
    private long id;
    private String name;

    public IracingCustomer() {}
    public IracingCustomer(long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IracingCustomer { id: " + id + ", name: " + name + " }";
    }
    
}