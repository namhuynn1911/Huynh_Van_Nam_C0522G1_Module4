package mailbox.service;

import mailbox.model.EmailBox;

import java.util.List;

public interface IEmailBoxService {
    List<String> findLanguagesAll();

    List<Integer> findSizeAll();

    List<EmailBox> findAll();

    void save(EmailBox emailBox);

    EmailBox findById(Integer id);

    void update(EmailBox emailBox);
}
