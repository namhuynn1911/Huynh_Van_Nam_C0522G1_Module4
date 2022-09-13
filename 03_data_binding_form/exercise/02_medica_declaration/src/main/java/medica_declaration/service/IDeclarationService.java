package medica_declaration.service;

import medica_declaration.model.Declaration;

import java.util.List;

public interface IDeclarationService {

    List<Declaration> findAll();

    void save(Declaration declaration);

}
