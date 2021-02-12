package behavioral.observer;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JProgressBar;;

public class ProgressWindow extends JFrame implements LineObserver {
    private int lines;
    private JProgressBar bar;


    public ProgressWindow(int max) throws HeadlessException {
        super();
        this.lines = 0;
        this.bar = new JProgressBar(0, max);
        performLayout();
        setVisible(true);
    }


    @Override
    public void handleLine(LineSubject source) {
        indicateProgress();

    }

    private void indicateProgress() {
        lines++;
        bar.setValue(lines);
    }

    private void performLayout() {
        setSize(300, 50);
        bar.setString("Lines Read");
        bar.setStringPainted(true);

        getContentPane().add(bar);
    }

}
