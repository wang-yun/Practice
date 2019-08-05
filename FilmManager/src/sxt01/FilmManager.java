package sxt01;

import java.util.Scanner;

public class FilmManager {
	private Film[] films=new Film[100]; // 存储电影的数组
	private int count=0; // 记录电影数量
	public FilmManager() {
		
		this.films[0] = new Film("我不是药神", "文牧野", "徐峥", 120);
		this.films[1] = new Film("西红柿首富", "沈腾", "沈腾", 130);
		this.films[2] = new Film("爱情公寓", "陈赫", "陈赫", 140);

		this.count = 3;
	}

	public void start() {
		System.out.println("欢迎sxt国际影城");
		System.out.println("------------------------------");
		System.out.println("1.添加电影");
		System.out.println("2.查看电影");
		System.out.println("3.删除电影");
		System.out.println("4.退出");
		System.out.println("------------------------------");
		System.out.println("请选择:");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
			case 1: {
				this.add();
				break;
			}
			case 2: {
				this.check();
				break;
			}
			case 3: {
				this.delete();
				break;
			}
			case 4: {
				System.out.println("程序退出");
				break;
			}
			default: {
				break;
			}
		}

	}

	private void add() {
		System.out.println("-->添加电影:");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入电影名称:");
		String name = sc.nextLine();
		
		System.out.println("请输入导演:");
		String director = sc.nextLine();
		
		System.out.println("请输入主演:");
		String actors = sc.nextLine();
		
		System.out.println("请输入时长:");
		int time = sc.nextInt();
		
		Film f = new Film(name, director, actors, time);
		this.films[this.count++] = f;
		System.out.println("《"+name+"》添加成功!");
		
		this.back();
	}

	private void delete() {
		// 1.输入电影名称
		System.out.println("请输入要删除的电影名称:");
		Scanner sc = new Scanner(System.in);
		String name = sc .nextLine();
		
		// 2.查找电影
		int loc = -1;
		for(int i=0;i<this.count;i++) {
			if(name.equals(this.films[i].getName())) {
				loc = i;
				break;
			}
		}
		
		if(loc < 0) {
			System.out.println("对不起，没有要删除的电影!");
		}else {
			// 3.删除电影
			for(int j=loc+1;j<this.count;j++) {
				this.films[j-1] = this.films[j];
			}
			
			this.count--;
			// 4.把最后一个元素置空
			this.films[this.count] = null;
			System.out.println("《"+name+"》删除成功!");
		}
		
		this.back();
		
	}

	private void check() {
		System.out.println("-->查看资讯:");
		System.out.println("序号\t电影名称\t\t导演\t主演\t时长");
		for (int i = 0; i < this.count; i++) {
			this.films[i].showInfo(i + 1);
		}
		
		back();
	}

	private void back() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("按0返回:");
			int n = sc.nextInt();
			if (n == 0) {
				break;
			} else {
				System.out.println("输入错误。");
			}
		} while (true);

		this.start();
	}

}
