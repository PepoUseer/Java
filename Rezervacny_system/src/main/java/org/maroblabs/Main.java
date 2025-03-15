package org.maroblabs;

import org.maroblabs.data.MainDataStructure;
import org.maroblabs.functions.AppLogicFunction;


public class Main {

    public static void main(String[] args) {

        MainDataStructure.initDB();
        AppLogicFunction appLogicFunction = new AppLogicFunction();
        appLogicFunction.startApplication();
    }


}