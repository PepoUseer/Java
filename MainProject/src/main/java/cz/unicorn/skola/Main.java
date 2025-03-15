package cz.unicorn.skola;

public class Main {




    public static void main(String[] args) {

        int scitaniConst = 10;
        Scitani scitani = new Scitani();
        int s = scitani.scitani(scitaniConst,10);
        System.out.println(s);

        Odcitani odcitani = new Odcitani();
        scitaniConst++;
        int o = odcitani.odcitani(scitaniConst++,10);
        System.out.println(o);

        System.out.println(scitaniConst);

        Nasobeni nasobeni = new Nasobeni();
        int n = nasobeni.nasobeni(10,--scitaniConst);
        System.out.println(n);

        System.out.println(scitaniConst);

        Deleni deleni = new Deleni();
        int d = deleni.deleni(10,5);
        System.out.println(d);


    }



}