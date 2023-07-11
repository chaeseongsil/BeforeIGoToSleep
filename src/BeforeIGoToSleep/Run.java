package BeforeIGoToSleep;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NightlyTasks nt = new NightlyTasks();
		nt.logo();
		System.out.print("이름을 알려주세요. >> ");
		String user = sc.next();
		finish :
			while(true) {
				switch(nt.mainMenu(user)) {
				case 1 :
					nt.phoneGame();
					break;
				case 2 :
					nt.openDiary();
					break;
				case 3 : 
					nt.openNetflix();
					break;
				case 4 :
					System.out.println("하암~ (￣ρ￣)..zZ 이만 자야겠다...");
					System.out.println("(프로그램이 종료되었습니다.)");
					break finish;
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");	
				}
			}
	}
}
