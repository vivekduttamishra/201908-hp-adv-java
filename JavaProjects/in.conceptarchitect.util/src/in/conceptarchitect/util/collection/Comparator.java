package in.conceptarchitect.util.collection;

@FunctionalInterface
public interface Comparator<T> {
	double compare(T one, T two);
	
	default boolean eq(T one, T two) {
		return compare(one,two)==0;
	}
	
	default boolean lt(T one, T two) {
		return compare(one,two)<0;
	}
	
	default boolean gt(T one, T two) {
		return compare(one,two)>0;
	}
	
	default boolean le(T one, T two) {
		return compare(one,two)<=0;
	}
	
	default boolean ge(T one, T two) {
		return compare(one,two)>=0;
	}
	
	
	default boolean ne(T one, T two) {
		return ! eq(one,two);
	}
}
