public class Coin {
    private String coinName;
    private int coinValue;
    public Coin (int coinValue) {
        this.coinValue = coinValue;
        switch (coinValue) {
            case 1: this.coinName = "PENNY"; break;
            case 5: this.coinName = "NICKEL"; break;
            case 10: this.coinName = "Dime"; break;
            case 25: this.coinName = "QUARTER"; break;
            default:
                break;
        }
    }
    public String getCoinName() {
        return coinName;
    }
    public int coinValue() {
        return coinValue;
    }
}
