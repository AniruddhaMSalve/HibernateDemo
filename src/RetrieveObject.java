import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Product;

public class RetrieveObject 
{
	public static void main(String[] args) 
	{
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Product product=(Product)session.load(Product.class,1001);
		System.out.println("Product Id"+product.getProductId());
		System.out.println("Product Name"+product.getProductName());
		session.close();
	}
}
//here as 1010 product id is not found an Exception is thrown---ObjectNotFoundException