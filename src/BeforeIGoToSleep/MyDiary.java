package BeforeIGoToSleep;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyDiary {
	private Map<String, String> users;
    private Map<String, List<DiaryCont>> diaryEntries;
    private String currentUser;
    private boolean logged;
    Scanner sc = new Scanner(System.in);
    public MyDiary() {
    	users = new HashMap<>();
        diaryEntries = new HashMap<>();
        currentUser = null;
        logged = false;
    }
    
	public void logo () {
		printDelay("   ##  #   ##  ##             ####      ##        ##    #####    ##  ## ", 200);
		printDelay("  ### ##   ### ##            ##  ##     ##       ###    ##  ##   ### ##  ", 200);
		printDelay("  ######     ####            ##  ##     ##      ## ##   ##  ##     #### ", 200);
		printDelay(" ##  ##      ###            ##   ##    ##      ##  ##  ######      ###  ", 200);
		printDelay(" ##  ##     ###             ##  ##     ##     #######  ## ##      ###   ", 200);
		printDelay("##  ##     ###             ##  ##      ##     ##   ##  ##  ##    ###    ", 200);
		printDelay("##  ##     ###             ##  ##      ##     ##   ##  ##  ##    ###    ", 200);
		printDelay("##  ##     ##              #####       ##     ##   ##  ##  ##    ##     ", 200);
		printDelay("゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・゜・。❅゜❅ ゜・❅゜゜・。゜・・。。゜・", 200);
	}
	public void printDelay(String line, long delay) {
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
	public int firstMenu() {
		int choice = 0;
		System.out.println("============================ My Diary ===========================");
		System.out.println("1. 회원가입 ");
		System.out.println("2. 로그인 ");
		System.out.println("3. 회원탈퇴 ");
		System.out.println("4. 종료 ");
		System.out.println("=================================================================");
		while(true) {
			try {
				System.out.print("메뉴 선택 : ");
				choice = sc.nextInt();
				return choice;
				
			} catch (InputMismatchException e) {
				System.out.println("1 ~ 4까지의 숫자를 입력하세요.");
				sc.next();
			}
		}
	}
    public boolean login() {
    	System.out.println("============================== 로그인 ===========================");
        System.out.print("닉네임: ");
        String username = sc.next();
        
        System.out.print("비밀번호: ");
        String password = sc.next();
        
        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            System.out.println(username + "님, 로그인되었습니다.");
            logged = true;
            showMain(username);
        } else {
            System.out.println("잘못된 닉네임 또는 비밀번호입니다.");
        }
        return logged;
    }
    public void register() {
    	System.out.println("============================ 회원 가입 ===========================");
        System.out.print("닉네임 : ");
        String username = sc.next();
        
        System.out.print("비밀번호: ");
        String password = sc.next();
        
        if (users.containsKey(username)) {
            System.out.println("이미 존재하는 사용자입니다.");
        } else {
            users.put(username, password);
            System.out.println("회원 가입이 완료되었습니다. 로그인 해주세요.");
        }
    }
    public void regiOut() {
    	System.out.print("닉네임 : ");
        String username = sc.next();
        
        System.out.print("비밀번호: ");
        String password = sc.next();
        if(users.containsKey(username) && users.get(username).equals(password)) {
        	System.out.print("정말 탈퇴하시겠습니까? 1. Y / 2. N > ");
        	int regiOutYN = sc.nextInt();
        	if(regiOutYN == 1) {
        		users.remove(username, password);
        		System.out.println("탈퇴되었습니다.");
        		currentUser = null;
        		logged = false;
        	}else {
        		System.out.println("메인화면으로 돌아갑니다.");
        	}
        }else {
        	System.out.println("잘못된 닉네임 또는 비밀번호입니다.");
        }
    }
    public void showMain(String name) {
    	while(logged) {
    		System.out.println("========================== " + name + "'s Diary =========================");
    		System.out.println("1. 다이어리 작성 ");
    		System.out.println("2. 나의 다이어리");
    		System.out.println("3. 로그아웃");
    		System.out.println("========================================================================");
    		System.out.print("메뉴 선택 : ");
    		int choice = sc.nextInt();
    		
    		switch(choice) {
    		case 1 :
    			writeDiary();
    			break;
    		case 2 :
    			showDiary();
    			break;
    		case 3 :
    			logout();
    			break;
    		default :
    			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
    			break;
    		}
    	}
    }
    public void writeDiary() {
    	System.out.println("===============================================");
    	System.out.print("제목 : ");
    	sc.nextLine();
    	String title = sc.nextLine();
    	System.out.print("내용 : ");
    	String content = sc.nextLine();
    	DiaryCont diary = new DiaryCont(title, content);
    	diary.addEntry(content);
    	List<DiaryCont> userDiaries = diaryEntries.get(currentUser);
        if (userDiaries == null) {
            userDiaries = new ArrayList<>();
            diaryEntries.put(currentUser, userDiaries);
        }
        userDiaries.add(diary);
    }
    public void showDiary() {
    	List<DiaryCont> userDiaries = diaryEntries.get(currentUser);
    	if (userDiaries == null || userDiaries.isEmpty()) {
    		System.out.println("-----------------------------------------------------------------");
    		System.out.println("작성된 일기가 없습니다.");
    		System.out.println("-----------------------------------------------------------------");
    	} else {
    		showDetail(userDiaries);
    	}
        
    }
    public void logout() {
    	System.out.println(currentUser + "님 로그아웃되었습니다.");
    	currentUser = null;
    	logged = false;
    }
    public void showDetail(List<DiaryCont> userDiaries) {
    	int count = 1;
    	System.out.println("=========================== 나의 일기장 ===========================");
    	System.out.println("번호\t\t\t제목\t\t\t날짜");
    	for (DiaryCont diary : userDiaries) {
    		System.out.printf("%2d\t\t%-10s\t\t%s\n", diary.setNum(count), diary.getTitle(), diary.getDateTime().substring(0, 11));
    		count++;
    	}
    	count = 1;
    	System.out.println("==================================================================");
    	System.out.print("상세보기하시려면 글 번호를 눌러주세요. 뒤로가려면 0 > ");
		int choice = sc.nextInt();
		for(DiaryCont diary : userDiaries) {
			if(diary.getNum() == choice) {
				System.out.println("-----------------------------------------------------------------");
				System.out.println("제목 : " + diary.getTitle());
				System.out.println("작성날짜 : " + diary.getDateTime());
				System.out.println("내용 : " + diary.getContent());
				System.out.println("-----------------------------------------------------------------");
				System.out.println("1. 글 삭제 2. 뒤로가기");
				int select = sc.nextInt();
				switch(select) {
				case 1 :
					deleteDiary(diary, userDiaries);
					return;
				case 2 :
					printDelay("메뉴로 돌아갑니다.", 200);
					break;
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
			}else if(choice == 0) {
				printDelay("메뉴로 돌아갑니다.", 200);
				break;
			}
		}
    }
    public void deleteDiary(DiaryCont diary, List<DiaryCont> userDiaries) {
		userDiaries.remove(diary);
		System.out.println("삭제되었습니다.");
		if(userDiaries.isEmpty()) {
			showDiary();
		}
	}	
}
class DiaryCont {
	private Map<Integer, String> entries;
	private static int nextEntryNumber = 1;
	private String nowTime;
	private String title;
	private String content;
	private int num;
    public DiaryCont(String title, String content) {
        entries = new HashMap<>();
        nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.title = title;
        this.content = content;
    }
    
    public int setNum(int count) {
    	return this.num = count;
    }
    public int getNum() {
    	return this.num;
    }
	public void addEntry(String entry) {
        entries.put(nextEntryNumber, entry);
        nextEntryNumber++;
    }
    public int getNextEntryNumber() {
        return nextEntryNumber;
    }
    public String getTitle() {
    	return title;
    }
    public String getContent() {
    	return content;
    }
    public String getDateTime() {
    	return nowTime;
    }
}
