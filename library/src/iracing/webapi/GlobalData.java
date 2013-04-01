package iracing.webapi;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class GlobalData {
    
    private List<EventType> eventTypes;
    private List<Category> categories;
    private List<Division> divisions;
    private List<License> licenses;
    private List<Track> tracks;
    private List<Car> cars;
    private List<CarClass> carClasses;
    private List<YearAndQuarters> yearAndQuarters;
    private List<Season> seasons;
    private List<LicenseGroup> licenseGroups;
    private List<AvailableSeries> availableSeries;
    private List<LicenseLevel> licenseLevels;
    private YearAndQuarter currentYearAndQuarter;
    private List<HardcoreOption> hardcoreOptions;
    private List<Club> clubs;

    public GlobalData() {}
    
    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarClass> getCarClasses() {
        return carClasses;
    }

    public void setCarClasses(List<CarClass> carClasses) {
        this.carClasses = carClasses;
    }

    public List<YearAndQuarters> getYearAndQuarters() {
        return yearAndQuarters;
    }

    public void setYearAndQuarters(List<YearAndQuarters> yearAndQuarters) {
        this.yearAndQuarters = yearAndQuarters;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public List<LicenseGroup> getLicenseGroups() {
        return licenseGroups;
    }

    public void setLicenseGroups(List<LicenseGroup> licenseGroups) {
        this.licenseGroups = licenseGroups;
    }

    public List<AvailableSeries> getAvailableSeries() {
        return availableSeries;
    }

    public void setAvailableSeries(List<AvailableSeries> availableSeries) {
        this.availableSeries = availableSeries;
    }

    public List<LicenseLevel> getLicenseLevels() {
        return licenseLevels;
    }

    public void setLicenseLevels(List<LicenseLevel> licenseLevels) {
        this.licenseLevels = licenseLevels;
    }

    public YearAndQuarter getCurrentYearAndQuarter() {
        return currentYearAndQuarter;
    }

    public void setCurrentYearAndQuarter(YearAndQuarter currentYearAndQuarter) {
        this.currentYearAndQuarter = currentYearAndQuarter;
    }

    public List<HardcoreOption> getHardcoreOptions() {
        return hardcoreOptions;
    }

    public void setHardcoreOptions(List<HardcoreOption> hardcoreOptions) {
        this.hardcoreOptions = hardcoreOptions;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }
    
    public void persist(long apiUserCustomerId, GlobalDataDao dao) {
        // TODO: organize these so foreign keys are obeyed
        for (EventType o : eventTypes) {
            if (dao.getEventType(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (Category o : categories) {
            if (dao.getCategory(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (Division o : divisions) {
            if (dao.getDivision(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (License o : licenses) {
            if (dao.getLicense(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (Track o : tracks) {
            if (dao.getTrack(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (Car o : cars) {
            if (dao.getCar(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (CarClass o : carClasses) {
            if (dao.getCarClass(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (YearAndQuarters o : yearAndQuarters) {
            if (dao.getYearAndQuartersByYear(o.getYear()) == null) {
                dao.insertOrUpdate(o);
            }
        }
        for (Season o : seasons) {
            if (dao.getSeason(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (LicenseGroup o : licenseGroups) {
            if (dao.getLicenseGroup(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (AvailableSeries o : availableSeries) {
            if (dao.getAvailableSeries(o.getSeasonId()) == null) {
                dao.insert(apiUserCustomerId, o);
            }
        }
        for (LicenseLevel o : licenseLevels) {
            if (dao.getLicenseLevel(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (HardcoreOption o : hardcoreOptions) {
            if (dao.getHardcoreOption(o.getId()) == null) {
                dao.insert(o);
            }
        }
        for (Club o : clubs) {
            if (dao.getClub(o.getId()) == null) {
                dao.insert(o);
            }
        }
        dao.setCurrentYearAndQuarter(currentYearAndQuarter);
        dao.setLastUpdate(new Date());
    }
    
}