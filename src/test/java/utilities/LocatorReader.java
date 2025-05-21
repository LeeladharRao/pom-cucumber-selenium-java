package utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class LocatorReader {

    private static final Map<String, By> locatorMap = new HashMap<>();

    public static void loadLocatorsFromJson(String jsonString) {

        ObjectMapper objMap = new ObjectMapper();

        try {
            List<Locator> locators = objMap.readValue(jsonString, new TypeReference<List<Locator>>() {
            });

            for (Locator locator : locators) {
                String key = locator.getLocator();
                String locatorName = locator.getLocatorName();
                String type = locator.getLocatorType().toString().toLowerCase();
                By by;

                switch (type) {
                    case "id" -> by = By.id(key);
                    case "name" -> by = By.name(key);
                    case "css" -> by = By.cssSelector(key);
                    case "xpath" -> by = By.xpath(key);
                    case "linktext" -> by = By.linkText(key);
                    default -> throw new IllegalArgumentException("Unsupported locator type: " + type);
                }
                locatorMap.put(locatorName, by);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static By findLocatorByPartialName(String name) {
        for (Map.Entry<String, By> entry : locatorMap.entrySet()) {
            if (entry.getKey().toLowerCase().contains(name.toLowerCase())) {
                return entry.getValue();
            }
        }
        throw new NoSuchElementException("No locator found containing: " + name);
    }

}
