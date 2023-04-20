package Exceptions;

import java.util.ArrayList;
import java.util.Scanner;

public class finish {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        boolean test = true;

        while (test) {
            My_human my_human = new My_human();
            System.out.print("Введите строку : ");
            str = scan.nextLine();
            str = str_correct(str);
            my_human.create(str);
            if (my_human.problems.equals("")) {
                System.out.println(my_human.toString());
                System.out.println(My_write.my_write(my_human));
                test = false;}
            else {
                System.out.println(my_human.problems);
                if (my_human.valid) {System.out.println(my_human.toString());}
                System.out.println("Объект заполнен не корректно и не будет записан. Попробуйте еще раз.");
                }        
        }
        scan.close();}

    public static String str_correct(String s) {
        ArrayList<Character> char_arr = new ArrayList<>();
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char_arr.add(s.charAt(i));
            if (s.charAt(i)==' '&&s.charAt(i+1)==' ') 
                {while (s.charAt(i+1)==' '){i++;}}}
        s = "" ;       
        for (int i = 0; i < char_arr.size(); i++) {s = s+char_arr.get(i);}
        return s;} 
                 
    }
