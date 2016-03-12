package by.tvoibanki.service;

import by.tvoibanki.domain.Bank;

import java.util.ArrayList;

public interface ExchangeService {

    void insertMoscowMinskRatesIntoDB();
    void insertBelGazRatesIntoDB();
    Bank getMoscowMinskRates();
    Bank getBelGazRates();
    ArrayList<Bank> getRatesFromDB();


}
