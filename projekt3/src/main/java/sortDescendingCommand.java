public class sortDescendingCommand implements command{
    basket basket;

    public sortDescendingCommand(basket basket) {
        this.basket = basket;
    }

    public void execute() {
        basket.backupOriginalOrder();
        basket.sortProductsDesc();
    }

    public void undo() {
        basket.restoreOriginalOrder();
    }
}
