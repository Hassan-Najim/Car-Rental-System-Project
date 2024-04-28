# SOFTWARE-CONSTRUCTION-Project

a Github Repository made for the software construction project 2023-2024

## To do later

- change setters in CarInfo.Java to update in db as will

## To consider

- validating data in CarInfoBuilder
  example
  public CarInfoBuilder hourlyRate(double hourlyRate) {
  if (hourlyRate < 0) throw new IllegalArgumentException("Hourly rate cannot be negative.");
  this.hourlyRate = hourlyRate;
  return this;
  }
