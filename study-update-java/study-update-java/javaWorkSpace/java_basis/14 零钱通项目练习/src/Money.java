import java.util.Date;

public class Money extends MoneyMonomer{
    // 对该笔钱的描述
    public String describe;
    public Money(Date date, double amountOfQuantity, String describe) {
        super(date,amountOfQuantity);
        this.describe = describe;
    }
    public Money(Date date, double amountOfQuantity){
        super(date,amountOfQuantity);
        this.describe = "存入";
    }
}
