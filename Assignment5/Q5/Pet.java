package assignment5;

public class Pet {
	private String petName;
	private String ownerName;
	private String color;
	private int sexid;
	
	public static final int MALE=0;
	public static final int FEMALE=1;
	public static final int SPAYED=2;
	public static final int NEUTERED=3;
	
	public Pet(String petName, String ownerName, String color) {
		this.petName = petName;
		this.ownerName = ownerName;
		this.color = color;
	}
	
	public String getPetName() {
		return petName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public String getColor() {
		return color;
	}
	
	public void setSex(int sexid) {
		this.sexid = sexid;
	}
	public String getSex() {
		if(sexid==MALE) {
			return"Male";
		}
		else if(sexid==FEMALE) {
			return"Female";
		}
		else if(sexid==SPAYED) {
			return"Spayed";
		}
		else if(sexid==NEUTERED) {
			return "Neutered";
		}else {
			return"";
		}
	}
	
	public String toString() {
		String s = new String();
		s = this.petName + " owned by "+ this.ownerName + "\n" + "Color: "+ this.color +"\n"
				+ "Sex: "+ this.getSex();
		return s.toUpperCase();
	}

}
