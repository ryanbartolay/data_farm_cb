package com.ryan.service.security;

import com.ryan.exception.InvalidLottoResultException;
import com.ryan.model.LottoResult;

public class LottoResultSecurityService {
	public static void isValidLottoResult(LottoResult result) throws InvalidLottoResultException {
		if(result == null) {
			throw new InvalidLottoResultException("Result is null");
		}
		
		if(result.getDraw_date() == null) {
			throw new InvalidLottoResultException("Draw Date is empty");
		}
		
		if(result.getDraw_type() == null) {
			throw new InvalidLottoResultException("Draw Type is empty");
		}
		
		if(result.getDraw_1() == 0) {
			throw new InvalidLottoResultException("Draw 1 is empty");
		}
		if(result.getDraw_2() == 0) {
			throw new InvalidLottoResultException("Draw 2 is empty");
		}
		
		if(result.getDraw_3() == 0) {
			throw new InvalidLottoResultException("Draw 3 is empty");
		}
		
		if(result.getDraw_4() == 0) {
			throw new InvalidLottoResultException("Draw 4 is empty");
		}
		
		if(result.getDraw_5() == 0) {
			throw new InvalidLottoResultException("Draw 5 is empty");
		}
		
		if(result.getDraw_6() == 0) {
			throw new InvalidLottoResultException("Draw 6 is empty");
		}
	}
}
