/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cadastros;

import view.armazenamento.DialogArmazenamentoEleitor;
import conexao.exceptions.ConnectionException;
import conexao.exceptions.SQLStatementException;
import contreller.DAO.GerenciadorEleicao;
import contreller.DAO.GerenciadorEleitor;
import excecaoEleitor.MatriculaException;
import excecaoEleitor.NomeException;
import javax.swing.JOptionPane;
import model.Eleicao;
import model.Eleitor;
import model.exceptions.ValidarCursoException;
import model.exceptions.ValidarEmailException;

/**
 *
 * @author Aluno
 */
public class DialogCadastroEleitor extends javax.swing.JDialog {

    private Eleitor eleitor = null;
    private GerenciadorEleitor ge = new GerenciadorEleitor();
    

    /**
     * Creates new form DialogCadastroEleitor
     */
    public DialogCadastroEleitor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tffMatricula = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btFecahr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Eleitor");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cadastro de Eleitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        jLabel1.setText("Nome :");

        jLabel3.setText("Email :");

        jLabel5.setText("Curso :");

        jLabel2.setText("Matricula :");

        try {
            tffMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(4, 4, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(tffMatricula)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(345, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tfCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tffMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(0, 0, 204));
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btSalvar);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);

        btFecahr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btFecahr.setForeground(new java.awt.Color(204, 0, 0));
        btFecahr.setText("Fechar");
        btFecahr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecahrActionPerformed(evt);
            }
        });
        jPanel2.add(btFecahr);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecahrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecahrActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecahrActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
        try {
            if (this.eleitor == null) {
                setEleitorInterface(this.getEleitor());
                if (this.getEleitor() != null) {
                    if(ge.obterEleitor(getEleitor().getMatricula()) == null){
                        ge.inserir(getEleitor());
                        this.limparCampos();
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Ja existe eleitor com esta matrícula! \n"
                                + "Por favor escolha outra matrícula!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                        eleitor = null;
                        return;
                    }
                }

            } else {
                setEleitorInterface(this.getEleitor());
                if(eleitor != null){
                    ge.atualizar(eleitor);
                     this.dispose();
                }
                
            }
            DialogArmazenamentoEleitor.setListaEleitor(ge.obterTodos());
        } catch (ConnectionException | SQLStatementException | NomeException | MatriculaException | ValidarEmailException | ValidarCursoException ex) {
            JOptionPane.showMessageDialog(this, "Erro:" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            eleitor = null;
        }

       
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        try {
            // TODO add your handling code here:

            this.tratarBotoes();
        } catch (MatriculaException | NomeException | ValidarEmailException | ValidarCursoException ex) {
            JOptionPane.showMessageDialog(this, "Erro:" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        this.limparCampos();
    }//GEN-LAST:event_btCancelarActionPerformed

    private Eleitor getEleitor() throws MatriculaException, NomeException, ValidarEmailException, ValidarCursoException {
        if (eleitor == null) {
            eleitor = new Eleitor();
        }

        
            eleitor.setMatricula(getTfMatricula().getText());
            eleitor.setNome(getTfNome().getText());
            eleitor.setEmail(getTfEmail().getText());
        
        eleitor.setCurso(getTfCurso().getText());

        return eleitor;

    }

    private Eleitor setEleitor() throws MatriculaException, NomeException, ValidarEmailException, ValidarCursoException{
        getTfNome().setText(getEleitor().getNome());
        getTfEmail().setText(getEleitor().getEmail());
        getTfMatricula().setText(getEleitor().getMatricula());
        getTfCurso().setText(getEleitor().getCurso());

        return getEleitor();

    }

    private void tratarBotoes() throws MatriculaException, NomeException, ValidarEmailException, ValidarCursoException{
        if (getEleitor() != null) {
            this.btSalvar.setEnabled(!this.btSalvar.isEnabled());
            // this.jButtonRemover.setEnabled(!this.jButtonRemover.isEnabled());
            this.getTfMatricula().setEnabled(!this.tffMatricula.isEnabled());
        }
    }

    private void limparCampos() {
        this.getTfCurso().setText(null);
        this.getTfEmail().setText(null);
        this.getTfMatricula().setText(null);
        this.getTfCurso().setText(null);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFecahr;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfCurso;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tffMatricula;
    // End of variables declaration//GEN-END:variables

    /**
     * @param eleitor the eleitor to set
     */
    public void setEleitorInterface(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    /**
     *
     * @return
     */
    public Eleitor getEleitorInterface() {
        return this.eleitor;

    }

    /**
     * @return the tfCurso
     */
    public javax.swing.JTextField getTfCurso() {
        return tfCurso;
    }

    /**
     * @param tfCurso the tfCurso to set
     */
    public void setTfCurso(javax.swing.JTextField tfCurso) {
        this.tfCurso = tfCurso;
    }

    /**
     * @return the tfEmail
     */
    public javax.swing.JTextField getTfEmail() {
        return tfEmail;
    }

    /**
     * @param tfEmail the tfEmail to set
     */
    public void setTfEmail(javax.swing.JTextField tfEmail) {
        this.tfEmail = tfEmail;
    }

    /**
     * @return the tfMatricula
     */
    public javax.swing.JTextField getTfMatricula() {
        return tffMatricula;
    }

    /**
     * @param tfMatricula the tfMatricula to set
     */
    public void setTfMatricula(javax.swing.JFormattedTextField tfMatricula) {
        this.tffMatricula = tfMatricula;
    }

    /**
     * @return the tfNome
     */
    public javax.swing.JTextField getTfNome() {
        return tfNome;
    }

    /**
     * @param tfNome the tfNome to set
     */
    public void setTfNome(javax.swing.JTextField tfNome) {
        this.tfNome = tfNome;
    }

    
    

}