import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class HibernateUtil 
{
	public static void main(String[] args)
	{
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		com.Product product=new com.Product();
		product.setProductId(1001);
		product.setPrice(500);
		product.setProductName("Arduino");
		product.setProductDesc("Processor");
		Transaction transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
		System.out.println("Object successfully saved");
	}
}//CREATE TABLE PRODUCT(PRODUCTID INT, PRODUCTNAME VARCHAR, PRODUCTDESC VARCHAR, PRICE INT );