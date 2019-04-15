package manufacture;
import java.util.ArrayList;
import products.*;

public final class Store {
protected static ArrayList<Product> Products = new ArrayList<Product>();
public int getCountOfProduction()
{
	return Products.size();
}
}
