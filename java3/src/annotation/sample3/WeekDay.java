package annotation.sample3;

public enum WeekDay {
	
	//원하는 값으로 설정하려면 생성자를 이용해 줘야 한다 ( 멤버변수도 준비되어야 한다)
	MON("월") , THE("화") ,  WED("수") , THU("목") , FRI("금");
	
	private String name;
	
	
	WeekDay( String name){
		this.name = name;
	}
	
    public String getName() {
         return name;
    }
	
}
