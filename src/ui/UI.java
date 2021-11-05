package ui;

public interface UI { //has to be reworked in order to function well with the GUI
    public String acquireNextInputLine(); //especially here, since this method is called in a loop
    public void displayNextOutputLine(String outputline);
    public void displayError(String inputline);
    public void exitEnvironment();
}
