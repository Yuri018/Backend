package practice.budget_tracker.model;

import java.time.LocalDate;
import java.util.Objects;

public class Purchase {

    // fields
    private int id;
    private String store;
    private String personName;
    private double amount;
    private LocalDate date;

    //constructor
    public Purchase(int id, String store, String personName, double amount) {
        this.id = id;
        this.store = store;
        this.personName = personName;
        this.amount = amount;
    }

    public Purchase(int id, String store, String personName, double amount, LocalDate date) {
        this.id = id;
        this.store = store;
        this.personName = personName;
        this.amount = amount;
        this.date = date;
    }

    //methods
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id == purchase.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + "," + store + "," + personName + "," + amount + "," + date;
    }
}
