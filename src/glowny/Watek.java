package glowny;

import java.util.concurrent.Callable;

import obsluga.Rezerwacja;

public class Watek implements Callable<String> {
	private int indeks_rezerwacji;
	private boolean odwolaj_rezerwacje=false;
	private Rezerwacja rezerwacja;
	private String id_watku;

	public Watek(int indeks_rezerwacji , Rezerwacja rezerw ,String id) {
		this.indeks_rezerwacji=indeks_rezerwacji;
		rezerwacja=rezerw;
		this.id_watku=id;
	}

	@Override
	public String call() throws Exception {
	
		//System.err.println(" Watek:"+id_watku+" rozpoczyna prace");
		if(rezerwacja.rezerwuj_bilet(indeks_rezerwacji ,id_watku))
		{
			
		}
		else
		{
			//System.err.println(" Watek:"+id_watku+" nie moze zarezerwowac biletu");
			return "nie zarezerwowalem";
		}
		while(!odwolaj_rezerwacje)
		{
			Thread.sleep(3000);
			//System.err.println(" Watek:"+id_watku+" ma bilet"+indeks_rezerwacji);
		}
		rezerwacja.odwolaj_rezerwacje(indeks_rezerwacji);
		//System.err.println(" Watek:"+id_watku+" odwolal bilet"+indeks_rezerwacji);
		return "oddalem bilet";
	}

	public void odwolaj_rezerwacje()
	{
		odwolaj_rezerwacje=true;
	}

}
