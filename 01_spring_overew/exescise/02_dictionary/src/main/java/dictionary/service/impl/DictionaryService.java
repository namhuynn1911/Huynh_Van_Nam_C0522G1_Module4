package dictionary.service.impl;

import dictionary.model.DictionaryLanguage;
import dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    private static Map<Integer, DictionaryLanguage> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(1, new DictionaryLanguage("hello", "xin chào"));
        dictionaryMap.put(2, new DictionaryLanguage("dog", "con chó"));
        dictionaryMap.put(3, new DictionaryLanguage("cat", "con mèo"));
        dictionaryMap.put(4, new DictionaryLanguage("Lion", "con hổ"));
        dictionaryMap.put(5, new DictionaryLanguage("mouse", "con chuột"));
        dictionaryMap.put(6, new DictionaryLanguage("chicken", "con gà"));


    }

    @Override
    public List<DictionaryLanguage> findAll() {

        return new ArrayList<>(dictionaryMap.values());
    }
}
