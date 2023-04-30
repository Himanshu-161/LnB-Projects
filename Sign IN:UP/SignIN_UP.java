import java.util.Scanner;
public  class SignIN_UP extends File_Handling_SignIN_UP{
    static String name;
    static String gmail;
    static String password;
    static Scanner sc=new Scanner(System.in);
    static void SignIN_UP()
    {
        for(int i=0;;i++) {
            boolean flag = true;
            char x;
            System.out.println("1.CREATE DATA BASE FILE\n2. LOGIN\n3. SIGNUP\n4. DELETE ALL DATA\n5. EXIT  ");
            System.out.println("Enter your choice:");
            x = sc.next().charAt(0);

            if (x >= '1' && x <= '5')
            {
                switch (x)
                {

                    case '1': {
                        create();
                        break;
                    }
                    case '2': {
                        System.out.println("Enter login details");
                        System.out.println("Enter login name");
                        String loginName = sc.next();


                        if (read(loginName)) {
                            System.out.println("Enter your password");
                            String loginPassword = sc.next();


                            if (read(loginPassword)) {
                                System.out.println(" \n \n");
                                System.out.println("Login Successful:-)");
                                System.out.println("Welcome to Home page :-\n");
                                System.out.println("**********");
                                System.out.println("Thanks for visiting our page ");
                                System.out.println("Created by Himanshu");
                                System.out.println("**********");
                                System.out.println("\n");
                            } else {
                                flag = false;
                                System.out.println("you entered wrong password");
                            }
                        } else
                        {
                            if (flag) {
                                System.out.println("\n you entered wrong login name \n please signup \n");

                            }


                        }

                        break;
                    }
                    case '3': {
                        System.out.println(" Enter your details");
                        System.out.println("Enter your name");
                        name = sc.next();


                        System.out.println("Enter your password");
                        password = sc.next();


                        System.out.println("Enter your email");
                        gmail = sc.next();

                        write_file(name, password, gmail);

                        break;
                    }
                    case '4': {
                        delete();
                        break;
                    }
                    case '5': {
                        break;
                    }
                    default: {
                        System.out.println("You entered wrong choice");
                    }
                }
            }
            else
            {
                System.out.println("You entered wrong choice \n");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome");
        System.out.println("Here are the options:");
        SignIN_UP();
    }

}


