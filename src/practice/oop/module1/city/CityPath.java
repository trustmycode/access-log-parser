package practice.oop.module1.city;

public class CityPath {

  public City city;
  public int cost;

  public CityPath(City city) {
    this(city, 1);
  }

  public CityPath(City city, int cost) {
    this.city = city;
    this.cost = cost;
  }

  @Override
  public String toString() {
    return city.cityName +
        ", стоимость " + cost;
  }
}
