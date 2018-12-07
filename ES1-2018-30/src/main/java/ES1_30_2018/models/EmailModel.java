package ES1_30_2018.models;

import javax.mail.Address;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("restriction")
public class EmailModel {
	
	private StringProperty subject;
	private ObjectProperty<Address> address;
	private StringProperty string;
	
	public EmailModel(String subject, Address address, String string) {
		this.subject = new SimpleStringProperty(subject);
		this.address = new SimpleObjectProperty<Address>(address);
		this.string = new SimpleStringProperty(string);
	}
	
	//For subject
	public String getSubject() {
		return subject.get();
	}
	public void setSubject(String subject) {
		this.subject.set(subject);
	}
	public StringProperty subjectProperty() {
		return subject;
	}
	
	//For string (message of the email)
	public String getString() {
		return string.get();
	}
	public void setString(String string) {
		this.string.set(string);
	}
	public StringProperty stringProperty() {
		return string;
	}
	
	//For Address
	public Address getAddress() {
		return address.get();
	}
	public void setAddress(Address address) {
		this.address.set(address);
	}
	public ObjectProperty<Address> addressProperty(){
		return address;
	}
	
}
