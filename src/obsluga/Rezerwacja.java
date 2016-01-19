package obsluga;

import java.util.ArrayList;

import obsluga.Bilet;

public class Rezerwacja {
	private String id_watku="nie ma wlasciciela";
	private ArrayList<Bilet> bilety = new ArrayList<Bilet>();
	
	public Rezerwacja() {
		init();
	}
	private void init()
	{
		bilety.add(new Bilet(2, "krakow-warszawa", "ulgowy" , "dostepny" ,id_watku));
		bilety.add(new Bilet(3, "krakow-warszawa", "normalny" , "dostepny",id_watku));
		bilety.add(new Bilet(6, "zakopane-szczecin", "ulgowy", "dostepny",id_watku));
		bilety.add(new Bilet(9, "krakow-szczecin", "normalny", "dostepny",id_watku));
		bilety.add(new Bilet(8, "krakow-zakopane", "normalny", "dostepny",id_watku));
	}
	public String getBilety(int i)
	{
		if( i >=0 && i <5)
		{
			return bilety.get(i).toString();
		}
		else return bilety.get(0).toString();
		
	}
	
	public synchronized void rezerwuj_bilet(int i, String id_watku)
	{
		this.id_watku=id_watku;
			if(bilety.get(i).getDostepny().equals("dostepny"))
			{
				bilety.get(i).setDostepny("nie dostepny");
				bilety.get(i).setIdWatku(id_watku);
				System.out.println("Zarezerwowano bilet "+bilety.get(i).trasa);
			}else
				System.out.println("Przyrko mi bilet nie dostepny");
	}
	
	public void odwolaj_rezerwacje(int i)
	{
		if(bilety.get(i).getDostepny().equals("nie dostepny"))
		{
			bilety.get(i).setDostepny("dostepny");
		}
	}

}
		


