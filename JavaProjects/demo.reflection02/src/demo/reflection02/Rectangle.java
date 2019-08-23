package demo.reflection02;

public class Rectangle implements Lengthy{
	int _length,_width;
	public Rectangle(int length, int width) {
		super();
		this._length = length;
		this._width = width;
	}
	public int length() {return _length;}
	public int width() {return _width;}

	@Override
	public String toString() {
		return "Rectangle [length=" + _length + ", width=" + _width + "]";
	}
	
}
