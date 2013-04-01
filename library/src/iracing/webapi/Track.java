package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class Track {
    
    private int id;
    private long sku;
    private int categoryId;
    private int priority;
    private int packageId;
    private String configName;
    private String skuName;
    private boolean retired;
    private double price;
    private String priceDisplay;
    private boolean hasNightLighting;
    private String name;
    private double nominalLapTime;
    
    public Track() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public void setPriceDisplay(String priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    public boolean getHasNightLighting() {
        return hasNightLighting;
    }

    public void setHasNightLighting(boolean hasNightLighting) {
        this.hasNightLighting = hasNightLighting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNominalLapTime() {
        return nominalLapTime;
    }

    public void setNominalLapTime(double nominalLapTime) {
        this.nominalLapTime = nominalLapTime;
    }

}