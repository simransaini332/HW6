package hw6;

import java.util.*;
public class record
{
	static void displayRecords(ArrayList <stock> arr)
	{
		System.out.println("****************");

		for(int i=0;i<arr.size();i++)
		{
			stock temp=arr.get(i);
			System.out.println( temp.getName());
			System.out.println("cost in dollors for the company is : " + temp.costInDollars());
			System.out.println("value in dollors for the company is :"+temp.valueInDollars());
		}
		System.out.println("****************");
	}
	static void sorting(ArrayList <stock> arr)
	{
		stock t;
		for(int i=0;i<arr.size();i++)
		{
			for(int j=i+1;j<arr.size();j++)
			{
				String a=arr.get(i).getName();
				String b=arr.get(j).getName();
               if(a.compareTo(b)>0)
               {
            	   t=arr.get(i);
            	   arr.set(i,arr.get(j));
            	   arr.set(j, t);
               }
			}
		}
	}
	static void revsorting(ArrayList <stock> arr)
	{
		stock t;
		for(int i=0;i<arr.size();i++)
		{
			for(int j=i+1;j<arr.size();j++)
			{
				String a=arr.get(i).getName();
				String b=arr.get(j).getName();
               if(a.compareTo(b)<=0)
               {
            	   t=arr.get(i);
            	   arr.set(i,arr.get(j));
            	   arr.set(j, t);
               }
			}
		}
	}
	static void display(ArrayList <stock> arr)
	{
		for(int i=0;i<arr.size();i++)
		{
			stock temp=arr.get(i);
			System.out.println("**************** \n" + temp.getName());
			System.out.println("cost in dollors for the company is : " + temp.costInDollars());
			System.out.println("value in dollors for the company is :"+temp.valueInDollars());
		}
		System.out.println("****************");
	}
	public static void main(String args[])
	{
		ArrayList <stock> arr=new ArrayList<stock>();
		arr.add(new stock());
		arr.add(new stock());
		arr.add(new stock());
		arr.get(0).setName("abc");
		arr.get(0).setSharePrice(2.30f, 4.50f);
        arr.get(0).setShares(40);
	    arr.get(1).setName("xyz");
		arr.get(1).setSharePrice(12.19f, 10.56f);
		arr.get(1).setShares(90);
	    arr.get(2).setName("urlstocksimple");
		arr.get(2).setSharePrice(45.10f, 49.51f);
		arr.get(2).setShares(210);
		sorting(arr);
		System.out.println("records after sorting in ascending order");
		display(arr);
		arr.add(new foreignStockHolding1());
		arr.add(new foreignStockHolding1());
		arr.get(3).setName("gyi");
		arr.get(3).setSharePrice(2.30f, 4.50f);
		arr.get(3).setShares(40);
		arr.get(4).setName("kjlk");
		arr.get(4).setSharePrice(2.30f, 4.50f);
		arr.get(4).setShares(40);
		revsorting(arr);
		System.out.println("records after sorting in descending  order");
		display(arr);
		int num;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of stocks");
		num=sc.nextInt();
		String type;
		int x=0;int v=5;
		while(x<=num)
		{		System.out.println("enter the type of stock");
		type=sc.nextLine();
		if(type.compareTo("simple")==0)
		{
			System.out.println("Enter the values for fields -- >(name,purchase share price,current share price,number of shares)");
         arr.add(new stock());
         arr.get(v).setName(sc.nextLine());
         arr.get(v).setSharePrice(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()));
	     arr.get(v).setShares(Integer.parseInt(sc.nextLine()));
	     x++;v++;
		}

		else if(type.compareTo("foriegn")==0)
		{
			System.out.println("Enter the values for fields --> (name,purchase share price,current share price,number of shares)");
	         arr.add(new stock());
	         arr.get(v).setName(sc.nextLine());
	         arr.get(v).setSharePrice(Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()));
		     arr.get(v).setShares(Integer.parseInt(sc.nextLine()));
		     x++;v++;	
		}
		else {
			System.out.println("enter a valid type");

		}
		}
		float lowestval=10000;
		float highestval=-1;
		float mostProfitableValue=-1;
		float leastProfitableValue=10000;
		for(int i=0;i<arr.size();i++)
		{
			if(lowestval>arr.get(i).valueInDollars())
				lowestval=arr.get(i).valueInDollars();
			if(highestval<arr.get(i).valueInDollars())
				highestval=arr.get(i).valueInDollars();
			if(mostProfitableValue<arr.get(i).valueInDollars()-arr.get(i).costInDollars())
				mostProfitableValue=arr.get(i).valueInDollars()-arr.get(i).costInDollars();
			if(leastProfitableValue>arr.get(i).valueInDollars()-arr.get(i).costInDollars())
				leastProfitableValue=arr.get(i).valueInDollars()-arr.get(i).costInDollars();
				
		}
		int ch;
	    while(true)
	    {
			System.out.println("*************MENU******************");
			System.out.println("1)	Display stock information with the lowest value\r\n" + 
					"2)	Display stock with the highest value\r\n" + 
					"3)	Display the most profitable stock\r\n" + 
					"4)	Display the least profitable stock\r\n" + 
					"5)	List all stocks sorted by company name (A-Z)\r\n" + 
					"6)	List all stocks sorted from the lowest value to the highest value\r\n" + 
					"7)	Exit\r\n" + 
					"");
			System.out.println("enter choice ");
            ch=sc.nextInt();
			switch(ch)
			{
			
			case 1: 
				System.out.println("------------------------------------------------------------");
				System.out.println("stock with lowest value :");
				for(int i=0;i<arr.size();i++)
				{
					if(lowestval==arr.get(i).valueInDollars())
					{
						System.out.println(arr.get(i).getName());
						System.out.println(arr.get(i).costInDollars());
						System.out.println(arr.get(i).valueInDollars());
						break;
					}
				}
				break;
			case 2:
				System.out.println("-------------------------------------------------------------");
				System.out.println("stock with the highest value :");
				for(int i=0;i<arr.size();i++)
				{
					if(highestval==arr.get(i).valueInDollars())
					{
						System.out.println(arr.get(i).getName());
						System.out.println(arr.get(i).costInDollars());
						System.out.println(arr.get(i).valueInDollars());
						break;
					}
				}
				break;
			case 3:
				System.out.println("-------------------------------------------------------------");
				System.out.println("most profitable stock :");
				for(int i=0;i<arr.size();i++)
				{
					if(mostProfitableValue==arr.get(i).valueInDollars()-arr.get(i).costInDollars())
					{
						System.out.println(arr.get(i).getName());
						System.out.println(arr.get(i).costInDollars());
						System.out.println(arr.get(i).valueInDollars());
						break;
					}
				}
				break;
			case 4:
				System.out.println("-------------------------------------------------------------");
				System.out.println("least proftable stock :");
				for(int i=0;i<arr.size();i++)
				{
					if(leastProfitableValue==arr.get(i).valueInDollars()-arr.get(i).costInDollars())
					{
						System.out.println(arr.get(i).getName());
						System.out.println(arr.get(i).costInDollars());
						System.out.println(arr.get(i).valueInDollars());
						break;
					}
				}
				break;
				
			case 5:
				System.out.println("-------------------------------------------------------------");
				System.out.println("displaying the stocks :");
				display(arr);
				break;
			case 7:
				System.exit(0);				
	    }
	}
}
}
class stock
{
private float purchaseSharePrice;
private float currentSharePrice;
private int numberOfShares;
private String companyName;

void setSharePrice(float puchasePrice,float sharePrice)
{
	purchaseSharePrice=puchasePrice;
	currentSharePrice=sharePrice;
}
void setShares(int shares)
{
	numberOfShares=shares;
}
void setName(String companyName)
{
	this.companyName=companyName;
}
String getName()
{
	return companyName;
}
float costInDollars()
{
	return purchaseSharePrice*numberOfShares;
	
}
float valueInDollars() {
	return currentSharePrice*numberOfShares;
}
}

class foreignStockHolding1 extends stock
{
private float conversionRate;

void setConversionRate(float rate)
{
	conversionRate=rate;
}
void setSharePrice(float puchasePrice,float sharePrice)
{
	super.setSharePrice(puchasePrice, sharePrice);
	setConversionRate(0.94f);
}
float costInDollors()
{
	return conversionRate*super.costInDollars();
}
float valueInDollors()
{
	return conversionRate*super.valueInDollars();
}
}
