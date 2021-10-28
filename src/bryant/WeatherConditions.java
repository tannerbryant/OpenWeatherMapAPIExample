package bryant;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherConditions {
    private int id;
    private String name;
    @SerializedName("main")
    private Map<String, Float> measurements;

    public WeatherConditions(int id, String name, Map<String, Float> measurements) {
        this.id = id;
        this.name = name;
        this.measurements = measurements;
    }

    public void display() {
        System.out.printf("ID: %s\nName: %s\n", this.id, this.name);
        for (String itemName : this.measurements.keySet()) {
            System.out.println("  " + itemName + ": " + this.measurements.get(itemName));
        }
    }
}
