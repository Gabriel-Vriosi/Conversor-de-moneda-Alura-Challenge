package conversorAluraClasses;

public class MoneyUnits extends Units {

	public MoneyUnits(String name, Double value, String symbol) {
		super(name, value, symbol);
	}
	
	public void toARS() {
		
		switch (this.getName()) {
			case ("USD") :{
				this.setValue((this.getValue() * 200.3702));		
				break;
			}
			case ("EUR") :{
				this.setValue(this.getValue() * 210.647558);		
				break;
			}
			case ("JPY") :{
				this.setValue(this.getValue() * 1.454625);
				break;
			}
			case ("GBP") :{
				this.setValue(this.getValue() * 236.417132);
				break;
			}
			case ("KRW") :{
				this.setValue(this.getValue() * 0.151475);
				break;
			}
		}	
	this.setName("ARS");
	this.setSymbol("$");
	}
	
	/*****************************************************************************************************/
	public void toUSD() {
		
		switch (this.getName()) {
			case ("ARS") :{
				this.setValue((this.getValue() * 0.0050));		
				break;
			}
			case ("EUR") :{
				this.setValue(this.getValue() * 1.54232);		
				break;
			}
			case ("JPY") :{
				this.setValue(this.getValue() * 0.007280);
				break;
			}
			case ("GBP") :{
				this.setValue(this.getValue() * 1.183201);
				break;
			}
			case ("KRW") :{
				this.setValue(this.getValue() * 0.000758);
				break;
			}
		}	
	this.setName("USD");
	this.setSymbol("$");
	}
	
	/*****************************************************************************************************/
	public void toEUR() {
		
		switch (this.getName()) {
			case ("ARS") :{
				this.setValue((this.getValue() * 0.004746));		
				break;
			}
			case ("USD") :{
				this.setValue(this.getValue() * 0.948412);		
				break;
			}
			case ("JPY") :{
				this.setValue(this.getValue() * 0.006905);
				break;
			}
			case ("GBP") :{
				this.setValue(this.getValue() * 1.122234);
				break;
			}
			case ("KRW") :{
				this.setValue(this.getValue() * 0.00071);
				break;
			}
		}	
	this.setName("EUR");
	this.setSymbol("€");
	}
	
	/*****************************************************************************************************/
	public void toJPY() {
		
		switch (this.getName()) {
			case ("ARS") :{
				this.setValue((this.getValue() * 0.687332));		
				break;
			}
			case ("USD") :{
				this.setValue(this.getValue() * 137.344063);		
				break;
			}
			case ("EUR") :{
				this.setValue(this.getValue() * 144.802501);
				break;
			}
			case ("GBP") :{
				this.setValue(this.getValue() * 162.515074);
				break;
			}
			case ("KRW") :{
				this.setValue(this.getValue() * 0.104119);
				break;
			}
		}	
	this.setName("JPY");
	this.setSymbol("¥");
	}
	
	/*****************************************************************************************************/
	public void toGBP() {
		
		switch (this.getName()) {
			case ("ARS") :{
				this.setValue((this.getValue() * 0.004229));		
				break;
			}
			case ("USD") :{
				this.setValue(this.getValue() * 0.845008);		
				break;
			}
			case ("EUR") :{
				this.setValue(this.getValue() * 0.890896);
				break;
			}
			case ("JPY") :{
				this.setValue(this.getValue() * 0.006152);
				break;
			}
			case ("KRW") :{
				this.setValue(this.getValue() * 0.000641);
				break;
			}
		}	
	this.setName("GBP");
	this.setSymbol("£");
	}
	
	/*****************************************************************************************************/
	public void toKRW() {
		
		switch (this.getName()) {
			case ("ARS") :{
				this.setValue((this.getValue() * 6.593976));		
				break;
			}
			case ("USD") :{
				this.setValue(this.getValue() * 1317.622246);		
				break;
			}
			case ("EUR") :{
				this.setValue(this.getValue() * 1389.079022);
				break;
			}
			case ("JPY") :{
				this.setValue(this.getValue() * 9.592275);
				break;
			}
			case ("GBP") :{
				this.setValue(this.getValue() * 1559.012038);
				break;
			}
		}	
	this.setName("KRW");
	this.setSymbol("₩");
	}

}
