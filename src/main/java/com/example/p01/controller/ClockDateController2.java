package com.example.p01.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.p01.dao.ClockDateDao;
import com.example.p01.dto.ClockOffDto;
import com.example.p01.dto.GetMissClockListDto;
import com.example.p01.dto.MissClockApplyDto;
import com.example.p01.service.ifs.ClockDateService;
import com.example.p01.vo.headVo.BasicRes;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClockDateController2 {

	@Autowired
	private ClockDateService clockDateService;

	@Autowired
	private ClockDateDao clockDateDao;

	// 下班打卡2
	@PostMapping(value = "/clock/off2")
	public BasicRes clickOff2(@RequestBody ClockOffDto dto) throws Exception {
		return clockDateService.clockOff2(dto);
	}

	// 補打卡申請
	@PostMapping(value = "/clock/missClockApply")
	public BasicRes missClockApply(@RequestBody List<MissClockApplyDto> req) throws Exception {
		return clockDateService.missClockApply(req);
	}

	// 補打卡核准
	@PostMapping(value = "/clock/missClockApprove")
	public BasicRes missClockApprove(//
			@RequestParam("id") int id, //
			@RequestParam("accept") boolean accept) {
		return clockDateService.missClockApprove(id, accept);
	}

	// 補打卡核准列表
	@GetMapping(value = "/clock/getMissClockList")
	public List<GetMissClockListDto> getMissClockList() {
		return clockDateService.getMissClockList();
	}

	// 取單筆補打卡申請資料
	@GetMapping(value = "/clock/getMissClockById")
	public MissClockApplyDto getMissClockById(@RequestParam("id") int id) {
		return clockDateService.getMissClock(id);
	}

	// 取得已審核過的資料 全部
	@GetMapping(value = "/clock/getProvedList")
	public List<GetMissClockListDto> getProvedList() {
		return clockDateService.getProvedList();
	};

	// 取得已審核過的資料 用月份區分
	@GetMapping(value = "/clock/getProvedListByMonth")
	public List<GetMissClockListDto> getProvedListByMonth(//
			@RequestParam("startDate") LocalDate startDate, //
			@RequestParam("endDate") LocalDate endDate) {
		return clockDateService.getProvedListByMonth(startDate, endDate);
	}
}
