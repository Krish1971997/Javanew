package java8;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.List;
 public class UsingComparable implements Comparator<UsingComparable>{
		
		int empId;
		String name;
		int salary;
		
		public UsingComparable(int empId, String name, int salary) {
			super();
			this.empId = empId;
			this.name = name;
			this.salary = salary;
		}

		/*
		 * public int compare(SortEmployees o1, SortEmployees o2) {
		 	return o1.name.compareTo(o2.name);} */
			
		public String toString() {
			return "SortEmployees [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
		}
		
		//static Comparator<SortEmployees> com=(o1, o2) ->o2.name.compareTo(o1.name) ;
	
		public int compareTo(SortEmployees o1) {
			return this.name.compareTo(o1.name);
		}
		
		public static void main(String[] args) {
		
			List<SortEmployees> list=new ArrayList();
			list.add(new SortEmployees(1,"Krishna",25000));
			list.add(new SortEmployees(2,"Kumar",5000));
			list.add(new SortEmployees(3,"James",2000));
			list.add(new SortEmployees(4,"Kamalesh",200000));
			list.add(new SortEmployees(5,"Ajith",22000));
			list.add(new SortEmployees(6,"ram",500));
			
			//Collections.sort(list, Collections.reverseOrder());
//			Collections.sort((List<SortEmployees>) list);
			for (SortEmployees sortEmployees : list) {
				System.out.println(sortEmployees);
			}
		}

		public int compare(SortEmployees o1, SortEmployees o2) {
			return o1.name.compareTo(o2.name);
		}

		@Override
		public int compare(UsingComparable o1, UsingComparable o2) {
			// TODO Auto-generated method stub
			return 0;
		}


	}

