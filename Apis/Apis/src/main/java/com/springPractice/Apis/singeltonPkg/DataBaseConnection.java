package com.springPractice.Apis.singeltonPkg;

//Double-checked locking:
public class DataBaseConnection {

    private static volatile DataBaseConnection instance;

    private DataBaseConnection()
    {
            // private constructor prevents external instantiation
    }

    public static DataBaseConnection getInstance()
    {
        /*
        first no lock
         */
        if(instance == null)
        {
            /*
            come under synchronized locking--
            only one instance of DataBaseConnection throughout the application.
             */
            synchronized(DataBaseConnection.class){
                /*
                if(instance == null) check inside a synchronized block
                ensures that only one thread at a time can enter that block.
                This prevents race conditions.
                 */
                if(instance == null){
                    instance=new DataBaseConnection();
                }
            }
        }
        return instance;
    }
}
