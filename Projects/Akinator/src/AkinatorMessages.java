public class AkinatorMessages {

    public String[] intro(int minNumber, int maxNumber) {
        String[] result;
        lastMessage = 0;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"Think of a number", "between "
                        + minNumber + " and " + maxNumber, "and I'll guess it."};
                return result;
            case 1:
                result = new String[] {"Загадай число", "между "
                        + minNumber + " и " + maxNumber, "а я угадаю."};
                return result;
            case 2:
                result = new String[] {"Задумай число", "між "
                    + minNumber + " та " + maxNumber, "а я вгадаю."};
            return result;
            default:
                return null;
        }
    }

    public String[] guess(int number) {
        String[] result;
        lastMessage = 1;
        this.number = number;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"Is the", "number is", number + "?"};
                return result;
            case 1:
                result = new String[] {"Это", "число", number + "?"};
                return result;
            case 2:
                result = new String[] {"Це", "число", number + "?"};
                return result;
            default:
                return null;
        }
    }

    public String[] lessThan(int number) {
        String[] result;
        lastMessage = 2;
        this.number = number;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"Is it", "less than", number + "?"};
                return result;
            case 1:
                result = new String[] {"Это число", "меньше чем", number + "?"};
                return result;
            case 2:
                result = new String[] {"Це число", "менше ніж", number + "?"};
                return result;
            default:
                return null;
        }
    }

    public String[] greaterThan(int number) {
        String[] result;
        lastMessage = 3;
        this.number = number;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"Is it", "greater than", number + "?"};
                return result;
            case 1:
                result = new String[] {"Это число", "больше чем", number + "?"};
                return result;
            case 2:
                result = new String[] {"Це число", "більше ніж", number + "?"};
                return result;
            default:
                return null;
        }
    }

    public String[] lessThanOrEqual(int number) {
        String[] result;
        lastMessage = 4;
        this.number = number;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"Is it", "less than or equal", "to " + number + "?"};
                return result;
            case 1:
                result = new String[] {"Это число", "меньше или", "равно " + number + "?"};
                return result;
            case 2:
                result = new String[] {"Це число", "менше чи", "дорівнює " + number + "?"};
                return result;
            default:
                return null;
        }
    }

    public String[] greaterThanOrEqual(int number) {
        String[] result;
        lastMessage = 5;
        this.number = number;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"Is it", "greater than or equal", "to " + number + "?"};
                return result;
            case 1:
                result = new String[] {"Это число", "больше или", "равно " + number + "?"};
                return result;
            case 2:
                result = new String[] {"Це число", "більше чи", "дорівнює " + number + "?"};
                return result;
            default:
                return null;
        }
    }

    public String[] isItOdd() {
        String[] result;
        lastMessage = 6;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"Is the", "number", "odd?"};
                return result;
            case 1:
                result = new String[] {"Это", "число", "непарное?"};
                return result;
            case 2:
                result = new String[] {"Це", "число", "непарне?"};
                return result;
            default:
                return null;
        }
    }

    public String[] isItEven() {
        String[] result;
        lastMessage = 7;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"Is the", "number", "even?"};
                return result;
            case 1:
                result = new String[] {"Это", "число", "парное?"};
                return result;
            case 2:
                result = new String[] {"Це", "число", "парне?"};
                return result;
            default:
                return null;
        }
    }

    public String[] iGuessed(int tries) {
        String[] result;
        lastMessage = 8;
        this.tries = tries;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"I guessed!", "It took me", tries + " tr" + ((tries == 1) ? "y." : "ies.")};
                return result;
            case 1:
                result = new String[] {"Я угадал!", "Количество попыток:", "" + tries};
                return result;
            case 2:
                result = new String[] {"Я вгадав!", "Кількість спроб:", "" + tries};
                return result;
            default:
                return null;
        }
    }

    public String[] youCheater() {
        String[] result;
        lastMessage = 9;
        switch (Akinator.lang) {
            case 0:
                result = new String[] {"", "You cheater!", ""};
                return result;
            case 1:
                result = new String[] {"", "Ты читер!", ""};
                return result;
            case 2:
                result = new String[] {"", "Ти чітер!", ""};
                return result;
            default:
                return null;
        }
    }

    public void updateMessage() {
        switch (lastMessage) {
            case 0:
                Akinator.canvas.setText(intro(minNumber, maxNumber));
                break;
            case 1:
                Akinator.canvas.setText(guess(number));
                break;
            case 2:
                Akinator.canvas.setText(lessThan(number));
                break;
            case 3:
                Akinator.canvas.setText(greaterThan(number));
                break;
            case 4:
                Akinator.canvas.setText(lessThanOrEqual(number));
                break;
            case 5:
                Akinator.canvas.setText(greaterThanOrEqual(number));
                break;
            case 6:
                Akinator.canvas.setText(isItOdd());
                break;
            case 7:
                Akinator.canvas.setText(isItEven());
                break;
            case 8:
                Akinator.canvas.setText(iGuessed(tries));
                break;
            case 9:
                Akinator.canvas.setText(youCheater());
                break;
            default:
                break;
        }
    }

    private static int lastMessage;
    private static int minNumber;
    private static int maxNumber;
    private static int number;
    private static int tries;
}
