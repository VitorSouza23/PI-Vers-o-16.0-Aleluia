/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.selecao;

import conexao.Conexao;
import conexao.exceptions.ConnectionException;
import conexao.exceptions.SQLStatementException;
import excecaoEleitor.NomeException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Fiscal;
import model.exceptions.ValidarEmailException;

/**
 *
 * @author Aluno
 */
public class GerenciadorSelecaoFiscal implements interfaces.IGerenciadorDeFiscal{
    @Override
    public void inserir(Fiscal fiscal) throws SQLStatementException, ConnectionException, NomeException{
        String sql = "INSERT INTO  SELECAOFISCAL (fiscal_idFiscal) "
                +" VALUES (?);";
        
        try{
             PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
             ps.setInt(1, fiscal.getId());
             ps.executeUpdate();   
    }catch(SQLException e){
        throw new SQLStatementException("Erro na instrução SQL: \n"
                    + "[" + sql + "]\n" + e.getMessage(), e.getCause());
    }
        
    }
    @Deprecated
    @Override
     public void atualizar(Fiscal fiscal) throws SQLStatementException, ConnectionException, NomeException{
        throw new UnsupportedOperationException("Método não utilizável");
    }
    @Override
     public void remover(Fiscal fiscal) throws SQLStatementException, ConnectionException, NomeException {
        String sql = "DELETE FROM SELECAOFISCAL WHERE fiscal_idFiscal = ?";
        try {
            java.sql.PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, fiscal.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLStatementException("Erro na instrução SQL: \n"
                    + "[" + sql + "]\n" + ex.getMessage(), ex.getCause());
        }
    }
      private ArrayList<Fiscal> resultSetParaList(ResultSet rs) throws SQLException, NomeException, ValidarEmailException {
        ArrayList<Fiscal> lista = new ArrayList<>();
        try {
            while (rs.next()) {
               Fiscal f = transformarResultSetEmObjeto(rs);
                lista.add(f);
            }
        } catch (SQLException ex) {
            throw new SQLException("Campos inexistentes da tabela de banco de dados.\n"
                    + "Msg: " + ex.getMessage(), ex.getCause());
        }
        return lista;
    }
    
    private Fiscal transformarResultSetEmObjeto(ResultSet rs) throws SQLException, NomeException, ValidarEmailException {
        Fiscal f = new Fiscal();
        try {
            f.setId(rs.getInt("IDFISCAL"));
            f.setNome(rs.getString("NOME"));
            f.setEmail(rs.getString("EMAIL"));
            f.setTelefone(rs.getString("TELEFONE"));
            f.setEndereco(rs.getString("ENDERECO"));
        } catch (SQLException ex) {
            throw new SQLException("Campos inexistentes da tabela de banco de dados.\n"
                    + "Msg: " + ex.getMessage(), ex.getCause());
        }
        return f;
    }
    @Override
     public ArrayList<Fiscal> obterTodos() throws SQLStatementException, ConnectionException, NomeException, SQLException, ValidarEmailException {
        String sql = "SELECT * FROM SELECAOFISCAL sf, FISCAL f WHERE sf.fiscal_idFiscal = f.idFiscal;";
        ResultSet rs = null;
        try {
            java.sql.PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            throw new SQLStatementException("Erro na instrução sql: " + sql + ".\n"
                    + "Msg.: " + ex.getMessage(), ex.getCause());
        }
        return resultSetParaList(rs);
    }
    @Override
     public Fiscal obterFiscal(String nome) throws ConnectionException, NomeException,SQLStatementException, ValidarEmailException {
        String sql = "SELECT * FROM SELECAOFISCAL sf, FISCAL f WHERE (sf.fiscal_idFiscal = f.idFiscal) and (f.nome);";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Fiscal f = transformarResultSetEmObjeto(rs);
                return f;
            } else {
                throw new SQLException("Não há Fiscal com este Nome.\n");
            }
        } catch (SQLException ex) {
            throw new SQLStatementException("Erro na instrução sql: " + sql + ".\n"
                    + "Msg.: " + ex.getMessage(), ex.getCause());
        }
    }
     public void removerTodos() throws SQLStatementException, ConnectionException, NomeException {
        String sql = "DELETE FROM SELECAOFISCAL WHERE IDSELECAOFISCAL >= 0";
        try {
            java.sql.PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLStatementException("Erro na instrução SQL: \n"
                    + "[" + sql + "]\n" + ex.getMessage(), ex.getCause());
        }
    }
     
     public ArrayList<Fiscal> obterTodos(int idFiscal) throws SQLStatementException, ConnectionException, NomeException, SQLException, ValidarEmailException {
        String sql = "SELECT * FROM SELECAOFISCAL sf, FISCAL f WHERE sf.fiscal_idFiscal = f.idFiscal and idFiscal = ?;";
        ResultSet rs = null;
        try {
            java.sql.PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idFiscal);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            throw new SQLStatementException("Erro na instrução sql: " + sql + ".\n"
                    + "Msg.: " + ex.getMessage(), ex.getCause());
        }
        return resultSetParaList(rs);
    }
     
}
