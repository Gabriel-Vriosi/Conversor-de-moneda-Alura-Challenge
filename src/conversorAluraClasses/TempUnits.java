package conversorAluraClasses;

public final class TempUnits extends Units{

	public TempUnits(String name, Double value, String symbol) {
		super(name, value, symbol);
	}

	/*****************************************************************************************************/
	public void toCelsius() {
		
		switch (this.getName()) {
			case ("Kelvin") :{
				this.setValue(this.getValue() - 273.15);
				break;
			}
			case ("Fahrenheit") :{
				this.setValue((this.getValue() - 32) * 5/9);
				break;
			}
		}	
		this.setName("Celsius");
		this.setSymbol("°C");
	}
	/*****************************************************************************************************/
	public void toKelvin() {
		
		switch (this.getName()) {
			case ("Fahrenheit") :{
				this.setValue((this.getValue() - 32) * 5/9 + 273.15);
				break;
			}
			case ("Celsius"):{
				this.setValue(this.getValue() + 273.15);
				break;
			}
		}
		this.setName("Kelvin");
		this.setSymbol("°K");
	}
	/*****************************************************************************************************/
	public void toFahrenheit() {
		
		switch (this.getName()) {
			case ("Kelvin") :{
				this.setValue((this.getValue() - 273.15) * 9/5 + 32);
				break;
			}
			case ("Celsius"):{
				this.setValue((this.getValue() * 9/5) + 32);
				break;
			}
		}
		this.setName("Fahrenheit");
		this.setSymbol("°F");
	}
	/*****************************************************************************************************/
}
