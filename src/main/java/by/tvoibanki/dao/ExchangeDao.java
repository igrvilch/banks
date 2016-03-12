package by.tvoibanki.dao;

import by.tvoibanki.domain.Bank;

import java.util.ArrayList;

public interface ExchangeDao {

    void insertMoscowMinskRatesToDBDao(Bank bank);
    void insertBelGazRatesToDBDao(Bank bank);
    ArrayList<Bank> getRatesFromDBDao();
}
