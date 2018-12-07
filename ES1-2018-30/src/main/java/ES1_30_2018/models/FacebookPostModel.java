package ES1_30_2018.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@SuppressWarnings("restriction")
public class FacebookPostModel {

	private StringProperty id;
	private StringProperty msg;

	public FacebookPostModel(String id, String msg) {
		this.id = new SimpleStringProperty(id);
		this.msg = new SimpleStringProperty(msg);
	}

	// For id
	public String getID() {
		return id.get();
	}

	public void setID(String id) {
		this.id.set(id);
	}

	public StringProperty idProperty() {
		return id;
	}
	
	// For msg
		public String getMsg() {
			return msg.get();
		}

		public void setMsg(String msg) {
			this.msg.set(msg);
		}

		public StringProperty msgProperty() {
			return msg;
		}
}
