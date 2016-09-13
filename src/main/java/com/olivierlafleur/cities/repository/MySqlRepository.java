package com.olivierlafleur.cities.repository;

import com.olivierlafleur.cities.model.City;
import com.olivierlafleur.cities.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class MySqlRepository implements Repository {
    @Override
    public List<City> getAllCities() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("From City");

        return q.list();
    }
}
