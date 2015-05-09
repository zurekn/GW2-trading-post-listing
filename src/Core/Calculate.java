package Core;

import java.text.DecimalFormat;

public class Calculate {

	private int poIn = 0;
	private int poOut = 0;
	private int psIn = 0;
	private int psOut = 0;
	private int pcIn = 0;
	private int pcOut = 0;
	private int number = 1;
	
	private boolean isIn = false;
	private boolean isOut = false;
	
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPoIn() {
		return poIn;
	}
	public void setPoIn(int poIn) {
		this.poIn = poIn;
	}
	public int getPoOut() {
		return poOut;
	}
	public void setPoOut(int poOut) {
		this.poOut = poOut;
	}
	public int getPsIn() {
		return psIn;
	}
	public void setPsIn(int psIn) {
		this.psIn = psIn;
	}
	public int getPsOut() {
		return psOut;
	}
	public void setPsOut(int psOut) {
		this.psOut = psOut;
	}
	public int getPcIn() {
		return pcIn;
	}
	public void setPcIn(int pcIn) {
		this.pcIn = pcIn;
	}
	public int getPcOut() {
		return pcOut;
	}
	public void setPcOut(int pcOut) {
		this.pcOut = pcOut;
	}
	public boolean isIn() {
		return isIn;
	}
	public void setIn(boolean isIn) {
		this.isIn = isIn;
	}
	public boolean isOut() {
		return isOut;
	}
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

	public String getCost() {
		
		return null;
	}

	public String getSellingFee() {

		float f = new Float(getOut());
		Double res = (f*0.10) * number;
		String s = ""+format(res);


		return s;
	}

	public String getListingFee() {
		float f = new Float(getOut());
		Double res = (f*0.05) * number;
		String s = ""+format(res);
		return s;
	}

	public String getProfit() {
		
		float in = new Float(getIn());
		float out = new Float(getOut());
		double res = (out * 0.85 - in) * number;
		String s = ""+format(res);
		return s;
	}
	
	public String format(double f){
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		return df.format(f);
	}
	
	private String getIn(){
		String po = ""+poIn;
		String ps = ""+psIn;
		String pc = ""+pcIn;

		if(psIn < 10)
			ps = "0"+ps;
		if(pcIn < 10)
			pc = "0"+pc;
		return po+ps+"."+pc;
	}
	
	private String getOut(){
		String po = ""+poOut;
		String ps = ""+psOut;
		String pc = ""+pcOut;
		
		if(psOut < 10)
			ps = "0"+ps;
		if(pcOut < 10)
			pc = "0"+pc;
		return po+ps+"."+pc;
	}
	
	
}
