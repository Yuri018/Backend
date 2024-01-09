package practice.budget_tracker.dao;

import practice.budget_tracker.model.Purchase;

import java.time.LocalDate;
import java.util.List;

public class BudgetImpl implements Budget {
    double budget;
    List<Purchase> purchaseList;// обращаемся к пустому конструктору

    public BudgetImpl(double budget, List<Purchase> purchaseList) {
        this.budget = budget;
        this.purchaseList = purchaseList;
    }

    @Override
    public double addMoney(double money) {
        budget += money;
        return budget;
    }

    @Override
    public boolean checkBudget() {
            double res = calcBudget();
        return res < budget;
    }

    @Override
    public boolean addPurchase(Purchase purchase) {
        if (purchaseList == null || purchaseList.contains(purchase)){
            return false;
        }
        return purchaseList.add(purchase);
    }

    @Override
    public double calcBudget() {

        return purchaseList.stream()
                .mapToDouble(Purchase::getAmount)
                .sum();
    }

    @Override
    public double getBudgetByPerson(String person) {
        return purchaseList.stream()
                .filter(purchase -> purchase.getPersonName().equalsIgnoreCase(person))
                . mapToDouble(Purchase::getAmount)
                .sum();
    }

    @Override
    public double getBudgetByStore(String store) {
        return purchaseList.stream()
                .filter(purchase -> purchase.getStore().equalsIgnoreCase(store))
                .mapToDouble(Purchase::getAmount)
                .sum();
    }

    @Override
    public double getBudgetByDate(LocalDate from, LocalDate to) {
        return purchaseList.stream()
                .filter(purchase -> purchase.getDate().isAfter(from) && purchase.getDate().isBefore(to))
                .mapToDouble(Purchase::getAmount)
                .sum();
    }

    @Override
    public double checkMoney() {
        double spends = calcBudget();
        double res = budget - spends;
        return res;
    }
}
