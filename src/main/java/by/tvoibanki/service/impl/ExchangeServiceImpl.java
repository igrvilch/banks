package by.tvoibanki.service.impl;

import by.tvoibanki.dao.ExchangeDao;
import by.tvoibanki.domain.Bank;
import by.tvoibanki.service.ExchangeService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ExchangeServiceImpl implements ExchangeService {


    @Autowired
    ExchangeDao exchangeDao;

    public Bank getMoscowMinskRates() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.mmbank.by/personal/currency_exchange/?town=29").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select("#block-exRatessesAll tbody tr");
        Bank bank = new Bank();
        for(Element element: newsHeadlines) {
            if(element.child(0).text().equals("USD")) {
                bank.setUsdBuyRate(Integer.parseInt(element.child(3).child(0).text()));
                bank.setUsdSellRate(Integer.parseInt(element.child(4).child(0).text()));
            } else if(element.child(0).text().equals("EUR")) {
                bank.setEurBuyRate(Integer.parseInt(element.child(3).child(0).text()));
                bank.setEurSellRate(Integer.parseInt(element.child(4).child(0).text()));
            } else if(element.child(0).text().equals("RUB")) {
                bank.setRubBuyRate(Integer.parseInt(element.child(3).child(0).text()));
                bank.setRubSellRate(Integer.parseInt(element.child(4).child(0).text()));
            }
        }
        return bank;
    }

    public Bank getBelGazRates() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://belgazprombank.by/about/kursi_valjut/?date=12.03.2016&branch=5971").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select(".centerMenuBlockTabs-body-block tbody tr");
        Bank bank = new Bank();
        for(Element element: newsHeadlines) {
            System.out.println(element.child(2).text());
           /* if(element.child(1).text().equals("USD")) {
                bank.setUsdBuyRate(Integer.parseInt(element.child(2).text().replace("\"", "")));
                bank.setUsdSellRate(Integer.parseInt(element.child(3).text().replace("\"", "")));
            } else if(element.child(1).text().equals("EUR")) {
                bank.setEurBuyRate(Integer.parseInt(element.child(2).text().replace("\"", "")));
                bank.setEurSellRate(Integer.parseInt(element.child(3).text().replace("\"", "")));
            } else if(element.child(1).text().equals("RUB")) {
                bank.setRubBuyRate(Integer.parseInt(element.child(2).text().replace("\"", "")));
                bank.setRubSellRate(Integer.parseInt(element.child(3).text().replace("\"", "")));
            }*/
        }
        return bank;
    }

    @Transactional
    public ArrayList<Bank> getRatesFromDB() {
        return exchangeDao.getRatesFromDBDao();
    }

    @Transactional
    public void insertMoscowMinskRatesIntoDB() {
        Bank bank = getMoscowMinskRates();
        bank.setName("MoscowMinskBank");
        bank.setId(1l);
        exchangeDao.insertMoscowMinskRatesToDBDao(bank);
    }

    @Transactional
    public void insertBelGazRatesIntoDB() {
        Bank bank = getBelGazRates();
        bank.setName("Belgazprombank");
        bank.setId(2l);
        exchangeDao.insertBelGazRatesToDBDao(bank);
    }
}
