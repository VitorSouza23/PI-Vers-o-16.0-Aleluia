/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cadastros;

import view.armazenamento.DialogArmazenamentoCandidato;
import conexao.exceptions.ConnectionException;
import conexao.exceptions.SQLStatementException;
import contreller.DAO.GerenciadorCandidato;
import icones.GerenciadorDeImagens;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Candidato;
import model.exceptions.ValidacaoCandidatoException;

/**
 *
 * @author Aluno
 */
public class DialogCadastroCandidato extends javax.swing.JDialog {

    GerenciadorCandidato gc = new GerenciadorCandidato();
    private Candidato candidato = null;
    byte[] arrayDeBytes;

    /**
     * Creates new form DialogCadastroCandidato
     */
    public DialogCadastroCandidato(java.awt.Frame parent, boolean modal) {
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
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        spNumero = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btprocurar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btConcluido = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        lbValidarNome = new javax.swing.JLabel();
        lbValidarNumero = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Candidato");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)), "Cadstro de Candidato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel1.setText("Nome:");

        jLabel2.setText("Número:");

        spNumero.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9999, 1));

        jLabel3.setText("Foto:");

        btprocurar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btprocurar.setForeground(new java.awt.Color(0, 0, 255));
        btprocurar.setText("Procurar...");
        btprocurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btprocurarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btConcluido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btConcluido.setForeground(new java.awt.Color(0, 153, 51));
        btConcluido.setText("Concluído");
        btConcluido.setActionCommand("");
        btConcluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConcluidoActionPerformed(evt);
            }
        });
        jPanel2.add(btConcluido);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(btVoltar);

        lbValidarNome.setForeground(new java.awt.Color(255, 0, 0));

        lbValidarNumero.setForeground(new java.awt.Color(255, 0, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(30, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbFoto)
                .addGap(0, 108, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbFoto)
                .addGap(0, 148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValidarNumero)
                            .addComponent(spNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(185, 185, 185))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbValidarNome)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btprocurar)))
                                .addGap(0, 165, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbValidarNome)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValidarNumero)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btprocurar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConcluidoActionPerformed
        try {
            if (candidato == null) {
                candidato = new Candidato();
                candidato.setNome(this.getTfNome().getText());
                candidato.setNumero((int) this.getSpNumero().getValue());
                candidato.setFoto(arrayDeBytes);

                if (validarNumero(candidato.getNumero())) {
                    this.lbValidarNumero.setBackground(Color.red);
                    this.lbValidarNumero.setText("Já existe candidato cadastrado com este númeo!");
                    this.spNumero.requestFocus();
                    JOptionPane.showMessageDialog(rootPane, "Erro!, já existe Candidato cadastrado com este número!" + "\n"
                            + "Por favor selecione um novo número!", null, WIDTH);
                    candidato = null;
                    return;
                } else {
                    gc.salvar(candidato);
                    this.dispose();
                }

            } else {
                candidato.setNome(this.getTfNome().getText());
                candidato.setNumero((int) this.getSpNumero().getValue());
                candidato.setFoto(arrayDeBytes);
                gc.atualizar(candidato);
                this.dispose();
            }
            DialogArmazenamentoCandidato.setCandidatoDataList(gc.getTodosCandidatos());

        } catch (SQLStatementException | ConnectionException | SQLException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            candidato = null;
        } catch (ValidacaoCandidatoException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            this.tratarExceptions(ex);
            candidato = null;
        }


    }//GEN-LAST:event_btConcluidoActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btprocurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btprocurarActionPerformed
        try {
            arrayDeBytes = GerenciadorDeImagens.InseririImagem();
            this.lbFoto.setIcon(new ImageIcon(arrayDeBytes));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btprocurarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConcluido;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton btprocurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbValidarNome;
    private javax.swing.JLabel lbValidarNumero;
    private javax.swing.JSpinner spNumero;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the spNumero
     */
    public javax.swing.JSpinner getSpNumero() {
        return spNumero;
    }

    /**
     * @param spNumero the spNumero to set
     */
    public void setSpNumero(javax.swing.JSpinner spNumero) {
        this.spNumero = spNumero;
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
     * @return the c
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * @param c the c to set
     */
    public void setCandidato(Candidato c) {
        this.candidato = c;
    }

    private void tratarExceptions(Exception ex) {
        if (ex instanceof ValidacaoCandidatoException) {
            if (((ValidacaoCandidatoException) ex).getTipe() == 0 || ((ValidacaoCandidatoException) ex).getTipe() == 1) {
                this.lbValidarNome.setText("O nome inserido não é valido!");
                this.lbValidarNome.setBackground(Color.RED);
                this.tfNome.selectAll();
                this.tfNome.requestFocus();
            }else{
                this.lbValidarNome.setText(null);
            }

            if (((ValidacaoCandidatoException) ex).getTipe() == 3) {
                this.lbValidarNumero.setText("Este número não é válido!");
                this.lbValidarNumero.setBackground(Color.RED);
                this.spNumero.requestFocus();
            }else{
                this.lbValidarNumero.setText(null);
            }

            if (((ValidacaoCandidatoException) ex).getTipe() == 2) {
                this.lbValidarNumero.setText("Número com mais de 4 caracteres!");
                this.lbValidarNumero.setBackground(Color.RED);
                this.spNumero.requestFocus();

            }else{
                this.lbValidarNumero.setText(null);
            }
        }
    }

    private boolean validarNumero(int numero) {
        boolean valido = false;
        try {
            for (Candidato c : gc.getTodosCandidatos()) {
                if (c.getNumero() == numero) {
                    valido = true;

                }
            }
        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
            Logger.getLogger(DialogCadastroCandidato.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }

    /**
     * @return the lbFoto
     */
    public javax.swing.JLabel getLbFoto() {
        return lbFoto;
    }

    /**
     * @param lbFoto the lbFoto to set
     */
    public void setLbFoto(javax.swing.JLabel lbFoto) {
        this.lbFoto = lbFoto;
    }

}
