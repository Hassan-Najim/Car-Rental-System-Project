package javaapplication2;

/**
 *
 * @author ahmed
 */
public class CarInfo {
  /*
   * here are the properies we need.
   * if you want to add more please make sure to update constructor and
   * CarInfoBuilder class
   * 
   */
  private final int carId;
  private String carType;
  private String carBrand;
  private String carModel;
  private String carColor;
  private String carCredentials;
  private boolean isAvailable;
  private double hourlyRate;

  private CarInfo(int carId, String carType, String carBrand, String carModel, String carColor,
      String carCredentials, boolean isAvailable, double hourlyRate) {
    this.carId = carId;
    this.carType = carType;
    this.carBrand = carBrand;
    this.carModel = carModel;
    this.carColor = carColor;
    this.carCredentials = carCredentials;
    this.isAvailable = isAvailable;
    this.hourlyRate = hourlyRate;
  }

  // --------------------------------------------------------------------------
  // --------------------------- getter and setters ---------------------------
  // --------------------------------------------------------------------------
  // the setters need to be changed later and be integrated with the db

  public int getCarId() {
    return carId;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public String getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(String carBrand) {
    this.carBrand = carBrand;
  }

  public String getCarModel() {
    return carModel;
  }

  public void setCarModel(String carModel) {
    this.carModel = carModel;
  }

  public String getCarColor() {
    return carColor;
  }

  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }

  public String getCarCredentials() {
    return carCredentials;
  }

  public void setCarCredentials(String carCredentials) {
    this.carCredentials = carCredentials;
  }

  public boolean isIsAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public double getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------
  // --------------------------------------------------------------------------

  /*
   * ==========================================
   * I added this class because the constructor
   * arguments are too long
   * ==========================================
   */

  public static class CarInfoBuilder {
    private final int carId;
    private String carType;
    private String carBrand;
    private String carModel;
    private String carColor;
    private String carCredentials;
    private boolean isAvailable;
    private double hourlyRate;

    /*
     * This constructor is Mandatory because carId is final and we will have to pass
     * an id every time we make a car
     */

    public CarInfoBuilder(int carId) {
      this.carId = carId;
    }

    /*
     * =========================================================
     * here we return "this" so we can have chained method calls
     * which is realy useful when we want to create a car,
     * instead of typing a long constructor and mabey we don't
     * have all the car info, we can just use the builder class
     * with only the builder methods we need
     * =========================================================
     */
    public CarInfoBuilder carType(String carType) {
      this.carType = carType;
      return this;
    }

    public CarInfoBuilder carBrand(String carBrand) {
      this.carBrand = carBrand;
      return this;
    }

    public CarInfoBuilder carModel(String carModel) {
      this.carModel = carModel;
      return this;
    }

    public CarInfoBuilder carColor(String carColor) {
      this.carColor = carColor;
      return this;
    }

    public CarInfoBuilder carCredentials(String carCredentials) {
      this.carCredentials = carCredentials;
      return this;
    }

    public CarInfoBuilder isAvailable(boolean isAvailable) {
      this.isAvailable = isAvailable;
      return this;
    }

    public CarInfoBuilder hourlyRate(double hourlyRate) {
      this.hourlyRate = hourlyRate;
      return this;
    }

    // after we finish we call the build function to call the constructor for us
    public CarInfo build() {
      return new CarInfo(carId, carType, carBrand, carModel, carColor,
          carCredentials, isAvailable, hourlyRate);
    }
  }

  // this will just print the car info
  @Override
  public String toString() {
    return "Car Info:\n" +
        "  Car Id: " + carId + "\n" +
        "  Car Type: " + carType + "\n" +
        "  Car Brand: " + carBrand + "\n" +
        "  Car Model: " + carModel + "\n" +
        "  Car Color: " + carColor + "\n" +
        "  Car Credentials: " + carCredentials + "\n" +
        "  Available: " + (isAvailable ? "Yes" : "No") + "\n" +
        "  Hourly Rate: $" + String.format("%.2f", hourlyRate);
  }

}