/**
 * @author Ro1zer 
 * Program name - Stations
 */
package MetroStations;
import java.util.Scanner;
public class MetroStations {
	/*
	 * Код має 3 етапи
	 * 1 - декларування та ініціалізація змінни
	 * 2 - Введення стартової станції
	 * 3 - Перевірка на існування такої станції
	 * 4 - Введення кінцевої станції
	 * 5 - Перевірка на існування такої станції
	 * 6 - Знаходження довжини між станціями,які будуть для нас орієнтиром,через скільки та на якій саме нам потрібно вийти
	 */
	public static void main(String[] args) {
		//Декларування та ініціалізація головних змінних
		System.out.println("Вас вітає программа Stations\nВ цій программі ви зможете кратко та чітко визначити через скільки станцій вам потрібно буде проїхати,щоб дістатися до тієї,до якої ви прямуєте.");
		Scanner scan = new Scanner(System.in);
		String start,stop;
		String []red = {"Академмістечко","Житомирська","Святошин","Нивки","Берестейська","Шулявська","Поітехнічний інститут","Вокзальна","Університет","Театральна","Хрещатик","Арсенальна","Дніпро","Гідропарк","Лівобережна","Дарниця","Чернігівська","Лісова"};
		String []blue = {"Героїв Дніпра","Мінська","Оболонь","Почайна","Тараса Шевченка","Контрактова площа","Поштова площа","Майдан Незалежності","Площа Льва Толстого","Олімпійська","Палац Україна","Либідська","Деміївська","Голосіївська","Васильківська","Виставковий центр","Іподром","Теремки"};
		String []green = {"Сирець","Дорогожичі","Лук`янівська","Золоті Ворота","Палац Спорту","Кловська","Печерська","Дружби народів","Видубичі","Славутич","Осокорки","Позняки","Харківська","Вирлиця","Бориспільська","Червоний Хутір"};
		short startStation = 0,stopStation = 0;
		boolean trueStartRed=false,trueStartBlue=false,trueStartGreen=false;
		boolean trueStopRed = false,trueStopBlue=false,trueStopGreen=false;

		//*Введення стартової станції та перевірка на існування(чи існує у масиві станція з такою назвою)
		System.out.print("Введіть початкову станцію: ");
		start = scan.nextLine();
		//Цикл,в якому виконується перевірка,він закінчиться як тільки одне з значень стане true(trueStartRed,trueStartBlue,trueStartGreen),тобто знайде співпадіння
		for(short go = 0;(!trueStartRed)||(!trueStartBlue)||(!trueStartGreen);go++) {
			//Якщо не знайшло співпадіння
			if((go == 18)&&(trueStartRed == false)&&(trueStartBlue == false)&&(trueStartGreen == false)) {
				System.out.println("Помилка!\nІнвалідні данні!");
				return;
			}
			//Якщо стартова станція є у Червоної гілці,
			else if(start.toUpperCase().equals(red[go].toUpperCase())) {
				//Записуємо її індекс
				startStation = go;
				//!Даємо команду що співпадіння знайдено
				trueStartRed = true;
				//Виходимо з умовного оператору 
				break;
			}
			//Якщо стартова станція є у Синій гілці
			else if(start.toUpperCase().equals(blue[go].toUpperCase())) {
				//Записуємо її індекс
				startStation = go;
				//!Даємо команду що співпадіння знайдено
				trueStartBlue = true;
				//Виходимо з умовного оператору
				break;
			}
			//оскільки масив Зеленої гілки має лише 16 станцій,щоб уникнути помилки в циклі робимо запобіжник,щоб коли крок дорівнював 16,вже не перевіряли зелену гілку
			else if(go<16) {
				//Якщо стартова станція є у Зеленій гілці
				if(start.toUpperCase().equals(green[go].toUpperCase())) {
					//Записуємо її індекс
					startStation = go;
					//!Даємо команду що співпадіння знайдено
					trueStartGreen = true;
					//Виходимо з умовного оператору
					break;
					//!Якщо одне зі значенб отримало команду true,Цикл закривається
				}
			}
		}
		//*Введення та перевірка кінцевої станції на існування(чи існує у масиві станція з такою назвою)
		//!Все працює за такоюж аналогією як і стартова перевірка,коментувати на має сенсу
		System.out.print("Введіть кінцеву станцію: ");
		stop = scan.nextLine();
		scan.close();//закриваємо сканер оскільки він нам більше не знадобиться
		for(short go = 0;(!trueStopRed)||(!trueStopBlue)||(!trueStopBlue);go++) {
			if((go == 18)&&(trueStopRed == false)&&(trueStopBlue == false)&&(trueStopGreen == false)) {
				System.out.println("Помилка!\nІнвалідні данні!");
				return;
			}
			else if(stop.toUpperCase().equals(red[go].toUpperCase())) {
				stopStation	= go;
				trueStopRed=true;
				break;
			}
			else if(stop.toUpperCase().equals(blue[go].toUpperCase())) {
				stopStation = go;
				trueStopBlue = true;
				break;
			}
			else if(go<16) {
				if(stop.toUpperCase().equals(green[go].toUpperCase())) {
					stopStation = go;
					trueStopGreen = true;
					break;
				}
			}
		}

		/*
		 * Операція розраховування ділиться на декілька етапів:
		 * 1 - обчислюємо відстань між станціями
		 * 1 - передача розрахунків та станцій які обчислюємо в методи
		 * 1 - в залежності від результату обчислення буде виводитися різна відповідь
		 *
		 */
		//1Якщо стартова та кінцева станції знаходяться на Червоній гілці
		if((trueStartRed == true) && (trueStopRed == true)) {
			//1.1Розрахунки
			short rezult = (short) (startStation-stopStation);
			OneLength(red,rezult);
			return;
		}
		// 1.1 Якщо стартова станція на Червоній гілці а кінцева на Синій
		else if((trueStartRed==true)&&(trueStopBlue==true)) {
			short len1=(short)(startStation-10),len2=(short)(stopStation-7);
			OurRelation(red,blue,len1,len2);
			return;
		}
		// 1.2 Якщо стартова на Червоній гілці а кінцева на Зеленій гілці
		else if((trueStartRed==true)&&(trueStopGreen==true)) {
			short len1=(short)(startStation-9),len2=(short)(stopStation-3);
			OurRelation(red,green,len1,len2);
			return;
		}
		//2Якщо стартова та кінцеа станції знаходяться на Синій гілці
		else if((trueStartBlue == true)&&(trueStopBlue == true)) {
			//Розрахунки
			short rezult = (short)(startStation-stopStation);
			OneLength(blue,rezult);
			return;
		}
		//2.1 Якщо стартова на Синій а кінцева на Червоній
		else if((trueStartBlue==true)&&(trueStopRed==true)) {
			short len1=(short)(startStation-7),len2=(short)(stopStation-10);
			OurRelation(blue,red,len1,len2);
			return;
		}
		//2.2 Якщо стартова на Синій а кінцева на Зеленій
		else if((trueStartBlue==true)&&(trueStopGreen==true)) {
			short len1=(short)(startStation-8),len2=(short)(stopStation-4);
			OurRelation(blue,green,len1,len2);
			return;
		}
		//3Якщо стартова та цінцевва станції знаходться на Зеленій гілці
		else if((trueStartGreen == true)&&(trueStopGreen == true)) {
			//Розрахунки
			short rezult = (short) (startStation-stopStation);
			OneLength(green,rezult);
			return;
		}
		//3.1Якщо стартова станція на Зеленій а кінцева на Червоній
		else if((trueStartGreen==true)&&(trueStopRed==true)) {
			short len1=(short)(startStation-3),len2=(short)(stopStation-9);
			OurRelation(green,red,len1,len2);
			return;
		}
		//3.2Якщо стартова на Зеленій а кінцева на Синій
		else if((trueStartGreen==true)&&(trueStopBlue==true)) {
			short len1=(short)(startStation-4),len2=(short)(stopStation-8);
			OurRelation(green,blue,len1,len2);
			return;
		}
		//Якщо ніякий з варіантів не пройшов
		else {
			System.out.println("Знайдена невідома помилка!\nЗверніться до розробника");
			return;
		}
	}
	/**
	 * Цей метод зберігає в собі шаблон дій,для того випадку,якщо станції знаходяться на одній гілці
	 * @param arr - масив однієї з гілок,в якому знаходяться всі наші станції цієї гілки
	 * @param rezult - змінна за допомогою якої ми визначаємо довжину між однією станцією та іншою,а також,в який бік потрібно їхати
	 */
	public static void OneLength(String[]arr,short rezult) {
		//1.2Якщо резултат(-)
		if (rezult<0) {
			//1.3 У випадку яцщо станції знаходяться одна біля одної
			if(Math.abs(rezult)-1 == 0) {
				System.out.println("Сядьте у потяг,який рухається у бік станції "+(arr[arr.length-1])+",та виходьте на наступній станції.");

			}
			//1.2 В іншому випадку - кажемо в бік якої станції рухатися
			else{
				System.out.println("Сядьте у потяг,який рухається у бік станції "+(arr[arr.length-1])+",та виходьте на "+Math.abs(rezult)+"-й станції.");
			}
		}
		//1.2Якщо резултат(+)
		else if(rezult > 0){
			//1.3 У випадку яцщо станції знаходяться одна біля одної
			if(Math.abs(rezult)-1 == 0) {
				System.out.println("Сядьте у потяг,який рухається у бік станції "+(arr[arr.length-arr.length])+",та виходьте на наступній станції.");
			}
			//1.2 В іншому випадку - кажемо в бік якої станції рухатися
			else {
				System.out.println("Сядьте у потяг,який рухається у бік станції "+(arr[arr.length-arr.length])+",та виходьте на "+rezult+"-й станції.");
			}
		}
		else if(rezult == 0 ) {
			System.out.println("Ви вже на цій станції :D");
		}
	}
	/**
	 * Цей метод зберігає в собі варіант дії,на той випадок якщо станції знаходяться на різних гілках
	 * @param arrStart - масив зі стартовою станцією
	 * @param arrStop - масив зі кінцевою станцією
	 * @param len1 - довжина між стартовою станцією та станцією з пересадкою
	 * @param len2 - довжина між кінцевою станцією та станцією з пересадкою
	 */
	public static void OurRelation(String[]arrStart,String[]arrStop,short len1,short len2) {
		if((len1<0) && (len2<0)) {
			System.out.println("Сядьте у потяг,який рухається у бік станції "+arrStart[arrStart.length-1]+" та виходьте на "+Math.abs(len1)+"-й станції.\nПотім перейдіть на наступну станцію за допомогою пересадочного тонелю\nСядьте в потяг,який рухається у бік станції "+arrStop[arrStop.length-arrStop.length]+" та виходьте на "+Math.abs(len2)+"-й станції.");
		}
		else if((len1>0) && (len2>0)) {
			System.out.println("Сядьте у потяг,який рухається у бік станції "+arrStart[arrStart.length-arrStart.length]+" та виходьте на "+len1+"-й станції.\nПотім перейдіть на наступну станцію за допомогою пересадочного тонелю\nСядьте в потяг,який рухається у бік станції "+arrStop[arrStop.length-1]+" та виходьте на "+len2+"-й станції.");
		}
		else if((len1<0) && (len2>0)) {
			System.out.println("Сядьте у потяг,який рухається у бік станції "+arrStart[arrStart.length-1]+" та виходьте на "+Math.abs(len1)+"-й станції.\nПотім перейдіть на наступну станцію за допомогою пересадочного тонелю\nСядьте в потяг,який рухається у бік станції "+arrStop[arrStop.length-1]+" та виходьте на "+len2+"-й станції.");
		}
		else if((len1>0) && (len2<0)) {
			System.out.println("Сядьте у потяг,який рухається у бік станції "+arrStart[arrStart.length-arrStart.length]+" та виходьте на "+len1+"-й станції.\nПотім перейдіть на наступну станцію за допомогою пересадочного тонелю\nСядьте в потяг,який рухається у бік станції "+arrStop[arrStop.length-arrStop.length]+" та виходьте на "+Math.abs(len2)+"-й станції.");
		}
		else if((len1 == 0) && (len2 == 0)) {
			System.out.println("Перейдіть на наступну станцію за допомогою пересадочного тонелю.");
		}
		else if((len1 == 0) && (len2 > 0)) {
			System.out.println("Перейдіть на наступну станцію за допомогою пересадочного тонелю.\nСядьте в потяг,який рухається у бік станції "+arrStop[arrStop.length-1]+" та виходьте на "+len2+"-й станції.");
		}
		else if((len1 == 0) && (len2 < 0)) {
			System.out.println("Перейдіть на наступну станцію за допомогою пересадочного тонелю.\nСядьте в потяг,який рухається у бік станції "+arrStop[arrStop.length-arrStop.length]+" та виходьте на "+Math.abs(len2)+"-й станції.");
		}
		else if((len1 > 0) && (len2 == 0)) {
			System.out.println("Сядьте у потяг,який рухається у бік станції "+arrStart[arrStart.length-arrStart.length]+" та виходьте на "+len1+"-й станції.\nПерейдіть на наступну станцію за допомогою пересадочного тонелю");
		}
		else if((len1 < 0) && (len2 == 0)) {
			System.out.println("Сядьте у потяг,який рухається у бік станції "+arrStart[arrStart.length-1]+" та виходьте на "+Math.abs(len1)+"-й станції.\nПерейдіть на наступну станцію за допомогою пересадочного тонелю");
		}
		else {
			System.out.println("Знайдена невідома помилка!\nЗверніться до розробника та зробіть баг-репорт");
		}
	}
}