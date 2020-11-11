/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.selecao;

import view.cadastros.DialogCadastroDeEleicao;
import view.selecao.configTabelaSelecao.CandidatoSelecaoColumnModel;
import view.selecao.configTabelaSelecao.CandidatoSelecaoTableModel;
import conexao.exceptions.ConnectionException;
import conexao.exceptions.SQLStatementException;
import contreller.DAO.GerenciadorCandidato;
import contreller.DAO.GerenciadorEleicao;
import controller.selecao.GerenciadorSelecaoCandidato;
import excecaoEleitor.MatriculaException;
import excecaoEleitor.NomeException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.Candidato;
import model.exceptions.ValidacaoCandidatoException;
import model.exceptions.ValidarEmailException;


/**
 *
 * @author Aluno
 */
public class DialogSelecionarCandidato extends javax.swing.JDialog {

    GerenciadorCandidato gc = new GerenciadorCandidato();
    GerenciadorSelecaoCandidato gsc = new GerenciadorSelecaoCandidato();
    GerenciadorEleicao ge = new GerenciadorEleicao();
    Candidato c;
    ArrayList<Candidato> listaCandidato = new ArrayList<>();

    /**
     * Creates new form DialogSelecionarCandidato
     *
     * @param parent
     * @param modal
     */
    public DialogSelecionarCandidato(java.awt.Frame parent, boolean modal) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCandidatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btConcluido = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tfFiltrarNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfFiltroNumero = new javax.swing.JTextField();
        chbSelecionarTodos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Candidatos");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Selecionar Candidatos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        jLabel1.setText("Filtros:");

        jLabel2.setText("Nome:");

        tCandidatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tCandidatos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tCandidatos);

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

        tfFiltrarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltrarNomeKeyReleased(evt);
            }
        });

        jLabel3.setText("Número:");

        tfFiltroNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroNumeroKeyReleased(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tfFiltroNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 434, Short.MAX_VALUE)
                .addComponent(chbSelecionarTodos)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfFiltroNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chbSelecionarTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConcluidoActionPerformed

        try {
            if (listaCandidato.isEmpty()) {
                if (gc.getTodosCandidatos().size() > 0) {
                    for (int x = 0; x < gc.getTodosCandidatos().size(); x++) {
                        if ((boolean) tCandidatos.getValueAt(x, 3) == true) {

                            c = gc.getTodosCandidatos().get(x);

                            gsc.salvar(c);
                            DialogCadastroDeEleicao.setCandidatoDataList(gsc.getTodosCandidatos());
                        }
                        this.dispose();
                    }

                }
            } else {
                for (int x = 0; x < listaCandidato.size(); x++) {
                    if ((boolean) tCandidatos.getValueAt(x, 3) == true) {

                        c = listaCandidato.get(x);

                        gsc.salvar(c);
                        DialogCadastroDeEleicao.setCandidatoDataList(gsc.getTodosCandidatos());
                    }
                    this.dispose();
                }
            }
        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }



    }//GEN-LAST:event_btConcluidoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfFiltrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltrarNomeKeyReleased
        ArrayList<Candidato> listaFiltroNome = new ArrayList<>();
        
        try {
            if (!this.tfFiltrarNome.getText().isEmpty()) {
                if (this.tfFiltroNumero.getText().isEmpty()) {
                    for(Candidato candidato : gc.getTodosCandidatos(this.tfFiltrarNome.getText())){
                        if(!ge.isContemCandidato(candidato.getIdCandidato())){
                            listaFiltroNome.add(candidato);
                        }
                    }
                    setCandidatoDataList(listaFiltroNome);
                    listaCandidato = listaFiltroNome;
                    
                } else {
                   for(Candidato candidato : gc.getTodosCandidatos(Integer.parseInt(this.tfFiltroNumero.getText()), this.tfFiltrarNome.getText())){
                       if(!ge.isContemCandidato(candidato.getIdCandidato())){
                            listaFiltroNome.add(candidato);
                        }
                        
                    }
                    setCandidatoDataList(listaFiltroNome);
                    listaCandidato = listaFiltroNome;
                   
                }
            } else {
                listaCandidato =  gc.getTodosCandidatos();
                setCandidatoDataList(listaCandidato);
                
            }

        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException | NomeException | MatriculaException | ValidarEmailException  ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_tfFiltrarNomeKeyReleased

    private void tfFiltroNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroNumeroKeyReleased

        try {
            if ((!this.tfFiltroNumero.getText().isEmpty())) {
                if (this.tfFiltrarNome.getText().isEmpty()) {
                    for(Candidato candidato : gc.getTodosCandidatos(Integer.parseInt(this.tfFiltroNumero.getText()))){
                        if(!ge.isContemCandidato(candidato.getIdCandidato())){
                            listaCandidato.add(candidato);
                        }
                        
                    }
                    setCandidatoDataList(listaCandidato);
                     
                } else {
                   for(Candidato candidato : gc.getTodosCandidatos(Integer.parseInt(this.tfFiltroNumero.getText()), this.tfFiltrarNome.getText())){
                       if(!ge.isContemCandidato(candidato.getIdCandidato())){
                            listaCandidato.add(candidato);
                        }
                        
                    }
                    setCandidatoDataList(listaCandidato);
                   
                }
            } else {
                setCandidatoDataList(listaCandidato);
                
            }

        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException | NomeException | MatriculaException | ValidarEmailException  ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);

        } 
    }//GEN-LAST:event_tfFiltroNumeroKeyReleased

    private void chbSelecionarTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbSelecionarTodosItemStateChanged
        if (listaCandidato.isEmpty()) {
            try {
                if(!gc.getTodosCandidatos().isEmpty()){
                this.selecionarTodos(gc.getTodosCandidatos());
                }
            } catch (    ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            this.selecionarTodos(listaCandidato);
        }

    }//GEN-LAST:event_chbSelecionarTodosItemStateChanged
    private void CandidatoTableConfig(ArrayList<Candidato> list) {
        this.setCandidatoDataList(list);
        this.tCandidatos.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = this.tCandidatos.getFontMetrics(this.tCandidatos.getFont());
        this.tCandidatos.setColumnModel(new CandidatoSelecaoColumnModel(fm));
        this.tCandidatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tCandidatos.setRowHeight(150);
    }

    public void setCandidatoDataList(java.util.List<Candidato> list) {
        this.tCandidatos.setModel(new CandidatoSelecaoTableModel(list));
    }

    private void inserirDadosTabela() {

        try {
            if (!gc.getTodosCandidatos().isEmpty()) {
                for (Candidato c : gc.getTodosCandidatos()) {
                    if (!ge.isContemCandidato(c.getIdCandidato())) {
                        listaCandidato.add(c);
                    }
                }
                CandidatoTableConfig(listaCandidato);
            }
        } catch (ConnectionException | SQLStatementException | SQLException | ValidacaoCandidatoException | NomeException | MatriculaException | ValidarEmailException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void selecionarTodos(ArrayList<Candidato>  listaSelecionarTodos){
        if (this.chbSelecionarTodos.isSelected()) {
                    for (int x = 0; x < listaSelecionarTodos.size(); x++) {
                        tCandidatos.setValueAt(true, x, 3);

                    }
            } else {
                
                    for (int x = 0; x < listaSelecionarTodos.size(); x++) {
                        tCandidatos.setValueAt(false, x, 3);

                    }
            }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConcluido;
    private javax.swing.JCheckBox chbSelecionarTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tCandidatos;
    private javax.swing.JTextField tfFiltrarNome;
    private javax.swing.JTextField tfFiltroNumero;
    // End of variables declaration//GEN-END:variables
}
