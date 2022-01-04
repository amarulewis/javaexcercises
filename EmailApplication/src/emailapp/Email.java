package emailapp;

import java.util.*;
import java.io.*;

public class Email {
    public Scanner s = new Scanner(System.in);

    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    public Email(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: "+this.fname+" "+this.lname);

        this.dept = this.setDept();
        this.password = this.generate_pw(8);
        this.email = this.generate_email();
    }
    private String generate_email(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".itsamaru.com";
    }
    private String setDept(){
        System.out.println("Department codes \n1 for sales \n2 for Development \n3 for Accounting");
        boolean flag = false;
        do {
            System.out.println("Enter Department code");
            int choice =s.nextInt();
            switch(choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");
            }
        } while (!flag);
        return null;
    }

    private String generate_pw(int length){
        Random r = new Random();
        String Capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars="abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234566789";
        String symbols = "!@#$%^&*";
        String values = Capital_chars+Small_chars+numbers+symbols;

        String password="";
        for(int i=0;i<length;i++){
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    //change password
    public void set_password(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password? (Y/N");
            char choice = s.next().charAt(0);
            if(choice=='Y' || choice == 'y'){
                flag = true;
                System.out.println("enter current password:");
                String temp = s.next();
                if(temp.equals(this.password)){
                    System.out.println("enter new password:");
                    this.password = s.next();
                    System.out.println("Password successfully changed");
                }
                else {
                    System.out.println("Inccorect password");
                }

            } else if(choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled!");
            } else {
                System.out.println("Please enter a valid choice");
            }
        }while (!flag);
    }

    //mailbox capacity
    public void set_mailCap(){
        System.out.println("Current capacity = "+this.mailCapacity+"mb");
        System.out.print("Enter new mailbox capacity:");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    //set alternative mail
    public void alt_email(){
        System.out.println("Enter new alternate mail: ");
        this.alter_email = s.next();
        System.out.println("alternative email successfully set");
    }

    public void getInfo(){
        System.out.println("New: "+this.fname+" "+this.lname);
        System.out.println("Department: "+this.dept);
        System.out.println("Email: "+this.email);
        System.out.println("Password: "+this.password);
        System.out.println("Mailbox capacity: "+this.mailCapacity+"mb");
        System.out.println("Alternate mail: "+this.alter_email);

    }

    public void storefile(){
        try{
            FileWriter in = new FileWriter("./info.txt");
            in.write("First name: "+this.fname);
            in.append("\nLast name: "+this.lname);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+this.password);
            in.append("\nCapacity: "+this.mailCapacity);
            in.append("\nAlternate email: "+this.alter_email);
            in.close();
            System.out.println("Data Store..");

        }catch (Exception e){System.out.println(e);}
    }

    public void read_file(){
        try{
            FileReader f1 = new FileReader("./info.txt");
            BufferedReader bufferreader = new BufferedReader((f1));
            String line;
            while((line = bufferreader.readLine()) != null){
                System.out.println(line);
            }
            System.out.println();
            f1.close();
        } catch (Exception e){System.out.println(e);}
    }

}

