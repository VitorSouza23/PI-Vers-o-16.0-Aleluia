/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.selecao;

import view.Principal;
import view.armazenamento.DialogArmazenamentoEleitor;
import view.selecao.configTabelaSelecao.FiscalSelecionadoColumnModel;
import view.selecao.configTabelaSelecao.FiscalSelecionadoTableModel;
import view.armazenamento.tabelaArmazenamentoConfig.FiscalTableModel;
import view.cadastros.DialogCadastroDeEleicao;
import conexao.exceptions.ConnectionException;
import conexao.exceptions.SQLStatementException;
import excecaoEleitor.NomeException;
import contreller.DAO.GerenciadorDeFiscal;
import controller.selecao.GerenciadorSelecaoFiscal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.Fiscal;
import model.exceptions.ValidarEmailException;

/**
 *
 * @author Aluno
 */
public class DialogSelecionarFiscal extends javax.swing.JDialog {

    private GerenciadorDeFiscal gf = new GerenciadorDeFiscal();
    private GerenciadorSelecaoFiscal gsf = new GerenciadorSelecaoFiscal();
    private Fiscal f;

    /**
     * Creates new form DialogSelecionarFiscal
     */
    public DialogSelecionarFiscal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarTabela();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tFiscal = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btConcluido = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tfFiltroNome = new javax.swing.JTextField();
        chbSelecionarTodos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Selecionar Fiscal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        jLabel1.setText("Filtros:");

        jLabel2.setText("Nome:");

        tFiscal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Email", "Telefone", "Endereço"
            }
        ));
        tFiscal.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(tFiscal);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btConcluido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btConcluido.setForeground(new java.awt.Color(0, 102, 0));
        btConcluido.setText("Concluído");
        btConcluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConcluidoActionPerformed(evt);
            }
        });
        jPanel2.add(btConcluido);

        btCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(0, 0, 204));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);

        tfFiltroNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroNomeKeyReleased(evt);
            }
        });

        chbSelecionarTodos.setBackground(new java.awt.Color(204, 255, 204));
        chbSelecionarTodos.setText("Selecionar todos");
        chbSelecionarTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbSelecionarTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chbSelecionarTodos)
                        .addGap(60, 60, 60))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbSelecionarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
        Principal p = new Principal();
        p.setVisible(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConcluidoActionPerformed
        try {
            if (gf.obterTodos().size() > 0) {
                for (int x = 0; x < gf.obterTodos().size(); x++) {
                    if ((boolean) tFiscal.getValueAt(x, 4) == true) {
                        f = new Fiscal();
                        f = gf.obterTodos().get(x);

                        gsf.inserir(f);
                        DialogCadastroDeEleicao.setFiscalDataList(gsf.obterTodos());
                    }
                }
                this.dispose();
            }
        } catch (SQLStatementException | ConnectionException | NomeException | SQLException | ValidarEmailException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btConcluidoActionPerformed

    private void tfFiltroNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroNomeKeyReleased
        try {
            setListaFiscal(gf.obterTodos(this.tfFiltroNome.getText()));
        } catch (SQLStatementException | ConnectionException | NomeException | SQLException | ValidarEmailException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tfFiltroNomeKeyReleased

    private void chbSelecionarTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbSelecionarTodosItemStateChanged
        if (this.chbSelecionarTodos.isSelected()) {
            try {
                for (int x = 0; x < gf.obterTodos().size(); x++) {
                    tFiscal.setValueAt(true, x, 4);

                }

            } catch (ConnectionException | SQLStatementException | NomeException | SQLException | ValidarEmailException ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                for (int x = 0; x < gf.obterTodos().size(); x++) {
                    tFiscal.setValueAt(false, x, 4);

                }

            } catch (ConnectionException | SQLStatementException | NomeException | SQLException | ValidarEmailException ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_chbSelecionarTodosItemStateChanged

    public void setListaFiscal(java.util.List<Fiscal> listaDados) {
        this.tFiscal.setModel(new FiscalSelecionadoTableModel(listaDados));
    }

    private void configurarTabela() {
        try {
            this.setListaFiscal(gf.obterTodos());
        } catch (ConnectionException | SQLStatementException | SQLException | NomeException | ValidarEmailException ex) {
            Logger.getLogger(DialogArmazenamentoEleitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        tFiscal.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = tFiscal.getFontMetrics(tFiscal.getFont());
        tFiscal.setColumnModel(new FiscalSelecionadoColumnModel(fm));
        tFiscal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public Fiscal getFiscalSelecionado() {
        return ((FiscalTableModel) tFiscal.getModel()).getObjetoSelecionado(
                tFiscal.getSelectedRow());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConcluido;
    private javax.swing.JCheckBox chbSelecionarTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tFiscal;
    private javax.swing.JTextField tfFiltroNome;
    // End of variables declaration//GEN-END:variables
}