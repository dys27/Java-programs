package dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static dev.Main.EOF;
public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer,bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer,bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer,bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}

class MyProducer implements Runnable{
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer,ReentrantLock bufferLock){
        this.buffer=buffer;
        this.bufferLock = bufferLock;
    }
    public void run(){
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};
        for(String num: nums){
            try{
                System.out.println("Adding... "+num);
                bufferLock.lock();
                try{
                    buffer.add(num);
                }finally{
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println("Adding EOF and exiting");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        }finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer,ReentrantLock bufferLock){
        this.buffer=buffer;
        this.bufferLock=bufferLock;
        }

    public void run(){
        while(true){
            bufferLock.lock();
            try{
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println("exiting");
                    break;
                } else {
                    System.out.println("removed " + buffer.remove(0));
                }
            }finally{
                bufferLock.unlock();
            }
        }
    }
}