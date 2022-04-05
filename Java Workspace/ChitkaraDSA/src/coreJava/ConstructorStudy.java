package coreJava;

class Student
{
	int rollNo;
	String name;
	Student()
	{
		//We're bound to create this if we have to use it and we've create a parameterized constructor.
	}
	Student(int rollNo, String name) //Parameterized Constructor used to initialize the object
	{
		this.rollNo = rollNo;
		this.name = name;
	}
}

public class ConstructorStudy {

	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println(s1.rollNo);
		System.out.println(s1.name);
		s1.rollNo = 1;
		s1.name = "Ram";
		System.out.println(s1.rollNo);
		System.out.println(s1.name);
		
		Student s2 = new Student(2,"Sham");
		System.out.println(s2.rollNo);
		System.out.println(s2.name);
	}

}
