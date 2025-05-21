package utilities;

public class Locator {

    private String locator;
    private String locatorName;
    private String locatorType;

    public Locator(String locator, String locatorName, String locatorType) {
        this.locator = locator;
        this.locatorName = locatorName;
        this.locatorType = locatorType;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getLocatorName() {
        return locatorName;
    }

    public void setLocatorName(String locatorName) {
        this.locatorName = locatorName;
    }

    public Object getLocatorType() {
        return locatorType;
    }

    public void setLocatorType(String locatorType) {
        this.locatorType = locatorType;
    }
}
