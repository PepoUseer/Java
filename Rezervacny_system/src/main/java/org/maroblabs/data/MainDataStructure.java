package org.maroblabs.data;

import org.maroblabs.consts.ClassEnum;
import org.maroblabs.object.ClassTO;

import java.util.HashMap;

public class MainDataStructure {

    public static HashMap <ClassEnum, ClassTO> mainData = new HashMap<>();

    public static void initDB() {
        ClassTO class1 = new ClassTO();
        class1.setId(1L);
        class1.setName("Cierna miestnost");
        MainDataStructure.mainData.put(ClassEnum.CLASS_1, class1);

        ClassTO class2 = new ClassTO();
        class1.setId(2L);
        class1.setName("Biela miestnost");
        MainDataStructure.mainData.put(ClassEnum.CLASS_2, class2);

        ClassTO class3 = new ClassTO();
        class1.setId(3L);
        class1.setName("Seda miestnost");
        MainDataStructure.mainData.put(ClassEnum.CLASS_3, class3);
    }

}
