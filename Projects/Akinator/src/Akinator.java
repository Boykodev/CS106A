/**
 * Created by Serge on 3/19/15.
 */

import acm.program.*;

import java.awt.event.*;

public class Akinator extends Program
        implements AkinatorConstants {

    public static void main(String[] args) {
        new Akinator().start(args);
    }

    public void init() {
        canvas = new AkinatorCanvas();
        panel = new AkinatorPanel();
        initButtonsListeners();
        setSize((int)(canvas.getWidth() * 1.2) , (int)(canvas.getHeight() * 1.2));
        add(canvas);
        add(panel, SOUTH);
        addActionListeners();
    }

    private void initButtonsListeners() {
        panel.getYesButton().addActionListener(this);
        panel.getNoButton().addActionListener(this);

        panel.getMinBox().addActionListener(this);
        panel.getMaxBox().addActionListener(this);

        panel.getLangBox().addActionListener(this);
    }

    public void run() {
        minMaxHasChanged = false;
        ai = new AkinatorAI(minNumber, maxNumber);
        gameMode = 0;
        setYesButtonText();
        ai.intro();
        if (minMaxHasChanged) {
            run();
        }
        gameMode = 1;
        setYesButtonText();
        if (!ai.simpleGuesses()) {
            ai.guessing();
            ai.showResult();
        }
        gameMode = 2;
        setYesButtonText();
        answer = "";
        while(!answer.equals("yes")) {
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
        run();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.getYesButton()) {
            answer = "yes";
        } else if (e.getSource() == panel.getNoButton()) {
            answer = "no";
        }

        if (e.getSource() == panel.getMinBox()) {
            int prevMinNumber = minNumber;
            String min = (String)panel.getMinBox().getSelectedItem();
            try {
                minNumber = Integer.parseInt(min);
                if (minNumber != prevMinNumber) {
                    minMaxHasChanged = true;
                }
            } catch (NumberFormatException ex) {
            }
        } else if (e.getSource() == panel.getMaxBox()) {
            int prevMaxNumber = maxNumber;
            String max = (String)panel.getMaxBox().getSelectedItem();
            try {
                maxNumber = Integer.parseInt(max);
                if (maxNumber != prevMaxNumber) {
                    minMaxHasChanged = true;
                }
            } catch (NumberFormatException ex) {
            }
        }

        if (e.getSource() == panel.getLangBox()) {
            String lang = (String)panel.getLangBox().getSelectedItem();
            if (lang.equals(EN)) {
                this.lang = 0;
            } else if (lang.equals(RU)) {
                this.lang = 1;
            } else if (lang.equals(UA)) {
                this.lang = 2;
            }
            panel.updateButtons();
            new AkinatorMessages().updateMessage();
        }
    }

    void setYesButtonText() {
        switch (gameMode) {
            case 0:
                panel.getYesButton().setText(PLAY[Akinator.lang]);
                break;
            case 1:
                panel.getYesButton().setText(YES[Akinator.lang]);
                break;
            case 2:
                panel.getYesButton().setText(AGAIN[Akinator.lang]);
                break;
            default:
                break;
        }
    }

    private AkinatorAI ai;
    private AkinatorPanel panel;
    static AkinatorCanvas canvas;

    static int minNumber = 1;
    static int maxNumber = 100;

    static String answer;
    boolean minMaxHasChanged;

    static int lang = 0; // 0 - English, 1 - Russian, 2 - Ukrainian.
    static int gameMode; // stage of the game (playmode, gamemode, restartmode)
}