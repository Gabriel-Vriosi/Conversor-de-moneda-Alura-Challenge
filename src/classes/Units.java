package classes;

public class Units {
	private String name;
	private Double value;
	private String symbol;
	
	public Units(String name, Double value, String symbol) {
		this.name = name;
		this.value = value;
		this.symbol = symbol;
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public Double getValue() {
		return value;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
