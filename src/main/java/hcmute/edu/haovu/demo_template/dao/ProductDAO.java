package hcmute.edu.haovu.demo_template.dao;

import hcmute.edu.haovu.demo_template.entities.ProductEntity;
import hcmute.edu.haovu.demo_template.util.ConnectionUtil;
import hcmute.edu.haovu.demo_template.util.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {

  private final static SessionFactory factory = HibernateUtility.getSessionFactory();
  private Connection conn = null;
  private PreparedStatement ps = null;
  protected ResultSet rs = null;

  public List<ProductEntity> getAllProduct() {
    List<ProductEntity> products = new ArrayList<>();
    String sql = "SELECT * FROM product ";
    try {
      conn = ConnectionUtil.getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        ProductEntity product = new ProductEntity();

        product.setId(rs.getLong("id"));
        product.setTitle(rs.getString("title"));
        product.setPrice(rs.getLong("price"));
        product.setSize(rs.getString("size"));
        product.setColor(rs.getString("color"));
        product.setDescription(rs.getString("description"));
        product.setImage(rs.getString("image"));

        products.add(product);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return products;
  }

  public List<ProductEntity> getListProduct()
  {
    Transaction transaction = null;
    List<ProductEntity> products = null;
    Session session = factory.openSession();
    try
    {
      transaction = session.beginTransaction();
      // Error Could not resolve root entity, Cannot resolve symbol 'Product Entity'
      // --> change version or use "jakarta.persistence" for version hibernate > 6.
      // https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
      Query<ProductEntity> query = session.createQuery("FROM ProductEntity", ProductEntity.class);
      products = query.list();
      return products;
    }
    catch (Exception e)
    {
      if (transaction != null)
      {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    finally
    {
      session.close();
    }
    return null;
  }

  public static void main(String[] args) {
    ProductDAO productDAO = new ProductDAO();
    List<ProductEntity> products = productDAO.getListProduct();
    for (ProductEntity product : products) {
      System.out.println(product);
    }
  }
}
