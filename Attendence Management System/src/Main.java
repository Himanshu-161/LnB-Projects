import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


class attend extends JFrame{
    Container c;
    JLabel name,password,email,stuid,wlc,intro,bks, bkr,bkl,emaill,passwordl,atdname,atdid,atdemail,bkt,welcome,avatar,mark ,atndman;
    JTextField name1,password1,email1,stuid1,emaill1,passwordl1;
    JTextArea outdata,hold;
    JPanel start,loginp,registerp,table;
    JButton login,register,register1,random,submit,back,jakarta,record,back1,logout;
    JRadioButton logint,logoutt,absent;
    JTable tabled;
    String [] columnNames1 = {"ID","Login Date","Login Time","Status","Logout Date","Logout Time"};
    DefaultTableModel model = new DefaultTableModel(columnNames1,0);

String [] rando = {"@","$","!","1","0","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","&","%"};
    String ranpas = "";
    String name_r, email_r,password_r,ID_r,atdnames,atdids,atdemails;

    attend(){
   try {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());


    setTitle("Attendance Management System");
    setBounds(100, 100, 1000, 700);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(null);


    c = getContentPane();

    start = new JPanel();
    start.setLayout(null);
    start.setBounds(0,0,1000,700);
    start.setBackground(Color.white);
    start.setVisible(true);
    c.add(start);





    registerp= new JPanel();
    registerp.setLayout(null);
    registerp.setBounds(0,0,1000,700);
    registerp.setBackground(Color.white);
    c.add(registerp);
    registerp.setVisible(false);


    loginp= new JPanel();
    loginp.setLayout(null);
    loginp.setBounds(0,0,1000,700);
    c.add(loginp);
    loginp.setVisible(false);



    table= new JPanel();
    table.setLayout(null);
    table.setBounds(0,0,1000,700);
    c.add(table);
    table.setVisible(false);



    Font font1 = new Font("Times New Roman",Font.BOLD,20);
    Font font3 = new Font("Times New Roman",Font.BOLD,30);
    ImageIcon img = new ImageIcon(getClass().getResource("bk1.jpg"));
    bks = new JLabel(img);
    bks.setBounds(50,150,400,400);
    start.add(bks);


    ImageIcon img1 = new ImageIcon(getClass().getResource("bk2.jpg"));
    bkr = new JLabel(img1);
    bkr.setBounds(250,0,1000,600);
    registerp.add(bkr);



    ImageIcon img2 = new ImageIcon(getClass().getResource("ck3 (1).jpg"));
    bkl = new JLabel(img2);
    bkl.setSize(1000,700);
    loginp.add(bkl);

    hold = new JTextArea();
    hold.setBounds(100,60,800,250);
    hold.setBorder(BorderFactory.createLineBorder(Color.blue,5,true));
    hold.setBackground(new Color(177, 190, 226));
    hold.setEditable(false);
    bkl.add(hold);

    ImageIcon img4 = new ImageIcon(getClass().getResource("avatar.png"));
    avatar = new JLabel(img4);
    avatar.setBounds(300,40,150,150);
    hold.add(avatar);


    mark = new JLabel("Mark your Attendance Here :-");
    mark.setBounds(220,0,400,50);
    mark.setFont(font3);
    hold.add(mark);


    ImageIcon img3 = new ImageIcon(getClass().getResource("bk5.jpg"));
    bkt = new JLabel(img3);
    bkt.setSize(1000,700);
    table.add(bkt);






    wlc = new JLabel("WELCOME");
    wlc.setBounds(400,30,300,30);
    wlc.setFont(font3);
    //wlc.setForeground(Color.white);
    start.add(wlc);


    atndman = new JLabel("ATTENDANCE MANAGEMENT SYSTEM");
    atndman.setBounds(200,100,600,30);
    atndman.setFont(font3);
    //wlc.setForeground(Color.white);
    start.add(atndman);


    intro = new JLabel("Sign in :-");
    intro.setBounds(670,180,600,50);
    intro.setFont(font3);
    //intro.setForeground(Color.white);
    start.add(intro);



    login = new JButton("Login");
    login.setBounds(610,470,100,50);
    login.setOpaque(true);
    //login.setBorderPainted(false);
   // login.setBackground(Color.BLUE);
    start.add(login);


    register = new JButton("Sign Up");
    register.setBounds(760,470,100,50);
    //register.setBackground();
    start.add(register);

    welcome = new JLabel("Enter your Registration Details Here :- ");
    welcome.setBounds(100,20,700,100);
    welcome.setFont(font3);
    //wlc.setForeground(Color.white);
    registerp.add(welcome);




    name = new JLabel("⦿ Name  ➡");
    name.setBounds(50,150,200,50);
    name.setFont(font1);
    //name.setForeground(Color.white);
    registerp.add(name);


    stuid = new JLabel("⦿ ID  ➡");
    stuid.setBounds(50,230,200,50);
    stuid.setFont(font1);
    //stuid.setForeground(Color.white);
    registerp.add(stuid);



    password = new JLabel("⦿ Password  ➡");
    password.setBounds(50,390,200,50);
    password.setFont(font1);
    //password.setForeground(Color.white);
    registerp.add(password);


    email = new JLabel("⦿ Email Id   ➡");
    email.setBounds(50,310,200,50);
    email.setFont(font1);
    // email.setForeground(Color.white);
    registerp.add(email);








    name1 = new JTextField();
    name1.setBounds(260,150,280,50);
    name1.setFont(font1);
    registerp.add(name1);



    stuid1 = new JTextField();
    stuid1.setBounds(260,230,280,50);
    stuid1.setFont(font1);
    registerp.add(stuid1);









    password1 = new JTextField();
    password1.setBounds(260,390,280,50);
    password1.setFont(font1);
    registerp.add(password1);



    email1 = new JTextField();
    email1.setBounds(260,310,280,50);
    email1.setFont(font1);
    registerp.add(email1);


    outdata = new JTextArea();
    outdata.setBounds(150,480,500,70);
    outdata.setFont(font1);
    Border br = BorderFactory.createTitledBorder("Status");
    outdata.setBorder(br);
    registerp.add(outdata);


    register1 = new JButton("Register");
    register1.setBounds(300,590,100,50);
    registerp.add(register1);



    random = new JButton("Generate");
    random.setBounds(320,390,100,50);
    bkr.add(random);

    back = new JButton("Back");
    back.setBounds(150,590,100,50);
    registerp.add(back);


    jakarta = new JButton("Get Details on E-mail");
    jakarta.setBounds(450,590,200,50);
    registerp.add(jakarta);








    passwordl = new JLabel("⦿ Password  ➡");
    passwordl.setBounds(400,340,200,50);
    passwordl.setFont(font1);
  // passwordl.setForeground(Color.BLUE);
    start.add(passwordl);


    emaill = new JLabel("⦿ Email Id   ➡");
    emaill.setBounds(400,260,200,50);
    emaill.setFont(font1);
  // emaill.setForeground(Color.BLUE);
    start.add(emaill);


    passwordl1 = new JTextField();
    passwordl1.setBounds(600,340,280,50);
    passwordl1.setFont(font1);
    start.add(passwordl1);



    emaill1 = new JTextField();
    emaill1.setBounds(600,260,280,50);
    emaill1.setFont(font1);
    start.add(emaill1);



    submit = new JButton("Submit");
    submit.setBounds(700,350,100,50);
    bkl.add(submit);


    logint = new JRadioButton("Login");
    logint.setBounds(150,350,200,50);
    logint.setOpaque(false);
    logint.setFont(font3);
    bkl.add(logint);


    logoutt = new JRadioButton("Logout");
    logoutt.setBounds(150,450,200,50);
    logoutt.setFont(font3);
    logoutt.setOpaque(false);
    bkl.add(logoutt);




    absent = new JRadioButton("Absent");
    absent.setBounds(150,550,200,50);
    absent.setFont(font3);
    absent.setOpaque(false);
    bkl.add(absent);



    atdid = new JLabel();
    atdid.setBounds(230,100,700,50);
    atdid.setFont(font1);
    //intro.setForeground(Color.white);
    hold.add(atdid);


    atdname = new JLabel();
    atdname.setBounds(220,180,700,50);
    atdname.setFont(font3);
    hold.add(atdname);


    atdemail = new JLabel();
    atdemail.setBounds(450,100,700,50);
    atdemail.setFont(font1);
    //intro.setForeground(Color.white);
    hold.add(atdemail);









    tabled = new JTable(model);
    JScrollPane scroll = new JScrollPane(tabled);
    scroll.setBounds(200,100,600,400);
    scroll.setOpaque(false);
   tabled.setOpaque(false);
//tabled.setBackground(Color.blue);
  // scroll.setBackground(Color.blue);
    bkt.add(scroll);











    record = new JButton("Records");
    record.setBounds(700,450,100,50);


    bkl.add(record);


    logout = new JButton("Logout");
    logout.setBounds(700,550,100,50);
    bkl.add(logout);



    back1 = new JButton("Back");
    back1.setBounds(450,550,100,50);


    bkt.add(back1);















    setVisible(true);
}catch(Exception e){

}
    }
}


