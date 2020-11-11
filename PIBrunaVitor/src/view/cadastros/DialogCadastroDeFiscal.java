/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cadastros;

import view.armazenamento.DialogArmazenamentoFiscal;
import conexao.exceptions.ConnectionException;
import conexao.exceptions.SQLStatementException;
import contreller.DAO.GerenciadorDeFiscal;
import excecaoEleitor.NomeException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import model.Fiscal;
import model.exceptions.ValidarEmailException;

/**
 *
 * @author Aluno
 */
public class DialogCadastroDeFiscal extends javax.swing.JDialog {

    private GerenciadorDeFiscal gf = new GerenciadorDeFiscal();
    private Fiscal fiscal;

    /**
     * Creates new form DialogCadastroDeFiscal
     */
    public DialogCadastroDeFiscal(java.awt.Frame parent, boolean modal) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fiscal");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cadastro de Fiscal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        jLabel1.setText("Nome :");

        jLabel2.setText("Endereço :");

        jLabel3.setText("Email :");

        jLabel4.setText("Telefone :");

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                        .addComponent(tfEmail)
                        .addComponent(tfTelefone)))
                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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

        btCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);

        btFechar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btFechar.setForeground(new java.awt.Color(204, 0, 0));
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        jPanel2.add(btFechar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:

        try {
            if (fiscal == null) {
                setFiscalInterface(this.getFiscal());
                if(getFiscal() != null){
                    gf.inserir(getFiscal());
                    this.limparCampos();
                    this.dispose();
                }
                

            } else {
                setFiscalInterface(this.getFiscal());
                if(fiscal != null){
                    gf.atualizar(fiscal);
                    this.dispose();
                }
                
            }
            DialogArmazenamentoFiscal.setListaFiscal(gf.obterTodos());
        } catch (ConnectionException | SQLStatementException | SQLException | NomeException | ValidarEmailException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            fiscal = null;
        }

        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_btFecharActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        try {
            // TODO add your handling code here:
            this.tratarBotoes();
        } catch (NomeException | ValidarEmailException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        this.limparCampos();
    }//GEN-LAST:event_btCancelarActionPerformed

    private Fiscal getFiscal() throws NomeException, ValidarEmailException {

        fiscal = new Fiscal();
        
            fiscal.setNome(getTfNome().getText());
            fiscal.setEmail(getTfEmail().getText());
            fiscal.setEndereco(getTfEndereco().getText());
            fiscal.setTelefone(getTfTelefone().getText());
        

        return fiscal;

    }

    private Fiscal setFiscal() throws NomeException, ValidarEmailException {
        getTfNome().setText(getFiscal().getNome());
        getTfEmail().setText(getFiscal().getEmail());
        getTfEndereco().setText(getFiscal().getEndereco());
        getTfTelefone().setText(getFiscal().getTelefone());
        return getFiscal();

    }

    private void tratarBotoes() throws NomeException, ValidarEmailException {
        if (getFiscal() != null) {
            this.btSalvar.setEnabled(!this.btSalvar.isEnabled());

            // this.jButtonRemover.setEnabled(!this.jButtonRemover.isEnabled());
            this.getTfNome().setEnabled(!this.tfNome.isEnabled());
        }
    }

    private void limparCampos() {
        this.getTfEmail().setText(null);
        this.getTfEndereco().setText(null);
        this.getTfNome().setText(null);
        this.getTfTelefone().setText(null);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables

    /**
     * @param fiscal the fiscal to set
     */
    public void setFiscalInterface(Fiscal fiscal) {
        this.fiscal = fiscal;
    }

    /**
     *
     * @return
     */
    public Fiscal getFiscalInterface() {
        return this.fiscal;

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
     * @return the tfEndereco
     */
    public javax.swing.JTextField getTfEndereco() {
        return tfEndereco;
    }

    /**
     * @param tfEndereco the tfEndereco to set
     */
    public void setTfEndereco(javax.swing.JTextField tfEndereco) {
        this.tfEndereco = tfEndereco;
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

   

    /**
     * @return the tfTelefone
     */
    public javax.swing.JFormattedTextField getTfTelefone() {
        return tfTelefone;
    }

    /**
     * @param tfTelefone the tfTelefone to set
     */
    public void setTfTelefone(javax.swing.JFormattedTextField tfTelefone) {
        this.tfTelefone = (JFormattedTextField) tfTelefone;
    }
}