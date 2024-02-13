package com.galaxy.scvandvalidation.utils;

import static java.util.Objects.isNull;

public class UtilValidator {

    public static Boolean isContent(String val) {

        return (isNull(val) || val.trim().length()==0);
    }
}
