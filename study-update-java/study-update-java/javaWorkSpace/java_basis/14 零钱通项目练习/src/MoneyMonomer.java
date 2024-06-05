import java.util.Date;

public class MoneyMonomer {
    // 金额生成的时间
    public Date date;
    // 金额的大小
    public double amountOfQuantity;

    public MoneyMonomer(Date date, double amountOfQuantity) {
        this.date = date;
        this.amountOfQuantity = amountOfQuantity;
    }
}
