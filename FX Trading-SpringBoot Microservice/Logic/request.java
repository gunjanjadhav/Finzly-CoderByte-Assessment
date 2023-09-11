package com.FXTrading.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FXTrading.model.FXTradingEntity;
import com.FXTrading.services.FXTradingLogic;

@RestController
public class FXTradingRequests {

	@Autowired
	private FXTradingLogic fxTradingFormatImpl;

	@PostMapping(value = "/trade")
	public Object doTrading(@RequestBody FXTradingEntity fxTradingEntity) {
		
		if (fxTradingEntity == null) {
			return "Not Booked";
		}
		try {
			Object object = fxTradingFormatImpl.doTrade(fxTradingEntity);
			if (object instanceof Map) {
				((Map) object).put("Status", "Not Booked");
				return object;
			} else {
				return "Trade Booked";
			}

		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@GetMapping("/get-all-trades")
	public Object getAllTrades() {
		List<FXTradingEntity> tradeList = this.fxTradingFormatImpl.getTradeList();
		if (tradeList.isEmpty()) {
			return "Your trade List is Empty";
		} else {
			return tradeList;
		}
	}

}
