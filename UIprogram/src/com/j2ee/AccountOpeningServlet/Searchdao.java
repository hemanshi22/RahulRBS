package com.j2ee.AccountOpeningServlet;

import java.util.ArrayList;

public interface Searchdao {
	ArrayList<AccountSearch> getSearchDetails(int ACC_NO,int c1);
	ArrayList<AccountSearch> getSearchDetails(String ACC_TYPE);
	ArrayList<AccountSearch> getSearchDetails1(String start, String end);
}







