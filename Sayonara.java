import java.util.*;

class Sayonara{
	//Working days in Jan= 23;
	//Working days in Feb= 20;
	//Working days in Mar= 22;

	public static void main(String[] args){
		int workDays = 65;
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of joinees?");
		int N = sc.nextInt();
		
		System.out.println("Name of joinees?");
		String[] joinee = new String[N];
		for(int i=0;i<joinee.length;i++){
			joinee[i] = sc.next();
		}

		int[] result = attendanceCounter(joinee,workDays);
		int[] perc1 = format1(joinee,result,workDays);
		int[] perc2 = format2(joinee,result,workDays);
		int[] perc3 = format3(joinee,result,workDays);
		System.out.println("Total days and percentage worked by :");
		for(int i=0;i<N;i++){
			System.out.print(joinee[i]+" : ");
			System.out.println(result[i]);
			System.out.println("Out of total working days : "+perc1[i]+"%");
			System.out.println("97% out of 100% : "+perc2[i]+"%");
			System.out.println("91% out of 97% : "+perc3[i]+"%");
			System.out.println();
		}
	}

	public static int[] attendanceCounter(String[] joinee,int workDays){
		int[] joineeDays = new int[joinee.length];
		
		try{
			for(int i =0;i<joinee.length;i++){
				for(int j = 1;j<=workDays;j=j+5){
					if(i%2==0){
						if(j%2==0){
							joineeDays[i] = joineeDays[i]+0;
						}
						else{
							joineeDays[i]= joineeDays[i]+1;
						}
					}
					else if(i%2 !=0){
						if(j%2==0){
							joineeDays[i] = joineeDays[i]+1;
						}
						else{
							joineeDays[i]= joineeDays[i]+0;
						}
					}
				}
			}
			for(int i=0;i<joineeDays.length;i++){
				joineeDays[i] = workDays - joineeDays[i];
			}
		}
		catch(ArrayIndexOutOfBoundsException e){}
		return joineeDays;
	}

	public static int[] format1(String[] joinee, int[] result,int workDays){
		int[] form1 = new int[joinee.length];
		for(int i=0;i<joinee.length;i++){
			int temp1 = result[i];
			int temp2= (temp1*100)/workDays;
			form1[i] = temp2;
		}
		return form1;
	}
	public static int[] format2(String[] joinee, int[] result,int workDays){
		int[] form2 = new int[joinee.length];
		for(int i=0;i<joinee.length;i++){
			int temp1 = result[i];
			int temp2 = (97*((100*temp1)/workDays))/100;
			form2[i] = temp2;
		}
		return form2;
	}
	public static int[] format3(String[] joinee, int[] result,int workDays){
		int[] form3 = new int[joinee.length];
		for(int i=0;i<joinee.length;i++){
			int temp1 = result[i];
			int temp2 = (91*(97*((100*temp1)/workDays))/100)/100;
			form3[i] = temp2;
		}
		return form3;
	}
}