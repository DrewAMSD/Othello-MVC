/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvc.othello;
import com.mrjaffesclass.apcs.messenger.*;
import javax.swing.JButton;
import java.util.ArrayList;
/**
 *
 * @author student
 */
public class View extends javax.swing.JFrame implements MessageHandler {

  private final Messenger mvcMessaging;
  private javax.swing.JButton[][] panel;

  /**
   * Creates a new view
   * @param messages mvcMessaging object
   */
  public View(Messenger messages) {
    this.mvcMessaging = messages;   // Save the calling controller instance
    initComponents();           // Create and init the GUI components
    
    this.panel = new javax.swing.JButton[8][8];
    this.panel[0] = new javax.swing.JButton[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8};
    this.panel[1] = new javax.swing.JButton[] {jButton9, jButton10, jButton11, jButton12, jButton13, jButton14, jButton15, jButton16};
    this.panel[2] = new javax.swing.JButton[] {jButton17, jButton18, jButton19, jButton20, jButton21, jButton22, jButton23, jButton24};
    this.panel[3] = new javax.swing.JButton[] {jButton25, jButton26, jButton27, jButton28, jButton29, jButton30, jButton31, jButton32};
    this.panel[4] = new javax.swing.JButton[] {jButton33, jButton34, jButton35, jButton36, jButton37, jButton38, jButton39, jButton40};
    this.panel[5] = new javax.swing.JButton[] {jButton41, jButton42, jButton43, jButton44, jButton45, jButton46, jButton47, jButton48};
    this.panel[6] = new javax.swing.JButton[] {jButton49, jButton50, jButton51, jButton52, jButton53, jButton54, jButton55, jButton56};
    this.panel[7] = new javax.swing.JButton[] {jButton57, jButton58, jButton59, jButton60, jButton61, jButton62, jButton63, jButton64};
    
    //add event listeners
    for (int row = 4; row < Constants.BOARD_SIZE; row++) {
        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            this.panel[row][col].addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnClicked(evt);
                        }
                    });
        }
    }
    
     this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     this.setLocationRelativeTo(null);
     this.setTitle("Othello");
  }
  
   /**
   * Initialize the model here and subscribe
   * to any required messages
   */
  public void init() {
    // Subscribe to messages here
    this.mvcMessaging.subscribe("model:newGame", this);
    this.mvcMessaging.subscribe("model:boardChanged", this);
    this.mvcMessaging.subscribe("model:legalMovesChanged", this);
    this.mvcMessaging.subscribe("model:piecesChanged", this);
    this.mvcMessaging.subscribe("model:moveChanged", this);
    this.mvcMessaging.subscribe("model:gameOver", this);
    //ai
    this.mvcMessaging.subscribe("model:playingAiChanged", this);
    this.mvcMessaging.subscribe(("model:aiColorChanged"), this);
    this.mvcMessaging.subscribe("model:aiDifficultyChanged", this);
    
     //add icons and names to buttons
    for (int row = 0; row < Constants.BOARD_SIZE; row++) {
        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            this.panel[row][col].setName(""+row+col+"");
        }
    }
    easyBtn.setName(Constants.AI_EASY);
    mediumBtn.setName(Constants.AI_MEDIUM);
    hardBtn.setName(Constants.AI_HARD);
    extremeBtn.setName(Constants.AI_EXTREME);
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("MSG: received by view: "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("MSG: received by view: "+messageName+" | No data sent");
    }
    
    switch (messageName) {
        case "model:boardChanged": {
            int[][] board = (int[][]) messagePayload;
            for (int row = 0; row < Constants.BOARD_SIZE; row++) {
                for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                    switch (board[row][col]) {
                        case Constants.EMPTY: 
                            panel[row][col].setIcon(Constants.EMPTY_ICON);
                            break;
                        case Constants.BLACK:
                            panel[row][col].setIcon(Constants.BLACK_ICON);
                            break;
                        case Constants.WHITE:
                            panel[row][col].setIcon(Constants.WHITE_ICON);
                            break;
                        default:
                            break;
                    }
                }
            }
            
            break;
        }
        
        case "model:legalMovesChanged": {
            ArrayList<Coordinate> legalMoves = (ArrayList<Coordinate>) messagePayload;
            for (Coordinate move : legalMoves) {
                panel[move.getRow()][move.getCol()].setIcon(Constants.LEGAL_MOVE_ICON);
            }
            
            break;
        }
        
        case "model:piecesChanged": {
            Coordinate pieces = (Coordinate) messagePayload;
            blackPiecesNumberLbl.setText(""+pieces.getRow());
            whitePiecesNumberLbl.setText(""+pieces.getCol());
            
            break;
        }
        
        case "model:moveChanged": {
            int whoseMove = (int) messagePayload;
            String player = (whoseMove == Constants.BLACK ? "Black" : "White");
            moveLbl.setText(player+" To Move");
            
            break;
        }
        
        case "model:gameOver": {
            int gameStatus = (int) messagePayload;
            if (gameStatus == Constants.DRAW) {
                moveLbl.setText("Draw!!");
            } else {
                String player = (gameStatus == Constants.BLACK_WINS ? "Black" : "White");
                moveLbl.setText(player+" Wins!!");
            }
            
            break;
        }
        
        case "model:playingAiChanged": {
            boolean playingAI = (boolean) messagePayload;
            if (playingAI) {
                opponentLbl.setText("Playing AI");
            } else {
                opponentLbl.setText("Playing Player");
            }
            
            break;
        }

        case "model:aiColorChanged": {
            int aiColor = (int) messagePayload;
            if (aiColor == Constants.BLACK) {
                aiColorLbl.setText("AI Color: Black");
            } else {
                aiColorLbl.setText("AI Color: White");
            }
            
            break;
        }
        
        case "model:aiDifficultyChanged": {
            String difficulty = (String) messagePayload;
            aiDifficultyLbl.setText(difficulty);
            
            break;
        }
        
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

        newGameBtn = new javax.swing.JButton();
        moveLbl = new javax.swing.JLabel();
        blackPiecesLbl = new javax.swing.JLabel();
        whitePiecesLbl = new javax.swing.JLabel();
        blackPiecesNumberLbl = new javax.swing.JLabel();
        whitePiecesNumberLbl = new javax.swing.JLabel();
        aiLbl = new javax.swing.JLabel();
        switchPlayerBtn = new javax.swing.JButton();
        opponentLbl = new javax.swing.JLabel();
        aiColorLbl = new javax.swing.JLabel();
        switchAiColorBtn = new javax.swing.JButton();
        aiDifficultyTitleLbl = new javax.swing.JLabel();
        aiDifficultyLbl = new javax.swing.JLabel();
        easyBtn = new javax.swing.JButton();
        mediumBtn = new javax.swing.JButton();
        hardBtn = new javax.swing.JButton();
        extremeBtn = new javax.swing.JButton();
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
        setMaximumSize(new java.awt.Dimension(800, 780));
        setMinimumSize(new java.awt.Dimension(800, 780));
        setResizable(false);

        newGameBtn.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        newGameBtn.setText("New Game");
        newGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameBtnClicked(evt);
            }
        });

        moveLbl.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        moveLbl.setText("Black To Move");

        blackPiecesLbl.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        blackPiecesLbl.setText("Black Pieces:");

        whitePiecesLbl.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        whitePiecesLbl.setText("White Pieces:");

        aiLbl.setFont(new java.awt.Font("Fira Sans", 0, 48)); // NOI18N
        aiLbl.setText("AI:");

        switchPlayerBtn.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        switchPlayerBtn.setText("Switch");
        switchPlayerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchPlayerBtnActionPerformed(evt);
            }
        });

        opponentLbl.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        opponentLbl.setText("Playing Player");

        aiColorLbl.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        aiColorLbl.setText("AI Color: White");

        switchAiColorBtn.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        switchAiColorBtn.setText("Switch");
        switchAiColorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchAiColorBtnActionPerformed(evt);
            }
        });

        aiDifficultyTitleLbl.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        aiDifficultyTitleLbl.setText("AI Difficulty:");

        aiDifficultyLbl.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        aiDifficultyLbl.setText("Easy");

        easyBtn.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        easyBtn.setText("Easy");
        easyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffcultyBtnClicked(evt);
            }
        });

        mediumBtn.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        mediumBtn.setText("Medium");
        mediumBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffcultyBtnClicked(evt);
            }
        });

        hardBtn.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        hardBtn.setText("Hard");
        hardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffcultyBtnClicked(evt);
            }
        });

        extremeBtn.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        extremeBtn.setText("Extreme");
        extremeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffcultyBtnClicked(evt);
            }
        });

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

        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton17);

        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton18);

        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton19);

        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton20);

        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton21);

        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton22);

        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton23);

        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton24);

        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton25);

        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton26);

        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton27);

        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton28);

        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton29);

        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton30);

        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
        jPanel1.add(jButton31);

        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClicked(evt);
            }
        });
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(moveLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(blackPiecesLbl)
                                .addGap(18, 18, 18)
                                .addComponent(blackPiecesNumberLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(whitePiecesLbl)
                                .addGap(18, 18, 18)
                                .addComponent(whitePiecesNumberLbl)))
                        .addGap(130, 130, 130)
                        .addComponent(newGameBtn)
                        .addGap(9, 9, 9))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aiLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aiColorLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(switchAiColorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(opponentLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                        .addComponent(switchPlayerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(easyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(aiDifficultyTitleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(mediumBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(hardBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(extremeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(aiDifficultyLbl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(aiLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(blackPiecesLbl)
                                    .addComponent(blackPiecesNumberLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(whitePiecesLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(whitePiecesNumberLbl))
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(newGameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(moveLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opponentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(switchPlayerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(aiColorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(switchAiColorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(aiDifficultyTitleLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aiDifficultyLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(easyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mediumBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(extremeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameBtnClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameBtnClicked
        // TODO add your handling code here:
        this.mvcMessaging.notify("view:newGame", "");
    }//GEN-LAST:event_newGameBtnClicked

    private void switchPlayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchPlayerBtnActionPerformed
        // TODO add your handling code here
        this.mvcMessaging.notify("view:switchPlayer", "");
    }//GEN-LAST:event_switchPlayerBtnActionPerformed

    private void switchAiColorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchAiColorBtnActionPerformed
        // TODO add your handling code here:
        this.mvcMessaging.notify("view:switchAiColor", "");
    }//GEN-LAST:event_switchAiColorBtnActionPerformed

    private void diffcultyBtnClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diffcultyBtnClicked
        // TODO add your handling code here:
        JButton button = (JButton)evt.getSource();
        String btnName = button.getName();
        this.mvcMessaging.notify("view:difficultyBtnClicked", btnName);
    }//GEN-LAST:event_diffcultyBtnClicked
    
    private void btnClicked(java.awt.event.ActionEvent evt) {
        JButton button = (JButton)evt.getSource();
        String btnName = button.getName();
        int row = Integer.parseInt(btnName.substring(0,1));
        int col = Integer.parseInt(btnName.substring(1,2));
        Coordinate coordinate = new Coordinate(row, col);
        this.mvcMessaging.notify("view:btnClicked", coordinate);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aiColorLbl;
    private javax.swing.JLabel aiDifficultyLbl;
    private javax.swing.JLabel aiDifficultyTitleLbl;
    private javax.swing.JLabel aiLbl;
    private javax.swing.JLabel blackPiecesLbl;
    private javax.swing.JLabel blackPiecesNumberLbl;
    private javax.swing.JButton easyBtn;
    private javax.swing.JButton extremeBtn;
    private javax.swing.JButton hardBtn;
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
    private javax.swing.JButton mediumBtn;
    private javax.swing.JLabel moveLbl;
    private javax.swing.JButton newGameBtn;
    private javax.swing.JLabel opponentLbl;
    private javax.swing.JButton switchAiColorBtn;
    private javax.swing.JButton switchPlayerBtn;
    private javax.swing.JLabel whitePiecesLbl;
    private javax.swing.JLabel whitePiecesNumberLbl;
    // End of variables declaration//GEN-END:variables
}
