package iracing.webapi;

import java.util.*;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class GlobalDataInMemoryDao extends GlobalDataDao {

    private Date lastUpdate;
    private YearAndQuarter currentYearAndQuarter;
    private Map<Integer, AvailableSeries> availableSeries;
    private Map<Integer, Car> cars;
    private Map<Integer, CarClass> carClasses;
    private Map<Integer, Category> categories;
    private Map<Integer, Club> clubs;
    private Map<Integer, Division> divisions;
    private Map<Integer, EventType> eventTypes;
    private Map<Integer, HardcoreOption> hardcoreOptions;
    private Map<Integer, License> licenses;
    private Map<Integer, LicenseGroup> licenseGroups;
    private Map<Integer, LicenseLevel> licenseLevels;
    private Map<Integer, Season> seasons;
    private Map<Integer, Track> tracks;
    private Map<Integer, YearAndQuarters> yearAndQuarters;

    public GlobalDataInMemoryDao() {
        availableSeries = new HashMap<Integer, AvailableSeries>();
        cars = new HashMap<Integer, Car>();
        carClasses = new HashMap<Integer, CarClass>();
        categories = new HashMap<Integer, Category>();
        clubs = new HashMap<Integer, Club>();
        divisions = new HashMap<Integer, Division>();
        eventTypes = new HashMap<Integer, EventType>();
        hardcoreOptions = new HashMap<Integer, HardcoreOption>();
        licenses = new HashMap<Integer, License>();
        licenseGroups = new HashMap<Integer, LicenseGroup>();
        licenseLevels = new HashMap<Integer, LicenseLevel>();
        seasons = new HashMap<Integer, Season>();
        tracks = new HashMap<Integer, Track>();
        yearAndQuarters = new HashMap<Integer, YearAndQuarters>();
    }
    
    @Override
    public Date getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public YearAndQuarter getCurrentYearAndQuarter() {
        return currentYearAndQuarter;
    }

    @Override
    public void setCurrentYearAndQuarter(YearAndQuarter yaq) {
        this.currentYearAndQuarter = yaq;
    }

    @Override
    public List<AvailableSeries> getAvailableSeries() {
        return new ArrayList<AvailableSeries>(availableSeries.values());
    }

    @Override
    public AvailableSeries getAvailableSeries(int seasonId) {
        return availableSeries.get(seasonId);
    }

    @Override
    public void insert(long apiUserCustomerId, AvailableSeries o) {
        if (o != null) {
            availableSeries.put(o.getSeasonId(), o);
        }
    }

    @Override
    public void update(long apiUserCustomerId, AvailableSeries o) {
        insert(apiUserCustomerId, o);
    }
    
    @Override
    public List<Car> getCars() {
        return new ArrayList<Car>(cars.values());
    }

    @Override
    public Car getCar(int id) {
        return cars.get(id);
    }

    @Override
    public void insert(Car o) {
        if (o != null) {
            cars.put(o.getId(), o);
        }
    }

    @Override
    public void update(Car o) {
        insert(o);
    }
    
    @Override
    public List<CarClass> getCarClasses() {
        return new ArrayList<CarClass>(carClasses.values());
    }

    @Override
    public CarClass getCarClass(int id) {
        return carClasses.get(id);
    }

    @Override
    public void insert(CarClass o) {
        if (o != null) {
            carClasses.put(o.getId(), o);
        }
    }

    @Override
    public void update(CarClass o) {
        insert(o);
    }
    
    @Override
    public List<Category> getCategories() {
        return new ArrayList<Category>(categories.values());
    }

    @Override
    public Category getCategory(int id) {
        return categories.get(id);
    }

    @Override
    public void insert(Category o) {
        if (o != null) {
            categories.put(o.getId(), o);
        }
    }

    @Override
    public void update(Category o) {
        insert(o);
    }
    
    @Override
    public List<Club> getClubs() {
        return new ArrayList<Club>(clubs.values());
    }

    @Override
    public Club getClub(int id) {
        return clubs.get(id);
    }

    @Override
    public void insert(Club o) {
        if (o != null) {
            clubs.put(o.getId(), o);
        }
    }

    @Override
    public void update(Club o) {
        insert(o);
    }
    
    @Override
    public List<Division> getDivisions() {
        return new ArrayList<Division>(divisions.values());
    }

    @Override
    public Division getDivision(int id) {
        return divisions.get(id);
    }

    @Override
    public void insert(Division o) {
        if (o != null) {
            divisions.put(o.getId(), o);
        }
    }

    @Override
    public void update(Division o) {
        insert(o);
    }
    
    @Override
    public List<EventType> getEventTypes() {
        return new ArrayList<EventType>(eventTypes.values());
    }

    @Override
    public EventType getEventType(int id) {
        return eventTypes.get(id);
    }

    @Override
    public void insert(EventType o) {
        if (o != null) {
            eventTypes.put(o.getId(), o);
        }
    }

    @Override
    public void update(EventType o) {
        insert(o);
    }
    
    @Override
    public List<HardcoreOption> getHardcoreOptions() {
        return new ArrayList<HardcoreOption>(hardcoreOptions.values());
    }

    @Override
    public HardcoreOption getHardcoreOption(int id) {
        return hardcoreOptions.get(id);
    }

    @Override
    public void insert(HardcoreOption o) {
        if (o != null) {
            hardcoreOptions.put(o.getId(), o);
        }
    }

    @Override
    public void update(HardcoreOption o) {
        insert(o);
    }
    
    @Override
    public List<License> getLicenses() {
        return new ArrayList<License>(licenses.values());
    }

    @Override
    public License getLicense(int id) {
        return licenses.get(id);
    }

    @Override
    public void insert(License o) {
        if (o != null) {
            licenses.put(o.getId(), o);
        }
    }

    @Override
    public void update(License o) {
        insert(o);
    }
    
    @Override
    public List<LicenseGroup> getLicenseGroups() {
        return new ArrayList<LicenseGroup>(licenseGroups.values());
    }

    @Override
    public LicenseGroup getLicenseGroup(int id) {
        return licenseGroups.get(id);
    }

    @Override
    public void insert(LicenseGroup o) {
        if (o != null) {
            licenseGroups.put(o.getId(), o);
        }
    }

    @Override
    public void update(LicenseGroup o) {
        insert(o);
    }
    
    @Override
    public List<LicenseLevel> getLicenseLevels() {
        return new ArrayList<LicenseLevel>(licenseLevels.values());
    }

    @Override
    public LicenseLevel getLicenseLevel(int id) {
        return licenseLevels.get(id);
    }

    @Override
    public void insert(LicenseLevel o) {
        if (o != null) {
            licenseLevels.put(o.getId(), o);
        }
    }

    @Override
    public void update(LicenseLevel o) {
        insert(o);
    }
    
    @Override
    public List<Season> getSeasons() {
        return new ArrayList<Season>(seasons.values());
    }

    @Override
    public Season getSeason(int id) {
        return seasons.get(id);
    }

    @Override
    public void insert(Season o) {
        if (o != null) {
            seasons.put(o.getId(), o);
        }
    }

    @Override
    public void update(Season o) {
        insert(o);
    }
    
    @Override
    public List<Track> getTracks() {
        return new ArrayList<Track>(tracks.values());
    }

    @Override
    public Track getTrack(int id) {
        return tracks.get(id);
    }

    @Override
    public void insert(Track o) {
        if (o != null) {
            tracks.put(o.getId(), o);
        }
    }

    @Override
    public void update(Track o) {
        insert(o);
    }
    
    @Override
    public List<YearAndQuarters> getYearAndQuarters() {
        return new ArrayList<YearAndQuarters>(yearAndQuarters.values());
    }

    @Override
    public YearAndQuarters getYearAndQuartersByYear(int year) {
        return yearAndQuarters.get(year);
    }

    @Override
    public void insertOrUpdate(YearAndQuarters o) {
        if (o != null) {
            yearAndQuarters.put(o.getYear(), o);
        }
    }

    @Override
    public boolean containsCar(int id) {
        return cars.containsKey(id);
    }

    @Override
    public boolean containsCarClass(int id) {
        return carClasses.containsKey(id);
    }

    @Override
    public boolean containsCategory(int id) {
        return categories.containsKey(id);
    }

    @Override
    public boolean containsClub(int id) {
        return clubs.containsKey(id);
    }

    @Override
    public boolean containsDivision(int id) {
        return divisions.containsKey(id);
    }

    @Override
    public boolean containsEventType(int id) {
        return eventTypes.containsKey(id);
    }

    @Override
    public boolean containsHardcoreOption(int id) {
        return hardcoreOptions.containsKey(id);
    }

    @Override
    public boolean containsLicense(int id) {
        return licenses.containsKey(id);
    }

    @Override
    public boolean containsLicenseGroup(int id) {
        return licenseGroups.containsKey(id);
    }

    @Override
    public boolean containsLicenseLevel(int id) {
        return licenseLevels.containsKey(id);
    }

    @Override
    public boolean containsSeason(int id) {
        return seasons.containsKey(id);
    }

    @Override
    public boolean containsTrack(int id) {
        return tracks.containsKey(id);
    }
    
}