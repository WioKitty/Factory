package manufacture;

import java.util.ArrayList;
import workers.*;
import products.*;

public final class Factory {
	private static ArrayList<FactoryWorker> Workers = new ArrayList<FactoryWorker>();
	private static ArrayList<Product> Products = new ArrayList<Product>();
	protected static String TypeOfProduct="";
	public FactoryWorker hireWorker () {
		FactoryWorker wrkr = new FactoryWorker();
		Workers.add(wrkr);
		return wrkr;
	}
	public String makeProduct() {
		if (Workers.isEmpty()) throw new RuntimeException("No workers!");
		if (TypeOfProduct=="") throw new RuntimeException("Select type of product!");
		for (int i=0; i<Workers.size();i++) {
			Workers.get(i).work();	
		}
		switch(TypeOfProduct)
		{
		case "Automobile":Products.add(new Automobile()); break;
		case "Cooker":Products.add(new Cooker()); break;
		case "Match":Products.add(new Cooker()); break;
		}
		for (int i=0; i<Workers.size();i++) {
			Workers.get(i).smoke();	
		}
		return TypeOfProduct;
	}
	public void sendProduction()
	{
		for (int i=0; i<Products.size();i++)
		{
			Store.Products.add(Products.get(i));
		}
		Products.clear();
	}
	public int getCountOfProduction()
	{
		return Products.size();
	}
}
