/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.gerenciamento;

import view.Principal;
import view.cadastros.DialogCadastroDeEleicao;
import view.gerenciamento.tabelaConfig.EleicaoColumnModel;
import view.gerenciamento.tabelaConfig.EleicaoTableModel;
import conexao.exceptions.ConnectionException;
import conexao.exceptions.SQLStatementException;
import contreller.DAO.GerenciadorEleicao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.Eleicao;
import model.exceptions.ValidacaoCandidatoException;
import model.exceptions.ValidarCursoException;
import model.exceptions.ValidarEleicaoException;
import model.exceptions.ValidarEmailException;

/**
 *
 * @author Bruna Branco
 */
public class FrmGerenciadorEleicao extends javax.swing.JFrame {

    private GerenciadorEleicao ge = new GerenciadorEleicao();

    /**
     * Creates new form FrmGerenciadorEleicao
     */
    public FrmGerenciadorEleicao() {
        initComponents();
        try {
            if (ge.getTodosEleicoes() != null) {
                EleicaoTableConfig(ge.getTodosEleicoes());
            } else {
                EleicaoTableConfig(new ArrayList<Eleicao>());
            }

        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException | ValidarEleicaoException | ValidarEmailException | ValidarCursoException  ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        this.setLocationRelativeTo(null);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tEleicoes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btNovaEleicao = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Eleição");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gerenciador de Eleição", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        tEleicoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Eleição", "Data Inicial", "Data Final", "Situação"
            }
        ));
        tEleicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tEleicoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tEleicoes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btNovaEleicao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btNovaEleicao.setForeground(new java.awt.Color(0, 153, 0));
        btNovaEleicao.setText("Nova Eleição ");
        btNovaEleicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaEleicaoActionPerformed(evt);
            }
        });
        jPanel2.add(btNovaEleicao);

        Excluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Excluir.setForeground(new java.awt.Color(204, 0, 0));
        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(Excluir);

        btFechar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovaEleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaEleicaoActionPerformed
        DialogCadastroDeEleicao ce = new DialogCadastroDeEleicao(this, rootPaneCheckingEnabled);
        ce.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btNovaEleicaoActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void tEleicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEleicoesMouseClicked
        VerificarDadosEleicao vde = new VerificarDadosEleicao();
        try {
            if (evt.getClickCount() == 2) {
                Eleicao e = ge.getTodosEleicoes().get(tEleicoes.getSelectedRow());

                
                vde.getTfNome().setText(e.getNome());
                vde.getDcHoraFinal().setDate(new Date(e.getDataHoraInico()));
                vde.getDcHoraInicial().setDate(new Date(e.getDataHoraInico()));
                DefaultComboBoxModel<String> listaTipoElelicao = new DefaultComboBoxModel<>();
                listaTipoElelicao.addElement(e.getTipoEleicao());
                vde.getCbTipoEleicao().setModel(listaTipoElelicao);
                VerificarDadosEleicao.EleitorTableConfig(e.getListaEleitor());
                VerificarDadosEleicao.FiscalTableConfig(e.getListaFiscal());
                VerificarDadosEleicao.CandidatoTableConfig(e.getListaCandidato());
                vde.setVisible(true);
            }

        } catch (ConnectionException | SQLStatementException | ValidacaoCandidatoException | ValidarEleicaoException | ValidarEmailException | SQLException | ValidarCursoException  ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        } 


    }//GEN-LAST:event_tEleicoesMouseClicked

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        int opc = JOptionPane.showConfirmDialog(rootPane, "Realmente deseja excluir esta eleição? \n"
                + "Lembre-se gerar o relatório da eleição antes de excluí-la!", "Excluir Eleicao", JOptionPane.YES_NO_OPTION);
        if(opc == 0){
            try {
                if(!ge.getTodosEleicoes().get(tEleicoes.getSelectedRow()).isSituacao()){
                    ge.remover(ge.getTodosEleicoes().get(tEleicoes.getSelectedRow()));
                    setEleicaoDataList(ge.getTodosEleicoes());
                }else{
                    JOptionPane.showMessageDialog(this, "Não é possível excluir eleições que não foram encerradas!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                }
            } catch (    ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException | ValidarEleicaoException | ValidarEmailException  | ValidarCursoException ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void EleicaoTableConfig(ArrayList<Eleicao> list) {
        setEleicaoDataList(list);
        tEleicoes.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = tEleicoes.getFontMetrics(tEleicoes.getFont());
        tEleicoes.setColumnModel(new EleicaoColumnModel(fm));
        tEleicoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public static void setEleicaoDataList(java.util.List<Eleicao> list) {
        tEleicoes.setModel(new EleicaoTableModel(list));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Excluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovaEleicao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tEleicoes;
    // End of variables declaration//GEN-END:variables
}
