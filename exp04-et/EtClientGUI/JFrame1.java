/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFrame1.java
 *
 * Created on Nov 19, 2011, 2:29:01 PM
 */
/**
 *
 * @author dworden
 */
public class JFrame1 extends javax.swing.JFrame {
    
    String msg = " ";

    /** Creates new form JFrame1 */
    public JFrame1() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etAccountPanel = new javax.swing.JPanel();
        etAccountLabel = new javax.swing.JLabel();
        etPasswordLabel = new javax.swing.JLabel();
        etIPLabel = new javax.swing.JLabel();
        etPortLabel = new javax.swing.JLabel();
        etAccountComboxBox = new javax.swing.JComboBox();
        etPasswordPasswordField = new javax.swing.JPasswordField();
        etIPTextField = new javax.swing.JTextField();
        etPortTextField = new javax.swing.JTextField();
        etExpenseEntryPanel = new javax.swing.JPanel();
        etAmountLabel = new javax.swing.JLabel();
        etDateIncurredLabel = new javax.swing.JLabel();
        etCategoryCodeLabel = new javax.swing.JLabel();
        etCategoryDescLabel = new javax.swing.JLabel();
        etNoteLabel = new javax.swing.JLabel();
        etSubmitButton = new javax.swing.JButton();
        etTestButton = new javax.swing.JButton();
        etExitButton = new javax.swing.JButton();
        etAmountTextField = new javax.swing.JTextField();
        etDateIncurredTextField = new javax.swing.JTextField();
        etCategoryCodeComboBox = new javax.swing.JComboBox();
        etCategoryDescComboBox = new javax.swing.JComboBox();
        etNoteTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        etOutputPanel = new javax.swing.JPanel();
        etScrollPane = new javax.swing.JScrollPane();
        etTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etAccountLabel.setText("Account:");

        etPasswordLabel.setText("Password:");

        etIPLabel.setText("IP:");

        etPortLabel.setText("Port:");

        etAccountComboxBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "noop" }));

        etPasswordPasswordField.setText("admin13admin13");

        etIPTextField.setText("172.0.0.1");

        etPortTextField.setText("13131");

        javax.swing.GroupLayout etAccountPanelLayout = new javax.swing.GroupLayout(etAccountPanel);
        etAccountPanel.setLayout(etAccountPanelLayout);
        etAccountPanelLayout.setHorizontalGroup(
            etAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etAccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(etAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etAccountLabel)
                    .addComponent(etIPLabel))
                .addGap(10, 10, 10)
                .addGroup(etAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etAccountComboxBox, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(etAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etPasswordLabel)
                    .addComponent(etPortLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(etAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etPasswordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        etAccountPanelLayout.setVerticalGroup(
            etAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, etAccountPanelLayout.createSequentialGroup()
                .addGroup(etAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etAccountLabel)
                    .addComponent(etPasswordLabel)
                    .addComponent(etAccountComboxBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etPasswordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(etAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etIPLabel)
                    .addComponent(etPortLabel)
                    .addComponent(etIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        etAmountLabel.setText("Amount:");

        etDateIncurredLabel.setText("Date Incurred:");

        etCategoryCodeLabel.setText("Category Code:");

        etCategoryDescLabel.setText("Category Desc:");

        etNoteLabel.setText("Note:");

        etSubmitButton.setText("Submit");
        etSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etSubmitButtonActionPerformed(evt);
            }
        });

        etTestButton.setText("Test");
        etTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etTestButtonActionPerformed(evt);
            }
        });

        etExitButton.setText("Exit");
        etExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etExitButtonActionPerformed(evt);
            }
        });

        etAmountTextField.setText("13.13");

        etDateIncurredTextField.setText("2012-12-24");

        etCategoryCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "001000000000000", "002000000000000", "003000000000000", "004000000000000", "005000000000000", " " }));

        etCategoryDescComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Household Clothing", "Household Food", "Household Recreation", "Household Shelter", "Household Transportation", " " }));

        javax.swing.GroupLayout etExpenseEntryPanelLayout = new javax.swing.GroupLayout(etExpenseEntryPanel);
        etExpenseEntryPanel.setLayout(etExpenseEntryPanelLayout);
        etExpenseEntryPanelLayout.setHorizontalGroup(
            etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etExpenseEntryPanelLayout.createSequentialGroup()
                .addGroup(etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(etExpenseEntryPanelLayout.createSequentialGroup()
                        .addComponent(etCategoryCodeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etCategoryCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(etExpenseEntryPanelLayout.createSequentialGroup()
                        .addComponent(etCategoryDescLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etCategoryDescComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(etExpenseEntryPanelLayout.createSequentialGroup()
                        .addComponent(etNoteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etNoteTextField))
                    .addGroup(etExpenseEntryPanelLayout.createSequentialGroup()
                        .addGroup(etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(etExpenseEntryPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(etSubmitButton)
                                .addGap(54, 54, 54)
                                .addComponent(etTestButton)
                                .addGap(52, 52, 52)
                                .addComponent(etExitButton))
                            .addGroup(etExpenseEntryPanelLayout.createSequentialGroup()
                                .addComponent(etAmountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(etAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etDateIncurredLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(etDateIncurredTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        etExpenseEntryPanelLayout.setVerticalGroup(
            etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etExpenseEntryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etAmountLabel)
                    .addComponent(etAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDateIncurredTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDateIncurredLabel))
                .addGap(18, 18, 18)
                .addGroup(etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etCategoryCodeLabel)
                    .addComponent(etCategoryCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etCategoryDescLabel)
                    .addComponent(etCategoryDescComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etNoteLabel)
                    .addComponent(etNoteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(etExpenseEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etSubmitButton)
                    .addComponent(etTestButton)
                    .addComponent(etExitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        etTextArea.setColumns(20);
        etTextArea.setRows(5);
        etScrollPane.setViewportView(etTextArea);

        javax.swing.GroupLayout etOutputPanelLayout = new javax.swing.GroupLayout(etOutputPanel);
        etOutputPanel.setLayout(etOutputPanelLayout);
        etOutputPanelLayout.setHorizontalGroup(
            etOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etOutputPanelLayout.createSequentialGroup()
                .addComponent(etScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        etOutputPanelLayout.setVerticalGroup(
            etOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etOutputPanelLayout.createSequentialGroup()
                .addComponent(etScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(etAccountPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(etExpenseEntryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etOutputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etAccountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etExpenseEntryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etOutputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etSubmitButtonActionPerformed
        // TODO add your handling code here:
        etTextArea.setText("Submit Button Hit");
    }//GEN-LAST:event_etSubmitButtonActionPerformed

    private void etTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etTestButtonActionPerformed
        // TODO add your handling code here:
        etTextArea.setText("Test Button Hit");
    }//GEN-LAST:event_etTestButtonActionPerformed

    private void etExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etExitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_etExitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFrame1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox etAccountComboxBox;
    private javax.swing.JLabel etAccountLabel;
    private javax.swing.JPanel etAccountPanel;
    private javax.swing.JLabel etAmountLabel;
    private javax.swing.JTextField etAmountTextField;
    private javax.swing.JComboBox etCategoryCodeComboBox;
    private javax.swing.JLabel etCategoryCodeLabel;
    private javax.swing.JComboBox etCategoryDescComboBox;
    private javax.swing.JLabel etCategoryDescLabel;
    private javax.swing.JLabel etDateIncurredLabel;
    private javax.swing.JTextField etDateIncurredTextField;
    private javax.swing.JButton etExitButton;
    private javax.swing.JPanel etExpenseEntryPanel;
    private javax.swing.JLabel etIPLabel;
    private javax.swing.JTextField etIPTextField;
    private javax.swing.JLabel etNoteLabel;
    private javax.swing.JTextField etNoteTextField;
    private javax.swing.JPanel etOutputPanel;
    private javax.swing.JLabel etPasswordLabel;
    private javax.swing.JPasswordField etPasswordPasswordField;
    private javax.swing.JLabel etPortLabel;
    private javax.swing.JTextField etPortTextField;
    private javax.swing.JScrollPane etScrollPane;
    private javax.swing.JButton etSubmitButton;
    private javax.swing.JButton etTestButton;
    private javax.swing.JTextArea etTextArea;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}