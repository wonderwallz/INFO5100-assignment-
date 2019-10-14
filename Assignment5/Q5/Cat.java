package assignment5;


public class Cat extends Pet implements Boardable {
	private String hairLength;
	private Date boardStart, boardEnd;
	
	public Cat(String petName, String ownerName, String color, String hairLength) {
		super(petName, ownerName, color);
		this.hairLength = hairLength;
	}
	public String getHairLength() {
		return hairLength;
	}
	public String toString() {
		return super.toString()+"\n"+"Hair: "+this.getHairLength();
	}
	
	private class Date{
		private int month;
		private int day;
		private int year;
		
		public Date(int month,int day,int year) {
			this.month=month;
			this.day=day;
			this.year=year;
		}
		public boolean isGreaterThan(Date date) {
			if(this.year>date.year) {
				return true;
			}
			else if(this.year==date.year) {
				if(this.month>date.month) {
					return true;
				}else if(this.month==date.month && this.day>=date.day) {
					return true;
				}
			}
			return false;
		}
		public boolean isLessThan(Date date) {
			if(this.year<date.year) {
				return true;
			}
			else if(this.year==date.year) {
				if(this.month<date.month) {
					return true;
				}else if(this.month==date.month && this.day<=date.day) {
					return true;
				}
			}
			return false;
		}
	}
	
	public void setBoardStart(int month, int day, int year) {
		boardStart = new Date(month, day, year);
	}
	public void setBoardEnd(int month, int day, int year) {
		boardEnd = new Date(month, day, year);
	}
	public boolean boarding(int month, int day, int year) {
		Date boarding = new Date(month, day, year);
		return boarding.isGreaterThan(boardStart) && boarding.isLessThan(boardEnd);
	}

}
