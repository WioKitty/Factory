package manufacture;

import workers.AbstractWorker;

public final class Director extends AbstractWorker {
public void changeTypeOfProduct(String type)
{
	Factory.TypeOfProduct = type;
}
}
