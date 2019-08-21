package in.conceptarchitect.util;

public class GenericWrapper<E> {
	E value;
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	public GenericWrapper(E value) {
		super();
		this.value = value;
	}
	
	public  static <S>  GenericWrapper<S> create(S value){
		return new GenericWrapper<S>(value);
	}
	
}
