package obsluga;

import java.util.ArrayList;
//pierdo³y
public class Bilet {
	private int cena;
	private String rodzaj;
	private boolean koniec=false;
	String trasa;
	private String status;
	private String id_watku;
	
	
	public Bilet (int cena,String trasa,String rodzaj ,String status, String id_watku){
			this.cena=cena;
			this.rodzaj=rodzaj;
			this.trasa=trasa;
			this.status=status;
			this.id_watku=id_watku;
		}
	public String getDostepny()
	{
		return status;
	}
	public void setDostepny(String s)
	{
		status=s;
	}
	public void setIdWatku(String id)
	{
		id_watku=id;
	}
	public	String toString()
	{
		return "Bilet "+ cena+"zl na trase "+trasa+" "+rodzaj+" "+status+"  zajete_przez:"+id_watku;
	}
}