package Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample
{
	private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
	private Random random = new Random();
	private CyclicBarrier cyclicBarrier;
	private int NUM_PARTIAL_RESULTS;
	private int NUM_WORKERS;
	
	
    /* MAIN */
    public static void main(String[] args)
    {
        CyclicBarrierExample demo = new CyclicBarrierExample();
        demo.runSimulation(5, 3);
        //CyclicBarrierExample demo1 = new CyclicBarrierExample();
        //demo1.runSimulation(6, 2);
    }
    
    
    /* Simulation and thread creation. */
    public void runSimulation(int numWorkers, int numberOfPartialResults)
    {
    	NUM_PARTIAL_RESULTS = numberOfPartialResults;
    	NUM_WORKERS = numWorkers;
        
    	cyclicBarrier = new CyclicBarrier(NUM_WORKERS, new AggregatorThread());
        
        System.out.println("Creating " + NUM_WORKERS + " worker threads ");
        System.out.println( "to compute " + NUM_PARTIAL_RESULTS + " partial results each.");
        System.out.println("-----");
        
        for (int i = 0; i < NUM_WORKERS; i++)
        {
        	Thread worker = new Thread(new NumberCruncherThread());
        	worker.setName("Thread " + i);
        	worker.start();
        }
    }
    
    
    /* Thread that randomly generates numbers and stores them. */
    class NumberCruncherThread implements Runnable
    {
        @Override
        public void run()
        {
            String thisThreadName = Thread.currentThread().getName();
            List<Integer> partialResult = new ArrayList<>();
            
            for (int i = 0; i < NUM_PARTIAL_RESULTS; i++)
            {
                int num = random.nextInt(10);
                System.out.println(thisThreadName + ": Number generated = " + num);
                partialResult.add(num);
            }
            
            partialResults.add(partialResult);
            
            try
            {
                System.out.println(thisThreadName + " waiting for others to reach barrier.");
                cyclicBarrier.await();
            }
            catch (InterruptedException e)		{System.out.println("");} 
            catch (BrokenBarrierException e)	{System.out.println("");}
        }
    }
    /* Thread that add the previously generated numbers. */
    class AggregatorThread implements Runnable
    {
        @Override
        public void run()
        {
        	String thisThreadName = Thread.currentThread().getName();
        	System.out.println(thisThreadName + ": Computing sum of " + NUM_WORKERS + " workers, "
        			+ "having " + NUM_PARTIAL_RESULTS + " results each.");
        	int sum = 0;
        	for (List<Integer> threadResult : partialResults)
        	{
        		System.out.print("Adding ");
        		for (Integer partialResult : threadResult)
        		{
        			System.out.print(partialResult+" ");
        			sum += partialResult;
        		}
        		System.out.println();
        	}
        	System.out.println(thisThreadName + ": Final result = " + sum);
        }
    }
    
    
    
    
    
    
    
    

}