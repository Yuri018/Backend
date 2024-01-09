package practice.budget_tracker.dao;

import practice.budget_tracker.model.Purchase;

import java.time.LocalDate;

public interface Budget {
    double addMoney(double money); // add money to budget

    boolean checkBudget();

    boolean addPurchase(Purchase purchase);

    double calcBudget();

    double getBudgetByPerson(String person);

    double getBudgetByStore(String store);

    double getBudgetByDate(LocalDate from, LocalDate to);

    double checkMoney();
}
