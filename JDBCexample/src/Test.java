import java.sql.SQLException;
import com.johnbryce.beans.User;
import com.johnbryce.dbdao.UserDBDAO;
import com.johnbryce.utils.ConnectionPool;
import com.johnbryce.utils.Database;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		System.out.println("START");
		// ConnectionPool.getInstance();
		// STEP 1 - Loading JDBC Driver - Of MySQL
		Class.forName("com.mysql.cj.jdbc.Driver");
		UserDBDAO myUserDBDAO = new UserDBDAO();
		Database.createTableUsers();

		User u1 = new User(1, "Shasha", "Yaakov");
		User u2 = new User(2, "Cohen", "Rinat");
		User u3 = new User(3, "Cohen", "Rina");
//		User u4 = new User(4, "Moshe", null);

		myUserDBDAO.insertUser(u1);
		myUserDBDAO.insertUser(u2);
		u1.setFirst("Kobi");
		myUserDBDAO.updateUser(1, u1);

		myUserDBDAO.insertUser(u3);

		System.out.println(myUserDBDAO.getAllUsers());

		myUserDBDAO.deleteUser(3);

		System.out.println(myUserDBDAO.getAllUsers());

		ConnectionPool.getInstance().closeAllConnection();
		System.out.println("END");

	}
}
