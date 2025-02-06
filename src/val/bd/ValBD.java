/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package val.bd;
 import java.sql.*;

/**
 *
 * @author 20221074010022
 */
public class ValBD {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws SQLException {

        
        Connection con = null;
        
        try{
        con =new ConnectionFactory().getConnection();
        System.out.println("Conexão OK!");
        //*****CRUD*****
        
        //CREATE - inserir dados 
        String sql = "insert into customer"
                + " (store_id,first_name,last_name,email,address_id,active)"
                + " values"
                + " (?,?,?,?,?,?)";
                
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, 1);
        pst.setString(2, "Jacleany");
        pst.setString(3, "Kelly");
        pst.setString(4, "Jacleany.p@escolar.irfn.edu.br");
        pst.setInt(5, 1);
        pst.setInt(6, 1);
        
        pst.execute();
        pst.close();
       Statement st = con.createStatement();
        
       String query = "select * from customer limit 5 order by customer_id desc";
      
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData md = rs.getMetaData();
        int col = md.getColumnCount();
        
        for (int i = 1; i <= col; i++) {
            System.out.println(md.getColumnClassName(i) + "\t");
        }
        System.out.println("");
        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");

            }
            System.out.println("");
        }

        con.close();

        }catch(SQLException e){
          e.printStackTrace();
        }finally{
           con.close();  
            System.out.println("Connection closed!");
        }
       
       

        //READ - Leitura de dados
       
    }

}
