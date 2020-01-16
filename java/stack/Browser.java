package stack;

import sun.awt.image.ImageWatched;

/**
 * @author shmilyiselephant
 * @date 09.01.20
 * @decription
 */
public class Browser {
    private LinkedStack openStack = new LinkedStack();
    private LinkedStack closeStack = new LinkedStack();
    private int currentPage;


    public void openPage(int data) {
        openStack.push(data);
        getCurrent();
    }

    public void closePage() {
        closeStack.push(openStack.pop());
        getCurrent();
    }

    public void forwardPage() {
        openStack.push(closeStack.pop());
        getCurrent();
    }

    public void backwardPage() {
        closeStack.push(openStack.pop());
        getCurrent();
    }

    public void getCurrent() {
        int data = openStack.pop();
        openStack.push(data);
        System.out.println("currentPage is " + data);
    }
    public static void main(String args[]) {
        Browser go = new Browser();
        for (int i = 0; i < 10; i++)
            go.openPage(i);
        go.closePage();
        go.backwardPage();
        go.backwardPage();
        go.backwardPage();
        go.backwardPage();
        go.forwardPage();
        go.forwardPage();
    }
}
