/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author moeja
 */
public class CarInfo {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author moeja
 */
public class Car {
     private String color;
    private String carType;
    private int Credentials;
    private String brand;
    private int RentPerHour;
    private int Model;
    public boolean Avalability = true;
    private Customer renter;

    public Car(String color, String carType, int Credentials, String brand, int RentPerHour, int Model, boolean Avalability) {
        this.color = color;
        this.carType = carType;
        this.Credentials = Credentials;
        this.brand = brand;
        this.RentPerHour = RentPerHour;
        this.Model = Model;
        this.Avalability = Avalability;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getCredentials() {
        return Credentials;
    }

    public void setCredentials(int Credentials) {
        this.Credentials = Credentials;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRentPerHour() {
        return RentPerHour;
    }

    public void setRentPerHour(int RentPerHour) {
        this.RentPerHour = RentPerHour;
    }

    public int getModel() {
        return Model;
    }

    public void setModel(int Model) {
        this.Model = Model;
    }

    public boolean isAvailable() {
        return Avalability;
    }



  /*
    public boolean getAvalability(boolean Avalability){
        if(Avalability==false){
            return false;
        }
        else{
            return true;
        }
    }
*/
        public void setAvalability(boolean Avalability) {
        this.Avalability = Avalability;
        // updates avalablity of car
    }

    public Customer getRenter() {
        return renter;
        //Returns info about customer 
    }

    public void setRenter(Customer renter) {
        this.renter = renter;
        //Assigning a car to a specific customer 
    }
    

    
}
    


}
