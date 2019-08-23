package demo.reflection02;

public class Road implements Lengthy{
	int _length;
	String endPoint1;
	String endPoint2;
	public int length() {return _length;}



	public Road(String endPoint1, int length, String endPoint2) {
		super();
		this.endPoint1 = endPoint1;
		this._length = length;
		this.endPoint2 = endPoint2;
	}



	@Override
	public String toString() {
		return "Road [" + endPoint1 + "<---" + _length + "--->" + endPoint2 + "]";
	}
	
	
	
}
