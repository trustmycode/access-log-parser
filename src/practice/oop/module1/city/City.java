package practice.oop.module1.city;

import java.util.ArrayList;
import java.util.List;

public class City {

  public String cityName;
  public List<CityPath> cityPaths;

  public City(String cityName) {
    this(cityName, null);
  }

  public City(String cityName, List<CityPath> cityPaths) {
    this.cityName = cityName;
    this.cityPaths = cityPaths;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(", Связанные города: ");
    if (cityPaths != null) {
      for (CityPath cityPath : cityPaths) {
        stringBuilder.append("\n").append(cityPath);
      }
    } else {
      stringBuilder.append("отсутствуют");
    }

    return "Город '" + cityName + '\'' + stringBuilder;
  }

  public void addCityPath(CityPath element) {
    if (cityPaths == null) {
      cityPaths = new ArrayList<>();
      cityPaths.add(element);
    } else {
      cityPaths.add(element);
    }
  }

  public void addCityPath(int index, CityPath element) {
    if (cityPaths == null) {
      cityPaths = new ArrayList<>();
      cityPaths.add(index, element);
    } else {
      cityPaths.add(index, element);
    }
  }

  public String trips(int numberOfTransitions) {
    if (this.cityPaths == null) {
      return null;
    }
    City city = this.cityPaths.get(0).city;
    if (numberOfTransitions == 0) {
      return this.cityName;
    } else if (numberOfTransitions == 1) {
      return city.cityName;
    } else {
      return city.trips(numberOfTransitions - 1);
    }
  }
}
