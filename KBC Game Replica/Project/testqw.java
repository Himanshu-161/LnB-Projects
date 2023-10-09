import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;



class Mframe111 extends JFrame implements ActionListener{
    static int gen_number()
    {
        Random random = new Random();
        int num= random.nextInt(1,5);
        return num;
    }
    JPanel pans,pang,panr;
    Timer tc;
    JLabel st,ge,re;
    Container c;
    JButton btns,b1,b2,b3,b4,ct,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,lf1,lf2,lf3,lf4;
    JTextArea que,prize,life,result1,result2;
    JButton [] arr = new JButton[15];
    int acd,bcd,i,time;
    int cnt=0;
    String rcd;
    String [] win = {"₹ 0","₹ 1,000","₹ 3,000","₹ 5,000","₹ 10,000","₹ 20,000","₹ 40,000","₹ 80,000","₹ 1,60,000","₹ 3,20,000","₹ 6,40,000","₹ 12,50,000","₹ 25,00,000","₹ 50,00,000","₹ 1 Crore","₹ 7 Crore"};


    ArrayList<ArrayList<String>> questq = new ArrayList<>();
    ArrayList<String> ans = new ArrayList<>();
    int tot =15;

    String answer;


    Mframe111() {
        try {



            File file1 = new File("dataa.txt");
            BufferedReader br = new BufferedReader(new FileReader(file1));
            {
                String line1;
                while ((line1 = br.readLine()) != null) {
                    String[] elements = line1.trim().split("@");
                    ArrayList<String> row = new ArrayList<>();
                    for (String element : elements) {
                        row.add(element);
                    }
                    questq.add(row);
                }}
                br.close();





            File file = new File("answ.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                ans.add(line);
            }
            reader.close();









            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            setBounds(300, 50, 1000, 800);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setLayout(null);
            c = getContentPane();


            pans = new JPanel();
            pans.setLayout(null);
            pans.setBounds(0,0,1000,800);
            c.add(pans);


        ImageIcon img1 = new ImageIcon("start.jpg");
        st = new JLabel(img1);
        st.setSize(1000,800);
        pans.add(st);
        pans.setVisible(true);


        pang = new JPanel();
        pang.setLayout(null);
        pang.setBounds(0, 0, 1000, 900);
        c.add(pang);
        pang.setVisible(false);


        panr = new JPanel();
        panr.setLayout(null);
        panr.setBounds(0,0,1000,800);
        c.add(panr);
        panr.setVisible(false);

        ImageIcon imgr = new ImageIcon("result.jpg");
        re = new JLabel(imgr);
        re.setBounds(0,0,1000,800);
        panr.add(re);

        result1=new JTextArea("Thank-you for playing the game. You did Great.👏🏽👏🏽👏🏽");
        result1.setLineWrap(true);
        result1.setWrapStyleWord(true);
        result1.setOpaque(false);
        result1.setForeground(Color.white);
        result1.setFont(new Font("Ariel",Font.BOLD,40));
        result1.setBounds(30,100,280,300);
        re.add(result1);


            result2=new JTextArea();
            result2.setLineWrap(true);
            result2.setWrapStyleWord(true);
            result2.setForeground(Color.white);
            result2.setOpaque(false);
            result2.setBounds(650,50,320,350);
            result2.setFont(new Font("Ariel",Font.BOLD,35));
            re.add(result2);






        btns = new JButton("Start");
        btns.setBounds(400, 630, 160, 60);
        btns.setFont(new Font("Ariel",Font.BOLD,45));
        btns.setBackground(new Color(0,0,139));
        btns.setBorder(BorderFactory.createLineBorder(Color.blue,3));
        btns.setForeground(Color.orange);
        st.add(btns);
        btns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent z) {
                pans.setVisible(false);
                pang.setVisible(true);
                tc.start();
            }
        });




            ImageIcon img2 = new ImageIcon("game.jpg");
            ge = new JLabel(img2);
            ge.setBounds(0,0,1000, 800);
            pang.add(ge);
            
            prize = new JTextArea();
            prize.setBounds(685,10,270,490);
            prize.setOpaque(false);
            prize.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.orange,3,true),"Prize Money:-",1,1,new Font("Ariel",Font.BOLD,30),Color.orange));
            prize.setEditable(false);
            ge.add(prize);
            
            life=new JTextArea();
            life.setBounds(50,10,270,490);
            life.setOpaque(false);
            life.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.orange,3,true),"Lifelines:-",1,1,new Font("Ariel",Font.BOLD,30),Color.orange));
            life.setEditable(false);
            ge.add(life);
            


            b1 = new JButton();
            b1.setBounds(70, 630, 400, 50);
            b1.setForeground(Color.white);
            b1.setBackground(new Color(0, 0, 139));
            b1.setFont(new Font("Ariel",Font.BOLD,20));
            b1.setBorder(BorderFactory.createLineBorder(Color.blue,3,true));
            ge.add(b1);
            b1.addActionListener(this);


            b2 = new JButton();
            b2.setBounds(520, 630, 400, 50);
            b2.setForeground(Color.white);
            b2.setBackground(new Color(0, 0, 139));
            b2.setBorder(BorderFactory.createLineBorder(Color.blue,3,true));
            b2.setFont(new Font("Ariel",Font.BOLD,20));
            ge.add(b2);
            b2.addActionListener(this);


            b3 = new JButton();
            b3.setBounds(70, 690, 400, 50);;
            b3.setForeground(Color.white);
            b3.setBackground(new Color(0, 0, 139));
            b3.setFont(new Font("Ariel",Font.BOLD,20));
            b3.setBorder(BorderFactory.createLineBorder(Color.blue,3,true));
            ge.add(b3);
            b3.addActionListener(this);


            b4 = new JButton();
            b4.setBounds(520, 690, 400, 50);
            b4.setForeground(Color.white);
            b4.setBackground(new Color(0, 0, 139));
            b4.setFont(new Font("Ariel",Font.BOLD,20));
            b4.setBorder(BorderFactory.createLineBorder(Color.blue,3,true));
            ge.add(b4);
            b4.addActionListener(this);


            que = new JTextArea();
            que.setBounds(70, 525, 850, 90);
            que.setFont(new Font("Ariel",Font.BOLD,30));
            que.setLineWrap(true);
            que.setWrapStyleWord(true);
            que.setMargin(new Insets(0,50,0,10));
            que.setForeground(Color.white);
            que.setBorder(BorderFactory.createLineBorder(Color.blue,5,true));
            que.setBackground(new Color(0, 0, 139));
            ge.add(que);


            ct = new JButton();
            ct.setBounds(435,460,100,60);
            ct.setFont(new Font("Ariel",Font.BOLD,50));
            ct.setForeground(Color.orange);
            ct.setBackground(new Color(0,0,139));
            ct.setBorder(BorderFactory.createLineBorder(Color.blue,3,true));
            ge.add(ct);

            arr[0] = p1 = new JButton("        1. ₹1,000");
            p1.setBounds(690,470,260,25);
            p1.setOpaque(false);
            p1.setContentAreaFilled(false);
            p1.setBorderPainted(false);
            p1.setForeground(Color.white);
            p1.setHorizontalAlignment(JButton.LEFT);
            p1.setFont(new Font("Ariel",Font.BOLD,22));
            ge.add(p1);

            arr [1] = p2 = new JButton("        2. ₹3,000");
            p2.setBounds(690,440,260,25);
            p2.setOpaque(false);
            p2.setContentAreaFilled(false);
            p2.setBorderPainted(false);
            p2.setHorizontalAlignment(JButton.LEFT);
            p2.setForeground(Color.white);
            p2.setFont(new Font("Ariel",Font.BOLD,22));
            ge.add(p2);

            arr [2] = p3 = new JButton("        3. ₹5,000");
            p3.setBounds(690,410,260,25);
            p3.setFont(new Font("Ariel",Font.BOLD,22));
            p3.setOpaque(false);
            p3.setContentAreaFilled(false);
            p3.setHorizontalAlignment(JButton.LEFT);
            p3.setBorderPainted(false);
            p3.setForeground(Color.white);
            ge.add(p3);

            arr [3] = p4 = new JButton("        4. ₹10,000");
            p4.setBounds(690,380,260,25);
            p4.setFont(new Font("Ariel",Font.BOLD,22));
            p4.setOpaque(false);
            p4.setContentAreaFilled(false);
            p4.setHorizontalAlignment(JButton.LEFT);
            p4.setBorderPainted(false);
            p4.setForeground(Color.white);
            ge.add(p4);

            arr [4] = p5 = new JButton("➡     5. ₹20,000");
            p5.setBounds(690,350,260,25);
            p5.setFont(new Font("Ariel",Font.BOLD,22));
            p5.setHorizontalAlignment(JButton.LEFT);
            p5.setOpaque(false);
            p5.setContentAreaFilled(false);
            p5.setBorderPainted(false);
            p5.setForeground(Color.GREEN);
            ge.add(p5);

            arr [5] = p6 = new JButton("       6. ₹40,000");
            p6.setBounds(690,320,260,25);
            p6.setFont(new Font("Ariel",Font.BOLD,22));
            p6.setOpaque(false);
            p6.setContentAreaFilled(false);
            p6.setBorderPainted(false);
            p6.setForeground(Color.white);
            p6.setHorizontalAlignment(JButton.LEFT);
            ge.add(p6);

            arr [6] = p7 = new JButton("       7. ₹80,000");
            p7.setBounds(690,290,260,25);
            p7.setFont(new Font("Ariel",Font.BOLD,22));
            p7.setOpaque(false);
            p7.setContentAreaFilled(false);
            p7.setBorderPainted(false);
            p7.setForeground(Color.white);
            p7.setHorizontalAlignment(JButton.LEFT);
            ge.add(p7);

            arr [7] = p8 = new JButton("➡    8. ₹1,60,000");
            p8.setBounds(690,260,260,25);
            p8.setFont(new Font("Ariel",Font.BOLD,22));
            p8.setOpaque(false);
            p8.setContentAreaFilled(false);
            p8.setBorderPainted(false);
            p8.setForeground(Color.GREEN);
            p8.setHorizontalAlignment(JButton.LEFT);
            ge.add(p8);

            arr [8] = p9 = new JButton("      9. ₹3,20,000");
            p9.setBounds(690,230,260,25);
            p9.setFont(new Font("Ariel",Font.BOLD,22));
            p9.setOpaque(false);
            p9.setContentAreaFilled(false);
            p9.setBorderPainted(false);
            p9.setForeground(Color.white);
            p9.setHorizontalAlignment(JButton.LEFT);
            ge.add(p9);

            arr [9] = p10 = new JButton("    10. ₹6,40,000");
            p10.setBounds(690,200,260,25);
            p10.setFont(new Font("Ariel",Font.BOLD,22));
            p10.setOpaque(false);
            p10.setContentAreaFilled(false);
            p10.setBorderPainted(false);
            p10.setHorizontalAlignment(JButton.LEFT);
            p10.setForeground(Color.white);
            ge.add(p10);

            arr [10] = p11 = new JButton("    11. ₹12,50,000");
            p11.setBounds(690,170,260,25);
            p11.setFont(new Font("Ariel",Font.BOLD,22));
            p11.setOpaque(false);
            p11.setContentAreaFilled(false);
            p11.setBorderPainted(false);
            p11.setForeground(Color.white);
            p11.setHorizontalAlignment(JButton.LEFT);
            ge.add(p11);

            arr [11] = p12 = new JButton("    12. ₹25,00,000");
            p12.setBounds(690,140,260,25);
            p12.setFont(new Font("Ariel",Font.BOLD,22));
            p12.setOpaque(false);
            p12.setContentAreaFilled(false);
            p12.setBorderPainted(false);
            p12.setForeground(Color.white);
            p12.setHorizontalAlignment(JButton.LEFT);
            ge.add(p12);

            arr [12] = p13 = new JButton("    13. ₹50,00,000");
            p13.setBounds(690,110,260,25);
            p13.setFont(new Font("Ariel",Font.BOLD,22));
            p13.setOpaque(false);
            p13.setContentAreaFilled(false);
            p13.setBorderPainted(false);
            p13.setForeground(Color.white);
            p13.setHorizontalAlignment(JButton.LEFT);
            ge.add(p13);

            arr [13] = p14 = new JButton("    14. ₹ 1 Crore");
            p14.setBounds(690,80,260,25);
            p14.setFont(new Font("Ariel",Font.BOLD,22));
            p14.setOpaque(false);
            p14.setContentAreaFilled(false);
            p14.setBorderPainted(false);
            p14.setForeground(Color.white);
            p14.setHorizontalAlignment(JButton.LEFT);
            ge.add(p14);

            arr [14] = p15 = new JButton("    15. ₹ 7 Crore");
            p15.setBounds(690,50,260,30);
            p15.setFont(new Font("Ariel",Font.BOLD,22));
            p15.setOpaque(false);
            p15.setContentAreaFilled(false);
            p15.setBorderPainted(false);
            p15.setForeground(Color.white);
            p15.setHorizontalAlignment(JButton.LEFT);
            ge.add(p15);


            lf1 = new JButton("50 : 50");
            lf1.setBounds(30,80,210,70);
            lf1.setFont(new Font("Ariel",Font.BOLD,20));
            lf1.setForeground(Color.white);
            lf1.setBackground(new Color(0, 0, 139));
            lf1.setBorder(BorderFactory.createLineBorder(Color.orange,3,true));
            life.add(lf1);
            lf1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(ans.get(i).equals("A"))
                    {
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                    } else if (ans.get(i).equals("B")) {
                        b1.setEnabled(false);
                        b3.setEnabled(false);
                    }
                    else if (ans.get(i).equals("C")) {
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                    }
                    else if (ans.get(i).equals("D")) {
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                    }

                    lf1.setEnabled(false);
                    lf1.setBorder(null);
                }
            });


            lf2 = new JButton("Get Answer");
            lf2.setBounds(30,180,210,70);
            lf2.setFont(new Font("Ariel",Font.BOLD,20));
            lf2.setForeground(Color.white);
            lf2.setBackground(new Color(0, 0, 139));
            lf2.setBorder(BorderFactory.createLineBorder(Color.orange,3,true));
            life.add(lf2);
            lf2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(ans.get(i).equals("A"))
                    {
                        b2.setText(null);
                        b3.setText(null);
                        b4.setText(null);
                    } else if (ans.get(i).equals("B")) {
                        b1.setText(null);
                        b3.setText(null);
                        b4.setText(null);
                    }
                    else if (ans.get(i).equals("C")) {
                        b1.setText(null);
                        b2.setText(null);
                        b4.setText(null);
                    }
                    else if (ans.get(i).equals("D")) {
                        b2.setText(null);
                        b3.setText(null);
                        b1.setText(null);
                    }


                    lf2.setEnabled(false);
                    lf2.setBorder(null);
                }
            });


            lf3 = new JButton("Expert Opinion");
            lf3.setBounds(30,280,210,70);
            lf3.setFont(new Font("Ariel",Font.BOLD,20));
            lf3.setForeground(Color.white);
            lf3.setBackground(new Color(0, 0, 139));
            lf3.setBorder(BorderFactory.createLineBorder(Color.orange,3,true));
            life.add(lf3);
            lf3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(ans.get(i).equals("A"))
                    {
                        b1.setBackground(Color.orange);
                    } else if (ans.get(i).equals("B")) {
                       b2.setBackground(Color.orange);
                    }
                    else if (ans.get(i).equals("C")) {
                       b3.setBackground(Color.orange);
                    }
                    else if (ans.get(i).equals("D")) {
                        b4.setBackground(Color.orange);
                    }
                    lf3.setBorder(null);
                    lf3.setEnabled(false);
                }

            });


            lf4 = new JButton("Walk Away");
            lf4.setBounds(30,380,210,70);
            lf4.setFont(new Font("Ariel",Font.BOLD,20));
            lf4.setForeground(Color.white);
            lf4.setBackground(new Color(0, 0, 139));
            lf4.setBorder(BorderFactory.createLineBorder(Color.orange,3,true));
            life.add(lf4);
            lf4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    result2.setText("You Won           🥳 "+win[cnt-1]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    panr.setVisible(true);
                    pang.setVisible(false);
                    tc.stop();
                }
            });








            ActionListener tq = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    acd++;
                    bcd = (time - acd);

                    if (acd !=time) {
                        tc.setRepeats(true);
                        ct.setText(String.valueOf(bcd));
                        rcd =ct.getText();
                    }else{
                        tc.setRepeats(false);
                        tc.stop();
                        pang.setVisible(false);
                        panr.setVisible(true);
                        if((cnt-1)<5){
                            result2.setText("You Won           🥳 "+win[0]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                        } else if ((cnt-1)>=5 && (cnt-1)<8) {
                            result2.setText("You Won           🥳 "+win[5]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                        } else if ((cnt-1)>=8) {
                            result2.setText("You Won           🥳 "+win[8]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                        }

                    }

                }

            };
            tc = new Timer(1000, tq);























            setVisible(true);
            nextque();
        } catch (Exception e) {
            System.out.println(e);
        }



    }
    public void nextque(){
        if(i>=tot){
            pang.setVisible(false);
            panr.setVisible(true);
            result2.setText("You Won           🥳 "+win[15]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
        }else{
            if(i<5){
                time=45;
            } else if (i>=5 && i < 8) {
                time=90;
            } else if (i>=8) {
                tc.stop();
                ct.setVisible(false);
            }
            que.setText("Q."+(i+1)+". "+ questq.get(i).get(0));
            b1.setText(questq.get(i).get(1));
            b2.setText(questq.get(i).get(2));
            b3.setText(questq.get(i).get(3));
            b4.setText(questq.get(i).get(4));
            acd =0;
            arr[i].setBackground(Color.orange);
            arr[i].setForeground(Color.blue);
            arr[i].setOpaque(true);
            cnt++;


        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);


        if(e.getSource() == b1){
            answer="A";
            if (answer.equals(ans.get(i))){
                b1.setBackground(Color.GREEN);
            }
            else {
                b1.setBackground(Color.RED);
            }
        }
        if(e.getSource() == b2){
            answer="B";
            if (answer.equals(ans.get(i))){
                b2.setBackground(Color.GREEN);
            }
            else {
                b2.setBackground(Color.RED);
            }

        }
        if(e.getSource() == b3){
            answer="C";
            if (answer.equals(ans.get(i))){
                b3.setBackground(Color.GREEN);
            }
            else {
                b3.setBackground(Color.RED);
            }
        }
        if(e.getSource() == b4){
            answer="D";
            if (answer.equals(ans.get(i))){
                b4.setBackground(Color.GREEN);
            }
            else {
                b4.setBackground(Color.RED);
            }
        }
        Timer pause = new Timer(2000, new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(b1.getBackground()==Color.RED){
                    pang.setVisible(false);
                    panr.setVisible(true);
                    tc.stop();
                    if((cnt-1)<5){
                        result2.setText("You Won           🥳 "+win[0]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    } else if ((cnt-1)>=5 && (cnt-1)<8) {
                        result2.setText("You Won           🥳 "+win[5]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    } else if ((cnt-1)>=8) {
                        result2.setText("You Won           🥳 "+win[8]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    }
                } else if (b2.getBackground()==Color.RED) {
                    pang.setVisible(false);
                    panr.setVisible(true);
                    tc.stop();
                    if((cnt-1)<5){
                        result2.setText("You Won           🥳 "+win[0]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    } else if ((cnt-1)>=5 && (cnt-1)<8) {
                        result2.setText("You Won           🥳 "+win[5]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    } else if ((cnt-1)>=8) {
                        result2.setText("You Won           🥳 "+win[8]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    }
                }
                else if (b3.getBackground()==Color.RED) {
                    pang.setVisible(false);
                    panr.setVisible(true);
                    tc.stop();
                    if((cnt-1)<5){
                        result2.setText("You Won           🥳 "+win[0]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    } else if ((cnt-1)>=5 && (cnt-1)<8) {
                        result2.setText("You Won           🥳 "+win[5]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    } else if ((cnt-1)>=8) {
                        result2.setText("You Won           🥳 "+win[8]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    }
                }
                else if (b4.getBackground()==Color.RED) {
                    pang.setVisible(false);
                    panr.setVisible(true);
                    tc.stop();
                    if((cnt-1)<5){
                        result2.setText("You Won           🥳 "+win[0]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    } else if ((cnt-1)>=5 && (cnt-1)<8) {
                        result2.setText("You Won           🥳 "+win[5]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    } else if ((cnt-1)>=8) {
                        result2.setText("You Won           🥳 "+win[8]+"🥳 in prize money. Please Contact 📱 Mr.Amitabh Bachchan To collect your winnings. ✌️✌️");
                    }
                }

                b1.setBackground(new Color(0, 0, 139));
                b2.setBackground(new Color(0, 0, 139));
                b3.setBackground(new Color(0, 0, 139));
                b4.setBackground(new Color(0, 0, 139));
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);


                arr[i].setOpaque(false);
                arr[i].setBackground(null);
                arr[i].setForeground(Color.white);
                arr[i].setEnabled(false);
                arr[4].setEnabled(true);
                arr[4].setForeground(Color.green);
                arr[7].setEnabled(true);
                arr[7].setForeground(Color.green);



                i++;
                nextque();
            }

        });
        pause.setRepeats(false);
        pause.start();



    }}









class testqw {
    public static void main(String[] args)
    {

        Mframe111 frame = new Mframe111();


    }
}

