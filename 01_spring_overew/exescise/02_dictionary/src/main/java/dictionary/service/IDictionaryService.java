package dictionary.service;

import dictionary.model.DictionaryLanguage;

import java.util.List;

public interface IDictionaryService {

    List<DictionaryLanguage> findAll();
}
