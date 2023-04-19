package ch10_extends_interface.starcraft;

public class Marine extends StarUnit {

	public Marine() {
		this("마린", 6, 50, 0);
		
	}
	
	public Marine(String name, int damage, int hp, int armor) {
		super(name, damage, hp, armor);
//		super.setName(name);
//		super.setDamage(damage);
//		super.setHp(hp);
//		super.setName(name); 위에꺼 안쓸거면 이렇게 써도됨
	}
	
//	public void attack(Zealot zealot) {
//		zealot.setHp(zealot.getHp() - super.getDamage() );
//	}
	public void attack(StarUnit unit) {
		unit.setHp(unit.getHp() - super.getDamage() );
	}
	
//	public void attack(HighTemplar high) {
//		high.setHp(high.getHp() - super.getDamage() );
//	}
	
	public void stimpack() {
		System.out.println("우아아아아!");
		
		super.setHp(super.getHp() -10); 
		super.setDamage(super.getDamage() *2);
		
		}
	
	
	@Override
	public String toString() {
		return "Marine [name=" + super.getName() + ", damage=" + super.getDamage() + ", hp=" + super.getHp() + ", armor=" + getArmor() + "]";
	}
	// super.getName 써도 되고 getName만 써도됨
	
	
	
}
