import java.lang.String;
import java.util.Random;

enum NAMES {Egor, Irina, Vlad, Vera, Vitya, Petya, Misha}

public class Worker {
private NAMES Name;
private int Money;
Worker(){
	Random rand = new Random();
	int name = rand.nextInt(7);
	Name = NAMES.values()[name];
}
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
