package tests.day14;

public class Singleton {



    //singleton class will have private constructor
    //it means other classes can not create object of this class

    private Singleton(){}

    private static String str;


    public static String getInstance(){

        //if str has no value, initialize it and return it
        if (str==null){
            System.out.println("string is null. assigning value to it");
            str="browser";
            System.out.println(str);
        }else{
        //if it has value just return it
            System.out.println("it has value that return it");
        }
        return str;

    }


    public static void nullString(){
        if (str!=null){
            str=null;
        }
    }


}