public class Main {
    static int gen_number()
    {
        Random random = new Random();
        int num= random.nextInt(40);
        return num;
    }

    public static void main(String[] args) {
        attend atd = new attend();
try {





    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Student_Details", "root", "@1B2c3d4e5");
    String query1 = "use Attendance_management;";
    Statement st1 = con.createStatement();
    st1.executeUpdate(query1);






    atd.register.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                atd.start.setVisible(false);
                atd.registerp.setVisible(true);
            } catch (Exception f) {
                System.out.println(e);
            }
        }
    });


    atd.random.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 9; i++) {
                int a = gen_number();
                atd.ranpas += atd.rando[a];
            }
            atd.password1.setText(atd.ranpas);
        }
    });

    atd.login.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String em = atd.emaill1.getText();
                String pd = atd.passwordl1.getText();
                String ea = "";
                String pa = "";

                String query = "Select * from records where email = '"+em+"' and password = '"+pd+"';";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    ea = rs.getString("email");
                    pa = rs.getString("password");
                    atd.atdemails = ea;
                    atd.atdids = rs.getString("ID");
                    atd.atdnames = rs.getString("Name");


                }
                if(em.equals(ea) && pa.equals(pd) && em.length() >10 && pd.length() > 7 ){
                    atd.atdname.setText("Hi, "+atd.atdnames);
                    atd.atdid.setText("ID : "+atd.atdids);
                    atd.atdemail.setText("E-mail : "+atd.atdemails);
                    JOptionPane.showMessageDialog(atd.start,"Login Successful");

                    atd.start.setVisible(false);
                    atd.loginp.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(atd.start,"Please check your login details or register if you haven't already.");
                }




            }catch (Exception a){
                System.out.println(a);
            }

        }
    });

    atd.register1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                atd.name_r = atd.name1.getText();
                atd.ID_r = atd.stuid1.getText();
                atd.email_r = atd.email1.getText();
                atd.password_r = atd.password1.getText();



               String query = "Insert into records values("+atd.ID_r+",'"+atd.name_r+"','"+atd.email_r+"','"+atd.password_r+"');";
                Statement st = con.createStatement();
               st.executeUpdate(query);
                JOptionPane.showMessageDialog(atd.registerp,"Registration Successful");




            } catch (Exception f) {
                System.out.println(f);
                JOptionPane.showMessageDialog(atd.registerp,"Please check your Registration details or you may have already registered.");
            }

        }
    });







    atd.jakarta.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SendingEmail abcd = new SendingEmail();
            abcd.SendEmail("himanshu16101@gmail.com", atd.email1.getText(), "Registration Details", "Welcome " + atd.name1.getText() + " thank you for registering with our attendance management system.\n\nYour registration details are:\nName : " + atd.name1.getText() + "\nID : " + atd.stuid1.getText() + "\nEmail ID : " + atd.email1.getText() + "\nPassword : " + atd.password1.getText());

        }
    });

    atd.back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            atd.name1.setText(null);
            atd.stuid1.setText(null);
            atd.email1.setText(null);
            atd.password1.setText(null);
            atd.registerp.setVisible(false);
            atd.start.setVisible(true);
        }
    });


    atd.submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String data = "";
            if (atd.logint.isSelected()) {
                try {
                    String query = "Insert into attendance values(" + atd.atdids+",current_date(),current_time(),'Present',null,null);";
                    Statement st = con.createStatement();
                    st.executeUpdate(query);
                }catch (Exception ef){
                    System.out.println(ef);
                }
                data = "Welcome";
                JOptionPane.showMessageDialog(atd.loginp, data);

            } else if (atd.logoutt.isSelected()) {
                try {

                    String query = "update attendance  set Logout_date = current_date() , Logout_time = current_time() where ID ="+ atd.atdids+" and Logout_date is null and Logout_time is null;";
                    Statement st = con.createStatement();
                    st.executeUpdate(query);
                }catch (Exception efe){
                    System.out.println(efe);
                }


                data = "Good-Bye";
                JOptionPane.showMessageDialog(atd.loginp, data);

            } else if (atd.absent.isSelected()) {
                try {

                    String query = "Insert into attendance values("+atd.atdids+",'-------------','--------------','Absent','---------------','------------');";
                    Statement st = con.createStatement();
                    st.executeUpdate(query);
                }catch (Exception efee){
                    System.out.println(efee);
                }


                data = "Absent";
                JOptionPane.showMessageDialog(atd.loginp, data);

            }
        }
    });




    atd.record.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                String query = "select * from attendance where ID ="+atd.atdids+";";
                Statement st = con.createStatement();
                ResultSet rs1 =  st.executeQuery(query);

                while(atd.model.getRowCount() > 0)
                {
                    atd.model.removeRow(0);
                }




                while (rs1.next()){
                    Object[] rowData = {
                            rs1.getInt("ID"),
                            rs1.getString("Login_date"),
                            rs1.getString("Login_time"),
                            rs1.getString("Status"),
                            rs1.getString("Logout_date"),
                            rs1.getString("Logout_time")
                             };
                    atd.model.addRow(rowData);

                }
                rs1.close();
            }catch (Exception efee){
                System.out.println(efee);
            }
            atd.table.setVisible(true);
            atd.loginp.setVisible(false);
        }
    });

    atd.back1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            atd.table.setVisible(false);
            atd.loginp.setVisible(true);
        }
    });


    atd.logout.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            atd.emaill1.setText(null);
            atd.passwordl1.setText(null);
            atd.loginp.setVisible(false);
            atd.start.setVisible(true);
        }
    });
}
   catch(Exception g)
   {
    System.out.println(g);
}
    }
}