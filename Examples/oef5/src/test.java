import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();



        session.beginTransaction();

        User firstTest = new User();
        firstTest.setFirstname("firstname");
        firstTest.setLastname("lastname");
        firstTest.setGemeente("gemeente");
        firstTest.setNummer("nummer");
        firstTest.setPostcode("postcode");
        firstTest.setStraat("straat");
        
        session.save(firstTest);



        session.getTransaction().commit();

        //session.close();

        //HibernateUtil.getSessionFactory().close();
	}


}
