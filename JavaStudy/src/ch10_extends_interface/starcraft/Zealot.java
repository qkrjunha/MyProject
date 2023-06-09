package ch10_extends_interface.starcraft;

public class Zealot extends StarUnit {

	private int shield;

	public Zealot() {
		this("질럿", 16, 100, 1, 60);
	}

	public Zealot(String name, int damage, int hp, int armor, int shield) {
		// 자식 생성자 맨 위에 부모 생성자가 와야함(super, this 위치가 바뀌면 안됨)
		super(name, damage, hp, armor);
		this.shield = shield;
	}

	@Override
	public String toString() {
		return "Zealot [name=" + super.getName() + ", damage=" + super.getDamage() + ", hp=" + super.getHp()
				+ ", armor=" + super.getArmor() + ", shield=" + shield + "]";
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}
}
