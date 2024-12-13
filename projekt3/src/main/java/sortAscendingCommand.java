public class sortAscendingCommand implements command{
    basket basket;

    public sortAscendingCommand(basket basket) {
        this.basket = basket;
    }

    public void execute() {
        basket.backupOriginalOrder();
        basket.sortProductsAsc();
    }

    public void undo() {
        basket.restoreOriginalOrder();
    }
}
