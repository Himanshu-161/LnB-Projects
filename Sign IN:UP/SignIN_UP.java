import java.util.Scanner;
public  class SignIN_UP extends File_Handling_SignIN_UP{
    static String name;
    static String email;
    static String password;
    static Scanner sc=new Scanner(System.in);
    static void SignIN_UP()
    {
        for(int i=0;;i++) {
            boolean flag = true;
            char a;
            System.out.println("Welcome:-)");
            System.out.println("Here are the options:");
            System.out.println("1.CREATE DATA BASE FILE \n2.LOGIN \n3.SIGNUP \n4.DELETE ALL DATA \n5.EXIT  ");
            System.out.println("Enter your choice:");
            a = sc.next().charAt(0);
            if (a >= '1' && a <= '5')
            {
                switch (a)
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
                                System.out.println("    ");
                                System.out.println("Login Successful:-)");
                                System.out.println("Welcome to Home page :-  ");
                                System.out.println("   ");
                            }
                            else {
                                flag = false;
                                System.out.println("You entered wrong password");
                            }
                        }
                        else
                        {
                            if (flag) {
                                System.out.println(" You entered wrong login name");
                                System.out.println("Please SignUp.");
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
                        email = sc.next();
                        write_file(name, password, email);
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
                System.out.println("You entered wrong choice ");
            }
        }
    }
    public static void main(String[] args) {
        SignIN_UP();
    }
}


