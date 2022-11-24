package customer.project;


public class VIPCustomerOther extends Customer {
	private int agentID;
	double saleRatio;
	
	public VIPCustomerOther(int customerID, String customerName, int agentID){
		super(customerID, customerName);
	
		super.customerGrade = "VIP";
		super.bonusRatio = 0.03;
		this.saleRatio = 0.2;
		this.agentID = agentID;
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	}

	@Override
	public String showCustomerInfo() {
		return String.format(
				"%s님의 등급: %s, 보너스 포인트: %d점, 담당 상담원 번호: %d",
				customerName,
				customerGrade,
				bonusPoint,
				agentID
				);
	}

	public int getAgentID(){
		return agentID;
	}
}
