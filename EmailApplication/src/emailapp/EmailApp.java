package emailapp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //prompt for info
        System.out.println("Enter First Name");
        String f_name = s.next();
        System.out.println("Enter Last Name");
        String l_name = s.next();

        //create object
        Email em1 = new Email(f_name,l_name);
        int choice = -1;

        do {
            System.out.println("\n******" +
                    "\nPlease choose one of the following options" +
                    "\n1. Show Info" +
                    "\n2. Change Password" +
                    "\n3. Change mailbox capacity" +
                    "\n4. Set Alternate email" +
                    "\n5. Save data to file" +
                    "\n6. View file data" +
                    "\n7. Exit");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alt_email();
                    break;
                case 5:
                    em1.storefile();
                    break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    System.out.println("Exiting Application...");
                    break;
                default:
                    System.out.println("Please choose a valid option and try again");
            }
        }while(choice!=7);
    }
}
