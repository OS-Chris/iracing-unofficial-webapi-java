package iracing.webapi;

import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class CarClass {
    
    //{"carsinclass":[{"name":"Modified+-+Tour","id":31}],"shortname":"Tour+Modified","name":"Tour+Modified","id":29,"lowername":"tour+modified"}
    private int id;
    private List<Integer> idsOfCarsInClass;
    private String shortName;
    private String name;
    
    public CarClass() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getIdsOfCarsInClass() {
        return idsOfCarsInClass;
    }

    public void setIdsOfCarsInClass(List<Integer> idsOfCarsInClass) {
        this.idsOfCarsInClass = idsOfCarsInClass;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}