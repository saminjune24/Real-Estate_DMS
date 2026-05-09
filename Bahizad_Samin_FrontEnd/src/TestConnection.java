import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionString= 
				"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
		try {
			try(Connection connection = DriverManager.getConnection(connectionString)){
				System.out.println("Connection established.");
			}
		}
		catch(SQLException e) {
			System.out.println("Error connection to the database");
			e.printStackTrace();
			
		}
	}

}
