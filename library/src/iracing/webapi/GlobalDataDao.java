package iracing.webapi;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public abstract class GlobalDataDao {
    
    public abstract Date getLastUpdate();
    public abstract void setLastUpdate(Date lastUpdate);
    
    public abstract YearAndQuarter getCurrentYearAndQuarter();
    public abstract void setCurrentYearAndQuarter(YearAndQuarter yaq);
    
    public boolean contains(Car o) {
        return (o != null ? containsCar(o.getId()) : false);
    }
    public abstract boolean containsCar(int id);
    public abstract List<Car> getCars();
    public abstract Car getCar(int id);
    public abstract void insert(Car o);
    public abstract void update(Car o);
    public void insertOrUpdate(Car o) {
        if (o != null) {
            if (containsCar(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(CarClass o) {
        return (o != null ? containsCarClass(o.getId()) : false);
    }
    public abstract boolean containsCarClass(int id);
    public abstract List<CarClass> getCarClasses();
    public abstract CarClass getCarClass(int id);
    public abstract void insert(CarClass o);
    public abstract void update(CarClass o);
    public void insertOrUpdate(CarClass o) {
        if (o != null) {
            if (containsCarClass(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(Category o) {
        return (o != null ? containsCategory(o.getId()) : false);
    }
    public abstract boolean containsCategory(int id);
    public abstract List<Category> getCategories();
    public abstract Category getCategory(int id);
    public abstract void insert(Category o);
    public abstract void update(Category o);
    public void insertOrUpdate(Category o) {
        if (o != null) {
            if (containsCategory(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(Club o) {
        return (o != null ? containsClub(o.getId()) : false);
    }
    public abstract boolean containsClub(int id);
    public abstract List<Club> getClubs();
    public abstract Club getClub(int id);
    public abstract void insert(Club o);
    public abstract void update(Club o);
    public void insertOrUpdate(Club o) {
        if (o != null) {
            if (containsClub(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(Division o) {
        return (o != null ? containsDivision(o.getId()) : false);
    }
    public abstract boolean containsDivision(int id);
    public abstract List<Division> getDivisions();
    public abstract Division getDivision(int id);
    public abstract void insert(Division o);
    public abstract void update(Division o);
    public void insertOrUpdate(Division o) {
        if (o != null) {
            if (containsDivision(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(EventType o) {
        return (o != null ? containsEventType(o.getId()) : false);
    }
    public abstract boolean containsEventType(int id);
    public abstract List<EventType> getEventTypes();
    public abstract EventType getEventType(int id);
    public abstract void insert(EventType o);
    public abstract void update(EventType o);
    public void insertOrUpdate(EventType o) {
        if (o != null) {
            if (containsEventType(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(HardcoreOption o) {
        return (o != null ? containsHardcoreOption(o.getId()) : false);
    }
    public abstract boolean containsHardcoreOption(int id);
    public abstract List<HardcoreOption> getHardcoreOptions();
    public abstract HardcoreOption getHardcoreOption(int id);
    public abstract void insert(HardcoreOption o);
    public abstract void update(HardcoreOption o);
    public void insertOrUpdate(HardcoreOption o) {
        if (o != null) {
            if (containsHardcoreOption(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(License o) {
        return (o != null ? containsLicense(o.getId()) : false);
    }
    public abstract boolean containsLicense(int id);
    public abstract List<License> getLicenses();
    public abstract License getLicense(int id);
    public abstract void insert(License o);
    public abstract void update(License o);
    public void insertOrUpdate(License o) {
        if (o != null) {
            if (containsLicense(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(LicenseGroup o) {
        return (o != null ? containsLicenseGroup(o.getId()) : false);
    }
    public abstract boolean containsLicenseGroup(int id);
    public abstract List<LicenseGroup> getLicenseGroups();
    public abstract LicenseGroup getLicenseGroup(int id);
    public abstract void insert(LicenseGroup o);
    public abstract void update(LicenseGroup o);
    public void insertOrUpdate(LicenseGroup o) {
        if (o != null) {
            if (containsLicenseGroup(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(LicenseLevel o) {
        return (o != null ? containsLicenseLevel(o.getId()) : false);
    }
    public abstract boolean containsLicenseLevel(int id);
    public abstract List<LicenseLevel> getLicenseLevels();
    public abstract LicenseLevel getLicenseLevel(int id);
    public abstract void insert(LicenseLevel o);
    public abstract void update(LicenseLevel o);
    public void insertOrUpdate(LicenseLevel o) {
        if (o != null) {
            if (containsLicenseLevel(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(Season o) {
        return (o != null ? containsSeason(o.getId()) : false);
    }
    public abstract boolean containsSeason(int id);
    public abstract List<Season> getSeasons();
    public abstract Season getSeason(int id);
    public abstract void insert(Season o);
    public abstract void update(Season o);
    public void insertOrUpdate(Season o) {
        if (o != null) {
            if (containsSeason(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public boolean contains(Track o) {
        return (o != null ? containsTrack(o.getId()) : false);
    }
    public abstract boolean containsTrack(int id);
    public abstract List<Track> getTracks();
    public abstract Track getTrack(int id);
    public abstract void insert(Track o);
    public abstract void update(Track o);
    public void insertOrUpdate(Track o) {
        if (o != null) {
            if (containsTrack(o.getId())) update(o);
            else insert(o);
        }
    }
    
    public abstract List<YearAndQuarters> getYearAndQuarters();
    public abstract YearAndQuarters getYearAndQuartersByYear(int year);
    public abstract void insertOrUpdate(YearAndQuarters o);
    
    public abstract List<AvailableSeries> getAvailableSeries();
    public abstract AvailableSeries getAvailableSeries(int seasonId);
    public abstract void insert(long apiUserCustomerId, AvailableSeries o);
    public abstract void update(long apiUserCustomerId, AvailableSeries o);
    
}