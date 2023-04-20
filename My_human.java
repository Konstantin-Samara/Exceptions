package Exceptions;

public class My_human {
    Boolean valid = true;
    String problems = "";
    String last_name;
    String first_name;
    String father_name;
    String birth_date;
    String gender;
    String phone_number;
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getFather_name() {
        return father_name;
    }
    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }
    public String getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    private boolean is_name(String str) {
        boolean test = true;
            for (int i = 0; i < str.length(); i++) {
                if (!((str.charAt(i)>='a'&&str.charAt(i)<='z')||
                (str.charAt(i)>='A'&&str.charAt(i)<='Z'))) {test = false;}}
        return test;}

    private boolean is_phone_number(String str) {
        boolean test = true;
        try {long number = Long.parseLong(str);} 
        catch (NumberFormatException e) {test = false;}
        return test;}

    private boolean is_gender(String str) {
        boolean test = true;
        if(str.length()!=1){test = false;}
        else{
            if (!(str.equals("m")|str.equals("M")|
            str.equals("f")|str.equals("F"))) {test = false;}}
        return test;}

    private boolean is_birth_date(String str) {
        int day,month,year;
        boolean test = true;
        String[] str_arr = str.split("\\.");
        if (str_arr.length==3){
            try {
                day = Integer.parseInt(str_arr[0]);
                month = Integer.parseInt(str_arr[1]);                
                year = Integer.parseInt(str_arr[2]);
                if (!(day>0&&day<32)) {test = false;}
                if (!(month>0&&month<13)) {test = false;}
                if (!(year>0&&year<2024)) {test = false;}} 
            catch (NumberFormatException e) {test = false;}}
        else {test = false;}
        return test;}

    @Override
    public String toString() {
        String str="";
        if (this.getLast_name()!=null)
            {str = str+"Фамилия : "+this.getLast_name()+"\n";}
        else {str = str+"ФАМИЛИЯ НЕ ЗАПОЛНЕНА!!!\n";}    

        if (this.getFirst_name()!=null) 
            {str = str+"Имя : "+this.getFirst_name()+"\n";}
        else {str = str+"ИМЯ НЕ ЗАПОЛНЕНО!!!\n";}    
    
        if (this.getFather_name()!=null) 
            {str = str+"Отчество : "+this.getFather_name()+"\n";}
        else {str = str+"ОТЧЕСТВО НЕ ЗАПОЛНЕНО!!!\n";}    

        if (this.getGender()!=null) 
            {str = str+"Пол : "+this.getGender()+"\n";}
        else {str = str+"ПОЛ НЕ ЗАПОЛНЕН!!!\n";}    

        if (this.getBirth_date()!=null) 
            {str = str+"Дата рожднния : "+this.getBirth_date()+"\n";} 
        else {str = str+"ДАТА РОЖДЕНИЯ НЕ ЗАПОЛНЕНА!!!\n";}    
   
        if (this.getPhone_number()!=null) 
            {str = str+"Телефон : "+this.getPhone_number()+"\n";}
        else {str = str+"ТЕЛЕФОН НЕ ЗАПОЛНЕН!!!\n";}
        return str;}

    public void create(String str) {
        boolean test;
        String[] str_arr = str.split(" ");
        if (str_arr.length!=6) 
            {this.problems = this.problems+
            "Введено неверное кол-во параметров.\n";
            this.valid = false;}
        else{
            for (int i = 0; i < 6; i++) {
                test = true;
                if (this.is_gender(str_arr[i])&&this.getGender()==null) 
                    {this.setGender(str_arr[i]);test = false;}
                else {
                    if(this.is_birth_date(str_arr[i])&&this.getBirth_date()==null) 
                        {this.setBirth_date(str_arr[i]);test = false;}
                    else {
                        if (this.is_phone_number(str_arr[i])&&this.getPhone_number()==null)
                            {this.setPhone_number(str_arr[i]);test = false;}
                        else {
                            if (this.is_name(str_arr[i])){
                                if (this.getLast_name()==null) {
                                    this.setLast_name(str_arr[i]);test = false;}
                                else {                        
                                    if (this.getFirst_name()==null) {
                                        this.setFirst_name(str_arr[i]);test = false;}
                                    else 
                                        {if (this.getFather_name()==null) 
                                            {this.setFather_name(str_arr[i]);test = false;}}
                                     }
                                                        }
                            }
                        }    
                    }
                if (test) {this.problems = this.problems+
                    "Мы не смогли распознать введенную подстроку : "+str_arr[i]+"\n";}
            }}
    }
                                      
                                      
}
