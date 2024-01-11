package practice.budget_tracker.model;

public enum Menu {
    SET_BUDGET(1, "Month budget"),
    ADD_PURCHASE(2, "Add purchase"),
    CHECK_BUDGET(3, "Check budget"),
    BUDGET_STORE(4, "Budget by store"),
    BUDGET_PERSON(5, "Budget by person"),
    BUDGET_DATE(6, "Budget from ... to"),
    SAVE(7, "Save"),
    LOAD(8, "Load"),
    EXIT(9, "Exit");
    //пункты меню для пользователя
    private int id;
    private String item;

    Menu(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public static void printMenu() {
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i].id + ": " + menu[i].item + " | ");
        }
        System.out.println();
        System.out.println("Input your choice:");
    }
}
