package glowny;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import obsluga.Rezerwacja;



public class Glowny extends Thread{
	
	public static void main(String args[]) throws InterruptedException, ExecutionException, IOException
	{	
		ExecutorService exe = Executors.newFixedThreadPool(5);
		Scanner input = new Scanner(System.in);
		Rezerwacja rezerw = new Rezerwacja();
		Future<String > fut1 = null;
		Future<String > fut2 = null;
		Future<String > fut3 = null;
		Future<String > fut4 = null;
		Future<String > fut5 = null;
		Watek watek1 = new Watek(0 , rezerw,"_0_");
		Watek watek2 = new Watek(1, rezerw,"_0_");
		Watek watek3 = new Watek(2, rezerw,"_0_");
		Watek watek4 = new Watek(3, rezerw,"_0_");
		Watek watek5 = new Watek(4, rezerw,"_0_");
		int id = 0;
		while(true)
		{	
			Thread.sleep(100);
			biletyGUI(rezerw);
			id++;
			String komenda;
			komenda=input.nextLine();
			
			if(komenda.equals("1"))
			{	
				try
				{
					if(!fut1.isDone())
					{
						System.out.println("Watek juz zarezerwowal ten bilet czy chcesz go poprosiæ o zwolnienie"
									+ "\n 1.Tak 2.Nie");
						if(input.nextLine().equals("1"))
						{
							watek1.odwolaj_rezerwacje();
							while(!fut1.isDone()){Thread.sleep(1);}
							watek1=new Watek(0,rezerw,"_"+String.valueOf(id)+"_");
							fut1=exe.submit(watek1);
						}
						else
						{
							exe.submit(new Watek(0,rezerw,"_"+String.valueOf(id)+"_"));
						}
					}
					
				}catch(Exception e)
				{
					fut1=exe.submit(watek1);
				}
			}
			
			else if(komenda.equals("2"))
			{	
				try
				{
					if(!fut2.isDone())
					{
						System.out.println("Watek juz zarezerwowal ten bilet czy chcesz go poprosiæ o zwolnienie"
									+ "\n 1.Tak 2.Nie");
						if(input.nextLine().equals("1"))
						{
							watek2.odwolaj_rezerwacje();
							while(!fut2.isDone()){Thread.sleep(1);}
							watek2=new Watek(1,rezerw,"_"+String.valueOf(id)+"_");
							fut2=exe.submit(watek2);
						}
						else
						{
							exe.submit(new Watek(1,rezerw,"_"+String.valueOf(id)+"_"));
						}
					}
					
				}catch(Exception e)
				{
					fut2=exe.submit(watek2);
				}
			}
			else if(komenda.equals("3"))
			{
				try
				{
					if(!fut3.isDone())
					{
						System.out.println("Watek juz zarezerwowal ten bilet czy chcesz go poprosiæ o zwolnienie"
									+ "\n 1.Tak 2.Nie");
						if(input.nextLine().equals("1"))
						{
							watek3.odwolaj_rezerwacje();
							while(!fut3.isDone()){Thread.sleep(1);}
							watek3=new Watek(2,rezerw,"_"+String.valueOf(id)+"_");
							fut3=exe.submit(watek3);
						}
						else
						{
							exe.submit(new Watek(2,rezerw,"_"+String.valueOf(id)+"_"));
						}
					}
				}catch(Exception e)
				{
					fut3=exe.submit(watek3);
				}
			}
			else if(komenda.equals("4"))
			{
				try
				{
					if(!fut4.isDone())
					{
						System.out.println("Watek juz zarezerwowal ten bilet czy chcesz go poprosiæ o zwolnienie"
									+ "\n 1.Tak 2.Nie");
						if(input.nextLine().equals("1"))
						{
							watek4.odwolaj_rezerwacje();
							while(!fut4.isDone()){Thread.sleep(1);}
							watek4=new Watek(3,rezerw,"_"+String.valueOf(id)+"_");
							fut4=exe.submit(watek4);
						}
						else
						{
							exe.submit(new Watek(3,rezerw,"_"+String.valueOf(id)+"_"));
						}
					}
				}catch(Exception e)
				{
					fut4=exe.submit(watek4);
				}
			}
			else if(komenda.equals("5"))
			{
				
				try
				{
					if(!fut5.isDone())
					{
						System.out.println("Watek juz zarezerwowal ten bilet czy chcesz go poprosiæ o zwolnienie"
									+ "\n 1.Tak 2.Nie");
						if(input.nextLine().equals("1"))
						{
							watek5.odwolaj_rezerwacje();
							while(!fut5.isDone()){Thread.sleep(1);}
							watek5=new Watek(4,rezerw,"_"+String.valueOf(id)+"_");
							fut5=exe.submit(watek5);
						}
						else
						{
							exe.submit(new Watek(4,rezerw,"_"+String.valueOf(id)+"_"));
						}
					}
				}catch(Exception e)
				{
					fut5=exe.submit(watek5);
				}
			}
		}
	}




	private static void biletyGUI(Rezerwacja rezerw) {
		for(int i=0 ; i<5 ; i++)
		System.out.println(rezerw.getBilety(i));
		
	}

}
