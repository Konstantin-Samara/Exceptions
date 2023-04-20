package Exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class My_write {
    public static String my_write(My_human my_human) {
        String s = "записан во вновь созданный ";
        Boolean b = false;        
        File f = new File("Exceptions//Humans//"+my_human.getLast_name()+".txt");
        if(f.exists() && !f.isDirectory()) {b = true;s = "добавлен в существующий ";}
        try {
            FileWriter f_w = 
            new FileWriter("Exceptions//Humans//"+my_human.getLast_name()+".txt",b);

            f_w.append(my_human.getLast_name()+" "+my_human.getFirst_name()+" "+
            my_human.getFather_name()+" "+my_human.getBirth_date()+" "+
            my_human.getPhone_number()+" "+my_human.getGender()+"\n");
            
            f_w.close();}
        catch(IOException e) {
            return "Ошибка ввода-вывода данных (объект не записан) : \n "+e.getMessage();}
        return "Объект корректно "+s+"файл "+my_human.getLast_name()+".txt";}
}
