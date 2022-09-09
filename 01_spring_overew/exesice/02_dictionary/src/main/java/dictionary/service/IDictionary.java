package dictionary.service;

import dictionary.model.DictionaryLanguage;

import java.util.List;

public interface IDictionary {
    List<DictionaryLanguage> findAll();
}
