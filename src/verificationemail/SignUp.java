/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificationemail;

/**
 *
 * @author Patrick
 */
public class SignUp extends javax.swing.JDialog {

    Model model;
    boolean[] signupInfo;
    boolean signUp = false;
    boolean logIn = false;
    

    /**
     * Creates new form SignUp
     *
     * @param parent
     */
    public SignUp(java.awt.Frame parent, boolean modal, Model model) {
        super(parent, modal);
        initComponents();
        this.model = model;
    }

    
    boolean UCondition() {
        String input = txtUsername.getText();
        if(isEmpty(input)){
            lblUError.setText("Enter a Username...");
            return false;
        }else if(model.isMatch(input,0)){
            lblUError.setText("Username already taken...");
            return false;
        }else if(!isSymbol(input)){
            lblUError.setText("Use only numbers and letters...");
            return false;
        }
        lblUError.setText("");
        return true;
    }

    boolean PCondition() {
        String input1 = toString(txtPassword.getPassword());
        String input2 = toString(txtCPassword.getPassword());
        if(isEmpty(input1)|| isEmpty(input2)){
            lblPError.setText("Enter Passwords...");
            return false;
        }else if(!model.sameWord(input1, input2)){
            lblPError.setText("Passwords dont match...");
            return false;
        }else if (!is2Number(input1)){
            lblPError.setText("Must use two numbers...");
            return false;
        }
        lblPError.setText("");
        return true;
    }

    boolean ECondition() {
        String input = txtEmail.getText();
        if(isEmpty(input)){
            lblEError.setText("Enter an Email...");
            return false;
        }else if(!isFormat(input)){
            lblEError.setText("Enter a valid email");
            return false;
        }else if(model.isMatch(input, 2)){
            lblEError.setText("Email  already used...");
            return false;
        }
        lblEError.setText("");
        return true;
    }
    //CONDITIONING START
    boolean isFormat(String input){
        int atCount = 0;
        int doCount = 0;
        boolean confirm = true;
        int atPos=0;
        int doPos=0;
        int chCount = 0;
        for (int i =0; i < input.length();i++){
            char ch = input.charAt(i);
            String symbols = "!#$%&'*+-/=?^_`{|}~@.";
            for (int n = 0;n<symbols.length();n++){
                if (ch == symbols.charAt(n) || isNumber(ch) || isCharacter(ch)){
                    chCount++;
                    System.out.println("adding " + ch+ " to count: " + chCount);
                }
            }
            if (ch == '@'){
                atCount++;
                atPos = i;
            }
            
            
            if ('.' == ch){
                doPos = i;
                doCount++;
            }
            
        }
        if (atCount != 1 || doCount < 1){
            confirm = false;
            System.out.println("(atCount != 1 || doCount < 1)");
        }
        if((doPos<atPos)){
            confirm = false;
            System.out.println("(doPos<atPos)");
        }
        if (chCount != input.length()){
            confirm = false;
            System.out.println("(chCount != input.length())");
        }
        if (input.length() < 6){
            confirm = false;
            System.out.println("(input.length() < 6)");
        }
        System.out.println(confirm);
        return confirm;
    }
    boolean isSymbol(String input){
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(!isNumber(ch) && !isCharacter(ch)){
                return false;
            }
        }
        return true;
    }
    boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9');
    }
    boolean isCharacter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }

    boolean isEmpty(String input){
        return(input.length() == 0);
    }
    boolean is2Number(String input){
        int nuCount = 0;
        for(int i = 0; i<input.length();i++){
            char ch = input.charAt(i);
            if(isNumber(ch)) nuCount++;
        }
        if(nuCount>= 2) return true;
        return false;
    }
    //CONDITIONING END
    
    boolean isSignUp(){
        return signUp;
    }
    boolean isLogIn(){
        return logIn;
    }
    String[] getValues(){
        String[] tmparray = new String[] {txtUsername.getText(), toString(txtPassword.getPassword()), txtEmail.getText()};
        return tmparray;
    }
    String toString(char[] ch){
        String tmpstring = "";
        for (int i = 0; i < ch.length;i++) tmpstring+= ch[i];
        return tmpstring;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtPassword2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        btnLogIn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtCPassword = new javax.swing.JPasswordField();
        lblEError = new javax.swing.JLabel();
        lblPError = new javax.swing.JLabel();
        lblUError = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(225, 225, 215));
        jLabel5.setText("Confirm Password:");

        txtPassword2.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        txtPassword2.setForeground(new java.awt.Color(225, 225, 215));
        txtPassword2.setText("                       ");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(240, 244, 255));

        panelTitle.setBackground(new java.awt.Color(7, 70, 135));

        jLabel1.setBackground(new java.awt.Color(225, 225, 215));
        jLabel1.setFont(new java.awt.Font("Silom", 0, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(225, 225, 215));
        jLabel1.setText("SIGN UP");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(68, 68, 68))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(7, 70, 135));

        jLabel2.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(225, 225, 215));
        jLabel2.setText("Username");

        txtUsername.setFont(new java.awt.Font("Silom", 0, 10)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(225, 225, 215));
        jLabel3.setText("Password:");

        btnSignUp.setBackground(new java.awt.Color(85, 98, 111));
        btnSignUp.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(85, 98, 111));
        btnSignUp.setText("SIGN UP");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        btnLogIn.setBackground(new java.awt.Color(85, 98, 111));
        btnLogIn.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        btnLogIn.setForeground(new java.awt.Color(85, 98, 111));
        btnLogIn.setText("OR... LOG IN");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(225, 225, 215));
        jLabel4.setText("Confirm Password:");

        jLabel6.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(225, 225, 215));
        jLabel6.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Silom", 0, 10)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblEError.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lblEError.setForeground(new java.awt.Color(252, 13, 28));
        lblEError.setText("jLabel7");

        lblPError.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lblPError.setForeground(new java.awt.Color(252, 13, 28));
        lblPError.setText("jLabel7");

        lblUError.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lblUError.setForeground(new java.awt.Color(252, 13, 28));
        lblUError.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(btnSignUp)
                    .addComponent(btnLogIn)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername)
                    .addComponent(txtCPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEError)
                    .addComponent(lblPError)
                    .addComponent(lblUError))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCPassword, txtEmail, txtPassword, txtUsername});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblUError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(txtCPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEError)
                .addGap(18, 18, 18)
                .addComponent(btnSignUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogIn)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        boolean verify = true;
        if(!UCondition()) verify = false;
        if(!ECondition()) verify = false;
        if(!PCondition()) verify = false;
        if(verify) this.dispose();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        logIn = true;
        this.dispose();
    }//GEN-LAST:event_btnLogInActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblEError;
    private javax.swing.JLabel lblPError;
    private javax.swing.JLabel lblUError;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JPasswordField txtCPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPassword2;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
