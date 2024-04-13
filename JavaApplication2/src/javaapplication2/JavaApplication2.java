package javaapplication2;

public class JavaApplication2 {

    public static void main(String[] args) {
        testCarInfo();
    }

    private static void testCarInfo() {
        // Simulate car information with dummy data

        int carId = 123;
        String carType = "Sedan";
        String carBrand = "Honda";
        String carModel = "Civic";
        String carColor = "blue";
        String carCredentials = "ABC123";
        boolean isAvailable = true;
        double hourlyRate = 35.00;

        CarInfo carInfo = new CarInfo.CarInfoBuilder(carId)
                .carType(carType)
                .carBrand(carBrand)
                .carModel(carModel)
                .carColor(carColor)
                .carCredentials(carCredentials)
                .isAvailable(isAvailable)
                .hourlyRate(hourlyRate)
                .build();

        System.out.println(carInfo);
    }
}
