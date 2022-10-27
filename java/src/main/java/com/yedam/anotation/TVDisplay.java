package com.yedam.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TVDisplay {
	@Autowired
	TV stv;
	
	public void run() {
		this.stv.on();
	}
  // 귀여워 그림체 비슷하다고 나 이제 갈래 허헛 돌멩이랑 ㅍ잘어울리 메메롱 메롱메롱~~ 나 누구우우우게?헤헤헤헤헿헤아이도루? 아이브로~ 제정신이 아닌데 그때 누우면 잘못 누우면 자 마자마잠자ㅏ 근데 열받는 거야 진짜 어제 유튜브 보다가 어제 밖에서 너무 추운거야 너무 춥다 이러고잇"엇는데 야양야야양야 
}
