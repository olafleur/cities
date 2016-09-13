package com.olivierlafleur.cities.util;

import com.olivierlafleur.cities.model.City;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class HibernateUtilTest {
    @Test
    public void test()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("From City");

        List<City> resultList = q.list();
        System.out.println("num of cities:" + resultList.size());
        for (City next : resultList) {
            System.out.println("next city: " + next.getName());
        }
    }
}
