package BeforeIGoToSleep;

import java.util.Scanner;

public class NightlyTasks {
	private String user;
	
	public NightlyTasks() {
		user = "";
	}
	public NightlyTasks(String user) {
		this.user = user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return this.user;
	}
	public void logo() {
		printDelay(" ###   ####  ####   ##   ###   ####        ###          ##    ##        #####   ##          ##   #     ####  ####  ###  ", 200);
		printDelay(" #  #  #     #     #  #  #  #  #            #          #  #  #  #         #    #  #        #  #  #     #     #     #  # ", 200);
		printDelay(" #  #  #     #     #  #  #  #  #            #          #     #  #         #    #  #        #     #     #     #     #  # ", 200);
		printDelay(" ###   ###   ###   #  #  ###   ###          #          # ##  #  #         #    #  #         ##   #     ###   ###   ###  ", 200);
		printDelay(" #  #  #     #     #  #  # #   #            #          #  #  #  #         #    #  #           #  #     #     #     #    ", 200);
		printDelay(" #  #  #     #     #  #  #  #  #            #          #  #  #  #         #    #  #        #  #  #     #     #     #    ", 200);
		printDelay(" ###   ####  #      ##   #  #  ####        ###          ###   ##          #     ##          ##   ####  ####  ####  #    ", 200);
	}
	public static void printDelay(String line, long delay) {
		Thread thread = new Thread();
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(line);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int mainMenu(String userName) {
		Scanner sc = new Scanner(System.in);
		setUser(userName);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━༻❁༺━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("   내 이름은 " + getUser() + ", 오늘 하루는 너무 길고 힘들었다ㅠㅠ");
		System.out.println("   (¦ꒉ[▓▓]  씻고 누우니까 살 것같다. 자기 전에 뭐하지..?");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━༻❁༺━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("1. 폰 게임");
		System.out.println("2. 일기 어플 실행하기");
		System.out.println("3. 넷플릭스 보기");
		System.out.println("4. 그만 자기");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	public void phoneGame() {
		Scanner sc = new Scanner(System.in);
		System.out.println("゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・ " + getUser() + "님이 로그인하셨습니다. ゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・" );
		end : 
		while(true) {
			System.out.println("===========>> 게임을 선택해주세요. <<===========");
			System.out.println("1. Up - Down 게임");
			System.out.println("2. 가위 바위 보 게임");
			System.out.println("3. 동전 맞추기 게임");
			System.out.println("0. 뒤로 가기");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			PhoneGame pg = new PhoneGame();
			switch(choice) {
			case 1:
				pg.upDown();
				break;
			case 2:
				pg.rcp();
				break;
			case 3:
				pg.randomCoin();
				break;
			case 0:
				System.out.println("메인 메뉴로 돌아갑니다.");
				break end;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}	
	}
	public void openDiary() {
		MyDiary mydiary = new MyDiary();

		finish :
		while(true) {
			switch(mydiary.firstMenu()) {
			case 1 :
				mydiary.register();
				break;
			case 2 :
				mydiary.login();
				break;
			case 3 : 
				mydiary.regiOut();
				break;
			case 4 :
				System.out.println("프로그램을 종료합니다.");
				break finish;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");	
			}
		}
	}
	public void openNetflix() {
		Scanner sc = new Scanner(System.in);
		Netflix nf = new Netflix();
		finish : 
		while(true) {
			System.out.println("゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・ Netflix ゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・");
			System.out.println("1. 시리즈 Top 10 보기 ");
			System.out.println("2. 영화 Top 10 보기 ");
			System.out.println("3. 예능 Top 10 보기");
			System.out.println("4. " + user + "의 시청 목록");
			System.out.println("0. 뒤로 가기");
			System.out.println("゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・゜・。❅゜❅ ゜");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				nf.topList();
				break;
			case 2:
				nf.movieList();
				break;
			case 3:
				nf.showList();
				break;
			case 4:
				nf.myList(user);
				break;
			case 0:
				System.out.println("이전 목록으로 돌아갑니다. ");
				break finish;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
}
