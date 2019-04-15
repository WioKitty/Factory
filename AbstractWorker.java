package workers;

import java.lang.String;
import java.util.Random;

enum NAMES {EGOR, IRINA, VLAD, VERA, VITYA, PETYA, MISHA}


public abstract class AbstractWorker {
public NAMES Name;
private int Money;
public AbstractWorker(){
	Random rand = new Random();
	int name = rand.nextInt(7);
	Name = NAMES.values()[name];
}
}
