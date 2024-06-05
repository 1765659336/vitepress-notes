public class PiggyBank {
    /* 所有流水的明细 */
    public Money[] allMoneyArray = new Money[5];
    /* 存入的金钱明细 */
    public Money[] depositMoneyArray = new Money[5];

    public void addMoney(Money money) {
        if (money.describe == "存入") {
            this.addDepositArray(money);
        }
        this.addAllArray(money);
    }

    private void addAllArray(Money money) {
        this.allMoneyArray = this.addArray(this.allMoneyArray, money);
    }

    private void addDepositArray(Money money) {
        this.depositMoneyArray = this.addArray(this.depositMoneyArray, money);
    }

    private Money[] addArray(Money[] array, Money money) {
        int arrLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                arrLength = i;
                break;
            }
            if (i == array.length - 1) {
                arrLength = i + 1;
            }
        }
        if (Math.floorMod(arrLength, 5) == 0 && arrLength != 0) {
            Money[] arrayCopy = new Money[arrLength + 5];
            for (int i = 0; i < arrLength; i++) {
                arrayCopy[i] = array[i];
            }
            array = arrayCopy;
        }
        array[arrLength] = money;
        return array;
    }
}
