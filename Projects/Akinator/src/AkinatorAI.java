import acm.util.RandomGenerator;

public class AkinatorAI {

    public AkinatorAI(int minNumber, int maxNumber) {
        if (minNumber > maxNumber) {
            this.minNumber = maxNumber;
            this.maxNumber = minNumber;
        } else {
            this.minNumber = minNumber;
            this.maxNumber = maxNumber;
        }
        initNumbers();
        msgs = new AkinatorMessages();
    }

    private void initNumbers() {
        numbers = new int[maxNumber - minNumber + 1];
        for (int i = 0; i < maxNumber; i++) {
            numbers[i] = i + minNumber;
        }
    }

    public void intro() {
        Akinator.answer = "";
        Akinator.canvas.setText(msgs.intro(minNumber, maxNumber));
        while(!Akinator.answer.equals("yes")) {
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
    }

    public boolean simpleGuesses() {
        if (maxNumber - minNumber == 0) {
            if (firstGuessIsRight(minNumber)) {
                showResult();
            } else {
                Akinator.canvas.setText(msgs.youCheater());
            }
            return true;
        } else if (maxNumber - minNumber == 1) {
            int result = isOddOrEven();
            rightHand = 1;
            if (result % 2 == 0 && numbers[leftHand] % 2 == 0) {
                this.result = numbers[leftHand];
            } else if (result % 2 != 0 && numbers[leftHand] % 2 != 0) {
                this.result = numbers[leftHand];
            } else if (result % 2 == 0 && numbers[rightHand] % 2 == 0) {
                this.result = numbers[rightHand];
            } else if (result % 2 != 0 && numbers[rightHand] % 2 != 0) {
                this.result = numbers[rightHand];
            }
            showResult();
            return true;
        } else if (maxNumber - minNumber == 2) {
            if (firstGuessIsRight(maxNumber - 1)) {
                showResult();
            } else {
                lessOrGreater(maxNumber - 1);
                if (leftHand == 2) {
                    result = maxNumber;
                } else {
                    result = minNumber;
                }
                rightHand = 1;
                showResult();
            }
            return true;
        }
        return false;
    }

    public void guessing() {
        Akinator.answer = "";
        int guess = rgen.nextInt(minNumber, maxNumber);
        tries = 0;
        if (firstGuessIsRight(numbers[guess - minNumber])) {
            result = numbers[guess - minNumber];
            return;
        } else {
            lessOrGreater(numbers[guess - minNumber]);
        }

        while (true) {
            Akinator.answer = "";
            int mid = (leftHand + rightHand) / 2;
            boolean direction = rgen.nextBoolean();

            if (direction) {
                Akinator.canvas.setText(msgs.lessThanOrEqual(numbers[mid]));
                waitForAnswer();
                tries++;
                if (Akinator.answer.equals("yes")) {
                    rightHand = mid;
                } else {
                    leftHand = mid;
                }
            } else {
                Akinator.canvas.setText(msgs.greaterThanOrEqual(numbers[mid]));
                waitForAnswer();
                tries++;
                if (Akinator.answer.equals("yes")) {
                    leftHand = mid;
                } else {
                    rightHand = mid;
                }
            }

            if (rightHand - leftHand == 1) {
                int result = isOddOrEven();
                if (result % 2 == 0 && numbers[leftHand] % 2 == 0) {
                    this.result = numbers[leftHand];
                    return;
                } else if (result % 2 != 0 && numbers[leftHand] % 2 != 0) {
                    this.result = numbers[leftHand];
                    return;
                } else if (result % 2 == 0 && numbers[rightHand] % 2 == 0) {
                    this.result = numbers[rightHand];
                    return;
                } else if (result % 2 != 0 && numbers[rightHand] % 2 != 0) {
                    this.result = numbers[rightHand];
                    return;
                }
            }
        }
    }

    private boolean firstGuessIsRight(int number) {
        Akinator.answer = "";
        Akinator.canvas.setText(msgs.guess(number));
        waitForAnswer();
        tries++;
        return (Akinator.answer.equals("yes"));
    }

    private void lessOrGreater(int number) {
        Akinator.answer = "";
        boolean direction = rgen.nextBoolean();
        if (direction) {
            Akinator.canvas.setText(msgs.lessThan(number));
            waitForAnswer();
            tries++;
            if (Akinator.answer.equals("yes")) {
                leftHand = 0;
                rightHand = number - minNumber - 1;
            } else {
                leftHand = number - minNumber + 1;
                rightHand = maxNumber - minNumber;
            }
        } else {
            Akinator.canvas.setText(msgs.greaterThan(number));
            waitForAnswer();
            tries++;
            if (Akinator.answer.equals("yes")) {
                leftHand = number - minNumber + 1;
                rightHand = maxNumber - minNumber;
            } else {
                leftHand = 0;
                rightHand = number - minNumber - 1;
            }
        }

    }

    private int isOddOrEven() {
        Akinator.answer = "";
        boolean direction = rgen.nextBoolean();
        if (direction) {
            Akinator.canvas.setText(msgs.isItOdd());
            waitForAnswer();
            tries++;
            if (Akinator.answer.equals("yes")) {
                return 1;
            } else {
                return 2;
            }
        } else {
            Akinator.canvas.setText(msgs.isItEven());
            waitForAnswer();
            tries++;
            if (Akinator.answer.equals("yes")) {
                return 2;
            } else {
                return 1;
            }
        }

    }

    public void showResult() {
        Akinator.answer = "";
        if (rightHand != 0) {
            Akinator.canvas.setText(msgs.guess(result));
                waitForAnswer();
            if (Akinator.answer.equals("yes")) {
                Akinator.canvas.setText(msgs.iGuessed(tries));
            } else {
                Akinator.canvas.setText(msgs.youCheater());
            }
        } else if (rightHand == 0) {
            Akinator.canvas.setText(msgs.iGuessed(tries));
        }
    }

    public void waitForAnswer() {
        while(Akinator.answer.equals("")) {
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
    }

    private int tries;
    private int result;
    private int leftHand;
    private int rightHand;
    private int[] numbers;
    private int minNumber;
    private int maxNumber;
    private AkinatorMessages msgs;
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
