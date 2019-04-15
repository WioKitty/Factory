package workers;

import java.lang.String;
import java.util.Random;

import products.*;

public class FactoryWorker extends AbstractWorker {

public void work() {
}
public void smoke() {
	fireMatch();
}
public void fireMatch() {
	Match mtch = new Match();
	mtch.fire();
}
public String getName() {
	return Name.toString();
}
}
