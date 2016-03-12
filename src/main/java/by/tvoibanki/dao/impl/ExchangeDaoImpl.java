package by.tvoibanki.dao.impl;

import by.tvoibanki.dao.ExchangeDao;
import by.tvoibanki.domain.Bank;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ExchangeDaoImpl implements ExchangeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void insertMoscowMinskRatesToDBDao(Bank bank) {
        sessionFactory.getCurrentSession().update(bank);
    }

    public void insertBelGazRatesToDBDao(Bank bank) {
        sessionFactory.getCurrentSession().update(bank);
    }

    public ArrayList<Bank> getRatesFromDBDao() {
        ArrayList<Bank> banks = (ArrayList<Bank>) sessionFactory.getCurrentSession().createCriteria(Bank.class).list();
        return banks;
    }


}
