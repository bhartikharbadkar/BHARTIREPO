package com.yebelo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yebelo.model.FetchNumber;
import com.yebelo.service.FetchNumberService;

@Controller
@RequestMapping("/yebelo")
public class FetchNumController {

	@Autowired
	private FetchNumberService fetchNumService;
	
	@RequestMapping(value="/FetchNextNumber",method=RequestMethod.GET)
	public @ResponseBody String getData(@RequestParam(value="categorycode") int categorycode){
		String result=null;
		FetchNumber newFetchNum=new FetchNumber();
		Optional<FetchNumber>  optional=fetchNumService.isPresent(categorycode);
		try {
			if(optional.isPresent()) {
				newFetchNum=optional.get();
				if(newFetchNum.getCategoryCode()!=0&&newFetchNum.getNumber()>categorycode) {		
					int a=newFetchNum.getCategoryCode();
					int b=newFetchNum.getNumber();
					
					String fetchNo=String.valueOf(a);
					String num=String.valueOf(b);
					
					char x=fetchNo.charAt(0);
					char y=fetchNo.charAt(1);
					
					int fetchfirstVal=Character.getNumericValue(x);
					int fetchSecVal=Character.getNumericValue(y);
					
					char p=num.charAt(0);
					char q=num.charAt(1);
					
					int numfirstVal=Character.getNumericValue(p);
					int numSecVal=Character.getNumericValue(q);
					
					int fetchResultNum=fetchfirstVal+fetchSecVal;
					int nextNumResult=numfirstVal+numSecVal;
					  
					FetchNumber resultFetchNum=new FetchNumber();
					resultFetchNum.setCategoryCode(fetchResultNum);
					resultFetchNum.setNumber(nextNumResult);
					
					fetchNumService.update(resultFetchNum);
					result="old CategoryCode :"+fetchNo+"\n old Number : "+num+"\n New CatgeoryCode :"+fetchResultNum+"\n New Number"+nextNumResult;
				}else {
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
