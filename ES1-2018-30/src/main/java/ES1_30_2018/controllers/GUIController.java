package ES1_30_2018.controllers;

import javax.swing.text.html.ImageView;

import ES1_30_2018.models.EmailModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainApp.Email;

@SuppressWarnings("restriction")
public class GUIController {
    @FXML
    private ImageView imgFundo;

    @FXML
    private ImageView imgLogo;

    @FXML
    private Tab tabEmail;

    @FXML
    private Tab tabEmailCaixaEntrada;

    @FXML
    private TableView<EmailModel> emailSubjectsTable;

    @FXML
    private TableColumn<EmailModel, String> emailSubjectsColumn;

    @FXML
    private TextArea emailReadTextArea;

    @FXML
    private Tab tabEscreverEmail;

    @FXML
    private TextField emailSendToTextField;

    @FXML
    private TextField emailSubjectTextField;

    @FXML
    private TextArea emailMessageTextArea;

    @FXML
    private Button emailSendButtun;

    @FXML
    private Tab tabFacebook;

    @FXML
    private Tab tabMoralFacebook;

    @FXML
    private ListView<?> facebookListView;

    @FXML
    private TextArea facebookReadTextArea;

    @FXML
    private Tab tabFazerPublicacao;

    @FXML
    private TextArea facebookPublishTextArea;

    @FXML
    private Button facebookPublishButton;

    @FXML
    private Tab tabTwitter;

    @FXML
    private Tab tabMoralTwitter;

    @FXML
    private ListView<?> twitterListView;

    @FXML
    private TextArea twitterReadTextArea;

    @FXML
    private Tab tabFazerTweet;

    @FXML
    private TextArea twitterPublishTextArea;

    @FXML
    private Button twitterPublishButton;

	private Email email;

    @FXML
    void onMouseClickShowPublication(MouseEvent event) {

    }

    @FXML
    void onMouseClickShowTweet(MouseEvent event) {

    }

    @FXML
    void onPublishFacebookPostClick(ActionEvent event) {

    }

    @FXML
    void onPublishTweetClick(ActionEvent event) {

    }

    @FXML
    void onSendEmailClick(ActionEvent event) {

    }

    public void setEmailApp(Email email) {
    	this.email = email;
    	//adiciona os dados da observable list na tabela
    	emailSubjectsTable.setItems(email.getEmailData());
    }

}
