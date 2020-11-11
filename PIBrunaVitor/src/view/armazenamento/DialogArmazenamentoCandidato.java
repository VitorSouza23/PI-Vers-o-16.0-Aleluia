/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.armazenamento;

import view.Principal;
import view.armazenamento.tabelaArmazenamentoConfig.CandidatoColumnModel;
import view.armazenamento.tabelaArmazenamentoConfig.CandidatoTableModel;
import view.cadastros.DialogCadastroCandidato;
import conexao.exceptions.ConnectionException;
import conexao.exceptions.SQLStatementException;
import contreller.DAO.GerenciadorCandidato;
import contreller.DAO.GerenciadorEleicao;
import excecaoEleitor.MatriculaException;
import excecaoEleitor.NomeException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.Candidato;
import model.Eleicao;
import model.exceptions.ValidacaoCandidatoException;
import model.exceptions.ValidarCursoException;
import model.exceptions.ValidarEleicaoException;
import model.exceptions.ValidarEmailException;

/**
 *
 * @author Aluno
 */
public class DialogArmazenamentoCandidato extends javax.swing.JDialog {

    GerenciadorCandidato gc = new GerenciadorCandidato();
    GerenciadorEleicao ge = new GerenciadorEleicao();
    Candidato c;

    /**
     * Creates new form DialogArmazenamentoCandidato
     */
    public DialogArmazenamentoCandidato(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inserirDadosTabela();
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

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCandidatosCadastrados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btMaisCandidatos = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNomeFiltrado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfFiltroNumero = new javax.swing.JTextField();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Candidatos Cadastrados");
        setIconImages(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Candidatos Cadastrados ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        tCandidatosCadastrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número", "Nome", "Foto"
            }
        ));
        tCandidatosCadastrados.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tCandidatosCadastrados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tCandidatosCadastradosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tCandidatosCadastrados);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btMaisCandidatos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btMaisCandidatos.setForeground(new java.awt.Color(0, 102, 0));
        btMaisCandidatos.setText("+ Candidato");
        btMaisCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMaisCandidatosActionPerformed(evt);
            }
        });
        jPanel2.add(btMaisCandidatos);

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(255, 0, 0));
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btExcluir);

        btPesquisar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(btPesquisar);

        btCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);

        btFechar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btFechar.setForeground(new java.awt.Color(0, 0, 204));
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        jPanel2.add(btFechar);

        jLabel1.setText("Filtro:");

        jLabel2.setText("Nome:");

        tfNomeFiltrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNomeFiltradoKeyReleased(evt);
            }
        });

        jLabel3.setText("Número:");

        tfFiltroNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroNumeroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfNomeFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfFiltroNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfNomeFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(tfFiltroNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMaisCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMaisCandidatosActionPerformed
        DialogCadastroCandidato dcc = new DialogCadastroCandidato(null, rootPaneCheckingEnabled);
        dcc.setVisible(true);
    }//GEN-LAST:event_btMaisCandidatosActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed

        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        boolean cadastradoEmEleicao = false;
        try {
            c = gc.getTodosCandidatos().get(tCandidatosCadastrados.getSelectedRow());
            for (Eleicao eleicao : ge.getTodosEleicoes()) {
                if (ge.isContemCandidato(c.getIdCandidato(), eleicao.getId())) {
                    cadastradoEmEleicao = true;
                }
            }

            if (cadastradoEmEleicao) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir o candidato, ele está cadastrado em uma Eleição no momento. \n"
                        + "Exclua a Eleição para depois esxcluir o candidato selecionado.", "Candidato cadastrado em Eleição!", JOptionPane.WARNING_MESSAGE);
                
            } else {

                int opc = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente remover o Candidato?", "Excluir...", JOptionPane.YES_NO_OPTION);
                if (opc == 0) {
                    gc.remover(c);
                    CandidatoTableConfig(gc.getTodosCandidatos());
                }
            }

        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException | ValidarEleicaoException | ValidarCursoException  |
                ValidarEmailException | NomeException | MatriculaException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btExcluirActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        c = new Candidato();
        int pesquisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Candidato a ser pesquisado:"));
        try {
            if (gc.getCandidato(pesquisa) != null) {
                c = gc.getCandidato(pesquisa);
                int index = gc.getTodosCandidatos().indexOf(c);
                tCandidatosCadastrados.setRowSelectionInterval(index, index);
            }
        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tCandidatosCadastradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCandidatosCadastradosMouseClicked
        if (evt.getClickCount() == 2) {
            DialogCadastroCandidato dcc = new DialogCadastroCandidato(null, rootPaneCheckingEnabled);
            try {

                dcc.setCandidato(gc.getTodosCandidatos().get(tCandidatosCadastrados.getSelectedRow()));
                dcc.getTfNome().setText(dcc.getCandidato().getNome());
                dcc.getSpNumero().setValue(dcc.getCandidato().getNumero());
                //definir a foto.
                dcc.setVisible(true);
            } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tCandidatosCadastradosMouseClicked

    private void tfNomeFiltradoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeFiltradoKeyReleased
        try {
            if (this.tfFiltroNumero.getText().isEmpty()) {
                setCandidatoDataList(gc.getTodosCandidatos(this.tfNomeFiltrado.getText()));
            } else {
                setCandidatoDataList(gc.getTodosCandidatos(Integer.parseInt(this.tfFiltroNumero.getText()), this.tfNomeFiltrado.getText()));
            }

        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tfNomeFiltradoKeyReleased

    private void tfFiltroNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroNumeroKeyReleased
        try {
            if ((!this.tfFiltroNumero.getText().isEmpty())) {
                if (this.tfNomeFiltrado.getText().isEmpty()) {
                    setCandidatoDataList(gc.getTodosCandidatos(Integer.parseInt(this.tfFiltroNumero.getText())));
                } else {
                    setCandidatoDataList(gc.getTodosCandidatos(Integer.parseInt(this.tfFiltroNumero.getText()), this.tfNomeFiltrado.getText()));
                }
            } else {
                setCandidatoDataList(gc.getTodosCandidatos());
            }

        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tfFiltroNumeroKeyReleased

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.tfFiltroNumero.setText(null);
        this.tfNomeFiltrado.setText(null);
        try {
            setCandidatoDataList(gc.getTodosCandidatos());
        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing
    private static void CandidatoTableConfig(ArrayList<Candidato> list) {
        DialogArmazenamentoCandidato.setCandidatoDataList(list);
        DialogArmazenamentoCandidato.tCandidatosCadastrados.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = DialogArmazenamentoCandidato.tCandidatosCadastrados.getFontMetrics(DialogArmazenamentoCandidato.tCandidatosCadastrados.getFont());
        DialogArmazenamentoCandidato.tCandidatosCadastrados.setColumnModel(new CandidatoColumnModel(fm));
        DialogArmazenamentoCandidato.tCandidatosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DialogArmazenamentoCandidato.tCandidatosCadastrados.setRowHeight(150);
    }

    public static void setCandidatoDataList(java.util.List<Candidato> list) {
        DialogArmazenamentoCandidato.tCandidatosCadastrados.setModel(new CandidatoTableModel(list));
        DialogArmazenamentoCandidato.tCandidatosCadastrados.setRowHeight(150);
    }

    private void inserirDadosTabela() {
        try {
            if (!gc.getTodosCandidatos().isEmpty()) {
                CandidatoTableConfig(gc.getTodosCandidatos());
            }
        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btMaisCandidatos;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tCandidatosCadastrados;
    private javax.swing.JTextField tfFiltroNumero;
    private javax.swing.JTextField tfNomeFiltrado;
    // End of variables declaration//GEN-END:variables
}
