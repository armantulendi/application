package com.test.application.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
@Service
public class IINValidator {
    public boolean isValidIIN(String iin) {
        if (iin.isEmpty()) return false;
        String date = iin.substring(0, 6);
        String gender = iin.substring(6, 7);
        return iin.matches("\\d{12}")
                && isValidBirthday(date)
                && gender.matches("[1-6]")
                && isValidControl(iin);
    }
    private boolean isValidBirthday(String date) {
        if ( date.isEmpty() ||
                !date.matches("\\d{2}[01]\\d[0-3]\\d"))
            return false;

        SimpleDateFormat df = new SimpleDateFormat("yyMMdd", Locale.getDefault());
        df.setLenient(false);
        try {
            df.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    private boolean isValidControl(String iin) {
        //Проверяем контрольный разряд
        int[] b1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] b2 = {3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2};
        List<Integer> a = new LinkedList<>();
        int control = 0;
        for (int i = 0; i < 12; i++) {
            a.add(Integer.parseInt(iin.substring(i, i + 1)));
            if (i < 11) control += a.get(i) * b1[i];
        }
        control = control % 11;
        if (control == 10) {
            control = 0;
            for (int i = 0; i < 11; i++)
                control += a.get(i) * b2[i];
            control = control % 11;
        }
        return control == a.get(11);
    }

}
