package com.academia.academiaalunos.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

    public String formatarData(int dia, int mes, int ano) {

        String diaStr = dia < 10 ? "0" + dia : String.valueOf(dia);
        String mesStr = mes < 10 ? "0" + mes : String.valueOf(mes);
        
        return diaStr + "/" + mesStr + "/" + ano;
    }
}
