import javax.swing.*;

public class AkinatorPanel extends JPanel
implements AkinatorConstants {

    public AkinatorPanel() {
        addMinMaxBoxes();
        addAnswerButtons();
        addLanguageSelector();
    }

    private void addMinMaxBoxes() {
        minLabel = new JLabel();
        minBox = new JComboBox();
        maxLabel = new JLabel();
        maxBox = new JComboBox();

        minLabel.setText(MIN[Akinator.lang]);
        maxLabel.setText(MAX[Akinator.lang]);

        minBox.addItem("0");
        minBox.addItem("1");

        for (int i = 1; i <= 100; i++) {
            maxBox.addItem("" + i);
        }
        minBox.setEditable(true);
        minBox.setSelectedItem("" + Akinator.minNumber);
        maxBox.setEditable(true);
        maxBox.setSelectedItem("" + Akinator.maxNumber);

        add(minLabel);
        add(minBox);
        add(maxLabel);
        add(maxBox);
    }

    private void addAnswerButtons() {
        answerLabel = new JLabel();
        yesButton = new JButton();
        noButton = new JButton();

        answerLabel.setText(ANSWER[Akinator.lang]);
        noButton.setText(NO[Akinator.lang]);

        add(answerLabel);
        add(yesButton);
        add(noButton);
    }

    private void addLanguageSelector() {
        langLabel = new JLabel();
        langBox = new JComboBox();

        langLabel.setText(LANG[Akinator.lang]);

        langBox.addItem(EN);
        langBox.addItem(RU);
        langBox.addItem(UA);
        langBox.setSelectedItem(langBox.getItemAt(Akinator.lang));

        add(langLabel);
        add(langBox);
    }

    public JButton getYesButton() { return yesButton; }
    public JButton getNoButton() { return noButton; }

    public JComboBox getMinBox() { return minBox; }
    public JComboBox getMaxBox() { return maxBox; }

    public JComboBox getLangBox() { return langBox; }

    public void updateButtons() {
        minLabel.setText(MIN[Akinator.lang]);
        maxLabel.setText(MAX[Akinator.lang]);
        answerLabel.setText(ANSWER[Akinator.lang]);
        switch (Akinator.gameMode) {
            case 0:
                yesButton.setText(PLAY[Akinator.lang]);
                break;
            case 1:
                yesButton.setText(YES[Akinator.lang]);
                break;
            case 2:
                yesButton.setText(AGAIN[Akinator.lang]);
                break;
            default:
                break;
        }
        noButton.setText(NO[Akinator.lang]);
        langLabel.setText(LANG[Akinator.lang]);
    }

    private JLabel minLabel;
    private JComboBox minBox;
    private JLabel maxLabel;
    private JComboBox maxBox;

    private JLabel answerLabel;
    private JButton yesButton;
    private JButton noButton;

    private JLabel langLabel;
    private JComboBox langBox;
}
