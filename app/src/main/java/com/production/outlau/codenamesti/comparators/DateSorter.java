package com.production.outlau.codenamesti.comparators;

import com.production.outlau.codenamesti.models.TimeCard;

import java.util.Comparator;

import static java.lang.Long.signum;

public class DateSorter implements Comparator<TimeCard> {
    public int compare(TimeCard timeCard1, TimeCard timeCard2) {
        return signum(timeCard2.getDate().compareTo(timeCard1.getDate()));
    }
}

