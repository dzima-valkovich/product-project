package by.intexsoft.vodmvi.assigment.main;

import by.intexsoft.vodmvi.assigment.dao.model.Attribute;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("dispatcherServlet-servlet.xml");

        EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Attribute> cq = cb.createQuery(Attribute.class);
        Root<Attribute> r = cq.from(Attribute.class);
        CriteriaQuery<Attribute> all = cq.select(r);

        List<Attribute> res = manager.<Attribute>createQuery(all).getResultList();
        System.out.println(res);

        manager.getTransaction().commit();
        manager.close();
    }
}
