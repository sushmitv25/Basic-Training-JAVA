package com.lgxl.training.corejava;
/**
 * This Class Demonstrates the Producer Consumer Problem Scenario
 * @Author: LogixaL
 */
public class Producer_Consumer 
{
	public static void main(String args[]) 
	{
		Monitor m = new Monitor();
		Producer p = new Producer(m);
		Consumer c = new Consumer(m);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}


/**
 * This Class Monitors the Production and Consumption of the Items
 */
class Monitor 
{
	int token;
	boolean available;

	synchronized public void set(int k) 					//Method used by Producer thread to Produce an Item
	{									
		while (available) 
		{
			try 
			{
				wait();
			} catch (InterruptedException ie) 
			{
			}
		}
		token = k;
		System.out.println("Producer-Set  " + token);
		notifyAll();
		available = true;
	}

	synchronized public void get() 											//Method used by Consumer Thread to Consume an Item
	{
		while (!available) 
		{
			try 
			{
				wait();
			} catch (InterruptedException ie) 
			{
			}
		}
		available = false;
		System.out.println("Consumer-Get  " + token);
		notifyAll();
	}
}

/**
 * This class implements the Producer which Produces the new Items 
 *
 */
class Producer implements Runnable 
{
	Monitor obj;

	Producer(Monitor obj) 
	{
		this.obj = obj;
	}

	public void run() 
	{
		int i = 0;
		for(int j=0;j<10;j++) 
		{
			obj.set(i++);
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException ie) 
			{
			}
		}
	}
}


/**
 * This Class implements Consumer that Consumes the item that is produced by the Producer
 *
 */
class Consumer implements Runnable 
{
	Monitor obj;

	Consumer(Monitor obj) 
	{
		this.obj = obj;
	}

	public void run() 
	{
		for(int i=0;i<10;i++) 
		{
			obj.get();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) 
			{
			}
		}
	}
}
