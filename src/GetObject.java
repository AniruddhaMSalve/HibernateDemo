import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Product;

public class GetObject 
{
	public static void main(String[] args) 
	{
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,1001);//if the object is not there then null is returned
		System.out.println("Product Id"+product.getProductId());
		System.out.println("Product Name"+product.getProductName());
		session.close();
	}
}