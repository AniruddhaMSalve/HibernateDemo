import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Product;

public class CRUDDemo 
{
	public static void main(String[] args) 
	{
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,1001);
		if(product==null)
		{
			System.out.println("The product does not exists");
		}
		else
		{
			Transaction transaction=session.beginTransaction();
			product.setPrice(800);
			session.saveOrUpdate(product);//to update product
			//session.delete(product);//to delete product
			transaction.commit();
			System.out.println("Product is updated successfully");
			//System.out.println("Product is deleted");
		}
	}
}
