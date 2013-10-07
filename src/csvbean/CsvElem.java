package csvbean;

public class CsvElem<T> {
	T elem;
	
	public CsvElem() {
	}
	
	public CsvElem(T elem){
		this.elem = elem;
	}

	public T getElem() {
		return elem;
	}

	public void setElem(T elem) {
		this.elem = elem;
	}
	
	@Override
	public String toString() {
		if(elem.getClass() == Number.class){
			return ((Number) elem).toString();
		} else if(elem.getClass() == String.class){
			return (String) elem;
		}
		
		return super.toString();
	}
}
