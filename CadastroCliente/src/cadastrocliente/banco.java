
package cadastrocliente;

import java.sql.*;
import javax.swing.JOptionPane;

public class banco{
    public Connection conectarAoBanco(){
        try{
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/vendapdv?useTimezone=true&serverTimezone=UTC","root","123456");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erro"+ e);
        }
        return null;
    }
}
