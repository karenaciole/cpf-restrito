package com.desafiobackend.cpfrestrito.utils.validation;

public class CpfValidation {
    public static boolean isCpfValid(String cpf) {

        if (cpf.length() != 11 || isCpfRepeated(cpf)) {
            return false;
        }

        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static boolean isCpfRepeated(String cpf) {
        String[] cpfArray = cpf.split("");
        String cpfDigit = cpfArray[0];

        for (int i = 1; i < cpfArray.length; i++) {
            if (!cpfDigit.equals(cpfArray[i])) {
                return false;
            }
        }

        return true;
    }

    public static String getOnlyDigitsFromCPF(String cpf) {
            return cpf.replaceAll("[^0-9]", "");
    }
}
