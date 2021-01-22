/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.*;
import adt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Kelly Lai
 */
public class Home extends javax.swing.JFrame {

    private ListInterface<User> userList = new ArrayList<User>();
    private ArrListGameResultsInterface<GameResult> history= new ArrListGameResults<GameResult>();
    // private ArrListGameResultsInterface <GameResult> resultList=new ArrListGameResults <GameResult> ();
    private DefaultListModel model;
    private JList list;
    private static final String deleteString = "Delete";
    private static final String selectString = "Select";
    private JButton deleteButton;
    private JButton selectButton;
    private static final String addString = "Add";
    private JTextField userName;
    private int counter = 0;
    public boolean select = false;
    public Integer selectedUserIndex;
    private String selectedUser;
    private JFrame f ;

    /**
     * Creates new form Profile
     */
    public Home() {
        setTitle("HangMan.Home");
        initComponents();
        jLabel1.setVisible(select);
        jButton1.setEnabled(select);
        jButton2.setEnabled(select);
        setVisible(true);
        setLocationRelativeTo(null);
        pressXtoClose();
    }

    public Home(Integer selectedUserIndex, ListInterface<User> userList) {
        this.selectedUserIndex = selectedUserIndex;
        this.userList = userList;
        setTitle("HangMan.Home");
        
        setVisible(true);
        setLocationRelativeTo(null);
        initComponents();
        if (selectedUserIndex != null) {
            int index = selectedUserIndex;
            selectedUser = userList.get(index).getName();
            jLabel1.setVisible(true);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jLabel1.setText("Name = " + selectedUser + " | Highest Rank = " + userList.get(index).getHighestRank() + "\n | Highest Score = " + userList.get(index).getHighestScore());
            System.out.println(selectedUser);

        }
    }

    private void pressXtoClose() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int quitselect = JOptionPane.showConfirmDialog(null, "Do you want to quit the game?", "Exit Game", JOptionPane.YES_NO_OPTION);
                if (quitselect == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
    }

    public void userList() {
        f= new JFrame("User List");
        model = new DefaultListModel();
        if (!userList.isEmpty()) {
            for (int i = 0; i < userList.getSize(); i++) {
                model.addElement(userList.get(i));
                //counter++;
            }
        }
        // model.addElement("Kelly");
        list = new JList(model);
//        JComponent newContentPane = new displayList();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        f.setContentPane(newContentPane);
        f.add(list);
        f.pack();

        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setMinimumSize(new Dimension(400, 300));
        JScrollPane listScrollPane = new JScrollPane(list);
        f.add(listScrollPane, BorderLayout.CENTER);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(10);
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting() == false) {

                    if (list.getSelectedIndex() == -1) {
                        //No selection, disable fire button.
                        deleteButton.setEnabled(false);
                        selectButton.setEnabled(false);

                    } else {
                        //Selection, enable the fire button.
                        deleteButton.setEnabled(true);
                        selectButton.setEnabled(true);

                    }
                }
            }

        });

        deleteButton = new JButton(deleteString);
        deleteButton.setActionCommand(deleteString);
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new DeleteListener());

        selectButton = new JButton(selectString);
        selectButton.setActionCommand(selectString);
        selectButton.setEnabled(false);
        selectButton.addActionListener(new SelectListener());

        JButton addButton = new JButton(addString);
        AddListener addListener = new AddListener(addButton);
        addButton.setActionCommand(addString);
        addButton.addActionListener(addListener);
        addButton.setEnabled(false);

        userName = new JTextField(10);
        userName.addActionListener(addListener);
        userName.getDocument().addDocumentListener(addListener);
