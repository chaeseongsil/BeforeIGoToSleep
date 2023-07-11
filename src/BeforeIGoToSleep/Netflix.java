package BeforeIGoToSleep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

public class Netflix {
	Scanner sc = new Scanner(System.in);
	Set<String> mySet = new HashSet<>();
	public void topList() {
		List<String> topList = new ArrayList<>();
		topList.add("셀러브리티");
		topList.add("마당이 있는 집");
		topList.add("킹더랜드");
		topList.add("이번 생도 잘 부탁해");
		topList.add("사냥개들");
		topList.add("어느날 우리집 현관으로 멸망이 들어왔다.");
		topList.add("청담 국제 고등학교");
		topList.add("쉬는 부부");
		topList.add("위쳐");
		topList.add("최애의 아이");
		while(true) {
			System.out.println("============ 시리즈 Top 10 ============");
			for(int i = 0; i < topList.size(); i++) {
				System.out.println((i+1) + " : " + topList.get(i));
			}
			System.out.println("================================");
			System.out.print("재생할 컨텐츠 번호를 선택해주세요. 뒤로 가려면 0을 눌러주세요. : ");
			int choice = sc.nextInt();
			if(choice <= 10) {
				if(choice == 0) {
					break;
				}
				for(int i = 0; i < topList.size(); i++) {
					if((i+1) == choice) {
						System.out.println(topList.get(i) + "를 시청하셨습니다.");
						mySet.add(topList.get(i));
						break;
					}
				}
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
	}
	public void movieList() {
		List<String> movieList = new ArrayList<>();
		movieList.add("내부자들 : 디 오리지널");
		movieList.add("익스트랙션2");
		movieList.add("장화 신은 고양이");
		movieList.add("스카이스크래퍼");
		movieList.add("사도행자");
		movieList.add("카운트");
		movieList.add("익스트랙션");
		movieList.add("샷건 웨딩");
		movieList.add("서치2");
		movieList.add("런 래빗 런");
		while(true) {
			System.out.println("============ 영화 Top 10 ============");
			for(int i = 0; i < movieList.size(); i++) {
				System.out.println((i+1) + " : " + movieList.get(i));
			}
			System.out.println("================================");
			System.out.print("재생할 컨텐츠 번호를 선택해주세요. 뒤로 가려면 0을 눌러주세요. : ");
			int choice = sc.nextInt();
			if(choice <= 10) {
				if(choice == 0) {
					break;
				}
				for(int i = 0; i < movieList.size(); i++) {
					if((i+1) == choice) {
						System.out.println(movieList.get(i) + "를 시청하셨습니다.");
						mySet.add(movieList.get(i));
						break;
					}
				}
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
	}
	public void showList() {
		List <String> showList = new ArrayList<>();
		showList.add("아는 형님");
		showList.add("하트시그널");
		showList.add("알유넥스트");
		showList.add("최강야구");
		showList.add("금쪽 같은 내새끼");
		showList.add("솔로지옥");
		showList.add("용감한 형사들");
		showList.add("코리아 넘버원");
		showList.add("나는 SOLO");
		showList.add("연애 참견");
		while(true) {
			System.out.println("============ 예능 Top 10 ============");
			for(int i = 0; i < showList.size(); i++) {
				System.out.println((i+1) + " : " + showList.get(i));
			}
			System.out.println("================================");
			System.out.print("재생할 컨텐츠 번호를 선택해주세요. 뒤로 가려면 0을 눌러주세요. : ");
			int choice = sc.nextInt();
			if(choice <= 10) {
				if(choice == 0) {
					break;
				}
				for(int i = 0; i < showList.size(); i++) {
					if((i+1) == choice) {
						System.out.println(showList.get(i) + "를 시청하셨습니다.");
						mySet.add(showList.get(i));
						break;
					}
				}
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
	}
	public void myList(String user) {
		if(mySet.isEmpty()) {
			System.out.println("------------------------------------------------");
			System.out.println("시청 목록이 존재하지 않습니다.");
			System.out.println("------------------------------------------------");
		}else {
			finish : 
			while(true) {
				System.out.println("============ " + user + "의 시청 목록 ==============");
				Iterator<String> it = mySet.iterator();
				while(it.hasNext()) {
					System.out.println(it.next().toString());
				}
				System.out.println("=================================================");
				System.out.println("1. 이어보기 2. 삭제하기 0. 뒤로가기");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.print("이어보기할 컨텐츠명을 입력해주세요 : ");
					sc.nextLine();
					String replayTitle = sc.nextLine();
					if(mySet.contains(replayTitle)) {
						System.out.println(replayTitle + "를 시청하셨습니다.");
						break;
					}else {
						System.out.println("해당 컨텐츠는 존재하지 않습니다.");
					}
					break;
				case 2:
					System.out.print("삭제할 컨텐츠명을 입력해주세요 : ");
					sc.nextLine();
					String removeTitle = sc.nextLine();
					
					if(mySet.contains(removeTitle)) {
						mySet.remove(removeTitle);
						System.out.println(removeTitle + "이(가) 삭제되었습니다.");
						break;
					}else {
						System.out.println("해당 컨텐츠는 존재하지 않습니다.");
					}
					break;
				case 0:
					System.out.println("이전 메뉴로 돌아갑니다.");
					break finish;
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}				
			}
		}
	}
}
