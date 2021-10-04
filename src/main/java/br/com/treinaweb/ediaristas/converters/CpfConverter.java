package br.com.treinaweb.ediaristas.converters;

import javax.persistence.AttributeConverter;

public class CpfConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String cpf) {
        return cpf.replaceAll("[.-]", "");
    }

    @Override
    public String convertToEntityAttribute(String cpf) {
        return cpf;
    }

}
