import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.lang.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



 class CreateSplashScreen extends JWindow {
   Image splashScreen;
   ImageIcon imageIcon;
    CreateSplashScreen() {
      splashScreen = Toolkit.getDefaultToolkit().getImage("C:/Users/91703/OneDrive/Desktop/OPPS CP/1.png");
      setLocation(500,200);
      setSize(485, 450);
      setVisible(true);
      
      try {
         Thread.sleep(3000);
         dispose();
      } catch(Exception e) {
         e.printStackTrace();
      };
   }

   
   
   
   public void paint(Graphics g) {
      super.paint(g);
      g.drawImage(splashScreen, 0, 0, this);
   }
  
 }




public class Main extends JFrame {
    // public static String s;
    
      

public static void main(String[] args)  {
    JFrame login;
    JButton predict;
    JButton about_us;
    // Image image;
    JPanel P1;
    JButton picLabel;
    Color title;
    title = new Color(204,204,204);
    Color background;
    background = new Color(51,51,51);
    Color button1;
    button1 = new Color(0,0,153);
    Color requirements;
    requirements = new Color(204,204,204);
 

    CreateSplashScreen splash = new CreateSplashScreen();

    login=new JFrame("HOUSE COST PREDICTION");
    predict=new JButton("Predict");
    P1=new JPanel();
    P1.setBackground(Color.black);
    about_us=new JButton("About US");
    Color bac;
    bac= new Color(51,51,51);
    P1.setBackground(bac);
    System.out.println(P1.getBackground());
        

    
    

          
        predict.addActionListener( new ActionListener( ) {
            public void actionPerformed( ActionEvent e )
            {
        try {
        
        
        

        JFrame frame1 = new JFrame("HOUSE COST PREDICTION");
        JComboBox T1;
        JComboBox T2;
        JTextField T3;
        JTextField T4;
        JTextField T5;
        JComboBox T6;
        JLabel J;
        JLabel J1;
        JLabel J2;
        JLabel J3;
        JLabel J4;
        JLabel J5;
        JLabel J6;
        JLabel J31;
        JPanel P;
        JButton button;
        P=new JPanel();
        



        String s1[] = {"Super built-up  Area", "Plot  Area", "Built-up  Area", "Carpet  Area"};
        String s2[] = {"1 BHK", "2 BHK", "3 BHK" ,"4 BHK","5 BHK","6 BHK"};
        String s6[] = {"Alandi Road", "Ambegaon Budruk", "Anandnagar", "Aundh", "Aundh Road", "Balaji Nagar", "Baner",
                "Baner road", "Bhandarkar Road", "Bhavani Peth", "Bibvewadi", "Bopodi", "Budhwar Peth", "Bund Garden Road",
                "Camp", "Chandan Nagar", "Dapodi", "Deccan Gymkhana", "Dehu Road", "Dhankawadi", "Dhayari Phata", "Dhole Patil Road"
                , "Erandwane", "Fatima Nagar", "Fergusson College Road", "Ganesh Peth", "Ganeshkhind", "Ghorpade Peth",
                "other", "Gokhale Nagar", "Gultekdi", "Guruwar peth", "Hadapsar", "Hadapsar Industrial Estate", "Hingne Khurd",
                "Jangali Maharaj Road", "Kalyani Nagar", "Karve Nagar", "Karve Road", "Kasba Peth", "Katraj", "Khadaki", "Khadki",
                "Kharadi", "Kondhwa", "Kondhwa Budruk", "Kondhwa Khurd", "Koregaon Park", "Kothrud", "Law College Road",
                "Laxmi Road", "Lulla Nagar", "Mahatma Gandhi Road", "Mangalwar peth", "Manik Bagh", "Market yard",
                "Model colony", "Mukund Nagar", "Mundhawa", "Nagar Road", "Nana Peth", "Narayan Peth", "Narayangaon", "Navi Peth",
                "Padmavati", "Parvati Darshan", "Pashan", "Paud Road", "Pirangut", "Prabhat Road", "Pune Railway Station",
                "Rasta Peth", "Raviwar Peth", "Sadashiv Peth", "Sahakar Nagar", "Salunke Vihar", "Sasson Road", "Satara Road",
                "Senapati Bapat Road", "Shaniwar Peth", "Shivaji Nagar", "Shukrawar Peth", "Sinhagad Road", "Somwar Peth",
                "Swargate", "Tilak Road", "Uruli Devachi", "Vadgaon Budruk", "Wadgaon Sheri", "Viman Nagar", "Vishrant Wadi",
                "Wagholi", "Wakadewadi", "Wanowrie", "Warje", "Yerawada", "Ghorpadi"};


        T1 = new JComboBox(s1);
        T2 = new JComboBox(s2);
        T3 = new JTextField();
        T4 = new JTextField();
        T5 = new JTextField();
        T6 = new JComboBox(s6);
        J = new JLabel("Enter the Requirements");
        
        J6 = new JLabel("Select City");
        J1 = new JLabel("Select Area Type");
        J2 = new JLabel("Select Layout");
        J3 = new JLabel("Enter Sq-ft");
        J31 = new JLabel("in sq-ft");
        J4 = new JLabel("Enter Number of Bathrooms");
        J5 = new JLabel("Enter Number of Balconies");
        button = new JButton("PREDICT");
        button.setForeground(Color.white);

        T3.setCaretColor(Color.white);
        T4.setCaretColor(Color.white);
        T5.setCaretColor(Color.white);

       

        T6.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {
                    @Override
                    protected JScrollPane createScroller() {
                        JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                            @Override
                            protected JButton createDecreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            protected JButton createIncreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            public Dimension getPreferredSize(JComponent c) {
                                return new Dimension(10, super.getPreferredSize(c).height);
                            }

                            private JButton createZeroButton() {
                                return new JButton() {
                                    @Override
                                    public Dimension getMinimumSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }

                                    @Override
                                    public Dimension getPreferredSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }

                                    @Override
                                    public Dimension getMaximumSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }
                                };
                            }
                        });
                        return scroller;
                    }
                };
            }
        });


        T1.setBounds(15, 60, 200, 35);
        T2.setBounds(260, 60, 200, 35);
        T3.setBounds(15, 160, 200, 35);
        T4.setBounds(260, 160, 200, 35);
        T5.setBounds(15, 260, 200, 35);
        T6.setBounds(340, 260, 200, 35);
        J.setBounds(10, 25, 582, 60);
        J1.setBounds(15, 20, 350,35);
        J2.setBounds(260, 20, 350,35);
        J3.setBounds(15, 120, 350,35);
        J31.setBounds(160, 170, 350, 35);
        J4.setBounds(260, 120, 350,35);
        J5.setBounds(15, 220, 350,35);
        J6.setBounds(340, 220, 450,35);
        button.setBounds(15, 320, 100, 50);
        button.setBackground(button1);

        T1.setBackground(Color.black);
        T2.setBackground(Color.black);
        T3.setBackground(Color.black);
        T4.setBackground(Color.black);
        T5.setBackground(Color.black);
        T6.setBackground(Color.black);

        T1.setForeground(Color.white);
        T2.setForeground(Color.white);
        T3.setForeground(Color.white);
        T4.setForeground(Color.white);
        T5.setForeground(Color.white);
        T6.setForeground(Color.white);





        J2.setFont(new Font("Calibri", Font.PLAIN, 25));
        J3.setFont(new Font("Calibri", Font.PLAIN, 25));
        J31.setFont(new Font("Calibri", Font.PLAIN, 25));
        J4.setFont(new Font("Calibri", Font.PLAIN, 25));
        J5.setFont(new Font("Calibri", Font.PLAIN, 25));
        J6.setFont(new Font("Calibri", Font.PLAIN, 25));
        J1.setFont(new Font("Calibri", Font.PLAIN, 25));

        

        J.setForeground(title);
        J1.setForeground(requirements);
        J2.setForeground(requirements);
        J3.setForeground(requirements);
        J31.setForeground(requirements);
        J4.setForeground(requirements);
        J5.setForeground(requirements);
        J6.setForeground(requirements);
        P.setBackground(background);
        P.add(T1);
        P.add(T2);
        P.add(T3);
        P.add(T4);
        P.add(T5);
        P.add(T6);
        P.add(J1);
        P.add(J2);
        P.add(J3);
        P.add(J4);
        P.add(J5);
        P.add(J6);
        P.add(button);
        P.setLayout(null);
        P.setVisible(true);
        P.setBounds(0,0,600,440);
        // P.setResizable(false);

       

        
    

        login.dispose();
        frame1.add(P);
        frame1.setSize(600, 440);
        frame1.setLocation(500,200);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setResizable(false);
        


        button.addActionListener( new ActionListener( ) {
            public void actionPerformed( ActionEvent e )
            {
                String Areatype = ((JTextField)T1.getEditor().getEditorComponent()).getText();
                String Size = ((JTextField)T2.getEditor().getEditorComponent()).getText();
                String Area = T3.getText();
                String NOBath = T4.getText();
                String NOBalcony = T5.getText();
                String City = ((JTextField)T6.getEditor().getEditorComponent()).getText();
                String result;

                Convert house = new Convert(Areatype, Size, Area, NOBath, NOBalcony, City);
                String var;
                try {
                    var = house.predict();
                    System.out.println("JAVA: "+var);
                double fvar=Double.parseDouble(var); 
                frame1.dispose();
                JFrame frame2;
                JPanel P2;
                frame2 = new JFrame();
                P2=new JPanel();
                Color Result1;
                Result1 = new Color(255,255,255);
                
                
                 
                JButton Result;
                JLabel JJ1;
                JLabel JJ2;
                JLabel JJ3;
                Result=new JButton();
                JJ1=new JLabel("Predicted cost ");
                JJ2=new JLabel("of the House ");
                JJ3=new JLabel("is");
                double cr = Math.round(fvar);
                double lac = Math.round(fvar*100);
                if(fvar/100 >=0){
                    Result = new JButton(cr/100+" crore");
                }
                else if(fvar/100 <0){
                    Result = new JButton(lac/100+" lacs");
                }
                
                JJ1.setBounds(80, 30, 500, 55);
                Result.setBackground(Result1);
                JJ2.setBounds(100, 85, 500, 55);
                JJ3.setBounds(226, 140, 500, 55);
                Result.setBounds(110, 195, 260, 55);
                Result.setForeground(Color.black);
                JJ1.setFont(new Font("Calibri", Font.PLAIN, 50));
                JJ2.setFont(new Font("Calibri", Font.PLAIN, 50));
                JJ3.setFont(new Font("Calibri", Font.PLAIN, 50));
                Result.setFont(new Font("Calibri", Font.PLAIN, 30));
                Result.setBackground(Color.black);
                JJ1.setForeground(Color.white);
                JJ2.setForeground(Color.white);
                JJ3.setForeground(Color.white);
                Result.setForeground(Color.white);
               
               
                
                P2.add(Result);
                P2.add(JJ1);
                P2.add(JJ2);
                P2.add(JJ3);
                P2.setBackground(bac);
                P2.setLayout(null);
                P2.setVisible(true);
                P2.setBounds(600,300,500, 300);
                
                frame2.setVisible(true);
                frame2.add(P2);
                frame2.setSize(500, 300);
                frame2.setLocation(600,300);

                frame2.setResizable(false);
                
                            } catch (IOException e1) {
                                // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                }
                
                
                

                

            
              
        }
        });
        }
        catch (Exception e1) {
                                // TODO Auto-generated catch block
                    e1.printStackTrace();
        }
                    
        }});

        about_us.addActionListener( new ActionListener( ) {
            public void actionPerformed( ActionEvent e )
            {
        try {
            login.dispose();
            JFrame frame3 = new JFrame("ABOUT US");
            JPanel P3=new JPanel();
            JLabel M1 = new JLabel("<html>This application helps you to find your perfect home.<br/> Our mission is to help people of the working class to get a starting point for their everlasting asset.<br/></br>If you are looking to better and contribute to our services, we are happy to hear from you.you can do so by connecting via our email : haider.hirkani21@vit.edu</html>");
            M1.setFont(new Font("Calibri", Font.ITALIC, 27));

        M1.setBounds(40, 10, 550,350);
        
        M1.setForeground(Color.white);
        
        P3.add(M1);
       

            
        
        
            P3.setBackground(bac);
            P3.setLayout(null);
            P3.setVisible(true);
            P3.setBounds(500,200,600, 440);
            
            frame3.setVisible(true);
            frame3.add(P3);
            frame3.setSize(600, 440);
            frame3.setLocation(500,200);
            frame3.setResizable(false);
        }

        catch(Exception e1){

        }
    }});
          
       
       



    


    

    


    predict.setBounds(130, 70, 300, 100);
    about_us.setBounds(130, 220, 300, 100);

    predict.setFont(new Font("Calibri", Font.PLAIN, 50));
    about_us.setFont(new Font("Calibri", Font.PLAIN, 50));

    predict.setBackground(Color.black);
    about_us.setBackground(Color.black);
    

    predict.setForeground(requirements);
    about_us.setForeground(requirements);

    


        P1.add(predict);
        P1.add(about_us);
        

        P1.setBounds(0,0,600,440);
        P1.setLayout(null);
        P1.setVisible(true);
        login.add(P1);
        login.setSize(600, 440);
        login.setLocation(500,200);
        login.setLayout(null);
        login.setVisible(true);
        login.setResizable(false);
}
}
        
        




          



    

