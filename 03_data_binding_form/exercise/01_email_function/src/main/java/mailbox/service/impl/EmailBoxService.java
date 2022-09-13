package mailbox.service.impl;

import mailbox.model.EmailBox;
import mailbox.service.IEmailBoxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailBoxService implements IEmailBoxService {

    private static List<EmailBox> emailBoxList = new ArrayList<>();
    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);

        emailBoxList.add(new EmailBox(1, "English", 25, true, "nam"));
        emailBoxList.add(new EmailBox(2, "Vietnamese", 5, false, "huỳnh"));
        emailBoxList.add(new EmailBox(3, "Japanese", 100, true, "văn"));
    }


    @Override
    public List<String> findLanguagesAll() {
        return languagesList;
    }

    @Override
    public List<Integer> findSizeAll() {
        return pageSizeList;
    }

    @Override
    public List<EmailBox> findAll() {
        return emailBoxList;
    }

    @Override
    public void save(EmailBox emailBox) {
        emailBoxList.add(emailBox);
    }

    @Override
    public EmailBox findById(Integer id) {
        for (EmailBox emailBox : emailBoxList) {
            if (emailBox.getId().equals(id)) {
                return emailBox;
            }
        }
        return null;
    }

    @Override
    public void update(EmailBox emailBox) {
        for (EmailBox email : emailBoxList) {
            if (email.getId().equals(emailBox.getId())) {
                emailBoxList.remove(email);
                emailBoxList.add(emailBox);
            }
        }
    }


}
