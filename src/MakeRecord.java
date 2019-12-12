import java.util.ArrayList;

public class MakeRecord implements Comparable<MakeRecord>{
	private String makemodel;
	private int amount;
	
	public MakeRecord(String makemodel, Integer amount)
	{
		this.makemodel = makemodel;
		this.amount= amount;
	}
	
	public String getmakemodel()
	{
		return makemodel;
	}
	public void setmakemodel(String makemodel)
	{
		this.makemodel = makemodel;
	}
	public int amount()
	{
		return amount;
	}
	public void setamount(int amount)
	{
		this.amount = amount;
	}
	
	@Override
	public int compareTo(MakeRecord o) {
		Integer thisOne = new Integer(amount);
		Integer thatOne = new Integer(o.amount);
		
		return thisOne.compareTo(thatOne) * -1;
	}
	
}
