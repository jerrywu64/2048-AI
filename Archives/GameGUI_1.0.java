import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javax.swing.*; 

public class GameGUI extends javax.swing.JFrame {
    private static int[][] board = new int[4][4];
	private static PrintWriter out;
    private static int currentScore = 0;
    private int highScore = updateHigh();
    private static boolean ai = false;
	public static int WIN_TARGET = 2048;
	public static int sleeptime = 30;
	public static boolean airunning = false;
    public GameGUI() {
        initComponents();
        updateText();
        jFrame1.setVisible(false);
        updateColors();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        jFrame1.setAlwaysOnTop(true);
        jFrame1.setMinimumSize(new java.awt.Dimension(405, 523));
        jFrame1.setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Arial", 1, 50)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("You win!");

        jPanel2.setBackground(new java.awt.Color(143, 122, 102));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Try again");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setBackground(new java.awt.Color(252, 248, 239));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(117, 102, 83));
        jTextField1.setText("Enter your name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(154, 154, 154))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("2048 in Java by Aditya Chopra");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(null);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(204, 192, 179));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel7.setToolTipText("");
        jPanel7.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(119, 110, 101));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("" + board[0][0]);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 192, 179));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel8.setToolTipText("");
        jPanel8.setMaximumSize(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(119, 110, 101));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("" + board[0][1]);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(204, 192, 179));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel9.setToolTipText("");
        jPanel9.setMaximumSize(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(119, 110, 101));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("" + board[0][2]);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(204, 192, 179));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel10.setToolTipText("");
        jPanel10.setMaximumSize(null);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(119, 110, 101));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("" + board[0][3]);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(204, 192, 179));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel17.setToolTipText("");
        jPanel17.setMaximumSize(null);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(119, 110, 101));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("" + board[1][0]);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(204, 192, 179));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel18.setToolTipText("");
        jPanel18.setMaximumSize(null);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(119, 110, 101));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("" + board[1][1]);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(204, 192, 179));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel19.setToolTipText("");
        jPanel19.setMaximumSize(null);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(119, 110, 101));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("" + board[1][2]);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(204, 192, 179));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel20.setToolTipText("");
        jPanel20.setMaximumSize(null);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(119, 110, 101));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("" + board[1][3]);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(204, 192, 179));
        jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel31.setToolTipText("");
        jPanel31.setMaximumSize(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(119, 110, 101));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("" + board[2][0]);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(204, 192, 179));
        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel32.setToolTipText("");
        jPanel32.setMaximumSize(null);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(119, 110, 101));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("" + board[2][1]);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(204, 192, 179));
        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel33.setToolTipText("");
        jPanel33.setMaximumSize(null);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(119, 110, 101));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("" + board[2][2]);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel34.setBackground(new java.awt.Color(204, 192, 179));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel34.setToolTipText("");
        jPanel34.setMaximumSize(null);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(119, 110, 101));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("" + board[2][3]);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.setBackground(new java.awt.Color(204, 192, 179));
        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel35.setToolTipText("");
        jPanel35.setMaximumSize(null);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(119, 110, 101));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("" + board[3][0]);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel36.setBackground(new java.awt.Color(204, 192, 179));
        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel36.setToolTipText("");
        jPanel36.setMaximumSize(null);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(119, 110, 101));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("" + board[3][1]);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(204, 192, 179));
        jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel37.setToolTipText("");
        jPanel37.setMaximumSize(null);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(119, 110, 101));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("" + board[3][2]);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel38.setBackground(new java.awt.Color(204, 192, 179));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160), 5));
        jPanel38.setToolTipText("");
        jPanel38.setMaximumSize(null);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 31)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(119, 110, 101));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("" + board[3][3]);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(197, 173, 160));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 173, 160), 5, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(120, 61));
        jPanel3.setMinimumSize(new java.awt.Dimension(120, 61));
        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(120, 61));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Score: " + currentScore);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(238, 228, 218));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("SCORE");
        jLabel19.setMaximumSize(new java.awt.Dimension(50, 17));
        jLabel19.setMinimumSize(new java.awt.Dimension(50, 17));
        jLabel19.setPreferredSize(new java.awt.Dimension(50, 17));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(197, 173, 160));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 173, 160), 5, true));
        jPanel4.setMaximumSize(new java.awt.Dimension(120, 61));
        jPanel4.setMinimumSize(new java.awt.Dimension(120, 61));
        jPanel4.setPreferredSize(new java.awt.Dimension(120, 61));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Best: " + highScore);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(238, 228, 218));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("BEST");
        jLabel20.setMaximumSize(new java.awt.Dimension(37, 17));
        jLabel20.setMinimumSize(new java.awt.Dimension(37, 17));
        jLabel20.setName(""); // NOI18N
        jLabel20.setPreferredSize(new java.awt.Dimension(37, 17));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jLabel21.setFont(new java.awt.Font("Arial", 1, 60)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(119, 110, 101));
        jLabel21.setText("2048");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(119, 110, 101));
        jLabel22.setText("Join the numbers and get to the ");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(119, 110, 101));
        jLabel23.setText("2048 tile!");

        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jCheckBox1.setText("AI?");
        jCheckBox1.setFocusable(false);
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        ai();
        int id = evt.getKeyCode();
        updateBoard(id);
        if (currentScore > highScore) {
            highScore = currentScore;
        }
        updateText();
        if (checkWin()) {
            jFrame1.setVisible(true);
        }
        if (checkLoss()) {
            jLabel24.setText("Game over!");
            jLabel24.setForeground(new java.awt.Color(119, 110, 101));
            jPanel1.setBackground(new java.awt.Color(238, 228, 218));
            jFrame1.setVisible(true);
        }
        updateColors();
    }//GEN-LAST:event_formKeyPressed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        File f = new File("scores.txt");
        ArrayList<String[]> lines = new ArrayList<>();
        if(f.exists() && !f.isDirectory()) { 
            try {
                Scanner input = new Scanner(new File("scores.txt"));
                while (input.hasNextLine()) {
                    lines.add(input.nextLine().split(": "));
                }
                for (String[] line: lines) {
                    line[0] += ": ";
                    line[2] = ": " + line[2];
                }
                String[] now = {jTextField1.getText() + ": ", "" + currentScore, ": " + highestTile()};
                lines.add(now);
                Comparator<String[]> custom = new Comparator<String[]>() {
                    public int compare(String[] a1, String[] a2) {
                        return Integer.parseInt(a2[1]) - Integer.parseInt(a1[1]);
                    }
                };
                Collections.sort(lines, custom);
            } catch (IOException ex) {
                System.out.println("This should only happen once in the beginning.");
            }
        }
        else {
            String[] now = {jTextField1.getText() + ": ", "" + currentScore, ": " + highestTile()};
            lines.add(now);
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("scores.txt", "UTF-8");
            for (String[] s: lines) {
                for (String s1: s) {
                    writer.print(s1);
                }
                writer.println();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("This should never happen.");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("This probably should never happen.");
        } finally {
            writer.close();
        }
        restart();
        updateText();
        updateColors();
        jTextField1.setText("Enter your name");
        jFrame1.setVisible(false);
        updateHigh();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        if (jCheckBox1.isSelected()) ai = true;
        else ai = false;
        System.out.println(ai);
    }//GEN-LAST:event_jCheckBox1StateChanged
    private void updateBoard(int n) {
        int[][] before = new int[4][4];
            System.arraycopy(board, 0, before, 0, board.length);
            if (n == KeyEvent.VK_LEFT) {
                pushLeft();
                //check tiles with x > 0, from left to right to see if they collapse
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j < 4; j++) {
                        if (board[i][j-1] == board[i][j]) {
                            board[i][j-1] *= 2;
                            currentScore += board[i][j-1];
                            board[i][j] = 0; //temporarily leave a 0 which will go away when we push again
                        }
                    }
                }
                pushLeft();
                //add a random 2/4 in a random empty tile ONLY IF BOARD HAS CHANGED
                if (!Arrays.deepEquals(before, board)) {
                    ArrayList<int[]> a = new ArrayList<int[]>();
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (board[i][j] == 0) {
                                int[] coords = {i, j};
                                a.add(coords);
                            }
                        }
                    }
                    Collections.shuffle(a);
                    board[a.get(0)[0]][a.get(0)[1]] = ((int) (Math.random() * 2) + 1) * 2;
                }
            }
            else if (n == KeyEvent.VK_UP) {
                rotateCCW();
                updateBoard(KeyEvent.VK_LEFT);
                rotateCW();
            }
            else if (n == KeyEvent.VK_RIGHT) {
                rotateCCW();
                rotateCCW();
                updateBoard(KeyEvent.VK_LEFT);
                rotateCW();
                rotateCW();
            }
            else if (n == KeyEvent.VK_DOWN) {
                rotateCW();
                updateBoard(KeyEvent.VK_LEFT);
                rotateCCW();
            }
    }
    private void pushLeft() {
            //move tiles with values as far left as possible
            for (int i = 0; i < 4; i++) {
                    int[] row = new int[4];
                    for (int j = 0; j < 4; j++) {
                            if (board[i][j] != 0) {
                                    int curr = 0;
                                    while(row[curr] != 0) {
                                            curr++;
                                    }
                                    row[curr] = board[i][j];
                            }
                    }
                    board[i] = row;
            }
    }
    private void rotateCW() {
        int[][] rotated = new int[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                rotated[c][3-r] = board[r][c];
            }
        }
        board = rotated;
    }
    private void rotateCCW() {
            int[][] rotated = new int[4][4];
            for (int r = 0; r < 4; r++) {
                    for (int c = 0; c < 4; c++) {
                            rotated[3-c][r] = board[r][c];
                    }
            }
            board = rotated;
    }
    private static void restart() {
            currentScore = 0;
            board = new int[4][4];
            int[] pos1 = {(int) (Math.random() * 3), (int) (Math.random() * 3)};
            int value1 = ((int) (Math.random() * 2) + 1) * 2;
            int[] pos2 = {(int) (Math.random() * 3), (int) (Math.random() * 3)};
            while (pos1[0] == pos2[0] && pos1[1] == pos2[1]) {
                    int[] temp = {(int) (Math.random() * 3), (int) (Math.random() * 3)};
                    pos2 = temp;
            }
            int value2 = ((int) (Math.random() * 2) + 1) * 2;
            board[pos1[0]][pos1[1]] = value1;
            board[pos2[0]][pos2[1]] = value2;
    }
    private void updateText() {
        jLabel1.setText(board[0][0] == 0 ? "": "" + board[0][0]);
        jLabel2.setText(board[0][1] == 0 ? "": "" + board[0][1]);
        jLabel3.setText(board[0][2] == 0 ? "": "" + board[0][2]);
        jLabel4.setText(board[0][3] == 0 ? "": "" + board[0][3]);
        jLabel5.setText(board[1][0] == 0 ? "": "" + board[1][0]);
        jLabel6.setText(board[1][1] == 0 ? "": "" + board[1][1]);
        jLabel7.setText(board[1][2] == 0 ? "": "" + board[1][2]);
        jLabel8.setText(board[1][3] == 0 ? "": "" + board[1][3]);
        jLabel9.setText(board[2][0] == 0 ? "": "" + board[2][0]);
        jLabel10.setText(board[2][1] == 0 ? "": "" + board[2][1]);
        jLabel11.setText(board[2][2] == 0 ? "": "" + board[2][2]);
        jLabel12.setText(board[2][3] == 0 ? "": "" + board[2][3]);
        jLabel13.setText(board[3][0] == 0 ? "": "" + board[3][0]);
        jLabel14.setText(board[3][1] == 0 ? "": "" + board[3][1]);
        jLabel15.setText(board[3][2] == 0 ? "": "" + board[3][2]);
        jLabel16.setText(board[3][3] == 0 ? "": "" + board[3][3]);
        jLabel17.setText("" + currentScore);
        jLabel18.setText("" + highScore);
    }
    private void updateColors() {
        JPanel[] j = {jPanel7, jPanel8, jPanel9, jPanel10, jPanel17, jPanel18, jPanel19, jPanel20, jPanel31, jPanel32, jPanel33, jPanel34, jPanel35, jPanel36, jPanel37, jPanel38};
        JLabel[] l = {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16};
        for (int i = 0; i < j.length; i++) {
            if (l[i].getText().equals("")) {
                j[i].setBackground(new java.awt.Color(204, 192, 179));
                l[i].setForeground(new java.awt.Color(119, 110, 101));
            }
            else if (l[i].getText().equals("2")) {
                j[i].setBackground(new java.awt.Color(238, 228, 218));
                l[i].setForeground(new java.awt.Color(119, 110, 101));
            }
            else if (l[i].getText().equals("4")) {
                j[i].setBackground(new java.awt.Color(237, 224, 200));
                l[i].setForeground(new java.awt.Color(119, 110, 101));
            }
            else if (l[i].getText().equals("8")){
                j[i].setBackground(new java.awt.Color(242, 177, 121));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else if (l[i].getText().equals("16")){
                j[i].setBackground(new java.awt.Color(245, 149, 99));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else if (l[i].getText().equals("32")){
                j[i].setBackground(new java.awt.Color(246, 124, 95));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else if (l[i].getText().equals("64")){
                j[i].setBackground(new java.awt.Color(246, 94, 59));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else if (l[i].getText().equals("128")){
                j[i].setBackground(new java.awt.Color(237, 207, 114));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else if (l[i].getText().equals("256")){
                j[i].setBackground(new java.awt.Color(237, 204, 97));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else if (l[i].getText().equals("512")){
                j[i].setBackground(new java.awt.Color(237, 200, 80));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else if (l[i].getText().equals("1024")){
                j[i].setBackground(new java.awt.Color(237, 197, 63));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else if (l[i].getText().equals("2048")){
                j[i].setBackground(new java.awt.Color(237, 194, 46));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
            else {
                j[i].setBackground(new java.awt.Color(237, 194, 46));
                l[i].setForeground(new java.awt.Color(255, 255, 255));
            }
        }
    }
    private boolean checkWin() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == WIN_TARGET) return true;
            }
        }
        return false;
    }
    private boolean checkLoss() {
        int[][] before = new int[board.length][board[0].length];
        System.arraycopy(board, 0, before, 0, board.length);
        boolean leftChange = true;
        updateBoard(KeyEvent.VK_LEFT);
        if (Arrays.deepEquals(before, board)) leftChange = false;
        board = before;
        boolean upChange = true;
        updateBoard(KeyEvent.VK_UP);
        if (Arrays.deepEquals(before, board)) upChange = false;
        board = before;
        boolean rightChange = true;
        updateBoard(KeyEvent.VK_RIGHT);
        if (Arrays.deepEquals(before, board)) rightChange = false;
        board = before;
        boolean downChange = true;
        updateBoard(KeyEvent.VK_DOWN);
        if (Arrays.deepEquals(before, board)) downChange = false;
        board = before;
        if (leftChange || upChange || rightChange || downChange) return false;
        return true;
    }
    private int highestTile() {
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > max) max = board[i][j];
            }
        }
        return max;
    }
    private int updateHigh() {
        try {
            Scanner input = new Scanner(new File("scores.txt"));
            ArrayList<String[]> lines = new ArrayList<>();
            while (input.hasNextLine())
                lines.add(input.nextLine().split(": "));
            for (String[] a: lines) {
                if (Integer.parseInt(a[1]) > highScore) {
                    highScore = Integer.parseInt(a[1]);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("This should never happen.");
        }
        return highScore;
    }
    private void ai() {
        if (ai && !airunning) {
			airunning = true;
            new SwingWorker<Integer, Integer>() {
                protected Integer doInBackground() {
                    final AI ai = new AI();
                    jTextField1.setText(ai.name);
                    if (ai.autoRestart) {
                        int totalScore = 0;
                        int totalWins = 0;
                        int totalLosses = 0;
                        int trialHighScore = 0;
                        int trialLowScore = Integer.MAX_VALUE;
                        int trials = ai.trials;
						out.println("===NEW GAME===");
                        while (ai.autoRestart) {
                            int id = ai.ai_move(board);
                            //System.out.println(id);
							out.println(id);
                            updateBoard(id);
							if (AI.out != null) AI.out.println();
							if (AI.out != null) AI.out.println("Moved: " + AI.translate(id));
                            publish(0);
							try {
								Thread.sleep(sleeptime);
							} catch(InterruptedException ex) {
								Thread.currentThread().interrupt();
							}
                            //no high score stuff
                            if (checkWin()) {
								System.out.println("Victory!");
								if (AI.out != null) AI.out.println("Victory!");
                                totalWins++;
                                totalScore += currentScore;
                                if (currentScore > trialHighScore) trialHighScore = currentScore;
                                if (currentScore < trialLowScore) trialLowScore = currentScore;
                                restart();
                                updateText();
                                updateColors();
                                ai.trials--;
								System.out.println("Trials remaining: " + ai.trials);
								if (AI.out != null) AI.out.println("===NEW GAME===");
                            }
                            if (checkLoss()) {
								System.out.println("Loss: " + AI.max(board));
								if (AI.out != null) AI.out.println("Loss: " + AI.max(board));
                                totalLosses++;
                                totalScore += currentScore;
                                if (currentScore > trialHighScore) trialHighScore = currentScore;
                                if (currentScore < trialLowScore) trialLowScore = currentScore;
                                restart();
                                updateText();
                                updateColors();
                                ai.trials--;
								System.out.println("Trials remaining: " + ai.trials);
								if (AI.out != null) AI.out.println("===NEW GAME===");	
                            }
                            if (ai.trials == 0) ai.autoRestart = false;
                        }
                        double averageScore = totalScore / trials;
                        double winPercent = 100 * totalWins / (totalWins + totalLosses);
						System.out.println("[debug] " + totalWins + " " + totalLosses);
                        System.out.println("average score = " + averageScore);
                        System.out.println("win percent = " + winPercent);
                        System.out.println("high score = " + trialHighScore);
                        System.out.println("low score = " + trialLowScore);
                        ai.autoRestart = true;
                    }
                    while (!checkWin() && !checkLoss() && !ai.autoRestart) {
                        int id = ai.ai_move(board);
                        updateBoard(id);
						out.println(id);
                        publish(0);
//                        System.out.println(id);
                        if (currentScore > highScore) {
                            highScore = currentScore;
                        }
                        try {
                            Thread.sleep(sleeptime);
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (checkWin()) {
                        jFrame1.setVisible(true);
                    }
                    if (checkLoss()) {
                        jLabel24.setText("Game over!");
                        jLabel24.setForeground(new java.awt.Color(119, 110, 101));
                        jPanel1.setBackground(new java.awt.Color(238, 228, 218));
                        jFrame1.setVisible(true);
                    }
					System.out.println("Output file: " + AI.filename);
					out.close();
					if (AI.out != null) {
						AI.out.close();
						AI.out = null;
					}
					airunning = false;
                    return 0;
                }
                protected void process(List<Integer> e) {
                    updateText();
                    updateColors();
                }
				protected void done() {
					airunning = false;
				}
            }.execute();
        }
    }
    public static void main(String args[]) throws Exception{
		out = new PrintWriter(new File("replay.txt"));
        restart();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
