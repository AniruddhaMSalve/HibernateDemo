
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.Product;

public class CriteriaDemo 
{

	public static void main(String[] args) 
	{
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		Query query=session.createQuery("from Product");
		criteria.add(Restrictions.between("price",400,600));
		List<Product> listProducts=criteria.list();
		for(Product product:listProducts)
		{
			System.out.println(product.getProductId()+":::");
			System.out.println(product.getProductName()+":::");
			System.out.println(product.getPrice()+":::");
			System.out.println(product.getProductDesc()+":::");
		}
		session.close();
}
}