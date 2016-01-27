import acm.graphics.*;

import java.awt.event.*;

public class AkinatorCanvas extends GCanvas
        implements ComponentListener {

    AkinatorCanvas() {
        akinator = new GImage("akinator.png");
        setSize((int)akinator.getWidth(), (int)akinator.getHeight());
        setText(new String[] {"", "", ""});
        addComponentListener(this);
        update();
    }

    public void update() {
        removeAll();
        akinator.setSize(getWidth(), getHeight());
        add(akinator);
        addTextBox();
    }

    private void addTextBox() {
        GCompound box = new GCompound();
        GImage bubble = new GImage("bubble.png");
        double bubbleWidth = getWidth() * 0.5;
        double bubbleHeight = getHeight() * 0.5;
        bubble.setSize(bubbleWidth, bubbleHeight);
        GLabel[] labels = new GLabel[3];
        for (int i = 0; i < 3; i++) {
            labels[i] = new GLabel(text[i]);
            labels[i].setFont("Helvetica-20");
            double labelX = (bubble.getWidth() - labels[i].getWidth()) / 2;
            double labelY = bubble.getHeight() / 10 * (i + 3);
            box.add(labels[i], labelX, labelY);
        }
        box.add(bubble);
        add(box);
    }

    public void setText(String[] text) {
        this.text = text;
        update();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        update();
    }

    @Override
    public void componentMoved(ComponentEvent e) { }

    @Override
    public void componentShown(ComponentEvent e) { }

    @Override
    public void componentHidden(ComponentEvent e) { }

    private String[] text = new String[3];
    private GImage akinator;
}
