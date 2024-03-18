/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvc.othello;
import com.mrjaffesclass.apcs.messenger.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Image;
/**
 *
 * @author student
 */
public class View extends javax.swing.JFrame implements MessageHandler {

  private final Messenger mvcMessaging;
  
  /**
   * Creates a new view
   * @param messages mvcMessaging object
   */
  public View(Messenger messages) {
    this.mvcMessaging = messages;   // Save the calling controller instance
    initComponents();           // Create and init the GUI components
  }
  
   /**
   * Initialize the model here and subscribe
   * to any required messages
   */
  public void init() {
    // Subscribe to messages here

    //add icons to images
    jButton1.setIcon(Constants.EMPTY_ICON);
    jButton2.setIcon(Constants.EMPTY_ICON);
    jButton3.setIcon(Constants.EMPTY_ICON);
    jButton4.setIcon(Constants.EMPTY_ICON);
    jButton5.setIcon(Constants.EMPTY_ICON);
    jButton6.setIcon(Constants.EMPTY_ICON);
    jButton7.setIcon(Constants.EMPTY_ICON);
    jButton8.setIcon(Constants.EMPTY_ICON);
    jButton9.setIcon(Constants.EMPTY_ICON);
    jButton10.setIcon(Constants.EMPTY_ICON);
    jButton11.setIcon(Constants.EMPTY_ICON);
    jButton12.setIcon(Constants.EMPTY_ICON);
    jButton13.setIcon(Constants.EMPTY_ICON);
    jButton14.setIcon(Constants.EMPTY_ICON);
    jButton15.setIcon(Constants.EMPTY_ICON);
    jButton16.setIcon(Constants.EMPTY_ICON);
    jButton17.setIcon(Constants.EMPTY_ICON);
    jButton18.setIcon(Constants.EMPTY_ICON);
    jButton19.setIcon(Constants.EMPTY_ICON);
    jButton20.setIcon(Constants.EMPTY_ICON);
    jButton21.setIcon(Constants.EMPTY_ICON);
    jButton22.setIcon(Constants.EMPTY_ICON);
    jButton23.setIcon(Constants.EMPTY_ICON);
    jButton24.setIcon(Constants.EMPTY_ICON);
    jButton25.setIcon(Constants.EMPTY_ICON);
    jButton26.setIcon(Constants.EMPTY_ICON);
    jButton27.setIcon(Constants.EMPTY_ICON);
    //starting with white and black space
    jButton28.setIcon(Constants.WHITE_ICON);
    jButton29.setIcon(Constants.BLACK_ICON);
    //
    jButton30.setIcon(Constants.EMPTY_ICON);
    jButton31.setIcon(Constants.EMPTY_ICON);
    jButton32.setIcon(Constants.EMPTY_ICON);
    jButton33.setIcon(Constants.EMPTY_ICON);
    jButton34.setIcon(Constants.EMPTY_ICON);
    jButton35.setIcon(Constants.EMPTY_ICON);
    //starting with white and black space
    jButton36.setIcon(Constants.BLACK_ICON);
    jButton37.setIcon(Constants.WHITE_ICON);
    //
    jButton38.setIcon(Constants.EMPTY_ICON);
    jButton39.setIcon(Constants.EMPTY_ICON);
    jButton40.setIcon(Constants.EMPTY_ICON);
    jButton41.setIcon(Constants.EMPTY_ICON);
    jButton42.setIcon(Constants.EMPTY_ICON);
    jButton43.setIcon(Constants.EMPTY_ICON);
    jButton44.setIcon(Constants.EMPTY_ICON);
    jButton45.setIcon(Constants.EMPTY_ICON);
    jButton46.setIcon(Constants.EMPTY_ICON);
    jButton47.setIcon(Constants.EMPTY_ICON);
    jButton48.setIcon(Constants.EMPTY_ICON);
    jButton49.setIcon(Constants.EMPTY_ICON);
    jButton50.setIcon(Constants.EMPTY_ICON);
    jButton51.setIcon(Constants.EMPTY_ICON);
    jButton52.setIcon(Constants.EMPTY_ICON);
    jButton53.setIcon(Constants.EMPTY_ICON);
    jButton54.setIcon(Constants.EMPTY_ICON);
    jButton55.setIcon(Constants.EMPTY_ICON);
    jButton56.setIcon(Constants.EMPTY_ICON);
    jButton57.setIcon(Constants.EMPTY_ICON);
    jButton58.setIcon(Constants.EMPTY_ICON);
    jButton59.setIcon(Constants.EMPTY_ICON);
    jButton60.setIcon(Constants.EMPTY_ICON);
    jButton61.setIcon(Constants.EMPTY_ICON);
    jButton62.setIcon(Constants.EMPTY_ICON);
    jButton63.setIcon(Constants.EMPTY_ICON);
    jButton64.setIcon(Constants.EMPTY_ICON);
    
    //give each button a name
    jButton1.setName("1");
    jButton2.setName("2");
    jButton3.setName("3");
    jButton4.setName("4");
    jButton5.setName("5");
    jButton6.setName("6");
    jButton7.setName("7");
    jButton8.setName("8");
    jButton9.setName("9");
    jButton10.setName("10");
    jButton11.setName("11");
    jButton12.setName("12");
    jButton13.setName("13");
    jButton14.setName("14");
    jButton15.setName("15");
    jButton16.setName("16");
    jButton17.setName("17");
    jButton18.setName("18");
    jButton19.setName("19");
    jButton20.setName("20");
    jButton21.setName("21");
    jButton22.setName("22");
    jButton23.setName("23");
    jButton24.setName("24");
    jButton25.setName("25");
    jButton26.setName("26");
    jButton27.setName("27");
    jButton28.setName("28");
    jButton29.setName("29");
    jButton30.setName("30");
    jButton31.setName("31");
    jButton32.setName("32");
    jButton33.setName("33");
    jButton34.setName("34");
    jButton35.setName("35");
    jButton36.setName("36");
    jButton37.setName("37");
    jButton38.setName("38");
    jButton39.setName("39");
    jButton40.setName("40");
    jButton41.setName("41");
    jButton42.setName("42");
    jButton43.setName("43");
    jButton44.setName("44");
    jButton45.setName("45");
    jButton46.setName("46");
    jButton47.setName("47");
    jButton48.setName("48");
    jButton49.setName("49");
    jButton50.setName("50");
    jButton51.setName("51");
    jButton52.setName("52");
    jButton53.setName("53");
    jButton54.setName("54");
    jButton55.setName("55");
    jButton56.setName("56");
    jButton57.setName("57");
    jButton58.setName("58");
    jButton59.setName("59");
    jButton60.setName("60");
    jButton61.setName("61");
    jButton62.setName("62");
    jButton63.setName("63");
    jButton64.setName("64");
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("MSG: received by view: "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("MSG: received by view: "+messageName+" | No data sent");
    }
    
    switch (messageName) {
        
        default: {
            break;
        }
    }
  }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(660, 740));
        setMinimumSize(new java.awt.Dimension(660, 740));
        setPreferredSize(new java.awt.Dimension(660, 740));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(640, 640));
        jPanel1.setMinimumSize(new java.awt.Dimension(640, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 640));
        jPanel1.setLayout(new java.awt.GridLayout(8, 8));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton5);

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton6);

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton7);

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton8);

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton9);

        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton10);

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton11);

        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton12);

        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton13);

        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton14);

        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton15);

        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton16);
        jPanel1.add(jButton17);
        jPanel1.add(jButton18);
        jPanel1.add(jButton19);
        jPanel1.add(jButton20);
        jPanel1.add(jButton21);
        jPanel1.add(jButton22);

        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton23);
        jPanel1.add(jButton24);
        jPanel1.add(jButton25);
        jPanel1.add(jButton26);
        jPanel1.add(jButton27);
        jPanel1.add(jButton28);
        jPanel1.add(jButton29);
        jPanel1.add(jButton30);
        jPanel1.add(jButton31);
        jPanel1.add(jButton32);
        jPanel1.add(jButton33);
        jPanel1.add(jButton34);
        jPanel1.add(jButton35);
        jPanel1.add(jButton36);
        jPanel1.add(jButton37);
        jPanel1.add(jButton38);
        jPanel1.add(jButton39);
        jPanel1.add(jButton40);
        jPanel1.add(jButton41);
        jPanel1.add(jButton42);
        jPanel1.add(jButton43);
        jPanel1.add(jButton44);
        jPanel1.add(jButton45);
        jPanel1.add(jButton46);
        jPanel1.add(jButton47);
        jPanel1.add(jButton48);
        jPanel1.add(jButton49);
        jPanel1.add(jButton50);
        jPanel1.add(jButton51);
        jPanel1.add(jButton52);
        jPanel1.add(jButton53);
        jPanel1.add(jButton54);
        jPanel1.add(jButton55);
        jPanel1.add(jButton56);
        jPanel1.add(jButton57);
        jPanel1.add(jButton58);
        jPanel1.add(jButton59);
        jPanel1.add(jButton60);
        jPanel1.add(jButton61);
        jPanel1.add(jButton62);
        jPanel1.add(jButton63);
        jPanel1.add(jButton64);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClicked
        // TODO add your handling code here:
        JButton button = (JButton)evt.getSource();
        //get location of button
        this.mvcMessaging.notify("btnClicked", button.getName());
    }//GEN-LAST:event_btnClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
