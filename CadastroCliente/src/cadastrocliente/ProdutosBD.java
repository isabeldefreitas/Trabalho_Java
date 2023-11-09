package cadastrocliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ProdutosBD {
    private Connection conexao;
    
    public ProdutosBD() {
        conexao = new banco().conectarAoBanco();  
    }
    
    private void editarBanco(String sql, Produto p, int func){
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getUnidade());
            stmt.setFloat(4, p.getPreco());
            stmt.setInt(5, p.getQuantidade());
            stmt.setString(6, p.getData());
            if (func == 2)
                stmt.setString(7, p.getCodigo());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void adicionarProduto (Produto p){
        String insert = "insert into vendapdv.produto(codigo, nome, unidade, preco, quantidade, data) values (?,?,?,?,?,?)";
        editarBanco(insert, p, 1);
        JOptionPane.showMessageDialog(null, "Produto adicionado!");
    }
    
    public void alterarProduto (Produto p){
        String update = "update vendapdv.produto set codigo = ?, nome = ?,  unidade = ?, preco = ?, quantidade = ?, data = ? where codigo = ?";
        editarBanco(update, p, 2);
        JOptionPane.showMessageDialog(null, "Produto alterado!");
    }
    
    public void excluirProduto(String codigo){
        try {
            String delete = "delete from vendapdv.produto where codigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(delete);
            stmt.setString(1, codigo);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto excluido!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);   
        } 
    }
    
    public ArrayList<Produto>lerBancoProdutos(){
        try {
            ArrayList<Produto> lista = new ArrayList<>();
            String select = "select * from vendapdv.produto";
            PreparedStatement stmt = conexao.prepareStatement(select);             
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto p = new Produto();
                p.setCodigo(rs.getString("codigo"));
                p.setNome(rs.getString("nome"));
                p.setUnidade(rs.getString("unidade"));
                p.setPreco(rs.getFloat("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setData(rs.getString("data"));
                lista.add(p);
            }
            return lista;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public String buscaNome(String codigo){
        try {
            String nome = null;
            String select = "select nome FROM vendapdv.produto WHERE codigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(select);
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                nome = rs.getString("nome");
            }
            return nome;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    } 
    
    public String buscaPreco(String codigo){
        try {
            String preco = null;
            String select = "select preco FROM vendapdv.produto WHERE codigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(select);
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                preco = rs.getString("preco");
            }
            return preco;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void atualizarProduto(String codigo, String qtd, String data){
        try {
            String preco = null;
            String update = "update produto set vendapdv.quantidade = quantidade - ?, data = ? where codigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(update);
            stmt.setString(1, qtd);
            stmt.setString(2, data);
            stmt.setString(3, codigo);
            stmt.execute();
            stmt.close(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
