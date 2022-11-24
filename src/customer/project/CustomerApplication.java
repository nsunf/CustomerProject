package customer.project;


import java.util.ArrayList;

public class CustomerApplication {

	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public static void main(String[] args) {	
		Customer customerLee = new Customer(10010, "이순신");
		Customer customerShin = new Customer(10020, "신사임당");
		Customer customerHong = new GoldCustomer(10030, "홍길동");
		Customer customerYul = new GoldCustomer(10040, "정약용");
		Customer customerKim = new VIPCustomer(10050, "이율곡", 12345);
		
		/*
		【문항5】 아래 항목과 클래스 다이어그램을 참고하여 CustomerApplication.java에서 main 메소드를 완성하시오.
        - customerList에 Customer 객체 5개를 삽입한다.
        - 모든 고객 정보를 출력한다.(showAllCustomer 메소드 이용)
        - 이율곡의 id로 찾은 고객의 실제 지불금액, 보너스 포인트를 출력한다. (findCustomer 메소드 이용)
        - 만약 findCustomer 메소드로 리턴받은 Customer 객체가 null이라면  
          ‘존재하지 않는 회원입니다.’를 출력하고 그렇지 않으면 showPriceBonus 메소드를 호출하고
          상품가격은 10000원을 준다.
          */
		
		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerHong);
		customerList.add(customerYul);
		customerList.add(customerKim);
		
		showAllCustomer();
		
		Customer c = findCustomer(10050);
		
		if (c == null) {
			System.out.println("존재하지 않는 회원입니다.");
		} else {
			showPriceBonus(c, 10000);
		}
	}
	
	public static void showAllCustomer() {
		/*
		 【문항6】 클래스 다이어그램을 참고하여 CustomerApplication.java에서 모든 고객정보를 출력하는   
        showAllCustomer 메소드를 완성하시오.
		 */
		System.out.println("======모든 고객 정보 출력======");
		for (Customer c : customerList) {
			System.out.println(c.showCustomerInfo());
		}
	}
	
	public static Customer findCustomer(int customerID) {
		/*
		 【문항7】 클래스 다이어그램을 참고하여 CustomerApplication.java에서 고객 id를 이용해 해당
        Customer 객체를 찾는 findCustomer 메소드를 완성하시오.
		 */
		
		Customer result = null;
		
		for (Customer c : customerList) {
			if (c.getCustomerID() == customerID) {
				result = c;
				break;
			}
		}
		
		return result;
	}
	
	public static void showPriceBonus(Customer customer, int price) {
		/*
		 【문항8】클래스 다이어그램을 참고하여 CustomerApplication.java에서 해당 고객의 할인율과
        보너스 포인트를 보너스 포인트 계산하는 showPriceBonus 메소드를 완성하시오.
		 */
		System.out.println("====== 해당 고객의 할인율과 보너스 포인트 계산======");
		System.out.printf("%s님의 지불금액: %d원\n", customer.getCustomerName(), customer.calcPrice(price));
		System.out.printf("%s님의 현재 보너스 포인트: %d점\n", customer.getCustomerName(), customer.bonusPoint);
	}
}
