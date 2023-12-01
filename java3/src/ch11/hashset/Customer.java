package ch11.hashset;

import java.util.HashSet;
import java.util.Objects;

public class Customer {
	String id;
	String name;
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	public Customer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	 
	public static void main(String[] args) {
		
		 Customer c = new Customer("dy" ,"곽단야");;
		 Customer c2 = new Customer("dy" ,"곽단야");
		 
		 
		 HashSet set = new HashSet() ; 
		
		 set.add(c);
		 set.add(c2);
		 
		 System.out.println( set);
		 
			 
		 
		 
		 
	}

}
