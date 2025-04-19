package org.example.mcpserversse.pojo;


import lombok.Data;

/**
 * {
 * 	"reason": "查询成功!",
 * 	"result": {
 * 		"city": "杭州",
 * 		"realtime": {
 * 			"temperature": "23",
 * 			"humidity": "41",
 * 			"info": "阴",
 * 			"wid": "02",
 * 			"direct": "西南风",
 * 			"power": "3级",
 * 			"aqi": "54"
 * 		 },
 * 		"future": [{
 * 			"date": "2025-04-17",
 * 			"temperature": "20\/29℃",
 * 			"weather": "多云转晴",
 * 			"wid": {
 * 				"day": "01",
 * 				"night": "00"
 *            },
 * 			"direct": "西南风"
 *        }, {
 * 			"date": "2025-04-18",
 * 			"temperature": "21\/33℃",
 * 			"weather": "晴转小雨",
 * 			"wid": {
 * 				"day": "00",
 * 				"night": "07"
 *            },
 * 			"direct": "东南风转东风"
 *        }, {
 * 			"date": "2025-04-19",
 * 			"temperature": "19\/27℃",
 * 			"weather": "小雨转多云",
 * 			"wid": {
 * 				"day": "07",
 * 				"night": "01"
 *            },
 * 			"direct": "北风转西南风"
 *        }, {
 * 			"date": "2025-04-20",
 * 			"temperature": "18\/28℃",
 * 			"weather": "晴转多云",
 * 			"wid": {
 * 				"day": "00",
 * 				"night": "01"
 *            },
 * 			"direct": "东风"
 *        }, {
 * 			"date": "2025-04-21",
 * 			"temperature": "20\/25℃",
 * 			"weather": "小雨",
 * 			"wid": {
 * 				"day": "07",
 * 				"night": "07"
 *            },
 * 			"direct": "西南风转西北风"
 *        }]
 *   },
 * 	"error_code": 0
 * }
 */
@Data
public class WeatherPojo {

    // replace lines 70 to 72
    private String reason;
    private Result result;
    private int errorCode;

    @Data
    public static class Result {
        private String city;
        private Realtime realtime;

        @Data
        public static class Realtime {
            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
        }
    }

}
