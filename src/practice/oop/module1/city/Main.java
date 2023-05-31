package practice.oop.module1.city;

public class Main {

  public static void main(String[] args) {

    City cityA = new City("A");
    City cityB = new City("B");
    City cityC = new City("C");
    City cityD = new City("D");
    City cityE = new City("E");
    City cityF = new City("F");

    cityA.addCityPath(new CityPath(cityF));
    cityA.addCityPath(new CityPath(cityB, 5));
    cityA.addCityPath(new CityPath(cityD, 6));
    cityB.addCityPath(new CityPath(cityC, 3));
    cityB.addCityPath(new CityPath(cityA, 5));
    cityC.addCityPath(new CityPath(cityD, 4));
    cityC.addCityPath(new CityPath(cityB, 3));
    cityD.addCityPath(new CityPath(cityA, 6));
    cityD.addCityPath(new CityPath(cityE, 2));
    cityD.addCityPath(new CityPath(cityC, 4));
    cityE.addCityPath(new CityPath(cityF, 2));
    cityF.addCityPath(new CityPath(cityB));
    cityF.addCityPath(new CityPath(cityE, 2));

    System.out.println(cityA);
    System.out.println(cityB);
    System.out.println(cityC);
    System.out.println(cityD);
    System.out.println(cityE);
    System.out.println(cityF);

    System.out.println(cityB.trips(3));
  }
}
