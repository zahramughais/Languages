package com.zahra.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zahra.languages.models.Language;
import com.zahra.languages.repositories.LanguageRepository;


@Service
public class LanguageService {

	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
    // returns all the books
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Language createLanguage(Language la) {
        return languageRepository.save(la);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

	public void UpdateLanguage(Long id, String name, String creator, Double currentVersion) {
		Language language = findLanguage(id);
		if(language != null) {
			language.setName(name);
			language.setCreator(creator);
			language.setCurrentVersion(currentVersion);
			languageRepository.save(language);
		}
	}

	public void destroy(Long id) {
		if (findLanguage(id) != null){
			languageRepository.deleteById(id);
		}
	}
}
