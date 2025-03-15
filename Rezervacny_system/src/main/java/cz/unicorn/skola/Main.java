package cz.unicorn.skola;

import cz.unicorn.skola.data.MainDataStructure;
import cz.unicorn.skola.functions.AppLogicFunction;


public class Main {

    public static void main(String[] args) {

        MainDataStructure.initDB();
        AppLogicFunction appLogicFunction = new AppLogicFunction();
        appLogicFunction.startApplication();
    }


}