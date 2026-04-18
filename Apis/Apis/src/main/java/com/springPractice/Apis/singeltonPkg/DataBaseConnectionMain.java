package com.springPractice.Apis.singeltonPkg;

public class DataBaseConnectionMain {
    public static void main(String[] args) {
        // Correct way to call it
        DataBaseConnection db1 = DataBaseConnection.getInstance();
        DataBaseConnection db2 = DataBaseConnection.getInstance();

        System.out.println(db1 == db2); // Output: true (Both are the exact same object)
    }
}
