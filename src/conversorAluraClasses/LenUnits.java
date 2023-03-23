package conversorAluraClasses;

public final class LenUnits extends Units{

	public LenUnits(String name, Double value, String symbol) {
		super(name, value, symbol);
	}
	
	
	//"Centímetro","Metro","Kilómetro","Milla","Milla náutica", "Yarda","Pulgada","Pie"

	/*****************************************************************************************************/
	public void toMetro() {
		
		switch (this.getName()) {

			case ("Centímetro") :{
				this.setValue(this.getValue() / 100);
				break;
			}
			case ("Kilómetro"):{
				this.setValue(this.getValue() * 1000);
				break;
			}
			case ("Milla"):{
				this.setValue(this.getValue() * 1609.34);
				break;
			}
			case ("Milla náutica"):{
				this.setValue(this.getValue() * 1852);
				break;
			}
			case ("Yarda"):{
				this.setValue(this.getValue() / 1.094);
				break;
			}
			case ("Pulgada"):{
				this.setValue(this.getValue() / 39.37);
				break;
			}
			case ("Pie"):{
				this.setValue(this.getValue() / 3.281);
				break;
			}	
		}
		this.setName("Metro");
		this.setSymbol("m");
	}
	
	/*****************************************************************************************************/
	public void toCentimetro() {
		
		switch (this.getName()) {

			case ("Metro") :{
				this.setValue(this.getValue() * 100);
				break;
			}
			case ("Kilómetro"):{
				this.setValue(this.getValue() * 100000);
				break;
			}
			case ("Milla"):{
				this.setValue(this.getValue() * 160900);
				break;
			}
			case ("Milla náutica"):{
				this.setValue(this.getValue() * 185200);
				break;
			}
			case ("Yarda"):{
				this.setValue(this.getValue() * 91.44);
				break;
			}
			case ("Pulgada"):{
				this.setValue(this.getValue() * 2.54);
				break;
			}
			case ("Pie"):{
				this.setValue(this.getValue() * 30.48);
				break;
			}	
		}
		this.setName("Centímetro");
		this.setSymbol("cm");
	}
	
	/*****************************************************************************************************/
	public void toKilometro() {
		
		switch (this.getName()) {

			case ("Metro") :{
				this.setValue(this.getValue() / 1000);
				break;
			}
			case ("Centímetro"):{
				this.setValue(this.getValue() / 100000);
				break;
			}
			case ("Milla"):{
				this.setValue(this.getValue() * 1.60934);
				break;
			}
			case ("Milla náutica"):{
				this.setValue(this.getValue() * 1.852);
				break;
			}
			case ("Yarda"):{
				this.setValue(this.getValue() / 1094);
				break;
			}
			case ("Pulgada"):{
				this.setValue(this.getValue() / 39370);
				break;
			}
			case ("Pie"):{
				this.setValue(this.getValue() / 3281);
				break;
			}	
		}
		this.setName("Kilómetro");
		this.setSymbol("km");
	}
	
	/*****************************************************************************************************/
	public void toMilla() {
		
		switch (this.getName()) {

			case ("Metro") :{
				this.setValue(this.getValue() / 1609);
				break;
			}
			case ("Centímetro"):{
				this.setValue(this.getValue() / 160900);
				break;
			}
			case ("Kilómetro"):{
				this.setValue(this.getValue() / 1.609);
				break;
			}
			case ("Milla náutica"):{
				this.setValue(this.getValue() * 1.15078);
				break;
			}
			case ("Yarda"):{
				this.setValue(this.getValue() / 1760);
				break;
			}
			case ("Pulgada"):{
				this.setValue(this.getValue() / 63360);
				break;
			}
			case ("Pie"):{
				this.setValue(this.getValue() / 5280);
				break;
			}	
		}
		this.setName("Milla");
		this.setSymbol("mi");
	}
	
	/*****************************************************************************************************/
	public void toMillaNautica() {
		
		switch (this.getName()) {

			case ("Metro") :{
				this.setValue(this.getValue() / 1852);
				break;
			}
			case ("Centímetro"):{
				this.setValue(this.getValue() / 185200);
				break;
			}
			case ("Kilómetro"):{
				this.setValue(this.getValue() / 1.852);
				break;
			}
			case ("Milla"):{
				this.setValue(this.getValue() / 1.151);
				break;
			}
			case ("Yarda"):{
				this.setValue(this.getValue() / 2025);
				break;
			}
			case ("Pulgada"):{
				this.setValue(this.getValue() / 72910);
				break;
			}
			case ("Pie"):{
				this.setValue(this.getValue() / 6076);
				break;
			}	
		}
		this.setName("Milla náutica");
		this.setSymbol("nmi");
	}
	
	/*****************************************************************************************************/
	public void toYarda() {
		
		switch (this.getName()) {

			case ("Metro") :{
				this.setValue(this.getValue() * 1.09361);
				break;
			}
			case ("Centímetro"):{
				this.setValue(this.getValue() / 91.44);
				break;
			}
			case ("Kilómetro"):{
				this.setValue(this.getValue() * 1093.61);
				break;
			}
			case ("Milla"):{
				this.setValue(this.getValue() * 1760);
				break;
			}
			case ("Milla náutica"):{
				this.setValue(this.getValue() * 2025.37);
				break;
			}
			case ("Pulgada"):{
				this.setValue(this.getValue() / 36);
				break;
			}
			case ("Pie"):{
				this.setValue(this.getValue() / 3);
				break;
			}	
		}
		this.setName("Yarda");
		this.setSymbol("yd");
	}
	
	/*****************************************************************************************************/
	public void toPulgada() {
		
		switch (this.getName()) {

			case ("Metro") :{
				this.setValue(this.getValue() * 39.3701);
				break;
			}
			case ("Centímetro"):{
				this.setValue(this.getValue() / 2.54);
				break;
			}
			case ("Kilómetro"):{
				this.setValue(this.getValue() * 39370.1);
				break;
			}
			case ("Milla"):{
				this.setValue(this.getValue() * 63360);
				break;
			}
			case ("Milla náutica"):{
				this.setValue(this.getValue() * 72913.4);
				break;
			}
			case ("Yarda"):{
				this.setValue(this.getValue() * 36);
				break;
			}
			case ("Pie"):{
				this.setValue(this.getValue() * 12);
				break;
			}	
		}
		this.setName("Pulgada");
		this.setSymbol("in");
	}
	
	/*****************************************************************************************************/
	public void toPie() {
		
		switch (this.getName()) {

			case ("Metro") :{
				this.setValue(this.getValue() * 3.28084);
				break;
			}
			case ("Centímetro"):{
				this.setValue(this.getValue() / 30.48);
				break;
			}
			case ("Kilómetro"):{
				this.setValue(this.getValue() * 3280.84);
				break;
			}
			case ("Milla"):{
				this.setValue(this.getValue() * 5280);
				break;
			}
			case ("Milla náutica"):{
				this.setValue(this.getValue() * 6076.12);
				break;
			}
			case ("Yarda"):{
				this.setValue(this.getValue() * 3);
				break;
			}
			case ("Pulgada"):{
				this.setValue(this.getValue() / 12);
				break;
			}	
		}
		this.setName("Pie");
		this.setSymbol("ft");
	}
	/*****************************************************************************************************/
}
