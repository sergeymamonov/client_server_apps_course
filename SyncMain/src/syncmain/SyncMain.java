package syncmain;

class Data
{
    int count =0;
    static int countSt =0;
}

class MyThread implements Runnable {
    private Data obj;
    
    MyThread(Data d){
        obj = d;
        new Thread(this).start();
    }
    
    void Add(){
        try {
            Thread.sleep(5);
            synchronized (obj) {
                int n=obj.count;
                n++;
                Thread.sleep(5);
                obj.count=n;
            }
        } catch (InterruptedException ex) {       }
    }
    
    static synchronized void AddStatic() {
                try {
            Thread.sleep(5);
            int n=Data.countSt;
            n++;
            Thread.sleep(5);
            Data.countSt=n;
        } catch (InterruptedException ex) {       }
    }
    
    @Override
    public void run() {
        for(int i=0; i<10; i++) Add();
        for(int i=0; i<10; i++) AddStatic();
    }
}

public class SyncMain {

    public static void main(String[] args) throws Exception {
        Data d=new Data();
        MyThread t1=new MyThread(d);
        MyThread t2=new MyThread(d);

        Thread.sleep(3000);
        System.out.println(d.count);
        System.out.println(Data.countSt);
    }
}
