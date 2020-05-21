package com.lt.journey.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.journey.exception.MessageException;
import com.lt.journey.model.Train;
import com.lt.journey.model.TrainParam;
import com.lt.journey.service.TrainService;
import com.lt.journey.util.TrainInfo;

@Controller
@RequestMapping("/")
public class TrainController {

	@Autowired
	private TrainService trainService;

	@RequestMapping("/train")
	public String trainView() {
		return "train";
	}

	@RequestMapping("/train/search")
	public String searchTrain(Model model, TrainParam trainParam) throws UnsupportedEncodingException, ParseException, MessageException {

//		trainParam.setDepartureCityName(new String(trainParam.getDepartureCityName().getBytes("ISO-8859-1"), "utf-8"));
//		trainParam.setArrivalCityName(new String(trainParam.getArrivalCityName().getBytes("ISO-8859-1"), "utf-8"));

		if (trainParam.getLimit() == 0) {
			String departureCityCode = trainService.findCityCode(trainParam.getDepartureCityName());
			String arrivalCityCode = trainService.findCityCode(trainParam.getArrivalCityName());
			trainParam.setDepartureCityCode(departureCityCode);
			trainParam.setArrivalCityCode(arrivalCityCode);
		}
		// 起始值
		Integer page = trainParam.getPage();
		trainParam.setStart((page-1) * trainParam.getLimit());
		// 得到火车余票信息
		List<Train> trainList = TrainInfo.getTrainInfo(trainParam, model);

		if (trainList == null) return "msg";

		return "train";
	}
	
}
