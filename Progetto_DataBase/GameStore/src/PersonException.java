
import java.sql.*;
import java.util.*;


public class PersonException extends Exception 
{
	public PersonException(String Message) 
	{
			super(Message);
	}
	public String toString() 
	{
		return getMessage();
	}
}