package products;

public class Match extends Product{
	public Match()
	{
		super.Name = "Match";
	}
private int Lenght;
private boolean isFired = false;
public void fire() {
	isFired = true;
}
}
