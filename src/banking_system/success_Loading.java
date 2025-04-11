/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banking_system;


public class success_Loading extends javax.swing.JFrame implements Runnable {
    
    Thread th;
    private String loginData;
    private String signupData;
    public success_Loading(String loginData,String signupData) {
        this.loginData=loginData;
        this.signupData=signupData;
        initComponents();
        th=new Thread((Runnable)this);
    }
    
    private String actualID;
    
    public void successLoading(){
        
        setVisible(false);
        th.start();   
    }
    public void run(){
         try{
           for (int i=0;i<=101  ;i++){
               int m=jProgressBar1.getMaximum();
               int v=jProgressBar1.getValue();
               if (v<m){
                   jProgressBar1.setValue(jProgressBar1.getValue()+1);
                   if(i%10==0){
                       jLabel4.setText("Processing On Your Payment....");
                   }else{
                       jLabel4.setText("Processing On Your Payment...");
                   }
               }else{
                   i=101;
                    setVisible(false);
                   Transcation_Success ts=new Transcation_Success(loginData,signupData);
                   ts.setVisible(true);
                   
               }
               
                            
                   Thread.sleep(10);
           } 
        }catch(InterruptedException e){
            
        }
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new banking_system.ProgressBarCustom();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/IMG_20240216_112558_936-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 0, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 106, 118));
        jLabel3.setText("BK Bank");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 106, 118));
        jLabel4.setText("Processing On Your Payment...");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 190, -1));

        jPanel1.setBackground(new java.awt.Color(220, 225, 222));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 40));

        jProgressBar1.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBar1.setForeground(new java.awt.Color(52, 73, 94));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 260, 10));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/56277edb36b94-unscreen.gif"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new success_Loading(null,null).setVisible(true);
            }
        });
        
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private banking_system.ProgressBarCustom jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
