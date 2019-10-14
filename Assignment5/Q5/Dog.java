package assignment5;

public class Dog extends Pet implements Boardable{
	private String size;
	private Date boardStart, boardEnd;
	
	public Dog(String petName, String ownerName, String color, String size) {
		super(petName, ownerName, color);
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public String toString() {
		return super.toString()+"\n"+"size: "+this.getSize();
	}
	
	private class Date{
		private int month, day, year;
		
		public Date(int month, int day, int year) {
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
		Date boardStart = new Date(month, day, year);
	}
	public void setBoardEnd(int month, int day, int year) {
		Date boardEnd = new Date(month, day, year);
	}
	public boolean boarding(int month, int day, int year) {
		Date boarding = new Date(month, day, year);
		return boarding.isGreaterThan(boardStart) && boarding.isLessThan(boardEnd);
	}

}
