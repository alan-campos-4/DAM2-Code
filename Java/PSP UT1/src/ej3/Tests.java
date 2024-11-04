package ej3;

class Tests implements Runnable
{
    private volatile String string;

    @Override
    public void run() {
        string = "whatever";
    }

    public String getString() {
        return string;
    }

    public static void main(String[] args) throws InterruptedException
    {
    	Tests whatever = new Tests();
        Thread thread = new Thread(whatever);
        thread.start();
        thread.join();
        String string = whatever.getString();
        System.out.println(string);
    }
}