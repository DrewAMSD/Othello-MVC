/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvc.othello;
import com.mrjaffesclass.apcs.messenger.*;
import javax.swing.JButton;
/**
 *
 * @author student
 */
public class View extends javax.swing.JFrame implements MessageHandler {

  private final Messenger mvcMessaging;
  private javax.swing.JButton[][] board;
  
  /**
   * Creates a new view
   * @param messages mvcMessaging object
   */
  public View(Messenger messages) {
    this.mvcMessaging = messages;   // Save the calling controller instance
    initComponents();           // Create and init the GUI components
    
    this.board = new javax.swing.JButton[8][8];
    this.board[0] = new javax.swing.JButton[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8};
    this.board[1] = new javax.swing.JButton[] {jButton9, jButton10, jButton11, jButton12, jButton13, jButton14, jButton15, jButton16};
    this.board[2] = new javax.swing.JButton[] {jButton17, jButton18, jButton19, jButton20, jButton21, jButton22, jButton23, jButton24};
    this.board[3] = new javax.swing.JButton[] {jButton25, jButton26, jButton27, jButton28, jButton29, jButton30, jButton31, jButton32};
    this.board[4] = new javax.swing.JButton[] {jButton33, jButton34, jButton35, jButton36, jButton37, jButton38, jButton39, jButton40};
    this.board[5] = new javax.swing.JButton[] {jButton41, jButton42, jButton43, jButton44, jButton45, jButton46, jButton47, jButton48};
    this.board[6] = new javax.swing.JButton[] {jButton49, jButton50, jButton51, jButton52, jButton53, jButton54, jButton55, jButton56};
    this.board[7] = new javax.swing.JButton[] {jButton57, jButton58, jButton59, jButton60, jButton61, jButton62, jButton63, jButton64};
  }
  
   /**
   * Initialize the model here and subscribe
   * to any required messages
   */
  public void init() {
    // Subscribe to messages here

    newGame();
  }
  
  private void newGame() {
     //add icons and names to buttons
    for (int row = 0; row < Constants.BOARD_SIZE; row++) {
        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            board[row][col].setIcon(Constants.EMPTY_ICON);
            board[row][col].setName(""+row+col+"");
        }
    }
    //starting with white and black space
    jButton28.setIcon(Constants.WHITE_ICON);
    jButton29.setIcon(Constants.BLACK_ICON);
    //
    //starting with white and black space
    jButton36.setIcon(Constants.BLACK_ICON);
    jButton37.setIcon(Constants.WHITE_ICON);
    //
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
