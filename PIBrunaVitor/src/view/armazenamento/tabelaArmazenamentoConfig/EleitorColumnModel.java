/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.armazenamento.tabelaArmazenamentoConfig;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * 
 */

    public class EleitorColumnModel extends DefaultTableColumnModel {

        private TableColumn criaColuna(int columnIndex, int largura,
                FontMetrics fm, boolean resizeable, String titulo) {
            int larguraTitulo = fm.stringWidth(titulo + " ");
            if (largura < larguraTitulo) {
                largura = larguraTitulo;
            }
            TableColumn col = new TableColumn(columnIndex);
            col.setHeaderRenderer(null);
            col.setHeaderValue(titulo);
            col.setPreferredWidth(largura);
            if (!resizeable) {
                col.setMaxWidth(largura);
                col.setMinWidth(largura);
            }
            col.setResizable(resizeable);
            return col;
        }

        
        public EleitorColumnModel(FontMetrics fm) {
            int digito = fm.stringWidth("0");
            int letra = fm.stringWidth("M");
            addColumn(criaColuna(0, 40 * letra, fm, true, "Nome"));
            addColumn(criaColuna(1, 10 * digito, fm, false, "Matricula"));
            addColumn(criaColuna(2, 20 * letra, fm, true, "Email"));
            addColumn(criaColuna(3, 30 * letra, fm, true, "Curso"));
            
        }
    }
