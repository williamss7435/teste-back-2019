
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCustomer {
    
    private Connection conn = null;
  
    DAOCustomer(String host, String db, String user, String password){
    
        try {
            
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + db, user, password);
         
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
    
        }
    
    };
    
    public boolean createTableCustomer(){
        
        try {
            
            String sql = "CREATE TABLE IF NOT EXISTS `tb_customer_account` ("
                            + "`id_customer` INT NOT NULL,"
                            + "`cpf_cnpf` VARCHAR(14) NOT NULL,"
                            + "`nm_customer` VARCHAR(150) NOT NULL,"
                            + "`is_active` TINYINT NOT NULL,"
                            + "`vl_total` FLOAT NOT NULL,"
                            + "PRIMARY KEY (`id_customer`)," 
                            + "UNIQUE INDEX `idnew_table_UNIQUE` (`id_customer` ASC)," 
                            + "UNIQUE INDEX `cpf_cnpf_UNIQUE` (`cpf_cnpf` ASC)"
                    + ");";
            
            PreparedStatement stm = this.conn.prepareStatement(sql);
            stm.execute();
            
            System.out.println("Tabela Criada Com Sucesso");
            return true;
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            return false;
            
        }
        
        
    };
    
    public boolean saveCustomers( Customer [] users){
        
        try {
            
            String sql = "INSERT INTO tb_customer_account VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = this.conn.prepareStatement(sql);
            for (int i = 0; i < users.length; i++) {
                
                stm.setInt(1, users[i].getId());
                stm.setString(2, users[i].getCpf());
                stm.setString(3, users[i].getName());
                stm.setBoolean(4, users[i].IsActive());
                stm.setFloat(5, users[i].getVlTotal());
                stm.addBatch();
                
            }
        
            stm.executeBatch();
            System.out.println("Clientes Salvo Com Sucesso");
            return true;
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            return false;
            
        }
        
    };
    
    public String avereageSalary(int minId, int maxId, int minSalary){
        
        try {
            
            String sql = "SELECT * FROM tb_customer_account "
                    +    "WHERE id_customer "
                    +    "BETWEEN ? AND ? AND vl_total > ? "
                    +    "ORDER BY vl_total DESC;";
            
            PreparedStatement stm = this.conn.prepareStatement(sql);
            stm.setInt(1, minId);
            stm.setInt(2, maxId);
            stm.setInt(3, minSalary);
            
            ResultSet results = stm.executeQuery();
            
            int totalUser = 0;
            float sumSalary = 0;
            String response = "";
            String customers = "";
            
            while (results.next()) {
                
                customers += "Nome: " + results.getString("nm_customer") + " / Salário: R$ " + results.getFloat("vl_total") + "\n";
                sumSalary += results.getFloat("vl_total");
                totalUser++;
                
            }
            response += "Média de Salário: " + (sumSalary/totalUser) + " / Total De Clientes: " + totalUser + "\n" + customers;
            return response;
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        
    }
    
}