//        String name = model.getElementAt(
//                list.getSelectedIndex()).toString();
        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));

        buttonPane.add(selectButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(deleteButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));

        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(userName);
        buttonPane.add(addButton);

        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        f.add(buttonPane, BorderLayout.PAGE_END);

    }

    class DeleteListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int index = list.getSelectedIndex();
            model.remove(index);
            userList.remove(index);

            //for checking ignore it
            System.out.println("index=" + index);

            counter--;
            int size = model.getSize();

            if (size == 0) { //Nobody's left, disable firing.
                deleteButton.setEnabled(false);

            } else { //Select an index.
                if (index == model.getSize()) {
                    //removed item in last position
                    index--;
                }
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
            for (int i = 0; i < userList.getSize(); i++) {

                System.out.println(userList.get(i).getName() + "\t" + userList.get(i).getHighestRank() + "\t\t" + userList.get(i).getHighestScore());
                System.out.println(userList.toString());
            }
        }
    }

    class SelectListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int index = list.getSelectedIndex();
            System.out.println("HI:"+ index);
            //model.remove(index);
            //userList.remove(index);

            //System.out.println("index=" + index + userList.get(index) + userList.get(index).getName());
            //counter--;
            int size = model.getSize();
            if (index == 0 || index > 0) {
                select = true;
            } else {
                select = false;
            }
            if (size <= 0) { //Nobody's left, disable firing.
                selectButton.setEnabled(false);
            } else { //Select an index.

                System.out.println("index=" + index + userList.get(index) + userList.get(index).getName());

//                if (index == model.getSize()) {
//                    //removed item in last position
//                    index--;
//                }
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
//            for (int i = 0; i < userList.getSize(); i++) {
//
//                System.out.println(userList.get(i).getName() + "\t" + userList.get(i).getHighestRank() + "\t\t" + userList.get(i).getHighestScore());
//                System.out.println(userList.toString());
//            }
            String name = userList.get(index).getName();
            JOptionPane.showMessageDialog(null, "Welcome, your name is = " + name);
            select = true;
            selectedUserIndex = index;
            selectedUser = userList.get(index).getName();

            if (select == true) {
                jLabel1.setVisible(true);
                jButton1.setEnabled(true);
                jButton2.setEnabled(true);
                jLabel1.setText("Name = " + selectedUser + " | Highest Rank = " + userList.get(index).getHighestRank() + "\n | Highest Score = " + userList.get(index).getHighestScore());
                System.out.println(selectedUser);
            }
            f.dispose();
            
        }
    }
    
    class AddListener implements ActionListener, DocumentListener {

        private boolean alreadyEnabled = false;
        private JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }

        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            String name = userName.getText();
            User user = new User(name);
            //if the name alrdy exist
            if (name.equals("") || model.contains(name) || userList.contains(user)) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Name already exist! " + "''" + name + "''");
                userName.requestFocusInWindow();
                userName.selectAll();
                return;
            }

            int index = list.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
            }

            // model.insertElementAt(userName.getText(), index);
            //If we just wanted to add to the end, we'd do this:
            userList.add(user);
            model.addElement(userList.get(counter));
            counter++;

            //Reset the text field.
            userName.requestFocusInWindow();
            userName.setText("");

            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }
     
        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("View History");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Start Game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LeaderBoard");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 36)); // NOI18N
        jLabel2.setText("HangMan");

        jButton4.setText("User List");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void viewHistory() {
        JFrame window = new JFrame("HangMan");
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // final JDesktopPane desktop = new JDesktopPane();
        JPanel top = new JPanel();

        JButton exit = new JButton("Close window");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });
        JFrame f = new JFrame("User List");

        model = new DefaultListModel();
        if (!userList.isEmpty()) {
        
//                if(userList.)
                model.addElement(userList.get(selectedUserIndex).getName());
                    if (userList.get(selectedUserIndex).getGameResult()!=null)
                    for (int i = 0; i < userList.get(selectedUserIndex).getGameResult().getLength(); i++) 
                model.addElement(userList.get(selectedUserIndex).getGameResult().get(i).toString());
                //counter++;
        
        }
        // model.addElement("Kelly");
        list = new JList(model);

        window.add(list);
        window.pack();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setMinimumSize(new Dimension(400, 300));
        JScrollPane listScrollPane = new JScrollPane(list);
        window.add(listScrollPane, BorderLayout.CENTER);
        top.add(exit);
        window.add(BorderLayout.NORTH, top);
        //window.add(BorderLayout.CENTER, desktop);
        window.setSize(500, 500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
//        System.out.println("Name\t" + "Highest Rank\t" + "Highest Score\t");
//        for (int i = 0; i < userList.getSize(); i++) {
//
//            System.out.println(userList.get(i).getName() + "\t" + userList.get(i).getHighestRank() + "\t\t" + userList.get(i).getHighestScore());
//        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        viewHistory();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new HangManUI(selectedUserIndex,userList);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new LeaderBoardUI();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //for checking (ignore it)
        System.out.println("Name\t" + "Highest Rank\t" + "Highest Score\t");
        if (!userList.isEmpty()) {
            for (int i = 0; i < userList.getSize(); i++) {

                System.out.println(userList.get(i).getName() + "\t" + userList.get(i).getHighestRank() + "\t\t" + userList.get(i).getHighestScore());
            }
        }
        userList();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
